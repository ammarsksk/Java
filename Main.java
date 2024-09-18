package Java;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        courses c11 = new courses("IP", "CSE_101", 1,"Bijendra Nath Jain", 4, "Python", "C101", "NULL", 1, 600);
        courses c12 = new courses("DC", "ECE_101", 1, "Pravesh Biyani", 4, "Resistors, Flip-flops", "C102", "NULL", 2, 600);
        courses c13 = new courses("LA", "MTH_101", 1, "Samresh Chatterji", 4, "Matrices, Vector Fields", "C201", "NULL", 3, 600);
        c11.setdays(c11.getdays(), "MON");
        c11.setdays(c11.getdays(), "TUE");
        c12.setdays(c12.getdays(), "THU");
        c12.setdays(c12.getdays(), "FRI");
        c13.setdays(c13.getdays(), "WED");
        c13.setdays(c13.getdays(), "THU");
        courses c21 = new courses("BE", "ECE_102", 2, "Tamaam Tillo", 4, "Flip-flops, Electrical Circuits", "C01", "DC", 2, 600);
        courses c22 = new courses("DSA", "CSE_102", 2, "Ojaswa Sharma", 4, "Algorithms, Time complexity", "C11","IP", 4, 600);
        courses c23 = new courses("PNS", "MTH_201", 2, "Subhajit Ghosechowdhary", 4, "Probability and Statistics", "B003", "LA", 3, 600);
        c21.setdays(c21.getdays(), "MON");
        c21.setdays(c21.getdays(), "TUE");
        c22.setdays(c22.getdays(), "THU");
        c22.setdays(c22.getdays(), "FRI");
        c23.setdays(c23.getdays(), "WED");
        c23.setdays(c23.getdays(), "THU");
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
                            while(true){
                                System.out.print("Do you want to continue y/n: ");
                                String f = sc.next();
                                if (Objects.equals(f, "y") || Objects.equals(f, "Y")){
                                    System.out.println("Enter --> \n1)Get registered courses \n2)Get available courses (for your current semester) \n3)Calculate CGPA \n4)Calculate SGPA (for any completed semester) \n5)Apply for courses \n6)Drop courses \n7)Get course code \n8)Get prof name \n9)Get course credits \n10)Get course prerequisites \n11)Get weekly schedule (for particular course) \n12)Get the current semester you are on \n13)Get the completed passed and failed courses. \n14)Get course syllabus. \n15)Register a complaint \n16)View all your complaints and their status. ");
                                    int s = sc.nextInt();
                                    if(s==1){
                                        c.getregisteredcourses(c.getRegistered_courses());
                                    }
                                    else if(s==2){
                                        c.getavailablecourses(available_courses, c.getCurrent_semester());
                                        System.out.println();
                                    }
                                    else if(s==3){
                                        c.calculateCGPA(c.getCompleted_courses(), c.getCurrent_semester());
                                        System.out.println();
                                    }
                                    else if(s==4){
                                        System.out.print("Enter semester number: ");
                                        int p = sc.nextInt();
                                        c.calculateSGPA(c.getCompleted_courses(), c.getCompleted_backlog_courses(), p);
                                        System.out.println();
                                    }
                                    else if(s==5){
                                        c.make_registered_courses(available_courses, c.getRegistered_courses(), c, c.getCurrent_semester());
                                        System.out.println();
                                    }
                                    else if(s==6){
                                        System.out.println("Drop options are -->: ");
                                        for(courses o: c.getRegistered_courses()){
                                            System.out.println(o.getcourse_name());
                                        }
                                        System.out.print("Enter course name: ");
                                        String h = sc.next();
                                        c.dropcourses(c.getRegistered_courses(),h, c);
                                    }
                                    else if(s==7){
                                        System.out.print("Enter course name: ");
                                        String h = sc.next();
                                        c.getcoursecode(c.getRegistered_courses(),h);
                                    }
                                    else if(s==8){
                                        System.out.print("Enter course name: ");
                                        String h = sc.next();
                                        c.getprofname(c.getRegistered_courses(),h);
                                    }
                                    else if(s==9){
                                        System.out.print("Enter course name: ");
                                        String h = sc.next();
                                        c.getcoursecredits(c.getRegistered_courses(),h);
                                    }
                                    else if(s==10){
                                        System.out.print("Enter course name: ");
                                        String h = sc.next();
                                        c.getcourseprereqs(c.getRegistered_courses(),h);
                                    }
                                    else if(s==11){
                                        System.out.print("Enter course name: ");
                                        String h = sc.next();
                                        c.get_weekly_schedule(c.getRegistered_courses(),h);
                                    }
                                    else if(s==12){
                                        System.out.println(c.getCurrent_semester());
                                    }
                                    else if(s==13){
                                        c.get_completed_records(c.getCompleted_courses());
                                        c.get_completed_backlog_records(c.getCompleted_backlog_courses());
                                    }
                                    else if(s==14){
                                        System.out.print("Enter course name: ");
                                        String h = sc.next();
                                        c.get_course_syllabus(c.getRegistered_courses(),h);
                                    }
                                    else if(s==15){
                                        c.set_complaint(c.getStudent_complaints());
                                    }
                                    else if(s==16){
                                        c.view_complaints(c.getStudent_complaints());
                                    }
                                }
                                else if((Objects.equals(f, "n")) || Objects.equals(f, "N")){
                                    break;
                                }
                                else{
                                    System.out.println("Please enter the correct command");
                                }
                            }
                        }
                        else{
                            System.out.println("Enter correct password! ");
                        }
                    }
                }
                else if(z==2){
                    System.out.print("Enter the password: ");
                    String passw = sc.next();
                    for (professor c: total_professors){
                        if (c.getEmail().equals(eml) && c.getPassword().equals(passw)){
                            System.out.println("You have logged in!");
                            while(true) {
                                System.out.print("Do you want to continue y/n: ");
                                String f = sc.next();
                                if (Objects.equals(f, "y") || Objects.equals(f, "Y")) {
                                    System.out.println("Enter --> \n1)Change syllabus for a course \n2)Update timings for a particular course. \n3)Update the enrollment limit for a course \n4)Update the credits for a course \n5)Update the prerequisites for a course \n6)View enrolled students for a particular course, \n7)Update office hours for a particular course. \n8)Update the days of a course. \n9)View the courses under you. ");
                                    int s = sc.nextInt();
                                    if(s==1){
                                        System.out.print("Enter course name: ");
                                        String h = sc.next();
                                        c.change_syllabus(c.getCourses_under(), h);
                                    }
                                    else if(s==2){
                                        System.out.println("The possible slots to re-allot are --> \nSlot 1 = 9:30 - 11:00 \nSlot 2 = 11:00 - 12:30 \nSlot 3 = 13:00 - 14:30 \nSlot 4 = 14:30 - 16:00");
                                        System.out.print("Enter course name: ");
                                        String h = sc.next();
                                        c.update_timings(c.getCourses_under(), h);
                                    }
                                    else if (s==3){
                                        System.out.print("Enter course name: ");
                                        String h = sc.next();
                                        c.update_enrollment_limit(c.getCourses_under(), h);
                                    }
                                    else if(s==4){
                                        System.out.print("Enter course name: ");
                                        String h = sc.next();
                                        c.update_credits(c.getCourses_under(), h);
                                    }
                                    else if (s==5){
                                        System.out.print("Enter course name: ");
                                        String h = sc.next();
                                        c.update_prereqs(c.getCourses_under(), h);
                                    }
                                    else if (s==6){
                                        System.out.print("Enter course name: ");
                                        String h = sc.next();
                                        c.view_enrolled_students(c.getCourses_under(), h);
                                    }
                                    else if (s==7){
                                        System.out.print("Enter course name: ");
                                        String h = sc.next();
                                        c.update_office_hours(c.getCourses_under(), h);
                                    }
                                    else if (s==8){
                                        System.out.print("Enter course name: ");
                                        String h = sc.next();
                                        c.update_days(c.getCourses_under(), h);
                                    }
                                    else if (s==9){
                                        c.view_courses(c.getCourses_under());
                                        System.out.println();
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                        else{
                            System.out.println("Enter correct password! ");
                        }
                    }
                }
                else if(z==3){
                    System.out.print("Enter the password: ");
                    String passw = sc.next();
                    for(admin c: admins){
                        if(c.getAdmin_password().equals(passw)){
                            System.out.println("You have logged in! ");
                            while(true) {
                                System.out.print("Do you want to continue y/n: ");
                                String f = sc.next();
                                if (Objects.equals(f, "y") || Objects.equals(f, "Y")) {
                                    System.out.println("Enter --> \n1)View the course catalog \n2)Add a course to the course catalog \n3)Delete a course from the catalog. \n4)View student records \n5)Update student records \n6)Get CGPA and SGPA of a student \n7)Get grades of a particular course \n8)Change the grades of a course which is completed. \n9) Set the grades of an ongoing course \n10)Promote the student to the next semester. \n11)Assign a course to a professor. \n12)View the complaints for a student (in sorted order - oldest --> newest). \n13)Resolution for all the complaints of a student. \n14)Delete the complaints (after resolution)");
                                    int s = sc.nextInt();
                                    if (s==1){
                                        c.view_course_catalog(available_courses);
                                    }
                                    else if (s==2){
                                        System.out.println("Add the course_name, course_code, semester no., professor_name, credits allowed, syllabus, location, prereqs, slot, enrollment limit of the course respectively: ");
                                        String course_name = sc.next();
                                        String course_code = sc.next();
                                        int semester = sc.nextInt();
                                        String professor_name = sc.next();
                                        int credits = sc.nextInt();
                                        String syllabus = sc.nextLine();
                                        String locations = sc.next();
                                        String prereqs = sc.next();
                                        int slot = sc.nextInt();
                                        int enrollment_limit = sc.nextInt();
                                        courses c100 = new courses(course_name, course_code, semester, professor_name, credits, syllabus, locations, prereqs, slot, enrollment_limit);
                                        c.add_course_catalog(available_courses, c100);
                                    }
                                    else if (s==3){
                                        System.out.print("Enter the name of the course: ");
                                        String h = sc.next();
                                        c.delete_from_course_catalog(available_courses, total_students,total_professors, h);
                                    }
                                    else if (s==4){
                                        System.out.print("Enter the name of the student: ");
                                        String h = sc.next();
                                        c.view_student_records(total_students, h);
                                    }
                                    else if (s==5){
                                        System.out.print("Enter the name of the student: ");
                                        String h = sc.next();
                                        System.out.println("Choose what to change --> \n1)Name of the student \n2)Email of the student \n3)Password \n4)Roll number");
                                        int n = sc.nextInt();
                                        c.update_student_record(total_students, h, n);
                                    }
                                    else if (s==6){
                                        System.out.print("Enter the name of the student: ");
                                        String h = sc.next();
                                        System.out.print("Enter the semester: ");
                                        int r = sc.nextInt();
                                        c.get_CGPA_SGPA(total_students, h, r);
                                    }
                                    else if (s==7){
                                        System.out.print("Enter the name of the student: ");
                                        String h = sc.next();
                                        System.out.print("Enter the course name: ");
                                        String r = sc.next();
                                        c.get_grades(total_students, h, r);
                                    }
                                    else if (s==8){
                                        System.out.print("Enter the name of the student: ");
                                        String h = sc.next();
                                        System.out.print("Enter the course name: ");
                                        String r = sc.next();
                                        c.change_completed_grades(total_students, h, r);
                                        c.renew_grades_lists(total_students, h);
                                    }
                                    else if (s==9){
                                        System.out.print("Enter the name of the student: ");
                                        String h = sc.next();
                                        System.out.print("Enter the course name: ");
                                        String r = sc.next();
                                        c.set_grades(total_students, h, r);
                                    }
                                    else if (s==10){
                                        System.out.print("Enter the name of the student: ");
                                        String h = sc.next();
                                        c.change_semester(total_students, h);
                                    }
                                    else if (s==11){
                                        System.out.println("Do you want to add a new course or an existing course (1 for new, 2 for existing): ");
                                        int q = sc.nextInt();
                                        if(q == 1){
                                            System.out.println("Add the course_name, course_code, semester no., professor_name, credits allowed, syllabus, location, prereqs, slot, enrollment limit of the course respectively: ");
                                            String course_name = sc.next();
                                            String course_code = sc.next();
                                            int semester = sc.nextInt();
                                            String professor_name = sc.next();
                                            int credits = sc.nextInt();
                                            sc.nextLine();
                                            String syllabus = sc.nextLine();
                                            String locations = sc.next();
                                            String prereqs = sc.next();
                                            int slot = sc.nextInt();
                                            int enrollment_limit = sc.nextInt();
                                            courses c100 = new courses(course_name, course_code, semester, professor_name, credits, syllabus, locations, prereqs, slot, enrollment_limit);
                                            System.out.print("Enter the name of the professor: ");
                                            String h = sc.next();
                                            c.assign_professor(total_professors, c100, h);
                                        }
                                        else if(q == 2){
                                            System.out.print("Enter the name of the professor: ");
                                            String h = sc.next();
                                            System.out.print("Enter the name of the existing course: ");
                                            String g = sc.next();
                                            c.assign_professor(total_professors, available_courses, h, g);
                                        }
                                    }
                                    else if (s==12){
                                        System.out.print("Enter the name of the student: ");
                                        String h = sc.next();
                                        c.sort_complaints(total_students, h);
                                        c.view_complaint(total_students, h);
                                    }
                                    else if(s==13){
                                        System.out.print("Enter the name of the student: ");
                                        String h = sc.next();
                                        c.resolution(total_students, h);
                                    }
                                    else if (s==14){
                                        System.out.print("Enter the name of the student: ");
                                        String h = sc.next();
                                        c.delete_student_complaints(total_students, h);
                                    }
                                }
                                else {
                                    break;
                                }
                            }
                        }
                        else{
                            System.out.println("Enter correct password! ");
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