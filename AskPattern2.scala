import akka.actor._
import scala.concurrent.ExecutionContext.Implicits.global
import akka.pattern._
//import akka.util.Timeout
import scala.concurrent.duration
import scala.concurrent.ExecutionContext.Implicits.global
object AskPattern{

	case object AskName
	case class NameResponse(name : String)
	class AskActor(val name : String ) extends Actor{
		def receive = {
			case AskName => sender ! NameResponse(name)
		}
	}

	def main(args : Array[String]){ 
		
		val system = ActorSystem("SimpleSytem")
		//val actor = system.actorOf(Props[AskActor], "AskActor")
		val actor = system.actorOf(Props(new AskActor("Pat")), "AskActor")
		
		//implicit val timeout = Timeout(1.seconds)
		// ? return Future
		val answer = actor ? AskName
		answer.foreach( n => println("Name is : " + n))

		Thread.sleep(10000)
		system.shutdown()
	}
}