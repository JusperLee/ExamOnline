package servlet;

import java.util.List;

import bean.Paper;

public interface PaperInterfaceBiz {
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
	 * @param questionpoint
	 * @return  Paper �Ծ���
	 */
	public List<Paper> select(String questionpoint);
	public List<Paper> showbeforePaper(String username);
	public List<Paper> showafterPaper(String username);
	public List<Paper> shownowPaper(String username);
	
	/**
	 * �����Ծ������ҵ�ǰ��Ӧ���Ծ����
	 * @param papername
	 * @return  Paper ����
	 */
	public Paper selectInstance(String papername);
}
