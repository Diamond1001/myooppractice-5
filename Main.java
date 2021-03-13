package Helpmepls;
import java.sql.*;
public class Main {
    static Connection connection = null;
    static PreparedStatement pstmt = null;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
      //  input();
      // Main.output();
      //  update();
        //  drop();
    }
    public static void output() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres", "postgres", "12345");
            try {
                Statement stmt = connection.createStatement();
                String query = "select * from0 java1;";
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    String id = rs.getObject(1).toString();
                    String name = rs.getObject(2).toString();
                    String surname = rs.getObject(3).toString();
                    String grade =rs.getObject(4).toString();
                    System.out.println("Id  is " + id + " and name is " + name + surname + " grade = "+grade);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                for (Throwable ex : e) {
                    System.err.println("Error occurred " + ex);
                }
                System.out.println("Error in fetching data");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void input() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres", "postgres", "12345");
        try {
            String query = "insert into java1 (id, name, surname, grade) values (?,?,?,?);";
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, 2);
            pstmt.setString(2,"Max");
            pstmt.setString(3,"Love");
            pstmt.setInt(4,80);
            pstmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void update() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres", "postgres", "12345");
        try {
            String query = "update java1 set name=?,surname=?,grade=? where id=1";
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1,"Max");
            pstmt.setString(2,"Brand");
            pstmt.setInt(3,90);
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void drop() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres", "postgres", "12345");
        try {
            String query = "delete from java1 where id=2";
            pstmt = connection.prepareStatement(query);
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

