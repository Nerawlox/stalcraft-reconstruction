/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.misc.vjta;
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import gloomyfolken.mods.effects.client.mcsa.kjui;
import java.util.function.Predicate;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IntHashMap;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

public class anoq
extends hbcv {
    public static IntHashMap _i = new IntHashMap();
    public final anpy _j;
    public final boolean _k;
    public final boolean _l;
    public final boolean _m;
    public static final Predicate<String> _n = string -> !string.startsWith("fp_") && !string.startsWith("dist_");
    public static final Predicate<String> _o = string -> !string.startsWith("tp_") && !string.startsWith("dist_");
    public static final Predicate<String> _p = string -> string.startsWith("dist_");

    public static anoq _a(Item item) {
        return anoq._a(item.itemID);
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

    protected kjui _f(ItemStack itemStack) {
        Item item = itemStack._a();
        String string = null;
        if (item instanceof vjta) {
            string = ((vjta)((Object)item))._i_(itemStack);
        }
        return this._a(string);
    }

    @Override
    protected void _a(ItemStack itemStack, EntityItem entityItem) {
        xqrn xqrn2;
        ezfc._a(this._j._e);
        ezfc._b(this._j._f);
        ezfc._c(this._j._i);
        ogej ogej2 = null;
        if (this._k && (xqrn2 = xqrn._a(entityItem)) != null) {
            ogej2 = xqrn2._b;
        }
        this._a(itemStack, ogej2, IItemRenderer.ItemRenderType.ENTITY);
    }

    @Override
    protected void _a(ItemStack itemStack) {
        ezfc._a(this._j._a);
        ezfc._b(this._j._b);
        ezfc._c(this._j._g);
        this._a(itemStack, null, IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON);
    }

    @Override
    protected void _b(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        ezfc._a(this._j._c);
        ezfc._b(this._j._d);
        ezfc._c(this._j._h);
        this._a(itemStack, null, IItemRenderer.ItemRenderType.EQUIPPED);
    }

    protected void _a(ItemStack itemStack, cucv cucv2, IItemRenderer.ItemRenderType itemRenderType) {
        this._f((ItemStack)itemStack)._c.renderOnly(this._a(itemRenderType == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON), cucv2);
    }

    private Predicate<String> _a(boolean bl) {
        int n = MinecraftForgeClient.getRenderPass();
        if (n == 2) {
            return _p;
        }
        return bl ? _o : _n;
    }

    @Override
    public boolean _a(ItemStack itemStack, int n) {
        return n == 0 || n == 2 && this._m;
    }
}

