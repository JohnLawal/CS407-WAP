"use strict";
(function() {
    //Trick: X == Column == Left/100, Y == Row == Top/100
    const NUM_OF_ROWS_COLS = 4; //number of rows and columns
    const PIECE_SIZE = 100; //width and height of each div
    var emptySquareRow = 3; //default row of empty div (0 based)
    var emptySquareCol = 3; //default col of empty div (0 based)

    $(function() {
        let pieces = $("#puzzlearea div");
        // initialize each piece
        pieces.each(function(index, element) {
            let piece = $(element);
            // calculate x and y for this piece
            let x = ((index % NUM_OF_ROWS_COLS) * PIECE_SIZE);
            let y = (Math.floor(index / NUM_OF_ROWS_COLS) * PIECE_SIZE);

            // set basic style and background
            piece.addClass("puzzlepiece")
                .css("left", x + "px")
                .css("top", y + "px")
                .css("background-image", "url('background.jpg')")
                .css("background-position", -x + "px " + (-y) + "px");

            // store x and y for later
            piece.row = y / PIECE_SIZE;
            piece.col = x / PIECE_SIZE;
            piece.attr("id", "square_" + piece.row + "_" + piece.col)
                .attr("row", piece.row)
                .attr("col", piece.col);
        });

        //swap with empty if possible
        pieces.click(function() {
            var piece = $(this);
            if (isMoveavablePiece(piece)) {
                swapWithEmpty(piece);
            }
        });

        //hover effect for moveable pieces
        pieces.mouseover(function() {
            var piece = $(this);
            if (isMoveavablePiece(piece)) {
                piece.addClass("movablepiece");
            } else {
                piece.removeClass("movablepiece");
            }
        });

        //shuffle pieces
        $("#shufflebutton").click(function() {
            //swap randomly
            var numOfTimes = Math.pow(NUM_OF_ROWS_COLS, 3);
            for (let a = 0; a < numOfTimes; a++) {
                var moveablePieces = [];
                for (let i = 0; i < NUM_OF_ROWS_COLS; i++) {
                    for (let j = 0; j < NUM_OF_ROWS_COLS; j++) {
                        if (isMoveavableIndex(i, j)) {
                            moveablePieces.push({ row: i, col: j });
                        }
                    }
                }
                var randomIndex = Math.floor(Math.random() * moveablePieces.length);
                var piece = $("#square_" + moveablePieces[randomIndex].row + "_" + moveablePieces[randomIndex].col);
                swapWithEmpty(piece);
            }
        });
    });

    //check if piece can move
    function isMoveavablePiece(piece) {
        return isMoveavableIndex(parseInt(piece.attr("row")), parseInt(piece.attr("col")));
    }

    function isMoveavableIndex(row, col) {
        var rowDiff = Math.abs(row - emptySquareRow);
        var colDiff = Math.abs(col - emptySquareCol);
        return ((rowDiff === 0 && colDiff === 1) || (rowDiff === 1 && colDiff === 0));
    }

    //perform swap
    function swapWithEmpty(piece) {
        if (isMoveavablePiece(piece)) { //just to be sure
            var currentPieceRow = parseInt(piece.attr("row"));
            var currentPieceCol = parseInt(piece.attr("col"));

            piece.attr("row", emptySquareRow)
                .attr("col", emptySquareCol)
                .css("left", (emptySquareCol * PIECE_SIZE) + "px")
                .css("top", (emptySquareRow * PIECE_SIZE) + "px")
                .attr("id", "square_" + emptySquareRow + "_" + emptySquareCol);

            emptySquareRow = currentPieceRow;
            emptySquareCol = currentPieceCol;
            checkGameStatus();
        }
    }

    function checkGameStatus() {
        let pieces = $("#puzzlearea div");
        var expectedOutCome = [];
        var currentResult = [];

        var count = 0;
        for (let i = 0; i < NUM_OF_ROWS_COLS; i++) {
            for (let j = 0; j < NUM_OF_ROWS_COLS; j++) {
                if (!(i === NUM_OF_ROWS_COLS - 1 && j === NUM_OF_ROWS_COLS - 1)) {
                    expectedOutCome.push({ row: i, col: j });
                    var piece = $(pieces[count]);
                    currentResult.push({ row: parseInt(piece.attr("row")), col: parseInt(piece.attr("col")) });
                }
                count++;
            }
        }

        if (arraysEqual(expectedOutCome, currentResult))
            $("body").addClass("won");
        else
            $("body").removeClass("won");
    }

    function arraysEqual(expectedOutCome, currentResult) {
        if (expectedOutCome.length !== currentResult.length)
            return false;
        for (var i = expectedOutCome.length; i--;) {
            if ((expectedOutCome[i].row !== currentResult[i].row) || (expectedOutCome[i].col !== currentResult[i].col))
                return false;
        }

        return true;
    }


})();