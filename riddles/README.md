Running the profiler with the riddles
------------------
In the riddles folder you can find two riddles. \
The order you should solve them is:
1. StartHere-1.jar
2. ShiftingNext-2.jar

To run the riddles from the main folder you can use the following commands:\
\
To run the first riddle without the profiler use:
```shell
java -jar ./riddles/StartHere-1.jar
```
and with the profiler:
```shell
java -javaagent:./profiler/target/profiler-1.0-jar-with-dependencies.jar -jar ./riddles/StartHere-1.jar
```
\
To run the second riddle without the profiler use:
```shell
java -jar ./riddles/ShiftingNext-2.jar
```
and with the profiler:
```shell
java -javaagent:./profiler/target/profiler-1.0-jar-with-dependencies.jar -jar ./riddles/ShiftingNext-2.jar
```
