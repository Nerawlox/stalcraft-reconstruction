/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;
import net.minecraft.client.xpzm;

public class jzyx
extends Thread {
    public final dyir _a;
    public final InetAddress _b;
    public final MulticastSocket _c;

    public jzyx(dyir dyir2) {
        super("LanServerDetector");
        this._a = dyir2;
        this.setDaemon(true);
        this._c = new MulticastSocket(4445);
        this._b = InetAddress.getByName("224.0.2.60");
        this._c.setSoTimeout(5000);
        this._c.joinGroup(this._b);
    }

    @Override
    public void run() {
        byte[] byArray = new byte[1024];
        while (!this.isInterrupted()) {
            DatagramPacket datagramPacket = new DatagramPacket(byArray, byArray.length);
            try {
                this._c.receive(datagramPacket);
            }
            catch (SocketTimeoutException socketTimeoutException) {
                continue;
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                break;
            }
            String string = new String(datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength());
            xpzm._E()._O()._d(datagramPacket.getAddress() + ": " + string);
            this._a._a(string, datagramPacket.getAddress());
        }
        try {
            this._c.leaveGroup(this._b);
        }
        catch (IOException iOException) {
            // empty catch block
        }
        this._c.close();
    }
}

