***
Java code introduction for beginners workshop.
---------------------
This is the code for the exercise in Java code introduction for beginners workshop.
The exercise is to build a simple profiler in java to test and see how instrumentation in java using works.  
The workshop is presented in DevConf.us 2022.
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
To execute the tested app without the profiler run
```shell
java -javaagent:./profiler/target/profiler-1.0-jar-with-dependencies.jar -jar ./tested-app/target/tested-app-1.0.jar
```

