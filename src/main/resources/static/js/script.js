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
        $.ajax({
            url:"/locale/ng/" + $(this).val(), 
            type:"GET",
            success: function(data){
                var json = $.parseJSON(data);
                $("#lga option").remove();
                $("#lga").html('<option value="" selected>Select an option</option>');
                $(json).each(function(index, element) {
                    $("#lga").append('<option>' + json[index].name + '</option>');
                });
            },
            error: function(){
                $("#lga").html('<option value="" selected>Select an option</option>');
            }
        });
    });
});