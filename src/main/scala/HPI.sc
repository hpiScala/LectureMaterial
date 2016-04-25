// Intro val, var, def ; type inference basics

// val + type inference
val message = "Hello world!"
// reassign to val
//message = "Does not work."

// val + explicit type
val message2: String = "Hello world!"
// val + explicit type + type safety
//val message2a: Int = "Hello world!"
// val + explicit type + type safety + runtime exception
//val message2b: Int = "Hello world!".toInt

// var
var message3 = "Hello world!"
// var reassignment
message3 = "new value"

// def + type inference + last statement as return value
def message4() = "Hello World!"
// def reasignment
//message4 = "new value"

//using defs + type inference
val a = message4()
val b = message4

// def + parameter
def square(x: Int) = x*x
square(4)
//def + default paramter
def pow(exponent: Int, base: Int = 2) = math.pow(base, exponent)
// call with default
pow(2)
// normal positional args
pow(10, 2)
// call by named args
pow(base=10, exponent=2)
// mixed: first positional, then named args
pow(2, base=10)

// default paramters first
def pow2(base: Int=2, exponent: Int): Int = math.pow(base, exponent).toInt
// call positional args
//pow(2)
pow2(2, 10)
// call by name
pow2(exponent=10)

// Übung: Schreibe eine "Simon says" Methode
def simonSaysDummy(x: String)  = "Simon says " + x
// Simon Says => Generics
def simonSays[T](x: T) = ??? //"Simon says " + x
//simonSays(1)
//simonSays("foo")

// HUGE BONUS: WTF?
def simonSaysStrange[String](x: String)  = "Simon says " + x
simonSaysStrange(1)
// HINT: why this error?
//def simonSaysStrange2[String](x: String): String  = "Simon says " + x

// was ist der return type?
def calc( f: Int => Int, x: Int ) = (y: Int) => f(x) + y

// bonus: partially applied functions
val myOp = pow2(2, _: Int)
calc(myOp, 10)(2)


// pass-by-name/lazy evaluation
val logLevel = 1
def warnStupid( s: String) = if(logLevel>=2) println(s)
def warn( s: => String) = if(logLevel>=2) println(s)

def createString() = {
  println("FAIL")
  "log message"
}

println("warnStupid")
warnStupid("log message")
warnStupid(createString())

println("warn")
warn("log message")
warn(createString())


// lazy val -> memory overhead + eval cost on acces
// BUG: worksheets suck, use REPL
println("lazy foo")
lazy val foo = {
  println("bar")
  "foo"
}
println("access foo")
println(foo)

//Übung DoubleFunction -> Identity
def inc(a: Int) = a + 1
def dec(a: Int) = a - 1

//Übung -> (manual) Currying
def doubleFunction(f: Int => Int, g: Int => Int): Int => Int = {
  def blub(x:Int): Int = f(g(x))
  blub
}
// bonus solution
def doubleFunction2(f: Int => Int, g: Int => Int):(Int) => Int = {
  (a: Int) => f(g(a))
}
// bonus: partially applied
def doubleFuncDec = doubleFunction2(_: Int => Int, dec)

// tests
def identity = ??? // doubleFunction(inc, dec)
def plusTWO = ??? // doubleFunction(inc, inc)

//plusTWO(3)
//identity(45)
//identity(24) == plusTWO(22)


// if-then-else is a function not a statement
val x = 3
val a2 = if(x % 2 == 0) "YAY" else "epic fail"
val b2 = if(x % 2 == 0) "YAY" else if(x % 3 == 0) "STOOORY" else "epic fail"

// Tuples are typesafe
val tpl = (1, 2.0, "foo")
// type!
tpl._1 + tpl._2
// works due to implicits (object) -> return type
tpl._1 + tpl._2 + tpl._3
// does not work (* not defined on double! for string arg)
//tpl._1 * tpl._2 * tpl._3
// works because * is defined on string for int arg (= repeat string)
tpl._3 * tpl._1


