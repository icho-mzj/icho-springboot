package com.icho;

//import com.mysql.jdbc.Driver;
import org.junit.Test;
        import sun.reflect.Reflection;

import java.io.File;
import java.io.FileInputStream;
        import java.sql.*;
import java.util.Properties;

/**
 * @Author: icho
 * @Date: 2022/4/4 20:28
 * @Describe:
 */
public class JdbcTest {

    public static void main(String[] args) {
        Properties prop = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/java/com/icho/jdbc.properties");
            prop.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String driverClass = prop.getProperty("driverClass");
        String url = prop.getProperty("url");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        System.out.println("driverClass = " + driverClass);
        System.out.println("user = " + user);
    }

    @Test
    public void test02() {
        System.out.println("test02执行了");
        test03();
    }


    private void test03() {
        System.out.println(Reflection.getCallerClass());
        System.out.println("test03执行了");
    }

    @Test
    public void test01() throws Exception {
        // DriverManager.registerDriver(new Driver());
        // Class.forName("com.mysql.cj.jdbc.Driver"); // 从JDBC4.0开始，就是目前已经普遍使用的版本。可以不用注册驱动而直接使用。Class.forName这句话可以省略。
        String url = "jdbc:mysql://localhost:3306/ruoyi?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8"; // ?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8
        String user = "root";
        String pwd = "4321";
        Connection connection = DriverManager.getConnection(url, user, pwd);
        Statement statement = connection.createStatement();

        // 解决SQL注入问题
        PreparedStatement preparedStatement = connection.prepareStatement("select * from sys_user where user_name = ?");
        preparedStatement.setString(1,"若依'");
        ResultSet result = preparedStatement.executeQuery();

        //ResultSet result = statement.executeQuery("select * from sys_user where user_name ='若依' and password ='xxx' or '1'='1'");
        //ResultSet result = statement.executeQuery("select * from sys_user where login_name ='admin --' and password ='xxx' or '1'='1'");
        while (result.next()) {
            int id = result.getInt("user_id");
            String loginName = result.getString("login_name");
            String password = result.getString("password");
            String phonenumber = result.getString("phonenumber");
            System.out.println("id---"+id+"; loginName---"+loginName+"; password---"+password+"; phonenumber---"+phonenumber);
        }

        result.close();
        statement.close();
        connection.close();
    }

    @Test
    public void test04() throws Exception {
        // DriverManager.registerDriver(new Driver());
        // Class.forName("com.mysql.cj.jdbc.Driver"); // 从JDBC4.0开始，就是目前已经普遍使用的版本。可以不用注册驱动而直接使用。Class.forName这句话可以省略。
        String url = "jdbc:mysql://localhost:3306/ruoyi?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8"; // ?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8
        String user = "root";
        String pwd = "4321";
        Connection connection = DriverManager.getConnection(url, user, pwd);
        Statement statement = connection.createStatement();
        int i = statement.executeUpdate("update sys_role set remark = '超级管理员' where role_id = 1");
        System.out.println("i = " + i);

        statement.close();
        connection.close();
    }



}
