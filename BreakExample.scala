import scala.util.control._
object BreakExample {
	def main(args: Array[String]) {
		var a = 0;
		val numList = List(1,2,3,4,5,6,7,8,9,10);
		val loop = new Breaks;
		loop.breakable {
			for( a <- numList){
				println( "Value of a: " + a );
				if( a == 4 ){
					loop.break;
				}
			}
			//This is not Prited as control will come out of loop.breakable
			println(" Break Block ");
		}

		println( "After the loop" );
	}
}