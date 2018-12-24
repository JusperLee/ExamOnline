package caozuo;

import java.util.List;

import bean.Bct;

/**
 * ��������ݿ�ӿ���
 *
 */
public interface BctInterfaceCao {

	/**
	 * ����һ�������
	 * @param bct
	 * @return
	 */
	public boolean insert(Bct bct);
	
	/**
	 * ɾ��һ�������
	 * @param bct
	 * @return
	 */
	public boolean delete(Bct bct);
	
	/**
	 * �����޸�һ�������
	 * @param bct
	 * @return
	 */
	public boolean update(Bct bct);
	
	/**
	 * ��ѯȫ�������
	 * @param ��
	 * @return ����⼯��
	 */
	public List<Bct> select();
	
	/**
	 * ��֪ʶ���ѯ�����
	 * @param questionpoint ֪ʶ��
	 * @return ����⼯��
	 */
	public List<Bct> select(String questionpoint);
	/**
	 * ��id��ѯ�����
	 * @param id ���
	 * @return ����⼯��
	 */
	public Bct select(int id);
}
