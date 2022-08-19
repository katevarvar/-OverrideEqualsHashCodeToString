package PolishedTasksOneByOne.EqualsHashCodeAndToString;

public class EqualsToStringHashCodeOverride {

    public static void main(String[] args) {
        String[] e = new String[3];
        e[0] = "test1";
        e[1] = "test2";
        e[2] = "test3";
        Complex c1 = new Complex(10, 15, e);
        Complex c2 = new Complex(10, 15, e);
        if (c1.equals(c2) && (c1.hashCode() == c2.hashCode())) {
            System.out.println("Equal ");
        } else {
            System.out.println("Not Equal ");
        }
        System.out.println("An example of the method toString overriding: ");
        System.out.println(c1);
    }
}

