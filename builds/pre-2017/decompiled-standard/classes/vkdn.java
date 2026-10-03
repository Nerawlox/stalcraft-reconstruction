/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.mods.core.main.GloomyCore;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.util.eidj;

public class vkdn
extends twgu
implements flxv {
    public vkdn(int n) {
        super(n, tflj._a);
        this.func_71875_q();
        this.func_71905_a(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.func_71864_b("anomaly_upper_neighbor");
        LanguageRegistry.addName(this, "Anomaly upper neighbor");
        GloomyCore.instance.airBlocks.add(this.field_71990_ca);
    }

    @Override
    public void func_71869_a(ozlu ozlu2, int n, int n2, int n3, Entity entity) {
        for (int i = n2; i >= 0; --i) {
            int n4 = ozlu2.func_72798_a(n, i, n3);
            if (zwpb._a(n4)) {
                twgu.field_71973_m[n4].func_71869_a(ozlu2, n, i, n3, entity);
                continue;
            }
            if (n4 != this.field_71990_ca) break;
        }
    }

    @Override
    public int func_71857_b() {
        return -1;
    }

    @Override
    public int func_71925_a(Random random) {
        return 0;
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3) {
        for (int i = n2; i >= 0; --i) {
            int n4 = ozlu2.func_72798_a(n, i, n3);
            if (zwpb._a(n4)) {
                return;
            }
            if (n4 != this.field_71990_ca) break;
        }
        ozlu2.func_94575_c(n, n2, n3, 0);
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        return null;
    }

    @Override
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b("stalker:transparent");
    }

    @Override
    public boolean isAirBlock(ozlu ozlu2, int n, int n2, int n3) {
        return true;
    }
}

