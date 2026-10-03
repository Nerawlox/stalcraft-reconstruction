/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving.playerapi;

import java.lang.reflect.Field;
import java.util.List;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.NetworkListenThread;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet10Flying;
import net.minecraft.network.packet.Packet15Place;
import net.minecraft.server.MinecraftServer;
import net.smart.moving.playerapi.SmartMovingServerPlayerBase;
import net.smart.utilities.Install;
import net.smart.utilities.Reflect;

public class NetServerHandler
extends net.minecraft.network.NetServerHandler {
    private static final Field _minecraftServer = Reflect.GetField(net.minecraft.network.NetServerHandler.class, Install.NetServerHandler_minecraftServer);
    private static final Field _playerList = Reflect.GetField(NetworkListenThread.class, Install.NetworkListenThread_playerList);

    public NetServerHandler(MinecraftServer minecraftServer, jjpj jjpj2, EntityPlayerMP entityPlayerMP) {
        super(minecraftServer, jjpj2, entityPlayerMP);
    }

    @Override
    public void handleFlying(Packet10Flying packet10Flying) {
        SmartMovingServerPlayerBase smartMovingServerPlayerBase = SmartMovingServerPlayerBase.getPlayerBase(this.playerEntity);
        smartMovingServerPlayerBase.moving.beforeAddMovingHungerBatch();
        super.handleFlying(packet10Flying);
        smartMovingServerPlayerBase.moving.afterAddMovingHungerBatch();
    }

    @Override
    public void handlePlace(Packet15Place packet15Place) {
        if (packet15Place._d() == 255) {
            ItemStack itemStack = this.playerEntity.inventory._a();
            if (itemStack != null) {
                float f = 1.62f - this.playerEntity.getEyeHeight();
                this.playerEntity.yOffset += f;
                super.handlePlace(packet15Place);
                this.playerEntity.yOffset -= f;
            }
        } else {
            super.handlePlace(packet15Place);
        }
    }

    public static boolean replace(EntityPlayerMP entityPlayerMP) {
        net.minecraft.network.NetServerHandler netServerHandler = entityPlayerMP.playerNetServerHandler;
        MinecraftServer minecraftServer = (MinecraftServer)Reflect.GetField(_minecraftServer, netServerHandler);
        List list = (List)Reflect.GetField(_playerList, minecraftServer.__ah());
        for (int i = 0; i < list.size(); ++i) {
            Object e = list.get(i);
            if (!(e instanceof net.minecraft.network.NetServerHandler) || ((net.minecraft.network.NetServerHandler)e).playerEntity != entityPlayerMP) continue;
            NetServerHandler netServerHandler2 = new NetServerHandler(minecraftServer, netServerHandler.netManager, entityPlayerMP);
            Reflect.copyFields(net.minecraft.network.NetServerHandler.class, netServerHandler, netServerHandler2);
            Reflect.copyFields(NetHandler.class, netServerHandler, netServerHandler2);
            list.set(i, netServerHandler2);
            return true;
        }
        return false;
    }
}

