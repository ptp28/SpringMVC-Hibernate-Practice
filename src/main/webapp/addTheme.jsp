<html>
<body>

<form action="addData1" method="post">
	Theme Name : 
	<input type="text" name="themeName"><br>
	
	<br>
	Number of Stages :
	<select name="numStages">
	<%! int num; %>
	<%for ( num = 1; num <= 5; num++){ %>
		<option value="<%= num %>"><%= num %></option>
      <%}%>
    </select>
      
    <br>
	Number of Tasks :
	<select name="numTasks">
	<%for ( num = 1; num <= 10; num++){ %>
		<option value="<%= num %>"><%= num %></option>
      <%}%>
    </select>
    
    <br>
   	<input type="submit" value="Next"> 
</form>

</body>
</html>
