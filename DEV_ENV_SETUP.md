***
Setup you dev environment.
---------------------------
If you are developing in Java and have maven installed, you can skip this setup and work with the work environment of your choice.
However if you don't have an active Java development environment, please follow the following to make sure you are all set up and ready to write the code for the excercise.

// todo - the purpese of this readme is to help setup a working environment in conferences where participants have almost no knowledge in Java development. 
// todo - this is what we thoght might help in conferences like Hackeriot where the level of Java knowlegde is CS graduate level at most and bootcamp or personal interest knowledge is even more common.
// todo - pass all text with chatgpt.
// todo - write this as a trubleshoot guide - with how to test that the step was success full and perhaps guide how to fix common problems (path, restart, and others) 

Prepare work environment with Maven and IDE 
--------------------------------------------
To prepare your work environment, follow these steps:
1. IDE. \
   If you don't have a preferred working IDE, download and install [Intellij](https://www.jetbrains.com/idea/download/) Community Edition for free. Make sure you download the Community Edition.
2. JDK \
   If you don't have a JDK installed, download any version of JDK. The project was tested with JDK 1.8 and JDK 23. You can use IntelliJ to download the JDK by following the steps explained [here](https://www.jetbrains.com/help/idea/sdk.html#set-up-jdk).
   // todo - write how to test that the JDK is installed by running java --version (can also wok for JRE), how to set JAVA_HOME, perhaps suggest to download using intellij but give the option to download independently. jdk23 will work 
4. Maven \
   Download Maven, the build tool used in this project, from [here](https://maven.apache.org/download.cgi) and extract it to a folder (no installation required). 
   Then, add the maven/build folder to the PATH variable.
   // todo - write here how to make sure maven is installed. 



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
