<?php
    
    $host = "mysql11.000webhost.com";
    $user = "a7053728_alex";
    $pass = "a654321";
    $db = "a7053728_test";
    
    mysql_connect($host, $user, $pass);
    mysql_select_db($db);
   /*
    if (isset($_POST['username']))  {
        $username = $_POST['username'];
        $password = $_POST['password'];
        $sql = "SELECT * FROM test WHERE username='".$username."' AND password '".$password."' LIMIT 1";
        $res = mysql_query($sql);
        if (mysql_num_rows($res) == 1 ) {
            echo "You havve succesfully logged in.";
            exit();
        } else {
            echo "Invalid login information. Please return to the login page.";
            exit();
        }
        
        
    }
    */
    
    // include dirname(__FILE__).'/zyro/index.php';
    //	to use index file from different location use this line:
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Welcome To Your Webpage</title>
    <link href="style.css" rel="stylesheet" type="test/css" />
    <link href="menu.css" rel="stylesheet" type="test/css" />
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
			<h1>HOME PAGE</h1>
		</div>
		<div id="contentLeft">
			<applet code = "Test.class" width="400" height="100">
			</applet>
            <script type="text/javascript">
                function people(one, two) {
                    document.write(one + " is better than " + two + "<br />");
                }
                people("hamza", "abdul");
                people("koki", "jesse");
                people("barbra", "nicole");
            </script>
			<h2>Your text here.</h2>
			<h6>Messege...</h6>
		</div>
		<div id="contentRight">
			
		</div>
	</div>
	<div id="footer" class="footer">
    		<div class="validator">
    		<p>
      		<a href="http://validator.w3.org/check?uri=referer"><img src="http://www.w3.org/Icons/valid-xhtml10" 			alt="Valid XHTML 1.0 Transitional" height="31" width="88" /></a>
    		</p>
    		</div>	
	</div>
	</div>

  </body>
</html>
