/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.font;

import gloomyfolken.mods.core.client.gui.font.IFontRenderer;
import gloomyfolken.mods.core.client.gui.font.SdfFontConfig;
import gloomyfolken.mods.effects.client.main.jxtc;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CharIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 >2\u00020\u0001:\u0004=>?@B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007B\u0017\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\u001a\u0010\u001a\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJF\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020\u001d2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020(J \u0010 \u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0019H\u0016J(\u0010 \u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u001dH\u0016J(\u0010 \u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0019H\u0016J0\u0010 \u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u001dH\u0016J0\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u0002002\u0006\u0010%\u001a\u00020&H\u0002JF\u00101\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020\u001d2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020(J \u00101\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0019H\u0016J(\u00101\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u001dH\u0016J(\u00101\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0019H\u0016J0\u00101\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u001dH\u0016J@\u00102\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020(H\u0002J \u00104\u001a\u00020+2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020(H\u0002J\u0018\u00105\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u0019H\u0016J\u0014\u00107\u001a\u000208*\u0002092\u0006\u0010:\u001a\u00020&H\u0002J\f\u0010;\u001a\u00020<*\u000209H\u0002R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006A"}, d2={"Lgloomyfolken/mods/core/client/gui/font/SdfFont;", "Lgloomyfolken/mods/core/client/gui/font/IFontRenderer;", "id", "", "(Ljava/lang/String;)V", "fontSize", "", "(Ljava/lang/String;F)V", "font", "Lgloomyfolken/mods/core/client/gui/font/SdfFontConfig;", "size", "(Lgloomyfolken/mods/core/client/gui/font/SdfFontConfig;F)V", "getFont", "()Lgloomyfolken/mods/core/client/gui/font/SdfFontConfig;", "scale", "getScale", "()F", "getSize", "weight", "Lgloomyfolken/mods/core/client/gui/font/SdfFont$FontWeight$Normal;", "getWeight", "()Lgloomyfolken/mods/core/client/gui/font/SdfFont$FontWeight$Normal;", "setWeight", "(Lgloomyfolken/mods/core/client/gui/font/SdfFont$FontWeight$Normal;)V", "getFontHeight", "", "getStringWidth", "str", "isCharSupported", "", "c", "", "renderCenteredString", "", "x", "y", "string", "color", "", "border", "Lgloomyfolken/mods/core/client/gui/font/SdfFont$FontWeight;", "shadow", "renderGlyph", "", "renderX", "renderY", "fontScale", "glyph", "Lgloomyfolken/mods/core/client/gui/font/SdfFontConfig$Glyph;", "renderString", "renderStringOrBorder", "isBorder", "setupShader", "trimToWidth", "maxWidth", "coloredIterator", "Lgloomyfolken/mods/core/client/gui/font/SdfFont$ColoredStringIterator;", "", "baseColor", "uncoloredIterator", "Lgloomyfolken/mods/core/client/gui/font/SdfFont$StringIterator;", "ColoredStringIterator", "Companion", "FontWeight", "StringIterator", "minecraft"})
public final class SdfFont
implements IFontRenderer {
    @NotNull
    private FontWeight.Normal weight;
    private final float scale;
    @NotNull
    private final SdfFontConfig font;
    private final float size;
    @NotNull
    public static jxtc fontShader;
    @NotNull
    public static SdfFont tahoma;
    @NotNull
    private static final HashMap<String, SdfFontConfig> loadedFonts;
    public static final Companion Companion;

    @NotNull
    public final FontWeight.Normal getWeight() {
        return this.weight;
    }

    public final void setWeight(@NotNull FontWeight.Normal normal) {
        Intrinsics.checkParameterIsNotNull(normal, "<set-?>");
        this.weight = normal;
    }

    public final float getScale() {
        return this.scale;
    }

    public final float getStringWidth(@Nullable String string, float f) {
        if (string == null) {
            return 0.0f;
        }
        float f2 = 0.0f;
        StringIterator stringIterator = this.uncoloredIterator(string);
        SdfFontConfig.Glyph glyph = null;
        while (stringIterator.hasNext()) {
            SdfFontConfig.Glyph glyph2;
            Integer n;
            char c = stringIterator.nextChar();
            if (this.font.getGlyphs().get(c) == null) {
                continue;
            }
            if (glyph == null) {
                n = 0;
            } else {
                n = this.font.getKernings().get(glyph.getId() | glyph2.getId() << 16);
                if (n == null) {
                    n = 0;
                }
            }
            Integer n2 = n;
            f2 += (float)(n2 - (this.font.getPaddingLeft() + this.font.getPaddingRight()) + glyph2.getXadvance());
            glyph = glyph2;
        }
        return f2 * (f / (float)this.font.getDefaultFontSize());
    }

    public static /* synthetic */ float getStringWidth$default(SdfFont sdfFont, String string, float f, int n, Object object) {
        if ((n & 2) != 0) {
            f = sdfFont.size;
        }
        return sdfFont.getStringWidth(string, f);
    }

    public final double renderCenteredString(float f, float f2, @NotNull String string, long l, boolean bl, float f3, @NotNull FontWeight fontWeight) {
        Intrinsics.checkParameterIsNotNull(string, "string");
        Intrinsics.checkParameterIsNotNull(fontWeight, "weight");
        return this.renderString(f - this.getStringWidth(string, f3) / 2.0f, f2, string, l, bl, f3, fontWeight);
    }

    public static /* synthetic */ double renderCenteredString$default(SdfFont sdfFont, float f, float f2, String string, long l, boolean bl, float f3, FontWeight fontWeight, int n, Object object) {
        if ((n & 8) != 0) {
            l = 0xFFFFFFFFL;
        }
        if ((n & 0x10) != 0) {
            bl = false;
        }
        if ((n & 0x20) != 0) {
            f3 = sdfFont.size;
        }
        if ((n & 0x40) != 0) {
            fontWeight = sdfFont.weight;
        }
        return sdfFont.renderCenteredString(f, f2, string, l, bl, f3, fontWeight);
    }

    public final double renderString(float f, float f2, @NotNull String string, long l, boolean bl, float f3, @NotNull FontWeight fontWeight) {
        Intrinsics.checkParameterIsNotNull(string, "string");
        Intrinsics.checkParameterIsNotNull(fontWeight, "weight");
        Companion.getFontShader()._e();
        long l2 = l;
        if ((l2 & 0xFF000000L) == 0L) {
            l2 |= 0xFF000000L;
        }
        float f4 = f;
        if (bl) {
            this.renderStringOrBorder(f4, f2, string, l2 & 0xFF000000L, f3, true, fontWeight);
        }
        double d = this.renderStringOrBorder(f4, f2, string, l2, f3, false, fontWeight);
        GL20.glUseProgram(0);
        return d;
    }

    public static /* synthetic */ double renderString$default(SdfFont sdfFont, float f, float f2, String string, long l, boolean bl, float f3, FontWeight fontWeight, int n, Object object) {
        if ((n & 8) != 0) {
            l = 0xFFFFFFFFL;
        }
        if ((n & 0x10) != 0) {
            bl = false;
        }
        if ((n & 0x20) != 0) {
            f3 = sdfFont.size;
        }
        if ((n & 0x40) != 0) {
            fontWeight = sdfFont.weight;
        }
        return sdfFont.renderString(f, f2, string, l, bl, f3, fontWeight);
    }

    private final double renderStringOrBorder(float f, float f2, String string, long l, float f3, boolean bl, FontWeight fontWeight) {
        int n = -1;
        GL11.glEnable(3553);
        GL11.glEnable(3042);
        GL11.glPushMatrix();
        GL11.glTranslatef(f, f2, 0.0f);
        float f4 = f3 / (float)this.font.getDefaultFontSize();
        float f5 = owkq._n(this.font.getPaddingLeft());
        float f6 = 0.0f;
        SdfFontConfig.Glyph glyph = null;
        ColoredStringIterator coloredStringIterator = this.coloredIterator(string, l);
        htvf.field_78398_a.func_78382_b();
        this.setupShader(f3, bl, fontWeight);
        while (coloredStringIterator.hasNext()) {
            Integer n2;
            SdfFontConfig.Glyph glyph2;
            char c = coloredStringIterator.nextChar();
            if (this.font.getGlyphs().get(c) == null) {
                continue;
            }
            if (glyph2.getTexture() != n && n != glyph2.getTexture()) {
                n = glyph2.getTexture();
                xpzm._E()._R()._a(this.font.getTextures()[n]);
            }
            SdfFontConfig.Glyph glyph3 = glyph2;
            Intrinsics.checkExpressionValueIsNotNull(glyph3, "glyph");
            this.renderGlyph(f5, f6, f4, glyph3, coloredStringIterator.getColor());
            if (glyph == null) {
                n2 = 0;
            } else {
                n2 = this.font.getKernings().get(glyph.getId() | glyph2.getId() << 16);
                if (n2 == null) {
                    n2 = 0;
                }
            }
            Integer n3 = n2;
            f5 += (float)(n3 - (this.font.getPaddingLeft() + this.font.getPaddingRight()) + glyph2.getXadvance());
            glyph = glyph2;
        }
        htvf.field_78398_a.func_78381_a();
        GL11.glPopMatrix();
        return (double)f + owkq._r(f5) * (double)(f3 / (float)this.font.getDefaultFontSize());
    }

    private final void renderGlyph(float f, float f2, float f3, SdfFontConfig.Glyph glyph, long l) {
        double d = (owkq._r(f) + (double)glyph.getXoffset()) * (double)f3;
        double d2 = (owkq._r(f2) + (double)glyph.getYoffset()) * (double)f3;
        htvf htvf2 = htvf.field_78398_a;
        int n = owkq._l((int)l);
        htvf2.func_78370_a(owkq._d(n), owkq._e(n), owkq._f(n), owkq._g(n));
        htvf2.func_78374_a(d, d2 + (double)((float)glyph.getHeight() * f3), owkq._o(glyph.getChannel()), glyph.getU(), glyph.getV1());
        htvf2.func_78374_a(d + (double)((float)glyph.getWidth() * f3), d2 + (double)((float)glyph.getHeight() * f3), owkq._o(glyph.getChannel()), glyph.getU1(), glyph.getV1());
        htvf2.func_78374_a(d + (double)((float)glyph.getWidth() * f3), d2, owkq._o(glyph.getChannel()), glyph.getU1(), glyph.getV());
        htvf2.func_78374_a(d, d2, owkq._o(glyph.getChannel()), glyph.getU(), glyph.getV());
    }

    private final void setupShader(float f, boolean bl, FontWeight fontWeight) {
        Companion.getFontShader()._a("fontTexture", 0);
        Companion.getFontShader()._a("width", fontWeight.getWidth(f));
        Companion.getFontShader()._a("edgeWidth", fontWeight.getEdgeWidth(f));
        Companion.getFontShader()._a("borderWidth", fontWeight.getBorderWidth(f) * owkq._a(bl));
        Companion.getFontShader()._a("borderEdge", fontWeight.getBorderEdgeWidth(f));
    }

    @Override
    @NotNull
    public String trimToWidth(@NotNull String string, int n) {
        Intrinsics.checkParameterIsNotNull(string, "str");
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = 0;
        while (true) {
            String string2 = stringBuilder.toString();
            Intrinsics.checkExpressionValueIsNotNull(string2, "res.toString()");
            if (this.getStringWidth(string2) >= n || n2 >= string.length()) break;
            stringBuilder.append(string.charAt(n2++));
        }
        String string3 = stringBuilder.toString();
        Intrinsics.checkExpressionValueIsNotNull(string3, "res.toString()");
        return string3;
    }

    public final boolean isCharSupported(char c) {
        return this.font.getGlyphs().get(c) != null;
    }

    private final ColoredStringIterator coloredIterator(@NotNull CharSequence charSequence, long l) {
        return new ColoredStringIterator(charSequence, l);
    }

    private final StringIterator uncoloredIterator(@NotNull CharSequence charSequence) {
        return new StringIterator(charSequence);
    }

    public final int getFontHeight(float f) {
        return owkq._q((float)this.font.getLineHeight() * f / (float)this.font.getDefaultFontSize());
    }

    @Override
    public int getStringWidth(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "str");
        return owkq._t(this.getStringWidth(string, this.size));
    }

    @Override
    public int getFontHeight() {
        return owkq._q((float)this.font.getLineHeight() * this.scale);
    }

    @Override
    public int renderString(@NotNull String string, int n, int n2) {
        Intrinsics.checkParameterIsNotNull(string, "str");
        return owkq._k(SdfFont.renderString$default(this, owkq._n(n), owkq._n(n2), string, 0L, false, 0.0f, null, 120, null));
    }

    @Override
    public int renderString(@NotNull String string, int n, int n2, int n3) {
        Intrinsics.checkParameterIsNotNull(string, "str");
        return owkq._k(SdfFont.renderString$default(this, owkq._n(n), owkq._n(n2), string, n3, false, 0.0f, null, 112, null));
    }

    @Override
    public int renderString(@NotNull String string, int n, int n2, int n3, boolean bl) {
        Intrinsics.checkParameterIsNotNull(string, "str");
        return owkq._k(SdfFont.renderString$default(this, owkq._n(n), owkq._n(n2), string, n3, bl, 0.0f, null, 96, null));
    }

    @Override
    public int renderString(@NotNull String string, int n, int n2, boolean bl) {
        Intrinsics.checkParameterIsNotNull(string, "str");
        return owkq._k(SdfFont.renderString$default(this, owkq._n(n), owkq._n(n2), string, 0L, bl, 0.0f, null, 104, null));
    }

    @Override
    public int renderCenteredString(@NotNull String string, int n, int n2) {
        Intrinsics.checkParameterIsNotNull(string, "str");
        return owkq._k(SdfFont.renderCenteredString$default(this, owkq._n(n), owkq._n(n2), string, 0L, false, 0.0f, null, 120, null));
    }

    @Override
    public int renderCenteredString(@NotNull String string, int n, int n2, int n3) {
        Intrinsics.checkParameterIsNotNull(string, "str");
        return owkq._k(SdfFont.renderCenteredString$default(this, owkq._n(n), owkq._n(n2), string, n3, false, 0.0f, null, 112, null));
    }

    @Override
    public int renderCenteredString(@NotNull String string, int n, int n2, int n3, boolean bl) {
        Intrinsics.checkParameterIsNotNull(string, "str");
        return owkq._k(SdfFont.renderCenteredString$default(this, owkq._n(n), owkq._n(n2), string, n3, bl, 0.0f, null, 96, null));
    }

    @Override
    public int renderCenteredString(@NotNull String string, int n, int n2, boolean bl) {
        Intrinsics.checkParameterIsNotNull(string, "str");
        return owkq._k(SdfFont.renderCenteredString$default(this, owkq._n(n), owkq._n(n2), string, 0L, bl, 0.0f, null, 104, null));
    }

    @NotNull
    public final SdfFontConfig getFont() {
        return this.font;
    }

    public final float getSize() {
        return this.size;
    }

    public SdfFont(@NotNull SdfFontConfig sdfFontConfig, float f) {
        Intrinsics.checkParameterIsNotNull(sdfFontConfig, "font");
        this.font = sdfFontConfig;
        this.size = f;
        this.weight = FontWeight.Normal.INSTANCE;
        this.scale = this.size / owkq._n(this.font.getDefaultFontSize());
    }

    public /* synthetic */ SdfFont(SdfFontConfig sdfFontConfig, float f, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            f = owkq._n(sdfFontConfig.getDefaultFontSize());
        }
        this(sdfFontConfig, f);
    }

    public SdfFont(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "id");
        this(Companion.get(string), 0.0f, 2, null);
    }

    public SdfFont(@NotNull String string, float f) {
        Intrinsics.checkParameterIsNotNull(string, "id");
        this(Companion.get(string), f);
    }

    static {
        Companion = new Companion(null);
        loadedFonts = new HashMap();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\b\u0012\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0012\u001a\u00020\u0006H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0014J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001a"}, d2={"Lgloomyfolken/mods/core/client/gui/font/SdfFont$StringIterator;", "Lkotlin/collections/CharIterator;", "string", "", "(Ljava/lang/CharSequence;)V", "hasNextChar", "", "<set-?>", "", "index", "getIndex", "()I", "setIndex", "(I)V", "nextChar", "", "getString", "()Ljava/lang/CharSequence;", "hasNext", "init", "", "moveToNextChar", "resetColor", "updateColor", "color", "", "minecraft"})
    private static class StringIterator
    extends CharIterator {
        private char nextChar;
        private boolean hasNextChar;
        private int index;
        @NotNull
        private final CharSequence string;

        public final int getIndex() {
            return this.index;
        }

        private final void setIndex(int n) {
            this.index = n;
        }

        protected void init() {
            this.moveToNextChar();
        }

        protected void updateColor(long l) {
        }

        protected void resetColor() {
        }

        protected final void moveToNextChar() {
            while (this.index < this.string.length()) {
                char c = this.index;
                this.index = c + 1;
                char c2 = this.string.charAt(c);
                if (c2 == '\u00a7' && this.index + 1 < this.string.length()) {
                    int n = this.index;
                    this.index = n + 1;
                    CharSequence charSequence = "0123456789abcdefklmnor";
                    c = this.string.charAt(n);
                    char c3 = c;
                    char c4 = Character.toLowerCase(c3);
                    if ((n = StringsKt.indexOf$default(charSequence, c4, 0, false, 6, null)) > 0 && n < 16) {
                        this.updateColor(IFontRenderer.Colors.COLOR_CODES[n]);
                        continue;
                    }
                    if (n != 21) continue;
                    this.resetColor();
                    continue;
                }
                this.nextChar = c2;
                this.hasNextChar = true;
                return;
            }
        }

        @Override
        public boolean hasNext() {
            return this.hasNextChar;
        }

        @Override
        public char nextChar() {
            char c = this.nextChar;
            this.hasNextChar = false;
            this.moveToNextChar();
            return c;
        }

        @NotNull
        public final CharSequence getString() {
            return this.string;
        }

        public StringIterator(@NotNull CharSequence charSequence) {
            Intrinsics.checkParameterIsNotNull(charSequence, "string");
            this.string = charSequence;
            this.nextChar = (char)32;
            this.init();
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0014J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0005H\u0014R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lgloomyfolken/mods/core/client/gui/font/SdfFont$ColoredStringIterator;", "Lgloomyfolken/mods/core/client/gui/font/SdfFont$StringIterator;", "string", "", "baseColor", "", "(Ljava/lang/CharSequence;J)V", "alpha", "getBaseColor", "()J", "<set-?>", "color", "getColor", "setColor", "(J)V", "nextColor", "init", "", "nextChar", "", "resetColor", "updateColor", "minecraft"})
    private static final class ColoredStringIterator
    extends StringIterator {
        private long alpha;
        private long nextColor;
        private long color;
        private final long baseColor;

        public final long getColor() {
            return this.color;
        }

        private final void setColor(long l) {
            this.color = l;
        }

        @Override
        protected void init() {
        }

        @Override
        protected void updateColor(long l) {
            this.nextColor = l;
        }

        @Override
        protected void resetColor() {
            this.nextColor = this.baseColor;
        }

        @Override
        public char nextChar() {
            this.color = this.nextColor;
            return super.nextChar();
        }

        public final long getBaseColor() {
            return this.baseColor;
        }

        public ColoredStringIterator(@NotNull CharSequence charSequence, long l) {
            Intrinsics.checkParameterIsNotNull(charSequence, "string");
            super(charSequence);
            this.baseColor = l;
            this.alpha = (long)255 & this.baseColor;
            this.nextColor = this.baseColor;
            this.color = this.baseColor;
            this.moveToNextChar();
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001:\u0003\f\r\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003J\u000e\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003J\u000e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2={"Lgloomyfolken/mods/core/client/gui/font/SdfFont$FontWeight;", "", "additionalWidth", "", "(F)V", "getAdditionalWidth", "()F", "getBorderEdgeWidth", "fontSize", "getBorderWidth", "getEdgeWidth", "getWidth", "Bold", "Normal", "Thin", "minecraft"})
    public static class FontWeight {
        private final float additionalWidth;

        public final float getWidth(float f) {
            return owkq._b(f, 0.0f, 50.0f) * 0.002f + 0.3f + this.additionalWidth;
        }

        public final float getEdgeWidth(float f) {
            return owkq._d(0.425f - f * 0.01f, 0.1f);
        }

        public final float getBorderWidth(float f) {
            return 0.5f + this.additionalWidth;
        }

        public final float getBorderEdgeWidth(float f) {
            return owkq._d(0.28f - f * 0.004f, 0.05f);
        }

        public final float getAdditionalWidth() {
            return this.additionalWidth;
        }

        public FontWeight(float f) {
            this.additionalWidth = f;
        }

        @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2={"Lgloomyfolken/mods/core/client/gui/font/SdfFont$FontWeight$Normal;", "Lgloomyfolken/mods/core/client/gui/font/SdfFont$FontWeight;", "()V", "minecraft"})
        public static final class Normal
        extends FontWeight {
            public static final Normal INSTANCE;

            private Normal() {
                super(0.0f);
                INSTANCE = this;
            }

            static {
                new Normal();
            }
        }

        @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2={"Lgloomyfolken/mods/core/client/gui/font/SdfFont$FontWeight$Bold;", "Lgloomyfolken/mods/core/client/gui/font/SdfFont$FontWeight;", "()V", "minecraft"})
        public static final class Bold
        extends FontWeight {
            public static final Bold INSTANCE;

            private Bold() {
                super(0.1f);
                INSTANCE = this;
            }

            static {
                new Bold();
            }
        }

        @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2={"Lgloomyfolken/mods/core/client/gui/font/SdfFont$FontWeight$Thin;", "Lgloomyfolken/mods/core/client/gui/font/SdfFont$FontWeight;", "()V", "minecraft"})
        public static final class Thin
        extends FontWeight {
            public static final Thin INSTANCE;

            private Thin() {
                super(-0.1f);
                INSTANCE = this;
            }

            static {
                new Thin();
            }
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000bH\u0086\u0002J\u0016\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR-\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001e"}, d2={"Lgloomyfolken/mods/core/client/gui/font/SdfFont$Companion;", "", "()V", "fontShader", "Lgloomyfolken/mods/effects/client/main/Shader;", "getFontShader", "()Lgloomyfolken/mods/effects/client/main/Shader;", "setFontShader", "(Lgloomyfolken/mods/effects/client/main/Shader;)V", "loadedFonts", "Ljava/util/HashMap;", "", "Lgloomyfolken/mods/core/client/gui/font/SdfFontConfig;", "Lkotlin/collections/HashMap;", "getLoadedFonts", "()Ljava/util/HashMap;", "tahoma", "Lgloomyfolken/mods/core/client/gui/font/SdfFont;", "getTahoma", "()Lgloomyfolken/mods/core/client/gui/font/SdfFont;", "setTahoma", "(Lgloomyfolken/mods/core/client/gui/font/SdfFont;)V", "get", "id", "loadFont", "fontResource", "Lnet/minecraft/util/ResourceLocation;", "loadFonts", "", "loadShader", "minecraft"})
    public static final class Companion {
        @NotNull
        public final jxtc getFontShader() {
            jxtc jxtc2 = fontShader;
            if (jxtc2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fontShader");
            }
            return jxtc2;
        }

        public final void setFontShader(@NotNull jxtc jxtc2) {
            Intrinsics.checkParameterIsNotNull(jxtc2, "<set-?>");
            fontShader = jxtc2;
        }

        @NotNull
        public final SdfFont getTahoma() {
            SdfFont sdfFont = tahoma;
            if (sdfFont == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tahoma");
            }
            return sdfFont;
        }

        public final void setTahoma(@NotNull SdfFont sdfFont) {
            Intrinsics.checkParameterIsNotNull(sdfFont, "<set-?>");
            tahoma = sdfFont;
        }

        @NotNull
        public final HashMap<String, SdfFontConfig> getLoadedFonts() {
            return loadedFonts;
        }

        public final void loadShader() {
            this.setFontShader(new jxtc("gloomycore", "font"));
        }

        public final void loadFonts() {
            this.setTahoma(new SdfFont(this.loadFont("tahoma", new ResourceLocation("gloomycore", "fonts/sdf/tahoma.fnt")), 0.0f, 2, null));
        }

        @NotNull
        public final SdfFontConfig loadFont(@NotNull String string, @NotNull ResourceLocation resourceLocation) {
            Map map;
            Intrinsics.checkParameterIsNotNull(string, "id");
            Intrinsics.checkParameterIsNotNull(resourceLocation, "fontResource");
            Object object = this.getLoadedFonts();
            Map map2 = map = object;
            if (map2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            }
            if (map2.containsKey(string)) {
                SdfFontConfig sdfFontConfig = this.getLoadedFonts().get(string);
                if (sdfFontConfig == null) {
                    Intrinsics.throwNpe();
                }
                return sdfFontConfig;
            }
            object = new SdfFontConfig(resourceLocation);
            this.getLoadedFonts().put(string, (SdfFontConfig)object);
            return object;
        }

        @NotNull
        public final SdfFontConfig get(@NotNull String string) {
            Intrinsics.checkParameterIsNotNull(string, "id");
            SdfFontConfig sdfFontConfig = this.getLoadedFonts().get(string);
            if (sdfFontConfig == null) {
                Intrinsics.throwNpe();
            }
            return sdfFontConfig;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

