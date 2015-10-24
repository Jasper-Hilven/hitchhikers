/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package mygame.physics;

import java.util.ArrayList;
import mygame.spaceship.movement.SpaceShipFuelController;
import mygame.spaceship.movement.SpaceShipEngineController;


public class SystemControllerFactory{
  private ArrayList<SpaceShipEngineController> engineControllers = new ArrayList<SpaceShipEngineController>();
    
    public SpaceShipFuelController GetFuelController(){
      return new SpaceShipFuelController();
    }
  public SpaceShipEngineController GetEngineController(){
      SpaceShipEngineController controller = new SpaceShipEngineController();
        engineControllers.add(controller);
      return controller;
  }

  public void Update(float tpf){
    for(SpaceShipEngineController engineController : engineControllers){
      engineController.update(tpf);
    }
  }

}