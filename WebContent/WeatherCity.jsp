<!DOCTYPE html >
<!--  Website template by freewebsitetemplates.com  -->
<html>
<head>
<title>Minimalistic Web Template</title>
<meta charset="iso-8859-1" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/structure.css">
<!--[if IE 6]>
		<link href="css/ie6.css" rel="stylesheet" type="text/css" />
	<![endif]-->
<!--[if IE 7]>
        <link href="css/ie7.css" rel="stylesheet" type="text/css" />  
	<![endif]-->
</head>

<body>
	<div id="background">
		<div id="page">
			<div class="header">
				<div class="footer">
					<div class="body">
						<div id="sidebar">
							<a href="index.html"><img id="logo" src="images/logo2.png"
								width="154" height="74" alt="" title="" /></a>
							<ul class="navigation">
								<li class="active" ><a href="index.html">HOME</a></li>
											<li><a href="WeatherCity.jsp">Check Weather!</a></li>
											<li><a href="registration.html">Subscribe!</a></li>
											<li><a href="unsubscribe.html">Unsubscribe!</a></li>
<!-- 											<li><a href="about.html">ABOUT</a></li> -->
<!-- 											<li><a href="blog.html">BLOG</a></li> -->
											<li class="last" ><a href="contact.html">Give us Feedback</a></li>
										</ul>
							<div class="connect">
								<a href="http://facebook.com/freewebsitetemplates"
									class="facebook">&nbsp;</a> <a
									href="http://twitter.com/fwtemplates" class="twitter">&nbsp;</a>
								<a href="http://www.youtube.com/fwtemplates" class="vimeo">&nbsp;</a>
							</div>
							<div class="footenote">
								<span>&copy; Copyright &copy; 2014.</span> <span><a
									href="index.html">Pooja Khullar</a> All rights reserved</span>
							</div>
						</div>
 						<div id="content">
<!-- 							<div class="content"> -->
								
								<form class="box login1" action="./ControllerWeather">
								
									<fieldset class="boxBody"> 
									<h1><font size="5" face="ComicSans">Hey, Hi!</font></h1>
									<br><label>Please Enter your Mobile No.:</label> <input type="text" tabindex="1"
											 required name="mobile">
										<label>Please Enter the city:</label> <input type="text" tabindex="2"
											 required name="tempcity"> 
 									</fieldset> 
									<footer>
										 <input type="submit" class="btnLogin"
											value="Submit" tabindex="4">
									</footer>
								</form>
								
<!--  							</div>  -->
						</div>
					</div>
				</div>
			</div>
			<div class="shadow"></div>
		</div>
	</div>
</body>
</html>