$(function(){
    
            
        $('.form_time').datetimepicker({
        language: 'en',
        format: 'hh:ii',
        autoclose: 1,
        startView: 1,
        minView: 0,
        maxView: 1,
        forceParse: 0
    });
    
    
    $('.form_date').datetimepicker({
        language: 'en',
        format: 'dd-mm-yyyy',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
    
    });