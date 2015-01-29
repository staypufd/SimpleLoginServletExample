
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Logged In</title>
</head>
<body>
  	<form action="login" method="post">
		<input type="hidden" name="action" value="login">
		
		<label>Name:</label>
		<input type="text" name="name" required><br/>
		
		<label>Password:</label>
		<input type="password" name="password" required><br/>
		
		<label>&nbsp;</label>
		<input type="submit" value="Login" id="submit">
	</form>
</body>
</html>