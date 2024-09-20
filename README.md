***
Java code introduction for beginners workshop.
---------------------
This is the code for the exercise in Java code introduction for beginners workshop.
The exercise is to build a simple profiler in java to test and see how instrumentation in java using works.  

The workshop was presented in [DevConf.us 2022](http://devconf.us/). \
Then it transformed to **Interactive Application Security Testing (IAST) - Under the hood** workshop in [Hackeriot 2024](https://www.hackeriot.org/)
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
    You can find there a `README` file with the run instructions. 

Prepare work environment with Maven and IDE 
--------------------------------------------
To prepare your work environment, follow these steps:
1. IDE. \
   If you don't have a preferred working IDE, download and install [Intellij](https://www.jetbrains.com/idea/download/) Community Edition for free.
2. Maven \
   Download Maven, the build tool used in this project, from [here](https://maven.apache.org/download.cgi) and extract it to a folder (no installation required). 
   Then, add the maven/build folder to the PATH variable.
3. JDK \
   If you don't have a JDK installed, download any version of JDK. The project was tested with JDK 1.8 and JDK 23. You can use IntelliJ to download the JDK by following the steps explained [here](https://www.jetbrains.com/help/idea/sdk.html#set-up-jdk).


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

