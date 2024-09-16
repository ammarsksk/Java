package Java;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        courses c11 = new courses("IP", "CSE_101", 1,"Bijendra Nath Jain", 4, "Python");
        courses c12 = new courses("DC", "ECE_101", 1, "Pravesh Biyani", 4, "Resistors, Flip-flops");
        courses c13 = new courses("LA", "MTH_101", 1, "Samresh Chatterji", 4, "Matrices, Vector Fields");

        courses c21 = new courses("BE", "ECE_102", 2, "Tamaam Tillo", 4, "Flip-flops, Electrical Circuits");
        courses c22 = new courses("DSA", "CSE_102", 2, "Ojaswa Sharma", 4, "Algorithms, Time complexity");
        courses c23 = new courses("PNS", "MTH_201", 2, "Subhajit Ghosechowdhary", 4, "Probability and Statistics");

        ArrayList<courses> available_courses = new ArrayList<courses>(6) {{
            add(c11); add(c12); add(c13); add(c21); add(c22); add(c23);
        }};




    }
}