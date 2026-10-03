/*
 * Decompiled with CFR 0.152.
 */
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Set;
import net.minecraft.client.resources.data.MetadataSection;
import net.minecraft.client.resources.data.MetadataSerializer;
import net.minecraft.util.ResourceLocation;

public interface fnrl {
    public InputStream getInputStream(ResourceLocation var1);

    public boolean resourceExists(ResourceLocation var1);

    public Set getResourceDomains();

    public MetadataSection getPackMetadata(MetadataSerializer var1, String var2);

    public BufferedImage getPackImage();

    public String getPackName();
}

