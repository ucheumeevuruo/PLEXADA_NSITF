<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>page</title>
    <!-- Look of this document is driven by a CSS referenced by an href attribute. See http://www.w3.org/TR/xml-stylesheet/ -->
<link rel="StyleSheet" type="text/css" href="http://SAPTRAINING-PC:8082/resource/file%3A/C%3A/Users/SAP%2520Training/Documents/NetBeansProjects/PLEXADA_NSITF/src/main/resources/static/css/bootstrap.min.css" media="screen" >
 <!-- Look of this document is driven by a CSS referenced by an href attribute. See http://www.w3.org/TR/xml-stylesheet/ -->
<link rel="StyleSheet" type="text/css" href="http://SAPTRAINING-PC:8082/resource/file%3A/C%3A/Users/SAP%2520Training/Documents/NetBeansProjects/PLEXADA_NSITF/src/main/resources/static/css/styles.css" media="screen" >
	<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />
	<style> .bootstrap-iso .formden_header h2, .bootstrap-iso .formden_header p, .bootstrap-iso form{font-family: Arial, Helvetica, sans-serif; color: black}.bootstrap-iso form button, .bootstrap-iso form button:hover{color: white !important;} .asteriskField{color: red;}
                #Buttons {float: right}
                #OtherN {float: right}
                #SID {float: right}
                #FName {float: left}
                #PSTN {float: left; clear: both}
                #TandC {clear: both}
                #sign {clear: both; float: left}
                #offstamp {float: right}
                #Employee {clear: both}
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
                <li><a href="#">Business sector categories </a></li>
                <li><a href="#">Particulars of owner(s) of organization </br> (for  partnership &amp; sole proprietorship) &nbsp; &nbsp; &nbsp; </a></li>
                <li class="active"><a href="#">Declaration by employer or authorised person &nbsp; &nbsp; &nbsp; </a></li>
                <li><a href="#">Preview Registration </a></li>
            </ul>
        </div>
		
		
		
		<div class="col-lg-7 col-md-7 col-sm-12">
			<form method="post">
			 <div class="form-group" id="FName">
			  <label class="control-label requiredField" for="name">
			   First Name
			   <span class="asteriskField">
				*
			   </span>
			  </label>
			  <input class="form-control" id="name" name="name" type="text"/>
			 </div>
			 <div class="form-group" id="OtherN">
			  <label class="control-label requiredField" for="name1">
			   Other Names
			   <span class="asteriskField">
				*
			   </span>
			  </label>
			  <input class="form-control" id="name1" name="name1" type="text"/>
			 </div>
			 <div class="form-group" id="PSTN">
			  <label class="control-label requiredField" for="Position">
			   Position
			   <span class="asteriskField">
				*
			   </span>
			  </label>
			  <input class="form-control" id="Position" name="Position" type="text"/>
			 </div>
			 <div class="form-group" id="SID">
			  <label class="control-label requiredField" for="StaffID">
			   Staff ID
			   <span class="asteriskField">
				*
			   </span>
			  </label>
			  <input class="form-control" id="StaffID" name="StaffID" type="text"/>
			 </div>
			 <div class="form-group">
			  <!-- <label class="control-label requiredField">
			   Check all that apply
			   <span class="asteriskField">
				*
			   </span>
			  </label> -->
			  
			  <div id="sign">
			   Signature
			   <span class="asteriskField">
				*
			   </span>
			  <form action="upload.php" method="POST" enctype="multipart/form-data">
				 <input type="file" name="image" />
			  </form>
			  <span class="help-block" id="hint_name">
			   *Minimum 200*200px </br> *Maximum size 200kb </br> *Supports only JPEG, PNG and GIF
			  </span>
			  </div>
			  
			  <div id="offstamp">
			  Official stamp
			   <span class="asteriskField">
				*
			   </span>
			  <form action="upload.php" method="POST" enctype="multipart/form-data">
				 <input type="file" name="image" />
			  </form>
			  <span class="help-block" id="hint_name">
			   *Minimum 200*200px </br> *Maximum size 200kb </br> *Supports only JPEG, PNG and GIF
			  </span>
			  </div>
			  
			  <div id="Employee">
			  Employee list
			  <span class="asteriskField">
				*
			   </span>
			  <form action="upload.php" method="post" enctype="multipart/form-data">
				 <input type="file" name="fileToUpload" id="fileToUpload"> 
			  </form> 
			  <span class="help-block" id="hint_name">
			  *Maximum size 200kb </br> *Supports only xlsx
			  </span>
			  </div>
					   </br></br>

			  <div class=" ">
			   <div class="checkbox" id="TandC">
				<label class="checkbox">
				 <input name="checkbox" type="checkbox" value="I agree to NSITF Terms and Conditions and certify that the above particulars are correct"/>
				 I agree to NSITF Terms and Conditions and certify that the above particulars are correct
				</label>
			   </div>
			  </div>
			 </div>
			 <div class="form-group">
			  <div>
			  
			  <span id="Buttons"> <button class="btn btn-primary " name="Back" type="submit">
				Back
			   </button>
			   
			   <button class="btn btn-primary " name="Next" type="submit">
				Next
			   </button> </span>
			  </div>
			 </div>
			</form>
		   </div>
    </div>
	
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>