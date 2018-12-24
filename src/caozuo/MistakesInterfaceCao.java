package caozuo;

import java.util.List;

import bean.Mistakes;

/**
 * ���⼯���ݿ�ӿ���
 *  @author likai
 */
public interface MistakesInterfaceCao {

	/**
	 * ����һ������
	 * @param mistakes
	 * @return
	 */
	public boolean insert(Mistakes mistakes);
	
	/**
	 * ɾ��һ������
	 * @param mistakes
	 * @return
	 */
	public boolean delete(Mistakes mistakes);
	
	
	
	/**
	 * ��ѯĳ��ѧ����ȫ������  
	 * @param username ѧ������
	 * @return ���⼯��
	 */
	public List<Mistakes> selectxzt(String username);
	public List<Mistakes> selecttkt(String username);
	public List<Mistakes> selectbct(String username);
	public List<Mistakes> selectpdt(String username);
	public List<Mistakes> selectjdt(String username);
	/**
	 * ��֪ʶ���ѯĳ��ѧ����ȫ������
	 * @param username ѧ������
	 * @param  questionpoint ֪ʶ��
	 * @return ���⼯��
	 */
	public List<Mistakes> select(String username,String questionpoint);
}
