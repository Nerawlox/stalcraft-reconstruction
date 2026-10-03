/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class dxvq
extends dxwc {
    public final String _h;
    public final float _i;
    public final float _j;
    public final float _k;
    public ResourceLocation _l;
    public klka _m;
    private boolean _o;
    public final boolean _n;

    public dxvq(int n, String string, String string2, List<String> list2, String string3, float f, float f2, float f3, boolean bl, boolean bl2) {
        super(n, string, string2, list2, dxwc.eidj._g);
        this._h = string3;
        this._i = f;
        this._j = f2;
        this._k = f3;
        this._o = bl;
        this._n = bl2;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void _c() {
        super._c();
        if (this._h != null) {
            this._l = new ResourceLocation("weapons", "textures/" + this._h);
            fmib._b(this._l);
        }
    }

    @Override
    public void _a(ItemStack itemStack, EntityPlayer entityPlayer, List<String> list2) {
        this._c(list2, String.format("\u0423\u0432\u0435\u043b\u0438\u0447\u0435\u043d\u0438\u0435: x%.2f", Float.valueOf(this._i)));
        super._a(itemStack, entityPlayer, list2);
    }

    @Override
    public boolean _a_(dxwc.pidb pidb2) {
        return pidb2 == dxwc.pidb._l || this._o;
    }
}

