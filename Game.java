/****************************************
/* Author: Teacher
/* Course: CSC 221, Fall 2023
/* Lab: Inheritance Group Lab
/* Modified: October 29th 2023
/* Modified by Nick Bohm
*****************************************/

public class Game{
   
    protected InputOutput ioDevice;
    public Game(){
        ioDevice = new InputOutput();
    }
    public Move getMove(Player player) {
        Move move;
        ioDevice.print("It is "+player.getName()+"'s move: ");
        move = new Move(ioDevice.nextInt(),ioDevice.nextInt());
        ioDevice.flushLine();
        return move;
    }
}
