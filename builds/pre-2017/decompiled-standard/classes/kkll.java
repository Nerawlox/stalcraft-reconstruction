/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import net.minecraft.client.xpzm;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

@ezey(_a={eidj.CLIENT})
public interface kkll
extends IItemRenderer {
    default public void _a(cvzo cvzo2, EntityLivingBase entityLivingBase) {
        GL11.glPushMatrix();
        ezfc._e();
        this.renderItem(IItemRenderer.ItemRenderType.EQUIPPED, cvzo2, xpzm._E()._s._s, entityLivingBase);
        GL11.glPopMatrix();
    }
}

