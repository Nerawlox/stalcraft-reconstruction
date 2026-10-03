/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.Player;
import gloomyfolken.mods.stalker.hud.pidb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.server.MinecraftServer;

public class ntpl
implements IConnectionHandler {
    public static fokl _a = new dfso();
    private static long _b = -1L;
    private static long _c = -1L;
    private boolean _d = false;

    @Override
    public void clientLoggedIn(NetHandler netHandler, jjpj jjpj2, txpf txpf2) {
        if (!this._d) {
            FMLLog.info("Sending hardware data", new Object[0]);
            new ntaf(bqss._a()).sendClientToBackend();
            FMLLog.info("Hardware data sent", new Object[0]);
            this._d = true;
        }
    }

    public static void _a() {
        boolean bl;
        long l = ntte._b;
        boolean bl2 = Minecraft._E()._r != null;
        boolean bl3 = l > 600L && _b <= 0L;
        boolean bl4 = bl = _b > 0L && l - _b > 72000L;
        if (_c <= 0L && bl2 && (bl3 || bl)) {
            FMLLog.info("Starting sample profiling", new Object[0]);
            _c = l;
            _a._a();
            ntpl._a._c = true;
        }
        if (_c <= 0L) {
            return;
        }
        if (!bl2) {
            FMLLog.info("Terminating sample profiling after game exit", new Object[0]);
            ntpl._a._c = false;
            _c = -1L;
            _a._a();
            return;
        }
        long l2 = l - _c;
        if (l2 > 100L) {
            FMLLog.info("Finishing sample profiling", new Object[0]);
            HashMap<String, Long> hashMap = new HashMap<String, Long>(ntpl._a._e);
            _a._a();
            ntpl._a._c = false;
            _c = -1L;
            _b = l;
            List<String> list2 = new ArrayList<String>();
            GuiIngame guiIngame = Minecraft._E()._J;
            if (guiIngame instanceof pidb) {
                ((pidb)guiIngame)._a(list2);
                ((pidb)guiIngame)._b(list2);
            }
            list2 = list2.stream().filter(Objects::nonNull).collect(Collectors.toList());
            new piev(hashMap, list2).sendClientToBackend();
        }
    }

    @Override
    public void playerLoggedIn(Player player, NetHandler netHandler, jjpj jjpj2) {
    }

    @Override
    public String connectionReceived(yezc yezc2, jjpj jjpj2) {
        return null;
    }

    @Override
    public void connectionOpened(NetHandler netHandler, String string, int n, jjpj jjpj2) {
    }

    @Override
    public void connectionOpened(NetHandler netHandler, MinecraftServer minecraftServer, jjpj jjpj2) {
    }

    @Override
    public void connectionClosed(jjpj jjpj2) {
    }
}

