/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.physics;

import java.util.ArrayList;
import mygame.spaceship.SpaceShipPhysicsController;

/**
 *
 * @author Jasper
 */
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



