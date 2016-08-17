object DefaultParam {
	def main(args: Array[String]) {
		println( "Returned Value : " + addInt() );
	}
	def addInt( a:Int=5, b:Int=9 ) : Int = {
		var sum:Int = 0
		sum = a + b
	return sum
	}
}