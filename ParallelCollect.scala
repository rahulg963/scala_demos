object ParallelCollect{
	def main(args : Array[String]){	
		def fib(n :Int) : Int = {
			if(n < 2)
				1
			else
				fib(n-1) + fib(n-2)
		}

		// for(i <- (1 to 20 by +1 )){
		// 	print(fib(i) + "\n")
		// }

		//par allows multithreading
		// for(i <- (1 to 20 by +1).par ){
		// 	print(fib(i) + "\n")
		// }


		// Limitation of parallel programming
		// var i = 0
		// for(j <- (1 to 1000000).par) {
		// 	//load i from memory
		// 	//add 1 to register
		// 	//store i to memory
		// 	i += 1
		// }
		// println(i)
		
		//Here Synchronized is used
		var i = 0
		for(j <- (1 to 1000000).par) {
			//load i from memory
			//add 1 to register
			//store i to memory
			synchronized{i += 1}
		}
		println(i)
	}
}