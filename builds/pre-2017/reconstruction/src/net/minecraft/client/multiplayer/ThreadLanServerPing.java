/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.multiplayer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import net.minecraft.client.Minecraft;

public class ThreadLanServerPing
extends Thread {
    public final String _a;
    public final DatagramSocket _b;
    public boolean _c = true;
    public final String _d;

    public ThreadLanServerPing(String string, String string2) {
        super("LanServerPinger");
        this._a = string;
        this._d = string2;
        this.setDaemon(true);
        this._b = new DatagramSocket();
    }

    @Override
    public void run() {
        String string = ThreadLanServerPing._a(this._a, this._d);
        byte[] byArray = string.getBytes();
        while (!this.isInterrupted() && this._c) {
            try {
                InetAddress inetAddress = InetAddress.getByName("224.0.2.60");
                DatagramPacket datagramPacket = new DatagramPacket(byArray, byArray.length, inetAddress, 4445);
                this._b.send(datagramPacket);
            }
            catch (IOException iOException) {
                Minecraft._E()._O()._b("LanServerPinger: " + iOException.getMessage());
                break;
            }
            try {
                ThreadLanServerPing.sleep(1500L);
            }
            catch (InterruptedException interruptedException) {}
        }
    }

    @Override
    public void interrupt() {
        super.interrupt();
        this._c = false;
    }

    public static String _a(String string, String string2) {
        return "[MOTD]" + string + "[/MOTD][AD]" + string2 + "[/AD]";
    }

    public static String _a(String string) {
        int n = string.indexOf("[MOTD]");
        if (n < 0) {
            return "missing no";
        }
        int n2 = string.indexOf("[/MOTD]", n + "[MOTD]".length());
        if (n2 < n) {
            return "missing no";
        }
        return string.substring(n + "[MOTD]".length(), n2);
    }

    public static String _b(String string) {
        int n = string.indexOf("[/MOTD]");
        if (n < 0) {
            return null;
        }
        int n2 = string.indexOf("[/MOTD]", n + "[/MOTD]".length());
        if (n2 >= 0) {
            return null;
        }
        int n3 = string.indexOf("[AD]", n + "[/MOTD]".length());
        if (n3 < 0) {
            return null;
        }
        int n4 = string.indexOf("[/AD]", n3 + "[AD]".length());
        if (n4 < n3) {
            return null;
        }
        return string.substring(n3 + "[AD]".length(), n4);
    }
}

