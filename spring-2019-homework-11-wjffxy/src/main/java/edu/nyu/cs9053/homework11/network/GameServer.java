package edu.nyu.cs9053.homework11.network;

import edu.nyu.cs9053.homework11.game.Difficulty;
import edu.nyu.cs9053.homework11.game.screen.InputMove;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.util.Random;

/**
 * User: blangel
 *
 * A NIO implementation of a NetworkGameProvider.
 *
 * The server takes the following commands:
 * <pre>
 *     foes Difficulty
 * </pre>
 * <pre>
 *     move
 * </pre>
 * where the String "foes Easy" would be a call to {@linkplain NetworkGameProvider#getRandomNumberOfNextFoes(String)}
 * with "Easy"
 * and a call using String "move" would be a call to {@linkplain NetworkGameProvider#getRandomNextMove()}
 */
public class GameServer implements NetworkGameProvider, Runnable {

    public static final String SERVER_HOST = "localhost";

    public static final int SERVER_PORT = 8080;
    
    private static final int DEFAULT_BUFFER_SIZE = 1024;

    private static final int DEFAULT_UP = 65;

    private static final int DEFAULT_DOWN = 66;

    private static final int DEFAULT_RIGHT = 67;

    private static final int DEFAULT_LEFT = 68;
    
    
    public static void main(String[] args) throws IOException {
        GameServer server = new GameServer();
        server.run();
    }
    
    private final ServerSocketChannel channel;
    
    private final Selector selector;
    
    private final ByteBuffer readBuffer;
    
    private final Map<SocketChannel, ByteBuffer> writeBuffers;

    public GameServer() throws IOException {
        channel = ServerSocketChannel.open();
        channel.configureBlocking(false);
        channel.socket().bind(new InetSocketAddress(SERVER_HOST, SERVER_PORT));
        selector = Selector.open();
        readBuffer = ByteBuffer.allocate(DEFAULT_BUFFER_SIZE);
        channel.register(selector, SelectionKey.OP_ACCEPT);
        writeBuffers = new HashMap<>();
    }
    
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                running();
            } catch (IOException ioe) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(ioe);
            }
        }
    }
    
    private void running() throws IOException {
        int readyChannels = selector.select();
        if (readyChannels == 0) {
            return;
        }
        
        Set<SelectionKey> keys = selector.selectedKeys();
        Iterator<SelectionKey> iterator = keys.iterator();
        
        while (iterator.hasNext()) {
            SelectionKey key = iterator.next();
            try {
                if (key.isAcceptable()) {
                    acceptKey();
                } else if (key.isReadable()) {
                    if (!readFromKeyChannel(key)) {
                        continue;
                    }
                } else if (key.isWritable()) {
                    if(!writeIntoKeyChannel(key)) {
                        continue;
                    }
                }
            } finally {
                iterator.remove();
            }
        }
    }
    
    private boolean writeIntoKeyChannel(SelectionKey key) throws IOException {
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer writer = writeBuffers.get(client);
        if ((writer == null) || (writer.position() == 0)) {
            return false;
        }
        writer.flip();
        client.write(writer);
        writer.clear();
        return true;
    }
    private void acceptKey() throws IOException {
        SocketChannel client = channel.accept();
        client.configureBlocking(false);
        client.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        writeBuffers.put(client, ByteBuffer.allocate(DEFAULT_BUFFER_SIZE));
    }
    
    private boolean readFromKeyChannel(SelectionKey key) throws IOException {
        SocketChannel client = (SocketChannel) key.channel();
        readBuffer.clear();
        int result = client.read(readBuffer);
        if (result == -1) {
            writeBuffers.remove(client);
            key.cancel();
            return false;
        }
        String readInformation = new String(readBuffer.array()).trim();
        String[] arrOfReadInformation = readInformation.split(" ");
        String writeInformation = "";
        if (arrOfReadInformation.length > 2) {
            throw new IllegalArgumentException("argument count should less than 2");
        }
        if (arrOfReadInformation[0].equals("foes")) {
            if (arrOfReadInformation.length !=2) {
                throw new IllegalArgumentException("argument count for foes should be 2");
            }
            writeInformation += getRandomNumberOfNextFoes(arrOfReadInformation[1]);
        } else if (arrOfReadInformation[0].equals("move")) {
            writeInformation += getRandomNextMove();
        }
        writeInformation += "\n";
        ByteBuffer writeBufferInformation = ByteBuffer.wrap(writeInformation.getBytes());
        for (Map.Entry<SocketChannel, ByteBuffer> entry : writeBuffers.entrySet()) {
            SocketChannel otherClient = entry.getKey();
            if (client == otherClient) {
                ByteBuffer writeBuffer = entry.getValue();
                writeBuffer.put(writeBufferInformation);
            }
        }
        return true;
    }
    
    @Override
    public String getRandomNumberOfNextFoes(String difficulty) {
        Random random = new Random();
        Difficulty difficultyForRandom;
        try {
            difficultyForRandom = Difficulty.valueOf(difficulty);
        } catch (Exception e) {
            difficultyForRandom = Difficulty.Easy;
        }
        return Integer.toString(random.nextInt(difficultyForRandom.getLevel() + 1));
        
    }
    
    @Override
    public String getRandomNextMove() {
        Random random = new Random();
        int verticalOrHorizontal = random.nextInt(2);
        if (verticalOrHorizontal == 0) {
            int upOrDown = random.nextInt(2);
            if (upOrDown == 0) {
                return InputMove.getMove(DEFAULT_UP).toString();
            }
            else {
                return InputMove.getMove(DEFAULT_DOWN).toString();
            }
        }
        else {
            int leftOrRight = random.nextInt(100);
            if (leftOrRight <= 94 && leftOrRight >= 0) {
                return InputMove.getMove(DEFAULT_LEFT).toString();
            }
            else {
                return InputMove.getMove(DEFAULT_RIGHT).toString();
            }
        }
    }
}
