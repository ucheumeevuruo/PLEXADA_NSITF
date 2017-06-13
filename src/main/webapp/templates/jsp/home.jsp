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

	<style>.bootstrap-iso .formden_header h2, .bootstrap-iso .formden_header p, .bootstrap-iso form{font-family: Arial, Helvetica, sans-serif; color: black}.bootstrap-iso form button, .bootstrap-iso form button:hover{color: white !important;} .asteriskField{color: red;}
                #MobileN { float: right;} 
                #Email {float: left;} 
                #State {clear: both; float: left} 
                #LGA {float: right} #Address{clear: both} 
                #Next {float: right} 
                .text-center {font-family: Helvetica, Arial, Sans-Serif; color: white; font-size: 20px;}
	</style>

        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="js/jquery.validate.min.js"> </script>
        <script src="js/home.validate.js"> </script>
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
        <div class="col-lg-4 col-md-4">
            <ul class="nav nav-pills nav-stacked">
                <li class="active"><a href="#">Particulars for business </br> (for MDAs, public and private companies) &nbsp; &nbsp; &nbsp; </a></li>
                <li><a href="#">Total Emolument </a></li>
                <li><a href="#">Business sector categories </a></li>
                <li><a href="#">Particulars of owner(s) of organization  </br> (for  partnership &amp; sole proprietorship) &nbsp; &nbsp; &nbsp; </a></li>
                <li><a href="#">Declaration by employer or authorized person &nbsp; &nbsp; &nbsp; </a></li>
                <li><a href="#">Preview Registration </a></li>
            </ul>
        </div>
		
		<div class="col-md-6 col-sm-6 col-xs-12">
			<form method="post" action="/account/second-page" id="firstpage">
			 <div class="form-group">
			  <label class="control-label requiredField" for="CompName">
			   Company's Name
			   <span class="asteriskField">
				*
			   </span>
			  </label>
			  <input class="form-control" id="CompName" name="CompName" type="text"/>
			 </div>
			 <div class="form-group ">
			  <label class="control-label requiredField" for="IncorporationNumber">
			   Incorporation Number
			   <span class="asteriskField">
				*
			   </span>
			  </label>
			  <input class="form-control" id="IncorporationNumber" name="IncorporationNumber" type="text"/>
			 </div>
			 <div class="form-group ">
			  <label class="control-label " for="TINNumber">
			   TIN Number
			  </label>
			  <input class="form-control" id="TINNumber" name="TINNumber" type="number"/>
			 </div>
			 
			 <div class="form-group ">
			  <label class="control-label requiredField" for="Year">
			   What is the year of company incorporation
			   <span class="asteriskField">
				*
			   </span>
			  </label>
			  <select class="form-control" id="Year" name="Year" placeholder="YYYY" type="number"/>
			  </select>
			 </div>
			  
			 <div class="form-group " id="Email">
			  <label class="control-label requiredField" for="email">
			   Email
			   <span class="asteriskField">
				*
			   </span>
			  </label>
			  <input class="form-control" id="email" name="email" type="email"/>
			 </div>
			 
			 <div class="form-group " id="MobileN">
			  <label class="control-label requiredField" for="MobileNumber">
			   Mobile Number
			   <span class="asteriskField">
				*
			   </span>
			  </label>
			  <input class="form-control" id="MobileNumber" name="MobileNumber" type="number"/>
			 </div>
			 
			 
			 <div class="form-group " id="State">
			  <label class="control-label requiredField" for="State">
			   State
			   <span class="asteriskField">
				*
			   </span>
			  </label>
			  <select class="select form-control" id="State" name="State">
                             <option selected="selected" value="">
			   </option>
			   <option value="Lagos">
				Lagos
			   </option>
                           </select>
			 </div>
                            
			 <div class="form-group " id="LGA">
			  <label class="control-label requiredField" for="LocalGovernment">
			   Local Government
			   <span class="asteriskField">
				*
			   </span>
			  </label>
			  <select class="select form-control" id="LocalGovernment" name="LocalGovernment">
                             <option selected="selected" value="">
			   </option>
			   <option value="Eti-Osa">
				Eti-Osa
			   </option>
                           </select>
			 </div>
			 
			 <div class="form-group " >
			 <p id="Address"> Address 
			   <span class="asteriskField">
				*
			   </span> </p>
			 </div>
			 
			 <div class="form-group ">
			  <label class="control-label requiredField" for="HouseNo">
			   House/Block No
			  </label>
			  <input class="form-control" id="HouseNo" name="HouseNo" type="number"/>
			 </div>
			
			  <div class="form-group ">
			  <label class="control-label requiredField" for="StreetName">
			   Street Name
			   <span class="asteriskField">
				*
			   </span>
			  </label>
			  <input class="form-control" id="StreetName" name="StreetName" type="text"/>
			 </div>
			 
			 
			 <div class="form-group" id="Next">
			  <div>
			   <button class="btn btn-primary " name="Next" type="submit">
				Next
			   </button>
			  </div>
			 </div>
			</form>
   </div>
    </div>
	
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>