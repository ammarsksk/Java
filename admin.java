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
                    c.setName(sc.next());
                }
                if (n==2){
                    c.setEmail(sc.next());
                }
                if (n==3){
                    c.setPassword(sc.next());
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
    public void get_CGPA_SGPA(ArrayList<student> arr, String name, int semester){
        for (student c: arr){
            if (c.getName().equals(name)){
                System.out.println("The SGPA of the student is: ");
                c.calculateSGPA(c.getAll_courses_taken(), semester);
                System.out.println("The CGPA of the student is: ");
                c.calculateCGPA(c.getCompleted_courses());
            }
        }
    }
    public void get_grades(ArrayList<student> arr, String name, String course_name){
        for (student c: arr){
            if (c.getName().equals(name)){
                for (courses s: c.getCompleted_courses()){
                    if(s.getcourse_name().equals(course_name)){
                        System.out.println("The GPA of this course is: " + s.getGPA());
                    }
                }
            }
        }
    }
    public void change_completed_grades(ArrayList<student> arr, String name, String course_name){
        for (student c: arr){
            if (c.getName().equals(name)){
                for (courses s: c.getCompleted_courses()){
                    if(s.getcourse_name().equals(course_name)){
                        s.setGPA(sc.nextInt());
                    }

                }
            }
        }
    }
    public void set_grades(ArrayList<student> arr, String name, String course_name){
        for (student c: arr){
            if (c.getName().equals(name)){
                for (courses s: c.getRegistered_courses()){
                    if(s.getcourse_name().equals(course_name)){
                        System.out.println("I am here");
                        s.setGPA(sc.nextInt());
                    }

                }
            }
        }
    }
    public void change_semester(ArrayList<student> arr, String name){
        boolean flag = false;
        for (student c: arr){
            if(c.getName().equals(name)){
                for (courses s: c.getRegistered_courses()){
                    if (s.ispass_status() || s.getcredits()>=4){
                        flag = true;
                    }
                }
                if (flag){
                    c.setCurrent_semester(c.getCurrent_semester() + 1);
                    for (courses s: c.getRegistered_courses()){
                        if(s.getcredits()>=4 || s.ispass_status()){
                            c.getCompleted_courses().add(s);
                            c.setCompleted_courses(c.getCompleted_courses());
                        }
                    }
                }
                else{
                    System.out.println("He cannot be promoted to the next semester! ");
                }
            }
        }
    }
    public void assign_professor(ArrayList<professor> arr, courses course, String name){
        for (professor p: arr){
            if(p.getName().equals(name)){
                if (p.getCourses_under().size()<2){
                    p.getCourses_under().add(course);
                    p.setCourses_under(p.getCourses_under());
                }
            }
        }
    }
    public void assign_professor(ArrayList<professor> arr, ArrayList<courses> arr1, String name, String course_name){
        for (professor p: arr){
            if(p.getName().equals(name)){
                for (courses c: arr1){
                    if (c.getcourse_name().equals(course_name)){
                        p.getCourses_under().add(c);
                        p.setCourses_under(p.getCourses_under());
                    }
                }
            }
        }
    }

}
