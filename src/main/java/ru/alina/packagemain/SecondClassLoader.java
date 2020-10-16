package ru.alina.packagemain;

import com.sun.jdi.ClassNotLoadedException;
import ru.alina.packagetwo.SecondClass;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class SecondClassLoader extends ClassLoader {
    private HashMap <String, Class<?>> memory;
    public SecondClassLoader () {
        memory = new HashMap<>();
    }
    @Override
    public Class<?> findClass (String className) throws ClassNotFoundException {
        if (memory.containsKey(className))
            return memory.get(className);

        //InputStream inputS = getClass().getClassLoader().
          //      getResourceAsStream(("target\\classes\\"+className.replace(".","\\")+".class"));
        // File classFile = new File("target\\classes\\"+className.replace(".","\\")+".class");
        String bufTest = ("target\\classes\\"+className.replace(".","\\")+".class");
        File testFile = new File (bufTest);
        try {
            InputStream inputS = new FileInputStream(testFile);
            ByteBuffer buf = ByteBuffer.wrap(inputS.readAllBytes());
            memory.put(className,defineClass(className, buf, null));
            return memory.get(className);}
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return super.findClass(className);
        }
        catch (IOException exep) {
            return super.findClass(className);
        }
        catch (OutOfMemoryError exMem) {
            return super.findClass(className);
        }

    }

}
