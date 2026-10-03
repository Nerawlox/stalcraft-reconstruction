/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import mcoptifine.Config;
import mcoptifine.NaturalProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.dwan;

public class NaturalTextures {
    private static NaturalProperties[] propertiesByIndex = new NaturalProperties[0];

    public static void update() {
        propertiesByIndex = new NaturalProperties[0];
        if (Config.isNaturalTextures()) {
            String string = "optifine/natural.properties";
            try {
                ResourceLocation resourceLocation = new ResourceLocation(string);
                if (!Config.hasResource(resourceLocation, false)) {
                    Config.dbg("NaturalTextures: configuration \"" + string + "\" not found");
                    propertiesByIndex = NaturalTextures.makeDefaultProperties();
                    return;
                }
                InputStream inputStream = Config.getResourceStream(resourceLocation);
                ArrayList<NaturalProperties> arrayList = new ArrayList<NaturalProperties>(256);
                String string2 = Config.readInputStream(inputStream);
                inputStream.close();
                String[] stringArray = Config.tokenize(string2, "\n\r");
                Config.dbg("Natural Textures: Parsing configuration \"" + string + "\"");
                for (int i = 0; i < stringArray.length; ++i) {
                    String string3 = stringArray[i].trim();
                    if (string3.startsWith("#")) continue;
                    String[] stringArray2 = Config.tokenize(string3, "=");
                    if (stringArray2.length != 2) {
                        Config.warn("Natural Textures: Invalid \"" + string + "\" line: " + string3);
                        continue;
                    }
                    String string4 = stringArray2[0].trim();
                    String string5 = stringArray2[1].trim();
                    dhji dhji2 = sctd._f._f(string4);
                    if (dhji2 == null) {
                        Config.warn("Natural Textures: Texture not found: \"" + string + "\" line: " + string3);
                        continue;
                    }
                    int n = dhji2.getIndexInMap();
                    if (n < 0) {
                        Config.warn("Natural Textures: Invalid \"" + string + "\" line: " + string3);
                        continue;
                    }
                    NaturalProperties naturalProperties = new NaturalProperties(string5);
                    if (!naturalProperties.isValid()) continue;
                    while (arrayList.size() <= n) {
                        arrayList.add(null);
                    }
                    arrayList.set(n, naturalProperties);
                }
                propertiesByIndex = arrayList.toArray(new NaturalProperties[arrayList.size()]);
            }
            catch (FileNotFoundException fileNotFoundException) {
                Config.warn("NaturalTextures: configuration \"" + string + "\" not found");
                propertiesByIndex = NaturalTextures.makeDefaultProperties();
                return;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public static NaturalProperties getNaturalProperties(dwan dwan2) {
        if (!(dwan2 instanceof dhji)) {
            return null;
        }
        dhji dhji2 = (dhji)dwan2;
        int n = dhji2.getIndexInMap();
        if (n >= 0 && n < propertiesByIndex.length) {
            NaturalProperties naturalProperties = propertiesByIndex[n];
            return naturalProperties;
        }
        return null;
    }

    private static NaturalProperties[] makeDefaultProperties() {
        if (Config.getResourcePack() != Config.getDefaultResourcePack()) {
            Config.dbg("NaturalTextures: Texture pack is not default, ignoring default configuration.");
            return new NaturalProperties[0];
        }
        Config.dbg("Natural Textures: Using default configuration.");
        ArrayList arrayList = new ArrayList();
        NaturalTextures.setIconProperties(arrayList, "grass_top", "4F");
        NaturalTextures.setIconProperties(arrayList, "stone", "2F");
        NaturalTextures.setIconProperties(arrayList, "dirt", "4F");
        NaturalTextures.setIconProperties(arrayList, "grass_side", "F");
        NaturalTextures.setIconProperties(arrayList, "grass_side_overlay", "F");
        NaturalTextures.setIconProperties(arrayList, "stone_slab_top", "F");
        NaturalTextures.setIconProperties(arrayList, "bedrock", "2F");
        NaturalTextures.setIconProperties(arrayList, "sand", "4F");
        NaturalTextures.setIconProperties(arrayList, "gravel", "2");
        NaturalTextures.setIconProperties(arrayList, "log_oak", "2F");
        NaturalTextures.setIconProperties(arrayList, "log_oak_top", "4F");
        NaturalTextures.setIconProperties(arrayList, "gold_ore", "2F");
        NaturalTextures.setIconProperties(arrayList, "iron_ore", "2F");
        NaturalTextures.setIconProperties(arrayList, "coal_ore", "2F");
        NaturalTextures.setIconProperties(arrayList, "diamond_ore", "2F");
        NaturalTextures.setIconProperties(arrayList, "redstone_ore", "2F");
        NaturalTextures.setIconProperties(arrayList, "lapis_ore", "2F");
        NaturalTextures.setIconProperties(arrayList, "obsidian", "4F");
        NaturalTextures.setIconProperties(arrayList, "leaves_oak", "2F");
        NaturalTextures.setIconProperties(arrayList, "leaves_oak_opaque", "2F");
        NaturalTextures.setIconProperties(arrayList, "leaves_jungle", "2");
        NaturalTextures.setIconProperties(arrayList, "leaves_jungle_opaque", "2");
        NaturalTextures.setIconProperties(arrayList, "snow", "4F");
        NaturalTextures.setIconProperties(arrayList, "grass_side_snowed", "F");
        NaturalTextures.setIconProperties(arrayList, "cactus_side", "2F");
        NaturalTextures.setIconProperties(arrayList, "clay", "4F");
        NaturalTextures.setIconProperties(arrayList, "mycelium_side", "F");
        NaturalTextures.setIconProperties(arrayList, "mycelium_top", "4F");
        NaturalTextures.setIconProperties(arrayList, "farmland_wet", "2F");
        NaturalTextures.setIconProperties(arrayList, "farmland_dry", "2F");
        NaturalTextures.setIconProperties(arrayList, "netherrack", "4F");
        NaturalTextures.setIconProperties(arrayList, "soul_sand", "4F");
        NaturalTextures.setIconProperties(arrayList, "glowstone", "4");
        NaturalTextures.setIconProperties(arrayList, "log_spruce", "2F");
        NaturalTextures.setIconProperties(arrayList, "log_birch", "F");
        NaturalTextures.setIconProperties(arrayList, "leaves_spruce", "2F");
        NaturalTextures.setIconProperties(arrayList, "leaves_spruce_opaque", "2F");
        NaturalTextures.setIconProperties(arrayList, "log_jungle", "2F");
        NaturalTextures.setIconProperties(arrayList, "end_stone", "4");
        NaturalTextures.setIconProperties(arrayList, "sandstone_top", "4");
        NaturalTextures.setIconProperties(arrayList, "sandstone_bottom", "4F");
        NaturalTextures.setIconProperties(arrayList, "redstone_lamp_on", "4F");
        NaturalProperties[] naturalPropertiesArray = arrayList.toArray(new NaturalProperties[arrayList.size()]);
        return naturalPropertiesArray;
    }

    private static void setIconProperties(List list2, String string, String string2) {
        sctd sctd2 = sctd._f;
        dhji dhji2 = sctd2._f(string);
        if (dhji2 == null) {
            Config.warn("*** NaturalProperties: Icon not found: " + string + " ***");
        } else if (!(dhji2 instanceof dhji)) {
            Config.warn("*** NaturalProperties: Icon is not IconStitched: " + string + ": " + dhji2.getClass().getName() + " ***");
        } else {
            dhji dhji3 = dhji2;
            int n = dhji3.getIndexInMap();
            if (n < 0) {
                Config.warn("*** NaturalProperties: Invalid index for icon: " + string + ": " + n + " ***");
            } else {
                while (n >= list2.size()) {
                    list2.add(null);
                }
                NaturalProperties naturalProperties = new NaturalProperties(string2);
                list2.set(n, naturalProperties);
            }
        }
    }
}

