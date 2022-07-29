package irach.demo.profiler_solution;

public class LogProfiler
{
  public static final LogProfiler $_INSTANCE = new LogProfiler();

  int count = 0;

  private LogProfiler()
  {
  }

  public void logMethodCalled()
  {
    count++;
    System.out.println("[Agent] log method was called " + count + " times");
  }
}