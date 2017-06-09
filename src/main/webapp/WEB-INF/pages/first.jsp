<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.Date" %>

<!-- Special version of Bootstrap that only affects content wrapped in .bootstrap-iso -->
<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" /> 

<!-- Inline CSS based on choices in "Settings" tab -->
<style>.bootstrap-iso .formden_header h2, .bootstrap-iso .formden_header p, .bootstrap-iso form{font-family: Arial, Helvetica, sans-serif; color: black}.bootstrap-iso form button, .bootstrap-iso form button:hover{color: white !important;} .asteriskField{color: red;}
         #MobileN { float: right;} #Email {float: left;} #State {clear: both; float: left} #LGA {float: right} #Address{clear: both} #Next {float: right}</style>

<!-- HTML Form (wrapped in a .bootstrap-iso div) -->
<form:form method="POST" modelAttribute="first" action="first.htm" >
    
<div class="bootstrap-iso">
 <div class="container-fluid">
  <div class="row">
   <div class="col-md-6 col-sm-6 col-xs-12">
    <form method="post" action="/first">
     <div class="form-group ">
      <label class="control-label requiredField" for="Company's Name">
       Company's Name
       <span class="asteriskField">
        *
       </span>
      </label>
      <input class="form-control" id="Company's Name" name="Company's Name" type="text"/>
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
      <input class="form-control" id="TINNumber" name="TINNumber" type="text"/>
     </div>
	 
     <div class="form-group ">
      <label class="control-label requiredField" for="year">
       What is the year of company incorporation
       <span class="asteriskField">
        *
       </span>
      </label>
      <select class="form-control" id="year" name="year" placeholder="YYYY" type="text"/>
	  </select>
     </div>
	  
     <div class="form-group " id="Email">
      <label class="control-label requiredField" for="email">
       Email
       <span class="asteriskField">
        *
       </span>
      </label>
      <input class="form-control" id="email" name="email" type="text"/>
     </div>
	 
     <div class="form-group " id="MobileN">
      <label class="control-label requiredField" for="MobileNumber">
       Mobile Number
       <span class="asteriskField">
        *
       </span>
      </label>
      <input class="form-control" id="MobileNumber" name="MobileNumber" type="text"/>
     </div>
	 
	 
     <div class="form-group " id="State">
      <label class="control-label requiredField" for="select">
       State
       <span class="asteriskField">
        *
       </span>
      </label>
      <select class="select form-control" id="select" name="select">
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
      </select>
     </div>
	 
	 <div class="form-group " >
	 <p id="Address"> Address 
       <span class="asteriskField">
        *
       </span> </p>
	 </div>
	 
	 <div class="form-group ">
      <label class="control-label requiredField" for="House/Block No">
       House/Block No
      </label>
      <input class="form-control" id="House/Block No" name="House/Block No" type="text"/>
     </div>
	
	  <div class="form-group ">
      <label class="control-label requiredField" for="Street Name">
       Street Name
       <span class="asteriskField">
        *
       </span>
      </label>
      <input class="form-control" id="Street Name" name="Street Name" type="text"/>
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
 </div>
</div>
</form:form>
