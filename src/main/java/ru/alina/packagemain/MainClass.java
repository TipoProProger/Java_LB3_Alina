package ru.alina.packagemain;


import ru.alina.packageone.FirstInterface;

public class MainClass {
    FirstClassLoader fcl;
    SecondClassLoader scl;
    public MainClass () {
        fcl = new FirstClassLoader();
        scl = new SecondClassLoader();
    }
    public static void main (String args[]) {
        MainClass mc = new MainClass();
        Object inFirst;
        try {
        inFirst = mc.fcl.findClass("ru.alina.packageone.FirstClass").getConstructor(int.class).newInstance(10);
            Object inSecond = mc.scl.findClass("ru.alina.packagetwo.SecondClass").getConstructor().newInstance();
            System.out.println("Search was succesfull");
            System.out.println(inSecond.getClass().getDeclaredMethod("outWithoutParam", int.class).invoke(inSecond, 1));
            System.out.println(inSecond.getClass().getDeclaredMethod("outWithParam", FirstInterface.class).invoke(inSecond, inFirst));

        }
        catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
        catch (Exception e) {
            System.out.println("Something is wrong");
        }

        ReflectClass rC = new ReflectClass();
        rC.printAll(mc.getClass());
    }
}
