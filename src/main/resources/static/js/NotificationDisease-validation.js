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
			
	
		$("#DiseaseNotification2").validate({
                    rules: {
						WorkNature: "required",
						DiseaseNature: "required",
						State: {
							required: true
							},
						LGA: {
							required: true
							},
						COD: "required",
						Disdate: "required",
						Diagdate: "required",
						Length: "required",
						Ceasedate: "required",
						Resumedate: "required",
						Numday: "required",
						div_radio3: {
							required: true
							},
							
						fname: "required",
						Lname: "required",
						Practicenum: "required",
						
						NKfname: "required",
						NKLname: "required",
						DFname: "required",
						DLname: "required",
						DOB: {
							required: true
							}
                            },
							
					messages: {
						WorkNature: "Please specify nature of work",
						DiseaseNature: "Please specify nature of disease",
						State: "Please select a state",
						LGA: "Please select a Local government area by States",
						COD: "Please specify Suspected Cause of Disease",
						Disdate: "Please select a date",
						Diagdate: "Please select a date",
						Length: "",
						Ceasedate: "Please select a date",
						Resumedate: "Please select a date",
						Numday: "",
						fname: "Please enter Practitioner's First Name",
						Lname: "Please enter Practitioner's Last Name",
						Practicenum: "This value is required",
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
						name: "Please enter Full Name",
						div_checkbox: "Please agree with the terms and conditions"
					},
					
					submitHandler: function(form) {
						form.submit();
					}
		});
		 }
);
						
						