/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.font;

import cpw.mods.fml.common.FMLLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0011\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\nR\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R-\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001b0\u001aj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001b`\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR-\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001aj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0011\u0010!\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\bR\u001a\u0010#\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\b\"\u0004\b%\u0010\nR\u001a\u0010&\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\b\"\u0004\b(\u0010\nR\u001a\u0010)\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\b\"\u0004\b+\u0010\nR\u001a\u0010,\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\b\"\u0004\b.\u0010\nR\"\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000300X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u00105\u001a\u0004\b1\u00102\"\u0004\b3\u00104\u00a8\u00067"}, d2={"Lgloomyfolken/mods/core/client/gui/font/SdfFontConfig;", "", "fontFile", "Lnet/minecraft/util/ResourceLocation;", "(Lnet/minecraft/util/ResourceLocation;)V", "atlasHeight", "", "getAtlasHeight", "()I", "setAtlasHeight", "(I)V", "atlasWidth", "getAtlasWidth", "setAtlasWidth", "baseLine", "getBaseLine", "setBaseLine", "<set-?>", "defaultFontSize", "getDefaultFontSize", "setDefaultFontSize", "fontName", "", "getFontName", "()Ljava/lang/String;", "glyphs", "Ljava/util/HashMap;", "Lgloomyfolken/mods/core/client/gui/font/SdfFontConfig$Glyph;", "Lkotlin/collections/HashMap;", "getGlyphs", "()Ljava/util/HashMap;", "kernings", "getKernings", "lineHeight", "getLineHeight", "paddingBottom", "getPaddingBottom", "setPaddingBottom", "paddingLeft", "getPaddingLeft", "setPaddingLeft", "paddingRight", "getPaddingRight", "setPaddingRight", "paddingTop", "getPaddingTop", "setPaddingTop", "textures", "", "getTextures", "()[Lnet/minecraft/util/ResourceLocation;", "setTextures", "([Lnet/minecraft/util/ResourceLocation;)V", "[Lnet/minecraft/util/ResourceLocation;", "Glyph", "minecraft"})
public final class SdfFontConfig {
    @NotNull
    private final HashMap<Integer, Integer> kernings;
    @NotNull
    private final HashMap<Integer, Glyph> glyphs;
    private int defaultFontSize;
    @NotNull
    private ResourceLocation[] textures;
    private int paddingLeft;
    private int paddingRight;
    private int paddingTop;
    private int paddingBottom;
    private int baseLine;
    private int atlasWidth;
    private int atlasHeight;
    @NotNull
    private final String fontName;
    private final int lineHeight;

    @NotNull
    public final HashMap<Integer, Integer> getKernings() {
        return this.kernings;
    }

    @NotNull
    public final HashMap<Integer, Glyph> getGlyphs() {
        return this.glyphs;
    }

    public final int getDefaultFontSize() {
        return this.defaultFontSize;
    }

    private final void setDefaultFontSize(int n) {
        this.defaultFontSize = n;
    }

    @NotNull
    public final ResourceLocation[] getTextures() {
        return this.textures;
    }

    public final void setTextures(@NotNull ResourceLocation[] resourceLocationArray) {
        Intrinsics.checkParameterIsNotNull(resourceLocationArray, "<set-?>");
        this.textures = resourceLocationArray;
    }

    public final int getPaddingLeft() {
        return this.paddingLeft;
    }

    public final void setPaddingLeft(int n) {
        this.paddingLeft = n;
    }

    public final int getPaddingRight() {
        return this.paddingRight;
    }

    public final void setPaddingRight(int n) {
        this.paddingRight = n;
    }

    public final int getPaddingTop() {
        return this.paddingTop;
    }

    public final void setPaddingTop(int n) {
        this.paddingTop = n;
    }

    public final int getPaddingBottom() {
        return this.paddingBottom;
    }

    public final void setPaddingBottom(int n) {
        this.paddingBottom = n;
    }

    public final int getBaseLine() {
        return this.baseLine;
    }

    public final void setBaseLine(int n) {
        this.baseLine = n;
    }

    public final int getAtlasWidth() {
        return this.atlasWidth;
    }

    public final void setAtlasWidth(int n) {
        this.atlasWidth = n;
    }

    public final int getAtlasHeight() {
        return this.atlasHeight;
    }

    public final void setAtlasHeight(int n) {
        this.atlasHeight = n;
    }

    @NotNull
    public final String getFontName() {
        return this.fontName;
    }

    public final int getLineHeight() {
        return this.lineHeight;
    }

    public SdfFontConfig(@NotNull ResourceLocation resourceLocation) {
        Object object;
        Object object2;
        Object object3;
        Intrinsics.checkParameterIsNotNull(resourceLocation, "fontFile");
        Object object4 = this;
        ResourceLocation[] resourceLocationArray = new HashMap();
        ((SdfFontConfig)object4).glyphs = resourceLocationArray;
        long l = System.currentTimeMillis();
        String string = srxe._b("/assets/" + resourceLocation.getResourceDomain() + '/' + resourceLocation.getResourcePath());
        Pattern pattern = Pattern.compile("([^=]+)=([^=\\s]+)");
        Object object5 = new Glyph(-1);
        int n = 0;
        String string2 = "";
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        String[] stringArray = null;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        List list2 = StringsKt.split$default((CharSequence)string, new String[]{"\n"}, false, 0, 6, null);
        for (String string3 : list2) {
            object3 = pattern.matcher(string3);
            try {
                block55: while (object3.find()) {
                    String string4;
                    object2 = object3.group(1);
                    String string5 = object2;
                    if (string5 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    String string6 = ((Object)StringsKt.trim((CharSequence)string5)).toString();
                    String string7 = string4 = object3.group(2);
                    if (string7 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    object2 = ((Object)StringsKt.trim((CharSequence)string7)).toString();
                    switch (string6) {
                        case "info face": {
                            string2 = StringsKt.replace$default((String)object2, "\"", "", false, 4, null);
                            break;
                        }
                        case "size": {
                            int n5;
                            String string8 = object2;
                            object4 = this;
                            ((SdfFontConfig)object4).defaultFontSize = n5 = Integer.parseInt(string8);
                            break;
                        }
                        case "padding": {
                            String string9 = (String)StringsKt.split$default((CharSequence)object2, new String[]{","}, false, 0, 6, null).get(0);
                            object4 = this;
                            String string10 = string9;
                            if (string10 == null) {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                            }
                            String string11 = ((Object)StringsKt.trim((CharSequence)string10)).toString();
                            ((SdfFontConfig)object4).paddingTop = Integer.parseInt(string11);
                            string9 = (String)StringsKt.split$default((CharSequence)object2, new String[]{","}, false, 0, 6, null).get(1);
                            object4 = this;
                            String string12 = string9;
                            if (string12 == null) {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                            }
                            string11 = ((Object)StringsKt.trim((CharSequence)string12)).toString();
                            ((SdfFontConfig)object4).paddingRight = Integer.parseInt(string11);
                            string9 = (String)StringsKt.split$default((CharSequence)object2, new String[]{","}, false, 0, 6, null).get(2);
                            object4 = this;
                            String string13 = string9;
                            if (string13 == null) {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                            }
                            string11 = ((Object)StringsKt.trim((CharSequence)string13)).toString();
                            ((SdfFontConfig)object4).paddingBottom = Integer.parseInt(string11);
                            string9 = (String)StringsKt.split$default((CharSequence)object2, new String[]{","}, false, 0, 6, null).get(3);
                            object4 = this;
                            String string14 = string9;
                            if (string14 == null) {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                            }
                            string11 = ((Object)StringsKt.trim((CharSequence)string14)).toString();
                            ((SdfFontConfig)object4).paddingLeft = Integer.parseInt(string11);
                            break;
                        }
                        case "common lineHeight": {
                            String string15 = object2;
                            n = Integer.parseInt(string15);
                            break;
                        }
                        case "base": {
                            int n6;
                            String string16 = object2;
                            object4 = this;
                            ((SdfFontConfig)object4).baseLine = n6 = Integer.parseInt(string16);
                            break;
                        }
                        case "scaleW": {
                            int n7;
                            String string17 = object2;
                            object4 = this;
                            ((SdfFontConfig)object4).atlasWidth = n7 = Integer.parseInt(string17);
                            break;
                        }
                        case "scaleH": {
                            int n8;
                            String string18 = object2;
                            object4 = this;
                            ((SdfFontConfig)object4).atlasHeight = n8 = Integer.parseInt(string18);
                            break;
                        }
                        case "pages": {
                            String string19 = object2;
                            stringArray = new String[Integer.parseInt(string19)];
                            break;
                        }
                        case "page id": {
                            String string20 = object2;
                            n4 = Integer.parseInt(string20);
                            break;
                        }
                        case "file": {
                            if (stringArray == null) {
                                Intrinsics.throwNpe();
                            }
                            stringArray[n4] = StringsKt.replace$default((String)object2, "\"", "", false, 4, null);
                            break;
                        }
                        case "char id": {
                            Glyph glyph;
                            Object object6 = object2;
                            Glyph glyph2 = glyph;
                            object4 = glyph;
                            int n9 = Integer.parseInt((String)object6);
                            glyph2(n9);
                            object5 = object4;
                            object6 = this.glyphs;
                            object = ((Glyph)object5).getId();
                            Object object7 = object5;
                            object6.put(object, object7);
                            break;
                        }
                        case "x": {
                            String string21 = object2;
                            object4 = object5;
                            int n10 = Integer.parseInt(string21);
                            ((Glyph)object4).setU(owkq._o(n10) / (double)this.atlasWidth);
                            break;
                        }
                        case "y": {
                            String string22 = object2;
                            object4 = object5;
                            int n11 = Integer.parseInt(string22);
                            ((Glyph)object4).setV(owkq._o(n11) / (double)this.atlasHeight);
                            break;
                        }
                        case "width": {
                            String string23 = object2;
                            object4 = object5;
                            int n12 = Integer.parseInt(string23);
                            ((Glyph)object4).setWidth(n12);
                            ((Glyph)object5).setU1(((Glyph)object5).getU() + (double)(owkq._n(((Glyph)object5).getWidth()) / (float)this.atlasWidth));
                            break;
                        }
                        case "height": {
                            String string24 = object2;
                            object4 = object5;
                            int n13 = Integer.parseInt(string24);
                            ((Glyph)object4).setHeight(n13);
                            ((Glyph)object5).setV1(((Glyph)object5).getV() + (double)(owkq._n(((Glyph)object5).getHeight()) / (float)this.atlasHeight));
                            break;
                        }
                        case "xoffset": {
                            String string25 = object2;
                            object4 = object5;
                            int n14 = Integer.parseInt(string25);
                            ((Glyph)object4).setXoffset(n14);
                            break;
                        }
                        case "yoffset": {
                            String string26 = object2;
                            object4 = object5;
                            int n15 = Integer.parseInt(string26);
                            ((Glyph)object4).setYoffset(n15);
                            break;
                        }
                        case "xadvance": {
                            String string27 = object2;
                            object4 = object5;
                            int n16 = Integer.parseInt(string27);
                            ((Glyph)object4).setXadvance(n16);
                            break;
                        }
                        case "page": {
                            String string28 = object2;
                            object4 = object5;
                            int n17 = Integer.parseInt(string28);
                            ((Glyph)object4).setTexture(n17);
                            break;
                        }
                        case "chnl": {
                            int n18;
                            Object object8 = object2;
                            object4 = object5;
                            int n19 = Integer.parseInt((String)object8);
                            HashMap<Integer, Integer> hashMap2 = object4;
                            if (n19 == 0) {
                                n18 = 3;
                            } else {
                                object8 = object2;
                                object4 = hashMap2;
                                n19 = Integer.parseInt((String)object8);
                                hashMap2 = object4;
                                n18 = n19 - 1;
                            }
                            ((Glyph)((Object)hashMap2)).setChannel(n18);
                            break;
                        }
                        case "kernings count": {
                            HashMap hashMap3;
                            object = object2;
                            int n20 = Integer.parseInt((String)object);
                            if (n20 <= 0) continue block55;
                            object = object2;
                            HashMap hashMap4 = hashMap3;
                            object4 = hashMap3;
                            int n9 = Integer.parseInt((String)object);
                            hashMap4(n9);
                            hashMap = object4;
                            break;
                        }
                        case "kerning first": {
                            String string29 = object2;
                            n2 = Integer.parseInt(string29);
                            break;
                        }
                        case "second": {
                            String string30 = object2;
                            n3 = Integer.parseInt(string30);
                            break;
                        }
                        case "amount": {
                            if (hashMap == null) {
                                Intrinsics.throwNpe();
                            }
                            Object object9 = object2;
                            Integer n21 = n2 | n3 << 16;
                            int n9 = Integer.parseInt((String)object9);
                            ((HashMap)object4).put(n21, n9);
                        }
                    }
                }
            }
            catch (Exception exception) {
                FMLLog.severe("Exception caught while reading font file!", exception);
                FMLLog.severe("Skipping current character for input data: " + object3.group() + "...", new Object[0]);
            }
        }
        int n22 = StringsKt.lastIndexOf$default((CharSequence)resourceLocation.getResourcePath(), "/", 0, false, 6, null);
        object3 = resourceLocation.getResourcePath();
        int n23 = 0;
        if (object3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string31 = object3.substring(n23, n22);
        Intrinsics.checkExpressionValueIsNotNull(string31, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        String string32 = string31;
        this.kernings = hashMap;
        this.fontName = string2;
        this.lineHeight = n;
        if (stringArray == null) {
            Intrinsics.throwNpe();
        }
        object3 = stringArray;
        object4 = this;
        Object[] objectArray = object3;
        object2 = new ArrayList(((Object[])object3).length);
        for (int i = 0; i < objectArray.length; ++i) {
            Object object10 = objectArray[i];
            object = (String)object10;
            resourceLocationArray = object2;
            String string33 = resourceLocation.getResourceDomain();
            StringBuilder stringBuilder = new StringBuilder().append("").append(string32).append('/');
            Object object11 = object;
            if (object11 == null) {
                Intrinsics.throwNpe();
            }
            ResourceLocation resourceLocation2 = new ResourceLocation(string33, stringBuilder.append((String)object11).toString());
            resourceLocationArray.add(resourceLocation2);
        }
        resourceLocationArray = (List)object2;
        objectArray = object3 = (Collection)resourceLocationArray;
        ResourceLocation[] resourceLocationArray2 = objectArray.toArray(new ResourceLocation[objectArray.size()]);
        if (resourceLocationArray2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        resourceLocationArray = resourceLocationArray2;
        ((SdfFontConfig)object4).textures = resourceLocationArray;
        FMLLog.finest("loaded font " + string2 + " in " + (System.currentTimeMillis() - l) + " ms", new Object[0]);
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0006\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001a\u0010\u001f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\u0004R\u001a\u0010\"\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\u0004R\u001a\u0010%\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\u0004R\u001a\u0010(\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\u0004\u00a8\u0006+"}, d2={"Lgloomyfolken/mods/core/client/gui/font/SdfFontConfig$Glyph;", "", "id", "", "(I)V", "channel", "getChannel", "()I", "setChannel", "height", "getHeight", "setHeight", "getId", "texture", "getTexture", "setTexture", "u", "", "getU", "()D", "setU", "(D)V", "u1", "getU1", "setU1", "v", "getV", "setV", "v1", "getV1", "setV1", "width", "getWidth", "setWidth", "xadvance", "getXadvance", "setXadvance", "xoffset", "getXoffset", "setXoffset", "yoffset", "getYoffset", "setYoffset", "minecraft"})
    public static final class Glyph {
        private double u;
        private double u1;
        private double v;
        private double v1;
        private int width;
        private int height;
        private int xoffset;
        private int yoffset;
        private int xadvance;
        private int texture;
        private int channel;
        private final int id;

        public final double getU() {
            return this.u;
        }

        public final void setU(double d) {
            this.u = d;
        }

        public final double getU1() {
            return this.u1;
        }

        public final void setU1(double d) {
            this.u1 = d;
        }

        public final double getV() {
            return this.v;
        }

        public final void setV(double d) {
            this.v = d;
        }

        public final double getV1() {
            return this.v1;
        }

        public final void setV1(double d) {
            this.v1 = d;
        }

        public final int getWidth() {
            return this.width;
        }

        public final void setWidth(int n) {
            this.width = n;
        }

        public final int getHeight() {
            return this.height;
        }

        public final void setHeight(int n) {
            this.height = n;
        }

        public final int getXoffset() {
            return this.xoffset;
        }

        public final void setXoffset(int n) {
            this.xoffset = n;
        }

        public final int getYoffset() {
            return this.yoffset;
        }

        public final void setYoffset(int n) {
            this.yoffset = n;
        }

        public final int getXadvance() {
            return this.xadvance;
        }

        public final void setXadvance(int n) {
            this.xadvance = n;
        }

        public final int getTexture() {
            return this.texture;
        }

        public final void setTexture(int n) {
            this.texture = n;
        }

        public final int getChannel() {
            return this.channel;
        }

        public final void setChannel(int n) {
            this.channel = n;
        }

        public final int getId() {
            return this.id;
        }

        public Glyph(int n) {
            this.id = n;
        }
    }
}

