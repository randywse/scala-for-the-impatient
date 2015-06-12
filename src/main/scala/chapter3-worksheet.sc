import scala.collection.mutable.ArrayBuffer

/*
*Scala for impatient
* chapter 3 exercises
 */

/*ex1
Write a code snippet that sets a to an array of n random integers between 0
(inclusive) and n (exclusive).
 */
def genRandomArray (n : Int) : Array[Int] = {
  val a = new Array[Int](n)
  for (i <- 0 until n) a(i) = util.Random.nextInt(n)
  a
}

val randomArray = genRandomArray(20)    //generate an array accessbile by all places in this file
println(randomArray.mkString(", "))
/*ex2
Write a loop that swaps adjacent elements of an array of integers. For example,
Array(1, 2, 3, 4, 5) becomes Array(2, 1, 4, 3, 5).
 */

val negToPosArr =Array(-3,9,0, -22,-17,2,10,8)
 //generate an array accessbile by all places in this file
def swap(arr: Array[Int]) : Array[Int] = {
  for (i <- 0 until arr.size if i % 2 != 0 ) {
    val temp = arr(i)
    arr(i)= arr(i-1)
    arr(i-1) = temp
  }
  arr
}
swap(negToPosArr).mkString(", ")
/*ex3
Repeat the preceding assignment, but produce a new array with the swapped
values. Use for/yield.
 */
def swapGen(arr: Array[Int])  = {
  val result = for (i <- 0 until arr.size ) yield {
    if (i % 2 != 0) arr(i-1)
    else if (i != arr.size -1) arr(i+1)
    else arr(i)
  }
  result
}
println("ex3: new array by 'for...yield'loop is:")
println(swapGen(negToPosArr).mkString(", "))
/*ex4
Given an array of integers, produce a new array that contains all positive
values of the original array, in their original order,
 */
def sortArray(arr: Array[Int]) ={
  val posArr = ArrayBuffer[Int]()
  val nonPosArr = ArrayBuffer[Int]()
  for (i <- arr){
    if (i>0) posArr += i
    else nonPosArr += i
  }
  (posArr ++ nonPosArr).toArray
}

println(sortArray(negToPosArr).mkString(", "))

//ex4 - a better solution
def softArray_better(arr : Array[Int]) = {
  arr.filter(_ >0) ++ arr.filter(_ <=0 )
}

println(softArray_better(negToPosArr).mkString(", "))
/*ex5
How do you compute the average of an Array[Double]?
 */
def calAverage(arr : Array[Double]) = {
  arr.sum / arr.size    //scala has functions for sum, max, min, sorted etc
}
val result = calAverage(Array(-3.3,9.6,0, -22.1,-17.4,2.0,10.1,8.5))
println(result)

/*ex6
How do you rearrange the elements of an Array[Int] so that they appear in
reverse sorted order? How do you do the same with an ArrayBuffer[Int]?
 */
val revSortedArr = randomArray.sortWith(_>_)
//val revSortedArr = randomArray.sorted.reverse    //alternative way to reverse sort
println(revSortedArr.mkString(", "))

//val revSortedArrBuf = randomArray.toBuffer.sortWith(_>_)
val revSortedArrBuf = randomArray.toBuffer.sorted.reverse    //alternative way to reverse sort
println(revSortedArrBuf.mkString(", "))
/*ex7
Write a code snippet that produces all values from an array with duplicates
removed. (Hint: Look at Scaladoc.)
 */
val dupeArr = randomArray ++ randomArray
println(dupeArr.mkString(", "))
val noDupeArr = dupeArr.distinct
println(noDupeArr.mkString(", "))
/*ex8
Rewrite the example at the end of Section 3.4, “Transforming Arrays,” on
page 32. Collect indexes of the negative elements, reverse the sequence, drop
the last index, and call a.remove(i) for each index. Compare the efficiency of
this approach with the two approaches in Section 3.4.
 */
println("Input array is: "+negToPosArr.mkString(", "))
val negToPosArrBuf = negToPosArr.toBuffer
val negIndices = for (i <- 0 until negToPosArrBuf.size if (negToPosArrBuf(i)) < 0) yield i
val revNegIndices = negIndices.reverse.dropRight(1)
val outputArr = revNegIndices.foreach(negToPosArrBuf.remove(_))
println("Output array is: "+ revNegIndices.mkString(","))

/*ex9
Make a collection of all time zones returned by java.util.TimeZone.getAvailableIDs
that are in America. Strip off the "America/" prefix and sort the result.
 */
val timeZoneIDs = java.util.TimeZone.getAvailableIDs()
val americanTimeZoneIDs = timeZoneIDs.filter(_.startsWith("America/"))
println(americanTimeZoneIDs.mkString(", "))
val sortedUSTimeZoneIDs = americanTimeZoneIDs.map(_.stripPrefix("America/"))
println("Stripped and sorted: "+ sortedUSTimeZoneIDs.mkString(", "))
/*ex10
Import java.awt.datatransfer._ and make an object of type SystemFlavorMap with
the call
val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
Then call the getNativesForFlavor method with parameter DataFlavor.imageFlavor
and get the return value as a Scala buffer. (Why this obscure class? It’s hard
to find uses of java.util.List in the standard Java library.)
 */
import java.awt.datatransfer._
import collection.JavaConversions.asScalaBuffer
import collection.mutable.Buffer

val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
//on page 37: when a Java method returns a java.util.List, you can have it automatically converted into a Buffer
//Buffer in Scala == List in Java
val types : Buffer[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
println("those are: "+types)
