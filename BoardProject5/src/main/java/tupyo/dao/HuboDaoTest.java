package tupyo.dao;

import tupyo.domain.Hubo;

public class HuboDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hubo hubo = new Hubo();
		hubo.setKiho(2);
		hubo.setName("¶ó¶ó¸®¶ö·ç");
		
		HuboDao huboDao = new HuboDaoImpl();
		huboDao.create(hubo);

	}

}
