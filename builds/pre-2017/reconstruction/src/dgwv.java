/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.IBlockAccess;

public class dgwv
extends Block {
    public boolean _a;
    public String _b;

    public dgwv(int n, String string, Material material, boolean bl) {
        super(n, material);
        this._a = bl;
        this._b = string;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        int n5 = iBlockAccess.getBlockId(n, n2, n3);
        if (!this._a && n5 == this.blockID) {
            return false;
        }
        return super.shouldSideBeRendered(iBlockAccess, n, n2, n3, n4);
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b(this._b);
    }
}

