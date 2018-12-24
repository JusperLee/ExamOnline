package caozuo;

import java.util.List;

import bean.Pdt;



/**
 * �ж������ݿ�ӿ���
 *
 */
public interface PdtInterfaceCao {


	/**
	 * ����һ���ж���
	 * @param xzt
	 * @return
	 */
	public boolean insert(Pdt pdt);
	
	/**
	 * ɾ��һ���ж���
	 * @param xzt
	 * @return
	 */
	public boolean delete(Pdt pdt);
	
	/**
	 * �����޸�һ���ж���
	 * @param xzt
	 * @return
	 */
	public boolean update(Pdt pdt);
	
	/**
	 * ��ѯȫ���ж���
	 * @param ��
	 * @return �ж��⼯��
	 */
	public List<Pdt> select();
	
	/**
	 * ��֪ʶ���ѯ�ж���
	 * @param questionpoint ֪ʶ��
	 * @return �ж��⼯��
	 */
	public List<Pdt> select(String questionpoint);
	/**
	 * ��id��ѯ�ж���
	 * @param id ���
	 * @return �ж��⼯��
	 */
	public Pdt select(int id);
}