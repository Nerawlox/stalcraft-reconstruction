/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.IWorldAccess;
import net.minecraft.world.WorldServer;

public class WorldManager
implements IWorldAccess {
    public MinecraftServer _a;
    public WorldServer _b;

    public WorldManager(MinecraftServer minecraftServer, WorldServer worldServer) {
        this._a = minecraftServer;
        this._b = worldServer;
    }

    @Override
    public void _a(String string, double d, double d2, double d3, double d4, double d5, double d6) {
    }

    @Override
    public void _b(Entity entity) {
        this._b.getEntityTracker()._a(entity);
    }

    @Override
    public void _c(Entity entity) {
        this._b.getEntityTracker()._b(entity);
    }

    @Override
    public void _a(String string, double d, double d2, double d3, float f, float f2) {
        this._a.__ag()._a(d, d2, d3, f > 1.0f ? (double)(16.0f * f) : 16.0, this._b.provider._i, new lpza(string, d, d2, d3, f, f2));
    }

    @Override
    public void _a(EntityPlayer entityPlayer, String string, double d, double d2, double d3, float f, float f2) {
        this._a.__ag()._a(entityPlayer, d, d2, d3, f > 1.0f ? (double)(16.0f * f) : 16.0, this._b.provider._i, new lpza(string, d, d2, d3, f, f2));
    }

    @Override
    public void _b(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    @Override
    public void _b(int n, int n2, int n3) {
        this._b.getPlayerManager()._a(n, n2, n3);
    }

    @Override
    public void _c(int n, int n2, int n3) {
    }

    @Override
    public void _a(String string, int n, int n2, int n3) {
    }

    @Override
    public void _a(EntityPlayer entityPlayer, int n, int n2, int n3, int n4, int n5) {
        this._a.__ag()._a(entityPlayer, n2, n3, n4, 64.0, this._b.provider._i, new qohl(n, n2, n3, n4, n5, false));
    }

    @Override
    public void _a(int n, int n2, int n3, int n4, int n5) {
        this._a.__ag()._a(new qohl(n, n2, n3, n4, n5, true));
    }

    @Override
    public void _b(int n, int n2, int n3, int n4, int n5) {
        for (EntityPlayerMP entityPlayerMP : this._a.__ag()._e) {
            double d;
            double d2;
            double d3;
            if (entityPlayerMP == null || entityPlayerMP.worldObj != this._b || entityPlayerMP.entityId == n || !((d3 = (double)n2 - entityPlayerMP.posX) * d3 + (d2 = (double)n3 - entityPlayerMP.posY) * d2 + (d = (double)n4 - entityPlayerMP.posZ) * d < 1024.0)) continue;
            entityPlayerMP.playerNetServerHandler.func_72567_b(new igpu(n, n2, n3, n4, n5));
        }
    }
}

