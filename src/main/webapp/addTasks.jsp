<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<html>
<head>

	<style>
		table,tr,td {
		border:solid;
		}
	</style>
</head>
<body>

<form action="addData2" method="post">
	Theme Name : <b>${themeName}</b>
	<br>
	<br>
	
	<%! int i; %>
	<%! int j; %>
	
	<table>
	<%for ( i = 0; i < (Integer)request.getAttribute("numTasks"); i++) { %>
		<tr>
			<td>
				<%=i+1%>.
			</td>
			<td>
				Task belongs to stage :
			</td>
			<td> 
				<select name="inputStage<%=i%>">
					<% for ( j = 0; j < (Integer)request.getAttribute("numStages"); j++){ %>
						<option value="<%= j+1 %>"><%= j+1 %></option>
			      <%}%>
			    </select>
			</td>
	    	<td>	
	    		Task Description :
	    	</td>
	    	<td> 
	    		<input type="text" name="taskDesc<%=i%>">
	    	</td>
	    </tr>
	<%}%>
    <tr>
    	<td colspan=5>
   			<input type="submit" value="Submit" style="width:100%; height:30px; background-color:green; color:white; font-size:17px">
   		</td>
   	</tr>
   	</table>
</form>

</body>
</html>
