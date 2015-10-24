package mygame.spaceship.physics.systems.gyro;

import mygame.spaceship.pieces.SpaceShipPiece;
import mygame.util.DiscreteMath.Pose;

/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */


public class SpaceShipGyroController {
    private float gyroSpeed = 0; //Expressed in kg*m*m/s
    private float gyroSpeedCapacity = 0; //Expressed in kg*m*m/s    

    public void update(float tpf){
        
    }

    public void AddBlock(SpaceShipPiece piece, Pose pose) {
      if (!(piece instanceof Gyro))
          return;
      gyroSpeedCapacity += ((Gyro)piece).GetTurningSpeed();
    }

    public void RemoveBlock(SpaceShipPiece piece) {
      if (!(piece instanceof Gyro))
          return;
           gyroSpeedCapacity -= ((Gyro)piece).GetTurningSpeed();

    }

}
