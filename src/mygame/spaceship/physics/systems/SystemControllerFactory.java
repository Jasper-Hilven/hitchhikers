/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package mygame.spaceship.physics.systems;

import java.util.ArrayList;
import mygame.spaceship.physics.systems.fuel.SpaceShipFuelController;
import mygame.spaceship.physics.systems.engine.SpaceShipEngineController;
import mygame.spaceship.physics.systems.gyro.SpaceShipGyroController;


public class SystemControllerFactory{
  private ArrayList<SpaceShipEngineController> engineControllers = new ArrayList<SpaceShipEngineController>();
  private ArrayList<SpaceShipGyroController> gyroControllers = new ArrayList<SpaceShipGyroController>();
    
    public SpaceShipFuelController GetFuelController(){
      return new SpaceShipFuelController();
    }
  public SpaceShipEngineController GetEngineController(){
      SpaceShipEngineController controller = new SpaceShipEngineController();
        engineControllers.add(controller);
      return controller;
  }
  public SpaceShipGyroController GetGyroController(){
     SpaceShipGyroController controller = new SpaceShipGyroController();
        gyroControllers.add(controller);
        return controller;
  }
  public void Update(float tpf){
    for(SpaceShipEngineController engineController : engineControllers){
      engineController.update(tpf);
    }
    for(SpaceShipGyroController gyroController: gyroControllers)
        gyroController.update(tpf);
  }

}