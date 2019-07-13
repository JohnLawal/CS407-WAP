let $ = jQuery;

function signIn() {
    let signInNotice = $('#signinNotice');
    signInNotice.html('');
    let password = $("#txtPasswordSignIn").val();
    let username = $("#txtUsernameSignIn").val();
    let remember = $("#chkRememberMe").prop("checked");

    let signInUrl = "/webstore/login";

    let fd = {
        "username": username,
        "password": password
    };
    if (remember) {
        fd.remember = "true";
    }

    let signInForm = $('#frmSignIn');

    //
    signInForm.preloader();
    $.ajax({
        type: 'POST',
        url: signInUrl,
        data: fd,
        success: function (result) {
            signInForm.preloader('remove');
            let resultObj = JSON.parse(result);
            if (resultObj['status'] === "success") {
                location.reload();
            } else {
                signInNotice.html(resultObj['message']);
            }
        },
        error: function (xhr, status, error) {
            signInForm.preloader('remove');
            signInNotice.html(error);
        }
    });
}
