package tupyo.dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tupyo.domain.Hubo;

public class HuboDaoImpl implements HuboDao {
	
	private static HuboDaoImpl instance = new HuboDaoImpl();
//	    시작하자마자 static에 하나 올려놓고 그것만 쓰는거야.. 왜냐 : 기능이 필요하지 상태가 필요한게 아니거든...
	private HuboDaoImpl() {
		//외부에선 절대 HuboDaoImpl()로 만들 수 없어.
	    
	}
//	
	public static HuboDaoImpl getInstance() {
		return instance;
	}
	
	static Connection conn;
	static Statement stmt;
	static ResultSet rset;
	
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
	public void create(Hubo hubo) {
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.20:33060/kopoctc", "root", "kopoctc");
			stmt = conn.createStatement();

			String QueryTxt = "insert into hubo values (" + hubo.getKiho() + ", '" + hubo.getName() + "');";
			stmt.execute(QueryTxt);
			

			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Hubo selectOne (int kiho) {
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.20:33060/kopoctc", "root", "kopoctc");
			stmt = conn.createStatement();

			String QueryTxt = "select * from hubo where kiho=" + kiho + ";";
			rset = stmt.executeQuery(QueryTxt);
			
			Hubo selectedHubo = new Hubo();
					
			while (rset.next()) {
				selectedHubo = new Hubo(rset.getInt(1), rset.getString(2));
			}

			rset.close();
			stmt.close();
			conn.close();
			
			return selectedHubo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Hubo> selectAll() {
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.20:33060/kopoctc", "root", "kopoctc");
			stmt = conn.createStatement();
			ArrayList<Hubo> listOfHubo = new ArrayList<Hubo>();
			rset = stmt.executeQuery("select * from hubo;");
			//conn = DriverManager.getConnection("jdbc:mysql://192.168.23.20:33060/kopoctc", "root", "kopoctc");
			
			while (rset.next()) {
				Hubo hubo = new Hubo();
				hubo.setKiho(rset.getInt(1));
				hubo.setName(rset.getString(2));
				
				listOfHubo.add(hubo);
			}
			
			rset.close();
			stmt.close();
			conn.close();
			
			return listOfHubo;
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void update(Hubo hubo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Hubo hubo) {
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.20:33060/kopoctc", "root", "kopoctc");
			stmt = conn.createStatement();

			String QueryTxt = "delete from hubo where kiho=" + hubo.getKiho() + ";";
			stmt.execute(QueryTxt);
			

			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
	
	
//
//	
//try {
//	ResultSet rset = stmt.executeQuery("select * from hubo;");
//	
//	while (rset.next()) {
//%>
//		<tr>
//			<td width=100><p>기호번호 : <%=rset.getInt(1)%></p></td>
//			<td width=250><p>후보명 : <%=rset.getString(2)%></p></td>
//			<td width=50 style='text-align:right;'><p>
//				<form id='delete<%=rset.getInt(1)%>' action='./A02.jsp' method='post' target='main'>
//				<input type='hidden' name='kiho_key' value='<%=rset.getInt(1)%>'/>
//				<input type='hidden' name='name_key' value='<%=rset.getString(2)%>'/>
//				</form>
//				<button onclick='javascript:$("#delete<%=rset.getInt(1)%>").submit()'>삭제</button>
//		</td>
//		</tr>
//<%
//	}
//	
//	rset.close();
//	stmt.close();
//	conn.close();
//} catch (SQLSyntaxErrorException se) {
//	out.println(se);
//} catch (Exception e) {
//	out.println(e);
//
//}
