<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="main.TransactionDao,main.Transaction ,main.TransactionDaoImpl,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display</title>
</head>
<body>
<%
	TransactionDao TransactionVar=new TransactionDaoImpl();
	List<Transaction> list = TransactionVar.GetAll();
	String trs="";
	for(Transaction l:list) trs+="<tr><td>"+l.getRef()+"</td>"+
			"<td>"+l.getCompteCred()+"</td>"+
			"<td>"+l.getCompteDeb()+"</td>"+
			"<td>"+l.getDate()+"</td>"+
			"<td>"+l.getDevise()+"</td>"+
			"<td>"+l.getDate()+"</td>"+
			"<td>"+l.getType()+"</td></tr>";
			
	out.write("<html>"
				+ "<body><h2>List of Transactions"
				+ "</h2></body></html>"
				+ "<table border=\"1\">"+
				trs
				+ "</table>");
	out.println("</body></html>");


%>

</body>
</html>