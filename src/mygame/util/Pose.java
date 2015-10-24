/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package mygame.util;



public class Pose {
    public final Orientation orientation;
    public final Vector3i position;
  
    public Pose(Orientation orientation, Vector3i position){
    this.orientation = orientation;
    this.position = position;}
    public Pose(Vector3i position){
      this(new Orientation(),position);
    }
    public Pose(int x, int y, int z){
      this(new Orientation(),new Vector3i(x, y, z));
    }
}
    

