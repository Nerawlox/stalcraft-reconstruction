/*
 * Decompiled with CFR 0.152.
 */
package net.smart.utilities;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.data.MetadataSection;
import net.minecraft.client.resources.data.MetadataSerializer;
import net.minecraft.util.ResourceLocation;
import net.smart.utilities.Install;
import net.smart.utilities.Reflect;

public class ResourcePack
implements fnrl {
    private final String name;
    private final String path;
    private final Class source;

    private ResourcePack(String string, String string2, Class clazz) {
        this.name = string;
        this.path = string2;
        this.source = clazz;
    }

    @Override
    public BufferedImage getPackImage() throws IOException {
        return null;
    }

    @Override
    public Set getResourceDomains() {
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add(this.name);
        return hashSet;
    }

    @Override
    public boolean resourceExists(ResourceLocation resourceLocation) {
        try {
            return this.getInputStream(resourceLocation) != null;
        }
        catch (IOException iOException) {
            return false;
        }
    }

    @Override
    public InputStream getInputStream(ResourceLocation resourceLocation) throws IOException {
        return this.getClass().getResourceAsStream("/" + this.path + "/" + resourceLocation.getResourcePath());
    }

    @Override
    public String getPackName() {
        return this.name;
    }

    @Override
    public MetadataSection getPackMetadata(MetadataSerializer metadataSerializer, String string) throws IOException {
        return null;
    }

    public static void remove(String string) {
        List list2 = ResourcePack.getResourcePacks();
        Iterator iterator2 = list2.iterator();
        while (iterator2.hasNext()) {
            Object e = iterator2.next();
            if (!(e instanceof fnrl) || !string.equals(((fnrl)e).getPackName())) continue;
            iterator2.remove();
        }
    }

    public static void add(String string, String string2, Class clazz) {
        ResourcePack.getResourcePacks().add(new ResourcePack(string, string2, clazz));
    }

    private static List getResourcePacks() {
        return (List)Reflect.GetField(Minecraft.class, Minecraft._E(), Install.Minecraft_resourcePacks);
    }
}

