package Java;
import java.util.ArrayList;
import java.util.Scanner;

public class admin extends user {
    Scanner sc = new Scanner(System.in);
    public admin(String email) {
        super(email);
    }

    public void view_course_catalog(ArrayList<courses> arr){
        for (courses c : arr){
            System.out.println(c.getcourse_name() + " - " + c.getcourse_code());
        }
    }
    public void add_course_catalog(ArrayList<courses> arr, courses course){
        arr.add(course);
    }
    public void delete_from_course_catalog(ArrayList<courses> arr, String name){
        arr.removeIf(c -> c.getcourse_name().equals(name));
    }
    public void view_student_records(ArrayList<student> arr, String name){
        for (student c: arr){
            if (c.getName().equals(name)){
                System.out.println(c.getPassword() + ", " + c.getEmail() + ", " + c.getRoll_no());
            }
        }
    }
    public void update_student_record(ArrayList<student> arr, String name, int n){
        for (student c: arr){
            if (c.getName().equals(name)){
                if (n==1){
                    c.setName(sc.nextLine());
                }
                if (n==2){
                    c.setEmail(sc.nextLine());
                }
                if (n==3){
                    c.setPassword(sc.nextLine());
                }
                if(n==4){
                    c.setRoll_no(sc.nextInt());
                }
                else{
                    System.out.println("Wrong input.");
                }
            }
        }
    }
    public void get_grades(ArrayList<courses> arr){
        for (courses c: arr){
            System.out.println(c.getGPA());
        }
    }
    public void change_grades(ArrayList<courses> arr, String name){
        for (courses c: arr){
            if (c.getcourse_name().equals(name)){
                c.setGPA(sc.nextInt());
            }
        }
    }
    public void change_semester(int semester, ArrayList<courses> arr){
        boolean flag = true;
        for (courses c: arr){
            if (c.getsemester() == semester){
                if (c.ispass_status()){
                    flag = true;
                }
                else{
                    flag = false;
                }
            }
        }
        if (flag){
            semester++;
        }
        else{
            System.out.println("Couldn't promote to the net semester!");
        }
    }
    public void assign_professor(ArrayList<courses> arr, courses course){
        if (arr.size()>=2){
            System.out.println("Ineligible for any more courses");
        }
        else{
            String c = sc.next();
            arr.add(course);
        }
    }

}
