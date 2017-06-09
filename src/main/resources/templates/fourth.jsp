<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.Date" %>

<!-- Special version of Bootstrap that only affects content wrapped in .bootstrap-iso -->
<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" /> 

<!-- Inline CSS based on choices in "Settings" tab -->
<style>.bootstrap-iso .formden_header h2, .bootstrap-iso .formden_header p, .bootstrap-iso form{font-family: Arial, Helvetica, sans-serif; color: black}.bootstrap-iso form button, .bootstrap-iso form button:hover{color: white !important;} .asteriskField{color: red;}
        #Ownerf {float: left} #Ownerl {float: right} #Ownerp {clear: both; float: left} #Ownere {float: right} #ModeID { } #downb { float: right}</style>

<!-- HTML Form (wrapped in a .bootstrap-iso div) -->
<div class="bootstrap-iso">
 <div class="container-fluid">
  <div class="row">
   <div class="col-md-6 col-sm-6 col-xs-12">
    <form method="post" action="/fourth">
     <div class="form-group " id="Ownerf">
      <label class="control-label " for="name">
       Owner's First Name
      </label>
      <input class="form-control" id="name" name="name" type="text"/>
     </div>
     <div class="form-group " id="Ownerl">
      <label class="control-label " for="name1">
       Owner's Last Name
      </label>
      <input class="form-control" id="name1" name="name1" type="text"/>
     </div>
     <div class="form-group " id="Ownerp">
      <label class="control-label " for="text">
       Position
      </label>
      <input class="form-control" id="text" name="text" type="text"/>
     </div>
     <div class="form-group " id="Ownere">
      <label class="control-label requiredField" for="email">
       Email
      </label>
      <input class="form-control" id="email" name="email" type="text"/>
     </div>
     <div class="form-group " id="ModeID">
      <label class="control-label " for="select">
       Mode of Identification
      </label>
      <select class="select form-control" id="select" name="select">
       <option selected="selected" value="">
       </option>
       <option value="Drivers License">
	    Drivers License
       </option>
       <option value="National I.D">
        National I.D
       </option>
       <option value="International Passport">
        International Passport
       </option>
      </select>
     </div>
     <div class="form-group ">
      <label class="control-label " for="tel">
       Mobile Number
      </label>
      <input class="form-control" id="tel" name="tel" type="text"/>
     </div>
     <div class="form-group">
      <div id="downb">
	  
	  <button class="btn btn-primary " name="Back" type="submit">
        Back
       </button>
	   
       <button class="btn btn-primary " name="Next" type="submit">
        Next
       </button>
      </div>
     </div>
    </form>
   </div>
  </div>
 </div>
</div>
