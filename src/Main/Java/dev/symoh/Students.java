package dev.symoh;

import java.util.*;

public class Students implements StudentInterface {
    public String sId;
    public String sName;

    List<String> stuId =new ArrayList<>();
    List<String> stuName =new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    //setter fo student reg
    public String getsId() {
        return String.valueOf(stuId);
    }
    //getter fo student reg
    public void setsId(String sId) {
        stuId.add(sId);
    }
    //setter fo student name
    public String getsName() {
        return String.valueOf(stuName);
    }
    //getter fo student name
    public void setsName(String sName) {
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
    }
    //deletes certain student
    @Override
    public void delete() {
        System.out.println("enter the number of the student you want to delete");
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
        System.out.println("student deleted successfully");
    }
    //returns all the students
    @Override
    public void view() {
        Iterator iterator=stuId.iterator();
        Iterator iterator1=stuName.iterator();
        while (iterator.hasNext()&&iterator1.hasNext()){
            System.out.println("student reg:"+iterator.next()+" "+"student name:"+iterator1.next());
        }
    }
}
