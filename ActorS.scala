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
		val actor1 = system.actorOf(Props[SimpleActor], "Rahul")
		val actor2 = system.actorOf(Props[SimpleActor], "Archit")
		
		println("Before messages")
		
		actor1.!("Hi there.")
		println("After String")
		
		actor2 ! 42
		println("After int")

		actor1 ! "a"
		println("After char")
		
		
		//Deprocated
		system.shutdown()

		//system.terminate()
	}
}