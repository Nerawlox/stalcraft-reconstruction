/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.core.main.GloomyCore;
import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.eidj;

public class oxgx
extends twgu
implements stgn {
    public oxgx(int n) {
        super(n, new tflj(iwnw._e)._p()._o());
        this.func_71864_b("block_flag");
        this.func_71849_a(GloomyCore.tab);
        this.func_71875_q();
        LanguageRegistry.addName(this, "\u0424\u043b\u0430\u0433");
        this.func_111022_d("stalker:transparent");
    }

    @Override
    public int func_71925_a(Random random) {
        return 0;
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        return null;
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        if (!ozlu2.field_72995_K) {
            InvokeSideOnly.frontend(() -> {});
        } else {
            ozlu2.func_94575_c(n, n2, n3, 0);
        }
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new fmle();
    }
}

