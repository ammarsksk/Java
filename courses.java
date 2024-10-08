package Java;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class courses {
    private String course_name;
    private String office_hours;
    private String course_code;
    private int GPA;
    private int credits;
    private String syllabus;
    private boolean pass_status;
    private int semester;
    private String professor_name;
    private String prereqs;
    private ArrayList<String> days = new ArrayList<String>();
    private int slot;
    private String locations;
    private ArrayList<student> enrolled_students = new ArrayList<student>();
    private int enrollment_limit;
    LocalDateTime deadline = LocalDateTime.of(2024, 12, 31, 23, 59, 59);
    private ArrayList<Feedback<Integer>> int_feedback = new ArrayList<Feedback<Integer>>();
    private ArrayList<Feedback<String>> string_feedback = new ArrayList<Feedback<String>>();
    private ArrayList<Feedback<Double>> double_feedback = new ArrayList<Feedback<Double>>();

    public courses(String course_name, String course_code, int semester, String professor_name, int credits, String syllabus, String locations, String prereqs,int slot, int enrollment_limit) {
        this.course_name = course_name;
        this.course_code = course_code;
        this.semester = semester;
        this.professor_name = professor_name;
        this.credits = credits;
        this.syllabus = syllabus;
        this.locations = locations;
        this.prereqs = prereqs;
        this.slot = slot;
        this.enrollment_limit = enrollment_limit;


    }

    public void setlocations(String locations) {
        this.locations = locations;
    }

    public void setslot(int slot) {
        this.slot = slot;
    }

    public void setdays(ArrayList<String> days, String day) {
        boolean add = days.add(day);
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

    public String getOffice_hours() {
        return office_hours;
    }

    public void setOffice_hours(String office_hours) {
        this.office_hours = office_hours;
    }

    public ArrayList<Feedback<Integer>> getInt_feedback() {
        return int_feedback;
    }

    public void setInt_feedback(ArrayList<Feedback<Integer>> int_feedback) {
        this.int_feedback = int_feedback;
    }

    public ArrayList<Feedback<String>> getString_feedback() {
        return string_feedback;
    }

    public void setString_feedback(ArrayList<Feedback<String>> string_feedback) {
        this.string_feedback = string_feedback;
    }

    public ArrayList<Feedback<Double>> getDouble_feedback() {
        return double_feedback;
    }

    public void setDouble_feedback(ArrayList<Feedback<Double>> double_feedback) {
        this.double_feedback = double_feedback;
    }
}
