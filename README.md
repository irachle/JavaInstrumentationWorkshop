***
Java code introduction for beginners workshop.
---------------------
This is the code for the exercise in Java code introduction for beginners workshop.
The exercise is to build a simple profiler in java to test and see how instrumentation in java using works.  
The workshop is presented in [DevConf.us 2022](http://devconf.us/).
*** 

There are three modules this project:
1. tested-app \
    A simple app that just writes to a log a constant message.
    It is used to test the profiler.

2. profiler \
    A profiler agent that instruments the log method. You should work onh this folder to improve the profiler.
    It instruments the java.util.logging.Logger.log using JavaAssist.

3. profiler-solution \
      A profiler agent that instruments the log method. 
      This is a solution to the exercises given in the workshop.
      It instruments the java.util.logging.Logger.log using JavaAssist.

4. riddles folder \
    The riddles folder contains two riddles that can be solved using the profiler.

Test and run the profiler
-------------------------
Build the project 
```shell
mvn install
```
To execute the tested app without the profiler run
```shell
java -jar ./tested-app/target/tested-app-1.0.jar
```
To execute the tested app with the profiler run
```shell
java -javaagent:./profiler/target/profiler-1.0-jar-with-dependencies.jar -jar ./tested-app/target/tested-app-1.0.jar
```

Running the profiler with the riddles
------------------
In the riddles folder you can find two riddles. \
The order you should solve them is:
1. StartHere-1.jar
2. ShiftingNext-2.jar

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
