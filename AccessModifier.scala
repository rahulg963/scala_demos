//Protected
// package p {
// 	class Super {
// 		protected def f() { println("f") }
// 	}
	
// 	class Sub extends Super {
// 		f() //Ok : Sub class is the child class of Super class
// 	}
	
// 	class Other {
// 		(new Super).f() // Error: f is not accessible
// 	}
// }


// Private
// class Outer {
// 	class Inner {
// 		private def f() { println("f") }
// 		class InnerMost {
// 			f() // OK
// 		}
// 	}
	
// 	//(new Inner).f() // Error: f is not accessible
// }
object AccessModifier{
	def main(args : Array[String])
	{
		println("Access-Modifier")
	}
}