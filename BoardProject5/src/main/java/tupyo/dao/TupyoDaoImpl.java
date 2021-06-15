package tupyo.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import tupyo.domain.Tupyo;
import tupyo.domain.Hubo;

public class TupyoDaoImpl implements TupyoDao {
	static Connection conn;
	static Statement stmt;
	static ResultSet rset;
	static int ageMax = 9;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.20:33060/kopoctc", "root", "kopoctc");
			stmt = conn.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void create(Tupyo tupyo) {
		// TODO Auto-generated method stub
		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.20:33060/kopoctc", "root", "kopoctc");
			stmt = conn.createStatement();

			String QueryTxt = "insert into tupyo values (" + tupyo.getKiho() + ", '" + tupyo.getAge() + "');";
			stmt.execute(QueryTxt);
			

			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Tupyo selectOne(int kiho) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tupyo> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Tupyo tupyo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Tupyo tupyo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int selectAllCount() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.20:33060/kopoctc", "root", "kopoctc");
			stmt = conn.createStatement();

			String QueryTxt = "select count(*) from tupyo;";
			int count = 0;
			rset = stmt.executeQuery(QueryTxt);
			
			if (!rset.isBeforeFirst()) return 0;
			
			while (rset.next()) {
				count = rset.getInt(1);
			}

			rset.close();
			stmt.close();
			conn.close();
			
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int selectOneCount(Hubo hubo) {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.20:33060/kopoctc", "root", "kopoctc");
			stmt = conn.createStatement();

			String QueryTxt = "select count(*) from tupyo where kiho=" + hubo.getKiho() +";";
			int count = 0;
			rset = stmt.executeQuery(QueryTxt);
			
			if (!rset.isBeforeFirst()) return 0;
			
			while (rset.next()) {
				count = rset.getInt(1);
			}

			rset.close();
			stmt.close();
			conn.close();
			
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public int[] selectOneAgeCount(Hubo hubo) {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.20:33060/kopoctc", "root", "kopoctc");
			stmt = conn.createStatement();
			int[] oneAgeCount = new int[ageMax];
			
			for (int i = 0; i < ageMax; i++) {
				String QueryTxt = 
						"select count(*) from tupyo where kiho=" + hubo.getKiho() + 
						" and age=" + (i+1) + ";";
				int count = 0;
				rset = stmt.executeQuery(QueryTxt);
				if (!rset.isBeforeFirst()) {
					oneAgeCount[i] = 0; 
					continue;
				}
				
				while (rset.next()) {
					count = rset.getInt(1);
				}
				
				oneAgeCount[i] = count;
				
			}

			rset.close();
			stmt.close();
			conn.close();
			
			return oneAgeCount;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
