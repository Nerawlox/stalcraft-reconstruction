/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  blg
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

@SideOnly(value=Side.CLIENT)
public class blf
extends Thread {
    private final blg a;
    private final InetAddress b;
    private final MulticastSocket c;

    public blf(blg par1LanServerList) throws IOException {
        super("LanServerDetector");
        this.a = par1LanServerList;
        this.setDaemon(true);
        this.c = new MulticastSocket(4445);
        this.b = InetAddress.getByName("224.0.2.60");
        this.c.setSoTimeout(5000);
        this.c.joinGroup(this.b);
    }

    @Override
    public void run() {
        byte[] abyte = new byte[1024];
        while (!this.isInterrupted()) {
            DatagramPacket datagrampacket = new DatagramPacket(abyte, abyte.length);
            try {
                this.c.receive(datagrampacket);
            }
            catch (SocketTimeoutException sockettimeoutexception) {
                continue;
            }
            catch (IOException ioexception) {
                ioexception.printStackTrace();
                break;
            }
            String s2 = new String(datagrampacket.getData(), datagrampacket.getOffset(), datagrampacket.getLength());
            atv.w().an().d(datagrampacket.getAddress() + ": " + s2);
            this.a.a(s2, datagrampacket.getAddress());
        }
        try {
            this.c.leaveGroup(this.b);
        }
        catch (IOException iOException) {
            // empty catch block
        }
        this.c.close();
    }
}

