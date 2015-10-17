/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package mygame.spaceship.pieces;

import mygame.spaceship.pieces.SpaceShipPiece;
import mygame.spaceship.pieces.Engine;
import mygame.spaceship.pieces.FuelReservoir;
import java.util.HashMap;
import mygame.MaybeNot;
import mygame.Sure;
import mygame.SureNot;
import mygame.Vector3i;

/**
 *
 * @author Jasper
 */
public class SpaceShipPiecesContainer {
    
    private HashMap<Vector3i,SpaceShipPiece> pieces;
    private HashMap<SpaceShipPiece,Vector3i> positions;
    private float enginePower;
    private float mass;
private float FuelCapacity;
    
    public SpaceShipPiecesContainer(){
    pieces = new HashMap<Vector3i, SpaceShipPiece>();
    positions = new HashMap<SpaceShipPiece,Vector3i>();
    }
    
    public void UpdateBlock(SpaceShipPiece piece){
      
    }
    
    public void AddBlock(SpaceShipPiece piece,Vector3i position){
      if(piece instanceof Engine)
          enginePower += ((Engine) piece ).GetTrust();
      if(piece instanceof FuelReservoir)
          FuelCapacity += ((FuelReservoir) piece).GetCapacity();
      mass += piece.GetMass();
     pieces.put(position, piece);
     positions.put(piece, position);
    }
    
    public MaybeNot<String> CanAddBlock(SpaceShipPiece piece, Vector3i position){
      if(pieces.containsKey(position))
          return new SureNot<String>("Position already taken.");
      if(positions.containsKey(piece))
          return new SureNot("Piece already part of ship");
      return new Sure();
    }
    
    public void RemoveBlock(SpaceShipPiece piece){
        if(piece instanceof Engine)
          enginePower -= ((Engine) piece).GetTrust();
        if(piece instanceof FuelReservoir)
            FuelCapacity -= ((FuelReservoir) piece).GetCapacity();
        mass -= piece.GetMass();
        Vector3i position = positions.get(piece);
        pieces.remove(position);
        positions.put(piece, position);
    }
}

