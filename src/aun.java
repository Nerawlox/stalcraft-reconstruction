/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public enum aun {
    a("options.music", true, false),
    b("options.sound", true, false),
    c("options.invertMouse", false, true),
    d("options.sensitivity", true, false),
    e("options.fov", true, false),
    f("options.gamma", true, false),
    g("options.renderDistance", false, false),
    h("options.viewBobbing", false, true),
    i("options.anaglyph", false, true),
    j("options.advancedOpengl", false, true),
    k("options.framerateLimit", false, false),
    l("options.difficulty", false, false),
    m("options.graphics", false, false),
    n("options.ao", false, false),
    o("options.guiScale", false, false),
    p("options.renderClouds", false, true),
    q("options.particles", false, false),
    r("options.chat.visibility", false, false),
    s("options.chat.color", false, true),
    t("options.chat.links", false, true),
    u("options.chat.opacity", true, false),
    v("options.chat.links.prompt", false, true),
    w("options.serverTextures", false, true),
    x("options.snooper", false, true),
    y("options.fullscreen", false, true),
    z("options.vsync", false, true),
    A("options.showCape", false, true),
    B("options.touchscreen", false, true),
    C("options.chat.scale", true, false),
    D("options.chat.width", true, false),
    E("options.chat.height.focused", true, false),
    F("options.chat.height.unfocused", true, false);

    private final boolean G;
    private final boolean H;
    private final String I;

    public static aun a(int par0) {
        for (aun enumoptions : aun.values()) {
            if (enumoptions.c() != par0) continue;
            return enumoptions;
        }
        return null;
    }

    private aun(String par3Str, boolean par4, boolean par5) {
        this.I = par3Str;
        this.G = par4;
        this.H = par5;
    }

    public boolean a() {
        return this.G;
    }

    public boolean b() {
        return this.H;
    }

    public int c() {
        return this.ordinal();
    }

    public String d() {
        return this.I;
    }
}

