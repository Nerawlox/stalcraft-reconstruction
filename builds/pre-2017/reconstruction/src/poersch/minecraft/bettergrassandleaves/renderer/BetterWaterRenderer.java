/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.entity.EntityWaterSuspendFX;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;

public class BetterWaterRenderer
extends BlockRenderer {
    public static Icon[] iconWaterSpray;
    public static Icon[] iconWaterSuspended;

    @Override
    public void onRegisterIcons(IconRegister iconRegister) {
        iconWaterSpray = BetterWaterRenderer.registerBlockIcons("water_spray");
        iconWaterSuspended = BetterWaterRenderer.registerBlockIcons("water_suspended");
    }

    @Override
    public boolean onSpawnParticle(String string, World world, double d, double d2, double d3, double d4, double d5, double d6, Entity entity) {
        if ((Integer)BetterGrassAndLeavesMod.waterSuspendedFX.value != 2) {
            return (Integer)BetterGrassAndLeavesMod.waterSuspendedFX.value == 0;
        }
        if (world.getBlockMaterial((int)d, (int)d2 + 1, (int)d3) == Material._h) {
            Icon icon = this.getIconWaterSuspended(0, (float)Math.random());
            if (icon == null) {
                return true;
            }
            this.minecraft._w._a(new EntityWaterSuspendFX(world, d + Math.random(), d2 + Math.random(), d3 + Math.random(), icon));
        }
        return true;
    }

    protected boolean nearShore(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        if (iBlockAccess.getBlockMaterial(n - 1, n2, n3) != Material._h) {
            return true;
        }
        if (iBlockAccess.getBlockMaterial(n + 1, n2, n3) != Material._h) {
            return true;
        }
        if (iBlockAccess.getBlockMaterial(n, n2, n3 - 1) != Material._h) {
            return true;
        }
        return iBlockAccess.getBlockMaterial(n, n2, n3 + 1) != Material._h;
    }

    public Icon getIconWaterSpray(int n, float f) {
        return iconWaterSpray == null ? null : iconWaterSpray[(int)(f * (float)(iconWaterSpray.length - 1) + 0.5f)];
    }

    public Icon getIconWaterSuspended(int n, float f) {
        return iconWaterSuspended == null ? null : iconWaterSuspended[(int)(f * (float)(iconWaterSuspended.length - 1) + 0.5f)];
    }
}

