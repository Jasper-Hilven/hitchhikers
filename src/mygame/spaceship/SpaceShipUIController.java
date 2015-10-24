/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package mygame.spaceship;

import mygame.util.DiscreteMath.Vector3i;
import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import java.util.HashMap;
import java.util.Map;
import mygame.spaceship.movement.Engine;
import mygame.spaceship.pieces.SpaceShipPiece;
import mygame.util.DiscreteMath.Pose;


public class SpaceShipUIController {
    private Map<SpaceShipPiece,Geometry> piecesToGeometry;
    private Node Ship;
    private AssetManager assetManager;
    public SpaceShipUIController(AssetManager assetManager) {
        this.piecesToGeometry = new HashMap<SpaceShipPiece, Geometry>();
        this.Ship = new Node();
        this.assetManager = assetManager;
    }
    public Spatial GetShip(){
      return Ship;
    }
    public void AddBlock(SpaceShipPiece piece,Pose pose){
        Geometry block = CreateBlock(piece);
        piecesToGeometry.put(piece, block);
        this.Ship.attachChild(block);
        block.setLocalTranslation(pose.position.toVector3f());
    }
    public void RemoveBlock(SpaceShipPiece piece){
        Geometry block = piecesToGeometry.get(piece);
        piecesToGeometry.remove(piece);
        this.Ship.detachChild(block);
    }
    private Geometry CreateBlock(SpaceShipPiece piece){
              Box b = new Box(0.5f, 0.5f, 0.5f);
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        ColorRGBA color = piece instanceof Engine ? ColorRGBA.Red : ColorRGBA.Brown;
        mat.setColor("Color", color);
        Geometry floor = new Geometry("floor", b);
        floor.setMaterial(mat);
        return floor;
    }

    void SetPosition(Vector3f position) {
      Ship.setLocalTranslation(position);
    }
}
