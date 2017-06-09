<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.Date" %>

<!-- Special version of Bootstrap that only affects content wrapped in .bootstrap-iso -->
<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" /> 

<!-- Inline CSS based on choices in "Settings" tab -->
<style>.bootstrap-iso .formden_header h2, .bootstrap-iso .formden_header p, .bootstrap-iso form{font-family: Arial, Helvetica, sans-serif; color: black}.bootstrap-iso form button, .bootstrap-iso form button:hover{color: white !important;} .asteriskField{color: red;}
        #Buttons {float: right} #OtherN {float: right} #SID {float: right} #FName {float: left} #PSTN {float: left; clear: both} #TandC {clear: both} #sign {clear: both; float: left} #offstamp {float: right} #Employee {clear: both} </style>

<!doctype html>
<html>
<!-- HTML Form (wrapped in a .bootstrap-iso div) -->
<div class="bootstrap-iso">
 <div class="container-fluid">
  <div class="row">
   <div class="col-md-6 col-sm-6 col-xs-12">
    <form method="post" action="/fifth">
     <div class="form-group " id="FName">
      <label class="control-label requiredField" for="name">
       First Name
       <span class="asteriskField">
        *
       </span>
      </label>
      <input class="form-control" id="name" name="name" type="text"/>
     </div>
     <div class="form-group " id="OtherN">
      <label class="control-label requiredField" for="name1">
       Other Names
       <span class="asteriskField">
        *
       </span>
      </label>
      <input class="form-control" id="name1" name="name1" type="text"/>
     </div>
     <div class="form-group " id="PSTN">
      <label class="control-label requiredField" for="text">
       Position
       <span class="asteriskField">
        *
       </span>
      </label>
      <input class="form-control" id="text" name="text" type="text"/>
     </div>
     <div class="form-group " id="SID">
      <label class="control-label requiredField" for="StaffID">
       Staff ID
       <span class="asteriskField">
        *
       </span>
      </label>
      <input class="form-control" id="StaffID" name="StaffID" type="text"/>
     </div>
     <div class="form-group ">
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
 </div>
</div>
</html>