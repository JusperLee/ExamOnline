package caozuo;

import java.util.List;

import bean.Jdt;

/**
 * 简答题数据库接口类
 *
 */
public interface JdtInterfaceCao {

	/**
	 * 增加一道简答题
	 * @param jdt
	 * @return
	 */
	public boolean insert(Jdt jdt);
	
	/**
	 * 删除一道简答题
	 * @param jdt
	 * @return
	 */
	public boolean delete(Jdt jdt);
	
	/**
	 * 更新修改一道简答题
	 * @param jdt
	 * @return
	 */
	public boolean update(Jdt jdt);
	
	/**
	 * 查询全部简答题
	 * @param 无
	 * @return 简答题集合
	 */
	public List<Jdt> select();
	
	/**
	 * 按知识点查询简答题
	 * @param questionpoint 知识点
	 * @return 简答题集合
	 */
	public List<Jdt> select(String questionpoint);
	/**
	 * 按id查询简答题
	 * @param id 知识点
	 * @return 简答题集合
	 */
	public Jdt select(int id);
}
