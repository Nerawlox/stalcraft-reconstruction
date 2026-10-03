/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.mcsa.jgro;
import gloomyfolken.mods.effects.client.mcsa.tupg;
import gloomyfolken.mods.effects.client.mcsa.ugqx;
import java.util.Collections;
import java.util.HashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;

public class ivhj {
    public static final ivhj _a = new ivhj();
    private static final String _c = "Material";
    public final ugqx _b = new ugqx("/assets/gloomycore/models/hands.mcsa")._a();
    private HashMap<ResourceLocation, ugqx> _d = new HashMap();
    private zxbe _e;
    private uhrk _f;
    private zxbe _g;
    private nuco _h;

    private ivhj() {
        this._e = new zxbe((jhuw)this._b._a, new iest[0]);
        this._f = new uhrk(new nuco(), null, null);
        this._g = new zxbe((jhuw)this._b._a, new iest[0]);
        this._h = new nuco();
        this._e._b(this._f);
        this._g._b(new jytp(this._h, "idle")._a(gpnw._c));
    }

    public boolean _a() {
        return this._e()._b._a(_c)._g();
    }

    public void _b() {
        this._g._b();
    }

    public void _c() {
        this._a(this._g);
    }

    public void _d() {
        if (this._g._e().size() == 0) {
            this._g._b(new jytp(this._h, "hit")._a(gpnw._a), 1.0f);
            this._g._c(new jytp(this._h, "idle")._a(gpnw._c), 1.0f);
        }
    }

    public void _a(cucv cucv2, jywl jywl2) {
        this._f._a = jywl2;
        this._f._b = cucv2;
        this._a(this._e);
    }

    private void _a(zxbe zxbe2) {
        ugqx ugqx2 = this._e();
        ugqx2._b().renderPart("hands", (cucv)zxbe2);
        MinecraftForge.EVENT_BUS.post(new ccvb(zxbe2));
    }

    private ugqx _e() {
        return this._a(Minecraft._E()._t.getLocationSkin());
    }

    private ugqx _a(ResourceLocation resourceLocation) {
        if (resourceLocation == AbstractClientPlayer.locationStevePng) {
            return this._b;
        }
        ugqx ugqx2 = this._d.get(resourceLocation);
        if (ugqx2 == null) {
            jgro jgro2 = jgro._a(resourceLocation, _c);
            tupg tupg2 = new tupg(Collections.singletonList(jgro2));
            ugqx2 = new ugqx(this._b._a, tupg2)._a();
            this._d.put(resourceLocation, ugqx2);
        }
        return ugqx2;
    }
}

