$(document).ready (
	function () {
	$("#employerDetails1").validate({
                    rules: {
						select: "required",
						compensation: "required",
						fName: "required",
						lName: "required",
						empId: "required",
						staffId: "required",
						maritalStatus: "required",
						spouseNumber: "required",
						childrenNumber: "required",
						childrenAge: "required",
						address: "required",
						dFirstName: "required",
						dLastName: "required",
						dDob: {
							required: true
							}
					},
					
					messages: {
						select: "",
						compensation: "",
						fName: "Please enter your First Name",
						lName: "Please enter your Last Name",
						empId: "Enter a valid Employee ID",
						staffId: "Enter a valid Staff ID",
						maritalStatus: "Please select Marital Status",
						spouseNumber: "Please select number of spouse",
						childrenNumber: "Please select number of children",
						childrenAge: "Please select age range of children",
						address: "This value is required",
						dFirstName: "Please enter Dependant's First Name",
						dLastName: "Please enter Dependant's Last Name",
						dDob: "Please select date"
					},
					
					submitHandler: function(form) {
						form.submit();
					}
                    });
					
	$("#healthStatus2").validate({
                    rules: {
						div_radio: {
							required: true
							},
						dateofinjury: "required",
						dateoftreat: "required",
						Hospital: "required",
						HouseNumber: "required",
						StreetNumber: "required",
						State: {
							required: true
							},
						LGA: {
							required: true
							},
						SPname: "required",
						SPname1: "required",
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
					}
                    });
					
	$("#attachments4").validate({
                    rules: {
						div_radio: "required",
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
					}
                    });
                     }
);

					
						