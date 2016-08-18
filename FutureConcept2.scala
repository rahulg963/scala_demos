import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Success
import scala.util.Failure
import scala.collection.mutable.ListBuffer
import scala.concurrent.Await
import scala.concurrent.duration._
object FutureConcept2{
	def main(args : Array[String]){
		def fib(n :Int) : Int = {
			if(n < 2)
				1
			else
				fib(n-1) + fib(n-2)
		}
		println("This is First")	

		val f = Future{

			println("Printing in the Future")
		}
		//Thread.sleep(1) 
		
		val fib_vals = ListBuffer[Int]()

		val f2 = Future{
			// def fib(n :Int) : Int = {
			// 	if(n < 2)
			// 		1
			// 	else
			// 		fib(n-1) + fib(n-2)
			// }
//		fib_vals.append(for(i <- 1 to 30) yield fib(i))

		for(i <- 1 to 30) fib_vals.append(fib(i))

			//throw new RuntimeException("Bad")
			fib_vals
		}
		// This Blocks the main Thread
		println(Await.result(f2, 5.seconds))
		// f2.onComplete{
		// 	case Success(n) => println(n)
		// 	case Failure(ex) => println("Something Went Wrong" + ex)
		// }
		
		// Whatever future is first completed.
		// val fut = List(f1,f2);
		// val FirstFuture = Future.firstCompletedOf(fut);

		// Gor Every Future Return
		// val allFutures = Future.sequence(pages)
		// allFutures.foreach(println)

		Thread.sleep(2000)
		println("This is Last")					
		
	}
}