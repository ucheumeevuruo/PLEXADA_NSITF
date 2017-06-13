$(document).ready (
	function () {
		$("#firstpage").validate({
			rules: {
				CompName: "required",
				IncorporationNumber: "required",
				year: "required",
				email: "required",
				MobileNumber: "required",
				State: "required",
				LocalGovernment: "required",
				HouseNo: "required",
				StreetName: "required"
			},
			message: {
				CompName: "Please enter Company's Name",
				IncorporationNumber: "Please enter Incorporation Number",
				year: "Please enter year of Incorporation",
				email: "Please enter a valid email address",
				MobileNumber: "Please enter a valid Mobile Number",
				State: "Please pick a state",
				LocalGovernment: "Please select a Local Government",
				HouseNo: "Please enter a House/Block No",
				StreetName: "Please enter a Street Name"
			},
		submitHandler: function(form) {
				form.submit();
		}
		});
	}
);