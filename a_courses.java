package Java;
import java.util.Scanner;
public class a_courses extends courses{
    private void setstudentgrade(s_courses student){
        Scanner sc = new Scanner(System.in);
        student.GPA = sc.nextInt();
    }
    private void setstudentcredit(s_courses student){
        Scanner sc = new Scanner(System.in);
        student.credits = sc.nextInt();
    }

}
