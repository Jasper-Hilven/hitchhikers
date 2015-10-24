/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package mygame.util.DiscreteMath;



public class Orientation {
    private final Rotation rotation;
    private final Direction direction;
  
    public Orientation(){
    this(Direction.Front);
    }
    
  public Orientation(Direction direction){
      this(direction, Rotation.Normal);
  }
  public Orientation(Direction direction, Rotation rotation){
    this.direction = direction;
    this.rotation = rotation;
  }
    
  public enum Direction{
    Front,
    Left,
    Back,
    Right,
    Up,
    Down
  }
  public enum Rotation{
    Normal,
    Left,
    UpsideDown,
    Right
  }
}
