package tupyo.dao;

import tupyo.domain.Hubo;
import tupyo.dao.*;

public class HuboDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hubo hubo = new Hubo();
		hubo.setKiho(2);
		hubo.setName("¶ó¶ó¸®¶ö·ç");
		
		HuboDao huboDao = HuboDaoImpl.getInstance();
		//HuboDao huboDao = huboDao.getInstance();
		huboDao.create(hubo);

	}
}
