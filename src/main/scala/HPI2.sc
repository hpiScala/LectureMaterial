// classes & case-classes
object Car {
  def apply(): Car = new Car(4) {
      val ESP = true
  }
  def apply(w: Int) = new Ford(w)
  def apply(s: String) = s
}
abstract class Car(w: Int) {
  def wheels = w
  def Honk(count: Int = 1) = s"Tr${"ö"*count}t"
  def ABS() = true
  def ESP: Boolean
  println("foo")
}
trait germanCar {
  def technology() = "Modern Cheaters"
  def cost: Double
}
trait punyCar {
  def rollingCoal(s: String) = s"Deny climate change! $s!!"
  def ESP = false
}
case class Ford(w: Int, var CO2: String = "never enough") extends Car(w) with punyCar with germanCar {
  def USofA() = "Yehaw"
  def cost = 4.0
  override val ABS = false
}
case class VW(w: Int, var CO2: String = "too much") extends Car(w) with germanCar {
  override def Honk(cnt: Int) = s"Tut${if(cnt>1)"-tut"*(cnt-1)}"
  override val ESP = true
  def cost = 100000000.0
}
case class Honda(w: Int, var CO2: String = "ok") extends Car(w) with punyCar {
  override def Honk(fub: Int) = "Mööp" // broken by design
  override val ABS = true
}
val f: Car = Ford(4)
/*
  TODO: AUGFGABEN
 */

f match {
  case x @ Ford(w, a @ "never enough") => {
    println("foo")
    println(x.rollingCoal(""))
  }
  case Honda(w, _) if w < 10 => {
    println("foo")
    println(w)
  }
  case b: germanCar => println("german")
  case a => println("hey")

}
/* Aufgabe 1
 a) create a tuple that contains an a:Int, b:Double, c:String
 b) match tpl and print c if a > 1
 c) match tpl and print a times c if a < 10 and b > 1
 d) default case print "default"
*/
val tpl = (1, 10.0, "boo")
def m(tpl: (Int, Double, String)) = tpl match {
  case (a,b,c) if a<10 && b>1 => println(c*a)
  case (a, b, c) if a>1 => println(c)
  case _ => println("default case")
}
m(tpl)

/*
 Aufgabe 2
 - create a function that for a given Car
 a) rolls coal for 64 wheeled Fords
 b) calls USofA for a Ford with 8 or more wheels
 c) is unreachable because a Ford never has "too much" CO2
 d) rolls coal with the CO2 amount when it is "too little"
 e) rolls coal with USofA for other Ford
 f) says something about VWs
 g) something else for Honda but lets it honk as well
 h) discards other cars as "no real cars"
*/
/*
 Aufgabe 3
 a) create a implicit def that converts any car into a VW
 b) create a implicit class that hides a VW in Ford (USA! USA! USA!)
*/
def forVWOnly(v: VW) = v.technology()
// a) forVWOnly(Ford(2))
// b) VW(3).USofA()
var cars = List(VW(1), Ford(64), Honda(2))
var list1 = List.empty
var list1a = list1 :+ 1
val list2: List[Int] = List.empty
val list3 = list1 ++ list2
val list4 = 1 +: list2
val list = 1 to 10
list.foreach(println)
list.foreach(x => {
  println(x)
  println("foo")
})
val l = list.map(x => s"---$x---")
def IntToString(x: Int) = s"$x--"
list.map(IntToString)
list.map(_*2)
list.filter(_>5)
list.fold(10)((x, y) => x+y)
list.foldLeft("")((x,y) => s"$x-$y")
/*
 Aufgabe 4
 a) Create a list of tuples where the first element is a number,
     the second the string representing that number and
     the third a string that repeats the 2nd argument 1st argument times
     for the numbers 10 - 25
*/
/*
 Aufgabe
 a) create a List of (Int, String) Tuples where the 2nd arg is the string
    representation of the number for all natural numbers until 1001
 b) create a List containing only Tuples with even numbers and string of length >3
 c) create a List of string where all strings are representing numbers that are dividable by 100
 d) create a (Int, Strong) Tuple which sums(/concatenates) all Tuples from a)
    which have an even number and then are multiplied by 10 (also adjust the string!)
 */
