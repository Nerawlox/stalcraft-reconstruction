/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.ResourceLocation;

public abstract class htys {
    public cekh field_76898_b;

    public abstract void func_76894_a(hurg var1, double var2, double var4, double var6, float var8);

    public void func_110628_a(ResourceLocation resourceLocation) {
        apbu apbu2 = this.field_76898_b._g;
        if (apbu2 != null) {
            apbu2._a(resourceLocation);
        }
    }

    public void func_76893_a(cekh cekh2) {
        this.field_76898_b = cekh2;
    }

    public void func_76896_a(ozlu ozlu2) {
    }

    public qncw func_76895_b() {
        return this.field_76898_b._a();
    }
}

