window.onload = function() {
    let popBox = document.getElementById('pop');

    setTimeout(popUp, 1000);

    let btnCloseBanner = document.getElementById('btnCloseBanner');
    btnCloseBanner.onclick = function() {
        popBox.className = "";
    }

    function popUp() {
        popBox.className = "display";
    }
};