package irach.demo.tested_app;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JustApp
{
    static Logger logger = Logger.getLogger(JustApp.class.getName());

    public static void main(String[] args)
    {
        try
        {
            for (int i = 0; i < 5; i++)
            {
                logger.log(Level.INFO, "My log message");
            }
        }
        catch (Exception ex)
        {
            System.out.println("Error in application: " + ex.getMessage());
        }
    }
}
