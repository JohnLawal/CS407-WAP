"use strict";
let runModule2 = (function() {
    class Bicycle {
        constructor() {
            this.speed = 0;
        }
        applyBrake(value) {
            this.speed -= parseInt(value);
        }
        speedup(value) {
            this.speed += parseInt(value);
        }
    }

    class MountainBike extends Bicycle {
        constructor() {
            super();
            this.gear = 1;
        }
        setGear(value) {
            this.gear = parseInt(value);
        }
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