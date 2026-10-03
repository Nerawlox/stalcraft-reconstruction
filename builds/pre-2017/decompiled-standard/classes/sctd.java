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
import net.minecraft.client.xpzm;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.jxsn;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.dwan;
import net.minecraft.util.turb;
import net.minecraftforge.client.ForgeHooksClient;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class sctd
extends zhix
implements cegw,
nege {
    public static final ResourceLocation _c = new ResourceLocation("textures/atlas/blocks.png");
    public static final ResourceLocation _d = new ResourceLocation("textures/atlas/blocks_animated.png");
    public static final ResourceLocation _e = new ResourceLocation("textures/atlas/items.png");
    public static sctd _f = null;
    public static sctd _g = null;
    public static sctd _i = null;
    public final List<dhji> _j = Lists.newArrayList();
    public final Map<String, dhji> _k = Maps.newHashMap();
    public final Map<String, dhji> _l = Maps.newHashMap();
    public final int _m;
    public final String _n;
    public final dhji _o = new dhji("missingno");
    public int _p = 0;
    public int _q = 0;
    public int _r = 256;
    public float _s = 1.5f;
    public int _t = 16;
    public static boolean _u = sbnz._a;
    public HashMultimap<Integer, LoadingSprite> _v = HashMultimap.create();
    public HashMap<dhji, dhji> _w = new HashMap();

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
            xpzm._E()._h._a(_d, _i);
            return _i;
        }
        return _i;
    }

    public void _f() {
        int[] nArray = new int[bsfn._c.length];
        System.arraycopy(bsfn._c, 0, nArray, 0, nArray.length);
        this._o.setTextureData(nArray);
        this._o.func_110966_b(16);
        this._o.func_110969_c(16);
        this._o.setIndexInMap(0);
    }

    @Override
    public void func_110551_a(xsfs xsfs2) throws IOException {
        this._f();
        this._a(xsfs2);
    }

    public void _g() {
        bsfn._a(this.func_110552_b());
        TextureUtils.setupTexture(this._p, this._q, Config.isUseMipmaps() && this._m != 1, false, this._r >= 256);
    }

    public void _h() {
        this._l.clear();
        this._j.clear();
    }

    public void _a(xsfs xsfs2, List<dhji> list) {
        int n = TextureUtils.ceilPowerOfTwo((int)((float)this._r * this._s * 16.0f));
        int n2 = TextureUtils.ceilPowerOfTwo((int)((float)this._r * this._s * (float)list.size()));
        this._p = n;
        this._q = n2;
        bsfn._a(this.func_110552_b(), n, n2);
        TextureUtils.setupTexture(n, n2, Config.isUseMipmaps(), true, this._r >= 256);
        for (dhji dhji2 : list) {
            try {
                dhji2.loadAnimatedSprite(xsfs2, this._c(dhji2.func_94215_i()), this._t, this);
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
        ResourceLocation resourceLocation2 = new ResourceLocation(resourceLocation.func_110624_b(), String.format("%s/%s%s", string2, resourceLocation.func_110623_a(), ".png"));
        if (this._a(resourceLocation)) {
            resourceLocation2 = new ResourceLocation(resourceLocation.func_110624_b(), resourceLocation.func_110623_a() + ".png");
        }
        return resourceLocation2;
    }

    public void _a(xsfs xsfs2) {
        Object object;
        Iterator<dhji> iterator2;
        Object object5;
        boolean bl = sbnz._a(this, xsfs2);
        if (bl) {
            return;
        }
        int n = ItemAtlasHooks.loadTextureAtlas(this, xsfs2);
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
        n = xpzm._F();
        htwe htwe2 = new htwe(n, n, true);
        htwe2._i = 16;
        this._h();
        ForgeHooksClient.onTextureStitchedPre(this);
        Iterator<Map.Entry<String, dhji>> iterator3 = this._k.entrySet().iterator();
        ArrayList<dhji> arrayList = new ArrayList<dhji>();
        HashMap<String, dhji> hashMap = Maps.newHashMap(this._k);
        while (iterator3.hasNext()) {
            block25: {
                Map.Entry<String, dhji> entry = iterator3.next();
                ResourceLocation resourceLocation = this._c(entry.getKey());
                object5 = entry.getValue();
                ((dhji)object5).resourcePackResolution = this._r;
                ((dhji)object5).cellSize = this._s;
                try {
                    if (!((dhji)object5).load(xsfs2, resourceLocation)) {
                    }
                    break block25;
                }
                catch (RuntimeException runtimeException) {
                    xpzm._E()._O()._c(String.format("Unable to parse animation metadata from %s: %s", resourceLocation, runtimeException.getMessage()));
                }
                catch (IOException iOException) {
                    xpzm._E()._O()._c("Using missing texture, unable to load: " + resourceLocation);
                }
                continue;
            }
            if (((dhji)object5).animated) {
                arrayList.add((dhji)object5);
                continue;
            }
            boolean bl2 = false;
            iterator2 = new LoadingSprite((dhji)object5);
            Set object42 = this._v.get((Object)((LoadingSprite)((Object)iterator2)).hashCode);
            if (object42 != null) {
                for (Object object2 : object42) {
                    if (!Arrays.equals(((LoadingSprite)((Object)iterator2)).pixeldata, ((LoadingSprite)object2).pixeldata)) continue;
                    ((dhji)object5).func_130103_l();
                    hashMap.remove(((dhji)object5).func_94215_i());
                    this._l.put(((dhji)object5).func_94215_i(), (dhji)object5);
                    bl2 = true;
                    this._w.put((dhji)object5, ((LoadingSprite)object2).sprite);
                    break;
                }
            }
            if (bl2) continue;
            this._v.put((Object)((LoadingSprite)((Object)iterator2)).hashCode, iterator2);
            htwe2._a((dhji)object5);
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
        bsfn._a(this.func_110552_b(), htwe2._a(), htwe2._b());
        boolean bl3 = Config.isUseMipmaps() && this._m == 0;
        TextureUtils.setupTexture(n3, n4, bl3, true, this._r >= 256);
        iterator2 = htwe2._d().iterator();
        for (dhji dhji2 : this._w.keySet()) {
            Object object2;
            object2 = this._w.get(dhji2);
            if (object2 != null) {
                object = dhji2.toString();
                dhji2.func_94217_a((dhji)object2);
                Logger.warning("Removing duplicated sprite " + (String)object, new Object[0]);
                Logger.warning("Transforming duplicated sprite to " + dhji2.toString(), new Object[0]);
                continue;
            }
            throw new IllegalStateException("Tried to duplicate sprite from null-value");
        }
        while (iterator2.hasNext()) {
            dhji dhji3 = (dhji)iterator2.next();
            String string = dhji3.func_94215_i();
            hashMap.remove(string);
            this._l.put(string, dhji3);
            try {
                dhji3.setMipmapActive(bl3);
                if (!dhji3.animated) {
                    dhji3.uploadFrameTexture();
                }
                if (object5 != null) {
                    this._a(dhji3, (BufferedImage)object5);
                }
            }
            catch (Throwable throwable) {
                object = CrashReport.func_85055_a(throwable, "Stitching texture atlas");
                jxsn jxsn2 = ((CrashReport)object).func_85058_a("Texture being stitched together");
                jxsn2._a("Atlas path", this._n);
                jxsn2._a("Sprite", dhji3);
                throw new turb((CrashReport)object);
            }
            if (dhji3.func_130098_m()) {
                this._j.add(dhji3);
            }
            dhji3.func_130103_l();
        }
        for (dhji dhji4 : hashMap.values()) {
            dhji4.func_94217_a(this._o);
        }
        if (object5 != null) {
            this._a((BufferedImage)object5, "debug_" + this._n.replace('/', '_') + ".png");
        }
        if (this._m == 0) {
            sctd._e()._r = this._r;
            sctd._e()._s = this._s;
            sctd._e()._a(xsfs2, arrayList);
            try {
                sctd._e().func_110551_a(xsfs2);
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
            for (twgu object : twgu.field_71973_m) {
                if (object == null) continue;
                object.func_94332_a(this);
            }
            xpzm._E()._s._a(this);
            gqqu._b._a(this);
            ConnectedTextures.updateIcons(this);
        }
        for (tgdv tgdv2 : tgdv.field_77698_e) {
            if (tgdv2 == null || tgdv2.func_94901_k() != this._m) continue;
            tgdv2.func_94581_a(this);
        }
    }

    public dhji _d(String string) {
        dhji dhji2 = this._l.get(string);
        if (dhji2 == null) {
            dhji2 = this._o;
        }
        return dhji2;
    }

    public void _i() {
    }

    @Override
    public dwan _b(String string) {
        dwan dwan2 = ItemAtlasHooks.registerIcon(this, string);
        if (dwan2 != null) {
            return dwan2;
        }
        if (string == null) {
            new RuntimeException("Don't register null!").printStackTrace();
            string = "null";
        }
        if ((dwan2 = this._k.get(string)) == null && this._m == 1 && Reflector.ModLoader_getCustomAnimationLogic.exists()) {
            dwan2 = (dhji)Reflector.call(Reflector.ModLoader_getCustomAnimationLogic, string);
        }
        if (dwan2 == null) {
            dwan2 = new dhji(string);
            this._k.put(string, (dhji)dwan2);
            ((dhji)dwan2).setIndexInMap(this._k.size());
        }
        return dwan2;
    }

    public int _j() {
        return this._m;
    }

    @Override
    public void func_110550_d() {
        this._i();
    }

    public dhji _e(String string) {
        return this._k.get(string);
    }

    public boolean _a(String string, dhji dhji2) {
        if (!this._k.containsKey(string)) {
            this._k.put(string, dhji2);
            dhji2.setIndexInMap(this._k.size());
            return true;
        }
        return false;
    }

    public boolean _a(ResourceLocation resourceLocation) {
        String string = resourceLocation.func_110623_a().toLowerCase();
        return string.startsWith("mcpatcher/") || string.startsWith("optifine/");
    }

    public dhji _f(String string) {
        return this._k.get(string);
    }

    public boolean _a(dhji dhji2) {
        return dhji2 != TextureUtils.iconWaterStill && dhji2 != TextureUtils.iconWaterFlow ? (dhji2 != TextureUtils.iconLavaStill && dhji2 != TextureUtils.iconLavaFlow ? (dhji2 != TextureUtils.iconFireLayer0 && dhji2 != TextureUtils.iconFireLayer1 ? (dhji2 == TextureUtils.iconPortal ? Config.isAnimatedPortal() : Config.isAnimatedTerrain()) : Config.isAnimatedFire()) : Config.isAnimatedLava()) : Config.isAnimatedWater();
    }

    public void _b(xsfs xsfs2) {
        try {
            this.func_110551_a(xsfs2);
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

    public void _a(dhji dhji2, BufferedImage bufferedImage) {
        if (!dhji2.animated) {
            int[] nArray = dhji2.getTextureData();
            bufferedImage.setRGB(dhji2.func_130010_a(), dhji2.func_110967_i(), dhji2.func_94211_a(), dhji2.func_94216_b(), nArray, 0, dhji2.func_94211_a());
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

