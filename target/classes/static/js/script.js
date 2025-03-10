$(document).ready(function(){
    $(window).scroll(function () {
        if ($(this).scrollTop() > 1) {
            $('.dmtop').css({ bottom: "25px" });
        } else {
            $('.dmtop').css({ bottom: "-100px" });
        }
    });
    $('.dmtop').click(function () {
        $('html, body').animate({ scrollTop: '0px' }, 800);
        return false;
    });

});