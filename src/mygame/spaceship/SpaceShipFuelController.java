/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package mygame.spaceship;

import mygame.spaceship.pieces.FuelReservoir;
import mygame.util.DiscreteMath.Pose;
import mygame.spaceship.pieces.SpaceShipPiece;

public class SpaceShipFuelController {
    private float fuelCapacity = 0;
    private float fuel = 0;
    public float GetFuel(float wantedAmount){
      if(wantedAmount > fuel)
      {
          fuel = 0f;
          return fuel;
      }
      fuel -= wantedAmount;
      return wantedAmount;
    }
    public float GetTotalFuel(){
      return fuel;
    }
    public void RemoveBlock(SpaceShipPiece piece) {
      if(!(piece instanceof FuelReservoir))
          return;
      fuelCapacity -= ((FuelReservoir)piece).GetCapacity();
      fuel = Math.min(fuel, fuelCapacity);

    }

    public void AddBlock(SpaceShipPiece piece, Pose pose) {
      if(!(piece instanceof FuelReservoir))
          return;
      float blockCapacity = ((FuelReservoir)piece).GetCapacity();
      fuelCapacity += blockCapacity;
      fuel = Math.max(fuel + blockCapacity, fuelCapacity);
    }

    
    
}
