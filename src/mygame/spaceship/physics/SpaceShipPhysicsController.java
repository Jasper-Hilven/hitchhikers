/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package mygame.spaceship.physics;

import mygame.util.DiscreteMath.Pose;
import com.jme3.math.Vector3f;
import mygame.spaceship.SpaceShip;
import mygame.spaceship.pieces.SpaceShipPiece;

public class SpaceShipPhysicsController {
    private SpaceShip spaceShip;
    private Vector3f position;
    private Vector3f orientation;
    private Vector3f speed ;
    private Vector3f frameImpuls;
    private float BlockMass;
    
    public SpaceShipPhysicsController(){
      this.position = Vector3f.ZERO;
      this.speed = Vector3f.ZERO;
      this.frameImpuls = Vector3f.ZERO;
    }
    
    public void SetSpaceShip(SpaceShip spaceShip){
    this.spaceShip = spaceShip;
    
    }
  private float GetMass(){
    return BlockMass + spaceShip.fuelController.GetTotalFuel();
  }
  public void update(float tpf){
    position= position.add(speed.mult(tpf));
    spaceShip.NotifyPosition(position);
    if(frameImpuls.equals(Vector3f.ZERO))
        return;
    float mass = GetMass();
    if(mass == 0)
        throw new IllegalStateException();
    speed = speed.add(frameImpuls.divide(mass));
    frameImpuls = new Vector3f();
  }

  public Vector3f getPosition() {
      return position;
  }
  //expressed in N*s
  public void GiveImpuls(Vector3f impuls)
  {
    frameImpuls = frameImpuls.add(impuls);
  }

    public void RemoveBlock(SpaceShipPiece piece) {
      BlockMass -= 1f;    
    }

    public void AddBlock(SpaceShipPiece piece, Pose pose) {
     BlockMass += 1f;
    }
}
