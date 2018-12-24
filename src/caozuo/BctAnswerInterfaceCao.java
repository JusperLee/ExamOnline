package caozuo;

import java.util.List;

import bean.BctAnswer;

public interface BctAnswerInterfaceCao {
	
public List<BctAnswer> select(String studentclass,String papername);
public List<BctAnswer> selectwp(String studentclass,String papername);
public boolean insert(BctAnswer bctanswer);



}