/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package mygame.spaceship;

import com.jme3.math.Vector3f;
import mygame.spaceship.pieces.Engine;
import mygame.spaceship.pieces.SpaceShipPiece;
import mygame.util.DiscreteMath.Pose;


public class SpaceShipEngineController {
    private float engineActivity;
    private float enginePower;
    private SpaceShip ship;
    private Vector3f engineDirection;
    void SetSpaceShip(SpaceShip ship){
      this.ship = ship;
    }
    public SpaceShipEngineController(){
        enginePower = 0;
        engineDirection = new Vector3f(1, 0, 0);
    }
    void SetEngineActivity(float activity) { //One means top speed forward, minus one means top speed backward.
        this.engineActivity = activity;
        this.engineDirection = new Vector3f(1, 0, 0);
    }
    
    public void AddBlock(SpaceShipPiece piece,Pose pose){
      if(! (piece instanceof Engine))
          return;
      enginePower+= ((Engine)piece).GetTrust();
    }
    public void RemoveBlock(SpaceShipPiece piece){
    if(! (piece instanceof Engine))
          return;
      enginePower-= ((Engine)piece).GetTrust();
    }
    
    
    public void update(float tpf){
       
      float fuelCost = tpf*Math.abs(engineActivity);
      float consumedFuel = ship.ConsumeFuel(fuelCost);
      float impulsSize = fuelCost*Math.signum(engineActivity);
      engineActivity = 0f;
      Vector3f impuls = engineDirection.mult(impulsSize);
      if(!impuls.equals(Vector3f.ZERO))
          ship.physicsController.GiveImpuls(impuls);
    }
}
