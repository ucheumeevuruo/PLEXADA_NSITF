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
                <li><a href="#">Total Emolument </a></li>
                <li class="active"><a href="#">Business sector categories </a></li>
                <li><a href="#">Particulars of owner(s) of organization </br> (for  partnership &amp; sole proprietorship) &nbsp; &nbsp; &nbsp; </a></li>
                <li><a href="#">Declaration by employer or authorised person &nbsp; &nbsp; &nbsp; </a></li>
                <li><a href="#">Preview Registration </a></li>
            </ul>
        </div>
		
		<div class="col-md-6 col-sm-6 col-xs-12">
			<form method="post" action="/account/fourth-page" id="thirdpage">
			 <div class="form-group">
			  <label class="control-label requiredField">
			   Class of Business
			   <span class="asteriskField">
				*
			   </span>
			  </label>
			  <div class=" ">
			   <div class="checkbox">
				<label class="checkbox">
				 <input name="checkbox" type="radio" value="Enterprise venture"/>
				 Enterprise venture
				</label>
			   </div>
			   <div class="checkbox">
				<label class="checkbox">
				 <input name="checkbox" type="radio" value="Partnership"/>
				 Partnership
				</label>
			   </div>
			   <div class="checkbox">
				<label class="checkbox">
				 <input name="checkbox" type="radio" value="MDA"/>
				 MDA
				</label>
			   </div>
			   <div class="checkbox">
				<label class="checkbox">
				 <input name="checkbox" type="radio" value="Public Sector"/>
				 Public Sector
				</label>
			   </div>
			   <div class="checkbox">
				<label class="checkbox">
				 <input name="checkbox" type="radio" value="PLC"/>
				 PLC
				</label>
			   </div>
			   <div class="checkbox">
				<label class="checkbox">
				 <input name="checkbox" type="radio" value="LTD"/>
				 LTD
				</label>
			   </div>
			  </div>
			 </div>
			 <div class="form-group ">
			  <label class="control-label requiredField" for="select">
			   Please select
			   <span class="asteriskField">
				*
			   </span>
			  </label>
			  <select class="select form-control" id="select" name="select">
                              <option value="Aviation">
				Aviation
			      </option>
                              
			  </select>
			  <span class="help-block" id="hint_select">
			   Press Ctrl for multiple select
			  </span>
			 </div>
			 <div class="form-group ">
			  <label class="control-label " for="name">
			   Others please specify
			  </label>
			  <input class="form-control" id="name" name="name" type="text"/>
			  <span class="help-block" id="hint_name">
			   Separate with comma. e.g, item1, item2
			  </span>
			 </div>
			 <div class="form-group">
			  <div id="Next">
			   <button class="btn btn-primary " name="Next" type="submit">
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