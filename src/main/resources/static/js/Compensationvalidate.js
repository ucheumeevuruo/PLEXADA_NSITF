$(document).ready (
	function () {
	$("#employer-details").validate({
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
					
	$("#health-status").validate({
                    rules: {
                            div_radio: {
                                    required: true
                                    },
                            dateOfInjury: "required",
                            dateOfTreat: "required",
                            hospital: "required",
                            houseNumber: "required",
                            streetNumber: "required",
                            state: {
                                    required: true
                                    },
                            province: {
                                    required: true
                                    },
                            medicFirstName: "required",
                            medicLastName: "required",
                            practiceNumber: "required"
                    },

                    messages: {
                            div_radio: "Please make a choice",
                            dateOfInjury: "Please select date",
                            dateOfTreat: "Please select date",
                            hospital: "This field is required",
                            houseNumber: "This field is required",
                            streetNumber: "This field is required",
                            state: "Please select a state",
                            province: "Please select a Local government area by States",
                            medicFirstName: "Please enter Specialist's First Name",
                            medicLastName: "Please enter Specialist's Last Name",
                            practiceNumber: "Please enter a valid  Practice Number of Specialist"
                    },

                    submitHandler: function(form) {
                            form.submit();
                    }
                    });
					
	$("#attachment").validate({
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
                    
        $("#bank-details").validate({
                    rules: {
                            bankName: "required",
                            accName: "required",
                            accNumber: {
                                required: true,
                                regex: /^[0-9]{10}$/
                            },
                            sortCode: {
                                required: true,
                                regex: /^[0-9]{7}$/
                            },
                            fileToUpload: {
                                required: true,
                                accept: "png|jpe?g|gif",
                                filesize: 1048576
                            },
                            fileToUpload1: {
                                required: true,
                                accept: "png|jpe?g|gif",
                                filesize: 1048576
                            },
                            
                    messages: {
                            bankName: "Enter a valid bank name",
                            accName: "Enter a valid account name",
                            accNumber: "Enter a valid account number",
                            sortCode: "Enter a valid sort code",
                            fileToUpload: "This is a required field",
                            fileToUpload1: "This is a required field"
                            
                            }
                                    
                                       
                    }
                    });
                    }
                     
);

					
						