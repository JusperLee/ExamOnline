package caozuo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import bean.Bct;
import bean.PaperString;
import bean.Pdt;
import bean.Student;
import bean.StudentGrade;
import bean.Teacher;
import bean.Tkt;
import bean.Xzt;

public interface TeacherInterfaceCao   {
	/**
	 * 查询老师个人信息
	 * @param t
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public Teacher select(Teacher t,Connection con)throws SQLException;
	/**
	 *按班级查询学生
	 * @param sc
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public List<Student> select(String sc,Connection con)throws SQLException;//sc--studentclass
	/**
	 * 插入学生
	 * @param s
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public boolean insert(Student s,Connection con)throws SQLException;
	/**
	 * 修改教师个人信息
	 * @param t
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public boolean updata(Teacher t,Connection con)throws SQLException;
	/**
	 * 找回密码
	 * @param t
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public boolean find(Teacher t,Connection con)throws SQLException;
	/**
	 * 删除学生
	 * @param s
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public boolean delete(String studentname,String studentclass,Connection con)throws SQLException;
	/**
	 * 更据试卷名字和班级查学生成绩
	 * @param studentclass
	 * @param Papername
	 * @return
	 * @throws SQLException
	 */
	public List<StudentGrade> studentgrade(String studentclass,String Papername)throws SQLException;
	/**
	 * 查看教师个人信息
	 * @param parameter
	 * @return
	 * @throws SQLException
	 */
	public Teacher showTeacherInfo(String parameter) throws SQLException; 
	/**
	 * 批量导题
	 */
	public boolean batchquestion(int questiontype,String filename,String path) throws SQLException;
	/**
	 * 出卷
	 */
	public boolean setPaper(int[] questionxztid,int[] questiontktid, int[] questionbctid )throws SQLException;
	/**
	 * 查看题库
	 */
	public Xzt showPaperbankxzt(int id)throws SQLException;
	public Tkt showPaperbanktkt(int id)throws SQLException;
	public Pdt showPaperbankpdt(int id)throws SQLException;
	/**
	 * 改卷
	 */
	public boolean correctPaper(int score)throws SQLException;
	/**
	 * 根据前台返回的试卷名称查看试卷
	 */
	public PaperString showPaper(String papername)throws SQLException; 
	/**
	 * login
	 */
	public Teacher login(String username, String pwd,String tel) throws SQLException;
	public String[] selectclass()throws SQLException;
	public String[] selectpaper()throws SQLException;
}

