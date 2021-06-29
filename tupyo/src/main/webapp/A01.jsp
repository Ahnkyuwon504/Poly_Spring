<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A01</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	function submit2(frm) {
		frm.action='./A02.jsp';
		frm.method='post';
		frm.target='main';
		frm.submit();
		return true;
	}
</script>
<script>		
	 // 특수문자 정규식 변수(공백 미포함)
    var replaceChar = /[~!@\#$%^&*\()\-=+_'\;<>0-9\/.\`:\"\\,\[\]?|{}]/gi;
 
    // 완성형 아닌 한글 정규식
    var replaceNotFullKorean = /[ㄱ-ㅎㅏ-ㅣ]/gi;
    
    $(document).ready(function(){
        
        $("#inputname").on("focusout", function() {
            var x = $(this).val();
            if (x.length > 0) {
                if (x.match(replaceChar) || x.match(replaceNotFullKorean)) {
                    x = x.replace(replaceChar, "").replace(replaceNotFullKorean, "");
                }
                $(this).val(x);
            }
            }).on("keyup", function() {
                $(this).val($(this).val().replace(replaceChar, ""));
				
				  var a = $(this).val().replace(/ /gi, '');
				$(this).val(a);
		});
    });  
</script>
<style>
button {
            background-color:#FF5A5F;
            color:white;
            width: 70px;
            height: 45px;
            font-size: 15px;
            font-weight: 700;
            border-radius: 6px;
            border: 0;
            outline: 0;
        }



table.type11 {
  border-collapse: separate;
  border-spacing: 1px;
  text-align: left;
  line-height: 1.0;
  margin: 20px 10px;
}
table.type11 th {
  width: 200px;
  padding: 10px;
  font-weight: bold;
  vertical-align: top;
  color: #fff;
  background: #ce4869 ;
}
table.type11 td {
  width: 200px;
  padding: 10px;
  vertical-align: top;
  border-bottom: 1px solid #ccc;
  background: #eee;
}
</style>
</head>

<body>
<%
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.20:33060/kopoctc", "root", "kopoctc");
	Statement stmt = conn.createStatement();
	
%>
	<table class="type11">
<%
try {
	ResultSet rset = stmt.executeQuery("select * from hubo;");
	
	while (rset.next()) {
%>
		<tr>
			<td width=100><p>기호번호 : <%=rset.getInt(1)%></p></td>
			<td width=250><p>후보명 : <%=rset.getString(2)%></p></td>
			<td width=50 style='text-align:center;'><p>
				<form id='delete<%=rset.getInt(1)%>' action='./A02.jsp' method='post' target='main'>
				<input type='hidden' name='kiho_key' value='<%=rset.getInt(1)%>'/>
				<input type='hidden' name='name_key' value='<%=rset.getString(2)%>'/>
				</form>
				<button href='#' onclick='javascript:$("#delete<%=rset.getInt(1)%>").submit()'>삭제</button>
			</p></td>
		</tr>
<%
	}
	
	rset.close();
	stmt.close();
	conn.close();
} catch (SQLSyntaxErrorException se) {
	out.println(se);
} catch (Exception e) {
	out.println(e);
}
%>
		<form id='insert' action='./A03.jsp' method='post' target='main'>
		<tr>
			<td width=100><p>기호번호 : <input style='width:80px;' type='text' onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" name='kiho_insert_key'></p></td>
			<td width=250><p>후보명 : <input  style='width:80px;' type='text' name='name_insert_key' id='inputname'></p></td>
			<td width=50 style='text-align:center;'><p>
				<button href='#' onclick='javascript:$("#insert").submit()'>추가</button>
			</p></td>
		</tr>
		</form>
	</table>
</body>
</html>