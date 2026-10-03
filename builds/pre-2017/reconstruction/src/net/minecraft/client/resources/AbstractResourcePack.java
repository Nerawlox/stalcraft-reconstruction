/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.resources;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.data.MetadataSection;
import net.minecraft.client.resources.data.MetadataSerializer;
import net.minecraft.logging.ILogAgent;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.IOUtils;

public abstract class AbstractResourcePack
implements fnrl {
    public static final ILogAgent resourceLog = Minecraft._E()._O();
    public final File resourcePackFile;

    public AbstractResourcePack(File file) {
        this.resourcePackFile = file;
    }

    public static String locationToName(ResourceLocation resourceLocation) {
        return String.format("%s/%s/%s", "assets", resourceLocation.getResourceDomain(), resourceLocation.getResourcePath());
    }

    public static String getRelativeName(File file, File file2) {
        return file.toURI().relativize(file2.toURI()).getPath();
    }

    @Override
    public InputStream getInputStream(ResourceLocation resourceLocation) {
        return this.getInputStreamByName(AbstractResourcePack.locationToName(resourceLocation));
    }

    @Override
    public boolean resourceExists(ResourceLocation resourceLocation) {
        return this.hasResourceName(AbstractResourcePack.locationToName(resourceLocation));
    }

    public abstract InputStream getInputStreamByName(String var1);

    public abstract boolean hasResourceName(String var1);

    public void logNameNotLowercase(String string) {
        resourceLog._a("ResourcePack: ignored non-lowercase namespace: %s in %s", string, this.resourcePackFile);
    }

    @Override
    public MetadataSection getPackMetadata(MetadataSerializer metadataSerializer, String string) {
        return AbstractResourcePack.readMetadata(metadataSerializer, this.getInputStreamByName("pack.mcmeta"), string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static MetadataSection readMetadata(MetadataSerializer metadataSerializer, InputStream inputStream, String string) {
        JsonObject jsonObject = null;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            jsonObject = new JsonParser().parse(bufferedReader).getAsJsonObject();
        }
        catch (Throwable throwable) {
            IOUtils.closeQuietly(bufferedReader);
            throw throwable;
        }
        IOUtils.closeQuietly(bufferedReader);
        return metadataSerializer._a(string, jsonObject);
    }

    @Override
    public BufferedImage getPackImage() {
        return ImageIO.read(this.getInputStreamByName("pack.png"));
    }

    @Override
    public String getPackName() {
        return this.resourcePackFile.getName();
    }
}

