/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.main.ClientProxy;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mcoptifine.Config;
import mcoptifine.TextureUtils;
import mcoptifine.WrUpdates;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.EnumOptions;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.util.options.Option;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\bJ\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\bJ\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0013J\u000e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0013J\u000e\u0010#\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0013J\u000e\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\bJ\u000e\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\bJ\u000e\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0013J\u000e\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\bR\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2={"Lgloomyfolken/mods/core/client/options/VideoOptionsHelper;", "", "()V", "mcSettings", "Lnet/minecraft/client/settings/GameSettings;", "getMcSettings", "()Lnet/minecraft/client/settings/GameSettings;", "minResolutionPower", "", "texturePackResolutions", "Ljava/util/ArrayList;", "Lgloomyfolken/mods/core/client/gui/engine/Dimension;", "Lkotlin/collections/ArrayList;", "getMaxSupportedTextureQuality", "targetQuality", "initializeTexturePackResolutions", "", "overrideBgSettings", "updateRenderersAndSave", "", "qualityToResourcePackResolution", "quality", "setAnimatedTextures", "enabled", "setBlocksTextureQuality", "setChunkLoading", "type", "setFancyGraphics", "setFilterModeBlocks", "filteringMode", "Lgloomyfolken/mods/effects/client/texture/FilteringMode;", "setFpsLimit", "normalizedValue", "", "setGrass", "setOcclusionCulling", "setRenderBlockDistance", "value", "setSoftLighting", "level", "setVSync", "vsync", "setVegetation", "vegetation", "minecraft"})
public final class uhip {
    private static final ArrayList<Dimension> _b;
    private static final int _c;
    public static final uhip _a;

    private final GameSettings _b() {
        GameSettings gameSettings = Minecraft._E()._M;
        Intrinsics.checkExpressionValueIsNotNull(gameSettings, "Minecraft.getMinecraft().gameSettings");
        return gameSettings;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void _a() {
        int n = 0;
        int n2 = 3;
        while (true) {
            ResourceLocation resourceLocation = new ResourceLocation("stalker", "textures/blocks_" + this._b(n) + ".map");
            try {
                Closeable closeable;
                Closeable closeable2 = Minecraft._E()._S()._a(resourceLocation)._a();
                boolean bl = false;
                try {
                    InputStream inputStream = (InputStream)closeable2;
                    DataInputStream dataInputStream = new DataInputStream(inputStream);
                    boolean bl2 = _b.add(new Dimension(dataInputStream.readInt(), dataInputStream.readInt()));
                    closeable = closeable2;
                }
                catch (Exception exception) {
                    try {
                        bl = true;
                        try {
                            Closeable closeable3 = closeable2;
                            if (closeable3 != null) {
                                closeable3.close();
                            }
                        }
                        catch (Exception exception2) {
                            // empty catch block
                        }
                        throw (Throwable)exception;
                    }
                    catch (Throwable throwable) {
                        if (!bl) {
                            Closeable closeable4 = closeable2;
                            if (closeable4 != null) {
                                closeable4.close();
                            }
                        }
                        throw throwable;
                    }
                }
                if (closeable != null) {
                    closeable.close();
                }
            }
            catch (IOException iOException) {
                _b.add(new Dimension(0, 0));
            }
            if (n == n2) break;
            ++n;
        }
    }

    public final void _a(int n) {
        this._b().setOfRenderDistanceFine(n);
        this._b().saveOptions();
    }

    public final int _b(int n) {
        return (int)Math.pow(2.0, owkq._o(_c) + (double)n);
    }

    public final int _c(int n) {
        if (_b.isEmpty() || n > _b.size() - 1) {
            return n;
        }
        int n2 = n;
        int n3 = uhip._b.get((int)n2).width;
        int n4 = uhip._b.get((int)n2).height;
        int n5 = GL11.glGetInteger(3379);
        while (n3 > n5 || n4 > n5) {
            if (--n2 < 0) {
                throw (Throwable)new IllegalStateException("Cound not find any supported resource pack resolution!");
            }
            n3 = uhip._b.get((int)n2).width;
            n4 = uhip._b.get((int)n2).height;
        }
        return n2;
    }

    public final void _d(int n) {
        int n2;
        sctd sctd2;
        sctd sctd3 = sctd2 = sctd._f;
        ClientProxy.textureQualityBlocks.value = n2 = _a._c(n);
        int n3 = sctd3._r;
        sctd._e()._r = sctd3._r = _a._b(n2);
        if (n3 != sctd3._r) {
            WrUpdates.finishCurrentUpdate();
            sctd3._b(Config.getResourceManager());
            sctd3._g();
            sctd3._i();
            TextureUtils.update();
            Minecraft._E()._s._b();
        }
    }

    public final void _a(@NotNull anxd anxd2) {
        Intrinsics.checkParameterIsNotNull((Object)anxd2, "filteringMode");
        int n = this._b().ofMipmapLevel;
        int n2 = this._b().ofMipmapType;
        int n3 = this._b().ofAfLevel;
        this._b().ofMipmapLevel = 4;
        this._b().ofMipmapType = anxd2._i && anxd2._h ? 3 : (anxd2._h ? 2 : (anxd2._i ? 1 : 0));
        this._b().ofAfLevel = anxd2._j;
        this._b().saveOptions();
        if (n3 != this._b().ofAfLevel || n != this._b().ofMipmapLevel || n2 != this._b().ofMipmapType) {
            Config.dbg("*** Updating block atlas parameters ***");
            WrUpdates.finishCurrentUpdate();
            sctd._f._g();
            sctd._f._i();
        }
        Minecraft._E()._s._b();
    }

    public final void _e(int n) {
        this._b().ambientOcclusion = n % 3;
        this._b().saveOptions();
        Minecraft._E()._s._b();
    }

    public final void _a(boolean bl) {
        this._b().fancyGraphics = bl;
        this._b().saveOptions();
        Minecraft._E()._s._b();
    }

    public final void _b(boolean bl) {
        this._b().ofAnimatedExplosion = bl;
        this._b().ofAnimatedFire = bl;
        this._b().ofAnimatedFlame = bl;
        this._b().ofAnimatedWater = bl ? 0 : 2;
        this._b().ofAnimatedLava = bl ? 0 : 2;
        this._b().ofAnimatedSmoke = bl;
        this._b().ofAnimatedPortal = bl;
        this._b().ofAnimatedRedstone = bl;
        this._b().ofAnimatedTerrain = bl;
        this._b().ofAnimatedTextures = bl;
        this._b().ofDrippingWaterLava = bl;
        this._b().ofVoidParticles = bl;
        this._b().ofPortalParticles = bl;
        this._b().ofRainSplash = bl;
        this._b().ofPotionParticles = bl;
        this._b().particleSetting = bl ? 0 : 2;
        this._b().saveOptions();
    }

    public final void _c(boolean bl) {
        BetterGrassAndLeavesMod.renderBetterGrass.value = bl;
        BetterGrassAndLeavesMod.renderBetterGrass.write();
        Minecraft._E()._s._b();
    }

    public final void _f(int n) {
        this._b().ofTrees = n > 0 ? 2 : 1;
        this._b().saveOptions();
        BetterGrassAndLeavesMod.renderBetterLeaves.value = n > 0;
        BetterGrassAndLeavesMod.currentLeavesRenderer.setValue(n > 1 ? "Advanced" : "Standard");
        BetterGrassAndLeavesMod.useRoundedVanillaLeaves.value = n > 0;
        BetterGrassAndLeavesMod.renderBetterSeaweed.value = n > 0;
        Iterable iterable = BetterGrassAndLeavesMod.modOptions;
        for (Object t : iterable) {
            Option option = (Option)t;
            option.write();
        }
        Minecraft._E()._s._b();
    }

    public final void _a(float f) {
        this._b().setOptionFloatValue(EnumOptions.__aN, f);
        this._b().saveOptions();
    }

    public final void _d(boolean bl) {
        this._b().enableVsync = bl;
        this._b().saveOptions();
        Display.setVSyncEnabled(bl);
    }

    public final void _e(boolean bl) {
        this._b().advancedOpengl = bl;
        this._b().saveOptions();
        Minecraft._E()._s._g();
    }

    public final void _g(int n) {
        this._b().ofChunkLoading = n;
        this._b().saveOptions();
        this._b().updateChunkLoading();
    }

    public final void _f(boolean bl) {
        BetterGrassAndLeavesMod.averageGrassHeight.value = Float.valueOf(0.5f);
        BetterGrassAndLeavesMod.currentGrassRenderer.setValue("Standard");
        BetterGrassAndLeavesMod.renderGrassSides.setValue("OFF");
        BetterGrassAndLeavesMod.renderGrassFX.setValue("OFF");
        BetterGrassAndLeavesMod.waterSuspendedFX.setValue("OFF");
        BetterGrassAndLeavesMod.renderFootprintsFX.setValue("OFF");
        BetterGrassAndLeavesMod.renderLeavesFX.setValue("OFF");
        BetterGrassAndLeavesMod.bloodFX.value = true;
        BetterGrassAndLeavesMod.renderSnowedGrass.value = false;
        BetterGrassAndLeavesMod.renderBetterLadders.value = false;
        BetterGrassAndLeavesMod.renderBetterCacti.value = false;
        BetterGrassAndLeavesMod.renderBetterLilyPads.value = false;
        BetterGrassAndLeavesMod.renderBetterCorals.value = false;
        BetterGrassAndLeavesMod.renderSnowedLeaves.value = false;
        BetterGrassAndLeavesMod.renderOnlyOuterLeaves.value = true;
        if (bl) {
            Iterable iterable = BetterGrassAndLeavesMod.modOptions;
            for (Object t : iterable) {
                Option option = (Option)t;
                option.write();
            }
            Minecraft._E()._s._b();
        }
    }

    private uhip() {
        _a = this;
        _b = new ArrayList();
        _c = Integer.parseInt(System.getProperty("min_resourcepack_resolution", "5"));
    }

    static {
        new uhip();
    }
}

