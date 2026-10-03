/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Sets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class ezfc {
    public final kjui _a;
    public qoac _b;
    public long _c;

    public ezfc(kjui kjui2, qoac qoac2) {
        this(kjui2, qoac2, LocalDateTime.now(ZoneId.of("UTC")).toEpochSecond(ZoneOffset.UTC));
    }

    public ezfc(kjui kjui2, qoac qoac2, long l) {
        this._a = kjui2;
        this._b = qoac2;
        this._c = l;
    }

    public kjui _a() {
        return this._a;
    }

    public long _b() {
        return this._c;
    }

    public LocalDateTime _c() {
        return LocalDateTime.ofEpochSecond(this._c, 0, ZoneOffset.UTC).atZone(ZoneId.of("UTC")).withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime();
    }

    public String _d() {
        return this._a._a(this._b);
    }

    public static enum kjui {
        _a{

            @Override
            String _a(qoac qoac2) {
                return String.format("%s \u0432\u0441\u0442\u0443\u043f\u0438\u043b \u0432 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0443 \u043f\u043e \u043f\u0440\u0438\u0433\u043b\u0430\u0448\u0435\u043d\u0438\u044e %s", qoac2._j("invitee"), qoac2._j("inviter"));
            }
        }
        ,
        _b{

            @Override
            String _a(qoac qoac2) {
                return String.format("%s \u0431\u044b\u043b \u0438\u0441\u043a\u043b\u044e\u0447\u0435\u043d \u0438\u0437 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438 \u0438\u0433\u0440\u043e\u043a\u043e\u043c %s", qoac2._j("player"), qoac2._j("kicker"));
            }
        }
        ,
        _c{

            @Override
            String _a(qoac qoac2) {
                return String.format("%s \u043f\u0440\u0438\u0441\u0432\u043e\u0438\u043b %s \u0437\u0432\u0430\u043d\u0438\u0435 %s", qoac2._j("initiator"), qoac2._j("player"), vjsq.values()[qoac2._f((String)"rank")]._e);
            }
        }
        ,
        _d{

            @Override
            String _a(qoac qoac2) {
                String string = qoac2._j("player");
                int n = qoac2._f("points");
                if (n >= 0) {
                    return string + " \u0437\u0430\u0440\u0430\u0431\u043e\u0442\u0430\u043b " + n + " \u041e\u0420";
                }
                return string + " \u043f\u043e\u0442\u0435\u0440\u044f\u043b " + n + " \u041e\u0420";
            }

            @Override
            public boolean _a(ezfc ezfc2, ezfc ezfc3) {
                return Objects.equals(ezfc2._b._j("player"), ezfc3._b._j("player"));
            }

            @Override
            public ezfc _b(ezfc ezfc2, ezfc ezfc3) {
                int n = ezfc2._b._f("points") + ezfc3._b._f("points");
                return new ezfc(_d, new dwly("player", ezfc2._b._j("player"), "points", n)._a(), Math.max(ezfc2._c, ezfc3._c));
            }
        }
        ,
        _e{

            @Override
            String _a(qoac qoac2) {
                return String.format("%s \u043d\u0430\u0447\u0438\u0441\u043b\u0438\u043b %s %d \u043e\u0447\u043a\u043e\u0432 \u043b\u043e\u044f\u043b\u044c\u043d\u043e\u0441\u0442\u0438", qoac2._j("initiator"), qoac2._j("player"), qoac2._f("points"));
            }

            @Override
            public boolean _a(ezfc ezfc2, ezfc ezfc3) {
                boolean bl = Objects.equals(ezfc2._b._j("initiator"), ezfc3._b._j("initiator"));
                boolean bl2 = Objects.equals(ezfc2._b._j("player"), ezfc3._b._j("player"));
                return bl && bl2;
            }

            @Override
            public ezfc _b(ezfc ezfc2, ezfc ezfc3) {
                qoac qoac2 = ezfc2._b;
                int n = qoac2._f("points") + ezfc3._b._f("points");
                String string = qoac2._j("initiator");
                String string2 = qoac2._j("player");
                return new ezfc(_e, new dwly("initiator", string, "player", string2, "points", n)._a(), Math.max(ezfc2._c, ezfc3._c));
            }
        }
        ,
        _f{

            @Override
            String _a(qoac qoac2) {
                String string = qoac2._o("captured") ? "\u0437\u0430\u0445\u0432\u0430\u0442\u0438\u043b\u0430" : "\u043f\u043e\u0442\u0435\u0440\u044f\u043b\u0430";
                return String.format("\u0413\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0430 %s \u0431\u0430\u0437\u0443 \"%s\"", string, qoac2._j("flag"));
            }
        }
        ,
        _g{

            @Override
            String _a(qoac qoac2) {
                String string = qoac2._j("battle");
                if (qoac2._o("captured")) {
                    return String.format("\u0412\u0430\u0448\u0430 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0430 \u0437\u0430\u0445\u0432\u0430\u0442\u0438\u043b\u0430 \u043b\u043e\u043a\u0430\u0446\u0438\u044e \"%s\"", string);
                }
                return String.format("\u0412\u0430\u0448\u0430 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0430 \u043f\u043e\u0442\u0435\u0440\u043f\u0435\u043b\u0430 \u043f\u043e\u0440\u0430\u0436\u0435\u043d\u0438\u0435 \u0432 \u0437\u0430\u0445\u0432\u0430\u0442\u0435 \u043b\u043e\u043a\u0430\u0446\u0438\u0438 \"%s\"", string);
            }
        }
        ,
        _h{

            @Override
            String _a(qoac qoac2) {
                List<String> list = wnbr._a(qoac2._n("players"));
                if (list.size() == 0) {
                    return "";
                }
                String string = qoac2._j("initiator");
                boolean bl = qoac2._o("access");
                if (list.size() == 1) {
                    if (bl) {
                        return String.format("%s \u0434\u043e\u043f\u0443\u0441\u0442\u0438\u043b %s \u043a \u0437\u0430\u0445\u0432\u0430\u0442\u0443", string, list.get(0));
                    }
                    return String.format("%s \u043e\u0442\u0441\u0442\u0440\u0430\u043d\u0438\u043b %s \u043e\u0442 \u0437\u0430\u0445\u0432\u0430\u0442\u0430", string, list.get(0));
                }
                if (bl) {
                    return String.format("%s \u0434\u043e\u043f\u0443\u0441\u0442\u0438\u043b %d \u0438\u0433\u0440\u043e\u043a\u043e\u0432 \u043a \u0437\u0430\u0445\u0432\u0430\u0442\u0443: %s", string, list.size(), String.join((CharSequence)", ", list));
                }
                return String.format("%s \u043e\u0442\u0441\u0442\u0440\u0430\u043d\u0438\u043b %d \u0438\u0433\u0440\u043e\u043a\u043e\u0432 \u043e\u0442 \u0437\u0430\u0445\u0432\u0430\u0442\u0430: %s", string, list.size(), String.join((CharSequence)", ", list));
            }

            @Override
            public boolean _a(ezfc ezfc2, ezfc ezfc3) {
                boolean bl = Objects.equals(ezfc2._b._j("initiator"), ezfc3._b._j("initiator"));
                boolean bl2 = ezfc2._b._o("access") == ezfc3._b._o("access");
                return bl && bl2;
            }

            @Override
            public ezfc _b(ezfc ezfc2, ezfc ezfc3) {
                String string = ezfc2._b._j("initiator");
                boolean bl = ezfc2._b._o("access");
                List<String> list = wnbr._a(ezfc2._b._n("players"));
                List<String> list2 = wnbr._a(ezfc3._b._n("players"));
                ArrayList<String> arrayList = new ArrayList<String>(Sets.union(new HashSet<String>(list), new HashSet<String>(list2)));
                return new ezfc(_h, new dwly("initiator", string, "access", bl, "players", wnbr._a(arrayList))._a(), Math.max(ezfc2._c, ezfc3._c));
            }
        }
        ,
        _i{

            @Override
            String _a(qoac qoac2) {
                return String.format("%s \u043e\u0442\u0440\u0435\u0434\u0430\u043a\u0442\u0438\u0440\u043e\u0432\u0430\u043b \u043f\u0440\u0430\u0432\u0438\u043b\u0430 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438", qoac2._j("player"));
            }
        };


        abstract String _a(qoac var1);

        public boolean _a(ezfc ezfc2, ezfc ezfc3) {
            return false;
        }

        public ezfc _b(ezfc ezfc2, ezfc ezfc3) {
            return null;
        }
    }
}

