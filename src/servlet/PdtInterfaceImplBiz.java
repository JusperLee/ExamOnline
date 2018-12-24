package servlet;

import java.util.List;

import bean.Pdt;
import caozuo.PdtInterfaceCao;
import caozuo.PdtInterfaceImplCao;
import servlet.PdtInterfaceBiz;

public class PdtInterfaceImplBiz implements PdtInterfaceBiz {
PdtInterfaceCao xif=new PdtInterfaceImplCao();
	@Override
	public boolean insert(Pdt xzt) {
		return xif.insert(xzt);
	}

	@Override
	public boolean delete(Pdt xzt) {
		return xif.delete(xzt);
	}

	@Override
	public boolean update(Pdt xzt) {
		return xif.update(xzt);
	}

	@Override
	public List<Pdt> select() {
		return xif.select();
	}

	@Override
	public List<Pdt> select(String questionpoint) {
		return xif.select(questionpoint);
	}

}
