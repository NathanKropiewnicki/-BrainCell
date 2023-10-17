import java.io.*;
import java.util.*;

public class FSMDriver {
    public static void main(String[] args) throws IOException {
        FSM myFSM;
        
        myFSM = new FSM("simple");
        System.out.println(myFSM.test("aacc"));
    }
}