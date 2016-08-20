import akka.actor._
import akka.pattern._
import akka.util.Timeout
import scala.concurrent.duration._
//import scala.concurrent.ExecutionContext.Implicit.global
import scala.util._
import scala.concurrent.Future
object AskPattern3 extends App{
	case object AskName
	case class NameResponse(name : String)
	case class AskNameOf(other : ActorRef)

	class AskActor(val name : String) extends Actor{
		implicit val ec = context.system.dispatcher
		def receive = {
			case AskName => 
				sender ! NameResponse(name)
			case AskNameOf(other) => 
				val f = other ? AskName
				f.onComplete{
					case Success(NameResponse(n)) =>
						println("They Said Their Name was" + n)
					case Success(s) =>
						println("They didnt tell their name")
					case Failure(ex) =>
						println("Asking their Name Failed")
				}
				val currentSender = sender
				Future{
					currentSender ! "Message"
				}
		}
	}

	val system  = ActorSystem("SimpleSystemm")
	val actor1 = system.actorOf(Props(new AskActor("Pat")), "AskActor1")
	val actor2 = system.actorOf(Props(new AskActor("Val")), "AskActor2")
	implicit val ec = system.dispatcher
	implicit val timeout = Timeout(1.seconds)
	val answer = actor1 ? AskName
	answer.foreach( n => println("Name is " + n))
	actor1 ! AskNameOf(actor2)
	system.shutdown()
}