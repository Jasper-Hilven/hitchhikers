package mygame.spaceship.physics.systems.gyro;

import mygame.spaceship.pieces.SpaceShipPiece;



public interface Gyro extends SpaceShipPiece{
  //Expressed in kg*m*m/s
  public float GetTurningSpeed();  

}