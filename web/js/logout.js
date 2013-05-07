// logout Form

$(function() {
    var button = $('#logoutButton');
    var box = $('#logoutBox');
    var form = $('#logoutForm');
    button.removeAttr('href');
    button.mouseup(function(logout) {
        box.toggle();
        button.toggleClass('active');
    });
    form.mouseup(function() { 
        return false;
    });
    $(this).mouseup(function(logout) {
        if(!($(logout.target).parent('#logoutButton').length > 0)) {
            button.removeClass('active');
            box.hide();
        }
    });
});
