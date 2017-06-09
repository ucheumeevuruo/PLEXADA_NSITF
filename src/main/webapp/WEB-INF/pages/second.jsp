<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.Date" %>

<!-- Special version of Bootstrap that only affects content wrapped in .bootstrap-iso -->
<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" /> 

<!-- Inline CSS based on choices in "Settings" tab -->
<style>.bootstrap-iso .formden_header h2, .bootstrap-iso .formden_header p, .bootstrap-iso form{font-family: Arial, Helvetica, sans-serif; color: black}.bootstrap-iso form button, .bootstrap-iso form button:hover{color: white !important;} .asteriskField{color: red;}
         #Next {float: right} </style>

<!-- HTML Form (wrapped in a .bootstrap-iso div) -->
<div class="bootstrap-iso">
 <div class="container-fluid">
  <div class="row">
   <div class="col-md-6 col-sm-6 col-xs-12">
    <form method="post" action="/second">
     <div class="form-group ">
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
       <button class="btn btn-primary " name="submit" type="Next" id="Next">
        Next
       </button>
      </div>
     </div>
    </form>
   </div>
  </div>
 </div>
</div>
