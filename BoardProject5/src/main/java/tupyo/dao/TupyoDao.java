package tupyo.dao;

import java.util.List;


import tupyo.domain.Tupyo;
import tupyo.domain.Hubo;

public interface TupyoDao {
	void create(Tupyo tupyo);
	Tupyo selectOne(int kiho);
	List<Tupyo> selectAll();
	void update(Tupyo tupyo);
	void delete(Tupyo tupyo);
	int selectAllCount();
	int selectOneCount(Hubo hubo);
	int[] selectOneAgeCount(Hubo hubo);

}
