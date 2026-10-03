/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.registry.LanguageRegistry
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  mt
 */
package ru.stalcraft.items;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.entity.EntityGrenade;

public class ItemGrenade
extends yc {
    public final String modelName;
    public final String modelTexture;
    public final String textureName;
    private final List description;
    public final float explosionSize;
    public final float maxStartSpeed;
    public final boolean handUse;
    public final int lifetime;
    public final boolean explosionOnCollide;
    private static int nextId = 0;

    public ItemGrenade(int id, String name, String modelName, String modelTexture, String textureName, List description, float explosionSize, float maxStartSpeed, boolean handUse, int lifetime, boolean explosionOnCollide) {
        super(id - 256);
        this.b("grenade" + ++nextId);
        this.a(StalkerMain.tab);
        LanguageRegistry.addName((Object)this, (String)name);
        this.modelName = modelName;
        this.modelTexture = modelTexture;
        this.textureName = textureName;
        this.description = description;
        this.explosionSize = explosionSize;
        this.maxStartSpeed = maxStartSpeed;
        this.handUse = handUse;
        this.lifetime = lifetime;
        this.explosionOnCollide = explosionOnCollide;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(mt par1IconRegister) {
        this.cz = par1IconRegister.a("stalker:" + this.textureName);
    }

    @Override
    public void a(ye par1ItemStack, uf par2EntityPlayer, List par3List, boolean par4) {
        par3List.addAll(this.description);
    }

    @Override
    public zj c_(ye par1ItemStack) {
        return zj.e;
    }

    @Override
    public int d_(ye par1ItemStack) {
        return 72000;
    }

    @Override
    public ye a(ye is2, abw world, uf player) {
        if (this.handUse) {
            player.a(is2, this.d_(is2));
        }
        return is2;
    }

    @Override
    public void a(ye is2, abw world, uf player, int ticksRemaining) {
        if (!world.I) {
            int ticksUsed = Math.min(20, this.d_(is2) - ticksRemaining);
            float throwPower = (float)ticksUsed / 20.0f;
            EntityGrenade grenade = new EntityGrenade(world, player, throwPower * this.maxStartSpeed, this.explosionSize, this.modelName, this.textureName, this.lifetime, this.explosionOnCollide);
            world.d(grenade);
        }
        if (!player.bG.d && player.bn.h() != null) {
            if (player.bn.a[player.bn.c].b == 1) {
                player.bn.a[player.bn.c] = null;
            } else {
                --player.bn.a[player.bn.c].b;
            }
        }
    }
}

