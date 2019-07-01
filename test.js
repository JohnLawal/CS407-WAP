// var x = 20;
// b();

// function b() {
//     console.log(x);
//     /*- > gives undefined
//        if var x is defined below*/

//     function a() {
//         console.log(x);
//     }
//     var x = 10;
//     a();
//     console.log(x);
// }

// var x = 10;

// function main() {
//     console.log("x1 is " + x);
//     x = 20;
//     console.log("x2 is " + x);
//     if (x > 0) {
//         x = 30; // x=30;
//         console.log("x3 is " + x);
//     }
//     console.log("x4 is " + x);
//     var x = 40; // x=40;
//     var f = function(x) {
//         console.log("x5 is " + x);
//     }
//     f(50);
//     console.log("x6 is " + x);
// }
// main();
// console.log("x7 is " + x);