/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client;

import com.google.common.base.Charsets;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.ModContainer;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import javax.imageio.ImageIO;

public class FMLFolderResourcePack
extends yvjs {
    private ModContainer container;

    public FMLFolderResourcePack(ModContainer modContainer) {
        super(modContainer.getSource());
        this.container = modContainer;
    }

    @Override
    public String getPackName() {
        return "FMLFileResourcePack:" + this.container.getName();
    }

    @Override
    protected InputStream getInputStreamByName(String string) throws IOException {
        try {
            return super.getInputStreamByName(string);
        }
        catch (IOException iOException) {
            if ("pack.mcmeta".equals(string)) {
                FMLLog.log(this.container.getName(), Level.WARNING, "Mod %s is missing a pack.mcmeta file, things may not work well", this.container.getName());
                return new ByteArrayInputStream(("{\n \"pack\": {\n   \"description\": \"dummy FML pack for " + this.container.getName() + "\",\n" + "   \"pack_format\": 1\n" + "}\n" + "}").getBytes(Charsets.UTF_8));
            }
            throw iOException;
        }
    }

    @Override
    public BufferedImage getPackImage() throws IOException {
        return ImageIO.read(this.getInputStreamByName(this.container.getMetadata().logoFile));
    }
}

