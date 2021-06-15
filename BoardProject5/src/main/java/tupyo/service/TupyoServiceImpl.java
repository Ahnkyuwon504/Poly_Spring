package tupyo.service;

import java.util.List;

import tupyo.domain.Hubo;
import tupyo.domain.Tupyo;
import tupyo.dao.TupyoDao;
import tupyo.dao.TupyoDaoImpl;

public class TupyoServiceImpl implements TupyoService {
	private TupyoDao tupyoDao = new TupyoDaoImpl(); 

	@Override
	public void create(Tupyo tupyo) {
		// TODO Auto-generated method stub
		tupyoDao.create(tupyo);
		
	}

	@Override
	public Tupyo selectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tupyo> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Tupyo tupyo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Tupyo tupyo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int selectAllCount() {
		// TODO Auto-generated method stub
		return tupyoDao.selectAllCount();
	}

	@Override
	public int selectOneCount(Hubo hubo) {
		// TODO Auto-generated method stub
		return tupyoDao.selectOneCount(hubo);
	}
	
	@Override
	public int[] selectOneAgeCount(Hubo hubo) {
		return tupyoDao.selectOneAgeCount(hubo);
	}

}
