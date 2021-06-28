package subway.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import subway.dao.SubwayDao;
import subway.dao.SubwayDaoImpl;
import subway.domain.Print;
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
	public Print getTime(Subway subway, String start, String arrive) {
		
		ArrayList<ArrayList<String>> map = subway.getMap();
		//int[][] time = subway.getTime();
		//int[][] line = subway.getLine();
		boolean[] visit = new boolean[1000];
		String[] isAvail = subway.getIsAvail();
		// TODO Auto-generated method stub
		ArrayList<String> startArr = new ArrayList<String>();
		startArr.add(start);
		
		Queue<Print> q = new LinkedList<Print>();
		
		q.offer(new Print(0, startArr));
		visit[indexOfStation(start, isAvail)] = true;
		
		while (!q.isEmpty()) {
			Print nowPrint = q.poll();
			
			ArrayList<String> nowRoute = nowPrint.getRoute();
			String lastStation = nowRoute.get(nowRoute.size() - 1);
			int nowTime = nowPrint.getTime();
			
			
			if (lastStation.equals(arrive)) {
				return nowPrint;
			}
			
			for (String next : getNextStation(lastStation, map, isAvail)) {
				ArrayList<String> newRoute = new ArrayList<String>();
				
				for (int k = 0; k < nowRoute.size(); k++) {
					newRoute.add(nowRoute.get(k));
				}
				if (visit[indexOfStation(next, isAvail)]) continue;
				
				newRoute.add(next);
				visit[indexOfStation(next, isAvail)] = true;
				
				q.offer(new Print(nowTime + 1, newRoute));
			}
		}
		
		return null;
	}
	
	static ArrayList<String> getNextStation(String lastStation, ArrayList<ArrayList<String>> map, String[] isAvail) {
		
		ArrayList<String> nextStation = new ArrayList<String>();
		
		for (int i = 0; i <isAvail.length; i++) {
			if (lastStation.equals(isAvail[i])) {
				for (int j = 0; j < map.get(i).size(); j++)
				nextStation.add(map.get(i).get(j));
			}
		}
		return nextStation;
	}
	
	static int indexOfStation (String lastStation, String[] isAvail) {
		for (int i = 0; i < isAvail.length; i++) {
			if (lastStation.equals(isAvail[i])) return i;
		}
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
