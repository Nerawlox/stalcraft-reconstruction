/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acf
 *  net.minecraftforge.fluids.BlockFluidBase
 *  net.minecraftforge.fluids.RenderBlockFluid
 */
package ru.stalcraft.client.render;

import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.RenderBlockFluid;

public class RenderBlockKissel
extends RenderBlockFluid {
    public static RenderBlockKissel instance = new RenderBlockKissel();

    public float getFluidHeightForRender(acf world, int x2, int y2, int z2, BlockFluidBase block) {
        return world.a(x2, y2 + 1, z2) == block.cF ? 1.0f : 0.1f;
    }
}

