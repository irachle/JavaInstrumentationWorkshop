package irach.demo.profiler_solution;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

/**
 * Learning Note:
 * To transform a class files an agent should provide an implementation of the ClassFileTransformer interface.
 * This is where you implement addition of new code.
 */

public class LogTransformer2 implements ClassFileTransformer
{
    private static final String CLASS_TO_INSTRUMENT = "java.util.logging.Logger";
    private static final String TRANSFORM_METHOD = "log";

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
            CtMethod method = cc.getDeclaredMethod(TRANSFORM_METHOD);

            if (method == null)
            {
                return byteCode;
            }

            method.insertAfter("irach.demo.profiler_solution.LogProfiler.$_INSTANCE.logMethodCalled();");

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