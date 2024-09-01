package Java;

class Employee {
    int id;
    String name;
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class ClassesAndMethods {
    static int logic(int x, int y){
        int z;
        if (x>y){
            z = x+y;
        }
        else{
            z = x-y;
        }
        return z;
    }
    static int sum (int ...arr)
    {
        int k = 0;
        for (int a:arr){
            k+=a;
        }
        return k;
    }
    public static void main(String[] args) {
/*
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(logic(a,b));
        System.out.println("My name is ammar");
        int c = sc.nextInt();

        int[] marks = new int[c];
        for(int i = 0; i<c; i++){
            marks[i] = sc.nextInt();
        }
        for(int i = 0; i<c; i++){
            System.out.print(marks[i] + " ");
        }

        System.out.println(sum(a, b, c, 54, 33, 25)); // This is to demonstrate var args.
*/
    Employee one = new Employee();
    one.setId(24);
    System.out.println("The id of the employee is: " + one.getId());
    one.setName("Ammar");
    System.out.println("The name of the employee is: " + one.getName());

    }
}
