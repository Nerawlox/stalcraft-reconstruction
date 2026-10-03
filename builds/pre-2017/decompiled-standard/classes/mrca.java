/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.FMLCommonHandler;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.ClientProxy;
import java.util.Random;
import org.lwjgl.util.vector.Vector2f;

public class mrca
extends hurg {
    @ezey(_a={eidj.CLIENT})
    public static ejcz[] _a;
    public int _b = 0;
    public double _c = 1.0;
    public int _d = 3;
    public double _e = 0.5;
    @ezey(_a={eidj.CLIENT})
    private kjui _f;
    private boolean _g = true;

    @Override
    public void func_70307_a(qoac qoac2) {
        super.func_70307_a(qoac2);
        this._b = qoac2._f("distortionIcon");
        this._c = qoac2._i("particles");
        this._d = qoac2._f("height");
        this._e = qoac2._c("offset") ? qoac2._i("offset") : 0.5;
    }

    @Override
    public void func_70310_b(qoac qoac2) {
        super.func_70310_b(qoac2);
        qoac2._a("distortionIcon", this._b);
        qoac2._a("particles", this._c);
        qoac2._a("height", this._d);
        qoac2._a("offset", this._e);
    }

    @Override
    public cezg func_70319_e() {
        qoac qoac2 = new qoac();
        this.func_70310_b(qoac2);
        return new wpte(this.field_70329_l, this.field_70330_m, this.field_70327_n, 1, qoac2);
    }

    @Override
    public void onDataPacket(jjpj jjpj2, wpte wpte2) {
        this.func_70307_a(wpte2._e);
    }

    @Override
    public boolean canUpdate() {
        return FMLCommonHandler.instance().getEffectiveSide().isClient();
    }

    @Override
    public void func_70316_g() {
        if (this._g) {
            if (this.field_70331_k.field_72995_K) {
                InvokeSideOnly.client(() -> this._a());
            }
            this._g = false;
        }
    }

    @ezey(_a={eidj.CLIENT})
    private void _a() {
        this._f = new kjui(this);
        gloomyfolken.mods.effects.client.main.pidb._a(this._f);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void func_70313_j() {
        if (this._f != null) {
            this._f.isValid = false;
        }
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void onChunkUnload() {
        if (this._f != null) {
            this._f.isValid = false;
        }
    }

    static {
        InvokeSideOnly.client(FMLCommonHandler.instance().getEffectiveSide().isClient(), () -> {
            _a = new ejcz[]{dwpk._q, dwpk._e, dwpk._o, cujo._c, cujo._d, cujo._e};
        });
    }

    private static class pidb
    extends ejdy {
        private kjui _a;
        private double _b = 0.0;
        private double _c;

        public pidb(kjui kjui2, float f, ejcz ejcz2) {
            super(kjui2, 1.0f, ejcz2);
            this._a = kjui2;
            this._c = ((kjui)kjui2)._a._e;
            this.setCollisionSize(1.0f);
            Random random = kjui2.world.field_73012_v;
            Vector2f vector2f = new Vector2f(random.nextFloat() - 0.5f, random.nextFloat() - 0.5f);
            vector2f.normalise();
            float f2 = random.nextFloat() * 0.3f;
            this.setPosition(kjui2.centerX + (double)(vector2f.x * f2) * this._c * 2.0, kjui2.centerY, kjui2.centerZ + (double)(vector2f.y * f2) * this._c * 2.0);
            this._b = kjui2.centerY + (double)f;
            this.motionY = 0.07f;
            this.prevAlpha = 0.5f;
            this.alpha = 0.5f;
        }

        @Override
        public void tick() {
            super.tick();
            if (this._c > 0.0) {
                this.motionX = (float)((double)this.motionX + (double)((this._a.world.field_73012_v.nextFloat() - 0.5f) * 2.5E-4f) * this._c * 2.0);
                this.motionZ = (float)((double)this.motionZ + (double)((this._a.world.field_73012_v.nextFloat() - 0.5f) * 2.5E-4f) * this._c * 2.0);
            }
            this.motionY = 0.07f;
            if (this.posY > this._b - 0.8) {
                this.alpha -= 0.2f;
                this.textureSize *= 1.01f;
            }
            if (this.posY > this._b) {
                this.isDead = true;
            }
        }
    }

    private static class kjui
    extends iekw {
        private mrca _a;
        private int _b = 0;

        public kjui(mrca mrca2) {
            super(mrca2.field_70331_k, mrca2);
            this._a = mrca2;
            this.setCenter((double)mrca2.field_70329_l + 0.5, mrca2.field_70330_m, (double)mrca2.field_70327_n + 0.5);
            this.setSize(1.5, 1.0, 1 + mrca2._d);
        }

        @Override
        public void tick() {
            super.tick();
            if (--this._b <= 0) {
                this._b = (int)(20.0 - 12.0 * this._a._c);
                this.particles.add(new pidb(this, (float)this._a._d, _a[this._a._b]));
            }
            this.renderDistanceSq = ClientProxy.particleRenderDistance.value * ClientProxy.particleRenderDistance.value;
        }
    }
}

