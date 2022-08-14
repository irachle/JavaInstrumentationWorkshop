package irach.demo.profiler_solution;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

/**
 * Exercise:
 * Print the log message that the application writes to the log.
 *
 * Note there are several approaches here, and here is implemented only one possible solution.
 * The problem that just printing the 1st argument doesn't get the message.
 * Possible directions will be:
 * 1. Find a way to instrument specifically the log method that is used by the tested-app (this is the one used for the riddle as well)
 *    Look on the different CtClass methods and find the one that seems most helpful to get the right method.
 *    Again several approaches exist also here.
 * 2. Debug and understand what is the log method that is instrumented, what is the argument,
 *    and how the message can obtained from this argument.
 *    Look in the java.util.logging.Logger to get more information
**/

public class LogTransformer3 implements ClassFileTransformer
{
    private static final String CLASS_TO_INSTRUMENT = "java.util.logging.Logger";
    private static final String TRANSFORM_METHOD = "log";
    private static final String TRANSFORM_METHOD_PARAM1 = "java.util.logging.Level";
    private static final String TRANSFORM_METHOD_PARAM2 = "java.lang.String";

    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer)
    {
        byte[] byteCode = classfileBuffer;

        if (!className.equals(CLASS_TO_INSTRUMENT.replaceAll("\\.", "/")))
        {
            return byteCode;
        }

        try
        {
            ClassPool cp = ClassPool.getDefault();
            CtClass cc = cp.get(CLASS_TO_INSTRUMENT);
            CtMethod method = cc.getDeclaredMethod(TRANSFORM_METHOD,
                new CtClass[]{cp.get(TRANSFORM_METHOD_PARAM1), cp.get(TRANSFORM_METHOD_PARAM2)});

            if (method == null)
            {
                return byteCode;
            }

            // Add code to the beginning of a method
            method.insertBefore( "System.out.println(\"[Added by Agent] log message is: \" + $2);");

            byteCode = cc.toBytecode();
            cc.detach();
        }
        catch (Exception e)
        {
            System.out.println("Exception during retransform: " + e.getMessage());
        }

        return byteCode;
    }
}