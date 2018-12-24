package servlet;

import java.sql.SQLException;
import java.util.List;

import bean.BctAnswer;



public interface BctAnswerInterfaceBiz {

	public List<BctAnswer> select(String studentclass,String papername)throws SQLException;

}
