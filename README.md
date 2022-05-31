# Purpose
pure scala version of https://github.com/jgperrin/net.jgp.books.spark.ch05

# Environment
- Java 11
- Scala 2.13.8
- Spark 3.2.1

# How to run
## 1, sbt package, in project root dir
When success, there a jar file at ./target/scala-2.13. The name is `main-scala-ch5_2.13-1.0.jar` (the same as name property in sbt file)

## 2, submit jar file, in project root dir
```
$ YOUR_SPARK_HOME/bin/spark-submit \
  --class net.jgp.books.spark.MainApp \
  --master "spark://10.11.1.120:7077" \
  target/scala-2.13/main-scala-ch5_2.13-1.0.jar 500000
```

## 3, print

### Case: different size of points
```
// 100000 points
Pi is roughly 3.13072

// 300000 points
Pi is roughly 3.1387733333333334

// 500000 points
Pi is roughly 3.143264
```

## 4, Some diffcult case

### I don't know why use this formula by author
I use `val x = scala.util.Random(42).nextDouble()` directly. Is `random * 2 - 1` better ?
```
// the formula used by author
double x = Math.random() * 2 - 1;
double y = Math.random() * 2 - 1;
```

### I just have one node
So, just compute 100000 points default(you can change bigger). **Notice:**, not use 127.0.0.1 or localhost, use real ip instead.
