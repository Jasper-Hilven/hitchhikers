/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package mygame.spaceship;

import com.jme3.asset.AssetManager;
import mygame.physics.PhysicsControllerFactory;
import mygame.physics.SystemControllerFactory;
import mygame.spaceship.pieces.BasicEngine;
import mygame.spaceship.pieces.BasicFuelReservoir;
import mygame.util.Vector3i;


public class SpaceShipFactory {
    private final PhysicsControllerFactory physicsControllerFactory;
    private final SystemControllerFactory systemControllerFactory;
    private final SpaceShipUIControllerFactory UIControllerFactory;
    public SpaceShipFactory(AssetManager assetManager,PhysicsControllerFactory physicsControllerFactory, 
            SystemControllerFactory systemControllerFactory,SpaceShipUIControllerFactory UIControllerFactory){
     this.physicsControllerFactory = physicsControllerFactory;
     this.systemControllerFactory  = systemControllerFactory;
     this.UIControllerFactory = UIControllerFactory;
  }
    public SpaceShip GetSpaceShip(){
      
    SpaceShip ship =  new SpaceShip(UIControllerFactory.GetSpaceShipUIController(), 
            physicsControllerFactory.GetSpaceShipController(),
            systemControllerFactory.GetFuelController(),
            systemControllerFactory.GetEngineController());
  
    ship.AddPiece(new BasicEngine(), new Vector3i(0, 0, 0));
        ship.AddPiece(new BasicFuelReservoir(), new Vector3i(0, 0, 1));
        return ship;
    }  
}