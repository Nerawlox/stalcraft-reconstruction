/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.GloomyHooks;
import net.minecraft.client.settings.kjui;

public class baxz
extends jiok {
    public final kjui field_73754_j;

    public baxz(int n, int n2, int n3, String string) {
        this(n, n2, n3, null, string);
    }

    public baxz(int n, int n2, int n3, int n4, int n5, String string) {
        super(n, n2, n3, n4, n5, string);
        this.field_73754_j = null;
    }

    public baxz(int n, int n2, int n3, kjui kjui2, String string) {
        super(n, n2, n3, 150, 20, string);
        this.field_73754_j = kjui2;
        GloomyHooks.onGuiSmallButtonInit(this, n, n2, n3, kjui2, string);
    }

    public kjui func_73753_a() {
        return this.field_73754_j;
    }
}

