class Point(xc : Int, yc : Int){
	var x : Int = xc
	var y : Int = yc

	println("Point x Before : " + x);
	println("Point y Before : " + y);


	def move(dx : Int, dy : Int){
		x = x + dx
		y = y + dy	
		println("Point x Location : " + x);
		println("Point y Location : " + y);

	}
}

object ClassExample{
	def main(args : Array[String]){
		val pt = new Point(10, 20);
		pt.move(10, 20); 
		// Not Allowed
		// println(pt.xc);
		// println(pt.yc);
	}
}