/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.trade;

import gloomyfolken.mods.core.client.gui.engine.Point;
import java.util.concurrent.TimeUnit;

public class zwaw
extends iuww {
    public zwaw() {
        super("\u0422\u043e\u0440\u0433\u043e\u0432\u043b\u044f", "trade", TimeUnit.MINUTES.toMillis(1L));
    }

    @Override
    public String getInfoText(bqdo bqdo2) {
        qoac qoac2 = bqdo2._d();
        switch (qoac2._j("type")) {
            case "request": {
                return String.format("\u0418\u0433\u0440\u043e\u043a %s \u043f\u0440\u0435\u0434\u043b\u0430\u0433\u0430\u0435\u0442 \u0432\u0430\u043c \u043e\u0431\u043c\u0435\u043d", qoac2._j("Author"));
            }
            case "completed": {
                return "\u041e\u0431\u043c\u0435\u043d \u0443\u0441\u043f\u0435\u0448\u043d\u043e \u0437\u0430\u0432\u0435\u0440\u0448\u0435\u043d";
            }
        }
        return null;
    }

    @Override
    public Point getIcon(bqdo bqdo2) {
        return bqdo2._d()._j("type").equals("completed") ? new Point(48, 48) : new Point(0, 48);
    }

    @Override
    public iuww.kjui getViewType(bqdo bqdo2) {
        return bqdo2._d()._j("type").equals("request") ? iuww.kjui._a : iuww.kjui._c;
    }

    @Override
    public void onAction(bqdo bqdo2, boolean bl) {
        qoac qoac2 = bqdo2._d();
        if (qoac2._j("type").equals("request")) {
            new jibv(bl).sendToServer();
        }
    }
}

