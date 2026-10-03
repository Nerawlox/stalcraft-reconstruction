/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.font;

import gloomyfolken.mods.core.client.gui.font.IFontRenderer;
import java.util.List;
import net.minecraft.client.gui.FontRenderer;

public class VanillaFontRenderer
implements IFontRenderer {
    protected final FontRenderer fr;

    public VanillaFontRenderer(FontRenderer fontRenderer) {
        this.fr = fontRenderer;
    }

    @Override
    public int getStringWidth(String string) {
        return this.fr._b(string);
    }

    @Override
    public int getFontHeight() {
        return this.fr._c;
    }

    @Override
    public String trimToWidth(String string, int n) {
        return this.fr._a(string, n);
    }

    @Override
    public List<String> wrapString(String string, int n) {
        return this.fr._c(string, n);
    }

    @Override
    public int renderString(String string, int n, int n2) {
        return this.fr._b(string, n, n2, 0xFFFFFF);
    }

    @Override
    public int renderString(String string, int n, int n2, int n3) {
        return this.fr._b(string, n, n2, n3);
    }

    @Override
    public int renderString(String string, int n, int n2, int n3, boolean bl) {
        return this.fr._a(string, n, n2, n3, bl);
    }

    @Override
    public int renderString(String string, int n, int n2, boolean bl) {
        return this.fr._a(string, n, n2, 0xFFFFFF, bl);
    }

    @Override
    public int renderCenteredString(String string, int n, int n2) {
        return this.renderCenteredString(string, n, n2, 0xFFFFFF);
    }

    @Override
    public int renderCenteredString(String string, int n, int n2, int n3) {
        return this.renderCenteredString(string, n, n2, n3, false);
    }

    @Override
    public int renderCenteredString(String string, int n, int n2, int n3, boolean bl) {
        return this.renderString(string, n - this.getStringWidth(string) / 2, n2 - this.getFontHeight() / 2, n3, bl);
    }

    @Override
    public int renderCenteredString(String string, int n, int n2, boolean bl) {
        return this.renderCenteredString(string, n, n2, 0xFFFFFF, bl);
    }

    public FontRenderer getFr() {
        return this.fr;
    }
}

