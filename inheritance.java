package Java;

class Base{
    int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        System.out.println("This is from the Base class");
        this.x = x;
    }

    public void printMe(){

        System.out.println("This is a new constructor (from the base class); ");
    }
    Base(){
        System.out.println("I am a Base class constructor; ");
    }
    Base(int a){
        x = a;
        System.out.println("I am the second constructor; ");
    }
}

class Derived extends Base{
    int y;

    public int getY() {

        return y;
    }

    public void setY(int y) {

        this.y = y;
    }
    public void printMe(){

        System.out.println("This is a new constructor (from the derived class);");
    }
    Derived(){
        super(55); // This uses the second constructor of the Base class which has one argument in it.
        System.out.println("I am a Derived class constructor; ");
    }
}
public class inheritance {
    public static void main(String[] args) {
        Base one = new Base();
        Base three = new Base(5);
        System.out.println(three.getX());
        Derived two = new Derived();
        System.out.println(two.getX());
    }
}
