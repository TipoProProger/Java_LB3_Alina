package ru.alina.packagetwo;
import ru.alina.packageone.FirstClass;
import ru.alina.packageone.FirstInterface;

public class SecondClass {
    public int outWithParam (FirstInterface fc) {
        return fc.getInt();
    }
    public int outWithoutParam (int var) {
        FirstClass fc2 = new FirstClass (var);
        return fc2.getInt();
    }
}
