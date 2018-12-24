/*
@author likai
*/
package caozuo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import bean.Manager;
import bean.Teacher;

public interface ManagerInterfaceCao {
	public Manager select(Manager m,Connection con)throws SQLException;
	public List<Teacher> select(Connection con)throws SQLException;
	public boolean insert(Teacher t,Connection con)throws SQLException;
	public boolean delete(String teachername,Connection con)throws SQLException;
	public Manager showManagerInfo(String parameter) throws SQLException; 
	public boolean find(Manager m,Connection con)throws SQLException;
	public Manager login(String username, String pwd,String tel) throws SQLException;
}
