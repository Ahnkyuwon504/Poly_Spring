package tupyo.service;

import java.util.List;

import tupyo.dao.HuboDao;
import tupyo.dao.HuboDaoImpl;
import tupyo.domain.Hubo;

public class HuboServiceImpl implements HuboService {
	
	private HuboDao huboDao = new HuboDaoImpl();

	@Override
	public void create(Hubo hubo) {
		// TODO Auto-generated method stub
		huboDao.create(hubo);
		
	}

	@Override
	public Hubo selectOne(int kiho) {
		// TODO Auto-generated method stub
		return huboDao.selectOne(kiho);
	}

	@Override
	public List<Hubo> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Hubo hubo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Hubo hubo) {
		// TODO Auto-generated method stub
		
	}

}
