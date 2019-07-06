$(function() {
    var gameOn = false;
    var cleanState = true;
    var walls = $("#maze .boundary");
    var startingPoint = $("#start");
    var endPoint = $("#end");
    var statusMsg = $("#status");

    walls.mouseover(function() {
        getDirty();
    });

    endPoint.mouseover(function() {
        if (gameOn) {
            if (cleanState) {
                statusMsg.text("You win!");
                gameOn = false;
            } else {
                gameOver();
            }
        }
    });

    startingPoint.click(reset);

    $("body").mousemove(function(event) {
        if (gameOn && (event.pageX < startingPoint.offset().left || event.pageX > endPoint.offset().right)) {
            gameOver();
        }
    });


    function reset() {
        cleanState = true;
        gameOn = true;
        statusMsg.text("Game On!");
        walls.removeClass("youlose");
    }

    function gameOver() {
        getDirty();
        statusMsg.text("Sorry, you lost. :(");
        gameOn = false;
    }

    function getDirty() {
        cleanState = false;
        walls.addClass("youlose");
    }


});