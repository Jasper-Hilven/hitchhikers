/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package mygame.spaceship;

import com.jme3.math.Vector3f;


public class SpaceShipEngineController {
    private float engineActivity;
    private SpaceShip ship;
    private Vector3f engineDirection;
    void SetSpaceShip(SpaceShip ship){
      this.ship = ship;
    }
    void SetEngineActivity(float activity) { //One means top speed forward, minus one means top speed backward.
        this.engineActivity = activity;
        this.engineDirection = new Vector3f(1, 0, 0);
    }
    public void update(float tpf){
       
      float fuelCost = tpf*Math.abs(engineActivity);
      float consumedFuel = ship.ConsumeFuel(fuelCost);
      float impulsSize = fuelCost*Math.signum(engineActivity);
      Vector3f impuls = engineDirection.mult(impulsSize);
      if(!impuls.equals(Vector3f.ZERO))
          ship.physicsController.GiveImpuls(impuls);
    }
}
