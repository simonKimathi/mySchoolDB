package dev.symoh.Teachers;

import dev.symoh.Database.databaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Teachers implements TeachersInterface {
    public String tId;
    public String tName;
    Connection connection;
    Scanner scanner=new Scanner(System.in);
    public List<Teachers> teacher=new ArrayList<>();
    //setter fo teachers id
    public String gettId() {
        return tId;
    }
    //getter fo teachers reg
    public void settId(String tId) {
        this.tId = tId;
    }
    //setter fo teachers name
    public String gettName() {
        return tName;
    }
    //getter fo teachers name
    public void settName(String tName) {
        this.tName = tName;
    }
//changes data written to collection
    @Override
    public String toString() {
        return "teacher id:"+this.gettId()+" "+"teacher name:"+this.gettName();
    }
// adds new teachers
    @Override
    public void add() {
        Teachers teachers=new Teachers();
        System.out.println("enter the Teacher ID");
        teachers.settId(scanner.nextLine());
        System.out.println("enter the name of the teacher");
        teachers.settName(scanner.nextLine());
        teacher.add(teachers);
        try {
            databaseConnection databaseConnection=new databaseConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("insert into teachers(reg,name)VALUES (?,?)");
            preparedStatement.setString(1,this.gettId());
            preparedStatement.setString(2,this.gettName());
            databaseConnection.executeUpdate(preparedStatement);

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("teacher added successfully");

    }
//deletes a certain teachers
    @Override
    public void delete() {
        System.out.println("enter the number of the teacher you want to delete");
        Iterator iterator=teacher.iterator();
        int i=0;
        while (iterator.hasNext()){
            System.out.println(i+". "+iterator.next());
            i++;
        }
        int j=scanner.nextInt();
        teacher.remove(j);
        try {
            databaseConnection databaseConnection=new databaseConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("DELETE  FROM teachers WHERE id=?");
            preparedStatement.setString(1,this.gettId());
            databaseConnection.executeUpdate(preparedStatement);
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("teacher deleted successfully");
    }
//returns all the teachers
    @Override
    public void view() {
        if(teacher.isEmpty()){
            System.out.println("teachers list is empty");
        }
        try {
            databaseConnection databaseConnection=new databaseConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM teachers");
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
        /*Iterator iterator=teacher.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/

    }
}
