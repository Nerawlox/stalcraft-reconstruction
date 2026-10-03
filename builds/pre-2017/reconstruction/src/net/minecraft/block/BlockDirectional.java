/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public abstract class BlockDirectional
extends Block {
    public BlockDirectional(int n, Material material) {
        super(n, material);
    }

    public static int _d(int n) {
        return n & 3;
    }
}

