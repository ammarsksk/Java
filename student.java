package Java;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class student extends user implements course_catalog{
    Scanner sc = new Scanner (System.in);
    private String name;
    private int roll_no;
    private int current_semester = 1; // DEFAULT VALUE
    private boolean status = false;
    private String Complaint;

    private ArrayList<courses> completed_backlog_courses = new ArrayList<courses>();;
    private ArrayList<courses> registered_courses = new ArrayList<courses>();;
    private ArrayList<courses> completed_courses = new ArrayList<courses>();;

    public student(String email, String password, String name, int roll_no){
        super(email, password);
        this.name = name;
        this.roll_no = roll_no;
    }
    public void calculateCGPA(ArrayList<courses> arr, int semester){
        float sgpa = 0; int num= 0;int sem = 1;float cgpa = 0;
        if (arr == null){
            System.out.println("There is no CGPA to be calculated, as there are no completed courses. ");
        }
        assert arr != null;
        if(semester==1){
            for(courses c:arr){
                if(c.getsemester() == semester){
                    sgpa+=c.getGPA();
                    num++;
                }
            }
            System.out.println("The CGPA is: " + sgpa/num);
            return;
        }
        while(sem<semester){
            for(courses c: arr){
                if (c.getsemester() == sem){
                    sgpa+=c.getGPA();
                    num++;
                }
            }
            cgpa+=sgpa/num;
            sgpa = 0; num = 0;
            sem++;
        }
        System.out.println("The CGPA of the student is: " + cgpa/(sem-1));
    }

    public void make_registered_courses(ArrayList<courses> arr1, ArrayList<courses> arr2, int semester){
        for (courses c: arr1){
            if (c.getsemester() == semester && has_passed(arr1, c.getprereqs()) && !has_registered(arr2, c.getcourse_name())){
                System.out.println("This is a course which you can apply for: " + c.getcourse_name());
                System.out.print("Enter y or n --> y to apply, n to reject: ");
                String f = sc.next();
                if (Objects.equals(f, "y")){
                    arr2.add(c);
                }
            }
            else{
                System.out.println("The prereqs haven't been cleared or it has already been registered! ");
            }
        }
    }
    public boolean has_registered(ArrayList<courses> arr, String name){
        boolean flag = false;
        for (courses c: arr){
            if(c.getcourse_name().equals(name)){
                flag = true;
            }
        }
        return flag;
    }
    public boolean has_passed(ArrayList<courses> arr, String name){
        boolean pass = Objects.equals(name, "NULL");
        for (courses c : arr){
            if (c.getcourse_name().equals(name) && (c.ispass_status() || c.getcredits()>=4)){
                pass = true;
            }
        }
        return pass;
    }
    public void getweeklyschedule(ArrayList<courses> arr, String name){
        for (courses c : arr){
            if (c.getcourse_name().equals(name)){
                System.out.println("The days are: " + c.getdays());
                System.out.println("The slot number is: " + c.getslot());
                System.out.println("The location is: " + c.getlocations());
            }
        }
    }
    public void dropcourses(ArrayList<courses> arr, String name){
        arr.removeIf(c -> c.getcourse_name().equals(name));
    }
    public void calculateSGPA(ArrayList<courses> arr, int semester){
        float sgpa = 0;
        int num = 0;
        for (courses c : arr){
            if (c.getsemester() == semester){
                num++;
                sgpa += c.getGPA();
            }
        }
        sgpa = sgpa/num;
        System.out.println(sgpa);
    }
    public void getcourseSGPA(ArrayList<courses> arr){
        int sgpa = 0;
        int num = 0;
        for (courses c : arr){
            sgpa += c.getGPA();
            num++;
        }
        System.out.println(sgpa/num);
    }
    public void getavailablecourses(ArrayList<courses> arr, int semester){
        for (courses c : arr){
            if (c.getsemester() == semester){
                System.out.println(c.getcourse_name() + " - " + c.getcourse_code());
            }
        }
    }
    public void getsemester(ArrayList<courses> arr, String name){
        for (courses c : arr){
            if (c.getcourse_name().equals(name)){
                System.out.println(c.getsemester());
            }
        }
    }
    public void getcoursecode(ArrayList<courses> arr, String name){
        for (courses c : arr){
            if (c.getcourse_name().equals(name)){
                System.out.println(c.getcourse_code());
            }
        }
    }
    public void getprofname(ArrayList<courses> arr, String name){
        for (courses c : arr){
            if (c.getcourse_name().equals(name)){
                System.out.println(c.getprofessor_name());
            }
        }
    }
    public void getcoursecredits(ArrayList<courses> arr, String name){
        for (courses c : arr){
            if (c.getcourse_name().equals(name)){
                System.out.println(c.getcredits());
            }
        }
    }
    public void getcourseprereqs(ArrayList<courses> arr, String name){
        for (courses c : arr){
            if (c.getcourse_name().equals(name)){
                System.out.println(c.getprereqs());
            }
        }
    }
    public void getregisteredcourses(ArrayList<courses> arr){
        if (arr == null){
            System.out.println("There are no registered courses!");
        }
        else{
            for (courses c : arr){
                System.out.println(c.getcourse_name() + " - " + c.getcourse_code());
            }
        }
    }
    public ArrayList<courses> getCompleted_courses() {
        return completed_courses;
    }

    public void setCompleted_courses(ArrayList<courses> completed_courses) {
        this.completed_courses = completed_courses;
    }

    public ArrayList<courses> getRegistered_courses() {
        return registered_courses;
    }

    public void setRegistered_courses(ArrayList<courses> registered_courses) {
        this.registered_courses = registered_courses;
    }

    public int getCurrent_semester() {
        return current_semester;
    }

    public void setCurrent_semester(int current_semester) {
        this.current_semester = current_semester;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getComplaint() {
        return Complaint;
    }

    public void setComplaint(String complaint) {
        Complaint = complaint;
    }

    public ArrayList<courses> getCompleted_backlog_courses() {
        return completed_backlog_courses;
    }

    public void setCompleted_backlog_courses(ArrayList<courses> completed_backlog_courses) {
        this.completed_backlog_courses = completed_backlog_courses;
    }
}
