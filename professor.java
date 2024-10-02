package Java;
import java.util.ArrayList;
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
                System.out.println("Enter the syllabus: ");
                c.setsyllabus(sc.nextLine());
                System.out.println("Syllabus entered successfully.");
            }
        }
    }
    public void view_courses(ArrayList<courses> arr){
        if (arr.isEmpty()){
            System.out.println("There are no courses under this prof.");
            return;
        }
        for (courses c: arr){
                System.out.print("The course name, course code and course syllabus is: " + c.getcourse_name() + " - " + c.getcourse_code() + " - " +  c.getsyllabus());
        }
    }

    public void update_timings(ArrayList<courses> arr, String name){
        if (arr.isEmpty()){
            System.out.println("There are no courses under this prof.");
            return;
        }
        for (courses c: arr){
            if (c.getcourse_name().equals(name)){
                System.out.print("Enter the slot number you want to change the selected course to: ");
                c.setslot(sc.nextInt());
                System.out.println("Slot number changed successfully");
            }
        }
    }
    public void update_days(ArrayList<courses> arr, String name){
        if (arr.isEmpty()){
            System.out.println("There are no courses under this prof.");
            return;
        }
        for (courses c: arr){
            if (c.getcourse_name().equals(name)){
                System.out.println("These are the original days of the course: ");
                for (String i: c.getdays()){
                    System.out.print(i + " ");
                }
                System.out.println();
                System.out.print("Enter the 2 days which you want to put for your course: ");
                for(int i = 0; i<2; i++){
                    c.getdays().set(i, sc.next());
                }
            }
        }
    }

    public void update_enrollment_limit(ArrayList<courses> arr, String name){
        if (arr.isEmpty()){
            System.out.println("There are no courses under this prof.");
            return;
        }
        for (courses c: arr){
            if (c.getcourse_name().equals(name)){
                System.out.print("Enter the new enrollment limit for this course. ");
                c.setEnrollment_limit(sc.nextInt());
                System.out.println("Enrollment limit changed successfully");
            }
        }
    }
    public void update_credits(ArrayList<courses> arr, String name){
        if (arr.isEmpty()){
            System.out.println("There are no courses under this prof.");
            return;
        }
        for (courses c: arr){
            System.out.print("Enter the new credits for this course. ");
            if (c.getcourse_name().equals(name)){
                c.setcredits(sc.nextInt());
                System.out.print("Credits changed successfully. ");
            }
        }
    }
    public void update_office_hours(ArrayList<courses> arr, String name){
        for (courses c: arr){
            if (c.getcourse_name().equals(name)){
                System.out.print("Enter the new office hours for this course. ");
                c.setOffice_hours(sc.next());
                System.out.print("Office hours changed successfully. ");
            }
        }
    }
    public void update_prereqs(ArrayList<courses> arr, String name){
        if (arr.isEmpty()){
            System.out.println("There are no courses under this prof.");
            return;
        }
        for (courses c: arr){
            if (c.getcourse_name().equals(name)){
                System.out.print("Enter new prereqs for this course. ");
                c.setprereqs(sc.next());
                System.out.print("Prereqs changed successfully. ");
            }
        }
    }
    public void view_enrolled_students(ArrayList<courses> arr, String name){
        if (arr.isEmpty()){
            System.out.println("There are no courses under this prof.");
            return;
        }
        for (courses c: arr){
            if (c.getcourse_name().equals(name)){
                if (c.getEnrolled_students().isEmpty()){
                    System.out.println("There are no students under the course which you teach.");
                    return;
                }
                for (student d: c.getEnrolled_students()){
                    System.out.println("The student name and roll number is: " + d.getName() + " - " + d.getRoll_no());
                }
            }
        }
    }
    public void view_feedback(ArrayList<courses> arr, String course_name){
        boolean flag = true;
        if(arr.isEmpty()){
            System.out.println("There are no courses under this prof! ");
            return;
        }
        for (courses c: arr){
            if(c.getcourse_name().equals(course_name)){
                flag = false;
                if(c.getInt_feedback().isEmpty() && c.getString_feedback().isEmpty() && c.getDouble_feedback().isEmpty()){
                    System.out.println("There are no feedbacks! ");
                    return;
                }
                for(Feedback<Integer> T: c.getInt_feedback()){
                    System.out.println("Rating (out of 5) : " + T.getFeedback());
                }
                for(Feedback<String> T: c.getString_feedback()){
                    System.out.println("Comment: " + T.getFeedback());
                }
                for(Feedback<Double> T: c.getDouble_feedback()){
                    System.out.println("Rating (out of 5.0): " + T.getFeedback());
                }
            }
        }
        if(flag){
            System.out.println("This course is not under this prof! ");
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
