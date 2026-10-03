/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core;

import codechicken.core.CommonUtils;
import codechicken.core.NetworkClosedException;
import codechicken.core.internal.ClientTickHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.net.Socket;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;

public class ClientUtils
extends CommonUtils {
    private static xpzm mc() {
        return xpzm._E();
    }

    public static ozlu getWorld() {
        return ClientUtils.mc()._r;
    }

    public static EntityPlayer getPlayer(String string) {
        return string == ClientUtils.mc()._t.field_71092_bJ || string == null ? ClientUtils.mc()._t : null;
    }

    public static boolean isClient(ozlu ozlu2) {
        return ozlu2 instanceof pkix;
    }

    public static boolean inWorld() {
        return ClientUtils.mc()._z() != null;
    }

    public static void openSMPGui(int n, gqjz gqjz2) {
        ClientUtils.mc()._a(gqjz2);
        if (n != 0) {
            ClientUtils.mc()._t.field_71070_bA.field_75152_c = n;
        }
    }

    public static float getRenderFrame() {
        return ClientTickHandler.renderFrame;
    }

    public static double getRenderTime() {
        return (float)ClientTickHandler.renderTime + ClientUtils.getRenderFrame();
    }

    public static String getServerIP() {
        try {
            jjpj jjpj2 = ClientUtils.mc()._z()._d();
            if (jjpj2 instanceof tgls) {
                return "memory";
            }
            Socket socket = ((hdip)jjpj2)._k();
            if (socket == null) {
                throw new NetworkClosedException();
            }
            return socket.getInetAddress().getHostAddress() + ":" + socket.getPort();
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public static boolean isLocal() {
        return ClientUtils.getServerIP().equals("memory");
    }

    @SideOnly(value=Side.CLIENT)
    public static String getWorldSaveName(String string) {
        if (!ClientUtils.isLocal()) {
            return null;
        }
        return dzfd._I()._j();
    }
}

