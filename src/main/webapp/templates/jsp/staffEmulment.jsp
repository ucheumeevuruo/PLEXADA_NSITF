<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>page</title>
    <<!-- Look of this document is driven by a CSS referenced by an href attribute. See http://www.w3.org/TR/xml-stylesheet/ -->
<link rel="StyleSheet" type="text/css" href="http://SAPTRAINING-PC:8082/resource/file%3A/C%3A/Users/SAP%2520Training/Documents/NetBeansProjects/PLEXADA_NSITF/src/main/resources/static/css/bootstrap.min.css" media="screen" >
    <!-- Look of this document is driven by a CSS referenced by an href attribute. See http://www.w3.org/TR/xml-stylesheet/ -->
<link rel="StyleSheet" type="text/css" href="http://SAPTRAINING-PC:8082/resource/file%3A/C%3A/Users/SAP%2520Training/Documents/NetBeansProjects/PLEXADA_NSITF/src/main/resources/static/css/styles.css" media="screen" >
	<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" /> 
	<style> .bootstrap-iso .formden_header h2, .bootstrap-iso .formden_header p, .bootstrap-iso form{font-family: Arial, Helvetica, sans-serif; color: black}.bootstrap-iso form button, .bootstrap-iso form button:hover{color: white !important;} .asteriskField{color: red;}
                #Next {float: right}
                .text-center {font-family: Helvetica, Arial, Sans-Serif; color: white; font-size: 20px;}
        </style>
</head>

<body>
    <div class="container">
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">
			<h3 class="text-center"> REGISTRATION OF EMPLOYERS </h3>
                <div class="navbar-header">
                    <button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
                </div>
                <div class="collapse navbar-collapse" id="navcol-1"></div>
            </div>
        </nav>
    </div>
    <div class="container">
        <div class="col-lg-4 col-md-4 col-md-offset-0">
            <ul class="nav nav-pills nav-stacked">
                <li><a href="#">Particulars for business </br> (for MDAs, public and private companies) &nbsp; &nbsp; &nbsp; </a></li>
                <li class="active"><a href="#">Total Emolument </a></li>
                <li><a href="#">Business sector categories </a></li>
                <li><a href="#">Particulars of owner(s) of organization  </br> (for  partnership &amp; sole proprietorship) &nbsp; &nbsp; &nbsp; </a></li>
                <li><a href="#">Declaration by employer or authorised person &nbsp; &nbsp; &nbsp; </a></li>
                <li><a href="#">Preview Registration </a></li>
            </ul>
        </div>
		
		<div class="col-md-6 col-sm-6 col-xs-12">
			<form method="post" action="/account/third-page">
			 <div class="form-group">
			  <label class="control-label requiredField" for="Emoulment">
			   Total Staff Emoulment ('&#8358;')
			   <span class="asteriskField">
				*
			   </span>
			  </label>
			  <input class="form-control" id="Emoulment" name="Emoulment" type="text"/>
			 </div>
			 <div class="form-group">
			  <div>
			   <button class="btn btn-primary" name="submit" type="Next">
				Next
			   </button>
			  </div>
			 </div>
			</form>
		</div>
		
    </div>
	<div class="container">
	  
	</div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>