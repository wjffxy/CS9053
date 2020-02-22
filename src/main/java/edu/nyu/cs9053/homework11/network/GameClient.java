package edu.nyu.cs9053.homework11.network;

import edu.nyu.cs9053.homework11.game.Difficulty;
import edu.nyu.cs9053.homework11.game.GameProvider;
import edu.nyu.cs9053.homework11.game.screen.InputMove;

import java.io.*;
import java.net.Socket;

/**
 * User: blangel
 *
 * A blocking IO implementation of a client which requests moves from a remote server implementing the
 * {@linkplain edu.nyu.cs9053.homework11.network.NetworkGameProvider}
 */
public class GameClient implements GameProvider {

    private static final String SERVER_HOST = "localhost";

    private static final int SERVER_PORT = 8080;

    public static GameClient construct(Difficulty difficulty) {
        try {
            Socket serverConnection = new Socket(SERVER_HOST, SERVER_PORT);
            return new GameClient(difficulty, serverConnection.getInputStream(), serverConnection.getOutputStream());
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    private final Difficulty difficulty;

    private final InputStream serverInput;

    private final OutputStream serverOutput;

    private final BufferedWriter bufferedWriter;

    private final BufferedReader bufferedReader;

    public GameClient(Difficulty difficulty, InputStream serverInput, OutputStream serverOutput) {
        this.difficulty = difficulty;
        this.serverInput = serverInput;
        this.serverOutput = serverOutput;
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(serverOutput));
        bufferedReader = new BufferedReader(new InputStreamReader(serverInput));
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public int getRandomNumberOfNextFoes() {
        
        writeIntoBuffer(String.format("foes %s",getDifficulty().toString()));
        String nextFoes = readFromBuffer();
        return Integer.parseInt(nextFoes);
        /*
        try {
            bufferedWritter.write("foes " + getDifficulty().toString());
            bufferedWritter.flush();
            String nextFoes = bufferedReader.readLine();
            return Integer.parseInt(nextFoes);
        } catch (IOException ioe) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(ioe);
        }*/
    }

    private void writeIntoBuffer(String textForWrite) {
        try {
            bufferedWriter.write(textForWrite);
            bufferedWriter.flush();
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
    
    private String readFromBuffer() {
        try {
            return bufferedReader.readLine();
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }



    public InputMove getRandomNextMove() {
        writeIntoBuffer(String.format("move"));
        String nextMove = readFromBuffer();
        switch (nextMove) {
            case "Up":
                return InputMove.Up;
            case "Down":
                return InputMove.Down;
            case "Left":
                return InputMove.Left;
            case "Right":
                return InputMove.Right;
            default:
                return InputMove.Up;
        }
    }
}
