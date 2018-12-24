package caozuo;

import java.util.List;

import bean.Tkt;



/**
 * ��������ݿ�ӿ���
 *
 */
public interface TktInterfaceCao {


	/**
	 * ����һ�������
	 * @param tkt
	 * @return
	 */
	public boolean insert(Tkt tkt);
	
	/**
	 * ɾ��һ�������
	 * @param tkt
	 * @return
	 */
	public boolean delete(Tkt tkt);
	
	/**
	 * �����޸�һ�������
	 * @param tkt
	 * @return
	 */
	public boolean update(Tkt tkt);
	
	/**
	 * ��ѯȫ�������
	 * @param tkt
	 * @return ����⼯��
	 */
	public List<Tkt> select();
	
	/**
	 * ��֪ʶ���ѯ�����
	 * @param questionpoint ֪ʶ��
	 * @return ����⼯��
	 */
	public List<Tkt> select(String questionpoint);

	public Tkt select(int id);
}