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
    <form method="post" action="/third">
     <div class="form-group ">
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
 </div>
</div>

