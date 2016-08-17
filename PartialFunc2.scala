import java.util.Date
object PartialFunc2 {
	def main(args: Array[String]) {
		val date = new Date
		// val logWithDateBound = log(date, _ : String)
		
		// logWithDateBound("message1" )
		// Thread.sleep(1000)
		
		// logWithDateBound("message2" )
		// Thread.sleep(1000)
		
		// logWithDateBound("message3" )
		// Thread.sleep(1000)

		var logT = log(date, "Hello", _ : Int)
		logT(5)
	}
	def log(date: Date, message: String, variable :Int) = {
		println(date + "----" + message + variable)
	}
}