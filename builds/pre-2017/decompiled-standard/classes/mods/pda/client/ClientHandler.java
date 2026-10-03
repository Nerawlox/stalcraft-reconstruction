/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client;

import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.Player;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import mods.pda.PdaMod;
import mods.pda.client.PdaClient;
import mods.pda.client.waypoint.DeathWaypoint;
import mods.pda.client.waypoint.UserWaypoint;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import org.lwjgl.util.vector.Vector3f;

public class ClientHandler
implements IConnectionHandler {
    @ForgeSubscribe
    public void onWorldLoad(lnrm.kjui kjui2) {
        if (kjui2._c == lnrm.pidb._b && xpzm._E()._r != null) {
            PdaMod.getClientPda().newsFetcher.publishNotification();
        }
    }

    @Override
    public void clientLoggedIn(elai elai2, jjpj jjpj2, txpf txpf2) {
        new sare(PdaMod.instance.quests.getActiveQuest()).sendToServer();
    }

    @ForgeSubscribe
    public void onSoundLoad(SoundLoadEvent soundLoadEvent) {
        String[] stringArray;
        for (String string : stringArray = new String[]{"radar_update"}) {
            try {
                soundLoadEvent.manager._a("pda:" + string + ".ogg");
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @ForgeSubscribe(priority=EventPriority.LOWEST)
    public void onClientDeath(GuiOpenEvent guiOpenEvent) {
        xpzm xpzm2 = xpzm._E();
        if (guiOpenEvent.gui instanceof jzaw && !(xpzm2._B instanceof jzaw)) {
            EntityClientPlayerMP entityClientPlayerMP = xpzm2._t;
            if ((double)entityClientPlayerMP.func_110143_aJ() > 0.0) {
                return;
            }
            Vector3f vector3f = new Vector3f((float)entityClientPlayerMP.field_70165_t, (float)entityClientPlayerMP.field_70163_u, (float)entityClientPlayerMP.field_70161_v);
            DeathWaypoint deathWaypoint = new DeathWaypoint(vector3f, -1);
            PdaMod.getClientPda().waypoints.add(deathWaypoint);
            this.updateDeathPoints(PdaClient.deathPointsAmount.value);
            PdaMod.getClientPda().waypoints.saveToFileSystem();
        }
    }

    private void updateDeathPoints(int n) {
        List list = PdaMod.getClientPda().waypoints.stream().filter(DeathWaypoint.class::isInstance).sorted(Comparator.comparing(UserWaypoint::getTime)).collect(Collectors.toList());
        List list2 = list.subList(Math.max(0, list.size() - n), list.size());
        PdaMod.getClientPda().waypoints.removeIf(userWaypoint -> userWaypoint instanceof DeathWaypoint && !list2.contains(userWaypoint));
    }

    @Override
    public void playerLoggedIn(Player player, elai elai2, jjpj jjpj2) {
    }

    @Override
    public String connectionReceived(yezc yezc2, jjpj jjpj2) {
        return null;
    }

    @Override
    public void connectionOpened(elai elai2, String string, int n, jjpj jjpj2) {
    }

    @Override
    public void connectionOpened(elai elai2, dzfd dzfd2, jjpj jjpj2) {
    }

    @Override
    public void connectionClosed(jjpj jjpj2) {
    }
}

