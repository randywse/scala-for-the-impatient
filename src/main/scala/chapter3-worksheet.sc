import scala.collection.mutable.ArrayBuffer

/*
*Scala for impatient
* chapter 3 exercises
 */
//ex1
def genRandomArray (n : Int) : Array[Int] = {
  val a = new Array[Int](n)
  for (i <- 0 until n) a(i) = util.Random.nextInt(n)
  a
}
println(genRandomArray(10).mkString(", "))
//ex2
def swap(arr: Array[Int]) : Array[Int] = {
  for (i <- 0 until arr.size if i % 2 != 0 ) {
    val temp = arr(i)
    arr(i)= arr(i-1)
    arr(i-1) = temp
  }
  arr
}
swap(Array(1, 2, 3, 4, 5)).mkString(", ")
//ex3
def swapGen(arr: Array[Int])  = {
  val result = for (i <- 0 until arr.size ) yield {
    if (i % 2 != 0) arr(i-1)
    else if (i != arr.size -1) arr(i+1)
    else arr(i)
  }
  result
}
println("ex3: new array by 'for...yield'loop is:")
println(swapGen(Array(1, 2, 3, 4, 5)).mkString(", "))
//ex4
def sortArray(arr: Array[Int]) ={
  val posArr = ArrayBuffer[Int]()
  val nonPosArr = ArrayBuffer[Int]()
  for (i <- arr){
    if (i>0) posArr += i
    else nonPosArr += i
  }
  (posArr ++ nonPosArr).toArray
}

println(sortArray(Array(-3,9,0, -22,-17,2,10,8)).mkString(", "))

//ex4 - a better solution
def softArray_better(arr : Array[Int]) = {
  arr.filter(_ >0) ++ arr.filter(_ <=0 )
}

println(softArray_better(Array(-3,9,0, -22,-17,2,10,8)).mkString(", "))

//ex5
def calAverage(arr : Array[Double]) = {
  arr.sum / arr.size    //scala has functions for sum, max, min, sorted etc
}
val result = calAverage(Array(-3.3,9.6,0, -22.1,-17.4,2.0,10.1,8.5))
println(result)