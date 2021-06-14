package tupyo.dao;

import java.util.List;


import java.io.*;
import java.sql.*;

import tupyo.domain.Hubo;

public class HuboDaoImpl implements HuboDao {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.20:33060/kopoctc", "root", "kopoctc");
			Statement stmt = conn.createStatement();
			ResultSet rset;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	@Override
	public void create(Hubo hubo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Hubo selectOne(int id) {
		// TODO Auto-generated method stub
		Hubo hubo = new Hubo();
		hubo.setKiho(1);
		hubo.setName("스프링이란..");
		return hubo;
	}

	@Override
	public List<Hubo> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Hubo hubo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Hubo hubo) {
		// TODO Auto-generated method stub
		
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
