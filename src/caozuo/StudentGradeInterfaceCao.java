package caozuo;

import java.util.List;


import bean.StudentGrade;

/**
 * ѧ���ɼ������ݿ�ӿ���
 *
 */
public interface StudentGradeInterfaceCao {

	/**
	 * ����һ��ѧ���ɼ���¼
	 * @param studentGrade
	 * @return
	 */
	public boolean insert(StudentGrade studentGrade);
	
	/**
	 * ɾ��һ��ѧ���ɼ���¼
	 * @param studentGrade
	 * @return
	 */
	public boolean delete(StudentGrade studentGrade);
	
	/**
	 * �޸�һ��ѧ���ɼ���¼
	 * @param studentGrade
	 * @return
	 */
	public boolean update(int bctscore,int jdtscore,int score,String username,String papername);
	
	/**
	 * ��ѯĳ��ѧ����ȫ���ɼ���¼
	 * @param username ѧ������
	 * @return ĳ��ѧ����ȫ���ɼ���¼StudentGrade
	 */
	public List<StudentGrade> select(String username);
	
	/**
	 * ��ѯĳ���Ծ���ĳ���༶��ȫ���ɼ���¼
	 * @param studentclass ѧ�����ڰ༶
	 * @param  papername �Ծ���
	 * @return ĳ���Ծ��ȫ���ɼ���¼
	 */
	public List<StudentGrade> select(String studentclass,String papername);
}
