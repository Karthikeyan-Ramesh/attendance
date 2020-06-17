<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create User</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body class="body-contents">
<div class="frm">
	<form action="/create" method="POST">
	   <input type="text" placeholder="Enter User Name" name="uname" id="uname" />
		<input type="text" placeholder="Mobile Number" name="umobile" id="umobile" />
		<select name="uroleId" id="uroleId" onclick="popupbox()" >
		<option value="1">Student</option>
		<option value="2">Teacher</option>
		</select>
		<select name="tclass" id="tclass" style="display:none" >
		<option value="5">Low</option>
		<option value="6">High</option>
		</select>
		<select name="sclass" id="sclass" style="display:none" >
		<option value="1">I</option>
		<option value="2">II</option>
		<option value="3">III</option>
		<option value="4">IV</option>
		<option value="5">V</option>
		<option value="6">VI</option>
		<option value="7">VII</option>
		<option value="8">VIII</option>
		<option value="9">IX</option>
		<option value="10">X</option>
		<option value="11">XI</option>
		<option value="12">XII</option>
		</select>
		<input type="submit" class="button" value="Create" />
	</form>
</div>
<script type="text/javascript">

function popupbox(){
	var d=document.getElementById("uroleId").value;
	if(d==1)
		document.getElementById("sclass").style.display = "block";
	else if(d==2)
		document.getElementById("tclass").style.display = "block";
}
</script>
</body>
</html>