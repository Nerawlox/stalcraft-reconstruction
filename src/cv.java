/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bu
 *  com.google.common.collect.Lists
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  cx
 *  u
 */
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

public class cv {
    private static final Gson a = new GsonBuilder().registerTypeAdapter(cv.class, (Object)new cx()).create();
    private a b;
    private Boolean c;
    private Boolean d;
    private Boolean e;
    private Boolean f;
    private String g;
    private String h;
    private List i;

    public cv() {
    }

    public cv(cv par1ChatMessageComponent) {
        this.b = par1ChatMessageComponent.b;
        this.c = par1ChatMessageComponent.c;
        this.d = par1ChatMessageComponent.d;
        this.e = par1ChatMessageComponent.e;
        this.f = par1ChatMessageComponent.f;
        this.g = par1ChatMessageComponent.g;
        this.h = par1ChatMessageComponent.h;
        this.i = par1ChatMessageComponent.i == null ? null : Lists.newArrayList((Iterable)par1ChatMessageComponent.i);
    }

    public cv a(a par1EnumChatFormatting) {
        if (par1EnumChatFormatting != null && !par1EnumChatFormatting.c()) {
            throw new IllegalArgumentException("Argument is not a valid color!");
        }
        this.b = par1EnumChatFormatting;
        return this;
    }

    public a a() {
        return this.b;
    }

    public cv a(Boolean par1) {
        this.c = par1;
        return this;
    }

    public Boolean b() {
        return this.c;
    }

    public cv b(Boolean par1) {
        this.d = par1;
        return this;
    }

    public Boolean c() {
        return this.d;
    }

    public cv c(Boolean par1) {
        this.e = par1;
        return this;
    }

    public Boolean d() {
        return this.e;
    }

    public cv d(Boolean par1) {
        this.f = par1;
        return this;
    }

    public Boolean e() {
        return this.f;
    }

    protected String f() {
        return this.g;
    }

    protected String g() {
        return this.h;
    }

    protected List h() {
        return this.i;
    }

    public cv a(cv par1ChatMessageComponent) {
        if (this.g == null && this.h == null) {
            if (this.i != null) {
                this.i.add(par1ChatMessageComponent);
            } else {
                this.i = Lists.newArrayList((Object[])new cv[]{par1ChatMessageComponent});
            }
        } else {
            this.i = Lists.newArrayList((Object[])new cv[]{new cv(this), par1ChatMessageComponent});
            this.g = null;
            this.h = null;
        }
        return this;
    }

    public cv a(String par1Str) {
        if (this.g == null && this.h == null) {
            if (this.i != null) {
                this.i.add(cv.d(par1Str));
            } else {
                this.g = par1Str;
            }
        } else {
            this.i = Lists.newArrayList((Object[])new cv[]{new cv(this), cv.d(par1Str)});
            this.g = null;
            this.h = null;
        }
        return this;
    }

    public cv b(String par1Str) {
        if (this.g == null && this.h == null) {
            if (this.i != null) {
                this.i.add(cv.e(par1Str));
            } else {
                this.h = par1Str;
            }
        } else {
            this.i = Lists.newArrayList((Object[])new cv[]{new cv(this), cv.e(par1Str)});
            this.g = null;
            this.h = null;
        }
        return this;
    }

    public cv a(String par1Str, Object ... par2ArrayOfObj) {
        if (this.g == null && this.h == null) {
            if (this.i != null) {
                this.i.add(cv.b(par1Str, par2ArrayOfObj));
            } else {
                this.h = par1Str;
                this.i = Lists.newArrayList();
                Object[] aobject = par2ArrayOfObj;
                int i2 = par2ArrayOfObj.length;
                for (int j2 = 0; j2 < i2; ++j2) {
                    Object object1 = aobject[j2];
                    if (object1 instanceof cv) {
                        this.i.add((cv)object1);
                        continue;
                    }
                    this.i.add(cv.d(object1.toString()));
                }
            }
        } else {
            this.i = Lists.newArrayList((Object[])new cv[]{new cv(this), cv.b(par1Str, par2ArrayOfObj)});
            this.g = null;
            this.h = null;
        }
        return this;
    }

    public String toString() {
        return this.a(false);
    }

    public String a(boolean par1) {
        return this.a(par1, null, false, false, false, false);
    }

    public String a(boolean par1, a par2EnumChatFormatting, boolean par3, boolean par4, boolean par5, boolean par6) {
        boolean flag8;
        StringBuilder stringbuilder = new StringBuilder();
        a enumchatformatting1 = this.b == null ? par2EnumChatFormatting : this.b;
        boolean flag5 = this.c == null ? par3 : this.c;
        boolean flag6 = this.d == null ? par4 : this.d;
        boolean flag7 = this.e == null ? par5 : this.e;
        boolean bl2 = flag8 = this.f == null ? par6 : this.f;
        if (this.h != null) {
            if (par1) {
                cv.a(stringbuilder, enumchatformatting1, flag5, flag6, flag7, flag8);
            }
            if (this.i != null) {
                Object[] astring = new String[this.i.size()];
                for (int i2 = 0; i2 < this.i.size(); ++i2) {
                    astring[i2] = ((cv)this.i.get(i2)).a(par1, enumchatformatting1, flag5, flag6, flag7, flag8);
                }
                stringbuilder.append(bu.a((String)this.h, (Object[])astring));
            } else {
                stringbuilder.append(bu.a((String)this.h));
            }
        } else if (this.g != null) {
            if (par1) {
                cv.a(stringbuilder, enumchatformatting1, flag5, flag6, flag7, flag8);
            }
            stringbuilder.append(this.g);
        } else if (this.i != null) {
            for (cv chatmessagecomponent : this.i) {
                if (par1) {
                    cv.a(stringbuilder, enumchatformatting1, flag5, flag6, flag7, flag8);
                }
                stringbuilder.append(chatmessagecomponent.a(par1, enumchatformatting1, flag5, flag6, flag7, flag8));
            }
        }
        return stringbuilder.toString();
    }

    private static void a(StringBuilder par0StringBuilder, a par1EnumChatFormatting, boolean par2, boolean par3, boolean par4, boolean par5) {
        if (par1EnumChatFormatting != null) {
            par0StringBuilder.append((Object)par1EnumChatFormatting);
        } else if (par2 || par3 || par4 || par5) {
            par0StringBuilder.append((Object)a.v);
        }
        if (par2) {
            par0StringBuilder.append((Object)a.r);
        }
        if (par3) {
            par0StringBuilder.append((Object)a.u);
        }
        if (par4) {
            par0StringBuilder.append((Object)a.t);
        }
        if (par5) {
            par0StringBuilder.append((Object)a.q);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public static cv c(String par0Str) {
        try {
            return (cv)a.fromJson(par0Str, cv.class);
        }
        catch (Throwable throwable) {
            b crashreport = b.a(throwable, "Deserializing Message");
            m crashreportcategory = crashreport.a("Serialized Message");
            crashreportcategory.a("JSON string", par0Str);
            throw new u(crashreport);
        }
    }

    public static cv d(String par0Str) {
        cv chatmessagecomponent = new cv();
        chatmessagecomponent.a(par0Str);
        return chatmessagecomponent;
    }

    public static cv e(String par0Str) {
        cv chatmessagecomponent = new cv();
        chatmessagecomponent.b(par0Str);
        return chatmessagecomponent;
    }

    public static cv b(String par0Str, Object ... par1ArrayOfObj) {
        cv chatmessagecomponent = new cv();
        chatmessagecomponent.a(par0Str, par1ArrayOfObj);
        return chatmessagecomponent;
    }

    public String i() {
        return a.toJson((Object)this);
    }
}

