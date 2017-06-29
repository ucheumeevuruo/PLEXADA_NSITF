$(document).ready (
	function () {
            $.validator.addMethod(
                "regex", function(value, element, regexp){
                    if(regexp.constructor != RegExp)
                        regexp = new RegExp(regexp);
                    else if(regexp.global)
                        regexp.lastIndex = 0;
                    return this.optional(element) || regexp.test(value);
                }, "Please check your input."    
            );
            $("#registration-form").validate({
                rules: {
                    company: "required",
                    incNumber: {
                        required : true,
                        regex: /^[A-Z]{2}\-[0-9]{9}$/
                    },
                    incYear: "required",
                    email: {
                        required : true,
                        email : true
                    },
                    phoneNumber: {
                        regex: /^[+-]{1}[0-9]{1,3}\-[0-9]{11}$/
                    },
                    state: "required",
                    province: "required",
                    houseNo: "required",
                    streetName: "required",
                    // second-page
                    staffEmulment: "required",
                    // third-page
                    type: "required",
                    sector: "required",
                    // fourth-page
                    firstName: "required",
                    otherName: "required",
                    lastName: "required",
                    position: "required",
                    modeOfId: "required",
                    staffID: "required",
                    agreement: {
                        required: true
                    }
                },
                messages: {
                    company: "Please enter Company's Name",
                    incNumber: {
                        required: "Please enter Incorporation Number",
                        regex: "Please enter a valid incorporation number i.e. RC-000000009"
                    },
                    incYear: "Please enter year of Incorporation",
                    email: {
                        required : "Email address is a required field",
                        email: "Please enter a valid email address"
                    },
                    phoneNumber: {
                        regex: "Please enter a valid phone number i.e. +234-1234567890"
                    },
                    state: "Please pick a state",
                    province: "Please select a Local Government",
                    houseNo: "Please enter a House/ Block No",
                    streetName: "Please enter a Street Name",
                    staffEmulment: "This value is required",
                    type: "This value is required",
                    sector: "This value is required",
                    agreement: "You have not agreed with out terms"
                },
                submitHandler: function(form) {
                    $("button['name=Next']").attr("disabled", "");
                    form.submit();
                }
            });
        }
);