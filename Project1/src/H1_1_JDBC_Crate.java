import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class H1_1_JDBC_Crate
{
    public static final String URL = "jdbc:mysql://localhost:3306/mydb";
    public static final String USER = "root";
    public static final String PASSWORD = "****";

    public static void main(String[] args) throws Exception
    {
        // 加载驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获得数据库连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        // 获取执行对象
        Statement stmt = conn.createStatement();

        // 清空数据表
        stmt.executeUpdate("truncate table mydb.student");

        // SQL语句: 增
        stmt.execute("INSERT INTO student(id, name, age) VALUES(1950001,'同大学', 20);");
        stmt.execute("INSERT INTO student(id, name, age) VALUES(1951542,'同大学', 20);");
        stmt.execute("INSERT INTO student(id, name, age) VALUES(2051236,'同阿济', 22);");
        stmt.execute("INSERT INTO student(id, name, age) VALUES(2051437,'同小济', 23);");

        // SQL语句: 删
        stmt.execute("DELETE FROM student WHERE id = 1950001");

        // SQL语句: 改
        stmt.execute("UPDATE student SET name = '济大同' WHERE id = 1951542");

        // SQL语句: 查
        ResultSet rs = stmt.executeQuery("SELECT * FROM student");
        while (rs.next())
        {
            System.out.println("id: " + rs.getInt("id"));
            System.out.println("name: " + rs.getString("name"));
            System.out.println("age: " + rs.getInt("age"));
            System.out.println("------------------------------");
        }

        // 释放
        stmt.close();
        conn.close();
    }
}
