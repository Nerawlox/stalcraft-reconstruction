/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;

public class yduo
extends uznj {
    public yduo(int n) {
        super(n, Material._b);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public int getRenderType() {
        return 31;
    }

    @Override
    public Icon _a(int n) {
        return this.blockIcon;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this._d = iconRegister._b(this.getTextureName() + "_top");
        this.blockIcon = iconRegister._b(this.getTextureName() + "_side");
    }
}

