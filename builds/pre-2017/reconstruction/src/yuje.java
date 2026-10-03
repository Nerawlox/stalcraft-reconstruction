/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;

public class yuje
extends Item {
    public yuje(int n) {
        super(n - 256);
        this.setCreativeTab(GloomyCore.tab);
        this.setUnlocalizedName("empty_bottle");
        LanguageRegistry.addName(this, "\u0411\u0443\u0442\u044b\u043b\u043a\u0430");
    }

    public int _a(Entity entity) {
        return 2;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void registerIcons(IconRegister iconRegister) {
        this.itemIcon = iconRegister._b("stalker:empty_bottle");
    }
}

