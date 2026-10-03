/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.misc.jgro;
import gloomyfolken.mods.core.misc.kjwj;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class sbvk
extends kjwj {
    private String _j;
    public xafi _b;
    public int _c;
    public int _d;
    public float _e;
    public boolean _f;
    public int _g = 0;
    public float _h = 0.0f;
    public int _i = 0;

    public sbvk(int n, String string, String string2, List<String> list2, int n2, String string3, float f, int n3, int n4, xafi xafi2, boolean bl, int n5, float f2, int n6) {
        super(n, string, "stalker:" + string2, list2, n2);
        if (!string3.isEmpty()) {
            this._j = "stalker:" + string3.substring(0, string3.lastIndexOf("."));
        }
        this._e = f;
        this._d = n3;
        this._c = n4;
        this._b = xafi2;
        this._f = bl;
        this._g = n5;
        this._h = f2;
        this._i = n6;
    }

    @Override
    public void _a(ItemStack itemStack, EntityPlayer entityPlayer, List<String> list2) {
        if (!this._f) {
            if (this._i > 0) {
                list2.add((Object)((Object)EnumChatFormatting._o) + "\u041a\u0430\u043b\u043e\u0440\u0438\u0439\u043d\u043e\u0441\u0442\u044c: " + this._i + " \u043a\u043a\u0430\u043b");
            }
            if (this._e > 0.0f) {
                list2.add((Object)((Object)EnumChatFormatting._c) + "\u041c\u0433\u043d\u043e\u0432\u0435\u043d\u043d\u043e\u0435 \u043b\u0435\u0447\u0435\u043d\u0438\u0435: " + jgro._f(this._e));
            }
            if (this._c > 0) {
                list2.add((Object)((Object)EnumChatFormatting._c) + "\u0412\u0440\u0435\u043c\u044f \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u044f: " + (int)Math.ceil((float)this._c / 20.0f) + " \u0441\u0435\u043a.");
            }
            list2.addAll(this._b._a());
        }
    }

    public boolean _a() {
        return this._g > 0 || this._h > 0.0f;
    }
}

