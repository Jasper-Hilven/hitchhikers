/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package mygame.spaceship;

import com.jme3.math.Vector3f;
import mygame.spaceship.pieces.SpaceShipPiece;
import mygame.util.Vector3i;

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
    return BlockMass + spaceShip.GetTotalFuel();
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

  Vector3f getPosition() {
      return position;
  }
  //expressed in N*s
  void GiveImpuls(Vector3f impuls)
  {
    frameImpuls = frameImpuls.add(impuls);
  }

    void RemoveBlock(SpaceShipPiece piece) {
      BlockMass -= 1f;    
    }

    void AddBlock(SpaceShipPiece piece, Vector3i position) {
     BlockMass += 1f;
    }
}
