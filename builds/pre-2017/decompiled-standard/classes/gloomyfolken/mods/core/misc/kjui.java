/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import gloomyfolken.mods.core.misc.pidb;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ezfc;

public abstract class kjui {
    public kjui getBindState(cvzo cvzo2, EntityPlayer entityPlayer, int n) {
        return kjui._a;
    }

    public boolean isInventoryPersonal(mssh mssh2) {
        return false;
    }

    public static enum kjui {
        _a(null, null),
        _b("no_drop", "\u041d\u0435\u0432\u044b\u043f\u0430\u0434\u0430\u044e\u0449\u0438\u0439 \u043f\u0440\u0435\u0434\u043c\u0435\u0442"),
        _c("personal_on_use", "\u041f\u0435\u0440\u0441\u043e\u043d\u0430\u043b\u044c\u043d\u044b\u0439 \u043f\u0440\u0438 \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0438"),
        _d("personal_on_get", "\u041f\u0435\u0440\u0441\u043e\u043d\u0430\u043b\u044c\u043d\u044b\u0439 \u043f\u0440\u0438 \u043f\u043e\u043b\u0443\u0447\u0435\u043d\u0438\u0438"),
        _e(null, "\u041f\u0435\u0440\u0441\u043e\u043d\u0430\u043b\u044c\u043d\u044b\u0439 \u043f\u0440\u0435\u0434\u043c\u0435\u0442"){

            @Override
            public String _a(cvzo cvzo2) {
                String string = pidb._e(cvzo2);
                return string == null ? this._i : (Object)((Object)ezfc._k) + "\u0412\u043b\u0430\u0434\u0435\u043b\u0435\u0446: " + string;
            }
        }
        ,
        _f(null, "\u0412\u0440\u0435\u043c\u0435\u043d\u043d\u043e \u043f\u0435\u0440\u0441\u043e\u043d\u0430\u043b\u044c\u043d\u044b\u0439"){

            @Override
            public String _a(cvzo cvzo2) {
                long l = pidb._c(cvzo2);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(_c._a(cvzo2)).append("\n");
                if (l > 0L && l > System.currentTimeMillis()) {
                    ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(l), ZoneOffset.UTC);
                    String string = bqgh._a.format(zonedDateTime);
                    stringBuilder.append((Object)ezfc._k).append("\u041d\u0435\u0434\u043e\u0441\u0442\u0443\u043f\u0435\u043d \u0434\u043b\u044f \u043e\u0431\u043c\u0435\u043d\u0430 \u0434\u043e ").append(string).append("\n");
                }
                stringBuilder.append(_e._a(cvzo2));
                return stringBuilder.toString();
            }
        };

        public static final kjui[] _g;
        public final String _h;
        public final String _i;

        private kjui(String string2, String string3) {
            this._h = string2;
            this._i = string3;
        }

        public String _a(cvzo cvzo2) {
            return this._i == null ? null : (Object)((Object)ezfc._k) + this._i;
        }

        static {
            _g = kjui.values();
        }
    }
}

