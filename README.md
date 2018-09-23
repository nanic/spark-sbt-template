# spark-sbt-template

A Sample Spark App with SBT as build tool. 

SBT is a build toold based and built out of scala.

### Usage

* git clone https://github.com/nanic/spark-sbt-template.git
* Edit build.sbt to change the project name
* Run `sbt assembly` to build a fat jar with application classes and libraries that are needed.

Note: `provided` in build.sbt file represents respective artifact being included as part of compilation
and ignored as part of runtime. So it is advised to use the APIs to test from such libraries as part of 
test cases as in  this template.