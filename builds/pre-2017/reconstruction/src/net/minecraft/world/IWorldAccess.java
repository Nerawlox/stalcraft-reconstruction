/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public interface IWorldAccess {
    public void _b(int var1, int var2, int var3);

    public void _c(int var1, int var2, int var3);

    public void _b(int var1, int var2, int var3, int var4, int var5, int var6);

    public void _a(String var1, double var2, double var4, double var6, float var8, float var9);

    public void _a(EntityPlayer var1, String var2, double var3, double var5, double var7, float var9, float var10);

    public void _a(String var1, double var2, double var4, double var6, double var8, double var10, double var12);

    public void _b(Entity var1);

    public void _c(Entity var1);

    public void _a(String var1, int var2, int var3, int var4);

    public void _a(int var1, int var2, int var3, int var4, int var5);

    public void _a(EntityPlayer var1, int var2, int var3, int var4, int var5, int var6);

    public void _b(int var1, int var2, int var3, int var4, int var5);
}

