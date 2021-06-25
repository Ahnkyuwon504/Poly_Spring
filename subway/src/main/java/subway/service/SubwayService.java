package subway.service;

import subway.domain.Subway;

public interface SubwayService {
	Subway create();
	int getTime(Subway subway, int start, int arrive);
	void insertDB(); 
	void createDB();
	void deleteDB();


}
