/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.misc;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.asm.GloomyLoadingPlugin;
import gloomyfolken.mods.core.misc.ezey;
import gloomyfolken.mods.stalker.misc.StalkerMiscMod;
import gloomyfolken.mods.stalker.misc.tupg;
import gloomyfolken.mods.stalker.mobs.client.tuning.gui.ParticleEditor;
import gloomyfolken.mods.stalker.player.qlgf;
import gloomyfolken.mods.weapon.ugqx;
import java.util.List;
import java.util.Random;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ezfc;
import net.minecraft.util.jxtc;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class jgro {
    private boolean _b = false;
    private long _c = 0L;
    private boolean _d = false;
    private boolean _e = false;
    public static int _a = 0;
    private static final boolean _f = System.getProperty("no_disclaimer", "false").equals("false");

    @ForgeSubscribe
    @ezey(_a={eidj.CLIENT})
    public void _a(ofxs.pidb pidb2) {
        if (gloomyfolken.mods.effects.client.main.eidj._a._k) {
            long l = xpzm._E()._r.field_72986_A._h;
            if (!this._b) {
                this._c = l;
            }
            float f = (float)(l - this._c) / 2.0f;
            float f2 = (float)(l + 1L - this._c) / 2.0f;
            float f3 = xpzm._E()._p._d;
            float f4 = 1.0f - owkq._c(f3, f, f2);
            pidb2._a(Math.max(0.0f, f4));
        }
        this._b = gloomyfolken.mods.effects.client.main.eidj._a._k;
    }

    @ForgeSubscribe
    @ezey(_a={eidj.CLIENT})
    public void _a(tvms.kjui kjui2) {
        if (tupg._a((EntityPlayer)xpzm._E()._t)._l && kjui2._a._r() > 0.0) {
            hsmn._e();
            hsmn._d();
            tenh._a((float)kjui2._a._r());
            hsmn._f();
        }
    }

    @ForgeSubscribe
    public void _a(piyf piyf2) {
        if (piyf2._b._b("weight")) {
            bahe._b._a(piyf2._b._e, Float.valueOf(piyf2._b._j("weight")));
        }
    }

    @ForgeSubscribe(priority=EventPriority.LOW)
    public void _a(ycvh ycvh2) {
        ycvh2._b.add((Object)((Object)ezfc._o) + String.format("\u0412\u0435\u0441: %.2f \u043a\u0433", Float.valueOf(bahe._a(ycvh2._a))));
    }

    @ForgeSubscribe
    public void _a(PlayerInteractEvent playerInteractEvent) {
        int n;
        if (playerInteractEvent.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK && !playerInteractEvent.entityPlayer.field_71075_bZ._d && ((n = playerInteractEvent.entityPlayer.field_70170_p.func_72798_a(playerInteractEvent.x, playerInteractEvent.y, playerInteractEvent.z)) == twgu.field_72077_au.field_71990_ca || n == twgu.field_94347_ck.field_71990_ca | n == twgu.field_94340_cs.field_71990_ca || n == twgu.field_71958_P.field_71990_ca || n == twgu.field_96469_cy.field_71990_ca)) {
            playerInteractEvent.setResult(Event.Result.DENY);
            playerInteractEvent.setCanceled(true);
        }
    }

    private boolean _a(jxtc jxtc2, Random random) {
        gloomyfolken.mods.weapon.ezey ezey2;
        float f;
        String string = jxtc2.func_76355_l();
        if (jxtc2 instanceof gloomyfolken.mods.weapon.ezey && (double)(f = (ezey2 = (gloomyfolken.mods.weapon.ezey)((Object)jxtc2)).getBleedingChance()) >= 0.0) {
            return random.nextDouble() < (double)f;
        }
        return random.nextFloat() < 0.05f && (string.equals("player") || string.equals("mob") || string.equals("bullet") || string.startsWith("explosion") || jxtc2 instanceof gloomyfolken.mods.core.misc.ezey && ((gloomyfolken.mods.core.misc.ezey)jxtc2)._k == ezey.kjui._d);
    }

    @ForgeSubscribe
    @ezey(_a={eidj.CLIENT})
    public void _a(ccvb ccvb2) {
        EntityClientPlayerMP entityClientPlayerMP = xpzm._E()._t;
        tewl tewl2 = tewl._a(entityClientPlayerMP);
        if (tewl2 != null) {
            tewl2._a(entityClientPlayerMP.func_82169_q(2), ccvb2._a);
        }
    }

    @ForgeSubscribe
    @ezey(_a={eidj.CLIENT})
    public void _a(dxaz dxaz2) {
        dxaz2._a()._a(new pjna());
    }

    @ForgeSubscribe
    @ezey(_a={eidj.CLIENT})
    public void _a(SoundLoadEvent soundLoadEvent) {
        String string = "/assets/stalker/sound/";
        List<String> list = srxe._a(string);
        for (String string2 : list) {
            soundLoadEvent.manager._a("stalker:" + string2.substring(string.length()));
        }
        soundLoadEvent.manager._c("stalker:mainmenu_ambient.ogg");
    }

    @ForgeSubscribe(priority=EventPriority.LOWEST)
    @ezey(_a={eidj.CLIENT})
    public void _a(fmab fmab2) {
        if (gloomyfolken.mods.effects.client.main.eidj._a._k) {
            float f = fmab2._c * fmab2._e * fmab2._d;
            float f2 = (float)Math.sqrt(fmab2._h * fmab2._h + fmab2._g * fmab2._g + fmab2._f * fmab2._f);
            if ((double)f2 < 0.25) {
                f2 = 0.0f;
            }
            f2 *= f2;
            fmab2._d = (float)Math.sqrt(f);
            fmab2._c = (float)Math.sqrt(f);
            fmab2._e = (float)Math.sqrt(f);
            fmab2._f = 0.1f + (float)Math.sqrt(f2);
            fmab2._h = 0.1f + (float)Math.sqrt(f2);
            fmab2._g = 0.1f + (float)Math.sqrt(f2);
        }
    }

    @ForgeSubscribe
    @ezey(_a={eidj.CLIENT})
    public void _a(lnrm.kjui kjui2) {
        if (kjui2._c == lnrm.pidb._b) {
            oxok._b();
            this._a();
            this._b();
            ivhj._a._b();
            xpzm._E()._M.field_74333_Y = 0.0f;
            if (xpzm._E()._t != null) {
                xpzm._E()._t.field_70737_aN = 0;
            }
            if (Keyboard.isKeyDown(29) && Keyboard.isKeyDown(38) && xpzm._E()._t.field_71075_bZ._d) {
                ParticleEditor.openEditor();
            }
        }
    }

    @ezey(_a={eidj.CLIENT})
    private void _a() {
        xpzm xpzm2 = xpzm._E();
        if (Mouse.isButtonDown(0) && xpzm2._t != null && ugqx._a((EntityPlayer)xpzm2._t)._f != null) {
            StalkerMiscMod.__aa.func_71905_a(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            StalkerMiscMod.__aa.func_71905_a(0.25f, 0.0f, 0.25f, 0.75f, 0.6f, 0.75f);
        }
    }

    @ezey(_a={eidj.CLIENT})
    private void _b() {
        if (_a > 0) {
            --_a;
        }
        xpzm xpzm2 = xpzm._E();
        if (xpzm2._t != null) {
            int n = tupg._a((EntityPlayer)xpzm2._t)._b._e()._e();
            if (n > 0 && !this._d) {
                int n2 = _a = _a == 0 ? 60 : _a;
            }
            if (xpzm2._t.func_110143_aJ() <= 0.0f) {
                _a = 0;
            }
            boolean bl = this._d = n > 0;
            if (n > 0) {
                if (!this._e || xpzm2._r.field_73012_v.nextInt(300) < n * 2) {
                    xpzm2._N._a("stalker:psy_voices_", 1.0f, 1.0f);
                    this._e = true;
                }
            } else {
                this._e = false;
            }
        }
    }

    @ForgeSubscribe
    public void _a(jymv.pidb pidb2) {
        if (!tupg._a(pidb2.entityPlayer)._d()) {
            pidb2.setCanceled(true);
        }
    }

    @ForgeSubscribe
    public void _a(mquk mquk2) {
        mquk2._a("stalker_inv", new tupg(mquk2._a));
        mquk2._a("Recipes", new magc(mquk2._a));
    }

    @ForgeSubscribe
    public void _a(jymv.kjui kjui2) {
        tupg tupg2 = tupg._a(kjui2.entityPlayer);
        if (tupg2._d()) {
            kjui2.entityPlayer.field_70181_x += (double)(tupg2._d._t * 0.1f);
        }
    }

    @ForgeSubscribe
    @ezey(_a={eidj.CLIENT})
    public void _a(qlgf.ezey ezey2) {
        AbstractClientPlayer abstractClientPlayer = ezey2._a;
        tewl tewl2 = tewl._a(abstractClientPlayer);
        if (tewl2 != null) {
            tewl2._a(abstractClientPlayer.func_82169_q(2), ezey2._c);
        }
        ccxr ccxr2 = ncwh._a(abstractClientPlayer);
        cvzo cvzo2 = ccxr2._f._b();
        if (cvzo2 != null) {
            ndfq._a((brhe)cvzo2._a())._a(cvzo2, ezey2._c);
        }
    }

    @ForgeSubscribe
    @ezey(_a={eidj.CLIENT})
    public void _a(GuiOpenEvent guiOpenEvent) {
        if (guiOpenEvent.gui instanceof fngq && !(guiOpenEvent.gui instanceof bafe)) {
            guiOpenEvent.setCanceled(true);
            xpzm._E()._a(new bafe());
            if (_f) {
                xpzm._E()._a(new texo(xpzm._E()._B));
            }
        }
        if (guiOpenEvent.gui instanceof gqju && !GloomyLoadingPlugin._a) {
            guiOpenEvent.setCanceled(true);
            xpzm._E()._a(new bafe());
        }
    }

    @ForgeSubscribe
    @ezey(_a={eidj.CLIENT})
    public void _a(anrg anrg2) {
        StalkerMiscMod stalkerMiscMod = StalkerMiscMod.instance;
        if (anrg2._a && stalkerMiscMod.__au.value != 0) {
            anrg2.setCanceled(true);
            new numa((byte)(anrg2._c + 8), stalkerMiscMod.__at.enabled).sendToServer();
        }
    }
}

