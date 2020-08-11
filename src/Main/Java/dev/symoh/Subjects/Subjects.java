package dev.symoh.Subjects;

import dev.symoh.Database.databaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Subjects implements SubjectInterface {
    public String subjectId;
    public String subjectName;

    Connection connection;
    public List<String> subjectidList =new ArrayList<>();
    public List<String> subjectNameList =new ArrayList<>();
    Scanner scanner;

    public void setSubjectId(String subjectId) {
        this.subjectId=subjectId;
    }
    public String getSubjectId() {
        return this.subjectId;
    }
    //setter fo student name
    public String getSubjectName() {
        return this.subjectName;
    }
    //getter fo student name
    public void setSubjectName(String subjectName) {
        this.subjectName=subjectName;
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
        try {
            databaseConnection databaseConnection=new databaseConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("insert into subjects(reg,name)VALUES (?,?)");
            preparedStatement.setString(1,this.getSubjectId());
            preparedStatement.setString(2,this.getSubjectName());
            databaseConnection.executeUpdate(preparedStatement);

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //deletes certain student
    @Override
    public void delete() {
        System.out.println("enter the subject id of the subject you want to delete");
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
        try {
            databaseConnection databaseConnection=new databaseConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("DELETE  FROM subject WHERE id=?");
            preparedStatement.setString(1,this.getSubjectId());
            databaseConnection.executeUpdate(preparedStatement);
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
        try {
            databaseConnection databaseConnection=new databaseConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM subjects");
            ResultSet resultset=databaseConnection.executeQuery(preparedStatement);
            while (resultset.next()){
                System.out.println(resultset.getString(1)+resultset.getString(2));
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        /*while (iterator.hasNext()&&iterator1.hasNext()){
            System.out.println("student reg:"+iterator.next()+" "+"student name:"+iterator1.next());
        }*/
    }

}
