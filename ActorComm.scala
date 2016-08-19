import akka.actor._
import scala.concurrent.ExecutionContext.Implicits.global

object ActorComm{
	case class StartCounting(n:Int, other:ActorRef)
	case class CountDown(n:Int)

	class CountDownActor extends Actor{
		def receive = {
			case StartCounting(n, other) => println(n)
			
			other ! CountDown(n-1)
			
			case CountDown(n) =>
				//Refrence to Actor Ref
				println(self)
				//Refrence to Actual Actor
				//println(this)
				if(n > 0){
					println(n)
					sender ! CountDown(n-1)
				} else {
					context.system.shutdown()
				}
		}
	
		def foo = println("Normal method")
	}

	def main(args : Array[String]){ 
		
		val system = ActorSystem("SimpleSytem")
		val actor1 = system.actorOf(Props[CountDownActor], "CountDown1")
		val actor2 = system.actorOf(Props[CountDownActor], "CountDown2")
		actor1 ! StartCounting(10, actor2)
	
	}

}