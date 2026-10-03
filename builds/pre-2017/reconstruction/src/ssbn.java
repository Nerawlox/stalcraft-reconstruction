/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;

public class ssbn
extends ModelBase {
    public ModelRenderer _a = new ModelRenderer(this, 40, 16);
    public ModelRenderer _b;

    public ssbn() {
        this._a.addBox(0.0f, 0.0f, 0.0f, 4, 12, 4);
        this._b = new ModelRenderer(this, 40, 16);
        this._b.mirror = true;
        this._b.addBox(0.0f, 0.0f, 0.0f, 4, 12, 4);
    }

    public void _a(AbstractClientPlayer abstractClientPlayer, int n) {
        TextureManager textureManager = Minecraft._E()._h;
        textureManager._a(abstractClientPlayer.getLocationSkin());
        super.render(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        if ((float)n == 2.0f) {
            this._a.render(0.0625f);
        }
        if ((float)n == 1.0f) {
            this._b.render(0.0625f);
        }
    }

    private void _a(ModelRenderer modelRenderer, float f, float f2, float f3) {
        modelRenderer.rotateAngleX = f;
        modelRenderer.rotateAngleY = f2;
        modelRenderer.rotateAngleZ = f3;
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        super.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
    }
}

