package subway.dao;


import subway.domain.Subway;

public interface SubwayDao {
	Subway create(); // �����ͺ��̽����� ���� �̾Ƽ� map, time, visit ���� ��ü ����
	void createDB();
	void deleteDB();
	void insertDB(); // CSV���Ͽ��� �����ͺ��̽� ����
	

}
