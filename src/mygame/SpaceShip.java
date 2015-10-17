/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package mygame;

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
    public SpaceShip(SpaceShipUIController controller){
       this.pieces = new SpaceShipPiecesContainer();
       this.UIController = controller;
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
