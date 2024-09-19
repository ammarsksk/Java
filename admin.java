package Java;
import java.util.*;

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
        boolean flag = true;
        for (student c: arr){
            if (c.getName().equals(name)){
                System.out.println("The password, email and roll number of the student is: " + c.getPassword() + ", " + c.getEmail() + ", " + c.getRoll_no());
                flag = false;
            }
        }
        if(flag){
            System.out.println("The student doesn't exist. ");
        }
    }
    public void update_student_record(ArrayList<student> arr, String name, int n){
        boolean flag = true;
        for (student c: arr){
            if (c.getName().equals(name)){
                flag = false;
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
        if (flag){
            System.out.println("The student doesn't exist. ");
        }
    }
    public void get_CGPA_SGPA(ArrayList<student> arr, HashMap<courses, Float> hash, String name, int semester){
        float sgpa = 0; int num = 0;
        float cgpa = 0; int num1 = 0;
        for (student c: arr){
            if (c.getName().equals(name)){
                if (c.getCompleted_backlog_courses().isEmpty() && c.getCompleted_courses().isEmpty()){
                    System.out.println("Cannot print SGPA or CGPA since there are no completed courses by this student. ");
                    return;
                }
                for(courses i : hash.keySet()){
                    if(i.getsemester() == semester){
                        sgpa += hash.get(i);
                        num++;
                    }
                }
                if(sgpa == 0 || num == 0){
                    System.out.println("The student's semester is ongoing or the course has not been graded yet.");
                }
                sgpa = sgpa /num;
                System.out.println("The SGPA of the student is: ");
                System.out.println(sgpa);
                for(courses i : hash.keySet()){
                    if(hash.get(i)>=4){
                        cgpa += hash.get(i);
                        num1++;
                    }
                }
                cgpa = cgpa/num1;
                System.out.println("The CGPA of the student is: ");
                System.out.println(cgpa);
            }
        }
    }
    public void get_grades(ArrayList<student> arr, HashMap<courses, Float> hash, String name, String course_name){
        boolean flag1 = true; boolean flag2 = true;
        for (student c: arr){
            if (c.getName().equals(name)){
                flag1 = false;
                for(courses i : hash.keySet()){
                    boolean a = c.getCompleted_courses().contains(i);
                    if(i.getcourse_name().equals(course_name) && a){
                        System.out.println(hash.get(i));
                        flag2 = false;
                    }
                }
            }
        }
        if(flag1){
            System.out.println("The student doesn't exist");
            return;
        }
        if(flag2){
            System.out.println("The student has not completed this course yet.");
        }
    }
    public void change_completed_grades(ArrayList<student> arr, HashMap<courses, Float> hash, String name, String course_name){
        boolean flag1 = true; boolean flag2 = true; boolean flag3 = true;
        for (student c: arr){
            if (c.getName().equals(name)){
                flag1 = false;
                System.out.println("Would you like to change a backlog or update a passed course (1 for backlog, 2 for passed course) --> ");
                int a = sc.nextInt();
                if (a==1){
                    for(courses i : hash.keySet()){
                        if(hash.get(i)<4 && i.getcourse_name().equals(course_name)){
                            hash.replace(i, sc.nextFloat());
                            flag2 = false;
                        }
                    }
                }
                else if (a==2){
                    for(courses i : hash.keySet()){
                        if(hash.get(i)>=4 && i.getcourse_name().equals(course_name)){
                            hash.replace(i, sc.nextFloat());
                            flag3 = false;
                        }
                    }
                }
            }
        }
        if(flag1){
            System.out.println("Student not found.");
            return;
        }
        if(flag2 && flag3){
            System.out.println("The course wasn't found.");
        }
    }
    public void renew_grades_lists(ArrayList<student> arr, HashMap<courses, Float> hash, String name){
        for (student c: arr){
            if(c.getName().equals(name)){
                c.getCompleted_backlog_courses().clear();
                for(courses i : hash.keySet()){
                    if(hash.get(i)<4){
                        c.getCompleted_backlog_courses().add(i);
                    }
                }
                c.getCompleted_courses().clear();
                for(courses i : hash.keySet()){
                    if(hash.get(i)>=4){
                        c.getCompleted_courses().add(i);
                    }
                }
            }
        }
    }
    public void set_grades(ArrayList<student> arr, HashMap<courses, Float> hash, String name, String course_name){
        boolean flag1 = true; boolean flag2 = true;
        for (student c: arr){
            if (c.getName().equals(name)){
                flag1 = false;
                for(courses i: hash.keySet()){
                    if(i.getcourse_name().equals(course_name)){
                        flag2 = false;
                        System.out.println("Enter the new CGPA --> ");
                        float a = sc.nextFloat();
                        hash.replace(i, a);
                        if(a >= 4){
                            c.getCompleted_courses().add(i);
                        }
                        else{
                            c.getCompleted_backlog_courses().add(i);
                        }
                    }
                }
            }
        }
        if(flag1){
            System.out.println("Student doesn't exist. ");
            return;
        }
        if(flag2){
            System.out.println("Course doesn't exist. ");
        }
    }
    public void change_semester(ArrayList<student> arr, HashMap<courses, Float> hash, String name){
        boolean flag = false;
        boolean flag1 = true;
        for (student c: arr){
            if(c.getName().equals(name)){
                flag1 = false;
                for(courses i: hash.keySet()){
                    if(hash.get(i)>=4){
                        flag = true;
                    }
                }
                if (flag){
                    c.setCurrent_semester(c.getCurrent_semester() + 1);
                    System.out.println("The semester has been changed successfully, the current semester is: " + c.getCurrent_semester());
                    for(courses i: hash.keySet()){
                        if(hash.get(i) >= 4){
                            c.getCompleted_courses().add(i);
                        }
                        else{
                            c.getCompleted_backlog_courses().add(i);
                        }
                    }
                    c.getRegistered_courses().clear();
                }
                else{
                    System.out.println("He cannot be promoted to the next semester! ");
                }
            }
        }
        if(flag1){
            System.out.println("The student doesn't exist");
        }
    }
    public void assign_professor(ArrayList<professor> arr, ArrayList<courses> arr1, String name, String course_name){
        boolean flag1 = true; boolean flag2 = true;
        for (professor p: arr){
            if(p.getName().equals(name)){
                flag1 = false;
                if(p.getCourses_under().size()<2){
                    for (courses c: arr1){
                        if (c.getcourse_name().equals(course_name)){
                            flag2 = false;
                            p.getCourses_under().add(c);
                            c.setprofessor_name(p.getName());
                        }
                    }
                }
                else{
                    System.out.println("The professor already has the maximum number of courses! ");
                    return;
                }
            }
        }
        if(flag1){
            System.out.println("Professor doesn't exist! ");
            return;
        }
        if(flag2){
            System.out.println("The course doesn't exist! ");
        }
    }
    public void view_complaint(ArrayList<student> arr, String name){
        boolean flag = true;
        for (student s: arr){
            if (s.getName().equals(name)){
                flag = false;
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
        if(flag){
            System.out.println("Student doesn't exist! ");
        }
    }
    public void resolution (ArrayList<student> arr, String name){
        boolean flag = true;
        for (student s: arr) {
            if (s.getName().equals(name)) {
                flag = false;
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
        if(flag){
            System.out.println("Student doesn't exist! ");
        }
    }
    public void delete_student_complaints(ArrayList<student> arr, String name){
        boolean flag = true;
        for (student s: arr) {
            if (s.getName().equals(name)) {
                flag = false;
                if (s.getStudent_complaints().isEmpty()) {
                    System.out.println("There are no complaints from this student. ");
                }
                else {
                    s.getStudent_complaints().removeIf(d -> Objects.equals(d.getStatus(), "Resolved"));
                }
            }
        }
        if(flag){
            System.out.println("Student doesn't exist! ");
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
