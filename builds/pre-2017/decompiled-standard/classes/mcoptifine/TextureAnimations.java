/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.imageio.ImageIO;
import mcoptifine.Config;
import mcoptifine.TextureAnimation;
import mcoptifine.TextureUtils;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.ResourceLocation;

public class TextureAnimations {
    private static TextureAnimation[] textureAnimations = null;

    public static void reset() {
        textureAnimations = null;
    }

    public static void update() {
        fnrl fnrl2 = Config.getResourcePack();
        textureAnimations = TextureAnimations.getTextureAnimations(fnrl2);
        TextureAnimations.updateAnimations();
    }

    public static void updateCustomAnimations() {
        if (textureAnimations != null && Config.isAnimatedTextures()) {
            TextureAnimations.updateAnimations();
        }
    }

    public static void updateAnimations() {
        if (textureAnimations != null) {
            for (int i = 0; i < textureAnimations.length; ++i) {
                TextureAnimation textureAnimation = textureAnimations[i];
                textureAnimation.updateTexture();
            }
        }
    }

    public static TextureAnimation[] getTextureAnimations(fnrl fnrl2) {
        if (!(fnrl2 instanceof nvkn)) {
            return null;
        }
        nvkn nvkn2 = (nvkn)fnrl2;
        File file = nvkn2.field_110597_b;
        if (file == null) {
            return null;
        }
        if (!file.exists()) {
            return null;
        }
        String[] stringArray = null;
        stringArray = file.isFile() ? TextureAnimations.getAnimationPropertiesZip(file) : TextureAnimations.getAnimationPropertiesDir(file);
        if (stringArray == null) {
            return null;
        }
        ArrayList<TextureAnimation> arrayList = new ArrayList<TextureAnimation>();
        for (int i = 0; i < stringArray.length; ++i) {
            String string = stringArray[i];
            Config.dbg("Texture animation: " + string);
            try {
                ResourceLocation resourceLocation = new ResourceLocation(string);
                InputStream inputStream = fnrl2.func_110590_a(resourceLocation);
                Properties properties = new Properties();
                properties.load(inputStream);
                TextureAnimation textureAnimation = TextureAnimations.makeTextureAnimation(properties, resourceLocation);
                if (textureAnimation == null) continue;
                arrayList.add(textureAnimation);
                continue;
            }
            catch (FileNotFoundException fileNotFoundException) {
                Config.warn("File not found: " + fileNotFoundException.getMessage());
                continue;
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        TextureAnimation[] textureAnimationArray = arrayList.toArray(new TextureAnimation[arrayList.size()]);
        return textureAnimationArray;
    }

    public static TextureAnimation makeTextureAnimation(Properties properties, ResourceLocation resourceLocation) {
        String string = properties.getProperty("from");
        String string2 = properties.getProperty("to");
        int n = Config.parseInt(properties.getProperty("x"), -1);
        int n2 = Config.parseInt(properties.getProperty("y"), -1);
        int n3 = Config.parseInt(properties.getProperty("w"), -1);
        int n4 = Config.parseInt(properties.getProperty("h"), -1);
        if (string != null && string2 != null) {
            if (n >= 0 && n2 >= 0 && n3 >= 0 && n4 >= 0) {
                String string3 = TextureUtils.getBasePath(resourceLocation.func_110623_a());
                string = TextureUtils.fixResourcePath(string, string3);
                string2 = TextureUtils.fixResourcePath(string2, string3);
                byte[] byArray = TextureAnimations.getCustomTextureData(string, n3);
                if (byArray == null) {
                    Config.warn("TextureAnimation: Source texture not found: " + string2);
                    return null;
                }
                ResourceLocation resourceLocation2 = new ResourceLocation(string2);
                if (!Config.hasResource(resourceLocation2, true)) {
                    Config.warn("TextureAnimation: Target texture not found: " + string2);
                    return null;
                }
                sctg sctg2 = TextureUtils.getTexture(resourceLocation2);
                if (sctg2 == null) {
                    Config.warn("TextureAnimation: Target texture not found: " + resourceLocation2);
                    return null;
                }
                int n5 = sctg2.func_110552_b();
                TextureAnimation textureAnimation = new TextureAnimation(string, byArray, string2, n5, n, n2, n3, n4, properties, 1);
                return textureAnimation;
            }
            Config.warn("TextureAnimation: Invalid coordinates");
            return null;
        }
        Config.warn("TextureAnimation: Source or target texture not specified");
        return null;
    }

    public static String[] getAnimationPropertiesDir(File file) {
        File file2 = new File(file, "anim");
        if (!file2.exists()) {
            return null;
        }
        if (!file2.isDirectory()) {
            return null;
        }
        File[] fileArray = file2.listFiles();
        if (fileArray == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 0; i < fileArray.length; ++i) {
            File file3 = fileArray[i];
            String string = file3.getName();
            if (string.startsWith("custom_") || !string.endsWith(".properties") || !file3.isFile() || !file3.canRead()) continue;
            Config.dbg("TextureAnimation: anim/" + file3.getName());
            arrayList.add("/anim/" + string);
        }
        String[] stringArray = arrayList.toArray(new String[arrayList.size()]);
        return stringArray;
    }

    public static String[] getAnimationPropertiesZip(File file) {
        try {
            String[] stringArray;
            ZipFile zipFile = new ZipFile(file);
            Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
            ArrayList<String> arrayList = new ArrayList<String>();
            while (enumeration.hasMoreElements()) {
                stringArray = enumeration.nextElement();
                String string = stringArray.getName();
                if (!string.startsWith("assets/minecraft/mcpatcher/anim/") || string.startsWith("assets/minecraft/mcpatcher/anim/custom_") || !string.endsWith(".properties")) continue;
                String string2 = "assets/minecraft/";
                string = string.substring(string2.length());
                arrayList.add(string);
            }
            stringArray = arrayList.toArray(new String[arrayList.size()]);
            return stringArray;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return null;
        }
    }

    public static byte[] getCustomTextureData(String string, int n) {
        byte[] byArray = TextureAnimations.loadImage(string, n);
        if (byArray == null) {
            byArray = TextureAnimations.loadImage("/anim" + string, n);
        }
        return byArray;
    }

    private static byte[] loadImage(String string, int n) {
        GameSettings gameSettings = Config.getGameSettings();
        try {
            ResourceLocation resourceLocation = new ResourceLocation(string);
            InputStream inputStream = Config.getResourceStream(resourceLocation);
            if (inputStream == null) {
                return null;
            }
            BufferedImage bufferedImage = TextureAnimations.readTextureImage(inputStream);
            if (bufferedImage == null) {
                return null;
            }
            if (n > 0 && bufferedImage.getWidth() != n) {
                double d = bufferedImage.getHeight() / bufferedImage.getWidth();
                int n2 = (int)((double)n * d);
                bufferedImage = TextureAnimations.scaleBufferedImage(bufferedImage, n, n2);
            }
            int n3 = bufferedImage.getWidth();
            int n4 = bufferedImage.getHeight();
            int[] nArray = new int[n3 * n4];
            byte[] byArray = new byte[n3 * n4 * 4];
            bufferedImage.getRGB(0, 0, n3, n4, nArray, 0, n3);
            for (int i = 0; i < nArray.length; ++i) {
                int n5 = nArray[i] >> 24 & 0xFF;
                int n6 = nArray[i] >> 16 & 0xFF;
                int n7 = nArray[i] >> 8 & 0xFF;
                int n8 = nArray[i] & 0xFF;
                if (gameSettings != null && gameSettings.field_74337_g) {
                    int n9 = (n6 * 30 + n7 * 59 + n8 * 11) / 100;
                    int n10 = (n6 * 30 + n7 * 70) / 100;
                    int n11 = (n6 * 30 + n8 * 70) / 100;
                    n6 = n9;
                    n7 = n10;
                    n8 = n11;
                }
                byArray[i * 4 + 0] = (byte)n6;
                byArray[i * 4 + 1] = (byte)n7;
                byArray[i * 4 + 2] = (byte)n8;
                byArray[i * 4 + 3] = (byte)n5;
            }
            return byArray;
        }
        catch (FileNotFoundException fileNotFoundException) {
            return null;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    private static BufferedImage readTextureImage(InputStream inputStream) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        inputStream.close();
        return bufferedImage;
    }

    public static BufferedImage scaleBufferedImage(BufferedImage bufferedImage, int n, int n2) {
        BufferedImage bufferedImage2 = new BufferedImage(n, n2, 2);
        Graphics2D graphics2D = bufferedImage2.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.drawImage(bufferedImage, 0, 0, n, n2, null);
        return bufferedImage2;
    }
}

