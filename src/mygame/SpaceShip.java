/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package mygame;

import com.jme3.math.Vector3f;
import mygame.spaceship.pieces.SpaceShipPiece;
import mygame.spaceship.pieces.SpaceShipPiecesContainer;
import mygame.util.Vector3i;

/**
 *
 * @author Jasper
 */
public class SpaceShip {
    private Vector3f position;
    private SpaceShipPiecesContainer pieces;
    private SpaceShipUIController UIController;
    public SpaceShip(SpaceShipUIController controller){
       this.pieces = new SpaceShipPiecesContainer();
       this.UIController = controller;
       position = new Vector3f();
    }
    
    public Vector3f GetPosition(){
      return position;
    }
    public void SetPosition(Vector3f position){
        this.position = position;
        UIController.SetPosition(position);
    }
    
    public void AddPiece(SpaceShipPiece piece, Vector3i position){
        this.pieces.AddBlock(piece, position);
        this.UIController.AddBlock(piece, position);
    }
    
    public void RemovePiece(SpaceShipPiece piece){
      this.UIController.RemoveBlock(piece);
      this.pieces.RemoveBlock(piece);
    }
}
