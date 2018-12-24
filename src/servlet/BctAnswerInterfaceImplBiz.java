package servlet                                                                                                                                                                                                                                                                   ;

import java.sql.SQLException;
import java.util.List;

import bean.BctAnswer;
import caozuo.BctAnswerInterfaceCao;
import caozuo.BctAnswerInterfaceImplCao;
import servlet.BctAnswerInterfaceBiz;

public class BctAnswerInterfaceImplBiz implements BctAnswerInterfaceBiz {
              BctAnswerInterfaceCao bfc=new BctAnswerInterfaceImplCao();
	@Override
	public List<BctAnswer> select(String studentclass, String papername) throws SQLException {
		return bfc.select(studentclass, papername);
	}

}
