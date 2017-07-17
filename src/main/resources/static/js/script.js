$(document).ready(function(){
    /* Add active plane to the list */
   var url = window.location;
    var element = $('.sidebar ul.nav a').filter(function() {
        return this.href == url;
    }).parent('li').addClass('active').parent().addClass('in').parent();
    if (element.is('li')) {
        element.addClass('active');
    } 
    
    
    $("#state").change(function(e) {
        var province = $("#province");
        $.ajax({
            url:"/locale/ng/" + $(this).val(), 
            type:"GET",
            success: function(data){
                var json = $.parseJSON(data);
                $("#province option").remove();
                province.html('<option value="" selected>Select an option</option>');
                $(json).each(function(index, element) {
                    if(json[index].name === province.attr("data-name")){
                        province.append('<option selected="selected">' + json[index].name + '</option>');
                    }else{
                        province.append('<option>' + json[index].name + '</option>');
                    }
                });
            },
            error: function(){
                $("#province").html('<option value="" selected>Select an option</option>');
            }
        });
    }).change();
    
    $("input[name='claim']").click(function(){
        window.location = "/notification/" + $(this).attr("value") + "/employee";
    });
    
    /*
    $("select").change(function(){
        $(this).find("option").each(function(){
            var optionValue = $(this).attr("value");
            if(optionValue){
                $(".box").not("." + optionValue).hide();
                $("." + optionValue).show();
            } else{
                $(".box").hide();
            }
        });
    }).change();*/
    
    
    $("#modeOfId").change(function(){
        $(this).each(function(){
            if($(this).val() === ""){
                $(".box").addClass("hidden");
            }else{
                if($(this).val() === "license"){
                    $(".box label.indentify").text("Specify Driver's License Number");
                }else if($(this).val() === "national"){
                    $(".box label.indentify").text("Specify National ID Number");
                }else if($(this).val() === "passport"){
                    $(".box label.indentify").text("Specify International Passport Number");
                }
                $(".box").removeClass("hidden");
            }
        });
    }).change();
    /*
    addCommas = function(input){
        
       return (input.toString()).replace(/^([-+]?)(0?)(\d+)(.?)(\d+)$/g, function(match, sign, zeros,before, decimal, after){
           var reverseString = function (string){
               return string.split('').reverse().join('');
           };
           
           var insertCommas = function (string){
               var reversed = reverseString(string);
               var reversedWithCommas = reversed.match(/.{1,3}/g).join(',');
               return reverseString(reversedWithCommas);
           };
           return sign + (decimal ? insertCommas(before) + decimal + after : insertCommas(before + after));
       });
    };
    
    $.fn.addCommas = function(){
       $(this).each(function(){
           //$(this).text($(this).text().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,"));
           //$(this).format({format:"#,###",locale:"us"});
           $(this).text(addCommas($(this).text()));
       });
    };
    /*
    $("input[type='number'].currency").each(function(){
        //$(this).format({format:"#,###", locale:"us"});
    });*/
    //$("input[type='number'].currency").addCommas();
});