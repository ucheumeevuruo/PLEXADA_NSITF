$(document).ready (
	function () {
		$("#registration-form").validate({
                    rules: {
                        company: "required",
                        incNumber: "required",
                        year: "required",
                        email: "required",
                        phoneNumber: "required",
                        State: "required",
                        LocalGovernment: "required",
                        houseNo: "required",
                        StreetName: "required"
                    },
                    message: {
                        company: "Please enter Company's Name",
                        incNumber: "Please enter Incorporation Number",
                        year: "Please enter year of Incorporation",
                        email: "Please enter a valid email address",
                        phoneNumber: "Please enter a valid Mobile Number",
                        State: "Please pick a state",
                        LocalGovernment: "Please select a Local Government",
                        houseNo: "Please enter a House/Block No",
                        StreetName: "Please enter a Street Name"
                    },
                    submitHandler: function(form) {
                                    form.submit();
                    }
		});
	}
);