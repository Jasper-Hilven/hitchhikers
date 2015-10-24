/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package mygame.spaceship.pieces;

import java.util.HashMap;
import mygame.util.Maybe.MaybeNot;
import mygame.util.DiscreteMath.Orientation;
import mygame.util.DiscreteMath.Pose;
import mygame.util.Maybe.Sure;
import mygame.util.Maybe.SureNot;
import mygame.util.DiscreteMath.Vector3i;

public class SpaceShipPiecesContainer {
    
    private HashMap<Vector3i,SpaceShipPiece> pieces;
    private HashMap<SpaceShipPiece,Vector3i> positions;
    private HashMap<SpaceShipPiece,Orientation> orientations;
    
    public SpaceShipPiecesContainer(){
    pieces = new HashMap<Vector3i, SpaceShipPiece>();
    positions = new HashMap<SpaceShipPiece,Vector3i>();
    orientations = new HashMap<SpaceShipPiece, Orientation>();
    }
    
    public void UpdateBlock(SpaceShipPiece piece){
      
    }
    
    public void AddBlock(SpaceShipPiece piece,Pose pose){
     pieces.put(pose.position, piece);
     orientations.put(piece, pose.orientation);
     positions.put(piece, pose.position);
    }
    
    public MaybeNot<String> CanAddBlock(SpaceShipPiece piece, Vector3i position){
      if(pieces.containsKey(position))
          return new SureNot<String>("Position already taken.");
      if(positions.containsKey(piece))
          return new SureNot("Piece already part of ship");
      return new Sure();
    }
    
    public void RemoveBlock(SpaceShipPiece piece){
        Vector3i position = positions.get(piece);
        pieces.remove(position);
        orientations.remove(piece);
        positions.remove(piece);
    }
}

