/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package mygame.spaceship;


public class SpaceShipFuelController {
    private float fuel = 20;
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
}
