$(document).ready(function(){
    /* Add active plane to the list */
   var url = window.location;
    var element = $('.sidebar ul.nav a').filter(function() {
        return this.href == url;
    }).parent('li').addClass('active').parent().addClass('in').parent();
    if (element.is('li')) {
        element.addClass('active');
    } 
});