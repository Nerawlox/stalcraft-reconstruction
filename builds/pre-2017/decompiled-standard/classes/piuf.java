/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.core.entity.jxtc;
import gloomyfolken.mods.core.main.ClientProxy;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.core.misc.hanr;
import gloomyfolken.mods.core.misc.jxsn;
import gloomyfolken.mods.core.misc.owak;
import gloomyfolken.mods.core.misc.sajh;
import gloomyfolken.mods.core.misc.ybzs;
import gloomyfolken.mods.stalker.hud.tupg;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ezfc;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.WorldEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class piuf {
    private xpzm _d = xpzm._E();
    private HashMap<Entity, Integer> _e = new HashMap();
    private boolean _f = false;
    public static int _a;
    public static int _b;
    public static long _c;

    @ForgeSubscribe
    public void _a(yund.pidb pidb2) {
        jxtc jxtc2 = jxtc._a(this._d._t);
        if (jxtc2 != null) {
            jxtc2._s();
        }
    }

    @ForgeSubscribe
    public void _a(lnrm.ezey ezey2) {
        if (ezey2._a == lnrm.zwat._e && ezey2._c == lnrm.pidb._a && this._d._t != null) {
            cvzo cvzo2 = this._d._t.func_71045_bC();
            jxtc jxtc2 = jxtc._a(this._d._t);
            if (jxtc2 != null && cvzo2 != null && cvzo2._a() instanceof ybzs) {
                ybzs ybzs2 = (ybzs)cvzo2._a();
                boolean bl = jxtc2._h() && jxtc2._e() < 0;
                jxtc2._a(this._d._p._d, bl ? null : ybzs2, ybzs2._c((float)ybzs2._n() * 0.75f + 1.0f));
            }
        }
    }

    @ForgeSubscribe
    public void _a(xqsm xqsm2) {
        boolean bl;
        jizq jizq2 = xqsm2._a;
        EntityClientPlayerMP entityClientPlayerMP = jizq2.field_78455_a._t;
        cvzo cvzo2 = entityClientPlayerMP.field_71071_by._a();
        boolean bl2 = bl = jizq2.field_78450_g == entityClientPlayerMP.field_71071_by._c && cvzo2 == jizq2.field_78453_b;
        if (bl && jizq2.field_78453_b != null && jizq2.field_78453_b._a() instanceof owak) {
            jizq2.field_78454_c = 1.0f;
            jizq2.field_78451_d = 1.0f;
        }
    }

    @ForgeSubscribe
    public void _a(PlayerInteractEvent playerInteractEvent) {
        cvzo cvzo2 = playerInteractEvent.entityPlayer.func_71045_bC();
        if (cvzo2 != null && cvzo2._a() instanceof owak) {
            playerInteractEvent.setCanceled(true);
        }
    }

    @ForgeSubscribe
    public void _a(anrz anrz2) {
        xpzm xpzm2 = xpzm._E();
        if (xpzm2._t == null || anrz2.isCanceled()) {
            return;
        }
        cvzo cvzo2 = xpzm2._t.func_70694_bm();
        if (cvzo2 != null && cvzo2._a() instanceof owak) {
            int n;
            int n2 = anrz2._a == anrz.kjui._a ? 0 : (n = anrz2._a == anrz.kjui._c ? 1 : -1);
            if (n >= 0) {
                ((owak)((Object)cvzo2._a()))._a(n, anrz2._b);
                anrz2.setCanceled(true);
            }
        }
    }

    @ForgeSubscribe
    public void _a(RenderGameOverlayEvent.Post post) {
        if (post.type == RenderGameOverlayEvent.ElementType.ALL) {
            this._b(post);
            ntsy ntsy2 = ClientProxy.screenCenterMessage;
            if (ntsy2 != null) {
                ExternalFont.tahomaBold17.renderCenteredString(ntsy2._a, post.resolution._a() / 2, post.resolution._b() / 8, 16711627, true);
            }
        }
    }

    private void _b(RenderGameOverlayEvent.Post post) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(770, 771);
        tupg._a._a(post.partialTicks);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
    }

    @ForgeSubscribe
    public void _a(ItemTooltipEvent itemTooltipEvent) {
        if (!itemTooltipEvent.entityPlayer.field_71075_bZ._d && !itemTooltipEvent.toolTip.isEmpty() && itemTooltipEvent.toolTip.get(itemTooltipEvent.toolTip.size() - 1).startsWith("Durability")) {
            itemTooltipEvent.toolTip.remove(itemTooltipEvent.toolTip.size() - 1);
        }
        if (itemTooltipEvent.itemStack._h()) {
            int n = itemTooltipEvent.itemStack._i();
            int n2 = itemTooltipEvent.itemStack._k();
            float f = Math.max(0.0f, Math.min(1.0f, 1.0f - (float)n / (float)n2));
            itemTooltipEvent.toolTip.add(String.format("\u041f\u0440\u043e\u0447\u043d\u043e\u0441\u0442\u044c: %.1f%%", Float.valueOf(f * 100.0f)));
        }
        hanr hanr2 = hanr._b(itemTooltipEvent.itemStack);
        ezfc ezfc2 = hanr2._k;
        String string = ezfc2 != ezfc._p ? String.valueOf((Object)ezfc2) + (Object)((Object)ezfc._u) : "";
        itemTooltipEvent.toolTip.add(1, string + hanr2._j + " \u043f\u0440\u0435\u0434\u043c\u0435\u0442");
        itemTooltipEvent.toolTip.add("");
        itemTooltipEvent.toolTip.addAll(jxsn._b_(itemTooltipEvent.itemStack));
        cvzo cvzo2 = itemTooltipEvent.itemStack;
        qoac qoac2 = cvzo2._e;
        if (qoac2 == null) {
            return;
        }
        if (qoac2._c("src")) {
            String string2;
            boolean bl;
            sajh sajh2 = sajh._o[qoac2._d("src")];
            if (sajh2 == null) {
                return;
            }
            boolean bl2 = bl = itemTooltipEvent.showAdvancedItemTooltips && itemTooltipEvent.entityPlayer.field_71075_bZ._d;
            if (bl) {
                itemTooltipEvent.toolTip.add(sajh2.name());
            }
            if ((sajh2._p || bl) && (string2 = sajh2._a(qoac2._j("sm"))) != null && !string2.isEmpty()) {
                itemTooltipEvent.toolTip.add(string2);
            }
            if (bl && qoac2._c("u1")) {
                itemTooltipEvent.toolTip.add("UUID: " + new UUID(qoac2._g("u1"), qoac2._g("u2")).toString());
            }
        }
    }

    @ForgeSubscribe
    public void _a(RenderLivingEvent.Pre pre) {
        this._e.put(pre.entity, pre.entity.field_70737_aN);
        pre.entity.field_70737_aN = 0;
    }

    @ForgeSubscribe
    public void _a(TextureStitchEvent.Post post) {
        int n = GL11.glGetTexLevelParameteri(3553, 0, 4096);
        int n2 = GL11.glGetTexLevelParameteri(3553, 0, 4097);
        System.out.println("Texture map " + post.map._n + " resolution: " + n + "x" + n2);
    }

    @ForgeSubscribe
    public void _a(RenderLivingEvent.Post post) {
        if (this._e.containsKey(post.entity)) {
            post.entity.field_70737_aN = this._e.get(post.entity);
            this._e.remove(post.entity);
        }
    }

    @ForgeSubscribe
    public void _a(MouseEvent mouseEvent) {
        long l;
        mouseEvent.setCanceled(true);
        int n = Mouse.getEventButton();
        if (xpzm._b && n == 0 && (Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157))) {
            n = 1;
        }
        anrz.kjui kjui2 = null;
        switch (n) {
            case 0: {
                kjui2 = anrz.kjui._a;
                break;
            }
            case 1: {
                kjui2 = anrz.kjui._c;
                break;
            }
            case 2: {
                kjui2 = anrz.kjui._b;
            }
        }
        boolean bl = false;
        if (kjui2 != null && this._d.__ab) {
            anrz anrz2 = new anrz(kjui2, mouseEvent.buttonstate ? anrz.pidb._a : anrz.pidb._c);
            bl = MinecraftForge.EVENT_BUS.post(anrz2);
        }
        if (!bl) {
            net.minecraft.client.settings.eidj._a(n - 100, Mouse.getEventButtonState());
            if (Mouse.getEventButtonState()) {
                net.minecraft.client.settings.eidj._a(n - 100);
            }
        }
        if ((l = xpzm._M() - this._d.__ac) <= 200L) {
            int n2 = Mouse.getEventDWheel();
            if (n2 != 0) {
                this._d._t.field_71071_by._b(n2);
                if (this._d._M.field_74331_S) {
                    if (n2 > 0) {
                        n2 = 1;
                    }
                    if (n2 < 0) {
                        n2 = -1;
                    }
                    this._d._M.field_74328_V += (float)n2 * 0.25f;
                }
            }
            if (this._d._B == null) {
                if (!this._d.__ab && Mouse.getEventButtonState()) {
                    this._d._o();
                }
            } else if (this._d._B != null) {
                this._d._B.func_73867_d();
            }
        }
    }

    @ForgeSubscribe
    public void _a(GuiOpenEvent guiOpenEvent) {
        if (guiOpenEvent.gui instanceof cebg && !this._f && ((cebg)guiOpenEvent.gui).field_74193_d instanceof zwyn) {
            guiOpenEvent.setCanceled(true);
            zwyn zwyn2 = (zwyn)((cebg)guiOpenEvent.gui).field_74193_d;
            zybc zybc2 = GloomyCore.instance.containerFactory._a(zwyn2);
            this._f = true;
            xpzm._E()._a(zybc2);
            this._f = false;
        }
    }

    @ForgeSubscribe
    @ezey(_a={eidj.CLIENT})
    public void _a(DrawBlockHighlightEvent drawBlockHighlightEvent) {
        if (!xpzm._E()._t.field_71075_bZ._e) {
            drawBlockHighlightEvent.setCanceled(true);
        }
    }

    @ForgeSubscribe
    public void _a(RenderWorldLastEvent renderWorldLastEvent) {
        _b = _a;
        _a = 0;
        ++_c;
    }

    @ForgeSubscribe
    public void _a(LivingHurtEvent livingHurtEvent) {
        if (livingHurtEvent.entityLiving instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer)livingHurtEvent.entityLiving;
            if (entityPlayer.field_70170_p.field_72995_K) {
                // empty if block
            }
        }
    }

    private float _a(EntityLivingBase entityLivingBase, float f) {
        return (float)entityLivingBase.field_70173_aa + f;
    }

    @ForgeSubscribe
    public void _a(WorldEvent.Load load) {
        if (load.world.field_72995_K) {
            ((ClientProxy)GloomyCore.proxy).initWorldStatics();
        }
    }

    @ForgeSubscribe
    public void _a(SoundLoadEvent soundLoadEvent) {
        Logger.info("Registering sounds...", new Object[0]);
        long l = System.currentTimeMillis();
        int n = 0;
        for (Map.Entry<String, Class> entry : GloomyCore.instance.assetDirs.entrySet()) {
            String string = "/assets/" + entry.getKey() + "/sound/";
            Logger.finer("Registering sounds in directory " + string, new Object[0]);
            List<String> list2 = srxe._a(string);
            for (String string2 : list2) {
                String string3 = entry.getKey() + ":" + string2.substring(string.length());
                soundLoadEvent.manager._a(string3);
                ++n;
            }
        }
        Logger.info("Registered " + n + " sounds in " + (System.currentTimeMillis() - l) + " ms", new Object[0]);
    }
}

