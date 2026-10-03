/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.misc.amxi;
import gloomyfolken.mods.core.misc.ezfa;
import gloomyfolken.mods.core.misc.jgro;
import gloomyfolken.mods.core.misc.kjui;
import gloomyfolken.mods.core.misc.kjwj;
import gloomyfolken.mods.core.misc.srli;
import gloomyfolken.mods.core.misc.tdmn;
import java.util.List;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class cdit
extends kjwj
implements aofo,
amxi,
ezfa,
srli,
tdmn {
    public final xafi _b;
    private boolean _f;
    public final float _c;
    public final float _d;
    public String _e = null;
    private static final xafi _g = new xafi();

    public cdit(int n, String string, String string2, List<String> list2, int n2, xafi xafi2, boolean bl, float f, float f2, String string3) {
        super(n, string, "stalker:" + string2, list2, n2);
        this._f = bl;
        this._b = xafi2;
        this._c = f;
        this._d = f2;
        this._e = string3;
    }

    @Override
    public void _a(ItemStack itemStack, EntityPlayer entityPlayer, List<String> list2) {
        if (!this._f) {
            this._c(list2, "\u041f\u043e\u0432\u0440\u0435\u0436\u0434\u0435\u043d\u0438\u0435: " + jgro._h(this._c) + " \u0435\u0434/\u043c\u0438\u043d");
            if (this._a(itemStack)) {
                float f = this._e(itemStack);
                jgro._a(list2, "\u041a\u0430\u0447\u0435\u0441\u0442\u0432\u043e", jgro._a(f));
                list2.addAll(this._a(f)._a());
            } else {
                list2.add((Object)((Object)EnumChatFormatting._o) + "\u041d\u0435 \u0438\u0441\u0441\u043b\u0435\u0434\u043e\u0432\u0430\u043d\u043e");
            }
        }
    }

    @Override
    public ItemStack _g() {
        ItemStack itemStack = new ItemStack(this);
        ncwh._b(itemStack)._a("stats_random", 0.0f);
        return itemStack;
    }

    @Override
    public int getEntityLifespan(ItemStack itemStack, World world) {
        return 72000;
    }

    @Override
    public int getColorFromItemStack(ItemStack itemStack, int n) {
        return this._a(itemStack) ? 0xFFFFFF : 0x555555;
    }

    @Override
    public xafi _g_(ItemStack itemStack) {
        if (this._a(itemStack)) {
            return this._a(this._e(itemStack));
        }
        return _g;
    }

    @Override
    public int getItemStackLimit(ItemStack itemStack) {
        return this._a(itemStack) ? 1 : super.getItemStackLimit(itemStack);
    }

    public xafi _a(float f) {
        xafi xafi2 = this._b._c();
        xafi2._f(f);
        return xafi2;
    }

    @Override
    public float _a() {
        return this._d;
    }

    @Override
    public kjui.kjui _c(ItemStack itemStack) {
        return this._a(itemStack) ? kjui.kjui._c : kjui.kjui._a;
    }

    @Override
    public int _a(ItemStack itemStack, int n) {
        return this._a(itemStack) ? (int)((float)n * this._e(itemStack)) : n;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public boolean _l_(ItemStack itemStack) {
        return anoq._a(itemStack._a()) != null;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public GuiScreen _a(GuiScreen guiScreen, EntityPlayer entityPlayer, ItemStack itemStack, int n) {
        anoq anoq2 = anoq._a(itemStack._a());
        return anoq2 == null ? null : new teuq(guiScreen, itemStack, anoq2);
    }
}

