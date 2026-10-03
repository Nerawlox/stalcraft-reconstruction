/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

@ezey(_a={eidj.CLIENT})
public interface kkll
extends IItemRenderer {
    default public void _a(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        GL11.glPushMatrix();
        ezfc._e();
        this.renderItem(IItemRenderer.ItemRenderType.EQUIPPED, itemStack, Minecraft._E()._s._s, entityLivingBase);
        GL11.glPopMatrix();
    }
}

