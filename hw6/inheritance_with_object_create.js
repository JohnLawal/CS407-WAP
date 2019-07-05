"use strict";
let runModule1 = (function() {
    let createBicyclePrototype = function() {
        let bikeProtoType = {
            speed: 0,
            applyBrake: function(value) {
                this.speed -= parseInt(value);
            },
            speedup: function(value) {
                this.speed += parseInt(value);
            }
        }
        return bikeProtoType;
    }

    let createMountainBikeProtoype = function(prototype) {
        let mountainBikePrototype = Object.create(prototype);
        mountainBikePrototype.gear = 1;
        mountainBikePrototype.setGear = function(value) {
            this.gear = parseInt(value);
        }
        return mountainBikePrototype;
    }

    let start = function() {
        let bicyclePrototype = createBicyclePrototype();
        let mountainBikePrototype = createMountainBikeProtoype(bicyclePrototype);

        console.log("PLAYING WITH MOUNTAIN BIKE PROTOTYPE");
        //SPEEDUP BY 5
        mountainBikePrototype.speedup(5);
        console.log(mountainBikePrototype);
        //CHANGE TO GEAR 4
        mountainBikePrototype.setGear(4);
        console.log(mountainBikePrototype);
        //APPLY BRAKE
        mountainBikePrototype.applyBrake(2);
        console.log(mountainBikePrototype);
        //FINISHED PLAYING WITH MOUNTAIN BIKE PROTOTYPE

        let newBike = Object.create(bicyclePrototype);
        console.log("PLAYING WITH NEW BIKE");
        //SPEEDUP BY 5
        newBike.speedup(10);
        console.log(newBike);
        //APPLY BRAKE
        newBike.applyBrake(3);
        console.log(newBike);
        //FINISHED PLAYING WITH NEW BIKE

        let newMntBike = Object.create(mountainBikePrototype);
        console.log("PLAYING WITH NEW MOUNTAIN BIKE");
        //SPEEDUP BY 5
        newMntBike.speedup(6);
        console.log(newMntBike);
        //APPLY BRAKE
        newMntBike.applyBrake(5);
        console.log(newMntBike);
        //CHANGE TO GEAR 3
        newMntBike.setGear(3);
        console.log(newMntBike);
        //FINISHED PLAYING WITH NEW MOUNTAIN BIKE
    }

    return start;
})();