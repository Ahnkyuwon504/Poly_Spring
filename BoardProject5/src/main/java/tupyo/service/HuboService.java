package tupyo.service;

import java.util.List;

import tupyo.domain.Hubo;

public interface HuboService {
	void create(Hubo hubo);
	Hubo selectOne(int kiho);
	List<Hubo> selectAll();
	void update(Hubo hubo);
	void delete(Hubo hubo);

}
