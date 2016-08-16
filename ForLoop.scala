object ForLoop {
	def main(args: Array[String]) {
		var a = 0;
		val numList = List(1,2,3,4,5,6);
		// // for loop execution with a range
		// for( a <- 1 to 10){
		// 	println( "Value of To a: " + a );
		// }

		// // for loop execution with unti
		// for( a <- 1 until 10){
		// 	println( "Value of Until a: " + a );
		// }

		for( a <- numList )
		{
			println( "Value of List a: " + a );
		}

	}
}