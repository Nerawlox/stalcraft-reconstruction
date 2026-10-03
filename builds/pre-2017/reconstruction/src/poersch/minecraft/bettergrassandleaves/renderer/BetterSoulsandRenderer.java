/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.entity.EntityRisingSoulFX;
import poersch.minecraft.bettergrassandleaves.interfaces.IBetterSoulsand;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;

public class BetterSoulsandRenderer
extends BlockRenderer
implements IBetterSoulsand {
    public static Icon[] iconRisingSoul;
    public static Icon[] iconSoulTrack;

    @Override
    public void onRegisterIcons(IconRegister iconRegister) {
        iconRisingSoul = BetterSoulsandRenderer.registerBlockIcons("rising_soul");
        iconSoulTrack = BetterSoulsandRenderer.registerBlockIcons("soul_track");
    }

    @Override
    public boolean onRandomDisplayTick(Block block, World world, int n, int n2, int n3, Random random) {
        if (world.provider._i == -1 && world.isAirBlock(n, n2 + 1, n3)) {
            int n4 = world.getBlockMetadata(n, n2, n3);
            if (random.nextFloat() > 1.0f - 0.06f * ((Float)BetterGrassAndLeavesMod.soulsFXSpawnRate.value).floatValue()) {
                IBetterSoulsand iBetterSoulsand = block instanceof IBetterSoulsand ? (IBetterSoulsand)((Object)block) : this;
                Icon icon = iBetterSoulsand.getIconRisingSoul(n4, random.nextFloat());
                if (icon == null) {
                    return false;
                }
                double d = (double)n + 0.5;
                double d2 = (double)n2 + 0.5;
                double d3 = (double)n3 + 0.5;
                this.minecraft._w._a(new EntityRisingSoulFX(world, d, d2, d3, icon, iBetterSoulsand.getIconsSoulTrack(n4)));
            }
        }
        return false;
    }

    @Override
    public Icon getIconRisingSoul(int n, float f) {
        return iconRisingSoul == null ? null : iconRisingSoul[(int)(f * (float)(iconRisingSoul.length - 1) + 0.5f)];
    }

    @Override
    public Icon[] getIconsSoulTrack(int n) {
        return iconSoulTrack;
    }
}

