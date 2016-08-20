import akka.actor._
object HierarchyExample extends App{
	case object CreateChild
	case class SignalChildren(order : Int)
	case class PrintSignal(order : Int)


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
	}

	class ChildActor extends Actor{
		def receive = {
			case PrintSignal(n) => println(n + " " + self) 
		}
	}

	val system = ActorSystem("HierarchySystem")
	val actor = system.actorOf(Props[ParentActor],"Parent1")
	val actor2 = system.actorOf(Props[ParentActor],"Parent2")
// ! bang
	actor ! CreateChild
	actor ! SignalChildren(1)
	actor ! CreateChild
	actor ! CreateChild
	actor ! SignalChildren(2)

	actor2 ! CreateChild
	val child0 = system.actorSelection("akka://HierarchySystem/user/Parent2/child0")
	child0 ! PrintSignal(3) 

	Thread.sleep(1000)
	system.shutdown()
}