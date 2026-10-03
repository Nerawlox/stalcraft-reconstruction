/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.EntityLivingBase;
import noppes.npcs.CustomItems;
import noppes.npcs.CustomNpcs;
import noppes.npcs.items.EnumNpcToolMaterial;
import noppes.npcs.items.ItemRenderInterface;
import org.lwjgl.opengl.GL11;

public class ItemNpcInterface
extends tgdv
implements ItemRenderInterface {
    public EnumNpcToolMaterial toolMaterial;

    public ItemNpcInterface(int n) {
        super(n - 26700 + CustomNpcs.ItemStartId);
        this.func_77637_a(CustomItems.tab);
        CustomNpcs.proxy.registerItem(this.field_77779_bT);
    }

    @Override
    public void renderSpecial() {
        GL11.glScalef(0.66f, 0.66f, 0.66f);
        GL11.glTranslatef(0.0f, 0.3f, 0.0f);
    }

    @Override
    public int func_77619_b() {
        return super.func_77619_b();
    }

    @Override
    public tgdv func_77655_b(String string) {
        GameRegistry.registerItem(this, string);
        return super.func_77655_b(string);
    }

    @Override
    public boolean func_77644_a(cvzo cvzo2, EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        if (entityLivingBase.func_110143_aJ() <= 0.0f) {
            return false;
        }
        cvzo2._a(1, entityLivingBase2);
        return true;
    }
}

