/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  abp
 *  net.minecraft.server.MinecraftServer
 *  net.minecraftforge.common.DimensionManager
 */
package ru.stalcraft.server.ejection;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.DimensionManager;
import ru.stalcraft.StalkerDamage;
import ru.stalcraft.ejection.Ejection;
import ru.stalcraft.player.PlayerUtils;
import ru.stalcraft.server.CommonProxy;
import ru.stalcraft.server.network.ServerPacketSender;
import ru.stalcraft.server.player.PlayerServerInfo;

public class ServerEjection
extends Ejection {
    private int lastLightning = 0;
    private Set<abp> doneChunks = new HashSet<abp>();
    private int updateLCG = new Random().nextInt();

    public ServerEjection() {
        this(CommonProxy.serverEjectionManager.getLastEjectionId() + 1, 0);
    }

    public ServerEjection(int id, int age) {
        super(id, age);
    }

    @Override
    public void tick() {
        super.tick();
        js par1 = DimensionManager.getWorld((int)0);
        par1.N().b(false);
        par1.N().a(false);
        if (this.age >= 4000) {
            for (jv player : MinecraftServer.F().af().a) {
                PlayerServerInfo playerInfo = (PlayerServerInfo)PlayerUtils.getInfo(player);
                if (this.age % 20 != 0 || playerInfo.isEjectionSave || player.bG.d && MinecraftServer.F().af().e(player.bu)) continue;
                player.a(StalkerDamage.ejection, 5.0f);
            }
        }
        if (this.age >= 12000) {
            this.end();
        }
    }

    @Override
    public void start() {
        if (CommonProxy.serverEjectionManager.hasEjection()) {
            CommonProxy.serverEjectionManager.getEjection().end();
        }
        CommonProxy.serverEjectionManager.setEjection(this);
        ServerPacketSender.sendEjectionStart(this.id, 0);
    }

    @Override
    public void end() {
        CommonProxy.serverEjectionManager.setLastEjectionId(this.id);
        CommonProxy.serverEjectionManager.setEjection(null);
        ServerPacketSender.sendEjectionEnd();
    }
}

