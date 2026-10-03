/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Point;

public class srtb
extends iuww {
    public srtb() {
        super("\u041f\u043e\u0447\u0442\u0430", "mail");
    }

    @Override
    public String getInfoText(bqdo bqdo2) {
        return String.format("\u041d\u043e\u0432\u043e\u0435 \u043f\u0438\u0441\u044c\u043c\u043e \u043e\u0442 %s", bqdo2._d()._j("Author"));
    }

    @Override
    public Point getIcon(bqdo bqdo2) {
        return new Point(144, 0);
    }

    @Override
    public iuww.kjui getViewType(bqdo bqdo2) {
        return iuww.kjui._c;
    }

    @Override
    public void onAction(bqdo bqdo2, boolean bl) {
    }
}

