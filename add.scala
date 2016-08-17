object add{
	def main(args : Array[String])
	{
		println("Sum is : " + addInt(2, 3))

		def addInt( a:Int, b:Int ) : Int = {
			var sum:Int = 0
			sum = a + b
			sum
			//return sum
		}
	}
}
