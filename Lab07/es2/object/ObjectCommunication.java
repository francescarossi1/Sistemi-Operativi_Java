package es2.object;

import java.io.*;

public class ObjectCommunication {

    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
		System.out.println("ObjectCommunication");

        PipedInputStream pis = new PipedInputStream();
        try {
            PipedOutputStream pos = new PipedOutputStream(pis);
			
            FromInput fi = new FromInput(pos);
            ToOutput to = new ToOutput(pis);
            fi.start();
            to.start();
        } 
		catch (IOException e) {
			e.printStackTrace();
		}
    }

}