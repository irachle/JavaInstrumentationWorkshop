package irach.demo.profiler_solution;

import java.util.Arrays;
import java.util.List;

public class LogPasswordProfiler
{
  public static final LogPasswordProfiler $_INSTANCE = new LogPasswordProfiler();

  private static final List<String> PASSWORD_INDICATORS = Arrays.asList("password", "passwd", "pwd", "pass");

  private LogPasswordProfiler()
  {
  }

  public void logMethodCalled(String message)
  {
    System.out.println("[Agent] log method was called with the message " + message);

    String lowerMessage = message.toLowerCase();
    for (String indicator : PASSWORD_INDICATORS)
    {
      if (lowerMessage.contains(indicator))
      {
        System.out.println("[Agent] log message contains password: " +
                message.substring(lowerMessage.indexOf(indicator)));
        break;
      }
    }
  }
}