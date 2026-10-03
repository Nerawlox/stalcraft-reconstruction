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
import net.minecraft.client.xpzm;
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
    public BufferedImage func_110586_a() throws IOException {
        return null;
    }

    @Override
    public Set func_110587_b() {
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add(this.name);
        return hashSet;
    }

    @Override
    public boolean func_110589_b(ResourceLocation resourceLocation) {
        try {
            return this.func_110590_a(resourceLocation) != null;
        }
        catch (IOException iOException) {
            return false;
        }
    }

    @Override
    public InputStream func_110590_a(ResourceLocation resourceLocation) throws IOException {
        return this.getClass().getResourceAsStream("/" + this.path + "/" + resourceLocation.func_110623_a());
    }

    @Override
    public String func_130077_b() {
        return this.name;
    }

    @Override
    public gqyj func_135058_a(rqxe rqxe2, String string) throws IOException {
        return null;
    }

    public static void remove(String string) {
        List list2 = ResourcePack.getResourcePacks();
        Iterator iterator2 = list2.iterator();
        while (iterator2.hasNext()) {
            Object e = iterator2.next();
            if (!(e instanceof fnrl) || !string.equals(((fnrl)e).func_130077_b())) continue;
            iterator2.remove();
        }
    }

    public static void add(String string, String string2, Class clazz) {
        ResourcePack.getResourcePacks().add(new ResourcePack(string, string2, clazz));
    }

    private static List getResourcePacks() {
        return (List)Reflect.GetField(xpzm.class, xpzm._E(), Install.Minecraft_resourcePacks);
    }
}

