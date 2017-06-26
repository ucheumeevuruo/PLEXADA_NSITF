$(document).ready (
	function () {
	$("#EmployeeDetails").validate({
                    rules: {
						fname: "required",
						Lname: "required",
						EmpID: "required",
						staffID: "required",
						Earnings: "required",
						yrs: "required",
						months: "required"
						},
						
					messages: {
						fname: "Please enter your First Name",
						Lname: "Please enter your Last Name",
						EmpID: "Enter a valid Employee ID",
						staffID: "Enter a valid Staff ID",
						Earnings: "This value is required",
						yrs: "This value is required",
						months: "This value is required"
						},
						
					submitHandler: function(form) {
					 form.submit();
					}
		});
			
	
		$("#AccidentNotification2").validate({
                    rules: {
						DOA: {
							required: true
							},
						TOA: "required",
						POA: "required",
						State: {
							required: true
							},
						LGA: {
							required: true
							},
						Reportdate: "required",
						Reporttime: "required",
						message1: "required",
						message: "required",
						div_radio: {
							required: true
							},
						div_radio1: {
							required: true
							},
						fname: "required",
						Lname: "required",
						Practicenum: "required",
						workmnth: "required",
						ceasedate: {
							required: true
							},
						div_radio2: {
							required: true
							},
						resumedate: {
							required: true
							},
						div_radio3: {
							required: true
							},
						NKfname: "required",
						NKLname: "required",
						DFname: "required",
						DLname: "required",
						DOB: {
							required: true
							},
							
					messages: {
						DOA: "Please select date",
						TOA: "Please select time",
						POA: "This field is required",
						State: "Please select a state",
						LGA: "Please select a Local government area by States",
						Reportdate: "Please select a date",
						Reporttime: "Please select time",
						message1: 
						message: 
						div_radio: "Please make a choice",
						div_radio1: "Please make a choice",
						fname: "Please enter Practitioner's First Name",
						Lname: "Please enter Practitioner's Last Name",
						Practicenum: "This value is required",
						workmnth: "This value is required",
						ceasedate: "Please select a date",
						div_radio2: "Please make a choice",
						resumedate: "Please select date",
						div_radio3: "Please make a choice",
						NKfname: "Please enter Next of Kin's First Name",
						NKLname: "Please enter Next of Kin's Last Name",
						DFname: "Please enter Dependant's First Name",
						DLname: "Please enter Dependant's Last Name",
						DOB: "Please select date"
					},
						
					submitHandler: function(form) {
						form.submit();
					}
		});
		
		$("#AccidentNotification2").validate({
                    rules: {
						Signature: {
							required: true,
							accept: "png|jpe?g|gif",
							filesize: 1048576
							},
						Stamp: {
							required: true,
							accept: "png|jpe?g|gif",
							filesize: 1048576
							},
						name: "required",
						div_checkbox: "required"
					},
						
					messages: {
						Signature: "File must be JPG, GIF or PNG, less than 1MB",
						Stamp: "File must be JPG, GIF or PNG, less than 1MB",
						name: "Please enter Full Name"
						div_checkbox: "Please agree with the terms and conditions"
					},
					
					submitHandler: function(form) {
						form.submit();
					}
		});
		 }
);						