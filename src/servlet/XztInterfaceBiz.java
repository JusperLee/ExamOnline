package servlet;

import java.util.List;

import bean.Xzt;

public interface XztInterfaceBiz {

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
		 * ��֪ʶ���ѯѡ����
		 * @param questionpoint ֪ʶ��
		 * @return ѡ���⼯��
		 */
		public List<Xzt> select(String questionpoint);
}
