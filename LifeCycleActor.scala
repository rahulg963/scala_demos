import akka.actor._
import akka.actor.SupervisorStrategy._

object LifeCycleActor extends App{
	case object CreateChild
	case class SignalChildren(order : Int)
	case class PrintSignal(order : Int)
	case class DivideNumbers(n:Int, d:Int)
	case object BadStuff

	class ParentActor extends Actor{
		private var number = 0
		private val children = collection.mutable.Buffer[ActorRef]()
		def receive = {
			case CreateChild =>
				children += context.actorOf(Props[ChildActor],"child" + number)
				//context.actorOf(Props[ChildActor],"child" + number)
				
				number += 1
		
			case SignalChildren(n) =>
				children.foreach(_ ! PrintSignal(n))
				//context.foreach(_ ! PrintSignal)
		}
		
		override val supervisorStrategy = OneForOneStrategy(loggingEnabled = false){
		case ae : ArithmeticException => Resume
		case _: Exception => Restart
		}
	
	}

	class ChildActor extends Actor{
		println("Child Actor Created")
		def receive = {
			case PrintSignal(n) => println(n + " " + self) 
			case DivideNumbers(n,d) => println(n/d)
			case BadStuff => throw new RuntimeException("Stuff Happened")
		}

		override def preStart() = {
			super.preStart()
			println("Child PreStart")
		}

		override def postStop() = {
			super.postStop()
			println("Child PostStart")
		}

		override def preRestart(reason:Throwable, message : Option[Any]) = {
			super.preRestart(reason, message)
			println("preRestart")
		}  

		override def postRestart(reason:Throwable) = {
			super.postRestart(reason)
			println("preRestart")
		}
	}
	
	val system = ActorSystem("HierarchySystem")
	val actor = system.actorOf(Props[ParentActor],"Parent1")
	//val actor2 = system.actorOf(Props[ParentActor],"Parent2")
	// ! bang
	actor ! CreateChild
	//actor ! CreateChild
	val child0 = system.actorSelection("/user/Parent1/child0")
	child0 ! DivideNumbers(4,2)
	child0 ! DivideNumbers(3,0)
	//child0 ! DivideNumbers(6,3)
	child0 ! BadStuff
	
	Thread.sleep(1000)
	system.shutdown()
}