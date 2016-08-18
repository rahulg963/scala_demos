object HighOrderFunc{

	def main(args: Array[String]) {
		println( apply( layout, 10) )
	}

	def apply(f: Int => String, v: Int) : String = {
		f(v)
	}
	
	def layout[A](x: A) = "[" + x.toString() + "]"

}