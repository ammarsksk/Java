package Java;

import java.util.Scanner;

public class p_courses extends courses{
    private void setstudentsyllabus(s_courses student){
        Scanner sc = new Scanner(System.in);
        student.syllabus = sc.nextLine();
    }

}
