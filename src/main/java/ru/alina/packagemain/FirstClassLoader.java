package ru.alina.packagemain;

import com.sun.jdi.ClassNotLoadedException;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class FirstClassLoader extends ClassLoader {
    private HashMap <String, Class<?>> memory;
    public  FirstClassLoader () {
        memory = new HashMap<>();
    }
    @Override
    public Class<?> findClass (String className) throws ClassNotFoundException {
        URL jU;
        if (memory.containsKey(className))
            return memory.get(className);
        String bufTest = ("jar:file:lr3jar.jar!/" + className.replace(".", "/") + ".class");
        try {
            jU = new URL(bufTest);
            InputStream inputS = jU.openStream();
            ByteBuffer buf = ByteBuffer.wrap(inputS.readAllBytes());
            memory.put(className, defineClass(className, buf, null));
            return memory.get(className);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return super.findClass(className);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return super.findClass(className);
        } catch (IOException exep) {
            return super.findClass(className);
        } catch (OutOfMemoryError exMem) {
            return super.findClass(className);
        }
    }
}

