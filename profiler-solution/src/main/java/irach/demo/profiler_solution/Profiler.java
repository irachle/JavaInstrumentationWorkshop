package irach.demo.profiler_solution;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

public class Profiler
{
  public static void premain(String agentArgs, Instrumentation inst)
  {
    transformClass(inst);
  }

  public static void agentmain(String agentArgs, Instrumentation inst)
  {
    transformClass(inst);
  }

  private static void transformClass(Instrumentation instrumentation)
  {
    ClassFileTransformer logTransformer = new LogTransformer2();
    instrumentation.addTransformer(logTransformer, true);
  }
}
