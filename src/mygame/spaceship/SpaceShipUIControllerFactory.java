/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package mygame.spaceship;

import mygame.util.Vector3i;
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
import mygame.spaceship.pieces.Engine;
import mygame.spaceship.pieces.SpaceShipPiece;

public class SpaceShipUIControllerFactory{
    private final AssetManager assetManager;
    private final Node rootNode;
    public SpaceShipUIControllerFactory(AssetManager assetManager,Node rootNode){
      this.assetManager = assetManager;
      this.rootNode = rootNode;
    }
  public SpaceShipUIController GetSpaceShipUIController(){
    SpaceShipUIController controller =  new SpaceShipUIController(assetManager);
    rootNode.attachChild(controller.GetShip());
    return controller;
  }


}