package Java;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
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
    public void add_course_catalog(ArrayList<courses> arr,  courses course){
        arr.add(course);
    }
    public void delete_from_course_catalog(ArrayList<courses> arr, ArrayList<student> arr2, ArrayList<professor> arr3,  String name){
        for (student s: arr2){
            s.getCompleted_backlog_courses().removeIf(d-> d.getcourse_name().equals(name));
            s.getCompleted_courses().removeIf(d-> d.getcourse_name().equals(name));
            s.getRegistered_courses().removeIf(d-> d.getcourse_name().equals(name));
        }
        for(professor p: arr3){
            p.getCourses_under().removeIf(d->d.getcourse_name().equals(name));
        }
        arr.removeIf(c -> c.getcourse_name().equals(name));
    }
    public void view_student_records(ArrayList<student> arr, String name){
        for (student c: arr){
            if (c.getName().equals(name)){
                System.out.println("The password, email and roll number of the student is: " + c.getPassword() + ", " + c.getEmail() + ", " + c.getRoll_no());
            }
        }
    }
    public void update_student_record(ArrayList<student> arr, String name, int n){
        for (student c: arr){
            if (c.getName().equals(name)){
                if(n==1){
                    c.setName(sc.next());
                }
                else if(n==2){
                    c.setEmail(sc.next());
                }
                else if(n==3){
                    c.setPassword(sc.next());
                }
                else if(n==4){
                    c.setRoll_no(sc.nextInt());
                }
                else{
                    System.out.println("Wrong input.");
                }
            }
        }
    }
    public void get_CGPA_SGPA(ArrayList<student> arr, String name, int semester){
        float sgpa; int sgpa1 = 0; int sgpa2 =0; int num1 = 0; int num2 = 0;
        for (student c: arr){
            if (c.getName().equals(name)){
                if (c.getCompleted_backlog_courses().isEmpty() && c.getCompleted_courses().isEmpty()){
                    System.out.println("Cannot print SGPA or CGPA since there are no completed courses by this student. ");
                    return;
                }
                for (courses s: c.getCompleted_courses()){
                    if(s.getsemester() == semester){
                        sgpa1 += s.getGPA();
                        num1++;
                    }
                }
                for (courses s: c.getCompleted_backlog_courses()){
                    if(s.getsemester() == semester){
                        sgpa2 += s.getGPA();
                        num2++;
                    }
                }
                sgpa = (float) (sgpa1 + sgpa2) /(num1 + num2);
                System.out.println("The SGPA of the student is: ");
                System.out.println(sgpa);
                c.calculateCGPA(c.getCompleted_courses(), c.getCurrent_semester());
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
                System.out.println("Would you like to change a backlog or update a passed course (1 for backlog, 2 for passed course) --> ");
                int a = sc.nextInt();
                if (a==1){
                    for (courses s: c.getCompleted_backlog_courses()){
                        if(s.getcourse_name().equals(course_name)){
                            System.out.println("Enter the new grade: ");
                            s.setGPA(sc.nextInt());
                        }
                    }
                }
                else if (a==2){
                    for (courses s: c.getCompleted_courses()){
                        if(s.getcourse_name().equals(course_name)){
                            System.out.println("Enter the new grade: ");
                            s.setGPA(sc.nextInt());
                        }
                    }
                }
            }
        }
    }
    public void renew_grades_lists(ArrayList<student> arr, String name){
        for (student c: arr){
            if(c.getName().equals(name)){
                for (courses s: c.getCompleted_courses()){
                        if(s.getGPA()<4){
                            c.getCompleted_backlog_courses().add(s);
                    }
                }
                c.getCompleted_courses().removeIf(d -> d.getGPA()<4);
                for (courses s: c.getCompleted_backlog_courses()){
                    if(s.getGPA()>=4){
                        c.getCompleted_courses().add(s);
                    }
                }
                c.getCompleted_backlog_courses().removeIf(d -> d.getGPA()>=4);
            }
        }

    }
    public void set_grades(ArrayList<student> arr, String name, String course_name){
        for (student c: arr){
            if (c.getName().equals(name)){
                for (courses s: c.getRegistered_courses()){
                    if(s.getcourse_name().equals(course_name)){
                        System.out.println("Enter the GPA of the student --> ");
                        int a = sc.nextInt();
                        s.setGPA(a);
                        if (a>=4){
                            c.getCompleted_courses().add(s);
                        }
                        else{
                            c.getCompleted_backlog_courses().add(s);
                        }
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
                    if (s.getGPA()>=4){
                        flag = true;
                    }
                }
                if (flag){
                    c.setCurrent_semester(c.getCurrent_semester() + 1);
                    System.out.println("The semester has been changed successfully, the current semester is: " + c.getCurrent_semester());
                    for (courses s: c.getRegistered_courses()){
                        if(s.getGPA()>=4){
                            c.getCompleted_courses().add(s);
                        }
                        else{
                            c.getCompleted_backlog_courses().add(s);
                        }
                    }
                    c.getRegistered_courses().clear();
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
                }
            }
        }
    }
    public void assign_professor(ArrayList<professor> arr, ArrayList<courses> arr1, String name, String course_name){
        for (professor p: arr){
            if(p.getName().equals(name)){
                if(p.getCourses_under().size()<2){
                    for (courses c: arr1){
                        if (c.getcourse_name().equals(course_name)){
                            p.getCourses_under().add(c);
                        }
                    }
                }
            }
        }
    }

    public void view_complaint(ArrayList<student> arr, String name){
        for (student s: arr){
            if (s.getName().equals(name)){
                if (s.getStudent_complaints().isEmpty()){
                    System.out.println("There are no complaints from this student. ");
                }
                else{
                    for (complaints c: s.getStudent_complaints()){
                        System.out.println(c.getComplaint() + " - " + c.getDateTime() +  " | Status is: " + c.getStatus());

                    }
                }
            }
        }
    }

    public void resolution (ArrayList<student> arr, String name){
        for (student s: arr) {
            if (s.getName().equals(name)) {
                if (s.getStudent_complaints().isEmpty()) {
                    System.out.println("There are no complaints from this student. ");
                }
                else {
                    for (complaints c : s.getStudent_complaints()) {
                        c.setStatus("Resolved");
                    }
                }
            }
        }
    }
    public void delete_student_complaints(ArrayList<student> arr, String name){
        for (student s: arr) {
            if (s.getName().equals(name)) {
                if (s.getStudent_complaints().isEmpty()) {
                    System.out.println("There are no complaints from this student. ");
                }
                else {
                    s.getStudent_complaints().removeIf(d -> Objects.equals(d.getStatus(), "Resolved"));
                }
            }
        }
    }
    public void sort_complaints(ArrayList<student> arr, String name){
        for (student s: arr) {
            if (s.getName().equals(name)) {
                s.getStudent_complaints().sort(new Comparator<complaints>() {
                    @Override
                    public int compare(complaints c1, complaints c2) {
                        return c1.getDateTime().compareTo(c2.getDateTime());
                    }
                });
            }
        }
    }
}
