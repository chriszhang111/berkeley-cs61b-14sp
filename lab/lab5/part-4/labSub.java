import java.io.*;

public class labSub extends labSuper{

	public static final int val = 22;

    public void print() {
        System.out.println("in subclass");
    }

    public static void main(String[] argv) {

    	// //向上cast
     //    labSub sup = new labSub();
     //    ((labSuper)sup).print(); //in subclass
     //    System.out.println(sup.val); //22 , however if we don't define val in sub class, it prints out 11.

        //向下cast
        labSuper sup2 = new labSuper();
        ((labSub)sup2).print(); //run-time error java.lang.ClassCastException: labSuper cannot be cast to labSub




    }
}