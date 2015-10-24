/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package mygame.spaceship.physics.systems;

import com.jme3.math.Vector3f;
import mygame.spaceship.SpaceShip;
import mygame.spaceship.physics.systems.engine.Engine;
import mygame.spaceship.physics.systems.engine.SpaceShipEngineController;
import mygame.spaceship.physics.systems.fuel.SpaceShipFuelController;
import mygame.spaceship.physics.systems.gyro.SpaceShipGyroController;
import mygame.spaceship.pieces.SpaceShipPiece;
import mygame.util.DiscreteMath.Pose;


public class SystemController {
  public final SpaceShipEngineController engineController;
  public final SpaceShipFuelController fuelController;
  public final SpaceShipGyroController gyroController;
  public SystemController(){
    this.engineController = new SpaceShipEngineController();
    this.fuelController = new SpaceShipFuelController();
    this.gyroController = new SpaceShipGyroController();
  }
  public void Update(float tpf){
    this.engineController.update(tpf);
    this.gyroController.update(tpf);
  }
    public void SetSpaceShip(SpaceShip ship){
      engineController.SetSpaceShip(ship);
    }
    public void AddBlock(SpaceShipPiece piece,Pose pose){
      engineController.AddBlock(piece, pose);
      fuelController.AddBlock(piece, pose);
      gyroController.AddBlock(piece, pose);
    }
    public void RemoveBlock(SpaceShipPiece piece){
      engineController.RemoveBlock(piece);
      fuelController.RemoveBlock(piece);
      gyroController.RemoveBlock(piece);
    }


}
