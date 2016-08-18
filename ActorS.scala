import akka.actor._
object ActorS{
	class SimpleActor extends Actor{
		def receive = {
			case s : String => println("String : " + s)
			case i : Int => println("Number : " + i)
		}
	
		def foo = println("Normal method")
	}

	def main(args : Array[String]){ 
		val system = ActorSystem("SimpleSytem")
		val actor = system.actorOf(Props[SimpleActor], "SimpleActor")
		
		println("Before messages")
		
		actor ! "Hi there."
		println("After String")
		
		actor ! 42
		println("After int")

		actor ! 'a'
		println("After char")
	}
}