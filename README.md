# scalapb spark assembly issue

Works with:

```shell
sbt run # remove "provided" from build.sbt next to spark libs
```

Does not work with:

```shell
sbt assembly # build.sbt "provided" can be next to spark libs or not. It does not change the error
wget https://dlcdn.apache.org/spark/spark-3.2.1/spark-3.2.1-bin-hadoop3.2.tgz
tar -xzf spark-3.2.1-bin-hadoop3.2.tgz
cd spark-3.2.1-bin-hadoop3.2
bin/spark-submit ../target/scala-2.12/scalapb-spark-issue-assembly-1.0.0.jar
```

Error

```shell
Exception in thread "main" java.lang.NoSuchMethodError: 'shapeless.DefaultSymbolicLabelling shapeless.DefaultSymbolicLabelling$.instance(shapeless.HList)'
```

Commented segments in `build.sbt` are there because they were present in original project with this issue.
