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
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.TcpConnection;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class ClientUtils
extends CommonUtils {
    private static Minecraft mc() {
        return Minecraft._E();
    }

    public static World getWorld() {
        return ClientUtils.mc()._r;
    }

    public static EntityPlayer getPlayer(String string) {
        return string == ClientUtils.mc()._t.username || string == null ? ClientUtils.mc()._t : null;
    }

    public static boolean isClient(World world) {
        return world instanceof pkix;
    }

    public static boolean inWorld() {
        return ClientUtils.mc()._z() != null;
    }

    public static void openSMPGui(int n, GuiScreen guiScreen) {
        ClientUtils.mc()._a(guiScreen);
        if (n != 0) {
            ClientUtils.mc()._t.openContainer.windowId = n;
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
            Socket socket = ((TcpConnection)jjpj2)._k();
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
        return MinecraftServer._I()._j();
    }
}

