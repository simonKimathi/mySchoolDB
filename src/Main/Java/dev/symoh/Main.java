package dev.symoh;

import java.util.Collections;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        //initialize variables
        Scanner scanner=new Scanner(System.in);
        //create instances of class
        Students students=new Students();
        Results results=new Results();
        Teachers teachers=new Teachers();
        System.out.println("welcome to my school manager \n****************************");

        //start a do while loop to keep program running until user decides to exit
        int li;
        do{
            System.out.println("select what data you want to manage\n" +
                    "1. students list \n" +
                    "2. teachers list \n" +
                    "3. results\n" +
                    "4. exit");

            li=scanner.nextInt();
            int li1;
            if(li==1){
                do { //a do while loop to keep user managing students record until he decides to go back to main menu
                    System.out.println("select the operation you want to do on students data\n" +
                            "1. add student \n" +
                            "2. view student \n" +
                            "3. delete student\n" +
                            "4. back");
                    li1=scanner.nextInt();

                    if(li1==1){
                        students.add(); //calls method add from student class
                    }
                    else if (li1==2){
                        students.view(); //calls method view from student class
                    }
                    else if (li1==3) {
                        students.delete(); //calls method delete from student class
                    }
                } while (li1==1||li1==2||li1==3);
            }
            else if(li==2){
                do { //a do while loop to keep user managing teachers record until he decides to go back to main menu
                    System.out.println("select the operation you want to do on teachers  data\n" +
                            "1. add teacher \n" +
                            "2. view teachers \n" +
                            "3. delete teacher\n" +
                            "4. back");
                    li1=scanner.nextInt();

                    if(li1==1){
                        teachers.add(); //calls method add from teachers class
                    }
                    else if (li1==2){
                        teachers.view(); //calls method view from teachers class
                    }
                    else if (li1==3) {
                        teachers.delete(); //calls method delete from teachers class
                    }
                } while (li1==1||li1==2||li1==3);
            }
            else if (li==3){
                do { //a do while loop to keep user managing results record until he decides to go back to main menu
                    System.out.println("select the operation you want to do on results  data\n" +
                            "1. add results \n" +
                            "2. view results \n" +
                            "3. delete results\n" +
                            "4. back");
                    li1=scanner.nextInt();

                    if(li1==1){
                        //i implemented add method of results class here so as to use data in other instances of classes created in this class
                        //enter results
                        boolean present;
                        String i;
                        do {
                            System.out.println("enter student registration number");
                            i=scanner.nextLine();
                            //check if the student is present in the students list
                            present = students.stuId.contains(i);
                        } while (!present);
                        results.setSid(i);
                        System.out.println("enter student name");
                        results.setName(scanner.nextLine());
                        System.out.println("enter the subject");
                        results.setSubject(scanner.nextLine());
                        System.out.println("enter teacher name");
                        results.setTeacherName(scanner.nextLine());
                        System.out.println("enter the score");
                        results.setScore(scanner.nextDouble());
                        //add all data to array list using tostring method
                        results.results.add(results);
                        System.out.println("results added successfully");
                    }
                    else if (li1==2){
                        results.view(); //calls method view from results class
                    }
                    else if (li1==3) {
                        results.delete(); //calls method delete from student class
                    }
                    else {
                        continue;
                    }
                } while (li1==1||li1==2||li1==3);
            }
            else {
                System.out.println("Thank you for using my program");
            }
        }
        while(li==1||li==2||li==3);


    }
}
