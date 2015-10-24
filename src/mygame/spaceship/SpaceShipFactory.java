/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package mygame.spaceship;

import mygame.spaceship.ui.SpaceShipUIControllerFactory;
import mygame.spaceship.physics.systems.engine.SpaceShipEngineController;
import com.jme3.asset.AssetManager;
import mygame.spaceship.physics.PhysicsControllerFactory;
import mygame.spaceship.physics.systems.SystemControllerFactory;
import mygame.spaceship.physics.systems.engine.BasicEngine;
import mygame.spaceship.physics.systems.fuel.BasicFuelReservoir;
import mygame.util.DiscreteMath.Pose;
import mygame.util.DiscreteMath.Vector3i;


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
    SpaceShipEngineController engineController = systemControllerFactory.GetEngineController();
    SpaceShip ship =  new SpaceShip(UIControllerFactory.GetSpaceShipUIController(), 
            physicsControllerFactory.GetSpaceShipController(),
            systemControllerFactory.GetFuelController(),
            engineController,systemControllerFactory.GetGyroController());
    engineController.SetSpaceShip(ship);  
    ship.AddPiece(new BasicEngine(), new Pose(0, 0, 0));
        ship.AddPiece(new BasicFuelReservoir(), new Pose(0, 0, 1));
        return ship;
    }  
}