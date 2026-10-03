/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.main.ClientProxy;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.util.ofbx;

public class broz
extends iekw {
    private int _a;

    public broz(ozlu ozlu2, Entity entity, boolean bl, int n, ofbx ofbx2, ofbx ofbx3) {
        super(ozlu2, entity);
        this.setCenter(ofbx3._c, ofbx3._d, ofbx3._e);
        this.setSize(2.0, 3.0, 3.0);
        ofbx ofbx4 = ofbx3._a(ofbx2)._a();
        for (int i = 0; i < (bl ? 3 : 5); ++i) {
            float f = bl ? 0.05f : 0.1f;
            float f2 = bl ? 0.15f : 0.05f;
            float f3 = (float)ofbx4._c * f + (ozlu2.field_73012_v.nextFloat() - 0.5f) * f2;
            float f4 = (float)ofbx4._d * f + (ozlu2.field_73012_v.nextFloat() - 0.5f) * f2;
            float f5 = (float)ofbx4._e * f + (ozlu2.field_73012_v.nextFloat() - 0.5f) * f2;
            switch (n) {
                case 0: 
                case 1: {
                    f3 *= -1.0f;
                    f5 *= -1.0f;
                    break;
                }
                case 2: 
                case 3: {
                    f3 *= -1.0f;
                    f4 *= -1.0f;
                    break;
                }
                case 4: 
                case 5: {
                    f4 *= -1.0f;
                    f5 *= -1.0f;
                }
            }
            ejcz ejcz2 = bl ? wojt._a : wojt._b;
            float f6 = bl ? 0.75f : 0.5f;
            float f7 = bl ? 0.8f : 0.3f;
            this.particles.add(new aolv(this, ejcz2, f6, false, f7, f3, f4, f5));
        }
    }

    @Override
    public void tick() {
        super.tick();
        ++this._a;
        this.renderDistanceSq = ClientProxy.particleRenderDistance.value * ClientProxy.particleRenderDistance.value;
    }

    @Override
    public boolean isValid() {
        return xpzm._E()._r != null && this._a <= 10;
    }

    @Override
    public boolean ignoreFrustrumTickCheck() {
        return true;
    }
}

