/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.Icon;

public class qmdn
extends ItemBlock {
    public qmdn(int n) {
        super(n);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void registerIcons(IconRegister iconRegister) {
        this.itemIcon = iconRegister._b(this.iconString);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public Icon getIconFromDamage(int n) {
        return this.itemIcon;
    }

    @Override
    public int getSpriteNumber() {
        return 1;
    }
}

