/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package mygame.spaceship.physics.systems.fuel;


public class BasicFuelReservoir implements  FuelReservoir{
    
    public float GetCapacity() {
        return 20;
    }

    public float GetMass() {
        return 1;
    }
    
}
