/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package mygame;

import mygame.spaceship.SpaceShip;
import mygame.spaceship.movement.SpaceShipMovementController;
import com.jme3.app.SimpleApplication;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.renderer.RenderManager;
import mygame.physics.PhysicsControllerFactory;
import mygame.physics.SystemControllerFactory;
import mygame.spaceship.SpaceShipFactory;
import mygame.spaceship.SpaceShipUIControllerFactory;


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
        SpaceShipMovementController movementController = new SpaceShipMovementController(ship);
        inputManager.addMapping("Forward", new KeyTrigger(keyInput.KEY_T));
        inputManager.addListener(movementController, "Forward");
        inputManager.addMapping("Backward", new KeyTrigger(keyInput.KEY_G));
        inputManager.addListener(movementController, "Backward");
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
