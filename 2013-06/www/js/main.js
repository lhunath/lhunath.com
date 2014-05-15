$(function(){
    if( ! /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent) )
        $.stellar();
    else
        $("header, section").css('background-attachment', 'fixed');
});

