package Java;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        courses c11 = new courses("IP", "CSE_101", 1,"Bijendra Nath Jain", 4, "Python");
        courses c12 = new courses("DC", "ECE_101", 1, "Pravesh Biyani", 4, "Resistors, Flip-flops");
        courses c13 = new courses("LA", "MTH_101", 1, "Samresh Chatterji", 4, "Matrices, Vector Fields");

        courses c21 = new courses("BE", "ECE_102", 2, "Tamaam Tillo", 4, "Flip-flops, Electrical Circuits");
        courses c22 = new courses("DSA", "CSE_102", 2, "Ojaswa Sharma", 4, "Algorithms, Time complexity");
        courses c23 = new courses("PNS", "MTH_201", 2, "Subhajit Ghosechowdhary", 4, "Probability and Statistics");

        ArrayList<courses> available_courses = new ArrayList<courses>() {{
            add(c11); add(c12); add(c13); add(c21); add(c22); add(c23);
        }};

        ArrayList<student> total_students = new ArrayList<student>();
        ArrayList<professor> total_professors = new ArrayList<professor>();
        ArrayList<admin> admins = new ArrayList<admin>();

        boolean y = true;

        while (y){
            System.out.println("Enter --> \n1 - Login \n2 - Sign Up \n3 - Exit");
            int x = sc.nextInt();
            if (x == 1){
                System.out.println("Enter the number: \n1) Student \n2) Professor \n3) Admin \n4) Exit");
                int z = sc.nextInt();

                boolean flag1 = false;
                boolean flag2 = false;
                System.out.print("Enter Email: ");
                String eml = sc.next();
                if (total_students.isEmpty() && z==1){
                    System.out.println("Email does not exist! ");
                    continue;
                }
                if (total_professors.isEmpty() && z==2){
                    System.out.println("Email does not exist! ");
                    continue;
                }
                for (student s: total_students){
                    if (s.getEmail().equals(eml)){
                        flag1= true;
                        break;
                    }
                }
                for (professor p: total_professors){
                    if (p.getEmail().equals(eml)){
                        flag2 = true;
                        break;
                    }
                }
                if(!flag1 && !flag2 && admins.isEmpty()){
                    System.out.println("Email does not exist! ");
                    continue;
                }
                if (z==1){
                    System.out.print("Enter the password: ");
                    String passw = sc.next();
                    for (student c: total_students){
                        if (c.getEmail().equals(eml) && c.getPassword().equals(passw)){
                            System.out.println("You have logged in!");
                            System.out.println("Enter --> \n1) ");
                        }
                    }
                }
                else if(z==2){
                    System.out.print("Enter the password: ");
                    String passw = sc.next();
                    for (professor c: total_professors){
                        if (c.getEmail().equals(eml) && c.getPassword().equals(passw)){
                            System.out.println("You have logged in!");
                        }
                    }
                }
                else if(z==3){
                    System.out.print("Enter the password: ");
                    String passw = sc.next();
                    for(admin c: admins){
                        if(c.getAdmin_password().equals(passw)){
                            System.out.println("You have logged in! ");
                        }
                    }
                }
                else if(z==4){
                    break;
                }
                else{
                    System.out.println("Please choose the correct option! ");
                }
            }
            else if (x == 2) {
                boolean flag = true;
                System.out.print("Enter new Email: ");
                String eml = sc.next();

                for (student s: total_students){
                    if (s.getEmail().equals(eml)){
                        System.out.println("Email already exists! ");
                        flag = false;
                    }
                }
                for (professor p: total_professors){
                    if (p.getEmail().equals(eml)){
                        System.out.println("Email already exists! ");
                        flag = false;
                    }
                }
                if (!flag){
                    continue;
                }
                System.out.println("Enter the number: \n1) Student \n2) Professor \n3) Admin \n4) Exit");
                int z = sc.nextInt();
                if(z == 1){
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("\nEnter new Password: ");
                    String passw = sc.next();
                    System.out.print("\nEnter roll number: ");
                    int roll_no = sc.nextInt();
                    if(total_students.size()<3){
                        student stu1 = new student(eml, passw, name, roll_no);
                        total_students.add(stu1);
                        System.out.println("You have successfully signed up!");
                    }
                    System.out.println();
                }
                else if (z == 2) {
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("\nEnter new Password: ");
                    String passw = sc.next();
                    if(total_professors.size()<2){
                        professor prof1 = new professor(eml, passw, name);
                        total_professors.add(prof1);
                        System.out.println("You have successfully signed up!");
                    }
                    System.out.println();
                }
                else if (z == 3) {

                    admin admin1 = new admin(eml);
                    if(!admins.isEmpty()){
                        System.out.println("Admin already exists! ");
                    }
                    else{
                        System.out.println("New Admin has been successfully added! ");
                        admins.add(admin1);
                    }
                }
                else if (z == 4) {
                    break;
                }
                else {
                    System.out.println("Please choose a correct option! ");
                }

            }
            else if(x==3){
                System.out.println("Thank you for using ERP");
                break;
            }
            else{
                System.out.println("Please Enter the correct command! ");
            }
        }



    }
}