/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.anomaly.pidb;
import gloomyfolken.mods.anomaly.qlgf;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.core.misc.ezey;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class sayw
extends zwpb {
    public sayw(int n, qlgf qlgf2) {
        super(n, GloomyCore.fakeAir, qlgf2, "anomalies:steam", 0.03f);
        this.setUnlocalizedName("steam");
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int n, int n2, int n3, Entity entity) {
        if (!entity.isEntityInvulnerable() && entity instanceof EntityLivingBase) {
            ezey._a(entity, pidb._e, 2.0f, true);
            if (entity instanceof EntityPlayer) {
                gloomyfolken.mods.anomaly.ezey._a((EntityPlayer)((EntityPlayer)entity))._c = true;
            }
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new qlvd();
    }
}

