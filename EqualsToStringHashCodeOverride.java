package PolishedTasksOneByOne.EqualsHashCodeAndToString;

import java.util.Arrays;
import java.util.StringJoiner;

public class EqualsToStringHashCodeOverride {
    static class Complex {
        double re;
        double im;
        String[] e;//написать equals hash code и to String, чтобы работало

        public Complex(double re, double im, String[] e) {//это конструктор, учла массив стрингов. Не до конца понимаю, заем массив здесь нужен
            this.re = re;
            this.im = im;
            this.e = e;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {//Проверяю, не обрящается ли оба референса на один объект
                return true;
            }
            if (obj == null || obj.getClass() != this.getClass()) {//Проверяю, что референсы обращают нас к объектам одного класса и что объект есть
                return false;
            }
            //таким образм можно избежать InstanceOf (if(!(obj instanceof Geek)) return false)
            //приведение типов
            Complex complex = (Complex) obj;
            //Теперь проверям, равен ли поданный в метод аргумент объекту, к которому мы апеллируем
            return (complex.re == (this.re) && complex.im == this.im && Arrays.equals(complex.e, this.e));
        }

        @Override
        public int hashCode() {
            return (int) (re * im);//Хочу чтобы в виде хэшкода выдавалсь значение произведения целочисленных частей,
            // так можно?
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Complex.class.getSimpleName() + "[", "]")
                    .add("re ='" + re + "'")
                    .add("im ='" + im + "'")
                    .add("content = " + e[0] + ", " + e[1] + ", " + e[2] )
                    .toString();
        }
    }


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

