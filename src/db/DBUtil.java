package db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 数据库连接类，配置文件为“context.xml”
 *
 */
public class DBUtil {
/*	private static Properties prt = null;
	private static String driver = null;
	private static String url = null;
	private static String user = null;
	private static String pwd = null;*/
	
	static Connection con = null;// 创建一个数据库连接
    static PreparedStatement pr = null;// 创建预编译语句对象，一般都是用这个而不用Statement
	static ResultSet rs = null;// 创建一个结果集对象
	static DataSource ds = null;
	static {
	
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			ds = (DataSource)envCtx.lookup("tomcatpool");
			/*prt = new Properties();
			InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("com/neuq/db/db.properties");
            prt.load(in);
			driver = prt.getProperty("driver");
			url = prt.getProperty("url");
			user = prt.getProperty("user");
			pwd = prt.getProperty("pwd");
			Class.forName(driver);*/

		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {

	
		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}

	public static void CloseConnection(ResultSet rs, PreparedStatement pr, Connection con) {
		try {
			// 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
			// 注意关闭的顺序，最后使用的最先关闭
			if (rs!= null)
				rs.close();
			if (pr != null)
				pr.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//System.out.println("已经关闭数据库连接");
		}
		
	}
	
	

}
