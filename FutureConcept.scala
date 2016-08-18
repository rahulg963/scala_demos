import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Success
import scala.util.Failure

object FutureConcept{
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
		
		val f2 = Future{
			// def fib(n :Int) : Int = {
			// 	if(n < 2)
			// 		1
			// 	else
			// 		fib(n-1) + fib(n-2)
			// }
			for(i <- 1 to 30) yield fib(i)
			//throw new RuntimeException("Bad")
		}

		f2.onComplete{
			case Success(n) => println(n)
			case Failure(ex) => println("Something Went Wrong" + ex)
		}
		//Thread.sleep(5000)
		println("This is Last")					
		
	}
}