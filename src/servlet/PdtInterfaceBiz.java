package servlet;

import java.util.List;

import bean.Pdt;

public interface PdtInterfaceBiz {

		public boolean insert(Pdt xzt);
		
		/**
		 * ɾ��һ���ж���
		 * @param xzt
		 * @return
		 */
		public boolean delete(Pdt xzt);
		
		/**
		 * �����޸�һ���ж���
		 * @param xzt
		 * @return
		 */
		public boolean update(Pdt xzt);
		
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
}
