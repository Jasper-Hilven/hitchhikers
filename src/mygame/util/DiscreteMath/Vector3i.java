/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package mygame.util.DiscreteMath;

import com.jme3.math.Vector3f;


public class Vector3i {
    private final int x;
    private final int y;
    private final int z;
    public Vector3i(int x, int y, int z){
      this.x = x;
      this.y = y;
      this.z = z;
    }

   public Vector3f toVector3f() {
        return new Vector3f(x, y, z); //To change body of generated methods, choose Tools | Templates.
    }
}
