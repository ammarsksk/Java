package Java;

import java.util.ArrayList;

public class TA extends student implements TAxAdmin{
    private ArrayList<courses> TA_Courses = new ArrayList<courses>();

    public TA(String email, String password, String name, int roll_no) {
        super(email, password, name, roll_no);
    }
    public void get_courses(ArrayList<courses> arr){
        if (arr.isEmpty()){
            System.out.println("There are no courses managed by this TA.");
            return;
        }
        System.out.println("The following course(s) are managed by you --> ");
        for(courses c: arr){
            System.out.println(c.getcourse_name());
        }
    }
    public void get_students_under(ArrayList<courses> arr){
        if (arr.isEmpty()){
            System.out.println("No courses under this TA");
            return;
        }
        for(courses c: arr){
            if(c.getEnrolled_students().isEmpty()){
                System.out.println("No students have taken the course: " + c.getcourse_name());
                return;
            }
            System.out.println("The students under the course " + c.getcourse_name() + " are --> ");
            for (student s: c.getEnrolled_students()){
                System.out.println("Name: " + s.getName() + " Roll no: " + s.getRoll_no());
            }
        }
    }
    public void get_grades(ArrayList<student> arr, String name, String course_name){
        boolean flag1 = true; boolean flag2 = true;
        for (student c: arr){
            if (c.getName().equals(name)){
                flag1 = false;
                for(courses i : c.getStudent_sgpa().keySet()){
                    boolean a = c.getCompleted_courses().contains(i);
                    if(i.getcourse_name().equals(course_name) && a){
                        System.out.println(c.getStudent_sgpa().get(i));
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
    public void set_grades(ArrayList<student> arr, String name, String course_name){
        boolean flag1 = true; boolean flag2 = true;
        for (student c: arr){
            if (c.getName().equals(name)){
                flag1 = false;
                for(courses i: c.getStudent_sgpa().keySet()){
                    if(i.getcourse_name().equals(course_name)){
                        flag2 = false;
                        System.out.println("Enter the new CGPA --> ");
                        float a = sc.nextFloat();
                        c.getStudent_sgpa().put(i, a);
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
    public void change_completed_grades(ArrayList<student> arr, String name, String course_name){
        boolean flag1 = true; boolean flag2 = true; boolean flag3 = true;
        for (student c: arr){
            if (c.getName().equals(name)){
                flag1 = false;
                System.out.println("Would you like to change a backlog or update a passed course (1 for backlog, 2 for passed course) --> ");
                int a = sc.nextInt();
                if (a==1){
                    for(courses i : c.getStudent_sgpa().keySet()){
                        if(c.getStudent_sgpa().get(i)<4 && i.getcourse_name().equals(course_name)){
                            c.getStudent_sgpa().replace(i, sc.nextFloat());
                            flag2 = false;
                        }
                    }
                }
                else if (a==2){
                    for(courses i : c.getStudent_sgpa().keySet()){
                        if(c.getStudent_sgpa().get(i)>=4 && i.getcourse_name().equals(course_name)){
                            c.getStudent_sgpa().replace(i, sc.nextFloat());
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
    public void renew_grades_lists(ArrayList<student> arr, String name){
        for (student c: arr){
            if(c.getName().equals(name)){
                c.getCompleted_backlog_courses().clear();
                for(courses i : c.getStudent_sgpa().keySet()){
                    if(c.getStudent_sgpa().get(i)<4 && c.getStudent_sgpa().get(i) != 0){
                        c.getCompleted_backlog_courses().add(i);
                    }
                }
                c.getCompleted_courses().clear();
                for(courses i : c.getStudent_sgpa().keySet()){
                    if(c.getStudent_sgpa().get(i)>=4 && c.getStudent_sgpa().get(i) != 0){
                        c.getCompleted_courses().add(i);
                    }
                }
            }
        }
    }
    public ArrayList<courses> getTA_Courses() {
        return TA_Courses;
    }
    public void setTA_Courses(ArrayList<courses> TA_Courses) {
        this.TA_Courses = TA_Courses;
    }
}
