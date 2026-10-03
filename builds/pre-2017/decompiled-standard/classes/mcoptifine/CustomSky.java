/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import mcoptifine.Config;
import mcoptifine.CustomSkyLayer;
import mcoptifine.TextureUtils;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CustomSky {
    private static CustomSkyLayer[][] worldSkyLayers = null;

    public static void reset() {
        worldSkyLayers = null;
    }

    public static void update() {
        CustomSky.reset();
        if (Config.isCustomSky()) {
            worldSkyLayers = CustomSky.readCustomSkies();
        }
    }

    private static CustomSkyLayer[][] readCustomSkies() {
        CustomSkyLayer[][] customSkyLayerArray;
        int n;
        CustomSkyLayer[][] customSkyLayerArray2 = new CustomSkyLayer[10][0];
        String string = "mcpatcher/sky/world";
        int n2 = -1;
        for (n = 0; n < customSkyLayerArray2.length; ++n) {
            CustomSkyLayer[] customSkyLayerArray3;
            customSkyLayerArray = string + n + "/sky";
            ArrayList<CustomSkyLayer> arrayList = new ArrayList<CustomSkyLayer>();
            for (int i = 1; i < 1000; ++i) {
                customSkyLayerArray3 = (String)customSkyLayerArray + i + ".properties";
                try {
                    ResourceLocation resourceLocation = new ResourceLocation((String)customSkyLayerArray3);
                    InputStream inputStream = Config.getResourceStream(resourceLocation);
                    if (inputStream == null) break;
                    Properties properties = new Properties();
                    properties.load(inputStream);
                    Config.dbg("CustomSky properties: " + (String)customSkyLayerArray3);
                    String string2 = (String)customSkyLayerArray + i + ".png";
                    CustomSkyLayer customSkyLayer = new CustomSkyLayer(properties, string2);
                    if (!customSkyLayer.isValid((String)customSkyLayerArray3)) continue;
                    ResourceLocation resourceLocation2 = new ResourceLocation(customSkyLayer.source);
                    sctg sctg2 = TextureUtils.getTexture(resourceLocation2);
                    if (sctg2 == null) {
                        Config.log("CustomSky: Texture not found: " + resourceLocation2);
                        continue;
                    }
                    customSkyLayer.textureId = sctg2.func_110552_b();
                    arrayList.add(customSkyLayer);
                    inputStream.close();
                    continue;
                }
                catch (FileNotFoundException fileNotFoundException) {
                    break;
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
            if (arrayList.size() <= 0) continue;
            customSkyLayerArray3 = arrayList.toArray(new CustomSkyLayer[arrayList.size()]);
            customSkyLayerArray2[n] = customSkyLayerArray3;
            n2 = n;
        }
        if (n2 < 0) {
            return null;
        }
        n = n2 + 1;
        customSkyLayerArray = new CustomSkyLayer[n][0];
        for (int i = 0; i < customSkyLayerArray.length; ++i) {
            customSkyLayerArray[i] = customSkyLayerArray2[i];
        }
        return customSkyLayerArray;
    }

    public static void renderSky(ozlu ozlu2, apbu apbu2, float f, float f2) {
        CustomSkyLayer[] customSkyLayerArray;
        int n;
        if (worldSkyLayers != null && Config.getGameSettings().ofRenderDistanceFine >= 128 && (n = ozlu2.field_73011_w._i) >= 0 && n < worldSkyLayers.length && (customSkyLayerArray = worldSkyLayers[n]) != null) {
            long l = ozlu2.func_72820_D();
            int n2 = (int)(l % 24000L);
            for (int i = 0; i < customSkyLayerArray.length; ++i) {
                CustomSkyLayer customSkyLayer = customSkyLayerArray[i];
                if (!customSkyLayer.isActive(n2)) continue;
                customSkyLayer.render(n2, f, f2);
            }
            CustomSky.clearBlend(f2);
        }
    }

    public static boolean hasSkyLayers(ozlu ozlu2) {
        if (worldSkyLayers == null) {
            return false;
        }
        if (Config.getGameSettings().ofRenderDistanceFine < 128) {
            return false;
        }
        int n = ozlu2.field_73011_w._i;
        if (n >= 0 && n < worldSkyLayers.length) {
            CustomSkyLayer[] customSkyLayerArray = worldSkyLayers[n];
            return customSkyLayerArray == null ? false : customSkyLayerArray.length > 0;
        }
        return false;
    }

    private static void clearBlend(float f) {
        GL11.glDisable(3008);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 1);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, f);
    }
}

