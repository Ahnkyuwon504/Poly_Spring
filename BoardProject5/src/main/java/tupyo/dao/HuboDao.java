package tupyo.dao;

import java.util.List;


import tupyo.domain.Hubo;

public interface HuboDao {
	void create(Hubo hubo);
	Hubo selectOne(int kiho);
	List<Hubo> selectAll();
	void update(Hubo hubo);
	void delete(Hubo hubo);
	

}
