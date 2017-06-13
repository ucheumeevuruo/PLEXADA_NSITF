$(document).ready (
	function () {
		$("#firstpage").validate({
			rules: {
				CompName: "required",
				IncorporationNumber: "required",
				year: "required",
				email: {
					required: true,
					email: true
				},
				MobileNumber: "required",
				State: "required",
				LocalGovernment: "required",
				HouseNo: "required",
				StreetName: "required"
			},
			message: {
				CompName: "Company's name should be text only example: Small or Big company Ltd",
				IncorporationNumber: "Enter a correct Incorpration Number ( first two characters are alphabets followed by numbers e.g RC20000000)",
				year: "Please enter year of Incorporation",
				email: "Enter a valid email address. eg example@mail.com",
				MobileNumber: "Enter a valid phone number",
				State: "Please select a state",
				LocalGovernment: "Please select a Local government area by States",
				HouseNo: "This value is required",
				StreetName: "This value is required."
			},
			submitHandler: function(form) {
				form.submit();
			}
		});
		
		$("#secondpage").validate({
			rules: {
				Emoulment: "required"
			},
			message: {
				Emoulment: "This value is required"
			},
			submitHandler: function(form) {
				form.submit();
			}
		});
		
		$("#thirdpage").validate({
			rules: {
				checkbox: {
					required: true,
					maxlength: 1
				},
				select: {
					required: true,
					minlength: 1
				}
			},
			message: {
				checkbox: "select a Business class",
				select: "select sector categories"
                            }
		});
		
		$("#fifthpage").validate({
			rules: {
				name: "required",
				name1: "required",
				Position: "required",
				StaffID: "required",
				TandC: {
					required: true,
					minlength: 1
				}
			},
                        message: {
                                name: "Please enter your First Name",
                                name1: "Please enter your Otheer Names",
                                Position: "Position is required and should be text only",
                                StaffID: "Enter a valid Staff ID",
                                TandC: "Please agree with the terms and conditions"
                                }
                        }
		);
        }
);