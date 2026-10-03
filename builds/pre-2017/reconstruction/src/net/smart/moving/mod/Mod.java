/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving.mod;

import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.NetServerHandler;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.smart.moving.SmartMoving;
import net.smart.moving.SmartMovingClient;
import net.smart.moving.SmartMovingContext;

public abstract class Mod {
    protected final mod_SmartMoving mod;

    protected Mod(mod_SmartMoving mod_SmartMoving2) {
        this.mod = mod_SmartMoving2;
    }

    public void load() {
    }

    public void modsLoaded() {
    }

    public void addRenderer(Map map) {
    }

    public void registerAnimation(Minecraft minecraft) {
    }

    public boolean onTickInGame(float f, Minecraft minecraft) {
        return false;
    }

    public boolean onTickInGUI(float f, Minecraft minecraft, GuiScreen guiScreen) {
        return false;
    }

    public void clientCustomPayload(bscn bscn2, Packet250CustomPayload packet250CustomPayload) {
    }

    public void serverCustomPayload(NetServerHandler netServerHandler, Packet250CustomPayload packet250CustomPayload) {
    }

    public void receiveCustomPacket(Packet250CustomPayload packet250CustomPayload) {
    }

    public void onPacket250Received(EntityPlayer entityPlayer, Packet250CustomPayload packet250CustomPayload) {
    }

    public String getName() {
        return "Smart Moving";
    }

    public String getVersion() {
        return "14.5";
    }

    public String toString() {
        return "Smart Moving 14.5";
    }

    public SmartMoving getInstance(EntityPlayer entityPlayer) {
        return null;
    }

    public SmartMovingClient getClient() {
        return SmartMovingContext.Client;
    }
}

