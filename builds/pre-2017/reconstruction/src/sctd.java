/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import gloomyfolken.mods.asm.ItemAtlasHooks;
import gloomyfolken.mods.asm.Logger;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.imageio.ImageIO;
import mcoptifine.AnimatedTextures;
import mcoptifine.Config;
import mcoptifine.ConnectedTextures;
import mcoptifine.LoadingSprite;
import mcoptifine.Reflector;
import mcoptifine.TextureUtils;
import mcoptifine.WrUpdates;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.turb;
import net.minecraftforge.client.ForgeHooksClient;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class sctd
extends zhix
implements cegw,
IconRegister {
    public static final ResourceLocation _c = new ResourceLocation("textures/atlas/blocks.png");
    public static final ResourceLocation _d = new ResourceLocation("textures/atlas/blocks_animated.png");
    public static final ResourceLocation _e = new ResourceLocation("textures/atlas/items.png");
    public static sctd _f = null;
    public static sctd _g = null;
    public static sctd _i = null;
    public final List<TextureAtlasSprite> _j = Lists.newArrayList();
    public final Map<String, TextureAtlasSprite> _k = Maps.newHashMap();
    public final Map<String, TextureAtlasSprite> _l = Maps.newHashMap();
    public final int _m;
    public final String _n;
    public final TextureAtlasSprite _o = new TextureAtlasSprite("missingno");
    public int _p = 0;
    public int _q = 0;
    public int _r = 256;
    public float _s = 1.5f;
    public int _t = 16;
    public static boolean _u = sbnz._a;
    public HashMultimap<Integer, LoadingSprite> _v = HashMultimap.create();
    public HashMap<TextureAtlasSprite, TextureAtlasSprite> _w = new HashMap();

    public sctd(int n, String string) {
        this._m = n;
        this._n = string;
        switch (this._m) {
            case 0: {
                _f = this;
                break;
            }
            case 1: {
                _g = this;
                break;
            }
            case 2: {
                _i = this;
            }
        }
        if (this._m != 2) {
            this._c();
        }
    }

    public boolean _d() {
        return this._m != 1;
    }

    public static sctd _e() {
        if (_i == null) {
            _i = new sctd(2, "textures/blocks_animated");
            Minecraft._E()._h._a(_d, _i);
            return _i;
        }
        return _i;
    }

    public void _f() {
        int[] nArray = new int[bsfn._c.length];
        System.arraycopy(bsfn._c, 0, nArray, 0, nArray.length);
        this._o.setTextureData(nArray);
        this._o.setIconWidth(16);
        this._o.setIconHeight(16);
        this._o.setIndexInMap(0);
    }

    @Override
    public void loadTexture(ResourceManager resourceManager) throws IOException {
        this._f();
        this._a(resourceManager);
    }

    public void _g() {
        bsfn._a(this.getGlTextureId());
        TextureUtils.setupTexture(this._p, this._q, Config.isUseMipmaps() && this._m != 1, false, this._r >= 256);
    }

    public void _h() {
        this._l.clear();
        this._j.clear();
    }

    public void _a(ResourceManager resourceManager, List<TextureAtlasSprite> list) {
        int n = TextureUtils.ceilPowerOfTwo((int)((float)this._r * this._s * 16.0f));
        int n2 = TextureUtils.ceilPowerOfTwo((int)((float)this._r * this._s * (float)list.size()));
        this._p = n;
        this._q = n2;
        bsfn._a(this.getGlTextureId(), n, n2);
        TextureUtils.setupTexture(n, n2, Config.isUseMipmaps(), true, this._r >= 256);
        for (TextureAtlasSprite textureAtlasSprite : list) {
            try {
                textureAtlasSprite.loadAnimatedSprite(resourceManager, this._c(textureAtlasSprite.getIconName()), this._t, this);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        if (System.getProperty("saveTextureMap", "false").equalsIgnoreCase("true")) {
            int n3 = Config.getMipmapLevel();
            for (int i = 0; i < n3; ++i) {
                int n4 = GL11.glGetTexLevelParameteri(3553, i, 4096);
                int n5 = GL11.glGetTexLevelParameteri(3553, i, 4097);
                IntBuffer intBuffer = BufferUtils.createIntBuffer(n4 * n5);
                GL11.glGetTexImage(3553, i, 32993, 33639, intBuffer);
                BufferedImage bufferedImage = new BufferedImage(n4, n5, 6);
                int[] nArray = new int[n4 * n5];
                intBuffer.get(nArray);
                bufferedImage.setRGB(0, 0, n4, n5, nArray, 0, n4);
                File file = new File(String.format("debug_blocks_animated_%d.png", i));
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    ImageIO.write((RenderedImage)bufferedImage, "png", file);
                    continue;
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
        }
    }

    public ResourceLocation _c(String string) {
        ResourceLocation resourceLocation = new ResourceLocation(string);
        String string2 = this._n;
        if (this._m == 2) {
            string2 = sctd._f._n;
        }
        ResourceLocation resourceLocation2 = new ResourceLocation(resourceLocation.getResourceDomain(), String.format("%s/%s%s", string2, resourceLocation.getResourcePath(), ".png"));
        if (this._a(resourceLocation)) {
            resourceLocation2 = new ResourceLocation(resourceLocation.getResourceDomain(), resourceLocation.getResourcePath() + ".png");
        }
        return resourceLocation2;
    }

    public void _a(ResourceManager resourceManager) {
        Object object;
        Iterator<TextureAtlasSprite> iterator2;
        Object object5;
        boolean bl = sbnz._a(this, resourceManager);
        if (bl) {
            return;
        }
        int n = ItemAtlasHooks.loadTextureAtlas(this, resourceManager);
        if (n != 0) {
            int n2 = n;
            return;
        }
        Config.dbg("Loading texture map: " + this._n);
        if (this._m == 2) {
            sbnz._a(this);
            return;
        }
        WrUpdates.finishCurrentUpdate();
        AnimatedTextures.reset();
        this._c();
        n = Minecraft._F();
        htwe htwe2 = new htwe(n, n, true);
        htwe2._i = 16;
        this._h();
        ForgeHooksClient.onTextureStitchedPre(this);
        Iterator<Map.Entry<String, TextureAtlasSprite>> iterator3 = this._k.entrySet().iterator();
        ArrayList<TextureAtlasSprite> arrayList = new ArrayList<TextureAtlasSprite>();
        HashMap<String, TextureAtlasSprite> hashMap = Maps.newHashMap(this._k);
        while (iterator3.hasNext()) {
            block25: {
                Map.Entry<String, TextureAtlasSprite> entry = iterator3.next();
                ResourceLocation resourceLocation = this._c(entry.getKey());
                object5 = entry.getValue();
                ((TextureAtlasSprite)object5).resourcePackResolution = this._r;
                ((TextureAtlasSprite)object5).cellSize = this._s;
                try {
                    if (!((TextureAtlasSprite)object5).load(resourceManager, resourceLocation)) {
                    }
                    break block25;
                }
                catch (RuntimeException runtimeException) {
                    Minecraft._E()._O()._c(String.format("Unable to parse animation metadata from %s: %s", resourceLocation, runtimeException.getMessage()));
                }
                catch (IOException iOException) {
                    Minecraft._E()._O()._c("Using missing texture, unable to load: " + resourceLocation);
                }
                continue;
            }
            if (((TextureAtlasSprite)object5).animated) {
                arrayList.add((TextureAtlasSprite)object5);
                continue;
            }
            boolean bl2 = false;
            iterator2 = new LoadingSprite((TextureAtlasSprite)object5);
            Set object42 = this._v.get((Object)((LoadingSprite)((Object)iterator2)).hashCode);
            if (object42 != null) {
                for (Object object2 : object42) {
                    if (!Arrays.equals(((LoadingSprite)((Object)iterator2)).pixeldata, ((LoadingSprite)object2).pixeldata)) continue;
                    ((TextureAtlasSprite)object5).clearFramesTextureData();
                    hashMap.remove(((TextureAtlasSprite)object5).getIconName());
                    this._l.put(((TextureAtlasSprite)object5).getIconName(), (TextureAtlasSprite)object5);
                    bl2 = true;
                    this._w.put((TextureAtlasSprite)object5, ((LoadingSprite)object2).sprite);
                    break;
                }
            }
            if (bl2) continue;
            this._v.put((Object)((LoadingSprite)((Object)iterator2)).hashCode, iterator2);
            htwe2._a((TextureAtlasSprite)object5);
        }
        htwe2._a(this._o);
        htwe2._c();
        Config.dbg("Texture size: " + this._n + ", " + htwe2._a() + "x" + htwe2._b());
        int n3 = htwe2._a();
        int n4 = htwe2._b();
        this._p = n3;
        this._q = n4;
        object5 = null;
        if (System.getProperty("saveTextureMap", "false").equalsIgnoreCase("true")) {
            object5 = this._a(n3, n4);
        }
        bsfn._a(this.getGlTextureId(), htwe2._a(), htwe2._b());
        boolean bl3 = Config.isUseMipmaps() && this._m == 0;
        TextureUtils.setupTexture(n3, n4, bl3, true, this._r >= 256);
        iterator2 = htwe2._d().iterator();
        for (TextureAtlasSprite textureAtlasSprite : this._w.keySet()) {
            Object object2;
            object2 = this._w.get(textureAtlasSprite);
            if (object2 != null) {
                object = textureAtlasSprite.toString();
                textureAtlasSprite.copyFrom((TextureAtlasSprite)object2);
                Logger.warning("Removing duplicated sprite " + (String)object, new Object[0]);
                Logger.warning("Transforming duplicated sprite to " + textureAtlasSprite.toString(), new Object[0]);
                continue;
            }
            throw new IllegalStateException("Tried to duplicate sprite from null-value");
        }
        while (iterator2.hasNext()) {
            TextureAtlasSprite textureAtlasSprite = (TextureAtlasSprite)iterator2.next();
            String string = textureAtlasSprite.getIconName();
            hashMap.remove(string);
            this._l.put(string, textureAtlasSprite);
            try {
                textureAtlasSprite.setMipmapActive(bl3);
                if (!textureAtlasSprite.animated) {
                    textureAtlasSprite.uploadFrameTexture();
                }
                if (object5 != null) {
                    this._a(textureAtlasSprite, (BufferedImage)object5);
                }
            }
            catch (Throwable throwable) {
                object = CrashReport.makeCrashReport(throwable, "Stitching texture atlas");
                CrashReportCategory crashReportCategory = ((CrashReport)object).makeCategory("Texture being stitched together");
                crashReportCategory._a("Atlas path", this._n);
                crashReportCategory._a("Sprite", textureAtlasSprite);
                throw new turb((CrashReport)object);
            }
            if (textureAtlasSprite.hasAnimationMetadata()) {
                this._j.add(textureAtlasSprite);
            }
            textureAtlasSprite.clearFramesTextureData();
        }
        for (TextureAtlasSprite textureAtlasSprite : hashMap.values()) {
            textureAtlasSprite.copyFrom(this._o);
        }
        if (object5 != null) {
            this._a((BufferedImage)object5, "debug_" + this._n.replace('/', '_') + ".png");
        }
        if (this._m == 0) {
            sctd._e()._r = this._r;
            sctd._e()._s = this._s;
            sctd._e()._a(resourceManager, arrayList);
            try {
                sctd._e().loadTexture(resourceManager);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        this._w.clear();
        this._v.clear();
        ForgeHooksClient.onTextureStitchedPost(this);
        sbnz._a(this);
    }

    public void _c() {
        this._k.clear();
        if (this._m == 0) {
            for (Block object : Block.blocksList) {
                if (object == null) continue;
                object.registerIcons(this);
            }
            Minecraft._E()._s._a(this);
            RenderManager._b._a(this);
            ConnectedTextures.updateIcons(this);
        }
        for (Item item : Item.itemsList) {
            if (item == null || item.getSpriteNumber() != this._m) continue;
            item.registerIcons(this);
        }
    }

    public TextureAtlasSprite _d(String string) {
        TextureAtlasSprite textureAtlasSprite = this._l.get(string);
        if (textureAtlasSprite == null) {
            textureAtlasSprite = this._o;
        }
        return textureAtlasSprite;
    }

    public void _i() {
    }

    @Override
    public Icon _b(String string) {
        Icon icon = ItemAtlasHooks.registerIcon(this, string);
        if (icon != null) {
            return icon;
        }
        if (string == null) {
            new RuntimeException("Don't register null!").printStackTrace();
            string = "null";
        }
        if ((icon = this._k.get(string)) == null && this._m == 1 && Reflector.ModLoader_getCustomAnimationLogic.exists()) {
            icon = (TextureAtlasSprite)Reflector.call(Reflector.ModLoader_getCustomAnimationLogic, string);
        }
        if (icon == null) {
            icon = new TextureAtlasSprite(string);
            this._k.put(string, (TextureAtlasSprite)icon);
            ((TextureAtlasSprite)icon).setIndexInMap(this._k.size());
        }
        return icon;
    }

    public int _j() {
        return this._m;
    }

    @Override
    public void tick() {
        this._i();
    }

    public TextureAtlasSprite _e(String string) {
        return this._k.get(string);
    }

    public boolean _a(String string, TextureAtlasSprite textureAtlasSprite) {
        if (!this._k.containsKey(string)) {
            this._k.put(string, textureAtlasSprite);
            textureAtlasSprite.setIndexInMap(this._k.size());
            return true;
        }
        return false;
    }

    public boolean _a(ResourceLocation resourceLocation) {
        String string = resourceLocation.getResourcePath().toLowerCase();
        return string.startsWith("mcpatcher/") || string.startsWith("optifine/");
    }

    public TextureAtlasSprite _f(String string) {
        return this._k.get(string);
    }

    public boolean _a(TextureAtlasSprite textureAtlasSprite) {
        return textureAtlasSprite != TextureUtils.iconWaterStill && textureAtlasSprite != TextureUtils.iconWaterFlow ? (textureAtlasSprite != TextureUtils.iconLavaStill && textureAtlasSprite != TextureUtils.iconLavaFlow ? (textureAtlasSprite != TextureUtils.iconFireLayer0 && textureAtlasSprite != TextureUtils.iconFireLayer1 ? (textureAtlasSprite == TextureUtils.iconPortal ? Config.isAnimatedPortal() : Config.isAnimatedTerrain()) : Config.isAnimatedFire()) : Config.isAnimatedLava()) : Config.isAnimatedWater();
    }

    public void _b(ResourceManager resourceManager) {
        try {
            this.loadTexture(resourceManager);
        }
        catch (IOException iOException) {
            Config.warn("Error loading texture map: " + this._n);
            iOException.printStackTrace();
        }
    }

    public BufferedImage _a(int n, int n2) {
        BufferedImage bufferedImage = new BufferedImage(n, n2, 2);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setPaint(new Color(255, 255, 0));
        graphics2D.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
        return bufferedImage;
    }

    public void _a(TextureAtlasSprite textureAtlasSprite, BufferedImage bufferedImage) {
        if (!textureAtlasSprite.animated) {
            int[] nArray = textureAtlasSprite.getTextureData();
            bufferedImage.setRGB(textureAtlasSprite.getOriginX(), textureAtlasSprite.getOriginY(), textureAtlasSprite.getIconWidth(), textureAtlasSprite.getIconHeight(), nArray, 0, textureAtlasSprite.getIconWidth());
        }
    }

    public void _a(BufferedImage bufferedImage, String string) {
        try {
            ImageIO.write((RenderedImage)bufferedImage, "png", new File(Config.getMinecraft()._P, string));
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

