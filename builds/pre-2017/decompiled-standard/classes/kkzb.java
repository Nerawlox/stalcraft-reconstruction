/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.font.SdfFont;
import gloomyfolken.mods.effects.client.main.eidj;
import gloomyfolken.mods.effects.client.main.qlgf;
import gloomyfolken.mods.effects.client.mcsa.ezfa;
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import gloomyfolken.mods.stalker.clans.pidb;
import java.util.ArrayList;
import java.util.List;
import mods.pda.client.PdaClient;
import mods.regions.Region;
import mods.regions.RegionsMod;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraft.util.amww;
import net.minecraft.util.hank;
import net.minecraft.util.iurn;
import net.minecraft.util.ofbx;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.ForgeSubscribe;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

public class kkzb {
    private List<Region> _a = new ArrayList<Region>();
    private qlgf<kjui> _b = new qlgf<kjui>(() -> new kjui());

    @ForgeSubscribe
    public void _a(RenderWorldLastEvent renderWorldLastEvent) {
        if (!PdaClient.showBattlefieldWaypointsWorld.enabled) {
            return;
        }
        pidb pidb2 = this._a();
        if (pidb2 == null || pidb2._l().isEmpty()) {
            return;
        }
        xpzm xpzm2 = xpzm._E();
        double d = (double)(512 >> xpzm2._M.field_74339_e) * 0.5;
        List<pidb.eidj> list2 = pidb2._f();
        EntityClientPlayerMP entityClientPlayerMP = xpzm2._t;
        ofbx ofbx2 = entityClientPlayerMP.func_70040_Z();
        for (int i = 0; i < list2.size(); ++i) {
            this._a(entityClientPlayerMP, ofbx2, d, i);
        }
    }

    @ForgeSubscribe
    public void _a(qmds.kjui kjui2) {
        boolean bl;
        boolean bl2 = bl = yuch._c != null && !yuch._c._n();
        if (!bl) {
            return;
        }
        double d = gqqu._d;
        double d2 = gqqu._e;
        double d3 = gqqu._f;
        for (Region region : RegionsMod.regionsClient.regions.values()) {
            double d4;
            double d5;
            if (!region.getTitle().startsWith("battlefield_slot_")) continue;
            dfkn dfkn2 = region.getRegionBoundingBox();
            double d6 = Math.max(Math.max(dfkn2._a - d, 0.0), d - dfkn2._d - 1.0);
            if (d6 * d6 + (d5 = Math.max(Math.max(dfkn2._b - d2, 0.0), d2 - dfkn2._e - 1.0)) * d5 + (d4 = Math.max(Math.max(dfkn2._c - d3, 0.0), d3 - dfkn2._f - 1.0)) * d4 > 216.0) continue;
            this._a.add(region);
        }
        if (!this._a.isEmpty()) {
            kjui2._a = true;
        }
    }

    @ForgeSubscribe
    public void _a(qmds.pidb pidb2) {
        if (this._a.isEmpty()) {
            return;
        }
        RegionsMod.noPvpShader._e();
        RegionsMod.noPvpShader._a("time", ((float)ntte._b + xpzm._E()._p._d) / 15.0f);
        GL11.glEnable(3553);
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        GL11.glDisable(2884);
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        htvf.field_78398_a.func_78382_b();
        double d = gqqu._d;
        double d2 = gqqu._e;
        double d3 = gqqu._f;
        for (Region region : this._a) {
            for (dfkn dfkn2 : region.getBoxes()) {
                this._a(dfkn2._a - d, dfkn2._b - d2, dfkn2._c - d3, dfkn2._d - d, dfkn2._e - d2, dfkn2._f - d3);
            }
        }
        htvf.field_78398_a.func_78381_a();
        GL11.glEnable(2884);
        GL11.glPopMatrix();
        GL11.glDisable(3042);
        GL11.glEnable(2896);
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL20.glUseProgram(0);
        this._a.clear();
    }

    private pidb _a() {
        return yuch._c;
    }

    private void _a(EntityClientPlayerMP entityClientPlayerMP, ofbx ofbx2, double d, int n) {
        ofbx ofbx3;
        Object object;
        hank hank2;
        double d2;
        double d3;
        iurn iurn2 = entityClientPlayerMP.field_70170_p.func_82732_R();
        pidb.eidj eidj2 = this._a()._f().get(n);
        einh einh2 = eidj2._h();
        double d4 = (double)einh2._c() - gqqu._d;
        double d5 = Math.sqrt(d4 * d4 + (d3 = (double)einh2._d() - gqqu._e) * d3 + (d2 = (double)einh2._e() - gqqu._f) * d2);
        double d6 = d5;
        if (d6 > d) {
            double d7 = d / d6;
            d4 *= d7;
            d3 *= d7;
            d2 *= d7;
            d6 = d;
        }
        float f = eidj._a._z;
        double d8 = Math.max(12.0, d6) * 0.1 * 0.013333333333333334 * (double)(f / 90.0f);
        ofbx ofbx4 = iurn2._a(d4, d3, d2);
        double d9 = ofbx2._b(ofbx4) / (ofbx2._b() * d6);
        boolean bl = Math.abs(d9) > (d5 > d ? 0.9999 : 1.0 - 0.05 * (1.0 / Math.max(12.0, d5)));
        int n2 = eidj2._g();
        if (!bl && (hank2 = entityClientPlayerMP.field_70170_p.func_72933_a((ofbx)(object = iurn2._a(entityClientPlayerMP.field_70165_t, entityClientPlayerMP.field_70163_u, entityClientPlayerMP.field_70161_v)), ofbx3 = iurn2._a(einh2._c, einh2._d, einh2._e))) != null && hank2._c == amww._a) {
            n2 &= 0x64FFFFFF;
        }
        object = String.valueOf((char)(65 + n));
        this._a((String)object, eidj2, d4, d3, d2, d5, d8, bl, n2);
    }

    private void _a(String string, pidb.eidj eidj2, double d, double d2, double d3, double d4, double d5, boolean bl, int n) {
        GL11.glPushMatrix();
        GL11.glTranslated(d, d2, d3);
        gqqu gqqu2 = gqqu._b;
        GL11.glRotatef(-gqqu2._l, 0.0f, 1.0f, 0.0f);
        boolean bl2 = xpzm._E()._M.field_74320_O == 2;
        GL11.glRotatef(bl2 ? -gqqu2._m : gqqu2._m, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(-d5, -d5, d5);
        ezfc._a();
        ezfc._d();
        kjui kjui2 = this._b._a();
        kjui2._b = string;
        kjui2._c = n;
        kjui2._d = eidj2._a() == null ? 1.0f : (float)eidj2._c();
        kjui2._e = bl ? d4 : -1.0;
        kjui2.load();
        ezfa._a._b.add(kjui2);
        ezfc._b();
        GL11.glPopMatrix();
    }

    private void _a(double d, double d2, double d3, double d4, double d5, double d6) {
        htvf htvf2 = htvf.field_78398_a;
        double d7 = d4 - d;
        double d8 = d5 - d2;
        double d9 = d6 - d3;
        htvf2.func_78374_a(d, d5, d3, d7, 0.0);
        htvf2.func_78374_a(d4, d5, d3, 0.0, 0.0);
        htvf2.func_78374_a(d4, d2, d3, 0.0, d8);
        htvf2.func_78374_a(d, d2, d3, d7, d8);
        htvf2.func_78374_a(d, d2, d6, 0.0, d8);
        htvf2.func_78374_a(d4, d2, d6, d7, d8);
        htvf2.func_78374_a(d4, d5, d6, d7, 0.0);
        htvf2.func_78374_a(d, d5, d6, 0.0, 0.0);
        htvf2.func_78374_a(d, d2, d3, 0.0, 0.0);
        htvf2.func_78374_a(d4, d2, d3, d7, 0.0);
        htvf2.func_78374_a(d4, d2, d6, d7, d9);
        htvf2.func_78374_a(d, d2, d6, 0.0, d9);
        htvf2.func_78374_a(d, d5, d6, 0.0, d9);
        htvf2.func_78374_a(d4, d5, d6, d7, d9);
        htvf2.func_78374_a(d4, d5, d3, d7, 0.0);
        htvf2.func_78374_a(d, d5, d3, 0.0, 0.0);
        htvf2.func_78374_a(d, d2, d6, d8, 0.0);
        htvf2.func_78374_a(d, d5, d6, 0.0, 0.0);
        htvf2.func_78374_a(d, d5, d3, 0.0, d9);
        htvf2.func_78374_a(d, d2, d3, d8, d9);
        htvf2.func_78374_a(d4, d2, d3, d8, 0.0);
        htvf2.func_78374_a(d4, d5, d3, 0.0, 0.0);
        htvf2.func_78374_a(d4, d5, d6, 0.0, d9);
        htvf2.func_78374_a(d4, d2, d6, d8, d9);
    }

    private class kjui
    extends qlgf.kjui {
        private String _b;
        private int _c;
        private float _d;
        private double _e = -1.0;

        private kjui() {
        }

        @Override
        protected void render(float f) {
            GL11.glPushMatrix();
            ezfc._a();
            ezfc._a(this.modelView);
            ezfc._e();
            GL11.glEnable(3042);
            GL11.glDisable(2896);
            GL11.glBlendFunc(770, 771);
            GL11.glDisable(2929);
            yuch._a(0.0f, 0.0f, this._d, this._c, this._c, 106, 261, 4, 261, 91, 91.0f);
            SdfFont.tahoma.renderCenteredString(-3.0f, -9.5f, this._b, 0L, false, 15.0f, SdfFont.FontWeight.Bold.INSTANCE);
            if (this._e >= 0.0) {
                SdfFont.tahoma.renderCenteredString(-3.0f, 21.0f, String.format("%.1f", this._e), -1L, true, 15.0f, SdfFont.FontWeight.Bold.INSTANCE);
            }
            GL11.glEnable(2929);
            GL11.glDisable(2896);
            GL11.glDisable(3042);
            ezfc._b();
            GL11.glPopMatrix();
        }
    }
}

