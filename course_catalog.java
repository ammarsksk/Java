package Java;
import java.util.ArrayList;
import java.util.HashMap;

public interface course_catalog {
    public void calculateSGPA(HashMap<courses, Float> hash, int semester);
    public void calculateCGPA(HashMap<courses, Float> hash);
    public void dropcourses(ArrayList<courses> arr, String name, student s);
    public void getregisteredcourses(ArrayList<courses> arr);
    public void getavailablecourses(ArrayList<courses> arr, HashMap<courses, Float> hash, int semester);
}
