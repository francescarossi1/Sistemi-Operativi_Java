package es2.buffered;

import java.io.*;

public class BufferedCommunication {

    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
		System.out.println("BufferedCommunication");
        
        PipedInputStream pis = new PipedInputStream();
        try {
            PipedOutputStream pos = new PipedOutputStream(pis);
			
            FromInput fi = new FromInput(pos);
            ToOutput to = new ToOutput(pis);
            fi.start();
            to.start();
        } catch (IOException e) {e.printStackTrace();}
    }

}
