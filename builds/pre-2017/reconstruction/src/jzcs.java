/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.entity.jxtc;
import gloomyfolken.mods.effects.client.main.eidj;
import gloomyfolken.mods.effects.client.main.zwaw;
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import gloomyfolken.mods.effects.client.mcsa.vjsq;
import gloomyfolken.mods.stalker.hud.StalkerGuiMod;
import gloomyfolken.mods.stalker.player.qlgf;
import gloomyfolken.mods.stalker.player.tupg;
import gloomyfolken.mods.weapon.WeaponMod;
import gloomyfolken.mods.weapon.pidb;
import gloomyfolken.mods.weapon.ugqx;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class jzcs {
    public static boolean _a;
    private static Minecraft _e;
    private static final ResourceLocation _f;
    private static int _g;
    private static float _h;
    private static float _i;
    public static float _b;
    public static float _c;
    private static long _j;
    private static boolean _k;
    private static boolean _l;
    private static boolean _m;
    public static boolean _d;
    private float _n;
    private boolean _o;
    private static final int _p = 3;
    private int _q;
    private boolean _r;
    private static final int _s = 40;

    public jzcs() {
        this._n = jzcs._e._M.mouseSensitivity;
        this._q = -1;
    }

    private float _a() {
        ugqx ugqx2 = ugqx._a(Minecraft._E()._t);
        if (!pjux._g(Minecraft._E()._t.getCurrentEquippedItem())) {
            return -1.0f;
        }
        return ugqx2._p();
    }

    private boolean _b() {
        if (Minecraft._E()._t == null) {
            return false;
        }
        return ugqx._a(Minecraft._E()._t)._a();
    }

    private void _c() {
        if (this._b()) {
            eidj._a._k = true;
        }
    }

    @ForgeSubscribe
    public void _a(lnrm.ezey ezey2) {
        if (ezey2._a == lnrm.zwat._e && ezey2._c == lnrm.pidb._a && jzcs._e._t != null) {
            ugqx._a(jzcs._e._t)._a(jxtc._a(jzcs._e._t), jzcs._e._p._d);
        }
    }

    @ForgeSubscribe
    public void _a(tvms.pidb pidb2) {
        if (this._b()) {
            oxth._h();
        }
    }

    @ForgeSubscribe
    public void _a(jylm.eidj eidj2) {
        if ((double)this._a() > 0.0) {
            ejef.kjui._b._a();
        }
    }

    @ForgeSubscribe
    public void _a(jylm.kjui kjui2) {
        if ((double)this._a() > 0.0) {
            kjui2._d |= 0x400;
        }
    }

    @ForgeSubscribe
    public void _a(jylm.pidb pidb2) {
        float f = this._a();
        if ((double)f > 0.0) {
            ejef.kjui._b._c();
            ieoo._a(true, f * 0.05f, zwaw._j());
            ejef.kjui._b._d();
        }
    }

    @ForgeSubscribe
    public void _b(jylm.eidj eidj2) {
        if (Minecraft._E()._B instanceof majr) {
            eidj2.setCanceled(true);
        }
    }

    @ForgeSubscribe
    public void _a(yund.jgro.kjui kjui2) {
        if (kjui2.entityPlayer == jzcs._e._t) {
            uiaq._k()._h();
        }
    }

    @ForgeSubscribe
    public void _a(yund.ezey ezey2) {
        if (ezey2.entityPlayer == jzcs._e._t) {
            uiaq._k()._a(ezey2._a, ezey2._b);
        }
    }

    @ForgeSubscribe
    public void _a(yund.eidj eidj2) {
        if (eidj2.entityPlayer == jzcs._e._t) {
            uiaq._k()._g();
        }
    }

    @ForgeSubscribe
    public void _a(yund.zwat zwat2) {
        if (zwat2.entityPlayer == jzcs._e._t) {
            uiaq._k()._a(zwat2._a);
        }
    }

    @ForgeSubscribe
    public void _a(yund.pidb pidb2) {
        if (pidb2.entityPlayer == jzcs._e._t) {
            uiaq._k()._j();
        }
    }

    @ForgeSubscribe
    public void _a(yund.kjui kjui2) {
        if (kjui2.entityPlayer == jzcs._e._t) {
            uiaq._k()._i();
        }
    }

    @ForgeSubscribe
    public void _a(RenderPlayerEvent.Specials.Pre pre) {
        EntityPlayer entityPlayer = pre.entityPlayer;
        if (pre.renderer.mainModel instanceof ModelBiped) {
            ModelBiped modelBiped = (ModelBiped)pre.renderer.mainModel;
            GL11.glPushMatrix();
            modelBiped.bipedBody.postRender(0.0625f);
            ccxr ccxr2 = ncwh._a(entityPlayer);
            ItemStack itemStack = ccxr2._f._b();
            if (sbzn._h.enabled) {
                this._a(entityPlayer, itemStack != null, false);
            }
            GL11.glPopMatrix();
        }
    }

    @ForgeSubscribe
    public void _a(qlgf.ezey ezey2) {
        ezfc._a();
        vjsq._a(ezey2._c, tupg._c._a((String)"body")._c);
        ccxr ccxr2 = ncwh._a(ezey2._a);
        ItemStack itemStack = ccxr2._f._b();
        if (sbzn._h.enabled) {
            this._a(ezey2._a, itemStack != null, true);
        }
        ezfc._b();
    }

    private void _a(EntityPlayer entityPlayer, boolean bl, boolean bl2) {
        ugqx ugqx2 = ugqx._a(entityPlayer);
        if (ugqx2._j() != null && pjux._a(ugqx2._j()._d) != null) {
            pjux._a(ugqx2._j()._d)._a(entityPlayer, bl ? pjux.pidb._b : pjux.pidb._a, ugqx2._j(), bl2);
        }
        if (ugqx2._i() != null && pjux._a(ugqx2._i()._d) != null) {
            pjux._a(ugqx2._i()._d)._a(entityPlayer, pjux.pidb._c, ugqx2._i(), bl2);
        }
    }

    @ForgeSubscribe
    public void _a(lnrm.kjui kjui2) {
        if (kjui2._c == lnrm.pidb._a) {
            this._e();
            this._f();
            this._d();
            this._c();
        }
        if (kjui2._c == lnrm.pidb._b) {
            this._g();
        }
    }

    private void _d() {
        boolean bl;
        boolean bl2 = bl = jzcs._e._t != null && ugqx._a(jzcs._e._t)._l();
        if (bl != this._o) {
            if (bl) {
                this._n = jzcs._e._M.mouseSensitivity;
                ItemStack itemStack = jzcs._e._t.getCurrentEquippedItem();
                jzcs._e._M.mouseSensitivity = this._n / ((wolf)itemStack._a())._S(itemStack);
            } else {
                jzcs._e._M.mouseSensitivity = this._n;
            }
            this._o = bl;
        }
    }

    private void _e() {
        if (jzcs._e.__ab && Keyboard.isKeyDown(64) && jzcs._e._t != null && jzcs._e._t.getCurrentEquippedItem() != null && jzcs._e._t.capabilities._d && jzcs._e._t.getCurrentEquippedItem()._a() instanceof wolf) {
            wolf wolf2 = (wolf)jzcs._e._t.getCurrentEquippedItem()._a();
            _e._a(new yuni(wolf2.__af));
        }
    }

    private void _f() {
        if (!sbzn._e.enabled) {
            return;
        }
        if (!jzcs._e.__ab || jzcs._e._t == null) {
            return;
        }
        ItemStack itemStack = jzcs._e._t.getHeldItem();
        if (itemStack == null || !(itemStack._a() instanceof wolf)) {
            return;
        }
        wolf wolf2 = (wolf)itemStack._a();
        if (ugqx._a(jzcs._e._t)._a(itemStack) != ugqx.pidb._a) {
            return;
        }
        if (ugqx._a(jzcs._e._t)._f()) {
            if (wolf2._z(itemStack) != 0) {
                return;
            }
            xrox xrox2 = wolf2._a(itemStack, dxwc.pidb._b, xrox.class);
            if (xrox2 == null) {
                return;
            }
            if (!ncwh._b((EntityPlayer)jzcs._e._t, xrox2._i)) {
                return;
            }
        } else {
            if (wolf._E(jzcs._e._t.getHeldItem()) != 0) {
                return;
            }
            if (!ncwh._b((EntityPlayer)jzcs._e._t, wolf2._b)) {
                return;
            }
        }
        ugqx._a(jzcs._e._t)._a(0);
    }

    private void _g() {
        wnja._a(jzcs._e._t);
        this._h();
        if ((_b != 0.0f || _c != 0.0f) && jzcs._e._t != null) {
            jzcs._e._t.rotationYaw -= _c;
            jzcs._e._t.rotationPitch -= _b;
            _b = 0.0f;
            _c = 0.0f;
        }
        wnja._b(jzcs._e._t);
    }

    private void _h() {
        ugqx ugqx2 = jzcs._e._t != null ? ugqx._a(jzcs._e._t) : null;
        _m = _d;
        if (ugqx2 == null || !ugqx2._l()) {
            _d = false;
            _g = 0;
            return;
        }
        float f = StalkerGuiMod._d._c();
        boolean bl = WeaponMod.instance._C._e;
        boolean bl2 = f < 1.0f;
        boolean bl3 = _d = bl2 && bl && !_l;
        if (bl && _m && !_d) {
            _l = true;
        } else if (!bl) {
            _l = false;
        }
        this._a(f);
        if (--_g <= 0) {
            ItemStack itemStack = jzcs._e._t.getCurrentEquippedItem();
            wolf wolf2 = (wolf)itemStack._a();
            float f2 = wolf2._q(itemStack);
            f2 *= 1.0f + f * 3.0f;
            _g = 5 + jzcs._e._r.rand.nextInt(15);
            _i = ((float)Math.random() - 0.5f) * 0.5f * (f2 *= 1.0f + (htcn._a()._d - 1.0f) * ugqx2._o);
            _h = ((float)Math.random() - 0.5f) * 0.5f * f2;
        }
        if (!_d) {
            jzcs._e._t.setAngles(_h, _i);
        }
    }

    private void _a(float f) {
        Random random;
        if (!_m && _d) {
            boolean bl = _k = (double)f < 0.8;
            if (_k) {
                if (System.currentTimeMillis() - _j > 600L) {
                    random = jzcs._e._r.rand;
                    jzcs._e._N._a("weapons:breath_in", 1.0f, 0.9f + random.nextFloat() * 0.1f);
                }
                _j = System.currentTimeMillis();
            }
        }
        if (_m && !_d && _k && System.currentTimeMillis() - _j > 500L) {
            random = jzcs._e._r.rand;
            jzcs._e._N._a("weapons:breath_out", 0.3f + random.nextFloat() * 0.5f, 0.9f + random.nextFloat() * 0.2f);
            _j = System.currentTimeMillis();
        }
    }

    @ForgeSubscribe
    public void _a(FOVUpdateEvent fOVUpdateEvent) {
        float f;
        Minecraft minecraft = Minecraft._E();
        if (minecraft._t != null && minecraft._t.inventory._a() != null && minecraft._t.inventory._a()._a() instanceof wolf) {
            ugqx ugqx2 = ugqx._a(minecraft._t);
            ItemStack itemStack = minecraft._t.inventory._a();
            f = fOVUpdateEvent.fov / ((wolf)itemStack._a())._S(itemStack);
            fOVUpdateEvent.newfov = jywc._a(fOVUpdateEvent.fov, f, ugqx2._p());
        }
        fOVUpdateEvent.newfov -= sbzn._a() / 100.0f;
        if (_d || _m) {
            float f2 = _d ? 1.0f : 0.0f;
            float f3 = _d != _m ? 1.0f - f2 : f2;
            f = jywc._a(f3, f2, Minecraft._E()._p._d);
            fOVUpdateEvent.newfov = (float)((double)fOVUpdateEvent.newfov * (0.99 - 0.1 * (double)f));
        }
    }

    @ForgeSubscribe
    public void _b(lnrm.kjui kjui2) {
        if (this._r && !jzcs._e.__ab) {
            this._r = false;
        }
        if (kjui2._c != lnrm.pidb._b) {
            return;
        }
        boolean bl = false;
        boolean bl2 = false;
        if (this._q >= 0 && this._q < 3) {
            Minecraft minecraft = Minecraft._E();
            ugqx ugqx2 = ugqx._a(minecraft._t);
            if (ugqx2._g() == ugqx.kjui._b) {
                ugqx.pidb pidb2 = pidb._a(false);
                if (pidb2 == ugqx.pidb._f) {
                    bl2 = true;
                } else if (pidb2 == ugqx.pidb._a) {
                    bl = true;
                }
            }
        }
        if (bl) {
            ++this._q;
        } else if (!bl2) {
            this._q = -1;
        }
    }

    @ForgeSubscribe
    public void _a(PlayerInteractEvent playerInteractEvent) {
        ItemStack itemStack = playerInteractEvent.entityPlayer.getCurrentEquippedItem();
        if (itemStack != null && itemStack._a() instanceof wolf) {
            playerInteractEvent.setCanceled(true);
        }
    }

    @ForgeSubscribe
    public void _a(anrz anrz2) {
        Minecraft minecraft = Minecraft._E();
        if (anrz2._a == anrz.kjui._a && anrz2._b == anrz.pidb._a) {
            this._r = minecraft.__ab;
        }
        if (minecraft._t == null || anrz2.isCanceled()) {
            return;
        }
        ugqx ugqx2 = ugqx._a(minecraft._t);
        ItemStack itemStack = minecraft._t.getHeldItem();
        if (ugqx2._f != null) {
            if (anrz2._a == anrz.kjui._a && anrz2._b != anrz.pidb._c) {
                pidb._a(anrz2._b == anrz.pidb._a);
                anrz2.setCanceled(true);
            }
        } else if (itemStack != null && itemStack._a() instanceof wolf) {
            switch (anrz2._a) {
                case _a: {
                    if (ugqx2._f()) {
                        if (anrz2._b == anrz.pidb._a) {
                            xrox._a(minecraft._t);
                        }
                    } else {
                        switch (ugqx2._g()) {
                            case _c: {
                                if (anrz2._b != anrz.pidb._a) break;
                                pidb._a(true);
                                break;
                            }
                            case _b: {
                                if (anrz2._b != anrz.pidb._a || this._q >= 0) break;
                                this._q = 0;
                                break;
                            }
                            case _a: {
                                if (anrz2._b == anrz.pidb._c || anrz2._b != anrz.pidb._a && !this._r) break;
                                pidb._a(anrz2._b == anrz.pidb._a);
                            }
                        }
                    }
                    anrz2.setCanceled(true);
                    break;
                }
                case _c: {
                    if (sbzn._f.enabled) {
                        if (anrz2._b != anrz.pidb._a) break;
                        _a = !_a;
                        anrz2.setCanceled(true);
                        break;
                    }
                    if (anrz2._b == anrz.pidb._a) {
                        _a = true;
                        anrz2.setCanceled(true);
                        break;
                    }
                    if (anrz2._b != anrz.pidb._c) break;
                    _a = false;
                    anrz2.setCanceled(true);
                }
            }
        }
    }

    @ForgeSubscribe
    public void _a(RenderPlayerEvent.Pre pre) {
        if (pre.entityPlayer.getHeldItem() != null && pre.entityPlayer.getHeldItem()._a() instanceof wolf) {
            pre.renderer.modelArmorChestplate.aimedBow = true;
            pre.renderer.modelArmor.aimedBow = true;
            pre.renderer.modelBipedMain.aimedBow = true;
        }
    }

    @ForgeSubscribe
    public void _a(qlgf.eidj eidj2) {
        if (eidj2._a.getHeldItem() != null && eidj2._a.getHeldItem()._a() instanceof wolf) {
            eidj2._c.aimedBow = true;
        }
    }

    @ForgeSubscribe
    public void _a(xqsm xqsm2) {
        float f;
        boolean bl;
        ItemRenderer itemRenderer = xqsm2._a;
        itemRenderer.prevEquippedProgress = itemRenderer.equippedProgress;
        EntityClientPlayerMP entityClientPlayerMP = itemRenderer.mc._t;
        ItemStack itemStack = entityClientPlayerMP.inventory._a();
        boolean bl2 = bl = itemRenderer.equippedItemSlot == entityClientPlayerMP.inventory._c && itemStack == itemRenderer.itemToRender;
        if (itemRenderer.itemToRender == null && itemStack == null) {
            bl = true;
        }
        if (itemStack != null && itemRenderer.itemToRender != null && itemStack != itemRenderer.itemToRender && itemStack._d == itemRenderer.itemToRender._d) {
            itemRenderer.itemToRender = itemStack;
            bl = true;
        }
        if (!entityClientPlayerMP.isEntityAlive()) {
            itemRenderer.equippedProgress = Math.max(itemRenderer.equippedProgress - 0.4f, 0.0f);
            xqsm2.setCanceled(true);
            return;
        }
        float f2 = bl ? 1.0f : 0.0f;
        float f3 = f2 - itemRenderer.equippedProgress;
        if (f3 < -(f = 0.4f)) {
            f3 = -f;
        }
        if (f3 > f) {
            f3 = f;
        }
        itemRenderer.equippedProgress += f3;
        if (itemRenderer.equippedProgress < 0.1f) {
            itemRenderer.itemToRender = itemStack;
            itemRenderer.equippedItemSlot = entityClientPlayerMP.inventory._c;
        }
        if (itemRenderer.itemToRender != null && itemRenderer.itemToRender._a() instanceof wolf && itemRenderer.equippedProgress > itemRenderer.prevEquippedProgress) {
            itemRenderer.equippedProgress = 1.0f;
            itemRenderer.prevEquippedProgress = 1.0f;
        }
        xqsm2.setCanceled(true);
    }

    @ForgeSubscribe
    public void _a(rpct.kjui kjui2) {
        if (yuni._d) {
            GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
        }
    }

    @ForgeSubscribe
    public void _a(ncux ncux2) {
        if (ncux2._o) {
            return;
        }
        ModelBiped modelBiped = ncux2._b;
        EntityPlayer entityPlayer = ncux2._a;
        if (modelBiped.aimedBow && entityPlayer.getCurrentEquippedItem() != null && entityPlayer.getCurrentEquippedItem()._a() instanceof wolf && ((wolf)entityPlayer.getCurrentEquippedItem()._a())._O && !rpdf.instance.isPlayerCrawling(entityPlayer)) {
            modelBiped.aimedBow = false;
            float f = ncux2._k.rotateAngleX;
            float f2 = ncux2._k.rotateAngleY;
            float f3 = ncux2._k.rotateAngleZ;
            ncux2._a();
            modelBiped.aimedBow = true;
            ncux2._k.rotateAngleX = f;
            ncux2._k.rotateAngleY = f2;
            ncux2._k.rotateAngleZ = f3;
        }
        ugqx ugqx2 = ugqx._a(entityPlayer);
        if (modelBiped.aimedBow && ugqx2._n()) {
            wolf wolf2 = ugqx2._r();
            pjux pjux2 = pjux._a(wolf2);
            if (pjux2._m == null) {
                float f = ugqx2._b(Minecraft._E()._p._d);
                ncux2._k.rotateAngleX = ncux2._i.rotateAngleX + (ncux2._k.rotateAngleX - ncux2._i.rotateAngleX) * (1.0f - f);
                if (ugqx2._r() == null || !ugqx2._r()._O) {
                    ncux2._l.rotateAngleX = ncux2._i.rotateAngleX + (ncux2._l.rotateAngleX - ncux2._i.rotateAngleX) * (1.0f - f);
                }
            } else {
                float f = ugqx2._c(Minecraft._E()._p._d);
                pjux2._m._a(ncux2, f);
            }
        }
    }

    @ForgeSubscribe
    public void _a(RenderGameOverlayEvent.Post post) {
        if (post.type == RenderGameOverlayEvent.ElementType.ALL) {
            this._a(jzcs._e._J, post.resolution, post.partialTicks);
            if (jzcs._e._t != null) {
                ugqx ugqx2 = ugqx._a(jzcs._e._t);
                int n = ugqx2._i;
                if (n < 40) {
                    String string = ugqx2._k;
                    int n2 = (int)((float)(40 - n) * 256.0f / 20.0f);
                    if (n2 > 255) {
                        n2 = 255;
                    }
                    if (n2 > 0) {
                        int n3 = post.resolution._b() - 45;
                        if (!jzcs._e._j._b()) {
                            n3 += 14;
                        }
                        GL11.glPushMatrix();
                        GL11.glEnable(3042);
                        GL11.glDisable(3008);
                        GL11.glBlendFunc(770, 771);
                        int n4 = (post.resolution._a() - jzcs._e._z._b(string)) / 2;
                        jzcs._e._z._a(string, n4, n3, 0xFFFFFF | n2 << 24);
                        GL11.glEnable(3008);
                        GL11.glDisable(3042);
                        GL11.glPopMatrix();
                        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                    }
                }
            }
        }
    }

    private void _a(GuiIngame guiIngame, htou htou2, float f) {
        int n;
        jzcs._e._h._a(_f);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3008);
        nuoa nuoa2 = sbzn._b;
        if (nuoa2._c != null) {
            float f2 = 1.0f;
            if (nuoa2._c._b > 7) {
                f2 = (float)((15 - nuoa2._c._b) * 2) / 15.0f;
            }
            GL11.glColor4f(1.0f, 0.0f, 0.0f, f2);
            for (n = 0; n < nuoa2._c._a.ordinal() - 1; ++n) {
                guiIngame.drawTexturedModalRect(htou2._a() / 2 - 12 - n * 10, htou2._b() / 2 - 12 - n * 10, 229, 4, 12, 12);
                guiIngame.drawTexturedModalRect(htou2._a() / 2 + n * 10, htou2._b() / 2 - 12 - n * 10, 240, 4, 12, 12);
                guiIngame.drawTexturedModalRect(htou2._a() / 2 - 12 - n * 10, htou2._b() / 2 + n * 10, 229, 16, 12, 12);
                guiIngame.drawTexturedModalRect(htou2._a() / 2 + n * 10, htou2._b() / 2 + n * 10, 240, 16, 12, 12);
            }
        }
        if (nuoa2._d != null) {
            EntityClientPlayerMP entityClientPlayerMP = jzcs._e._t;
            n = htou2._a() / 2;
            int n2 = htou2._b() / 2;
            GL11.glTexParameteri(3553, 10240, 9729);
            GL11.glTexParameteri(3553, 10241, 9729);
            float f3 = nuoa2._d._a - (float)(entityClientPlayerMP.lastTickPosX + (entityClientPlayerMP.posX - entityClientPlayerMP.lastTickPosX) * (double)f);
            float f4 = nuoa2._d._b - (float)(entityClientPlayerMP.lastTickPosZ + (entityClientPlayerMP.posZ - entityClientPlayerMP.lastTickPosZ) * (double)f);
            float f5 = (float)Math.atan2(f4, f3) * 180.0f / (float)Math.PI;
            float f6 = 180.0f + entityClientPlayerMP.prevRotationYaw + (entityClientPlayerMP.rotationYaw - entityClientPlayerMP.prevRotationYaw) * f;
            float f7 = f5 - f6;
            for (int i = 0; i < 3; ++i) {
                float f8 = (float)((System.currentTimeMillis() + (long)(i * 1000)) % 3000L) / 1500.0f;
                if (f8 > 1.0f) {
                    f8 = 2.0f - f8;
                }
                if (nuoa2._d._c > 30) {
                    f8 *= (float)((60 - nuoa2._d._c) * 2) / 60.0f;
                }
                GL11.glColor4f(1.0f, 0.0f, 0.0f, f8);
                GL11.glPushMatrix();
                GL11.glTranslatef(n, n2, 0.0f);
                GL11.glRotatef(f7, 0.0f, 0.0f, 1.0f);
                GL11.glTranslatef(-n, -n2, 0.0f);
                guiIngame.drawTexturedModalRect(n + 60, n2 - 98, 109 + i % 3 * 49, 122, 49, 99);
                this._a(n + 60, n2, 109 + i % 3 * 49, 122, 49, 99, guiIngame.zLevel);
                GL11.glPopMatrix();
            }
            GL11.glTexParameteri(3553, 10240, 9728);
            GL11.glTexParameteri(3553, 10241, 9728);
        }
        GL11.glEnable(3008);
        GL11.glDisable(3042);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }

    private void _a(int n, int n2, int n3, int n4, int n5, int n6, float f) {
        float f2 = 0.00390625f;
        float f3 = 0.00390625f;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(n, n2 + n6, f, (float)n3 * f2, (float)n4 * f3);
        tessellator.addVertexWithUV(n + n5, n2 + n6, f, (float)(n3 + n5) * f2, (float)n4 * f3);
        tessellator.addVertexWithUV(n + n5, n2, f, (float)(n3 + n5) * f2, (float)(n4 + n6) * f3);
        tessellator.addVertexWithUV(n, n2, f, (float)n3 * f2, (float)(n4 + n6) * f3);
        tessellator.draw();
    }

    static {
        _e = Minecraft._E();
        _f = new ResourceLocation("weapons", "textures/gui/hud.png");
        _g = 0;
        _h = 0.0f;
        _i = 0.0f;
        _j = 0L;
        _k = false;
        _l = false;
        _m = false;
        _d = false;
    }
}

