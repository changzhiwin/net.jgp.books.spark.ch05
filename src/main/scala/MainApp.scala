package net.jgp.books.spark

import net.jgp.books.spark.basic.Basic

object MainApp extends Basic{
  def main(args: Array[String]) = {
    val spark = getSession("Spark on a cluster")

    val numberOfThrows = (args.toSeq :+ "100000")(0).toInt

    val numArray = (1 to numberOfThrows).toArray

    import spark.implicits._
    val ds = spark.createDataset(numArray)

    val numSeed = new scala.util.Random(42)

    val dartsDs = ds.map(p => {
      val x = numSeed.nextDouble()
      val y = numSeed.nextDouble()
      (x * x + y * y <= 1) match {
        case true  => 1
        case false => 0
      }
    })

    val dartsInCircle = dartsDs.reduce((a, b) => a + b)

    println("Pi is roughly " + 4.0 * dartsInCircle / numberOfThrows)

    spark.stop
  }
}