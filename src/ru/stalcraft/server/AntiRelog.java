/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.ReflectionHelper
 *  hn
 *  net.minecraft.server.MinecraftServer
 */
package ru.stalcraft.server;

import cpw.mods.fml.relauncher.ReflectionHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import ru.stalcraft.player.IAntiRelog;
import ru.stalcraft.server.network.ServerPacketSender;

public class AntiRelog
implements IAntiRelog {
    private List reloggingPlayers = new ArrayList();
    private static final int MAX_TIMER = 1200;

    private void fullExit(jv player) {
        if (MinecraftServer.F().V()) {
            try {
                ReflectionHelper.findMethod(hn.class, (Object)MinecraftServer.F().af(), (String[])new String[]{"writePlayerData", "func_72391_b", "b"}, (Class[])new Class[]{jv.class}).invoke(MinecraftServer.F().af(), player);
            }
            catch (Exception exception) {
                // empty catch block
            }
            player.p().e(player);
        }
    }

    public List getPlayers() {
        return this.reloggingPlayers;
    }

    @Override
    public void onDamage(jv player) {
        if (MinecraftServer.F().V()) {
            ReloggingPlayer rp2;
            Iterator i$ = this.reloggingPlayers.iterator();
            do {
                if (!i$.hasNext()) {
                    if (player.aN() <= 0.0f) {
                        this.fullExit(player);
                    }
                    return;
                }
                rp2 = (ReloggingPlayer)i$.next();
            } while (player != rp2.player);
            rp2.timer = 1200;
            rp2.player.af = 0;
        }
    }

    @Override
    public void addReloggingPlayer(jv player) {
        if (MinecraftServer.F().V()) {
            this.reloggingPlayers.add(new ReloggingPlayer(player));
            try {
                ReflectionHelper.findMethod(hn.class, (Object)MinecraftServer.F().af(), (String[])new String[]{"writePlayerData", "func_72391_b", "b"}, (Class[])new Class[]{jv.class}).invoke(MinecraftServer.F().af(), player);
            }
            catch (Exception e2) {
                e2.printStackTrace();
            }
            ServerPacketSender.sendHasQuitted(player);
        }
    }

    public jv getAndRemoveReloggingPlayer(String username) {
        ReloggingPlayer rp2;
        Iterator it2 = this.reloggingPlayers.iterator();
        do {
            if (!it2.hasNext()) {
                return null;
            }
            rp2 = (ReloggingPlayer)it2.next();
        } while (!rp2.player.bu.equals(username));
        it2.remove();
        return rp2.player;
    }

    @Override
    public void tick() {
        if (MinecraftServer.F().V()) {
            Iterator it2 = this.reloggingPlayers.iterator();
            hn scm = MinecraftServer.F().af();
            while (it2.hasNext()) {
                ReloggingPlayer rp2 = (ReloggingPlayer)it2.next();
                if (--rp2.timer > 0 && scm.f(rp2.player.bu) == null) continue;
                this.fullExit(rp2.player);
                it2.remove();
            }
        }
    }

    @Override
    public boolean isPlayerRelogging(jv player) {
        if (MinecraftServer.F().V()) {
            ReloggingPlayer rp2;
            Iterator i$ = this.reloggingPlayers.iterator();
            do {
                if (!i$.hasNext()) {
                    return false;
                }
                rp2 = (ReloggingPlayer)i$.next();
            } while (rp2.player != player);
        }
        return false;
    }

    @Override
    public void onSaveAll() {
        if (MinecraftServer.F().V()) {
            for (ReloggingPlayer rp2 : this.reloggingPlayers) {
                try {
                    ReflectionHelper.findMethod(hn.class, (Object)MinecraftServer.F().af(), (String[])new String[]{"writePlayerData", "func_72391_b", "b"}, (Class[])new Class[]{jv.class}).invoke(MinecraftServer.F().af(), rp2.player);
                }
                catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public class ReloggingPlayer {
        public int timer = 1200;
        public final jv player;

        public ReloggingPlayer(jv player) {
            this.player = player;
        }
    }
}

