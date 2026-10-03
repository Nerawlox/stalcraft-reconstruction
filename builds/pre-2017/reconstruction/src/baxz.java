/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.GloomyHooks;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.settings.EnumOptions;

public class baxz
extends GuiButton {
    public final EnumOptions enumOptions;

    public baxz(int n, int n2, int n3, String string) {
        this(n, n2, n3, null, string);
    }

    public baxz(int n, int n2, int n3, int n4, int n5, String string) {
        super(n, n2, n3, n4, n5, string);
        this.enumOptions = null;
    }

    public baxz(int n, int n2, int n3, EnumOptions enumOptions, String string) {
        super(n, n2, n3, 150, 20, string);
        this.enumOptions = enumOptions;
        GloomyHooks.onGuiSmallButtonInit(this, n, n2, n3, enumOptions, string);
    }

    public EnumOptions returnEnumOptions() {
        return this.enumOptions;
    }
}

