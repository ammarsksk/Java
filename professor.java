package Java;
import java.util.ArrayList;
import java.util.Scanner;


public class professor extends user {
    private String name;
    private ArrayList<courses> courses_under;
    Scanner sc = new Scanner (System.in);

    public professor(String email, String password, String name){
        super(email, password);
        this.name = name;
    }

    public void change_syllabus(ArrayList<courses> arr, String name){
        for (courses c: arr){
            if (c.getcourse_name().equals(name)){
                c.setsyllabus(sc.nextLine());
            }
        }
    }
    public void update_timings(ArrayList<courses> arr, String name){
        for (courses c: arr){
            if (c.getcourse_name().equals(name)){
                c.setsyllabus(sc.nextLine());
            }
        }
    }
    public void update_enrollment_limit(ArrayList<courses> arr, String name){
        for (courses c: arr){
            if (c.getcourse_name().equals(name)){
                c.setEnrollment_limit(sc.nextInt());
            }
        }
    }
    public void update_credits(ArrayList<courses> arr, String name){
        for (courses c: arr){
            if (c.getcourse_name().equals(name)){
                c.setcredits(sc.nextInt());
            }
        }
    }
    public void update_prereqs(ArrayList<courses> arr, String name){
        for (courses c: arr){
            if (c.getcourse_name().equals(name)){
                c.setprereqs(sc.next());
            }
        }
    }
    public void view_enrolled(ArrayList<courses> arr){
        for (courses c: arr){
            System.out.println(c.getcourse_name());
        }
    }

    public professor(String email, String password) {
        super(email, password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<courses> getCourses_under() {
        return courses_under;
    }

    public void setCourses_under(ArrayList<courses> courses_under) {
        this.courses_under = courses_under;
    }
}
