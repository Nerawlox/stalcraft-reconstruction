/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Sets;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.bundle.common.core.InvokeWithResult;
import gloomyfolken.mods.core.entity.EntityAdvancedThrowable;
import gloomyfolken.mods.core.main.GloomyCore;
import java.util.List;
import java.util.Set;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;
import net.minecraft.util.ofbx;

public class yufe
extends twgu {
    public static final Set<Integer> _a = Sets.newHashSet(20, 101, 102, 79, 3520, 3523, 3522, 3518, 153);
    private dwan _b;

    public yufe(int n, tflj tflj2) {
        super(n, tflj2);
    }

    @Override
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b("stalker:impblock_inv");
        this._b = nege2._b("stalker:impblock_vis");
    }

    @Override
    public hank func_71878_a(ozlu ozlu2, int n, int n2, int n3, ofbx ofbx2, ofbx ofbx3) {
        if (this._a(ozlu2)) {
            return super.func_71878_a(ozlu2, n, n2, n3, ofbx2, ofbx3);
        }
        return null;
    }

    public boolean _a(ozlu ozlu2) {
        return ozlu2.field_72995_K && InvokeWithResult.client(() -> xpzm._E()._t.field_71075_bZ._d) != false;
    }

    @Override
    public void func_71871_a(ozlu ozlu2, int n, int n2, int n3, eidj eidj2, List list2, Entity entity) {
        if (!(entity instanceof EntityAdvancedThrowable)) {
            super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan func_71858_a(int n, int n2) {
        EntityClientPlayerMP entityClientPlayerMP = xpzm._E()._t;
        if (entityClientPlayerMP == null || !entityClientPlayerMP.field_71075_bZ._d) {
            return this.field_94336_cN;
        }
        return this._b;
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
    @SideOnly(value=Side.CLIENT)
    public int func_71856_s_() {
        return 1;
    }

    @Override
    public boolean canRenderInPass(int n) {
        return super.canRenderInPass(n) && this.func_71857_b() != -1;
    }

    @Override
    public int func_71857_b() {
        return GloomyCore.transparentsRenderType;
    }
}

