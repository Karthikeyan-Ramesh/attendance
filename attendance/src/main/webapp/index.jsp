<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body class="body-contents">
<div class="frm">
	<form action="/login" method="POST">
		<input type="text" name="mobile" id="mobile" />
		<input type="password" name="pass" id="pass" />
		<a href="/create">Create New User</a>
		<input type="submit" class="button" value="Login" />
	</form>
</div>
</body>
</html>