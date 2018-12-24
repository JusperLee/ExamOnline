package servlet                                                                                                                                                                                                                                                                   ;

import java.sql.SQLException;
import java.util.List;

import bean.JdtAnswer;
import caozuo.JdtAnswerInterfaceCao;
import caozuo.JdtAnswerInterfaceImplCao;
import servlet.JdtAnswerInterfaceBiz;

public class JdtAnswerInterfaceImplBiz implements JdtAnswerInterfaceBiz {
              JdtAnswerInterfaceCao bfc=new JdtAnswerInterfaceImplCao();
	@Override
	public List<JdtAnswer> select(String studentclass, String papername) throws SQLException {
		return bfc.select(studentclass, papername);
	}

}
