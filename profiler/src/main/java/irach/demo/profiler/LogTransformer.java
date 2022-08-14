package irach.demo.profiler;

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

public class LogTransformer implements ClassFileTransformer
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

            // Add code to the beginning of a method
            method.addLocalVariable("startTime", CtClass.longType);
            method.insertBefore( "startTime = System.currentTimeMillis();");

            // Add code to the end of a method
            StringBuilder endBlock = new StringBuilder();
            method.addLocalVariable("endTime", CtClass.longType);
            method.addLocalVariable("opTime", CtClass.longType);
            endBlock.append("endTime = System.currentTimeMillis();");
            endBlock.append("opTime = endTime - startTime;");
            endBlock.append("System.out.println(\"[Added by Agent] operation time: \" + opTime + \" miliseconds!\");");
            method.insertAfter(endBlock.toString());

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