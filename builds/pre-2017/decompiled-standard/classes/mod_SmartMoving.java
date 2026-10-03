/*
 * Decompiled with CFR 0.152.
 */
import java.util.Map;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;
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
    public void registerAnimation(xpzm xpzm2) {
        this.mod.registerAnimation(xpzm2);
    }

    @Override
    public boolean onTickInGame(float f, xpzm xpzm2) {
        return this.mod.onTickInGame(f, xpzm2);
    }

    @Override
    public boolean onTickInGUI(float f, xpzm xpzm2, gqjz gqjz2) {
        return this.mod.onTickInGUI(f, xpzm2, gqjz2);
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
    public void clientCustomPayload(bscn bscn2, jjqf jjqf2) {
        this.mod.clientCustomPayload(bscn2, jjqf2);
    }

    @Override
    public void serverCustomPayload(xbvu xbvu2, jjqf jjqf2) {
        this.mod.serverCustomPayload(xbvu2, jjqf2);
    }

    @Override
    public void receiveCustomPacket(jjqf jjqf2) {
        this.mod.receiveCustomPacket(jjqf2);
    }

    public void onPacket250Received(EntityPlayer entityPlayer, jjqf jjqf2) {
        this.mod.onPacket250Received(entityPlayer, jjqf2);
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

