/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acv
 *  ate
 *  atf
 *  atg
 *  atl
 *  awf
 *  bdi
 *  bdj
 *  bjo
 *  bu
 *  c
 *  cpw.mods.fml.common.FMLCommonHandler
 *  ma
 *  net.minecraftforge.client.GuiIngameForge
 *  net.minecraftforge.client.event.RenderGameOverlayEvent
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$Chat
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$ElementType
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$Post
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$Pre
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$Text
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.Event
 *  ni
 *  org.lwjgl.opengl.GL11
 *  r
 */
package ru.stalcraft.client.gui;

import cpw.mods.fml.common.FMLCommonHandler;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import org.lwjgl.opengl.GL11;
import ru.stalcraft.Contamination;
import ru.stalcraft.client.ClientRenderTicker;
import ru.stalcraft.client.ClientWeaponInfo;
import ru.stalcraft.client.effects.EffectsEngine;
import ru.stalcraft.items.ItemWeapon;
import ru.stalcraft.player.PlayerInfo;
import ru.stalcraft.player.PlayerUtils;

public class GuiIngameStalker
extends GuiIngameForge {
    private static final bjo VIGNETTE = new bjo("textures/misc/vignette.png");
    private static final bjo WIDGITS = new bjo("textures/gui/widgets.png");
    private static final bjo PUMPKIN_BLUR = new bjo("textures/misc/pumpkinblur.png");
    private static final bjo STALKER_GUI = new bjo("stalker", "textures/stalkerGUI.png");
    private static final int WHITE = 0xFFFFFF;
    public static boolean renderHelmet = true;
    public static boolean renderPortal = true;
    public static boolean renderHotbar = true;
    public static boolean renderCrosshairs = true;
    public static boolean renderBossHealth = true;
    public static boolean renderHealth = true;
    public static boolean renderArmor = true;
    public static boolean renderFood = true;
    public static boolean renderHealthMount = true;
    public static boolean renderAir = true;
    public static boolean renderExperiance = true;
    public static boolean renderJumpBar = true;
    public static boolean renderObjective = true;
    public static int left_height = 39;
    public static int right_height = 39;
    private final float[] alpha1Levels = new float[]{0.0f, 0.3f, 0.45f, 0.6f};
    private final float[] alpha2Levels = new float[]{0.0f, 0.45f, 0.6f, 0.75f};
    private awf res = null;
    private avi fontrenderer = null;
    private RenderGameOverlayEvent eventParent;
    private static final String MC_VERSION = new c((b)null).a();

    public GuiIngameStalker(atv mc) {
        super(mc);
    }

    public void a(float partialTicks, boolean hasScreen, int mouseX, int mouseY) {
        this.res = new awf(this.g.u, this.g.d, this.g.e);
        this.eventParent = new RenderGameOverlayEvent(partialTicks, this.res, mouseX, mouseY);
        int width = this.res.a();
        int height = this.res.b();
        renderHealthMount = this.g.h.o instanceof of;
        renderFood = this.g.h.o == null;
        renderJumpBar = this.g.h.u();
        right_height = 39;
        left_height = 39;
        if (!this.pre(RenderGameOverlayEvent.ElementType.ALL)) {
            this.fontrenderer = this.g.l;
            this.g.p.c();
            GL11.glEnable((int)3042);
            GL11.glDisable((int)2896);
            if (atv.s()) {
                this.a(this.g.h.d(partialTicks), width, height);
            } else {
                GL11.glBlendFunc((int)770, (int)771);
            }
            if (renderHelmet) {
                this.renderHelmet(this.res, partialTicks, hasScreen, mouseX, mouseY);
            }
            if (renderPortal && !this.g.h.a(ni.k)) {
                this.renderPortal(width, height, partialTicks);
            }
            PlayerInfo info = PlayerUtils.getInfo((uf)this.g.h);
            Contamination cont = info.cont;
            if (!this.g.c.a()) {
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                this.n = -90.0f;
                this.f.setSeed(this.i * 312871);
                if (!((ClientWeaponInfo)info.weaponInfo).isAiming() && renderCrosshairs) {
                    this.renderCrosshairs(width, height);
                }
                if (ClientRenderTicker.hitMarker > 0) {
                    --ClientRenderTicker.hitMarker;
                    atv mc = atv.w();
                    awf scale = new awf(mc.u, mc.d, mc.e);
                    bfq tessellator = bfq.a;
                    int xCenter = scale.a() / 2;
                    int offset = scale.b() * 2;
                    mc.N.a(new bjo("stalker", "textures/hitmarker.png"));
                    tessellator.b();
                    tessellator.a(xCenter - offset, scale.b(), -100.0, 0.0, 1.0);
                    tessellator.a(xCenter + offset, scale.b(), -100.0, 1.0, 1.0);
                    tessellator.a(xCenter + offset, 0.0, -100.0, 1.0, 0.0);
                    tessellator.a(xCenter - offset, 0.0, -100.0, 0.0, 0.0);
                    tessellator.a();
                }
                if (this.g.c.b()) {
                    String var20;
                    int reputation;
                    GL11.glEnable((int)3042);
                    GL11.glBlendFunc((int)770, (int)771);
                    this.g.N.a(STALKER_GUI);
                    int objective = 0;
                    if (this.g.h.i(5)) {
                        this.drawEffect(0, objective++);
                    }
                    if (this.g.h.i(10)) {
                        this.drawEffect(1, objective++);
                    }
                    if (this.g.h.i(1)) {
                        this.drawEffect(2, objective++);
                    }
                    bdi p2 = this.g.h;
                    this.b(this.res.a() - 6 - 111, this.res.b() - 6 - 63, 79, 0, 111, 63);
                    this.b(this.res.a() - 6 - 83, this.res.b() - 6 - 56, 79, 68, this.getEnd((int)p2.aN(), (int)p2.aT()), 8);
                    this.b(this.res.a() - 6 - 83, this.res.b() - 6 - 45, 79, 79, this.getEnd(p2.aQ(), 20), 6);
                    objective = 0;
                    for (reputation = 0; reputation < 3; ++reputation) {
                        if (cont.getLevel(reputation) <= 0) continue;
                        this.drawRightIcon(reputation, cont.getLevel(reputation), objective++);
                    }
                    if (cont.getLevel(3) > 0) {
                        this.drawRightIcon(3, 3, objective++);
                    }
                    if (this.g.h.bI().a() == 0) {
                        this.drawRightIcon(4, 4, objective++);
                    } else if (this.g.h.bI().a() <= 10) {
                        this.drawRightIcon(4, 3, objective++);
                    } else if (this.g.h.bI().a() <= 18) {
                        this.drawRightIcon(4, 2, objective++);
                    } else {
                        this.drawRightIcon(4, 1, objective++);
                    }
                    if (this.g.h.i(19)) {
                        if (this.g.h.b(ni.u).c() == 0) {
                            this.drawRightIcon(5, 1, objective++);
                        } else if (this.g.h.b(ni.u).c() == 1) {
                            this.drawRightIcon(5, 2, objective++);
                        } else {
                            this.drawRightIcon(5, 3, objective++);
                        }
                    }
                    if ((reputation = info.getReputation()) >= 0) {
                        this.b(this.res.a() - 90, this.res.b() - 27, 64, 57, 10, 12);
                    } else {
                        this.b(this.res.a() - 90, this.res.b() - 27, 64, 40, 10, 12);
                    }
                    float weightSpeed = info.getWeightSpeed();
                    if (weightSpeed >= 1.0f) {
                        this.drawRightIcon(6, 1, objective++);
                    } else if (weightSpeed >= 0.6f) {
                        this.drawRightIcon(6, 2, objective++);
                    } else if (weightSpeed >= 0.2f) {
                        this.drawRightIcon(6, 3, objective++);
                    } else {
                        this.drawRightIcon(6, 4, objective++);
                    }
                    GL11.glDisable((int)3042);
                    if (info.weaponInfo.currentGun != null) {
                        String deathScoreStr = String.valueOf(info.weaponInfo.currentGun.bulletsInCage);
                        this.g.l.b(deathScoreStr, this.res.a() - 97 - this.g.l.a(deathScoreStr) / 2, this.res.b() - 25 + 1, 0xFFFFFF);
                    } else if (this.g.h.bn.h() != null && this.g.h.bn.h().b() instanceof ItemWeapon) {
                        ItemWeapon var19 = (ItemWeapon)this.g.h.bn.h().b();
                        if (var19.grenadeId != 0) {
                            int reputationStr = 0;
                            for (ye stack : this.g.h.bn.a) {
                                if (stack == null || stack.d != var19.grenadeId) continue;
                                reputationStr += stack.b;
                            }
                            String var21 = String.valueOf(reputationStr);
                            this.g.l.b(var21, this.res.a() - 97 - this.g.l.a(var21) / 2, this.res.b() - 41, 0xFFFFFF);
                        }
                        var20 = String.valueOf(PlayerUtils.getTag(this.g.h.bn.h()).e("cage"));
                        this.g.l.b(var20, this.res.a() - 97 - this.g.l.a(var20) / 2, this.res.b() - 24, 0xFFFFFF);
                    }
                    String deathScoreStr = String.valueOf(info.getDeathScore());
                    this.g.l.b(deathScoreStr, this.res.a() - 67 - this.g.l.a(deathScoreStr) / 2, this.res.b() - 41, 0xFFFFFF);
                    var20 = String.valueOf(reputation);
                    this.g.l.b(var20, this.res.a() - 67 - this.g.l.a(var20) / 2, this.res.b() - 24, 0xFFFFFF);
                }
                if (renderHotbar) {
                    this.renderHotbar(width, height, partialTicks);
                }
            }
            this.renderSleepFade(width, height);
            this.renderToolHightlight(width, height);
            this.renderHUDText(width, height);
            this.renderRecordOverlay(width, height, partialTicks);
            ate var22 = this.g.f.X().a(1);
            if (renderObjective && var22 != null) {
                this.a(var22, height, width, this.fontrenderer);
            }
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glDisable((int)3008);
            this.renderChat(width, height);
            this.renderPlayerList(width, height);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glDisable((int)2896);
            GL11.glEnable((int)3008);
            this.post(RenderGameOverlayEvent.ElementType.ALL);
        }
    }

    public awf getResolution() {
        return this.res;
    }

    protected void renderHotbar(int width, int height, float partialTicks) {
        if (!this.pre(RenderGameOverlayEvent.ElementType.HOTBAR)) {
            this.res = new awf(this.g.u, this.g.d, this.g.e);
            GL11.glDisable((int)3042);
            this.g.C.a("actionBar");
            GL11.glEnable((int)32826);
            att.c();
            for (int i2 = 0; i2 < 4; ++i2) {
                int i4 = 3 + i2 * 20 + 2;
                int j2 = height - 16 - 3;
                this.a(i2 + 44, i4, j2, partialTicks);
            }
            this.a(this.g.h.bn.c, this.res.a() - 6 - 31, this.res.b() - 6 - 28, partialTicks);
            att.a();
            GL11.glDisable((int)32826);
            this.g.C.b();
            this.post(RenderGameOverlayEvent.ElementType.HOTBAR);
        }
    }

    protected void renderCrosshairs(int width, int height) {
        if (!this.pre(RenderGameOverlayEvent.ElementType.CROSSHAIRS)) {
            this.bind(avk.m);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)775, (int)769);
            this.b(width / 2 - 7, height / 2 - 7, 0, 0, 16, 16);
            GL11.glDisable((int)3042);
            this.post(RenderGameOverlayEvent.ElementType.CROSSHAIRS);
        }
    }

    private void renderHelmet(awf res, float partialTicks, boolean hasScreen, int mouseX, int mouseY) {
        if (!this.pre(RenderGameOverlayEvent.ElementType.HELMET)) {
            ye itemstack = this.g.h.bn.f(3);
            if (this.g.u.aa == 0 && itemstack != null && itemstack.b() != null) {
                if (itemstack.d == aqz.bf.cF) {
                    this.b(res.a(), res.b());
                } else {
                    itemstack.b().renderHelmetOverlay(itemstack, (uf)this.g.h, res, partialTicks, hasScreen, mouseX, mouseY);
                }
            }
            this.post(RenderGameOverlayEvent.ElementType.HELMET);
        }
    }

    protected void renderPortal(int width, int height, float partialTicks) {
        if (!this.pre(RenderGameOverlayEvent.ElementType.PORTAL)) {
            float f1 = this.g.h.bO + (this.g.h.bN - this.g.h.bO) * partialTicks;
            if (f1 > 0.0f) {
                this.b(f1, width, height);
            }
            this.post(RenderGameOverlayEvent.ElementType.PORTAL);
        }
    }

    protected void renderSleepFade(int width, int height) {
        if (this.g.h.bE() > 0) {
            this.g.C.a("sleep");
            GL11.glDisable((int)2929);
            GL11.glDisable((int)3008);
            int sleepTime = this.g.h.bE();
            float opacity = (float)sleepTime / 100.0f;
            if (opacity > 1.0f) {
                opacity = 1.0f - (float)(sleepTime - 100) / 10.0f;
            }
            int color = (int)(220.0f * opacity) << 24 | 0x101020;
            GuiIngameStalker.a((int)0, (int)0, (int)width, (int)height, (int)color);
            GL11.glEnable((int)3008);
            GL11.glEnable((int)2929);
            this.g.C.b();
        }
    }

    protected void renderJumpBar(int width, int height) {
        this.bind(avk.m);
        if (!this.pre(RenderGameOverlayEvent.ElementType.JUMPBAR)) {
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            this.g.C.a("jumpBar");
            float charge = this.g.h.bN();
            boolean barWidth = true;
            int x2 = width / 2 - 91;
            int filled = (int)(charge * 183.0f);
            int top = height - 32 + 3;
            this.b(x2, top, 0, 84, 182, 5);
            if (filled > 0) {
                this.b(x2, top, 0, 89, filled, 5);
            }
            this.g.C.b();
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            this.post(RenderGameOverlayEvent.ElementType.JUMPBAR);
        }
    }

    protected void renderToolHightlight(int width, int height) {
        if (this.g.u.D) {
            this.g.C.a("toolHighlight");
            if (this.q > 0 && this.r != null) {
                String name = this.r.s();
                int opacity = (int)((float)this.q * 256.0f / 10.0f);
                if (opacity > 255) {
                    opacity = 255;
                }
                if (opacity > 0) {
                    int y2 = height - 59;
                    if (!this.g.c.b()) {
                        y2 += 14;
                    }
                    GL11.glPushMatrix();
                    GL11.glEnable((int)3042);
                    GL11.glBlendFunc((int)770, (int)771);
                    avi font = this.r.b().getFontRenderer(this.r);
                    if (font != null) {
                        int x2 = (width - font.a(name)) / 2;
                        font.a(name, x2, y2, 0xFFFFFF | opacity << 24);
                    } else {
                        int x3 = (width - this.fontrenderer.a(name)) / 2;
                        this.fontrenderer.a(name, x3, y2, 0xFFFFFF | opacity << 24);
                    }
                    GL11.glDisable((int)3042);
                    GL11.glPopMatrix();
                }
            }
            this.g.C.b();
        }
    }

    protected void renderHUDText(int width, int height) {
        RenderGameOverlayEvent.Text var20;
        long event;
        this.g.C.a("forgeHudText");
        ArrayList<String> left = new ArrayList<String>();
        ArrayList<String> right = new ArrayList<String>();
        if (this.g.p()) {
            event = this.g.f.I();
            if (event >= 120500L) {
                right.add(bu.a((String)"demo.demoExpired"));
            } else {
                right.add(String.format(bu.a((String)"demo.remainingTime"), ma.a((int)((int)(120500L - event)))));
            }
        }
        if (this.g.u.ab) {
            this.g.C.a("debug");
            GL11.glPushMatrix();
            left.add("Minecraft " + MC_VERSION + " (" + this.g.E + ")");
            left.add(this.g.l());
            left.add(this.g.m());
            left.add(this.g.o());
            left.add(this.g.n());
            left.add("PE: " + EffectsEngine.instance.emittersRendered + ", P: " + EffectsEngine.instance.particlesRendered);
            left.add(null);
            event = Runtime.getRuntime().maxMemory();
            long msg = Runtime.getRuntime().totalMemory();
            long free = Runtime.getRuntime().freeMemory();
            long used = msg - free;
            right.add("Used memory: " + used * 100L / event + "% (" + used / 1024L / 1024L + "MB) of " + event / 1024L / 1024L + "MB");
            right.add("Allocated memory: " + msg * 100L / event + "% (" + msg / 1024L / 1024L + "MB)");
            int x1 = ls.c(this.g.h.u);
            int y2 = ls.c(this.g.h.v);
            int z2 = ls.c(this.g.h.w);
            float yaw = this.g.h.A;
            int heading = ls.c((double)(this.g.h.A * 4.0f / 360.0f) + 0.5) & 3;
            left.add(String.format("x: %.5f (%d) // c: %d (%d)", this.g.h.u, x1, x1 >> 4, x1 & 0xF));
            left.add(String.format("y: %.3f (feet pos, %.3f eyes pos)", this.g.h.E.b, this.g.h.v));
            left.add(String.format("z: %.5f (%d) // c: %d (%d)", this.g.h.w, z2, z2 >> 4, z2 & 0xF));
            left.add(String.format("f: %d (%s) / %f", heading, r.c[heading], Float.valueOf(ls.g(yaw))));
            if (this.g.f != null && this.g.f.f(x1, y2, z2)) {
                adr i$ = this.g.f.d(x1, z2);
                left.add(String.format("lc: %d b: %s bl: %d sl: %d rl: %d", i$.h() + 15, i$.a((int)(x1 & 0xF), (int)(z2 & 0xF), (acv)this.g.f.u()).y, i$.a(ach.b, x1 & 0xF, y2, z2 & 0xF), i$.a(ach.a, x1 & 0xF, y2, z2 & 0xF), i$.c(x1 & 0xF, y2, z2 & 0xF, 0)));
            } else {
                left.add(null);
            }
            left.add(String.format("ws: %.3f, fs: %.3f, g: %b, fl: %d", Float.valueOf(this.g.h.bG.b()), Float.valueOf(this.g.h.bG.a()), this.g.h.F, this.g.f.f(x1, z2)));
            right.add(null);
            for (String s2 : FMLCommonHandler.instance().getBrandings().subList(1, FMLCommonHandler.instance().getBrandings().size())) {
                right.add(s2);
            }
            GL11.glPopMatrix();
            this.g.C.b();
        }
        if (!MinecraftForge.EVENT_BUS.post((Event)(var20 = new RenderGameOverlayEvent.Text(this.eventParent, left, right)))) {
            int x2;
            for (x2 = 0; x2 < left.size(); ++x2) {
                String var21 = (String)left.get(x2);
                if (var21 == null) continue;
                this.fontrenderer.a(var21, 2, 2 + x2 * 10, 0xFFFFFF);
            }
            for (x2 = 0; x2 < right.size(); ++x2) {
                String var21 = (String)right.get(x2);
                if (var21 == null) continue;
                int w2 = this.fontrenderer.a(var21);
                this.fontrenderer.a(var21, width - w2 - 10, 2 + x2 * 10, 0xFFFFFF);
            }
        }
        this.g.C.b();
        this.post(RenderGameOverlayEvent.ElementType.TEXT);
    }

    protected void renderRecordOverlay(int width, int height, float partialTicks) {
        if (this.o > 0) {
            this.g.C.a("overlayMessage");
            float hue = (float)this.o - partialTicks;
            int opacity = (int)(hue * 256.0f / 20.0f);
            if (opacity > 255) {
                opacity = 255;
            }
            if (opacity > 0) {
                GL11.glPushMatrix();
                GL11.glTranslatef((float)(width / 2), (float)(height - 48), (float)0.0f);
                GL11.glEnable((int)3042);
                GL11.glBlendFunc((int)770, (int)771);
                int color = this.p ? Color.HSBtoRGB(hue / 50.0f, 0.7f, 0.6f) & 0xFFFFFF : 0xFFFFFF;
                this.fontrenderer.b(this.j, -this.fontrenderer.a(this.j) / 2, -4, color | opacity << 24);
                GL11.glDisable((int)3042);
                GL11.glPopMatrix();
            }
            this.g.C.b();
        }
    }

    protected void renderChat(int width, int height) {
        this.g.C.a("chat");
        RenderGameOverlayEvent.Chat event = new RenderGameOverlayEvent.Chat(this.eventParent, 0, height - 48);
        if (!MinecraftForge.EVENT_BUS.post((Event)event)) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)event.posX, (float)event.posY, (float)0.0f);
            this.h.a(this.i);
            GL11.glPopMatrix();
            this.post(RenderGameOverlayEvent.ElementType.CHAT);
            this.g.C.b();
        }
    }

    protected void renderPlayerList(int width, int height) {
        ate scoreobjective = this.g.f.X().a(0);
        bcw handler = this.g.h.a;
        if (this.g.u.T.e && (!this.g.A() || handler.c.size() > 1 || scoreobjective != null)) {
            int maxPlayers;
            if (this.pre(RenderGameOverlayEvent.ElementType.PLAYER_LIST)) {
                return;
            }
            this.g.C.a("playerList");
            List players = handler.c;
            int rows = maxPlayers = handler.d;
            boolean columns = true;
            int var22 = 1;
            while (rows > 20) {
                rows = (maxPlayers + ++var22 - 1) / var22;
            }
            int columnWidth = 300 / var22;
            if (columnWidth > 150) {
                columnWidth = 150;
            }
            int left = (width - var22 * columnWidth) / 2;
            int border = 10;
            GuiIngameStalker.a((int)(left - 1), (int)(border - 1), (int)(left + columnWidth * var22), (int)(border + 9 * rows), (int)Integer.MIN_VALUE);
            for (int i2 = 0; i2 < maxPlayers; ++i2) {
                int pingIndex;
                int ping;
                int xPos = left + i2 % var22 * columnWidth;
                int yPos = border + i2 / var22 * 9;
                GuiIngameStalker.a((int)xPos, (int)yPos, (int)(xPos + columnWidth - 1), (int)(yPos + 8), (int)0x20FFFFFF);
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                GL11.glEnable((int)3008);
                if (i2 >= players.size()) continue;
                bdj player = (bdj)players.get(i2);
                atf team = this.g.f.X().i(player.a);
                String displayName = atf.a((atl)team, (String)player.a);
                this.fontrenderer.a(displayName, xPos, yPos, 0xFFFFFF);
                if (scoreobjective != null && (ping = xPos + columnWidth - 12 - 5) - (pingIndex = xPos + this.fontrenderer.a(displayName) + 5) > 5) {
                    atg score = scoreobjective.a().a(player.a, scoreobjective);
                    String scoreDisplay = (Object)((Object)a.o) + "" + score.c();
                    this.fontrenderer.a(scoreDisplay, ping - this.fontrenderer.a(scoreDisplay), yPos, 0xFFFFFF);
                }
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                this.g.J().a(avk.m);
                int var23 = 4;
                ping = player.b;
                if (ping < 0) {
                    var23 = 5;
                } else if (ping < 150) {
                    var23 = 0;
                } else if (ping < 300) {
                    var23 = 1;
                } else if (ping < 600) {
                    var23 = 2;
                } else if (ping < 1000) {
                    var23 = 3;
                }
                this.n += 100.0f;
                this.b(xPos + columnWidth - 12, yPos, 0, 176 + var23 * 8, 10, 8);
                this.n -= 100.0f;
            }
            this.post(RenderGameOverlayEvent.ElementType.PLAYER_LIST);
        }
    }

    private boolean pre(RenderGameOverlayEvent.ElementType type) {
        return MinecraftForge.EVENT_BUS.post((Event)new RenderGameOverlayEvent.Pre(this.eventParent, type));
    }

    private void post(RenderGameOverlayEvent.ElementType type) {
        MinecraftForge.EVENT_BUS.post((Event)new RenderGameOverlayEvent.Post(this.eventParent, type));
    }

    private void bind(bjo res) {
        this.g.J().a(res);
    }

    private void drawGradientRect(int x2, int y2, int width, int heigth, float red1, float blue1, float green1, float alpha1, float red2, float blue2, float green2, float alpha2) {
        GL11.glDisable((int)3553);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3008);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glShadeModel((int)7425);
        bfq tessellator = bfq.a;
        tessellator.b();
        tessellator.a(red1, blue1, green1, alpha1);
        tessellator.a((double)width, (double)y2, (double)this.n);
        tessellator.a((double)x2, (double)y2, (double)this.n);
        tessellator.a(red2, blue2, green2, alpha2);
        tessellator.a((double)x2, (double)heigth, (double)this.n);
        tessellator.a((double)width, (double)heigth, (double)this.n);
        tessellator.a();
        GL11.glShadeModel((int)7424);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)3008);
        GL11.glEnable((int)3553);
    }

    private void renderQuad(bfq par1Tessellator, int x2, int y2, int width, int height, int color) {
        par1Tessellator.b();
        par1Tessellator.d(color);
        par1Tessellator.a((double)(x2 + 0), (double)(y2 + 0), 0.0);
        par1Tessellator.a((double)(x2 + 0), (double)(y2 + height), 0.0);
        par1Tessellator.a((double)(x2 + width), (double)(y2 + height), 0.0);
        par1Tessellator.a((double)(x2 + width), (double)(y2 + 0), 0.0);
        par1Tessellator.a();
    }

    public void drawEffect(int effectId, int screenId) {
        awf sr2 = new awf(this.g.u, this.g.d, this.g.e);
        this.b(8 + screenId * 18, sr2.b() - 24 - 18, effectId * 15, 0, 15, 18);
    }

    public void drawRightIcon(int effectId, int level, int screenId) {
        awf sr2 = new awf(this.g.u, this.g.d, this.g.e);
        this.b(sr2.a() - 6 - 19, sr2.b() - 6 - 63 - 6 - (screenId + 1) * 18, (level - 1) * 19, effectId * 18 + 18, 19, 18);
    }

    public int getEnd(int now, int max) {
        return max <= 0 ? 0 : (int)(69.0f * (float)now / (float)max);
    }

    protected void a(int par1, int par2, int par3, float par4) {
        ye itemstack = par1 < 36 ? this.g.h.bn.a[par1] : PlayerUtils.getInfo((uf)this.g.h).stInv.mainInventory[par1 - 36];
        if (itemstack != null) {
            float f1 = (float)itemstack.c - par4;
            if (f1 > 0.0f) {
                GL11.glPushMatrix();
                float f2 = 1.0f + f1 / 5.0f;
                GL11.glTranslatef((float)(par2 + 8), (float)(par3 + 12), (float)0.0f);
                GL11.glScalef((float)(1.0f / f2), (float)((f2 + 1.0f) / 2.0f), (float)1.0f);
                GL11.glTranslatef((float)(-(par2 + 8)), (float)(-(par3 + 12)), (float)0.0f);
            }
            avj.e.b(this.g.l, this.g.J(), itemstack, par2, par3);
            if (f1 > 0.0f) {
                GL11.glPopMatrix();
            }
            avj.e.c(this.g.l, this.g.J(), itemstack, par2, par3);
        }
    }
}

