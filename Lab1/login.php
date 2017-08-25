<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Login Page</title>
	<link rel="stylesheet" type="test/css" href="style.css">
	<link rel="stylesheet" type="test/css" href="menu.css">
    </head>
    <body>
	<div id="holder" class="holder">
	<div id="header" class="header"></div>
	<div id="navBar" class="navBar">
		<nav>
		<ul>
			<li><a href="index.php">Home</a></li>
			<li><a href="login.php">Login</a></li>
			<li><a href="register.php">Register</a></li>
			<li><a href="forgot.php">Forgot Password</a></li>
		</ul>
		</nav>	
	</div>
	<div id="content" class="content">
		<div id="pageHeading">
			<h1>Please Login here.</h1>
		</div>
		<div id="contentLeft">
			<h2>Enter your username and password.</h2>
			<h6>If you do not have one click on Register...</h6>
		</div>
		<div id="contentRight">
			<div id="frm">
           			<form action="procces.php" method="post">
				<p>
                    			Username: <input type="text" id="user" name="user" /><br /><br />
				</p>
				<p>
                   			Password: <input type="password" id="pass" name="pass" /><br /><br />
				</p>
				<p>
                    			<input type="submit" id="btn" name="submit" value="Log-In" />
				</p>
				<p>
		    			<a href="register.php">Register</a>
				</p>
            			</form>
			</div> 
		</div>
	</div>
	<div id="footer" class="footer">
    <div class="validator">
    <p>
      <a href="http://validator.w3.org/check?uri=referer"><img src="http://www.w3.org/Icons/valid-xhtml10" 
	alt="Valid XHTML 1.0 Transitional" height="31" width="88" /></a>
    </p>
    </div>
	</div>
	</div>

  </body>
</html>
