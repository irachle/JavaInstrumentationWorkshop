***
## Setup your development environment.

If you are developing in Java and have maven installed, you can skip this setup and work with the work environment of your choice.
However, if you don't have an active Java development environment, please follow these instructions to make ensure you are all set up and ready to write the code for the exercise.

### 1. Install Git and clone the code
1. Install Git. You can do it from [here](https://git-scm.com/downloads).
2. Clone the code for this project by running in the folder where you want the project
```shell
git clone https://github.com/irachle/JavaInstrumentationWorkshop.git
```

### 2. Install Intellij IDE - Community Edition.
1. Download and install [Intellij](https://www.jetbrains.com/idea/download/) Community Edition for free. Make sure you download the Community Edition.
2. Open the project you have cloned in [step 1](1.-Install-Git-and-clone-the-code).

### 3. Download a JDK using Intellij.
1. Open project settings `File -> Project Structure -> Project`.
2. In the `Project SDK` section, click `New -> Download JDK`.
3. Select the desired SDK version (the project was tested with JDK 1.8, 17 and 23) and click `Download and Install`.
4. Once the JDK is installed, select it as the `Project SDK` and click `Apply` and `OK`.

### 4. Build the project using maven (the version bundled in Intellij).
1. Open the terminal in Intellij.
2. Build the project
```shell
mvn install
```

### 5. Run the project to test it works.
To execute the tested app without the profiler run
```shell
java -jar ./tested-app/target/tested-app-1.0.jar
```
To execute the tested app with the profiler run
```shell
java -javaagent:./profiler/target/profiler-1.0-jar-with-dependencies.jar -jar ./tested-app/target/tested-app-1.0.jar
```

### You are all set to work on the exercise.
