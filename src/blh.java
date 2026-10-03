/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

@SideOnly(value=Side.CLIENT)
public class blh
extends Thread {
    private final String a;
    private final DatagramSocket b;
    private boolean c = true;
    private final String d;

    public blh(String par1Str, String par2Str) throws IOException {
        super("LanServerPinger");
        this.a = par1Str;
        this.d = par2Str;
        this.setDaemon(true);
        this.b = new DatagramSocket();
    }

    @Override
    public void run() {
        String s2 = blh.a(this.a, this.d);
        byte[] abyte = s2.getBytes();
        while (!this.isInterrupted() && this.c) {
            try {
                InetAddress inetaddress = InetAddress.getByName("224.0.2.60");
                DatagramPacket datagrampacket = new DatagramPacket(abyte, abyte.length, inetaddress, 4445);
                this.b.send(datagrampacket);
            }
            catch (IOException ioexception) {
                atv.w().an().b("LanServerPinger: " + ioexception.getMessage());
                break;
            }
            try {
                blh.sleep(1500L);
            }
            catch (InterruptedException interruptedException) {}
        }
    }

    @Override
    public void interrupt() {
        super.interrupt();
        this.c = false;
    }

    public static String a(String par0Str, String par1Str) {
        return "[MOTD]" + par0Str + "[/MOTD][AD]" + par1Str + "[/AD]";
    }

    public static String a(String par0Str) {
        int i2 = par0Str.indexOf("[MOTD]");
        if (i2 < 0) {
            return "missing no";
        }
        int j2 = par0Str.indexOf("[/MOTD]", i2 + "[MOTD]".length());
        return j2 < i2 ? "missing no" : par0Str.substring(i2 + "[MOTD]".length(), j2);
    }

    public static String b(String par0Str) {
        int i2 = par0Str.indexOf("[/MOTD]");
        if (i2 < 0) {
            return null;
        }
        int j2 = par0Str.indexOf("[/MOTD]", i2 + "[/MOTD]".length());
        if (j2 >= 0) {
            return null;
        }
        int k = par0Str.indexOf("[AD]", i2 + "[/MOTD]".length());
        if (k < 0) {
            return null;
        }
        int l2 = par0Str.indexOf("[/AD]", k + "[AD]".length());
        return l2 < k ? null : par0Str.substring(k + "[AD]".length(), l2);
    }
}

