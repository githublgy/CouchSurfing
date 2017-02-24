$(document).ready(function() {
    var unslider04 = $('#b04').unslider({
        dots: true
       
    }),
    data04 = unslider04.data('unslider');
    
    $('.unslider-arrow04').click(function() {
        var fn = this.className.split(' ')[1];
        data04[fn]();
    });
    
    
    var unslider05 = $('#b05').unslider({
        dots: true
       
    }),
    data05 = unslider05.data('unslider');
    
    $('.unslider-arrow05').click(function() {
        var fn = this.className.split(' ')[1];
        data05[fn]();
    });
});