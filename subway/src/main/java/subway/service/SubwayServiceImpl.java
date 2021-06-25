package subway.service;

import subway.dao.SubwayDao;
import subway.dao.SubwayDaoImpl;
import subway.domain.Subway;

public class SubwayServiceImpl implements SubwayService {
	
	private static SubwayServiceImpl instance = new SubwayServiceImpl();
	
	public static SubwayServiceImpl getInstance() {
		return instance;
	}
	
	private SubwayServiceImpl() {
		
	}
	
	private SubwayDao subwayDao = SubwayDaoImpl.getInstance();

	@Override
	public Subway create() {
		// TODO Auto-generated method stub
		return subwayDao.create();
	}

	@Override
	public int getTime(Subway subway, int start, int arrive) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insertDB() {
		// TODO Auto-generated method stub
		subwayDao.insertDB();
		
	}

	@Override
	public void createDB() {
		// TODO Auto-generated method stub
		subwayDao.createDB();
		
	}

	@Override
	public void deleteDB() {
		// TODO Auto-generated method stub
		subwayDao.deleteDB();
		
	}

}
