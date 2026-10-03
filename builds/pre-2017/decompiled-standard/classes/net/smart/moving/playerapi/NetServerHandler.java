/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving.playerapi;

import java.lang.reflect.Field;
import java.util.List;
import net.minecraft.entity.player.EntityPlayerMP;
import net.smart.moving.playerapi.SmartMovingServerPlayerBase;
import net.smart.utilities.Install;
import net.smart.utilities.Reflect;

public class NetServerHandler
extends xbvu {
    private static final Field _minecraftServer = Reflect.GetField(xbvu.class, Install.NetServerHandler_minecraftServer);
    private static final Field _playerList = Reflect.GetField(vmra.class, Install.NetworkListenThread_playerList);

    public NetServerHandler(dzfd dzfd2, jjpj jjpj2, EntityPlayerMP entityPlayerMP) {
        super(dzfd2, jjpj2, entityPlayerMP);
    }

    @Override
    public void func_72498_a(yvzj yvzj2) {
        SmartMovingServerPlayerBase smartMovingServerPlayerBase = SmartMovingServerPlayerBase.getPlayerBase(this.field_72574_e);
        smartMovingServerPlayerBase.moving.beforeAddMovingHungerBatch();
        super.func_72498_a(yvzj2);
        smartMovingServerPlayerBase.moving.afterAddMovingHungerBatch();
    }

    @Override
    public void func_72472_a(kmuc kmuc2) {
        if (kmuc2._d() == 255) {
            cvzo cvzo2 = this.field_72574_e.field_71071_by._a();
            if (cvzo2 != null) {
                float f = 1.62f - this.field_72574_e.func_70047_e();
                this.field_72574_e.field_70129_M += f;
                super.func_72472_a(kmuc2);
                this.field_72574_e.field_70129_M -= f;
            }
        } else {
            super.func_72472_a(kmuc2);
        }
    }

    public static boolean replace(EntityPlayerMP entityPlayerMP) {
        xbvu xbvu2 = entityPlayerMP.field_71135_a;
        dzfd dzfd2 = (dzfd)Reflect.GetField(_minecraftServer, xbvu2);
        List list = (List)Reflect.GetField(_playerList, dzfd2.__ah());
        for (int i = 0; i < list.size(); ++i) {
            Object e = list.get(i);
            if (!(e instanceof xbvu) || ((xbvu)e).field_72574_e != entityPlayerMP) continue;
            NetServerHandler netServerHandler = new NetServerHandler(dzfd2, xbvu2.field_72575_b, entityPlayerMP);
            Reflect.copyFields(xbvu.class, xbvu2, netServerHandler);
            Reflect.copyFields(elai.class, xbvu2, netServerHandler);
            list.set(i, netServerHandler);
            return true;
        }
        return false;
    }
}

