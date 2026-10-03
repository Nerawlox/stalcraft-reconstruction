/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.settings;

public enum EnumOptions {
    _a("MUSIC", 0, "options.music", true, false),
    _b("SOUND", 1, "options.sound", true, false),
    _c("INVERT_MOUSE", 2, "options.invertMouse", false, true),
    _d("SENSITIVITY", 3, "options.sensitivity", true, false),
    _e("FOV", 4, "options.fov", true, false),
    _f("GAMMA", 5, "options.gamma", true, false),
    _g("RENDER_DISTANCE", 6, "options.renderDistance", false, false),
    _h("VIEW_BOBBING", 7, "options.viewBobbing", false, true),
    _i("ANAGLYPH", 8, "options.anaglyph", false, true),
    _j("ADVANCED_OPENGL", 9, "options.advancedOpengl", false, true),
    _k("FRAMERATE_LIMIT", 10, "options.framerateLimit", false, false),
    _l("DIFFICULTY", 11, "options.difficulty", false, false),
    _m("GRAPHICS", 12, "options.graphics", false, false),
    _n("AMBIENT_OCCLUSION", 13, "options.ao", false, false),
    _o("GUI_SCALE", 14, "options.guiScale", false, false),
    _p("RENDER_CLOUDS", 15, "options.renderClouds", false, true),
    _q("PARTICLES", 16, "options.particles", false, false),
    _r("CHAT_VISIBILITY", 17, "options.chat.visibility", false, false),
    _s("CHAT_COLOR", 18, "options.chat.color", false, true),
    _t("CHAT_LINKS", 19, "options.chat.links", false, true),
    _u("CHAT_OPACITY", 20, "options.chat.opacity", true, false),
    _v("CHAT_LINKS_PROMPT", 21, "options.chat.links.prompt", false, true),
    _w("USE_SERVER_TEXTURES", 22, "options.serverTextures", false, true),
    _x("SNOOPER_ENABLED", 23, "options.snooper", false, true),
    _y("USE_FULLSCREEN", 24, "options.fullscreen", false, true),
    _z("ENABLE_VSYNC", 25, "options.vsync", false, true),
    _A("SHOW_CAPE", 26, "options.showCape", false, true),
    _B("TOUCHSCREEN", 27, "options.touchscreen", false, true),
    _C("CHAT_SCALE", 28, "options.chat.scale", true, false),
    _D("CHAT_WIDTH", 29, "options.chat.width", true, false),
    _E("CHAT_HEIGHT_FOCUSED", 30, "options.chat.height.focused", true, false),
    _F("CHAT_HEIGHT_UNFOCUSED", 31, "options.chat.height.unfocused", true, false),
    _G("FOG_FANCY", 32, "Fog", false, false),
    _H("FOG_START", 33, "Fog Start", false, false),
    _I("MIPMAP_LEVEL", 34, "Mipmap Level", false, false),
    _J("MIPMAP_TYPE", 35, "Mipmap Type", false, false),
    _K("LOAD_FAR", 36, "Load Far", false, false),
    _L("PRELOADED_CHUNKS", 37, "Preloaded Chunks", false, false),
    _M("SMOOTH_FPS", 38, "Smooth FPS", false, false),
    _N("CLOUDS", 39, "Clouds", false, false),
    _O("CLOUD_HEIGHT", 40, "Cloud Height", true, false),
    _P("TREES", 41, "Trees", false, false),
    _Q("GRASS", 42, "Grass", false, false),
    _R("RAIN", 43, "Rain & Snow", false, false),
    _S("WATER", 44, "Water", false, false),
    _T("ANIMATED_WATER", 45, "Water Animated", false, false),
    _U("ANIMATED_LAVA", 46, "Lava Animated", false, false),
    _V("ANIMATED_FIRE", 47, "Fire Animated", false, false),
    _W("ANIMATED_PORTAL", 48, "Portal Animated", false, false),
    _X("AO_LEVEL", 49, "Smooth Lighting Level", true, false),
    _Y("LAGOMETER", 50, "Lagometer", false, false),
    _Z("AUTOSAVE_TICKS", 51, "Autosave", false, false),
    __aa("BETTER_GRASS", 52, "Better Grass", false, false),
    __ab("ANIMATED_REDSTONE", 53, "Redstone Animated", false, false),
    __ac("ANIMATED_EXPLOSION", 54, "Explosion Animated", false, false),
    __ad("ANIMATED_FLAME", 55, "Flame Animated", false, false),
    __ae("ANIMATED_SMOKE", 56, "Smoke Animated", false, false),
    __af("WEATHER", 57, "Weather", false, false),
    __ag("SKY", 58, "Sky", false, false),
    __ah("STARS", 59, "Stars", false, false),
    __ai("SUN_MOON", 60, "Sun & Moon", false, false),
    __aj("CHUNK_UPDATES", 61, "Chunk Updates per Frame", false, false),
    __ak("CHUNK_UPDATES_DYNAMIC", 62, "Dynamic Updates", false, false),
    __al("TIME", 63, "Time", false, false),
    __am("CLEAR_WATER", 64, "Clear Water", false, false),
    __an("SMOOTH_WORLD", 65, "Smooth World", false, false),
    __ao("DEPTH_FOG", 66, "Depth Fog", false, false),
    __ap("VOID_PARTICLES", 67, "Void Particles", false, false),
    __aq("WATER_PARTICLES", 68, "Water Particles", false, false),
    __ar("RAIN_SPLASH", 69, "Rain Splash", false, false),
    __as("PORTAL_PARTICLES", 70, "Portal Particles", false, false),
    __at("POTION_PARTICLES", 71, "Potion Particles", false, false),
    __au("PROFILER", 72, "Debug Profiler", false, false),
    __av("DRIPPING_WATER_LAVA", 73, "Dripping Water/Lava", false, false),
    __aw("BETTER_SNOW", 74, "Better Snow", false, false),
    __ax("FULLSCREEN_MODE", 75, "Fullscreen Mode", false, false),
    __ay("ANIMATED_TERRAIN", 76, "Terrain Animated", false, false),
    __az("ANIMATED_ITEMS", 77, "Items Animated", false, false),
    __aA("SWAMP_COLORS", 78, "Swamp Colors", false, false),
    __aB("RANDOM_MOBS", 79, "Random Mobs", false, false),
    __aC("SMOOTH_BIOMES", 80, "Smooth Biomes", false, false),
    __aD("CUSTOM_FONTS", 81, "Custom Fonts", false, false),
    __aE("CUSTOM_COLORS", 82, "Custom Colors", false, false),
    __aF("SHOW_CAPES", 83, "Show Capes", false, false),
    __aG("CONNECTED_TEXTURES", 84, "Connected Textures", false, false),
    __aH("AA_LEVEL", 85, "Antialiasing", false, false),
    __aI("AF_LEVEL", 86, "Anisotropic Filtering", false, false),
    __aJ("RENDER_DISTANCE_FINE", 87, "Render Distance", true, false),
    __aK("ANIMATED_TEXTURES", 88, "Textures Animated", false, false),
    __aL("NATURAL_TEXTURES", 89, "Natural Textures", false, false),
    __aM("CHUNK_LOADING", 90, "Chunk Loading", false, false),
    __aN("FRAMERATE_LIMIT_FINE", 91, "Performance", true, false),
    __aO("HELD_ITEM_TOOLTIPS", 92, "Held Item Tooltips", false, false),
    __aP("DROPPED_ITEMS", 93, "Dropped Items", false, false),
    __aQ("LAZY_CHUNK_LOADING", 94, "Lazy Chunk Loading", false, false),
    __aR("CUSTOM_SKY", 95, "Custom Sky", false, false),
    __aS("FAST_MATH", 96, "Fast Math", false, false);

    public final boolean __aT;
    public final boolean __aU;
    public final String __aV;
    public static final EnumOptions[] $VALUES;

    public static EnumOptions _a(int n) {
        for (EnumOptions enumOptions : EnumOptions.values()) {
            if (enumOptions._c() != n) continue;
            return enumOptions;
        }
        return null;
    }

    public EnumOptions(String string2, int n2, String string3, boolean bl, boolean bl2) {
        this.__aV = string3;
        this.__aT = bl;
        this.__aU = bl2;
    }

    public boolean _a() {
        return this.__aT;
    }

    public boolean _b() {
        return this.__aU;
    }

    public int _c() {
        return this.ordinal();
    }

    public String _d() {
        return this.__aV;
    }

    static {
        $VALUES = new EnumOptions[]{_a, _b, _c, _d, _e, _f, _g, _h, _i, _j, _k, _l, _m, _n, _o, _p, _q, _r, _s, _t, _u, _v, _w, _x, _y, _z, _A, _B, _C, _D, _E, _F, _G, _H, _I, _J, _K, _L, _M, _N, _O, _P, _Q, _R, _S, _T, _U, _V, _W, _X, _Y, _Z, __aa, __ab, __ac, __ad, __ae, __af, __ag, __ah, __ai, __aj, __ak, __al, __am, __an, __ao, __ap, __aq, __ar, __as, __at, __au, __av, __aw, __ax, __ay, __az, __aA, __aB, __aC, __aD, __aE, __aF, __aG, __aH, __aI, __aJ, __aK, __aL, __aM, __aN, __aO, __aP, __aQ, __aR, __aS};
    }
}

