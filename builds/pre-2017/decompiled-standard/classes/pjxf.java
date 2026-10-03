/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.misc.jgro;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;

public class pjxf
extends dxwc {
    public final int _h;
    public final float _i;

    public pjxf(int n, String string, String string2, List<String> list, int n2, float f) {
        super(n, string, string2, list, dxwc.eidj._i);
        this._h = n2;
        this._i = f;
    }

    @Override
    public void _a(cvzo cvzo2, EntityPlayer entityPlayer, List<String> list) {
        this._c(list, "\u0420\u0430\u0437\u043c\u0435\u0440 \u043c\u0430\u0433\u0430\u0437\u0438\u043d\u0430: " + this._h);
        this._c(list, "\u0417\u0430\u043a\u043b\u0438\u043d\u0438\u0432\u0430\u043d\u0438\u0435: " + jgro._j(this._i));
        super._a(cvzo2, entityPlayer, list);
    }
}

