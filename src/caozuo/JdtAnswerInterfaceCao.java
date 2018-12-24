package caozuo;

import java.util.List;

import bean.JdtAnswer;

public interface JdtAnswerInterfaceCao {
	
public List<JdtAnswer> select(String studentclass,String papername);
public List<JdtAnswer> selectwp(String studentclass,String papername);
public boolean insert(JdtAnswer bctanswer);



}