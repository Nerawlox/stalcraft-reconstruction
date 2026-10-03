/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving.mod;

import java.io.File;
import java.util.logging.Logger;
import net.minecraft.network.NetServerHandler;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.MinecraftForge;
import net.smart.moving.SmartMovingPacketStream;
import net.smart.moving.SmartMovingServer;
import net.smart.moving.SmartMovingServerComm;
import net.smart.moving.mod.Mod;
import net.smart.moving.mod.SmartEventHandler;
import net.smart.moving.playerapi.SmartMovingServerPlayerBase;
import net.smart.utilities.Assert;
import net.smart.utilities.Install;

public class Server
extends Mod {
    public static Server create(mod_SmartMoving mod_SmartMoving2) {
        Logger logger = ModLoader.getLogger();
        Assert.server(logger);
        Assert.serverPlayerAPI(logger);
        return new Server(mod_SmartMoving2);
    }

    protected Server(mod_SmartMoving mod_SmartMoving2) {
        super(mod_SmartMoving2);
    }

    @Override
    public void load() {
        ModLoader.registerPacketChannel(this.mod, SmartMovingPacketStream.Id);
        SmartMovingServer.initialize(new File("."), Install.getLogger(MinecraftServer._I()._O()), ModLoader.getMinecraftServerInstance()._r()._a(), false);
        MinecraftForge.EVENT_BUS.register(new SmartEventHandler());
    }

    @Override
    public void modsLoaded() {
        SmartMovingServerPlayerBase.registerPlayerBase();
    }

    @Override
    public void serverCustomPayload(NetServerHandler netServerHandler, Packet250CustomPayload packet250CustomPayload) {
        SmartMovingPacketStream.receivePacket(packet250CustomPayload, SmartMovingServerComm.instance, SmartMovingServerPlayerBase.getPlayerBase(netServerHandler.playerEntity));
    }
}

