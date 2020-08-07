package dev.symoh.Subjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Subjects implements SubjectInterface {
    public String subjectId;
    public String subjectName;

    public List<String> subjectidList =new ArrayList<>();
    public List<String> subjectNameList =new ArrayList<>();
    Scanner scanner;

    public void setSubjectId(String subjectId) {
        subjectidList.add(subjectId);
    }
    public String getSubjectId() {
        return String.valueOf(subjectidList);
    }
    //setter fo student name
    public String getSubjectName() {
        return String.valueOf(subjectNameList);
    }
    //getter fo student name
    public void setSubjectName(String subjectName) {
        subjectNameList.add(subjectName);
    }
    //changes data written to collection
    @Override
    public String toString() {
        return this.getSubjectId()+" "+this.getSubjectName();
    }
    //adds new student
    @Override
    public void add() {
        //Students students1=new Students();
        System.out.println("enter the registration of the student");
        setSubjectId(scanner.nextLine());
        System.out.println("enter the name of the student");
        setSubjectName(scanner.nextLine());
        //students.add(students1);
        System.out.println("student added successfully");
    }
    //deletes certain student
    @Override
    public void delete() {
        System.out.println("enter the number of the student you want to delete");
        Iterator iterator= subjectidList.iterator();
        Iterator iterator1= subjectNameList.iterator();
        int i=0;
        while (iterator.hasNext()&&iterator1.hasNext()){
            System.out.println(i+". "+iterator.next()+" "+iterator1.next());
            i++;
        }
        int j=scanner.nextInt();
        subjectidList.remove(j);
        subjectNameList.remove(j);
        System.out.println("student deleted successfully");
    }
    //returns all the students
    @Override
    public void view() {
        if(subjectidList.isEmpty()){
            System.out.println("students list is empty");
        }
        Iterator iterator= subjectidList.iterator();
        Iterator iterator1= subjectNameList.iterator();
        while (iterator.hasNext()&&iterator1.hasNext()){
            System.out.println("student reg:"+iterator.next()+" "+"student name:"+iterator1.next());
        }
    }

}
