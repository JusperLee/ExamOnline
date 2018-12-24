package servlet;

import java.util.List;

import bean.Paper;
import caozuo.PaperInterfaceCao;
import caozuo.PaperInterfaceImplCao;
import servlet.PaperInterfaceBiz;

public class PaperInterfaceImplBiz implements PaperInterfaceBiz {
PaperInterfaceCao pif=new PaperInterfaceImplCao();
	@Override
	public boolean insert(Paper paper) {
		return pif.insert(paper);
	}

	@Override
	public boolean delete(Paper paper) {
		return pif.delete(paper);
	}

	@Override
	public List<Paper> select() {
		return pif.select();
	}

	@Override
	public List<Paper> select(String questionpoint) {
		return pif.select(questionpoint);
	}

	@Override
	public List<Paper> showbeforePaper(String username) {
		return pif.showbeforePaper(username);
	}

	@Override
	public List<Paper> showafterPaper(String username) {
		return pif.showafterPaper(username);
	}

	@Override
	public List<Paper> shownowPaper(String username) {
		return pif.shownowPaper(username);
	}

	@Override
	public Paper selectInstance(String papername) {

		return pif.selectInstance(papername);
	}
	

}
