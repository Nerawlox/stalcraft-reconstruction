/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import java.util.List;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.jxsn;
import net.minecraft.util.ezfc;
import net.minecraft.util.tdpx;
import net.minecraft.util.turb;
import net.minecraft.util.ybzs;

public class zwat {
    public static final Gson _a = new GsonBuilder().registerTypeAdapter((Type)((Object)zwat.class), new ybzs()).create();
    public ezfc _b;
    public Boolean _c;
    public Boolean _d;
    public Boolean _e;
    public Boolean _f;
    public String _g;
    public String _h;
    public List _i;

    public zwat() {
    }

    public zwat(zwat zwat2) {
        this._b = zwat2._b;
        this._c = zwat2._c;
        this._d = zwat2._d;
        this._e = zwat2._e;
        this._f = zwat2._f;
        this._g = zwat2._g;
        this._h = zwat2._h;
        this._i = zwat2._i == null ? null : Lists.newArrayList(zwat2._i);
    }

    public zwat _a(ezfc ezfc2) {
        if (ezfc2 != null && !ezfc2._c()) {
            throw new IllegalArgumentException("Argument is not a valid color!");
        }
        this._b = ezfc2;
        return this;
    }

    public ezfc _a() {
        return this._b;
    }

    public zwat _a(Boolean bl) {
        this._c = bl;
        return this;
    }

    public Boolean _b() {
        return this._c;
    }

    public zwat _b(Boolean bl) {
        this._d = bl;
        return this;
    }

    public Boolean _c() {
        return this._d;
    }

    public zwat _c(Boolean bl) {
        this._e = bl;
        return this;
    }

    public Boolean _d() {
        return this._e;
    }

    public zwat _d(Boolean bl) {
        this._f = bl;
        return this;
    }

    public Boolean _e() {
        return this._f;
    }

    public String _f() {
        return this._g;
    }

    public String _g() {
        return this._h;
    }

    public List _h() {
        return this._i;
    }

    public zwat _a(zwat zwat2) {
        if (this._g != null || this._h != null) {
            this._i = Lists.newArrayList(new zwat(this), zwat2);
            this._g = null;
            this._h = null;
        } else if (this._i != null) {
            this._i.add(zwat2);
        } else {
            this._i = Lists.newArrayList(zwat2);
        }
        return this;
    }

    public zwat _a(String string) {
        if (this._g != null || this._h != null) {
            this._i = Lists.newArrayList(new zwat(this), zwat._d(string));
            this._g = null;
            this._h = null;
        } else if (this._i != null) {
            this._i.add(zwat._d(string));
        } else {
            this._g = string;
        }
        return this;
    }

    public zwat _b(String string) {
        if (this._g != null || this._h != null) {
            this._i = Lists.newArrayList(new zwat(this), zwat._e(string));
            this._g = null;
            this._h = null;
        } else if (this._i != null) {
            this._i.add(zwat._e(string));
        } else {
            this._h = string;
        }
        return this;
    }

    public zwat _a(String string, Object ... objectArray) {
        if (this._g != null || this._h != null) {
            this._i = Lists.newArrayList(new zwat(this), zwat._b(string, objectArray));
            this._g = null;
            this._h = null;
        } else if (this._i != null) {
            this._i.add(zwat._b(string, objectArray));
        } else {
            this._h = string;
            this._i = Lists.newArrayList();
            for (Object object : objectArray) {
                if (object instanceof zwat) {
                    this._i.add((zwat)object);
                    continue;
                }
                this._i.add(zwat._d(object.toString()));
            }
        }
        return this;
    }

    public String toString() {
        return this._a(false);
    }

    public String _a(boolean bl) {
        return this._a(bl, null, false, false, false, false);
    }

    public String _a(boolean bl, ezfc ezfc2, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        boolean bl6;
        StringBuilder stringBuilder = new StringBuilder();
        ezfc ezfc3 = this._b == null ? ezfc2 : this._b;
        boolean bl7 = this._c == null ? bl2 : this._c;
        boolean bl8 = this._d == null ? bl3 : this._d;
        boolean bl9 = this._e == null ? bl4 : this._e;
        boolean bl10 = bl6 = this._f == null ? bl5 : this._f;
        if (this._h != null) {
            if (bl) {
                zwat._a(stringBuilder, ezfc3, bl7, bl8, bl9, bl6);
            }
            if (this._i != null) {
                Object[] objectArray = new String[this._i.size()];
                for (int i = 0; i < this._i.size(); ++i) {
                    objectArray[i] = ((zwat)this._i.get(i))._a(bl, ezfc3, bl7, bl8, bl9, bl6);
                }
                stringBuilder.append(tdpx._a(this._h, objectArray));
            } else {
                stringBuilder.append(tdpx._a(this._h));
            }
        } else if (this._g != null) {
            if (bl) {
                zwat._a(stringBuilder, ezfc3, bl7, bl8, bl9, bl6);
            }
            stringBuilder.append(this._g);
        } else if (this._i != null) {
            for (zwat zwat2 : this._i) {
                if (bl) {
                    zwat._a(stringBuilder, ezfc3, bl7, bl8, bl9, bl6);
                }
                stringBuilder.append(zwat2._a(bl, ezfc3, bl7, bl8, bl9, bl6));
            }
        }
        return stringBuilder.toString();
    }

    public static void _a(StringBuilder stringBuilder, ezfc ezfc2, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (ezfc2 != null) {
            stringBuilder.append((Object)ezfc2);
        } else if (bl || bl2 || bl3 || bl4) {
            stringBuilder.append((Object)ezfc._v);
        }
        if (bl) {
            stringBuilder.append((Object)ezfc._r);
        }
        if (bl2) {
            stringBuilder.append((Object)ezfc._u);
        }
        if (bl3) {
            stringBuilder.append((Object)ezfc._t);
        }
        if (bl4) {
            stringBuilder.append((Object)ezfc._q);
        }
    }

    public static zwat _c(String string) {
        try {
            return _a.fromJson(string, zwat.class);
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.func_85055_a(throwable, "Deserializing Message");
            jxsn jxsn2 = crashReport.func_85058_a("Serialized Message");
            jxsn2._a("JSON string", string);
            throw new turb(crashReport);
        }
    }

    public static zwat _d(String string) {
        zwat zwat2 = new zwat();
        zwat2._a(string);
        return zwat2;
    }

    public static zwat _e(String string) {
        zwat zwat2 = new zwat();
        zwat2._b(string);
        return zwat2;
    }

    public static zwat _b(String string, Object ... objectArray) {
        zwat zwat2 = new zwat();
        zwat2._a(string, objectArray);
        return zwat2;
    }

    public String _i() {
        return _a.toJson(this);
    }
}

