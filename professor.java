package Java;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class professor extends user {
    private String name;
    private ArrayList<courses> courses_under = new ArrayList<courses>();
    Scanner sc = new Scanner (System.in);

    public professor(String email, String password, String name){
        super(email, password);
        this.name = name;
    }

    public void change_syllabus(ArrayList<courses> arr, String name){
        if (arr == null){
            System.out.println("There are no courses under this prof.");
            return;
        }
        for (courses c: arr){
            if (c.getcourse_name().equals(name)){
                c.setsyllabus(sc.nextLine());
            }
        }
    }
    public void view_courses(ArrayList<courses> arr){
        if (arr == null){
            System.out.println("There are no courses under this prof.");
            return;
        }
        for (courses c: arr){
                System.out.print(c.getcourse_name() + " - " + c.getcourse_code() + " - " +  c.getsyllabus());
        }
    }

    public void update_timings(ArrayList<courses> arr, String name){
        if (arr == null){
            System.out.println("There are no courses under this prof.");
            return;
        }
        for (courses c: arr){
            if (c.getcourse_name().equals(name)){
                System.out.print("Enter the slot number you want to change the selected course to: ");
                c.setslot(sc.nextInt());
            }
        }
    }
    public void update_days(ArrayList<courses> arr, String name){
        if (arr == null){
            System.out.println("There are no courses under this prof.");
            return;
        }
        for (courses c: arr){
            if (c.getcourse_name().equals(name)){
                System.out.println("These are the original days of the course: ");
                System.out.println(c.getdays());
                System.out.print("Enter the 2 days which you want to put for your course: ");
                for(int i = 0; i<2; i++){
                    c.getdays().set(i, sc.next());
                }
            }
        }
    }

    public void update_enrollment_limit(ArrayList<courses> arr, String name){
        if (arr == null){
            System.out.println("There are no courses under this prof.");
            return;
        }
        for (courses c: arr){
            if (c.getcourse_name().equals(name)){
                c.setEnrollment_limit(sc.nextInt());
            }
        }
    }
    public void update_credits(ArrayList<courses> arr, String name){
        if (arr == null){
            System.out.println("There are no courses under this prof.");
            return;
        }
        for (courses c: arr){
            if (c.getcourse_name().equals(name)){
                c.setcredits(sc.nextInt());
            }
        }
    }
    public void update_office_hours(ArrayList<courses> arr, String name){
        for (courses c: arr){
            if (c.getcourse_name().equals(name)){
                c.setCourse_timings(sc.next());
            }
        }
    }
    public void update_prereqs(ArrayList<courses> arr, String name){
        if (arr == null){
            System.out.println("There are no courses under this prof.");
            return;
        }
        for (courses c: arr){
            if (c.getcourse_name().equals(name)){
                c.setprereqs(sc.next());
            }
        }
    }
    public void view_enrolled_students(ArrayList<courses> arr, String name){
        if (arr == null){
            System.out.println("There are no courses under this prof.");
            return;
        }
        for (courses c: arr){
            if (c.getcourse_name().equals(name)){
                for (student d: c.getEnrolled_students()){
                    System.out.print(d.getName() + " - " + d.getRoll_no());
                }
            }
        }
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
