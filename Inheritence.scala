class Point(val xc : Int, val yc : Int){
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

class Location(override val xc : Int, override val yc : Int, val zc : Int ) extends Point(xc, yc){
	// x = x from parent class
	// y = y from parent class
	var z: Int = zc;
	def move(dx : Int, dy : Int, dz : Int){
		x = x + dx
		y = y + dy
		z = z + dz	
		println("Point x Location After : " + x);
		println("Point y Location After : " + y);
		println("Point z Location After: " + z);
	}

}

object Inheritence{
	def main(args : Array[String]){
		// val pt = new Point(10, 20);
		// pt.move(10, 20); 
		// Not Allowed
		// println(pt.xc);
		// println(pt.yc);

		val loc = new Location(10, 20, 30);
		loc.move(40, 50, 60);
	}
}