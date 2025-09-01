***
Java Code Instrumentation for Beginners Workshop
---------------------
This is the code for the exercise in Java code instrumentation for beginners workshop.
The exercise is to build a simple profiler in java to test and see how instrumentation in java works.  

The workshop was presented in [DevConf.us 2022](http://devconf.us/). \
Then it transformed to **Interactive Application Security Testing (IAST) - Under the hood** workshop in [Hackeriot 2024](https://www.hackeriot.org/)
*** 

There are three modules this project:
1. tested-app \
    A simple app that just writes to a log a constant message.
    It is used to test the profiler.

2. profiler \
    A profiler agent that instruments the log method. You should work on this folder to improve the profiler.
    It instruments the java.util.logging.Logger.log using JavaAssist.

3. profiler-solution \
      A profiler agent that instruments the log method. 
      This is a solution to the exercises given in the workshop.
      It instruments the java.util.logging.Logger.log using JavaAssist.

4. riddles \
    The riddles folder contains two riddles that can be solved using the profiler you will write. 
    You can find there a `README` file with the run instructions. 

Prepare a work environment with GitHub Codespaces.
--------------------------------------------

## 🧑‍💻 Option 1: Use VS Code in the Browser

1. Go to the GitHub repository: [JavaInstrumentationWorkshop](https://github.com/irachle/JavaInstrumentationWorkshop).
2. Click the green **Code** button.
3. Select **Codespaces → Create codespace on main**.
4. Wait for the environment to initialize. It will automatically:
    - Clone the workshop repo
    - Install Java 17, Maven, and Git
    - Set up Java extensions for VS Code

You can now start coding directly in your browser!

---

## 🧠 Option 2: Use IntelliJ IDEA via JetBrains Gateway

1. Download and install [JetBrains Gateway](https://www.jetbrains.com/remote-development/gateway/)
2. Open JetBrains Gateway and install the **GitHub Codespaces plugin**
3. Log in with your GitHub account
4. Select the `JavaInstrumentationWorkshop` Codespace
5. Launch it in JetBrains Gateway

This gives you a full IntelliJ experience backed by a cloud-hosted VM.

---

Happy coding! 🎉

Prepare work environment with Maven and IDE Locally
--------------------------------------------
For working on this project you will need an IDE, Maven as the build tool and a JDK. \
If you have these installed you can move to [Test and run the profiler](#test-and-run-the-profiler) section.
Otherwise, install the following - or go to [`DEV_ENV_SETUP` file](./DEV_ENV_SETUP.md) for a step by step instructions.
1. IDE. \
   If you don't have a preferred working IDE, download and install [Intellij](https://www.jetbrains.com/idea/download/) **Community** Edition for free.
2. Maven \
   Download Maven, the build tool used in this project, from [here](https://maven.apache.org/download.cgi) and extract it to a folder (no installation required). 
   Then, add the maven/build folder to the PATH variable.
3. JDK \
   If you don't have a JDK installed, download any version of JDK. The project was tested with JDK 1.8, 17 and 23. You can use IntelliJ to download the JDK by following the steps explained [here](https://www.jetbrains.com/help/idea/sdk.html#set-up-jdk).

## Test and run the profiler

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

