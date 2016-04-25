// classes & case-classes
abstract class Car(w: Int) {
  def wheels = w
  def Honk(count: Int = 1) = s"Tr${"ö"*count}t"
  def ABS() = true
  def ESP: Boolean
}
trait germanCar {
  def technology() = "Modern Cheaters"
  def cost: Double
}
trait punyCar {
  def rollingCoal(s: String) = s"Deny climate change! $s!!"
  def ESP = false
}
case class Ford(w: Int, CO2: String = "never enough") extends Car(w) with punyCar {
  def USofA() = "Yehaw"
  override val ABS = false
}
case class VW(w: Int, CO2: String = "too much") extends Car(w) with germanCar {
  override def Honk(cnt: Int) = s"Tut${if(cnt>1)"-tut"*(cnt-1)}"
  override val ESP = true
  def cost = 100000000.0
}
case class Honda(w: Int, CO2: String = "ok") extends Car(w) with punyCar {
  override def Honk(fub: Int) = "Mööp" // broken by design
  override val ABS = true
}

/*
  TODO: AUGFGABEN
 */

/* Aufgabe 1
 a) create a tuple that contains an Int, Double, String
 b) match tpl and print c if a > 1
 c) match tpl and print b times c if a < 10 and b > 1
*/

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
