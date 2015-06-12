/*
*Scala for impatient
* chapter 2 exercises
*
* Created by randywang on 6/12/15.
 */

object ch2 extends App {

  val blah="***********"

  /*ex1

   */
  def signum(x: Int): Int = {
    if (x >0) 1
    else if (x<0) -1
    else 0
  }

  signum(8)
  signum(0)
  signum(-98)

  /*ex2

   */
  val s = {}


  /*ex3

   */
  var x : Unit= {}
  var y = 0
  x=y=1


  /*ex4

   */
  blah + "ex4"
  var counter: Int =10
  while(counter>=0){
    println(counter)
    counter -=1
  }
  for( i <- 10 to 1 by -1){
    println(i)
  }


  //ex5
  /*ex

   */
  def countdown(n : Int): Unit ={
    for(i <- n to 0 by -1){
      println(i)
    }
  }
  countdown(10)

  /*ex6

   */
  def calProduct(s : String) = {
    var prod: Long =1
    for (ch <- s){
      prod *= ch
    }
    prod
  }
  val s1 = "Hello"
  calProduct(s1)


  /*ex9

   */
  def recurCalProduct (args: String) : Long = {
    if (args.length>1){
      args.head.toLong * recurCalProduct(args.tail)
    } else 1L
  }
  recurCalProduct(s1)

  /*ex10

   */
  def pow(x: Int, n: Int) : Double ={
    if (n == 0) 1
    else if (n < 0)  1/pow(x, -n)
    else if ((n >0) && (n % 2) ==0) pow(x, n/2) * pow(x, n/2)
    else x * pow(x, n-1)
  }

  pow(5,-3)

}
