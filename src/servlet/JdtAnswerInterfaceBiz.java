package servlet;

import java.sql.SQLException;
import java.util.List;

import bean.JdtAnswer;



public interface JdtAnswerInterfaceBiz {

	public List<JdtAnswer> select(String studentclass,String papername)throws SQLException;

}
