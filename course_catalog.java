package Java;
import java.util.ArrayList;

public interface course_catalog {
    public void calculateSGPA(ArrayList<courses> arr1,ArrayList<courses> arr2, int semester);
    public void calculateCGPA(ArrayList<courses> arr, int semester);
    public void dropcourses(ArrayList<courses> arr, String name, student s);
    public void getregisteredcourses(ArrayList<courses> arr);
    public void getavailablecourses(ArrayList<courses> arr, int semester);
}
