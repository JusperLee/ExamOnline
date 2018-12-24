package caozuo;

import java.util.List;

import bean.Xzt;



/**
 * ѡ�������ݿ�ӿ���
 *
 */
public interface XztInterfaceCao {


	/**
	 * ����һ��ѡ����
	 * @param xzt
	 * @return
	 */
	public boolean insert(Xzt xzt);
	
	/**
	 * ɾ��һ��ѡ����
	 * @param xzt
	 * @return
	 */
	public boolean delete(Xzt xzt);
	
	/**
	 * �����޸�һ��ѡ����
	 * @param xzt
	 * @return
	 */
	public boolean update(Xzt xzt);
	
	/**
	 * ��ѯȫ��ѡ����
	 * @param ��
	 * @return ѡ���⼯��
	 */
	public List<Xzt> select();
	
	/**
	 * ��ѯidѡ����
	 * @param id
	 * @return ѡ���⼯��
	 */
	public Xzt select(int id);
	/**
	 * ��֪ʶ���ѯѡ����
	 * @param questionpoint ֪ʶ��
	 * @return ѡ���⼯��
	 */
	public List<Xzt> select(String questionpoint);
}