$(document).ready (
	function () {
	$("#employerDetails1").validate({
                    rules: {
						select: "required"
						Compensation: "required",
						fname: "required",
						lname: "required",
						EmpID: "required",
						StaffId: "required",
						mstat: "required",
						spouseno: "required",
						chno: "required",
						chage: "required",
						Address: "required",
						dfname: "required",
						dlname: "required",
						dob: {
							required: true
							}
						dfname2: 
						dmname2:
						dlname2:
						dfname3:
						dmname3:
						dlname3:
						dfname4:
						dmname4:
						dlname4:
					},
					
					messages: {
						select: 
						Compensation: 
						fname: "Please enter your First Name",
						lname: "Please enter your Last Name",
						EmpID: "Enter a valid Employee ID",
						StaffId: "Enter a valid Staff ID",
						mstat: "Please select Marital Status",
						spouseno: "Please select number of spouse",
						chno: "Please select number of children",
						chage: "Please select age range of children",
						Address: "This value is required"
						dfname: "Please enter Dependant's First Name",
						dlname: "Please enter Dependant's Last Name",
						dob: "Please select date",
						dfname2: 
						dmname2:
						dlname2:
						dfname3:
						dmname3:
						dlname3:
						dfname4:
						dmname4:
						dlname4:
					},
					
					submitHandler: function(form) {
						form.submit();
					},
					
	$("#healthStatus2").validate({
                    rules: {
						div_radio: {
							required: true
							},
						dateofinjury: "required"
						dateoftreat: "required"
						Hospital: "required"
						HouseNumber: "required"
						StreetNumber: "required"
						State: {
							required: true
							}
						LGA: {
							required: true
							}
						SPname: "required"
						SPname1: "required"
						PracticeNum: "required"
					},
						
					messages: {
						div_radio: "Please make a choice",
						dateofinjury: "Please select date",
						dateoftreat: "Please select date",
						Hospital: "This field is required",
						HouseNumber: "This field is required",
						StreetNumber: "This field is required",
						State: "Please select a state",
						LGA: "Please select a Local government area by States",
						SPname: "Please enter Specialist's First Name",
						SPname1: "Please enter Specialist's Last Name",
						PracticeNum: "Please enter a valid  Practice Number of Specialist"
					},
					 
					submitHandler: function(form) {
						form.submit();
					},
					
	$("#attachments4").validate({
                    rules: {
						div_radio: "required"
						fileToUpload1: {
							required: true,
							accept: "png|jpe?g|gif",
							filesize: 1048576
							},
						fileToUpload2: {
							required: true,
							accept: "png|jpe?g|gif",
							filesize: 1048576
							}
					},
						
					messages: {
						div_radio: "Please make a choice",
						fileToUpload1: "Please Upload recipt for treatment",
						fileToUpload2: "Please Upload Details of all bill"
					},
						
					submitHandler: function(form) {
						form.submit();
					},

					
						