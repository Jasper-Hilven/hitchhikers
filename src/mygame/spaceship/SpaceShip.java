/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package mygame.spaceship;

import com.jme3.math.Vector3f;
import mygame.spaceship.pieces.SpaceShipPiece;
import mygame.spaceship.pieces.SpaceShipPiecesContainer;
import mygame.util.DiscreteMath.Pose;
import mygame.util.DiscreteMath.Vector3i;

/**
 *
 * @author Jasper
 */
public class SpaceShip {
    public final SpaceShipPiecesContainer pieces;
    public final SpaceShipUIController UIController;
    public final SpaceShipPhysicsController physicsController;
    public final SpaceShipEngineController engineController;
    public final SpaceShipFuelController fuelController;
    public SpaceShip(SpaceShipUIController controller, SpaceShipPhysicsController physicsController,SpaceShipFuelController fuelController, SpaceShipEngineController engineController){
       this.pieces = new SpaceShipPiecesContainer();
       this.UIController = controller;
       this.physicsController = physicsController;
       this.fuelController = fuelController;
       this.engineController = engineController;
       physicsController.SetSpaceShip(this);
    }
    ///////REGION PHYSICS
    public Vector3f GetPosition(){
      return physicsController.getPosition();
    }
    public void NotifyPosition(Vector3f position){
        UIController.SetPosition(position);
    }
    
    ///////ENDREGION PHYSICS
    
    ///////REGION PIECES
    public void AddPiece(SpaceShipPiece piece, Pose pose){
        this.pieces.AddBlock(piece, pose);
        this.UIController.AddBlock(piece, pose);
        this.physicsController.AddBlock(piece, pose);
        
    }
    
    public void RemovePiece(SpaceShipPiece piece){
      this.UIController.RemoveBlock(piece);
      this.pieces.RemoveBlock(piece);
      this.physicsController.RemoveBlock(piece);
    }
    
    //////ENDREGION PIECES
    
    /////REGION ENGINE AND FUEL
    public void SetEngineActivity(float activity){
      this.engineController.SetEngineActivity(activity);
    }
    public float ConsumeFuel(float wantedAmount){
      return this.fuelController.GetFuel(wantedAmount);
    }
    public float GetTotalFuel(){
      return this.fuelController.GetTotalFuel();
    }
    
    
    /////ENDREGION ENGINE AND FUEL
    
}
