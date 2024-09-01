class employee {
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

    public employee(String myName) { // This is a constructor
        id = 100;
        name = myName;
    }
}

public class constructors {
    public static void main(String[] args) {
        employee new1 = new employee("Ammar");
        System.out.println(new1.getName());
        System.out.println(new1.getId());

    }
}
