/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.Icon;

public class cdjg
extends ItemBlock {
    public cdjg(int n) {
        super(n);
        this.setMaxDamage(0);
        this.setCreativeTab(GloomyCore.tab);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void registerIcons(IconRegister iconRegister) {
        this.itemIcon = iconRegister._b("stalker:machinegun");
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public Icon getIconFromDamage(int n) {
        return this.itemIcon;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public int getSpriteNumber() {
        return 1;
    }
}

