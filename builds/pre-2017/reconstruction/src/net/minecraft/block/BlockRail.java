/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRailBase;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockRail
extends BlockRailBase {
    public Icon _a;

    public BlockRail(int n) {
        super(n, false);
    }

    @Override
    public Icon getIcon(int n, int n2) {
        if (n2 >= 6) {
            return this._a;
        }
        return this.blockIcon;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        super.registerIcons(iconRegister);
        this._a = iconRegister._b(this.getTextureName() + "_turned");
    }

    @Override
    public void _a(World world, int n, int n2, int n3, int n4, int n5, int n6) {
        if (n6 > 0 && Block.blocksList[n6].canProvidePower() && new hcdc(this, world, n, n2, n3)._b() == 3) {
            this._a(world, n, n2, n3, false);
        }
    }
}

