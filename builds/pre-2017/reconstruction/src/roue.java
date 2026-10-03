/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;

public class roue {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static boolean _a(int n) {
        ServerSocket serverSocket = null;
        DatagramSocket datagramSocket = null;
        try {
            serverSocket = new ServerSocket(n);
            serverSocket.setReuseAddress(true);
            datagramSocket = new DatagramSocket(n);
            datagramSocket.setReuseAddress(true);
            boolean bl = true;
            return bl;
        }
        catch (IOException iOException) {
        }
        finally {
            if (datagramSocket != null) {
                datagramSocket.close();
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                }
                catch (IOException iOException) {}
            }
        }
        return false;
    }
}

