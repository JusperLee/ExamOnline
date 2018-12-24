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
 * ���ݿ������࣬�����ļ�Ϊ��context.xml��
 *
 */
public class DBUtil {
/*	private static Properties prt = null;
	private static String driver = null;
	private static String url = null;
	private static String user = null;
	private static String pwd = null;*/
	
	static Connection con = null;// ����һ�����ݿ�����
    static PreparedStatement pr = null;// ����Ԥ����������һ�㶼�������������Statement
	static ResultSet rs = null;// ����һ�����������
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
			// ��һ������ļ�������رգ���Ϊ���رյĻ���Ӱ�����ܡ�����ռ����Դ
			// ע��رյ�˳�����ʹ�õ����ȹر�
			if (rs!= null)
				rs.close();
			if (pr != null)
				pr.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//System.out.println("�Ѿ��ر����ݿ�����");
		}
		
	}
	
	

}
