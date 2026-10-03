/*
 * Decompiled with CFR 0.152.
 */
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.NetServerHandler;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.src.BaseMod;
import net.minecraft.src.ModLoader;
import net.smart.moving.SmartMoving;
import net.smart.moving.SmartMovingClient;
import net.smart.moving.mod.Client;
import net.smart.moving.mod.Mod;
import net.smart.moving.mod.None;
import net.smart.moving.mod.Server;
import net.smart.utilities.Assert;
import net.smart.utilities.Install;

public class mod_SmartMoving
extends BaseMod {
    public final Mod mod = !Assert.singleton(mod_SmartMoving.class, "Smart Moving", ModLoader.getLogger()) ? None.create(this) : (Install.hasClient ? Client.create(this) : Server.create(this));

    @Override
    public void load() {
        this.mod.load();
    }

    @Override
    public void modsLoaded() {
        this.mod.modsLoaded();
    }

    public void addRenderer(Map map) {
        this.mod.addRenderer(map);
    }

    @Override
    public void registerAnimation(Minecraft minecraft) {
        this.mod.registerAnimation(minecraft);
    }

    @Override
    public boolean onTickInGame(float f, Minecraft minecraft) {
        return this.mod.onTickInGame(f, minecraft);
    }

    @Override
    public boolean onTickInGUI(float f, Minecraft minecraft, GuiScreen guiScreen) {
        return this.mod.onTickInGUI(f, minecraft, guiScreen);
    }

    @Override
    public String getName() {
        return this.mod.getName();
    }

    @Override
    public String getVersion() {
        return this.mod.getVersion();
    }

    @Override
    public void clientCustomPayload(bscn bscn2, Packet250CustomPayload packet250CustomPayload) {
        this.mod.clientCustomPayload(bscn2, packet250CustomPayload);
    }

    @Override
    public void serverCustomPayload(NetServerHandler netServerHandler, Packet250CustomPayload packet250CustomPayload) {
        this.mod.serverCustomPayload(netServerHandler, packet250CustomPayload);
    }

    @Override
    public void receiveCustomPacket(Packet250CustomPayload packet250CustomPayload) {
        this.mod.receiveCustomPacket(packet250CustomPayload);
    }

    public void onPacket250Received(EntityPlayer entityPlayer, Packet250CustomPayload packet250CustomPayload) {
        this.mod.onPacket250Received(entityPlayer, packet250CustomPayload);
    }

    @Override
    public String toString() {
        return this.mod.toString();
    }

    public SmartMoving getInstance(EntityPlayer entityPlayer) {
        return this.mod.getInstance(entityPlayer);
    }

    public SmartMovingClient getClient() {
        return this.mod.getClient();
    }
}

