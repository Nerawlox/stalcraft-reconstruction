/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.weapon.trace.ugqx;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.ForgeSubscribe;
import znw.mods.stalkerguide.pidb;

public class ihco {
    private Minecraft _d;
    private divz _e;
    private mcqq _f;
    private boolean _g = false;
    public static lqls _a;
    public static ywqz _b;
    public static qozk _c;

    public ihco(divz divz2, mcqq mcqq2) {
        this._e = divz2;
        this._f = mcqq2;
        this._d = Minecraft._E();
    }

    @ForgeSubscribe
    public void _a(uigm uigm2) {
        if (!uigm2._a && pidb._a() && Objects.equals(uigm2._b.getEntityName(), mcne._f)) {
            uigm2._d = ugqx._a(uigm2._b);
        }
    }

    @ForgeSubscribe
    public void _a(lnrm.kjui kjui2) {
        if (this._d._B instanceof nuzu) {
            this._f._b();
        }
    }

    @ForgeSubscribe
    public void _a(RenderWorldLastEvent renderWorldLastEvent) {
        _a._a(renderWorldLastEvent.context, this._e, renderWorldLastEvent.partialTicks);
    }

    @ForgeSubscribe
    public void _a(RenderGameOverlayEvent renderGameOverlayEvent) {
        _c._a(renderGameOverlayEvent);
    }

    @ForgeSubscribe
    public void _b(lnrm.kjui kjui2) {
        if (this._d._r == null || this._d._t == null) {
            this._g = false;
        } else if (!this._g) {
            this._g = true;
            this._a();
            new nwuf(-1, false).sendToServer();
        }
    }

    private void _a() {
        _a = new lqls(this._d._r);
        _b = new ywqz(this._d._r);
        _c = new qozk(this._e);
    }
}

