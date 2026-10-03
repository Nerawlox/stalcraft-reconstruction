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
import net.minecraft.client.xpzm;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.jxsn;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.dwan;
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
        this._o.func_110966_b(16);
        this._o.func_110969_c(16);
    }

    @Override
    public void func_110551_a(xsfs xsfs2) throws IOException {
        this._k();
        this._a(xsfs2);
    }

    @Override
    public void _a(xsfs xsfs2) {
        Object object;
        long l = System.currentTimeMillis();
        int n = xpzm._F();
        htwe htwe2 = new htwe(n, n, true);
        this._l.clear();
        this._j.clear();
        for (Map.Entry<String, dhji> object22 : this._k.entrySet()) {
            dhji dhji2;
            block12: {
                Iterator<dhji> iterator2 = new ResourceLocation(object22.getKey());
                dhji2 = object22.getValue();
                object = new ResourceLocation(((ResourceLocation)((Object)iterator2)).func_110624_b(), String.format("%s/%s%s", this._n, ((ResourceLocation)((Object)iterator2)).func_110623_a(), ".png"));
                try {
                    if (!dhji2.load(xsfs2, (ResourceLocation)object)) {
                    }
                    break block12;
                }
                catch (RuntimeException iOException) {
                    xpzm._E()._O()._c(String.format("Unable to parse animation metadata from %s: %s", object, iOException.getMessage()));
                }
                catch (IOException throwable) {
                    xpzm._E()._O()._c("Using missing texture, unable to load: " + object);
                }
                continue;
            }
            htwe2._a(dhji2);
        }
        htwe2._a(this._o);
        htwe2._c();
        this._y = htwe2._a();
        this._z = htwe2._b();
        bsfn._a(this.func_110552_b(), htwe2._a(), htwe2._b());
        HashMap<String, dhji> hashMap = Maps.newHashMap(this._k);
        for (dhji dhji2 : htwe2._d()) {
            object = dhji2.func_94215_i();
            hashMap.remove(object);
            this._l.put((String)object, dhji2);
            try {
                bsfn._a(dhji2.getTextureData(), dhji2.func_94211_a(), dhji2.func_94216_b(), dhji2.func_130010_a(), dhji2.func_110967_i(), true, false);
            }
            catch (Throwable throwable) {
                CrashReport crashReport = CrashReport.func_85055_a(throwable, "Stitching diffuseMap atlas");
                jxsn jxsn2 = crashReport.func_85058_a("Texture being stitched together");
                jxsn2._a("Atlas path", this._n);
                jxsn2._a("Sprite", dhji2);
                throw new turb(crashReport);
            }
            if (dhji2.func_130098_m()) {
                this._j.add(dhji2);
                continue;
            }
            dhji2.func_130103_l();
        }
        for (dhji dhji2 : hashMap.values()) {
            dhji2.func_94217_a(this._o);
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
    public /* synthetic */ dwan _b(String string) {
        return this._a(string);
    }
}

