/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.resources;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;
import javax.imageio.ImageIO;
import net.minecraft.client.resources.AbstractResourcePack;
import net.minecraft.client.resources.data.MetadataSection;
import net.minecraft.client.resources.data.MetadataSerializer;
import net.minecraft.util.ResourceLocation;

public class DefaultResourcePack
implements fnrl {
    public static final Set _a = ImmutableSet.of("minecraft");
    public final Map _b = Maps.newHashMap();
    public final File _c;

    public DefaultResourcePack(File file) {
        this._c = file;
        this._a(this._c);
    }

    @Override
    public InputStream getInputStream(ResourceLocation resourceLocation) {
        InputStream inputStream = this._a(resourceLocation);
        if (inputStream != null) {
            return inputStream;
        }
        File file = (File)this._b.get(resourceLocation.toString());
        if (file != null) {
            return new FileInputStream(file);
        }
        throw new FileNotFoundException(resourceLocation.getResourcePath());
    }

    public InputStream _a(ResourceLocation resourceLocation) {
        return DefaultResourcePack.class.getResourceAsStream("/assets/minecraft/" + resourceLocation.getResourcePath());
    }

    public void _a(String string, File file) {
        this._b.put(new ResourceLocation(string).toString(), file);
    }

    @Override
    public boolean resourceExists(ResourceLocation resourceLocation) {
        return this._a(resourceLocation) != null || this._b.containsKey(resourceLocation.toString());
    }

    @Override
    public Set getResourceDomains() {
        return _a;
    }

    public void _a(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                this._a(file2);
            }
        } else {
            this._a(AbstractResourcePack.getRelativeName(this._c, file), file);
        }
    }

    @Override
    public MetadataSection getPackMetadata(MetadataSerializer metadataSerializer, String string) {
        return AbstractResourcePack.readMetadata(metadataSerializer, DefaultResourcePack.class.getResourceAsStream("/" + new ResourceLocation("pack.mcmeta").getResourcePath()), string);
    }

    @Override
    public BufferedImage getPackImage() {
        return ImageIO.read(DefaultResourcePack.class.getResourceAsStream("/" + new ResourceLocation("pack.png").getResourcePath()));
    }

    @Override
    public String getPackName() {
        return "Default";
    }
}

