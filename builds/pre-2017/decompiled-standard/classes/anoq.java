/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.misc.vjta;
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import gloomyfolken.mods.effects.client.mcsa.kjui;
import java.util.function.Predicate;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.amxi;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

public class anoq
extends hbcv {
    public static amxi _i = new amxi();
    public final anpy _j;
    public final boolean _k;
    public final boolean _l;
    public final boolean _m;
    public static final Predicate<String> _n = string -> !string.startsWith("fp_") && !string.startsWith("dist_");
    public static final Predicate<String> _o = string -> !string.startsWith("tp_") && !string.startsWith("dist_");
    public static final Predicate<String> _p = string -> string.startsWith("dist_");

    public static anoq _a(tgdv tgdv2) {
        return anoq._a(tgdv2.field_77779_bT);
    }

    public static anoq _a(int n) {
        return (anoq)_i._b(n);
    }

    public anoq(String string, String string2, String string3, anpy anpy2, boolean bl, boolean bl2, boolean bl3) {
        super(string, string2, string3);
        this._j = anpy2;
        this._k = bl;
        this._l = bl2;
        this._m = bl3;
    }

    protected kjui _f(cvzo cvzo2) {
        tgdv tgdv2 = cvzo2._a();
        String string = null;
        if (tgdv2 instanceof vjta) {
            string = ((vjta)((Object)tgdv2))._i_(cvzo2);
        }
        return this._a(string);
    }

    @Override
    protected void _a(cvzo cvzo2, EntityItem entityItem) {
        xqrn xqrn2;
        ezfc._a(this._j._e);
        ezfc._b(this._j._f);
        ezfc._c(this._j._i);
        ogej ogej2 = null;
        if (this._k && (xqrn2 = xqrn._a(entityItem)) != null) {
            ogej2 = xqrn2._b;
        }
        this._a(cvzo2, ogej2, IItemRenderer.ItemRenderType.ENTITY);
    }

    @Override
    protected void _a(cvzo cvzo2) {
        ezfc._a(this._j._a);
        ezfc._b(this._j._b);
        ezfc._c(this._j._g);
        this._a(cvzo2, null, IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON);
    }

    @Override
    protected void _b(cvzo cvzo2, EntityLivingBase entityLivingBase) {
        ezfc._a(this._j._c);
        ezfc._b(this._j._d);
        ezfc._c(this._j._h);
        this._a(cvzo2, null, IItemRenderer.ItemRenderType.EQUIPPED);
    }

    protected void _a(cvzo cvzo2, cucv cucv2, IItemRenderer.ItemRenderType itemRenderType) {
        this._f((cvzo)cvzo2)._c.renderOnly(this._a(itemRenderType == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON), cucv2);
    }

    private Predicate<String> _a(boolean bl) {
        int n = MinecraftForgeClient.getRenderPass();
        if (n == 2) {
            return _p;
        }
        return bl ? _o : _n;
    }

    @Override
    public boolean _a(cvzo cvzo2, int n) {
        return n == 0 || n == 2 && this._m;
    }
}

