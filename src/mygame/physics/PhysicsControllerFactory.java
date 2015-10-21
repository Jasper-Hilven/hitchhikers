/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package mygame.physics;

import java.util.ArrayList;
import mygame.spaceship.SpaceShipPhysicsController;

public class PhysicsControllerFactory {
  private ArrayList<SpaceShipPhysicsController> shipControllers = new ArrayList<SpaceShipPhysicsController>();
  public SpaceShipPhysicsController GetSpaceShipController(){
    SpaceShipPhysicsController controller = new SpaceShipPhysicsController();
    shipControllers.add(controller);
    return controller;
  }
  public void update(float tpf){
      for (int i = 0; i < shipControllers.size(); i++) {
          shipControllers.get(i).update(tpf);
      }
  }
  
    
}



