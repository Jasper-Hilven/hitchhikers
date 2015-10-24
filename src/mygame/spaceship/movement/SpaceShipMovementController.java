/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package mygame.spaceship.movement;

import com.jme3.input.controls.AnalogListener;
import com.jme3.math.Vector3f;
import mygame.spaceship.SpaceShip;


public class SpaceShipMovementController implements AnalogListener{
    private final SpaceShip ship;
    
    public SpaceShipMovementController(SpaceShip ship){
      this.ship = ship;
    }

    public void onAnalog(String name, float value, float tpf) {
      if (name.equals("Forward")) {
          ship.engineController.SetEngineActivity(1);
      }
      if (name.equals("Backward")) {
          ship.engineController.SetEngineActivity(-1);
      }
   }
}
