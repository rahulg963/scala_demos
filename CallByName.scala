object CallByName{	
	
	def main(args: Array[String]) {
		delayed(something(), time())
	}

	def something() = {
		println("SOmething Something")
	}

	def time() = {
		println("Getting time in nano seconds")
		System.nanoTime
	}

	def delayed(s: => Unit , t: => Long ) = {
		
		println("In delayed method")

	//	println("Param: " + t)

	s
	}
}