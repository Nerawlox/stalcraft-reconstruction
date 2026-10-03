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
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MessageComponentSerializer;
import net.minecraft.util.tdpx;
import net.minecraft.util.turb;

public class ChatMessageComponent {
    public static final Gson _a = new GsonBuilder().registerTypeAdapter((Type)((Object)ChatMessageComponent.class), new MessageComponentSerializer()).create();
    public EnumChatFormatting _b;
    public Boolean _c;
    public Boolean _d;
    public Boolean _e;
    public Boolean _f;
    public String _g;
    public String _h;
    public List _i;

    public ChatMessageComponent() {
    }

    public ChatMessageComponent(ChatMessageComponent chatMessageComponent) {
        this._b = chatMessageComponent._b;
        this._c = chatMessageComponent._c;
        this._d = chatMessageComponent._d;
        this._e = chatMessageComponent._e;
        this._f = chatMessageComponent._f;
        this._g = chatMessageComponent._g;
        this._h = chatMessageComponent._h;
        this._i = chatMessageComponent._i == null ? null : Lists.newArrayList(chatMessageComponent._i);
    }

    public ChatMessageComponent _a(EnumChatFormatting enumChatFormatting) {
        if (enumChatFormatting != null && !enumChatFormatting._c()) {
            throw new IllegalArgumentException("Argument is not a valid color!");
        }
        this._b = enumChatFormatting;
        return this;
    }

    public EnumChatFormatting _a() {
        return this._b;
    }

    public ChatMessageComponent _a(Boolean bl) {
        this._c = bl;
        return this;
    }

    public Boolean _b() {
        return this._c;
    }

    public ChatMessageComponent _b(Boolean bl) {
        this._d = bl;
        return this;
    }

    public Boolean _c() {
        return this._d;
    }

    public ChatMessageComponent _c(Boolean bl) {
        this._e = bl;
        return this;
    }

    public Boolean _d() {
        return this._e;
    }

    public ChatMessageComponent _d(Boolean bl) {
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

    public ChatMessageComponent _a(ChatMessageComponent chatMessageComponent) {
        if (this._g != null || this._h != null) {
            this._i = Lists.newArrayList(new ChatMessageComponent(this), chatMessageComponent);
            this._g = null;
            this._h = null;
        } else if (this._i != null) {
            this._i.add(chatMessageComponent);
        } else {
            this._i = Lists.newArrayList(chatMessageComponent);
        }
        return this;
    }

    public ChatMessageComponent _a(String string) {
        if (this._g != null || this._h != null) {
            this._i = Lists.newArrayList(new ChatMessageComponent(this), ChatMessageComponent._d(string));
            this._g = null;
            this._h = null;
        } else if (this._i != null) {
            this._i.add(ChatMessageComponent._d(string));
        } else {
            this._g = string;
        }
        return this;
    }

    public ChatMessageComponent _b(String string) {
        if (this._g != null || this._h != null) {
            this._i = Lists.newArrayList(new ChatMessageComponent(this), ChatMessageComponent._e(string));
            this._g = null;
            this._h = null;
        } else if (this._i != null) {
            this._i.add(ChatMessageComponent._e(string));
        } else {
            this._h = string;
        }
        return this;
    }

    public ChatMessageComponent _a(String string, Object ... objectArray) {
        if (this._g != null || this._h != null) {
            this._i = Lists.newArrayList(new ChatMessageComponent(this), ChatMessageComponent._b(string, objectArray));
            this._g = null;
            this._h = null;
        } else if (this._i != null) {
            this._i.add(ChatMessageComponent._b(string, objectArray));
        } else {
            this._h = string;
            this._i = Lists.newArrayList();
            for (Object object : objectArray) {
                if (object instanceof ChatMessageComponent) {
                    this._i.add((ChatMessageComponent)object);
                    continue;
                }
                this._i.add(ChatMessageComponent._d(object.toString()));
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

    public String _a(boolean bl, EnumChatFormatting enumChatFormatting, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        boolean bl6;
        StringBuilder stringBuilder = new StringBuilder();
        EnumChatFormatting enumChatFormatting2 = this._b == null ? enumChatFormatting : this._b;
        boolean bl7 = this._c == null ? bl2 : this._c;
        boolean bl8 = this._d == null ? bl3 : this._d;
        boolean bl9 = this._e == null ? bl4 : this._e;
        boolean bl10 = bl6 = this._f == null ? bl5 : this._f;
        if (this._h != null) {
            if (bl) {
                ChatMessageComponent._a(stringBuilder, enumChatFormatting2, bl7, bl8, bl9, bl6);
            }
            if (this._i != null) {
                Object[] objectArray = new String[this._i.size()];
                for (int i = 0; i < this._i.size(); ++i) {
                    objectArray[i] = ((ChatMessageComponent)this._i.get(i))._a(bl, enumChatFormatting2, bl7, bl8, bl9, bl6);
                }
                stringBuilder.append(tdpx._a(this._h, objectArray));
            } else {
                stringBuilder.append(tdpx._a(this._h));
            }
        } else if (this._g != null) {
            if (bl) {
                ChatMessageComponent._a(stringBuilder, enumChatFormatting2, bl7, bl8, bl9, bl6);
            }
            stringBuilder.append(this._g);
        } else if (this._i != null) {
            for (ChatMessageComponent chatMessageComponent : this._i) {
                if (bl) {
                    ChatMessageComponent._a(stringBuilder, enumChatFormatting2, bl7, bl8, bl9, bl6);
                }
                stringBuilder.append(chatMessageComponent._a(bl, enumChatFormatting2, bl7, bl8, bl9, bl6));
            }
        }
        return stringBuilder.toString();
    }

    public static void _a(StringBuilder stringBuilder, EnumChatFormatting enumChatFormatting, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (enumChatFormatting != null) {
            stringBuilder.append((Object)enumChatFormatting);
        } else if (bl || bl2 || bl3 || bl4) {
            stringBuilder.append((Object)EnumChatFormatting._v);
        }
        if (bl) {
            stringBuilder.append((Object)EnumChatFormatting._r);
        }
        if (bl2) {
            stringBuilder.append((Object)EnumChatFormatting._u);
        }
        if (bl3) {
            stringBuilder.append((Object)EnumChatFormatting._t);
        }
        if (bl4) {
            stringBuilder.append((Object)EnumChatFormatting._q);
        }
    }

    public static ChatMessageComponent _c(String string) {
        try {
            return _a.fromJson(string, ChatMessageComponent.class);
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Deserializing Message");
            CrashReportCategory crashReportCategory = crashReport.makeCategory("Serialized Message");
            crashReportCategory._a("JSON string", string);
            throw new turb(crashReport);
        }
    }

    public static ChatMessageComponent _d(String string) {
        ChatMessageComponent chatMessageComponent = new ChatMessageComponent();
        chatMessageComponent._a(string);
        return chatMessageComponent;
    }

    public static ChatMessageComponent _e(String string) {
        ChatMessageComponent chatMessageComponent = new ChatMessageComponent();
        chatMessageComponent._b(string);
        return chatMessageComponent;
    }

    public static ChatMessageComponent _b(String string, Object ... objectArray) {
        ChatMessageComponent chatMessageComponent = new ChatMessageComponent();
        chatMessageComponent._a(string, objectArray);
        return chatMessageComponent;
    }

    public String _i() {
        return _a.toJson(this);
    }
}

