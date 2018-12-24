package caozuo;

import java.util.List;

import bean.Paper;



/**
 * �Ծ����ݿ�ӿ���
 *
 */
public interface PaperInterfaceCao {


	/**
	 * ����һ���Ծ�
	 * @param paper
	 * @return
	 */
	public boolean insert(Paper paper);
	
	/**
	 * ɾ��һ���Ծ�
	 * @param paper
	 * @return
	 */
	public boolean delete(Paper paper);
	
	/**
	 * �����޸�һ���Ծ�
	 * @param paper
	 * @return
	 */
//	public boolean update(Paper paper);
	
	/**
	 * ��ѯȫ���Ծ�
	 * @param ��
	 * @return  Paper �Ծ���
	 */
	public List<Paper> select();
	
	
	/**
	 * ��֪ʶ���ѯ�Ծ�
	 * @param id
	 * @return  Paper �Ծ���
	 */
	public Paper select(int id);
	/**
	 * ��֪ʶ���ѯ�Ծ�
	 * @param questionpoint
	 * @return  Paper �Ծ���
	 */
	public List<Paper> select(String questionpoint);
	/**
	 * ֮ǰ�Ѿ������Ŀ���
	 * @param username 
	 * @return
	 */
	public List<Paper> showbeforePaper(String username);
	/**
	 * ��Ҫ���еĿ���
	 * @return
	 */
	public List<Paper> showafterPaper(String username);
	
	/**
	 * ���༶��ѯ
	 * @return
	 */
	public List<Paper> select_class_Paper(String class1);
	/**
	 * �����Ծ������ҵ�ǰ��Ӧ���Ծ����
	 * @param papername
	 * @return  Paper ����
	 */
	public Paper selectInstance(String papername);
     
	 /**
	 * ���ڽ��еĿ���
	 * @return
	 */
	public List<Paper> shownowPaper(String username);

	
	/**
	 * ��ֹ��ǰ����ʱ��bug����ѯ���Կ��Ե��Ծ�ǰ�ж��Ƿ���ڼ�¼
	 * Ϊ�棬���ڼ�¼��Ϊ�٣������ڼ�¼
	 * @param username
	 * @param papername
	 * @return
	 */
	public boolean IsDone(String username, int paperid);
}