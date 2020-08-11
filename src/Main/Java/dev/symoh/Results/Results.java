package dev.symoh.Results;

import dev.symoh.Database.databaseConnection;
import dev.symoh.students.Students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Results extends Students implements ResultsInterface{
    //innitialize variables
    public String sid;
    public String name;
    public String subject;
    public String teacherName;
    public double score;
    Connection connection;
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
            try {
                databaseConnection databaseConnection=new databaseConnection();

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
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
        try {
            databaseConnection databaseConnection=new databaseConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("insert into subjects(reg,name,subject,teacher_name,score)VALUES (?,?,?,?,?)");
            preparedStatement.setString(1,this.getsId());
            preparedStatement.setString(2,this.getName());
            preparedStatement.setString(3,this.getSubject());
            preparedStatement.setString(4,this.getTeacherName());
            preparedStatement.setString(5, String.valueOf(this.getScore()));
            databaseConnection.executeUpdate(preparedStatement);

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
        try {
            databaseConnection databaseConnection=new databaseConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("DELETE  FROM results WHERE id=?");
            preparedStatement.setString(1,this.getsId());
            databaseConnection.executeUpdate(preparedStatement);
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("results deleted successfully");
    }
//returns all results
    @Override
    public void view() {
        if(results.isEmpty()){
            System.out.println("results list is empty");
        }
        try {
            databaseConnection databaseConnection=new databaseConnection();

            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM results");
            ResultSet resultset=databaseConnection.executeQuery(preparedStatement);
            while (resultset.next()){
                System.out.println(resultset.getString(1)+resultset.getString(2)+resultset.getString(3)+resultset.getString(4+resultset.getString(5)+resultset.getString(6)));
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        /*Iterator iterator=results.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/

    }
}
