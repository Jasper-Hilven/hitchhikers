/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package mygame.spaceship.ui;

import com.jme3.asset.AssetManager;
import com.jme3.scene.Node;

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