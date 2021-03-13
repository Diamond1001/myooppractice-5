import java.sql.*;

public class Main {
    public static Connection connection = null;
    public static PreparedStatement pstmt = null;
    public static void main(String[] args) {
    emp emp = new emp();
    emp.getsetwork();
    emp.outpos();
    salary sal=new salary();
    sal.getsetsalary();
    sal.outsal();
    }
}
//new class
public class emp {
    public String[] work = new String[10];
    public int[] id=new int[10];
    public int i = 0;
    public String url = "jdbc:postgresql://localhost:5433/postgres";
    public String user = "postgres";
    public String password = "12345";
    public int salary;
    public void getsetwork() {
        try {
            Main.connection = DriverManager.getConnection(url,user ,password );
            Statement stmt = Main.connection.createStatement();
            String query = "select * from emp order by id";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = Integer.parseInt(rs.getObject(1).toString());
                String name = rs.getObject(2).toString();
                String work = rs.getObject(3).toString();
                this.work[i]=work;
                this.id[i]=id;
                i++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void outpos(){
        for(int i = 0;i<7;i++){
            if(work[i]!=null) {
                System.out.println(work[i]);
            }
        }
    }
}
//new class
public class salary extends emp{
    double[] salar=new double[10];
    public int i = 0;

    @Override
    public void getsetwork() {
        super.getsetwork();
    }

    public void getsetsalary() {
        try {
            Main.connection = DriverManager.getConnection(url, user, password);
            Statement stmt = Main.connection.createStatement();
            String query = "select id,position,price from emp inner join projemp on id=empid inner join project on projemp.project_id=project.project_id order by id;";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = Integer.parseInt(rs.getObject(1).toString());
                String posit = rs.getObject(2).toString();
                double price = Double.parseDouble(rs.getObject(3).toString());
                switch (posit){
                    case"Manager":{salar[i]+=price*0.45;}
                    case"Software Engineer":{salar[i]+=price*0.25;}
                    case"Tester":{salar[i]+=price*0.2;}
                    case"Designer":{salar[i]+=price*0.15;}
                    case"Recruit":{salar[i]+=price*0.05;}
                }
                i++;
            }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void outsal(){
        System.out.println("Manager salary = " + salar[0]);
        System.out.println("Software Engineer = " + salar[1]);
        System.out.println("Tester = " + salar[2]);
        System.out.println("Designer = " + salar[3]);
        System.out.println("Recruit = " + salar[4]);
    }

}
