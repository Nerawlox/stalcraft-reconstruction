/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.constants.EnumGuiType;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.controllers.PlayerDataController;
import noppes.npcs.controllers.PlayerTransportData;
import noppes.npcs.controllers.TransportController;
import noppes.npcs.controllers.TransportLocation;
import noppes.npcs.roles.RoleInterface;

public class RoleTransporter
extends RoleInterface {
    public int transportId = -1;
    public String name;
    private int ticks = 10;

    public RoleTransporter(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
    }

    @Override
    public void writeEntityToNBT(qoac qoac2) {
        qoac2._a("TransporterId", this.transportId);
    }

    @Override
    public void readEntityFromNBT(qoac qoac2) {
        this.transportId = qoac2._f("TransporterId");
        TransportLocation transportLocation = this.getLocation();
        if (transportLocation != null) {
            this.name = transportLocation.name;
        }
        if (transportLocation == null) {
            this.transportId = -1;
            this.name = "";
        }
    }

    @Override
    public boolean aiShouldExecute() {
        --this.ticks;
        if (this.ticks > 0) {
            return false;
        }
        this.ticks = 10;
        if (!this.hasTransport()) {
            return false;
        }
        TransportLocation transportLocation = this.getLocation();
        if (transportLocation.type != 0) {
            return false;
        }
        List list2 = this.npc.field_70170_p.func_72872_a(EntityPlayer.class, this.npc.field_70121_D._b(6.0, 6.0, 6.0));
        for (EntityPlayer entityPlayer : list2) {
            if (!this.npc.func_70685_l(entityPlayer)) continue;
            this.unlock(entityPlayer, transportLocation);
        }
        return false;
    }

    private void unlock(EntityPlayer entityPlayer, TransportLocation transportLocation) {
        PlayerTransportData playerTransportData = PlayerDataController.instance.getPlayerData((EntityPlayer)entityPlayer).transportData;
        if (!playerTransportData.transports.contains(this.transportId)) {
            playerTransportData.transports.add(this.transportId);
            NoppesUtilServer.sendData(entityPlayer, EnumPacketType.Chat, "transporter.unlock1", " " + transportLocation.name + " ", "transporter.unlock2");
        }
    }

    @Override
    public void aiStartExecuting() {
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        if (this.hasTransport()) {
            TransportLocation transportLocation = this.getLocation();
            if (transportLocation.type == 2) {
                this.unlock(entityPlayer, transportLocation);
            }
            NoppesUtilServer.sendOpenGui(entityPlayer, EnumGuiType.PlayerTransporter, this.npc);
        }
        return false;
    }

    public TransportLocation getLocation() {
        return this.npc.field_70170_p.field_72995_K ? null : TransportController.getInstance().getTransport(this.transportId);
    }

    public boolean hasTransport() {
        TransportLocation transportLocation = this.getLocation();
        return transportLocation != null && transportLocation.isNpc(this.npc);
    }

    public void setTransport(TransportLocation transportLocation) {
        this.transportId = transportLocation.id;
        this.name = transportLocation.name;
    }
}

