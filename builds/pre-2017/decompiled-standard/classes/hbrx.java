/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.mods.core.main.GloomyCore;
import java.util.ArrayList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.eidj;
import net.minecraft.util.sajh;

public class hbrx
extends twgu
implements stgn {
    public hbrx(int n) {
        super(n, new tflj(iwnw._h)._p()._o());
        this.func_71849_a(GloomyCore.tab);
        this.func_71864_b("StalkerMachineGun");
        LanguageRegistry.addName(this, "\u041f\u0443\u043b\u0435\u043c\u0435\u0442");
        this.func_71848_c(3.0f);
        this.func_71905_a(0.25f, 0.0f, 0.25f, 0.75f, 0.6f, 0.75f);
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    @Override
    public boolean func_71924_d(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return false;
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
    public hurg func_72274_a(ozlu ozlu2) {
        return new zgge();
    }

    @Override
    public ArrayList<cvzo> getBlockDropped(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        return new ArrayList<cvzo>();
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        if (entityLivingBase == null) {
            return;
        }
        int n4 = sajh._c((double)(entityLivingBase.field_70177_z * 4.0f / 360.0f) + 0.5) & 3;
        ozlu2.func_72921_c(n, n2, n3, n4, 3);
    }
}

