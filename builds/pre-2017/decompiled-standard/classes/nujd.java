/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.misc.kjwj;
import java.util.List;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;

public class nujd
extends kjwj {
    public final kjui _b;
    public final float _c;
    public final float _d;

    public nujd(int n, String string, String string2, List<String> list, kjui kjui2, float f, float f2) {
        super(n, string, "stalker:" + string2, list, 1);
        this._b = kjui2;
        this._c = f;
        this._d = f2;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        if (ozlu2.field_72995_K) {
            this._a();
        }
        return cvzo2;
    }

    @Override
    public void _a(cvzo cvzo2, EntityPlayer entityPlayer, List<String> list) {
        list.add("\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u0443\u0439\u0442\u0435 \u0440\u0435\u043c\u043a\u043e\u043c\u043f\u043b\u0435\u043a\u0442, \u0447\u0442\u043e\u0431\u044b \u043f\u043e\u0447\u0438\u043d\u0438\u0442\u044c \u043f\u0440\u0435\u0434\u043c\u0435\u0442.");
    }

    @ezey(_a={eidj.CLIENT})
    private void _a() {
        xpzm._E()._a(new dgki(this));
    }

    public boolean _b(cvzo cvzo2) {
        return this._b._a(cvzo2);
    }

    public static enum kjui {
        _a{

            @Override
            public boolean _a(cvzo cvzo2) {
                return cvzo2._a() instanceof wolf;
            }
        }
        ,
        _b{

            @Override
            public boolean _a(cvzo cvzo2) {
                return cvzo2._a() instanceof dgmz;
            }
        }
        ,
        _c{

            @Override
            public boolean _a(cvzo cvzo2) {
                return cvzo2._a() instanceof brhe;
            }
        };


        public abstract boolean _a(cvzo var1);
    }
}

