/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving.mod;

import java.util.Map;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;
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

    public void registerAnimation(xpzm xpzm2) {
    }

    public boolean onTickInGame(float f, xpzm xpzm2) {
        return false;
    }

    public boolean onTickInGUI(float f, xpzm xpzm2, gqjz gqjz2) {
        return false;
    }

    public void clientCustomPayload(bscn bscn2, jjqf jjqf2) {
    }

    public void serverCustomPayload(xbvu xbvu2, jjqf jjqf2) {
    }

    public void receiveCustomPacket(jjqf jjqf2) {
    }

    public void onPacket250Received(EntityPlayer entityPlayer, jjqf jjqf2) {
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

