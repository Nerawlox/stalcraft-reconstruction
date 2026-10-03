/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving;

import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.eidj;
import net.minecraft.client.xpzm;
import net.smart.moving.SmartMovingClient;
import net.smart.moving.SmartMovingFactory;
import net.smart.moving.SmartMovingServer;
import net.smart.moving.config.SmartMovingClientConfig;
import net.smart.moving.config.SmartMovingOptions;
import net.smart.moving.config.SmartMovingServerConfig;
import net.smart.moving.render.RenderPlayer;
import net.smart.render.SmartRenderContext;
import net.smart.render.statistics.SmartStatisticsContext;
import net.smart.utilities.Assert;
import net.smart.utilities.Install;
import net.smart.utilities.ResourcePack;

public abstract class SmartMovingContext
extends SmartRenderContext {
    public static final float ClimbPullMotion = 0.3f;
    public static final double FastUpMotion = 0.2;
    public static final double MediumUpMotion = 0.14;
    public static final double SlowUpMotion = 0.1;
    public static final double HoldMotion = 0.08;
    public static final double SinkDownMotion = 0.05;
    public static final double ClimbDownMotion = 0.01;
    public static final double CatchCrawlGapMotion = 0.17;
    public static final float SwimCrawlWaterMaxBorder = 1.0f;
    public static final float SwimCrawlWaterTopBorder = 0.65f;
    public static final float SwimCrawlWaterMediumBorder = 0.6f;
    public static final float SwimCrawlWaterBottomBorder = 0.55f;
    public static final float HorizontalGroundDamping = 0.546f;
    public static final float HorizontalAirDamping = 0.91f;
    public static final float HorizontalAirodynamicDamping = 0.999f;
    public static final float SwimSoundDistance = 1.4285715f;
    public static final float SlideToHeadJumpingFallDistance = 0.05f;
    public static final SmartMovingClient Client = new SmartMovingClient();
    public static final SmartMovingOptions Options = new SmartMovingOptions();
    public static final SmartMovingServerConfig ServerConfig = new SmartMovingServerConfig();
    public static SmartMovingClientConfig Config = Options;
    private static boolean wasInitialized;
    private static Set translateKeys;
    private static dzfd lastMinecraftServer;

    public static void onTickInGame() {
        xpzm xpzm2 = xpzm._E();
        if (xpzm2._r != null && xpzm2._r.field_72995_K) {
            SmartMovingFactory.handleMultiPlayerTick(xpzm2);
        }
        Options.initializeForGameIfNeccessary();
        SmartMovingContext.initializeServerIfNecessary();
    }

    public static void initialize(GameSettings gameSettings, boolean bl, Logger logger) {
        if (!wasInitialized) {
            if (bl) {
                Assert.client(logger);
                if (Install.hasMinecraftForge) {
                    Assert.warn(logger, SmartMovingContext.getModLoaderMessage("Minecraft Forge"));
                } else if (Install.hasModLoader) {
                    Assert.warn(logger, SmartMovingContext.getModLoaderMessage("ModLoader"));
                }
            }
            SmartStatisticsContext.setCalculateHorizontalStats(true);
        }
        eidj[] eidjArray = gameSettings.field_74324_K;
        int n = eidjArray.length;
        SmartMovingOptions smartMovingOptions = Options;
        gameSettings.field_74324_K = new eidj[n + (SmartMovingOptions.hasMoreKeyBindingGui ? 6 : 3)];
        eidj[] eidjArray2 = gameSettings.field_74324_K;
        int n2 = 0;
        int n3 = 0;
        while (n2 < eidjArray.length) {
            eidj eidj2 = eidjArray[n2];
            if (eidj2 == gameSettings.field_74311_E) {
                eidjArray2[n3++] = gameSettings.field_74311_E;
                eidjArray2[n3++] = SmartMovingContext.Options.keyBindGrab;
                eidjArray2[n3++] = SmartMovingContext.Options.keyBindSprint;
                eidjArray2[n3++] = SmartMovingContext.Options.keyBindCrawl;
                SmartMovingOptions smartMovingOptions2 = Options;
                if (SmartMovingOptions.hasMoreKeyBindingGui) {
                    eidjArray2[n3++] = SmartMovingContext.Options.keyBindConfigToggle;
                    eidjArray2[n3++] = SmartMovingContext.Options.keyBindSpeedIncrease;
                    eidjArray2[n3++] = SmartMovingContext.Options.keyBindSpeedDecrease;
                } else {
                    SmartMovingContext.releaseKeyBinding(SmartMovingContext.Options.keyBindConfigToggle);
                    SmartMovingContext.releaseKeyBinding(SmartMovingContext.Options.keyBindSpeedIncrease);
                    SmartMovingContext.releaseKeyBinding(SmartMovingContext.Options.keyBindSpeedDecrease);
                }
                --n3;
            } else {
                eidjArray2[n3] = eidj2;
            }
            ++n2;
            ++n3;
        }
        if (!wasInitialized) {
            if (bl) {
                SmartMovingContext.registerAnimation(null);
            }
            wasInitialized = true;
            ResourcePack.add("SmartMoving", "net/smart/resources", SmartMovingContext.class);
            System.out.println("Smart Moving uses communication protocol 2.3");
            if (logger != null) {
                logger.fine("Smart Moving uses communication protocol 2.3");
            }
        }
    }

    private static void releaseKeyBinding(eidj eidj2) {
        eidj._a.remove(eidj2);
        eidj._b._f(eidj2._d);
    }

    private static String[] getModLoaderMessage(String string) {
        return new String[]{"========================================", "Smart Moving detected " + string + "!", "----------------------------------------", "This Smart Moving standalone installation package should really not be used together with " + string + ".", "The Smart Moving installation package:", "\t\"Smart Moving Client for ModLoader or Minecraft Forge\"", "would be a much better choice for Smart Moving on a " + string + " Client.", "========================================"};
    }

    public static void initializeServerIfNecessary() {
        dzfd dzfd2 = dzfd._I();
        if (dzfd2 != null && dzfd2 != lastMinecraftServer) {
            SmartMovingServer.initialize(SmartMovingOptions.optionsPath, Install.getLogger(dzfd._I()._O()), dzfd2._r()._a(), Options);
        }
        lastMinecraftServer = dzfd2;
    }

    public static boolean registerAnimation(Map map) {
        return SmartRenderContext.registerAnimation(map, RenderPlayer.class);
    }

    static {
        lastMinecraftServer = null;
    }
}

