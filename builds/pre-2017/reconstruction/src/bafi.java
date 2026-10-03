/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class bafi
extends Item {
    public final klcb _a;
    private String _b;

    public bafi(int n, String string, String string2, klcb klcb2) {
        super(n - 256);
        this._a = klcb2;
        this._b = string;
        this.setCreativeTab(GloomyCore.tab);
        this.setUnlocalizedName(string);
        LanguageRegistry.addName(this, string2);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void registerIcons(IconRegister iconRegister) {
        this.itemIcon = iconRegister._b("stalker:" + this._b);
    }
}

