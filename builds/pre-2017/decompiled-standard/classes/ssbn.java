/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;

public class ssbn
extends ModelBase {
    public ModelRenderer _a = new ModelRenderer(this, 40, 16);
    public ModelRenderer _b;

    public ssbn() {
        this._a.func_78789_a(0.0f, 0.0f, 0.0f, 4, 12, 4);
        this._b = new ModelRenderer(this, 40, 16);
        this._b.field_78809_i = true;
        this._b.func_78789_a(0.0f, 0.0f, 0.0f, 4, 12, 4);
    }

    public void _a(AbstractClientPlayer abstractClientPlayer, int n) {
        apbu apbu2 = xpzm._E()._h;
        apbu2._a(abstractClientPlayer.func_110306_p());
        super.func_78088_a(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        if ((float)n == 2.0f) {
            this._a.func_78785_a(0.0625f);
        }
        if ((float)n == 1.0f) {
            this._b.func_78785_a(0.0625f);
        }
    }

    private void _a(ModelRenderer modelRenderer, float f, float f2, float f3) {
        modelRenderer.field_78795_f = f;
        modelRenderer.field_78796_g = f2;
        modelRenderer.field_78808_h = f3;
    }

    @Override
    public void func_78087_a(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        super.func_78087_a(f, f2, f3, f4, f5, f6, entity);
    }
}

