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
						workNature: "required",
						diseaseNature: "required",
						state: {
							required: true
							},
						province: {
							required: true
							},
						cod: "required",
						reportDate: "required",
						diagnosisDate: "required",
						length: "required",
						ceaseDate: "required",
						resumeDate: "required",
						numDay: "required",
						div_radio3: {
							required: true
							},
							
						medicFirstName: "required",
						medicLastName: "required",
						practiceNumber: "required",
						
						kinFirstName: "required",
						kinLastName: "required",
						dFirstName: "required",
						dLastName: "required",
						dDob: {
							required: true
							}
                            },
							
					messages: {
						workNature: "Please specify nature of work",
						diseaseNature: "Please specify nature of disease",
						state: "Please select a state",
						province: "Please select a Local government area by States",
						cod: "Please specify Suspected Cause of Disease",
						reportDate: "Please select a date",
						diagnosisDate: "Please select a date",
						Length: "",
						ceaseDate: "Please select a date",
						resumeDate: "Please select a date",
						numDay: "",
						medicFirstName: "Please enter Practitioner's First Name",
						medicLastName: "Please enter Practitioner's Last Name",
						practiceNumber: "This value is required",
						div_radio3: "Please make a choice",
						kinFirstName: "Please enter Next of Kin's First Name",
						kinLastName: "Please enter Next of Kin's Last Name",
						DFname: "Please enter Dependant's First Name",
						DLname: "Please enter Dependant's Last Name",
						dDob: "Please select date"
						
					},
						
					submitHandler: function(form) {
						form.submit();
					}
		});
                
                $("#AccidentNotification2").validate({
                    rules: {
						doA: {
							required: true
							},
						toA: "required",
						poA: "required",
						state: {
							required: true
							},
						province: {
							required: true
							},
						reportDate: "required",
						reportTime: "required",
						message1: "required",
						message: "required",
						div_radio: {
							required: true
							},
						div_radio1: {
							required: true
							},
						medicFirstName: "required",
						medicLastName: "required",
						practiceNumber: "required",
						workMonth: "required",
						ceaseDate: {
							required: true
							},
						div_radio2: {
							required: true
							},
						resumeDate: {
							required: true
							},
						div_radio3: {
							required: true
							},
						kinFirstName: "required",
						kinLastName: "required",
						dFirstName: "required",
						dLastName: "required",
						dDob: {
							required: true
							}
                                      },
							
					messages: {
						doA: "Please select date",
						toA: "Please select time",
						poA: "This field is required",
						state: "Please select a state",
						province: "Please select a Local government area by States",
						reportDate: "Please select a date",
						reportTime: "Please select time",
						message1: "",
						message: "",
						div_radio: "Please make a choice",
						div_radio1: "Please make a choice",
						medicFirstName: "Please enter Practitioner's First Name",
						medicLastName: "Please enter Practitioner's Last Name",
						practiceNumber: "This value is required",
						workMonth: "This value is required",
						ceaseDate: "Please select a date",
						div_radio2: "Please make a choice",
						resumeDate: "Please select date",
						div_radio3: "Please make a choice",
						kinFirstName: "Please enter Next of Kin's First Name",
						kinLastName: "Please enter Next of Kin's Last Name",
						DFname: "Please enter Dependant's First Name",
						DLname: "Please enter Dependant's Last Name",
						dDob: "Please select date"
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
						
						