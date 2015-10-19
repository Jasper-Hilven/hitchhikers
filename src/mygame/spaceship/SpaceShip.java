/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package mygame.spaceship;

import com.jme3.math.Vector3f;
import mygame.spaceship.pieces.SpaceShipPiece;
import mygame.spaceship.pieces.SpaceShipPiecesContainer;
import mygame.util.Vector3i;

/**
 *
 * @author Jasper
 */
public class SpaceShip {
    private SpaceShipPiecesContainer pieces;
    private SpaceShipUIController UIController;
    private SpaceShipPhysicsController physicsController;
    private SpaceShipEngineController spaceShipEngineController;
    private final SpaceShipFuelController fuelController;
    public SpaceShip(SpaceShipUIController controller, SpaceShipPhysicsController physicsController){
       this.pieces = new SpaceShipPiecesContainer();
       this.UIController = controller;
       this.physicsController = physicsController;
       this.fuelController = new SpaceShipFuelController();
       physicsController.SetSpaceShip(this);
    }
    ///////REGION PHYSICS
    public Vector3f GetPosition(){
      return physicsController.getPosition();
    }
    public void SetPosition(Vector3f position){
        UIController.SetPosition(position);
    }
    
    ///////ENDREGION PHYSICS
    
    ///////REGION PIECES
    public void AddPiece(SpaceShipPiece piece, Vector3i position){
        this.pieces.AddBlock(piece, position);
        this.UIController.AddBlock(piece, position);
    }
    
    public void RemovePiece(SpaceShipPiece piece){
      this.UIController.RemoveBlock(piece);
      this.pieces.RemoveBlock(piece);
    }
    
    //////ENDREGION PIECES
    
    /////REGION ENGINE AND FUEL
    public void SetEngineActivity(float activity){
      this.spaceShipEngineController.SetEngineActivity(activity);
    }
    public float ConsumeFuel(float wantedAmount){
      return this.fuelController.GetFuel(wantedAmount);
    }
    public float GetTotalFuel(){
      return this.fuelController.GetTotalFuel();
    }
    /////ENDREGION ENGINE AND FUEL
    
}
