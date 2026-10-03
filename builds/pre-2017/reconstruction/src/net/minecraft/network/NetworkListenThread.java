/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network;

import cpw.mods.fml.common.FMLLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.network.NetServerHandler;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.turb;

public abstract class NetworkListenThread {
    public final MinecraftServer _a;
    public final List _b = Collections.synchronizedList(new ArrayList());
    public volatile boolean _c;

    public NetworkListenThread(MinecraftServer minecraftServer) throws IOException {
        this._a = minecraftServer;
        this._c = true;
    }

    public void _a(NetServerHandler netServerHandler) {
        this._b.add(netServerHandler);
    }

    public void _a() {
        this._c = false;
    }

    public void _b() {
        for (int i = 0; i < this._b.size(); ++i) {
            NetServerHandler netServerHandler = (NetServerHandler)this._b.get(i);
            try {
                netServerHandler.func_72570_d();
            }
            catch (Exception exception) {
                if (netServerHandler.netManager instanceof tgls) {
                    CrashReport crashReport = CrashReport.makeCrashReport(exception, "Ticking memory connection");
                    CrashReportCategory crashReportCategory = crashReport.makeCategory("Ticking connection");
                    crashReportCategory._a("Connection", new rrgz(this, netServerHandler));
                    throw new turb(crashReport);
                }
                FMLLog.log(Level.SEVERE, exception, "A critical server error occured handling a packet, kicking %s", netServerHandler.getPlayer().entityId);
                this._a._O()._a("Failed to handle packet for " + netServerHandler.playerEntity.getEntityName() + "/" + netServerHandler.playerEntity.getPlayerIP() + ": " + exception, exception);
                netServerHandler.func_72565_c("Internal server error");
            }
            if (netServerHandler.connectionClosed) {
                this._b.remove(i--);
            }
            netServerHandler.netManager._a();
        }
    }

    public MinecraftServer _c() {
        return this._a;
    }
}

