package dev.symoh.Results;

import dev.symoh.students.Students;

import java.util.*;

public class Results extends Students implements ResultsInterface{
    //innitialize variables
    public String sid;
    public String name;
    public String subject;
    public String teacherName;
    public double score;
    //create instances of class
    Students students=new Students();
    Scanner scanner=new Scanner(System.in);
    public List<Results> results=new ArrayList<>();
    //getter fo student id
    public String getSid() {
        return sid;
    }
    //setter fo student id
    public void setSid(String sid) {
        this.sid = sid;
    }
    //getter fo student name
    public String getName() {
        return name;
    }
    //setter fo student name
    public void setName(String name) {
        this.name = name;
    }
    //getter fo subject
    public String getSubject() {
        return subject;
    }
    //setter fo subject
    public void setSubject(String subject) {
        this.subject = subject;
    }
    //getter fo teachers name
    public String getTeacherName() {
        return teacherName;
    }
    //setter fo teachers name
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    //getter fo student score
    public double getScore() {
        return score;
    }
    //setter fo student score
    public void setScore(double score) {
        this.score = score;
    }
 //changes data written to collection
    @Override
    public String toString() {
        return "student reg:"+this.getSid()+" "+"student name:"+this.getName()+" "+"subject:"+this.getSubject()+" "+"teacher name:"+this.getTeacherName()+" "+"score:"+this.getScore();
    }
 //adds new result
    @Override
    public  void add() {
        boolean present;
        String i;
        do {
            System.out.println("enter student registration number");
            i=scanner.nextLine();
            //check if the student is present in the students list
            present = students.stuId.contains(i);
        } while (!present);
        setSid(i);
        System.out.println("enter student name");
        setName(scanner.nextLine());
        System.out.println("enter the subject");
        setSubject(scanner.nextLine());
        System.out.println("enter teacher name");
        setTeacherName(scanner.nextLine());
        System.out.println("enter the score");
        setScore(scanner.nextDouble());
        System.out.println("results added successfully");
    }
 //deletes a certain result
    @Override
    public void delete() {
        System.out.println("enter the number of result you want to delete");
        Iterator iterator=results.iterator();
        int i=0;
        while (iterator.hasNext()){
            System.out.println(i+". "+iterator.next());
            i++;
        }
        int j=scanner.nextInt();
        results.remove(j);
        System.out.println("results added successfully");
    }
//returns all results
    @Override
    public void view() {
        if(results.isEmpty()){
            System.out.println("results list is empty");
        }
        Iterator iterator=results.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
