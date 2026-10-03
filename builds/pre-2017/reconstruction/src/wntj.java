/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Maps;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.turb;

@ezey(_a={eidj.CLIENT})
public class wntj
extends sctd {
    public static final ResourceLocation _a = new ResourceLocation("textures/atlas/particles.png");
    private List<rplk> _x;
    public Set<ejcz> _b = new HashSet<ejcz>();
    private int _y;
    private int _z;

    public wntj(List<rplk> list2) {
        super(347, "textures/particles");
        this._x = list2;
        for (rplk rplk2 : list2) {
            rplk2.registerIcons(this);
        }
    }

    public int _a() {
        return this._y;
    }

    public int _b() {
        return this._z;
    }

    private void _k() {
        int[] nArray = new int[bsfn._c.length];
        System.arraycopy(bsfn._c, 0, nArray, 0, nArray.length);
        this._o.setTextureData(nArray);
        this._o.setIconWidth(16);
        this._o.setIconHeight(16);
    }

    @Override
    public void loadTexture(ResourceManager resourceManager) throws IOException {
        this._k();
        this._a(resourceManager);
    }

    @Override
    public void _a(ResourceManager resourceManager) {
        Object object;
        long l = System.currentTimeMillis();
        int n = Minecraft._F();
        htwe htwe2 = new htwe(n, n, true);
        this._l.clear();
        this._j.clear();
        for (Map.Entry<String, TextureAtlasSprite> object22 : this._k.entrySet()) {
            TextureAtlasSprite textureAtlasSprite;
            block12: {
                Iterator<TextureAtlasSprite> iterator2 = new ResourceLocation(object22.getKey());
                textureAtlasSprite = object22.getValue();
                object = new ResourceLocation(((ResourceLocation)((Object)iterator2)).getResourceDomain(), String.format("%s/%s%s", this._n, ((ResourceLocation)((Object)iterator2)).getResourcePath(), ".png"));
                try {
                    if (!textureAtlasSprite.load(resourceManager, (ResourceLocation)object)) {
                    }
                    break block12;
                }
                catch (RuntimeException iOException) {
                    Minecraft._E()._O()._c(String.format("Unable to parse animation metadata from %s: %s", object, iOException.getMessage()));
                }
                catch (IOException throwable) {
                    Minecraft._E()._O()._c("Using missing texture, unable to load: " + object);
                }
                continue;
            }
            htwe2._a(textureAtlasSprite);
        }
        htwe2._a(this._o);
        htwe2._c();
        this._y = htwe2._a();
        this._z = htwe2._b();
        bsfn._a(this.getGlTextureId(), htwe2._a(), htwe2._b());
        HashMap<String, TextureAtlasSprite> hashMap = Maps.newHashMap(this._k);
        for (TextureAtlasSprite textureAtlasSprite : htwe2._d()) {
            object = textureAtlasSprite.getIconName();
            hashMap.remove(object);
            this._l.put((String)object, textureAtlasSprite);
            try {
                bsfn._a(textureAtlasSprite.getTextureData(), textureAtlasSprite.getIconWidth(), textureAtlasSprite.getIconHeight(), textureAtlasSprite.getOriginX(), textureAtlasSprite.getOriginY(), true, false);
            }
            catch (Throwable throwable) {
                CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Stitching diffuseMap atlas");
                CrashReportCategory crashReportCategory = crashReport.makeCategory("Texture being stitched together");
                crashReportCategory._a("Atlas path", this._n);
                crashReportCategory._a("Sprite", textureAtlasSprite);
                throw new turb(crashReport);
            }
            if (textureAtlasSprite.hasAnimationMetadata()) {
                this._j.add(textureAtlasSprite);
                continue;
            }
            textureAtlasSprite.clearFramesTextureData();
        }
        for (TextureAtlasSprite textureAtlasSprite : hashMap.values()) {
            textureAtlasSprite.copyFrom(this._o);
        }
        System.out.println("Particles stitching time: " + (System.currentTimeMillis() - l));
    }

    @Override
    public void _c() {
    }

    public ejcz _a(String string) {
        ejcz ejcz2;
        if (string == null) {
            new RuntimeException("Don't register null!").printStackTrace();
            string = "null";
        }
        if ((ejcz2 = (ejcz)this._k.get(string)) == null) {
            ejcz2 = new ejcz(string);
            this._k.put(string, ejcz2);
        }
        this._b.add(ejcz2);
        return ejcz2;
    }

    @Override
    public /* synthetic */ Icon _b(String string) {
        return this._a(string);
    }
}

