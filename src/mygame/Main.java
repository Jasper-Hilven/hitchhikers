/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package mygame;

import mygame.spaceship.SpaceShip;
import mygame.spaceship.SpaceShipUIController;
import mygame.spaceship.SpaceShipMovementController;
import com.jme3.app.SimpleApplication;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import mygame.physics.PhysicsControllerFactory;
import mygame.physics.SystemControllerFactory;
import mygame.spaceship.SpaceShipFactory;
import mygame.spaceship.SpaceShipUIControllerFactory;
import mygame.spaceship.pieces.BasicEngine;
import mygame.spaceship.pieces.BasicFuelReservoir;
import mygame.util.Vector3i;


public class Main extends SimpleApplication {
PhysicsControllerFactory physics;
    SystemControllerFactory systems;
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        physics = new PhysicsControllerFactory();
        systems = new SystemControllerFactory();
        SpaceShipUIControllerFactory uis = new SpaceShipUIControllerFactory(assetManager, rootNode);
        SpaceShipFactory factory = new SpaceShipFactory(assetManager, physics, systems, uis);
        SpaceShip ship = factory.GetSpaceShip();
        inputManager.addMapping("Forward", new KeyTrigger(keyInput.KEY_T));
        inputManager.addListener(new SpaceShipMovementController(ship), "Forward");
        inputManager.addMapping("Backward", new KeyTrigger(keyInput.KEY_G));
        inputManager.addListener(new SpaceShipMovementController(ship), "Backward");
    }

    @Override
    public void simpleUpdate(float tpf) {
       physics.update(tpf);
       systems.Update(tpf);
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
