package dev.symoh.students;

import dev.symoh.Database.databaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Students implements StudentInterface {
    public String sId;
    public String sName;
    private Connection connection;

    public List<String> stuId =new ArrayList<>();
    public List<String> stuName =new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public Students(List<String> stuId, List<String> stuName) {
        this.stuId = stuId;
        this.stuName = stuName;
    }

    public Students() {
    }

    //setter fo student reg
    public String getsId() {
        return this.sId;
    }
    //getter fo student reg
    public void setsId(String sId) {
        this.sId=sId;
        stuId.add(sId);

    }
    //setter fo student name
    public String getsName() {
        return this.sName;
    }
    //getter fo student name
    public void setsName(String sName) {
        this.sName=sName;
        stuName.add(sName);
    }
    //changes data written to collection
    @Override
    public String toString() {
        return this.getsId()+" "+this.getsName();
    }
    //adds new student
    @Override
    public void add() {
        //Students students1=new Students();
        System.out.println("enter the registration of the student");
        setsId(scanner.nextLine());
        System.out.println("enter the name of the student");
        setsName(scanner.nextLine());
        //students.add(students1);
        System.out.println("student added successfully");
        try {
            databaseConnection databaseConnection=new databaseConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("insert into students(reg,name)VALUES (?,?)");
            preparedStatement.setString(1,this.getsId());
            preparedStatement.setString(2,this.getsName());
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
        System.out.println("enter the reg no of the student you want to delete");
        Iterator iterator=stuId.iterator();
        Iterator iterator1=stuName.iterator();
        int i=0;
        while (iterator.hasNext()&&iterator1.hasNext()){
            System.out.println(i+". "+iterator.next()+" "+iterator1.next());
            i++;
        }
        int j=scanner.nextInt();
        stuId.remove(j);
        stuName.remove(j);
        try {
            databaseConnection databaseConnection=new databaseConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("DELETE  FROM students WHERE id=?");
            preparedStatement.setString(1,this.getsId());
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
        if(stuId.isEmpty()){
            System.out.println("students list is empty");
        }
        Iterator iterator=stuId.iterator();
        Iterator iterator1=stuName.iterator();
        while (iterator.hasNext()&&iterator1.hasNext()){
            System.out.println("student reg:"+iterator.next()+" "+"student name:"+iterator1.next());
        }
        try {
            databaseConnection databaseConnection=new databaseConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM students");
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
    }
}
