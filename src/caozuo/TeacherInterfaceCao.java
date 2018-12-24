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
	 * ��ѯ��ʦ������Ϣ
	 * @param t
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public Teacher select(Teacher t,Connection con)throws SQLException;
	/**
	 *���༶��ѯѧ��
	 * @param sc
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public List<Student> select(String sc,Connection con)throws SQLException;//sc--studentclass
	/**
	 * ����ѧ��
	 * @param s
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public boolean insert(Student s,Connection con)throws SQLException;
	/**
	 * �޸Ľ�ʦ������Ϣ
	 * @param t
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public boolean updata(Teacher t,Connection con)throws SQLException;
	/**
	 * �һ�����
	 * @param t
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public boolean find(Teacher t,Connection con)throws SQLException;
	/**
	 * ɾ��ѧ��
	 * @param s
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public boolean delete(String studentname,String studentclass,Connection con)throws SQLException;
	/**
	 * �����Ծ����ֺͰ༶��ѧ���ɼ�
	 * @param studentclass
	 * @param Papername
	 * @return
	 * @throws SQLException
	 */
	public List<StudentGrade> studentgrade(String studentclass,String Papername)throws SQLException;
	/**
	 * �鿴��ʦ������Ϣ
	 * @param parameter
	 * @return
	 * @throws SQLException
	 */
	public Teacher showTeacherInfo(String parameter) throws SQLException; 
	/**
	 * ��������
	 */
	public boolean batchquestion(int questiontype,String filename,String path) throws SQLException;
	/**
	 * ����
	 */
	public boolean setPaper(int[] questionxztid,int[] questiontktid, int[] questionbctid )throws SQLException;
	/**
	 * �鿴���
	 */
	public Xzt showPaperbankxzt(int id)throws SQLException;
	public Tkt showPaperbanktkt(int id)throws SQLException;
	public Pdt showPaperbankpdt(int id)throws SQLException;
	/**
	 * �ľ�
	 */
	public boolean correctPaper(int score)throws SQLException;
	/**
	 * ����ǰ̨���ص��Ծ����Ʋ鿴�Ծ�
	 */
	public PaperString showPaper(String papername)throws SQLException; 
	/**
	 * login
	 */
	public Teacher login(String username, String pwd,String tel) throws SQLException;
	public String[] selectclass()throws SQLException;
	public String[] selectpaper()throws SQLException;
}

