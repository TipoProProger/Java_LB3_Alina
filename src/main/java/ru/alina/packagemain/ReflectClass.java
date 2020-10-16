package ru.alina.packagemain;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectClass {
    public void printAll (Class <?> Cl) {
        System.out.println(Cl.getName());
        if (Cl.getName()=="java.lang.Object")
            System.out.println("This class doesnt have classloader");

        else System.out.println(Cl.getClassLoader().getName());
        for (Method meth: Cl.getMethods())
            System.out.println(meth.getName());
        for (Field par: Cl.getFields()){
            System.out.println("Type: "+par.getClass());
            System.out.println("Name: "+par.getName());
        }

        Class <?> prCl = Cl.getSuperclass();
        if (prCl==null)
            return;
        else {
            printAll(prCl);
        }

    }
}
