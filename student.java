package Java;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.HashMap;

public class student extends user implements course_catalog{
    Scanner sc = new Scanner (System.in);
    private String name;
    private int roll_no;
    private int current_semester = 1; // DEFAULT VALUE

    private HashMap<courses, Float> student_sgpa = new HashMap<courses, Float>();
    private ArrayList<complaints> student_complaints = new ArrayList<complaints>();
    private ArrayList<courses> completed_backlog_courses = new ArrayList<courses>();
    private ArrayList<courses> registered_courses = new ArrayList<courses>();
    private ArrayList<courses> completed_courses = new ArrayList<courses>();

    public student(String email, String password, String name, int roll_no){
        super(email, password);
        this.name = name;
        this.roll_no = roll_no;
    }

    public void get_completed_records(ArrayList<courses> arr, HashMap<courses, Float> hash){
        if (arr.isEmpty()) {
            System.out.println("There are no passed courses! ");
            return;
        }
        for (courses c: hash.keySet()){
            if(hash.get(c)>=4 && hash.get(c)!=0){
                System.out.println("The completed (passed) course name, GPA, code and semester respectively is: " + c.getcourse_name() + " " + hash.get(c) + " " + c.getcourse_code() + " " + c.getsemester());
            }
        }
    }
    public void get_completed_backlog_records(ArrayList<courses> arr, HashMap<courses, Float> hash) {
        if (arr.isEmpty()) {
            System.out.println("There are no backlogs! ");
            return;
        }
        for (courses c: hash.keySet()){
            if(hash.get(c)<4 && hash.get(c) != 0){
                System.out.println("The completed (failed) course name, GPA, code and semester respectively is: " + c.getcourse_name() + " " + hash.get(c) + " " + c.getcourse_code() + " " + c.getsemester());
            }
        }
    }
    public void calculateCGPA(HashMap<courses, Float> hash){
        float cgpa = 0; int num = 0;
        if(hash.isEmpty()){
            System.out.println("There are no completed courses by this student! ");
            return;
        }
        for (courses i: hash.keySet()){
            if(hash.get(i)>=4){
                cgpa += hash.get(i);
                num++;
            }
        }
        cgpa = cgpa/num;
        System.out.println("The CGPA of the student is: " + cgpa);
    }
    public void get_course_syllabus(ArrayList<courses> arr, String name){
        boolean flag = true;
        for (courses c : arr){
            if (c.getcourse_name().equals(name)){
                flag = false;
                System.out.println(c.getsyllabus());
            }
        }
        if(flag){
            System.out.println("There are no courses under that name / Student hasn't registered for it! ");
        }
    }
    public void make_registered_courses(ArrayList<courses> arr1, ArrayList<courses> arr2, student s, HashMap<courses, Float> hash, int semester){
        int cred_limit = 0;
        for (courses c: arr2){
            cred_limit += c.getcredits();
        }
        for (courses c: arr1){
            try {
                if(c.getEnrolled_students().size()>=c.getEnrollment_limit()){
                    throw new CourseFullException("The course " + c.getcourse_name() + " is full, and cannot be added ");
                }
            }
            catch(CourseFullException e){
                System.out.println(e.getMessage());
                continue;
            }
            if (c.getsemester() == semester && has_passed(hash, c.getprereqs()) && !has_registered(arr2, c.getcourse_name()) && cred_limit<20){
                System.out.println("This is a course which you can apply for: " + c.getcourse_name());
                System.out.print("Enter y or n --> y to apply, n to reject: ");
                String f = sc.next();
                if (Objects.equals(f, "y")){
                    if (c.getcredits() + cred_limit >20){
                        System.out.println("You have passed the course limit, you cannot add this course any more! ");
                        return;
                    }
                    hash.put(c, 0F);
                    arr2.add(c);
                    c.getEnrolled_students().add(s);
                }
            }
            else if (c.getsemester() == semester && has_registered(arr2, c.getcourse_name())){
                System.out.println("You have already registered for " + c.getcourse_name());
            }
            else if(c.getsemester() == semester && !has_passed(hash, c.getprereqs())){
                System.out.println("You have not passed the prerequisites for " + c.getcourse_name());
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
    public boolean has_passed(HashMap<courses, Float> hash, String name){
        boolean pass = Objects.equals(name, "NULL");
        for (courses c: hash.keySet()){
            if(hash.get(c)>=4 && Objects.equals(c.getcourse_name(), name)){
                pass = true;
            }
        }
        return pass;
    }
    public void get_weekly_schedule(ArrayList<courses> arr, String name){
        boolean flag = true;
        for (courses c : arr){
            if (c.getcourse_name().equals(name)){
                flag = false;
                System.out.println("The days are: " + c.getdays());
                System.out.println("The slot number is: " + c.getslot());
                System.out.println("The location is: " + c.getlocations());
            }
        }
        if(flag){
            System.out.println("The course doesn't exist! ");
        }
    }
    public void dropcourses(ArrayList<courses> arr, String name, student s){
        boolean flag = true;
        for (courses c: arr){
            if(c.getcourse_name().equals(name)){
                try{
                    if(LocalDateTime.now().isAfter(c.deadline)){
                        throw new DropDeadlinePassedException("The drop deadline for the course has passed. ");
                    }
                }
                catch (DropDeadlinePassedException e){
                    System.out.println(e.getMessage());
                    return;
                }
                flag = false;
                c.getEnrolled_students().removeIf(d -> d.getName().equals(s.getName()));
            }
        }
        if(flag){
            System.out.println("The course doesn't exist or student hasn't registered! ");
            return;
        }
        arr.removeIf(c -> c.getcourse_name().equals(name));
    }
    public void calculateSGPA(HashMap<courses, Float> hash, int semester){
        float sgpa = 0; int num = 0;
        if(hash.isEmpty()){
            System.out.println("There are no completed courses by this student! ");
            return;
        }
        for (courses i: hash.keySet()){
            if(i.getsemester() == semester){
                sgpa += hash.get(i);
                num++;
            }
        }
        if(sgpa == 0 || num == 0){
            System.out.println("The semester is ongoing or the student hasn't been assigned grades yet. ");
        }
        sgpa = sgpa /num;
        System.out.println("The SGPA of the student is: " + sgpa);
    }
    public void getavailablecourses(ArrayList<courses> arr, HashMap<courses, Float> hash, int semester){
        for (courses c : arr){
            if (c.getsemester() == semester && has_passed(hash, c.getprereqs())){
                System.out.println(c.getcourse_name() + " - " + c.getcourse_code());
            }
        }
    }
    public void getcoursecode(ArrayList<courses> arr, String name){
        boolean flag = true;
        for (courses c : arr){
            if (c.getcourse_name().equals(name)){
                flag = false;
                System.out.println(c.getcourse_code());
            }
        }
        if(flag){
            System.out.println("The course doesn't exist or student hasn't registered! ");
        }
    }
    public void getprofname(ArrayList<courses> arr, String name){
        boolean flag = true;
        for (courses c : arr){
            if (c.getcourse_name().equals(name)){
                flag = false;
                System.out.println(c.getprofessor_name());
            }
        }
        if(flag){
            System.out.println("The course doesn't exist or student hasn't registered! ");
        }
    }
    public void get_office_hours(ArrayList<courses> arr, String name){
        boolean flag = true;
        for (courses c : arr){
            if (c.getcourse_name().equals(name)){
                flag = false;
                System.out.println(c.getOffice_hours());
            }
        }
        if(flag){
            System.out.println("The course doesn't exist! ");
        }
    }
    public void getcoursecredits(ArrayList<courses> arr, String name){
        boolean flag = true;
        for (courses c : arr){
            if (c.getcourse_name().equals(name)){
                flag = false;
                System.out.println(c.getcredits());
            }
        }
        if(flag){
            System.out.println("The course doesn't exist! ");
        }
    }
    public void getcourseprereqs(ArrayList<courses> arr, String name){
        boolean flag = true;
        for (courses c : arr){
            if (c.getcourse_name().equals(name)){
                flag = false;
                System.out.println(c.getprereqs());
            }
        }
        if(flag){
            System.out.println("The course doesn't exist! ");
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
    public void set_complaint(ArrayList<complaints> arr){
        System.out.println("Enter the complaint that you have: ");
        String a = sc.nextLine();
        if (Objects.equals(a, "")){
            a = sc.nextLine();
        }
        complaints complaint = new complaints(a);
        arr.add(complaint);
    }
    public void view_complaints(ArrayList<complaints> arr){
        if (arr.isEmpty()){
            System.out.println("There are no complaints from you. ");
        }
        else {
            for (complaints c : arr) {
                System.out.println(c.getComplaint() + " - " + c.getDateTime() + " | Status is: " + c.getStatus());
            }
        }
    }
    public void add_feedback(ArrayList<courses> arr, String course_name){
        boolean flag = true;
        for (courses c: arr){
            if(c.getcourse_name().equals(course_name)){
                flag = false;
                System.out.println("Enter which type of feedback to give --> \n1)Rating(1-5) \n2)Comment \n3)Rating(1.00 - 5.00)");
                int a = sc.nextInt();
                if(a == 1){
                    System.out.println("Enter the rating: ");
                    int b = sc.nextInt();
                    Feedback<Integer> feed = new Feedback<Integer>(b);
                    c.getInt_feedback().add(feed);
                }
                else if(a == 2){
                    System.out.println("Enter the comment: ");
                    sc.nextLine();
                    String b = sc.nextLine();
                    Feedback<String> feed = new Feedback<String>(b);
                    c.getString_feedback().add(feed);
                }
                else if(a == 3){
                    System.out.println("Enter the rating (with decimals): ");
                    double b = sc.nextDouble();
                    Feedback<Double> feed = new Feedback<Double>(b);
                    c.getDouble_feedback().add(feed);
                }
                else{
                    System.out.println("Enter correct command please! ");
                }
            }
        }
        if(flag){
            System.out.println("The student has no such course under him/ The course doesn't exist! ");
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

    public ArrayList<courses> getCompleted_backlog_courses() {
        return completed_backlog_courses;
    }

    public void setCompleted_backlog_courses(ArrayList<courses> completed_backlog_courses) {
        this.completed_backlog_courses = completed_backlog_courses;
    }

    public ArrayList<complaints> getStudent_complaints() {
        return student_complaints;
    }

    public void setStudent_complaints(ArrayList<complaints> student_complaints) {
        this.student_complaints = student_complaints;
    }

    public HashMap<courses, Float> getStudent_sgpa() {
        return student_sgpa;
    }

    public void setStudent_sgpa(HashMap<courses, Float> student_sgpa) {
        this.student_sgpa = student_sgpa;
    }
}
