import akka.actor._
import scala.concurrent.duration._
object Scheduler extends App{
	case object Count
	class ScheduleActor extends Actor{
		var n =0
		def receive = {
			case Count =>
				n += 1
				println(n)
		}
	}

	val system = ActorSystem("SimpleActor")
	val actor = system.actorOf(Props[ScheduleActor],"SchedulerActor")
	implicit val ec = system.dispatcher

	actor ! Count
	system.scheduler.scheduleOnce(1.second)(actor ! Count)
	val can = system.scheduler.schedule(0.second, 100.millis, actor,Count)
	
	Thread.sleep(3000)
	//Cancell can before termination of it
	can.cancel
	system.shutdown()

}
