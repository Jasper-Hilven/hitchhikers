/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package mygame.spaceship;


public class SpaceShipEngineController {
    private float engineActivity;
    private SpaceShip ship;
    void SetSpaceShip(SpaceShip ship){
      this.ship = ship;
    }
    void SetEngineActivity(float activity) { //One means top speed forward, minus one means top speed backward.
        this.engineActivity = engineActivity;
    }
    public void update(float tpf){
       
      float fuelCost = tpf*Math.abs(engineActivity);
      float consumedFuel = ship.ConsumeFuel(fuelCost);
      
    
    }
}
