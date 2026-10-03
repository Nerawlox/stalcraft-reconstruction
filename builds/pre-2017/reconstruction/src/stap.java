/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.misc.jgro;
import gloomyfolken.mods.core.misc.kjwj;
import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class stap
extends kjwj {
    public final kjui _b;
    public final String _c;
    public final float _d;
    public final float _e;

    public stap(int n, String string, String string2, List<String> list2, int n2, kjui kjui2, float f, float f2) {
        super(n, string, "weapons:" + string2, list2, n2);
        this._c = string;
        this._b = kjui2;
        this._e = f;
        this._d = f2;
        this.setHasSubtypes(true);
    }

    @Override
    public void _a(ItemStack itemStack, EntityPlayer entityPlayer, List<String> list2) {
        if (itemStack._j() == 0) {
            this._a(list2, "\u041f\u0440\u0438 \u043d\u0435\u0443\u0434\u0430\u0447\u0435 \u0443\u0440\u043e\u0432\u0435\u043d\u044c \u043d\u0435 \u043f\u043e\u043d\u0438\u0436\u0430\u0435\u0442\u0441\u044f");
        } else {
            this._b(list2, "\u041f\u0440\u0438 \u043d\u0435\u0443\u0434\u0430\u0447\u0435 \u0443\u0440\u043e\u0432\u0435\u043d\u044c \u043f\u043e\u043d\u0438\u0436\u0430\u0435\u0442\u0441\u044f \u043d\u0430 " + itemStack._j());
        }
        jgro._a(list2, this._b._f, this._e);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void getSubItems(int n, CreativeTabs creativeTabs, List list2) {
        for (int i = 0; i < 3; ++i) {
            list2.add(new ItemStack(n, 1, i));
        }
    }

    public static enum kjui {
        _a("\u0423\u0440\u043e\u043d"),
        _b("\u0414\u0430\u043b\u044c\u043d\u043e\u0431\u043e\u0439\u043d\u043e\u0441\u0442\u044c"),
        _c("\u0422\u043e\u0447\u043d\u043e\u0441\u0442\u044c"),
        _d("\u041d\u0430\u0434\u0435\u0436\u043d\u043e\u0441\u0442\u044c"),
        _e("\u0423\u0434\u043e\u0431\u043d\u043e\u0441\u0442\u044c");

        public final String _f;

        private kjui(String string2) {
            this._f = string2;
        }
    }
}

