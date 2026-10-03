/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import mcoptifine.Config;
import mcoptifine.TextureUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RandomMobs {
    private static Map textureVariantsMap = new HashMap();
    private static cvgz renderGlobal = null;
    private static boolean initialized = false;
    private static Random random = new Random();
    private static Field fieldEntityUuid = RandomMobs.getField(Entity.class, UUID.class);
    private static boolean working = false;

    public static void entityLoaded(Entity entity) {
        if (entity instanceof EntityLiving) {
            Entity entity2;
            EntityLiving entityLiving = (EntityLiving)entity;
            yfgy yfgy2 = Config.getWorldServer();
            if (yfgy2 != null && (entity2 = yfgy2.func_73045_a(entity.field_70157_k)) instanceof EntityLiving) {
                EntityLiving entityLiving2 = (EntityLiving)entity2;
                if (fieldEntityUuid != null) {
                    try {
                        Object object = fieldEntityUuid.get(entityLiving2);
                        fieldEntityUuid.set(entityLiving, object);
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                        fieldEntityUuid = null;
                    }
                }
            }
        }
    }

    private static Field getField(Class clazz, Class clazz2) {
        try {
            Field[] fieldArray = clazz.getDeclaredFields();
            for (int i = 0; i < fieldArray.length; ++i) {
                Field field = fieldArray[i];
                Class<?> clazz3 = field.getType();
                if (clazz3 != clazz2) continue;
                field.setAccessible(true);
                return field;
            }
            return null;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static void worldChanged(ozlu ozlu2, ozlu ozlu3) {
        if (ozlu3 != null) {
            List list = ozlu3.func_72910_y();
            for (int i = 0; i < list.size(); ++i) {
                Entity entity = (Entity)list.get(i);
                RandomMobs.entityLoaded(entity);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ResourceLocation getTextureLocation(ResourceLocation resourceLocation) {
        ResourceLocation resourceLocation2;
        if (working) {
            return resourceLocation;
        }
        try {
            working = true;
            if (!initialized) {
                RandomMobs.initialize();
            }
            if (renderGlobal == null) {
                ResourceLocation resourceLocation3;
                ResourceLocation resourceLocation4 = resourceLocation3 = resourceLocation;
                return resourceLocation4;
            }
            Entity entity = RandomMobs.renderGlobal.__af;
            if (entity != null) {
                ResourceLocation resourceLocation5;
                if (!(entity instanceof EntityLiving)) {
                    ResourceLocation resourceLocation6;
                    ResourceLocation resourceLocation7 = resourceLocation6 = resourceLocation;
                    return resourceLocation7;
                }
                String string = resourceLocation.func_110623_a();
                if (!string.startsWith("textures/entity/")) {
                    ResourceLocation resourceLocation8;
                    ResourceLocation resourceLocation9 = resourceLocation8 = resourceLocation;
                    return resourceLocation9;
                }
                long l = entity.func_110124_au().getLeastSignificantBits();
                int n = (int)(l & Integer.MAX_VALUE);
                ResourceLocation resourceLocation10 = resourceLocation5 = RandomMobs.getTextureLocation(resourceLocation, n);
                return resourceLocation10;
            }
            resourceLocation2 = resourceLocation;
        }
        finally {
            working = false;
        }
        return resourceLocation2;
    }

    private static ResourceLocation getTextureLocation(ResourceLocation resourceLocation, int n) {
        if (n <= 0) {
            return resourceLocation;
        }
        String string = resourceLocation.func_110623_a();
        ResourceLocation[] resourceLocationArray = (ResourceLocation[])textureVariantsMap.get(string);
        if (resourceLocationArray == null) {
            resourceLocationArray = RandomMobs.getTextureVariants(resourceLocation);
            textureVariantsMap.put(string, resourceLocationArray);
        }
        if (resourceLocationArray != null && resourceLocationArray.length > 0) {
            int n2 = n % resourceLocationArray.length;
            ResourceLocation resourceLocation2 = resourceLocationArray[n2];
            return resourceLocation2;
        }
        return resourceLocation;
    }

    private static ResourceLocation[] getTextureVariants(ResourceLocation resourceLocation) {
        TextureUtils.getTexture(resourceLocation);
        ResourceLocation[] resourceLocationArray = new ResourceLocation[]{};
        String string = resourceLocation.func_110623_a();
        int n = string.lastIndexOf(46);
        if (n < 0) {
            return resourceLocationArray;
        }
        String string2 = string.substring(0, n);
        String string3 = string.substring(n);
        String string4 = "textures/entity/";
        if (!string2.startsWith(string4)) {
            return resourceLocationArray;
        }
        string2 = string2.substring(string4.length());
        string2 = "mcpatcher/mob/" + string2;
        int n2 = RandomMobs.getCountTextureVariants(string2, string3);
        if (n2 <= 1) {
            return resourceLocationArray;
        }
        resourceLocationArray = new ResourceLocation[n2];
        resourceLocationArray[0] = resourceLocation;
        for (int i = 1; i < resourceLocationArray.length; ++i) {
            int n3 = i + 1;
            String string5 = string2 + n3 + string3;
            resourceLocationArray[i] = new ResourceLocation(resourceLocation.func_110624_b(), string5);
            TextureUtils.getTexture(resourceLocationArray[i]);
        }
        Config.dbg("RandomMobs: " + resourceLocation + ", variants: " + resourceLocationArray.length);
        return resourceLocationArray;
    }

    private static int getCountTextureVariants(String string, String string2) {
        int n = 1000;
        for (int i = 2; i < n; ++i) {
            String string3 = string + i + string2;
            ResourceLocation resourceLocation = new ResourceLocation(string3);
            if (Config.hasResource(resourceLocation)) continue;
            return i - 1;
        }
        return n;
    }

    public static void resetTextures() {
        textureVariantsMap.clear();
        if (Config.isRandomMobs()) {
            RandomMobs.initialize();
        }
    }

    private static void initialize() {
        renderGlobal = Config.getRenderGlobal();
        if (renderGlobal != null) {
            initialized = true;
            ArrayList<String> arrayList = new ArrayList<String>();
            arrayList.add("bat");
            arrayList.add("blaze");
            arrayList.add("cat/black");
            arrayList.add("cat/ocelot");
            arrayList.add("cat/red");
            arrayList.add("cat/siamese");
            arrayList.add("chicken");
            arrayList.add("cow/cow");
            arrayList.add("cow/mooshroom");
            arrayList.add("creeper/creeper");
            arrayList.add("enderman/enderman");
            arrayList.add("enderman/enderman_eyes");
            arrayList.add("ghast/ghast");
            arrayList.add("ghast/ghast_shooting");
            arrayList.add("iron_golem");
            arrayList.add("pig/pig");
            arrayList.add("sheep/sheep");
            arrayList.add("sheep/sheep_fur");
            arrayList.add("silverfish");
            arrayList.add("skeleton/skeleton");
            arrayList.add("skeleton/wither_skeleton");
            arrayList.add("slime/slime");
            arrayList.add("slime/magmacube");
            arrayList.add("snowman");
            arrayList.add("spider/cave_spider");
            arrayList.add("spider/spider");
            arrayList.add("spider_eyes");
            arrayList.add("squid");
            arrayList.add("villager/villager");
            arrayList.add("villager/butcher");
            arrayList.add("villager/farmer");
            arrayList.add("villager/librarian");
            arrayList.add("villager/priest");
            arrayList.add("villager/smith");
            arrayList.add("wither/wither");
            arrayList.add("wither/wither_armor");
            arrayList.add("wither/wither_invulnerable");
            arrayList.add("wolf/wolf");
            arrayList.add("wolf/wolf_angry");
            arrayList.add("wolf/wolf_collar");
            arrayList.add("wolf/wolf_tame");
            arrayList.add("zombie_pigman");
            arrayList.add("zombie/zombie");
            arrayList.add("zombie/zombie_villager");
            for (int i = 0; i < arrayList.size(); ++i) {
                String string = (String)arrayList.get(i);
                String string2 = "textures/entity/" + string + ".png";
                ResourceLocation resourceLocation = new ResourceLocation(string2);
                if (!Config.hasResource(resourceLocation)) {
                    Config.warn("Not found: " + resourceLocation);
                }
                RandomMobs.getTextureLocation(resourceLocation, 100);
            }
        }
    }
}

