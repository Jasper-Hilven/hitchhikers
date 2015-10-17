/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package mygame.spaceship;

import com.jme3.input.controls.AnalogListener;
import com.jme3.math.Vector3f;


public class SpaceShipMovementController implements AnalogListener{
    private final SpaceShip ship;
    
    public SpaceShipMovementController(SpaceShip ship){
      this.ship = ship;
    
    
    }

    public void onAnalog(String name, float value, float tpf) {
      if (name.equals("Forward")) {
        ship.SetPosition(ship.GetPosition().add(new Vector3f(tpf, 0, 0)));
      }
      if (name.equals("Backward")) {
        ship.SetPosition(ship.GetPosition().add(new Vector3f(-tpf, 0, 0)));
      }
      }
}
