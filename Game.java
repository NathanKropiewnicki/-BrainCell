public class Game{
   
    private InputOutput ioDevice;
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