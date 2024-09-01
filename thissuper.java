package Java;

class ekClass {

    int a;
    public void meth(){
        System.out.println("This is a ekClass method;");
    }

    ekClass(int a){
        this.a = a;
        System.out.println("The value of a is: "+ a);
    }

    public int getA() {
        return a;
    }
}

class doClass extends ekClass{

    doClass(int a) {
        super(a);
    }
    public void meth(){
        super.meth(); // Invokes the superclass method.
        System.out.println("This is a doClass method;");
    }
    doClass(int a, int b) {
        super(a); // This invokes the superclass constructor which has one variable argument.
        System.out.println("The second constructor for this class is this, and the second variable is: "+ b);
    }
}

public class thissuper {

    public static void main(String[] args) {

        ekClass new1 = new ekClass(5);
        doClass new2 = new doClass(35, 45);
        new2.meth();

    }
}
