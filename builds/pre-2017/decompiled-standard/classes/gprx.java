/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.entity.Entity;

public class gprx
extends twgu
implements stgn {
    public gprx(int n) {
        super(n, tflj._d);
        this.func_71864_b("camp_fire");
        LanguageRegistry.addName(this, "\u041a\u043e\u0441\u0442\u0435\u0440");
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new maao();
    }

    @Override
    public int func_71857_b() {
        return -1;
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b("stalker:transparent");
    }

    @Override
    public void func_71891_b(ozlu ozlu2, int n, int n2, int n3, Entity entity) {
        entity.func_70015_d(10);
    }

    @Override
    public int getLightValue(sdrg sdrg2, int n, int n2, int n3) {
        return 15;
    }
}

