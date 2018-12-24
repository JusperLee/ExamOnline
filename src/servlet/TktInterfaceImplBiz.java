package servlet;

import java.util.List;

import bean.Tkt;
import caozuo.TktInterfaceCao;
import caozuo.TktInterfaceImplCao;
import servlet.TktInterfaceBiz;

public class TktInterfaceImplBiz implements TktInterfaceBiz {
TktInterfaceCao tif= new TktInterfaceImplCao();
	@Override
	public boolean insert(Tkt tkt) {
		return tif.insert(tkt);
	}

	@Override
	public boolean delete(Tkt tkt) {
		return tif.delete(tkt);
	}

	@Override
	public boolean update(Tkt tkt) {
		return tif.update(tkt);
	}

	@Override
	public List<Tkt> select() {
		return tif.select();
	}

	@Override
	public List<Tkt> select(String questionpoint) {
		return tif.select(questionpoint);
	}

}
