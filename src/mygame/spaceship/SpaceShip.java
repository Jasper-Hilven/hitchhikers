/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package mygame.spaceship;

import mygame.spaceship.ui.SpaceShipUIController;
import mygame.spaceship.physics.SpaceShipPhysicsController;
import com.jme3.math.Vector3f;
import mygame.spaceship.physics.systems.SystemController;
import mygame.spaceship.pieces.SpaceShipPiece;
import mygame.spaceship.pieces.SpaceShipPiecesContainer;
import mygame.util.DiscreteMath.Pose;

/**
 *
 * @author Jasper
 */
public class SpaceShip {
    public final SpaceShipPiecesContainer pieces;
    public final SpaceShipUIController UIController;
    public final SpaceShipPhysicsController physicsController;
    public final SystemController systemController;
    public SpaceShip(SpaceShipUIController controller, SpaceShipPhysicsController physicsController,
                     SystemController systemController){
       this.pieces = new SpaceShipPiecesContainer();
       this.UIController = controller;
       this.physicsController = physicsController;
       this.systemController = systemController;
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
        this.systemController.AddBlock(piece, pose);
    }
    
    public void RemovePiece(SpaceShipPiece piece){
      this.UIController.RemoveBlock(piece);
      this.pieces.RemoveBlock(piece);
      this.systemController.RemoveBlock(piece);
      this.physicsController.RemoveBlock(piece);
    }
    
    //////ENDREGION PIECES
    
    /////REGION ENGINE AND FUEL
    public float ConsumeFuel(float wantedAmount){
      return this.systemController.fuelController.GetFuel(wantedAmount);
    }    
    /////ENDREGION ENGINE AND FUEL
    
}
