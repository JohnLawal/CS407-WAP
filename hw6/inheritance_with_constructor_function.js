"use strict";
let runModule3 = (function() {
    function Bicycle() {
        this.speed = 0;
        this.speedup = function(value) {
            this.speed += parseInt(value);
        }
        this.applyBrake = function(value) {
            this.speed -= parseInt(value);
        }
    }

    function MountainBike() {
        Bicycle.call(this);
        this.gear = 1;
    }

    MountainBike.prototype = Object.create(Bicycle.prototype);
    MountainBike.prototype.constructor = MountainBike;

    MountainBike.prototype.setGear = function(value) {
        this.gear = parseInt(value);
    }

    let start = function() {
        let newBike = new Bicycle();
        console.log("PLAYING WITH NEW BIKE");
        //SPEEDUP BY 5
        newBike.speedup(10);
        console.log(newBike);
        //APPLY BRAKE
        newBike.applyBrake(3);
        console.log(newBike);
        //FINISHED PLAYING WITH NEW BIKE

        let newMntBike = new MountainBike();
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