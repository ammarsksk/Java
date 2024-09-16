package Java;

import java.util.ArrayList;

public class courses {
    private String course_name;
    private String course_code;
    private int GPA;
    private int credits;
    private String syllabus;
    private boolean pass_status;
    private int semester;
    private String professor_name;
    private String prereqs;
    private ArrayList<String> days;
    private int slot;
    private String locations;
    private ArrayList<student> enrolled_students;
    private int enrollment_limit;

    public courses(String course_name, String course_code, int semester, String professor_name, int credits, String syllabus) {
        this.course_name = course_name;
        this.course_code = course_code;
        this.semester = semester;
        this.professor_name = professor_name;
        this.credits = credits;
        this.syllabus = syllabus;
    }

    public void setlocations(String locations) {
        this.locations = locations;
    }

    public void setslot(int slot) {
        this.slot = slot;
    }

    public void setdays(ArrayList<String> days) {
        this.days = days;
    }

    public void setprereqs(String prereqs) {
        this.prereqs = prereqs;
    }

    public void setprofessor_name(String professor_name) {
        this.professor_name = professor_name;
    }

    public void setsemester(int semester) {
        this.semester = semester;
    }

    public void setpass_status(boolean pass_status) {
        this.pass_status = pass_status;
    }

    public void setsyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public void setcredits(int credits) {
        this.credits = credits;
    }

    public void setGPA(int GPA) {
        this.GPA = GPA;
    }

    public void setcourse_name(String course_name) {
        this.course_name = course_name;
    }

    public void setcourse_code(String course_code) {
        this.course_code = course_code;
    }

    public boolean ispass_status() {
        return pass_status;
    }

    public String getsyllabus() {
        return syllabus;
    }

    public String getlocations() {
        return locations;
    }

    public int getslot() {
        return slot;
    }

    public ArrayList<String> getdays() {
        return days;
    }

    public String getprereqs() {
        return prereqs;
    }

    public String getprofessor_name() {
        return professor_name;
    }

    public int getsemester() {
        return semester;
    }

    public int getcredits() {
        return credits;
    }

    public int getGPA() {
        return GPA;
    }

    public String getcourse_code() {
        return course_code;
    }

    public String getcourse_name() {
        return course_name;
    }

    public int getEnrollment_limit() {
        return enrollment_limit;
    }

    public void setEnrollment_limit(int enrollment_limit) {
        this.enrollment_limit = enrollment_limit;
    }

    public ArrayList<student> getEnrolled_students() {
        return enrolled_students;
    }

    public void setEnrolled_students(ArrayList<student> enrolled_students) {
        this.enrolled_students = enrolled_students;
    }
}
