// Understanding Hoisting - example 1

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

// Understanding Hoisting - example 2

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

// Understanding Hoisting - example 3

// var x = 1;

// function foo() {
//     console.log(x);
//     var y = 2;

//     function foo1() {
//         var y = 3;
//         if (!x) {
//             z = 4;
//         }
//         var x = 5;
//         console.log(x + y + z);
//     }

//     if (y == 2) {
//         var x = 3;
//     }
//     // console.log(z);
//     foo1(); /* Comment this call and see the changes */
//     console.log(x);
//     console.log(y);
//     console.log(z);
// }
// console.log(x);
// //console.log(y);
// //console.log(z);
// foo(); /* Comment this call and see the changes */
// console.log(x);
// //console.log(y);
// //console.log(z);

// Understanding Hoisting - example 4

// var x = 1;
// var y = 2;
// var z = 3;

// function foo() {
//     function foo1() {
//         console.log(`value of x: ${x}`);
//         console.log(`value of y: ${y}`);
//         console.log(`value of z: ${z}`);
//     }

//     var z = 4;
//     foo1();
//     var x = 3;

//     console.log(`value of x: ${x}`);
//     console.log(`value of y: ${y}`);
// }
// console.log(`value of y: ${y}`);
// foo();
// console.log(`value of x: ${x}`);
// console.log(`value of z: ${z}`);


// Understanding closure
// http://javascriptissexy.com/understand-javascript-closures-with-ease/
// function celebrityIDCreator(theCelebrities) {
//     var i;
//     var uniqueID = 100;
//     for (i = 0; i < theCelebrities.length; i++) {
//         theCelebrities[i]["id"] = function() {
//             console.log('about to return from inner function (closure)');
//             return uniqueID + i;
//         }
//         console.log('about to move to iteration: ' + i);
//     }
//     console.log('about to return from outer function');
//     return theCelebrities;
// }

// var actionCelebs = [{ name: "Stallone", id: 0 }, { name: "Cruise", id: 0 }, { name: "Willis", id: 0 }];

// var createIdForActionCelebs = celebrityIDCreator(actionCelebs);

// var stalloneID = createIdForActionCelebs[0];

// console.log(stalloneID.id()); // 103
// //REASON - IT ONLY BINDS THE FUNCTION TO THE ARRAY OBJECTS 
// //PARAMETER IN REAL TIME. THE BINDED FUNCTION IS ONLY INVOKED WHEN
// //WE NEED TO GET THE ID. BY THAT TIME, 'I' IS ALREADY 3
// //SINCE IT ACCESSES VARIABLES BY REFERENCE, AND CAN DO THAT 
// //EVEN AFTER THE ENCLOSING FUNCTION HAS RETURNED
// //THE CLOSURE IS NOT IMMEDIATELY INVOKED!


//SOLUTION TO ABOVE
function celebrityIDCreator(theCelebrities) {
    var i;
    var uniqueID = 100;
    for (i = 0; i < theCelebrities.length; i++) {
        theCelebrities[i]["id"] = function(j) { // the j parametric variable is the i passed in on invocation of this IIFE
            //return uniqueID + j; works already :(
            return function() {
                    return uniqueID + j; // each iteration of the for loop passes the current value of i into this IIFE and it saves the correct value to the array
                }() // BY adding () at the end of this function, we are executing it immediately and returning just the value of uniqueID + j, instead of returning a function.
        }(i); // immediately invoke the function passing the i variable as a parameter
    }

    return theCelebrities;
}

var actionCelebs = [{ name: "Stallone", id: 0 }, { name: "Cruise", id: 0 }, { name: "Willis", id: 0 }];

var createIdForActionCelebs = celebrityIDCreator(actionCelebs);

var stalloneID = createIdForActionCelebs[0];
console.log(stalloneID.id); // 100