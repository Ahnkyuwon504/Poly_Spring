package tupyo.service;

import java.util.List;

import tupyo.domain.Hubo;
import tupyo.domain.Tupyo;

public interface TupyoService {
	void create(Tupyo tupyo);
	Tupyo selectOne(int id);
	List<Tupyo> selectAll();
	void update(Tupyo tupyo);
	void delete(Tupyo tupyo);
	int selectAllCount();
	int selectOneCount(Hubo hubo);
	int[] selectOneAgeCount(Hubo hubo);

}
