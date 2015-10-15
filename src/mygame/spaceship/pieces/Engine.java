/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package mygame.spaceship.pieces;

/**
 *
 * @author Jasper
 */
public interface Engine extends SpaceShipPiece {
    //SI unit, expressed in Kg*m/s2
    float GetTrust();
}
