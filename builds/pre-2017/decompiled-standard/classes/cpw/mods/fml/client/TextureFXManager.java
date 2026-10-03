/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client;

import com.google.common.collect.Maps;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.Map;
import net.minecraft.client.xpzm;

public class TextureFXManager {
    private static final TextureFXManager INSTANCE = new TextureFXManager();
    private xpzm client;
    private Map<Integer, TextureHolder> texturesById = Maps.newHashMap();
    private Map<String, TextureHolder> texturesByName = Maps.newHashMap();

    void setClient(xpzm xpzm2) {
        this.client = xpzm2;
    }

    public static TextureFXManager instance() {
        return INSTANCE;
    }

    public void fixTransparency(BufferedImage bufferedImage, String string) {
        if (string.matches("^/mob/.*_eyes.*.png$")) {
            for (int i = 0; i < bufferedImage.getWidth(); ++i) {
                for (int j = 0; j < bufferedImage.getHeight(); ++j) {
                    int n = bufferedImage.getRGB(i, j);
                    if ((n & 0xFF000000) != 0 || n == 0) continue;
                    bufferedImage.setRGB(i, j, 0);
                }
            }
        }
    }

    public void bindTextureToName(String string, int n) {
        TextureHolder textureHolder = new TextureHolder();
        textureHolder.textureId = n;
        textureHolder.textureName = string;
        this.texturesById.put(n, textureHolder);
        this.texturesByName.put(string, textureHolder);
    }

    public void setTextureDimensions(int n, int n2, int n3) {
        TextureHolder textureHolder = this.texturesById.get(n);
        if (textureHolder == null) {
            return;
        }
        textureHolder.x = n2;
        textureHolder.y = n3;
    }

    public Dimension getTextureDimensions(String string) {
        return this.texturesByName.containsKey(string) ? new Dimension(this.texturesByName.get(string).x, this.texturesByName.get(string).y) : new Dimension(1, 1);
    }

    private class TextureHolder {
        private int textureId;
        private String textureName;
        private int x;
        private int y;

        private TextureHolder() {
        }
    }
}

