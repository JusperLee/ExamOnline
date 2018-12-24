package caozuo;

import java.util.List;

import bean.Jdt;

/**
 * ��������ݿ�ӿ���
 *
 */
public interface JdtInterfaceCao {

	/**
	 * ����һ�������
	 * @param jdt
	 * @return
	 */
	public boolean insert(Jdt jdt);
	
	/**
	 * ɾ��һ�������
	 * @param jdt
	 * @return
	 */
	public boolean delete(Jdt jdt);
	
	/**
	 * �����޸�һ�������
	 * @param jdt
	 * @return
	 */
	public boolean update(Jdt jdt);
	
	/**
	 * ��ѯȫ�������
	 * @param ��
	 * @return ����⼯��
	 */
	public List<Jdt> select();
	
	/**
	 * ��֪ʶ���ѯ�����
	 * @param questionpoint ֪ʶ��
	 * @return ����⼯��
	 */
	public List<Jdt> select(String questionpoint);
	/**
	 * ��id��ѯ�����
	 * @param id ֪ʶ��
	 * @return ����⼯��
	 */
	public Jdt select(int id);
}
