package servlet;

import java.util.List;

import bean.Xzt;
import caozuo.XztInterfaceCao;
import caozuo.XztInterfaceImplCao;
import servlet.XztInterfaceBiz;

public class XztInterfaceImplBiz implements XztInterfaceBiz {
XztInterfaceCao xif=new XztInterfaceImplCao();
	@Override
	public boolean insert(Xzt xzt) {
		return xif.insert(xzt);
	}

	@Override
	public boolean delete(Xzt xzt) {
		return xif.delete(xzt);
	}

	@Override
	public boolean update(Xzt xzt) {
		return xif.update(xzt);
	}

	@Override
	public List<Xzt> select() {
		return xif.select();
	}

	@Override
	public List<Xzt> select(String questionpoint) {
		return xif.select(questionpoint);
	}

}
