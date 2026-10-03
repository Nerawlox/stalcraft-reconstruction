/*
 * Decompiled with CFR 0.152.
 */
import codechicken.nei.forge.GuiContainerManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import gloomyfolken.mods.stalker.mobs.StalkerMobsHooks;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidj;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.dwan;
import net.minecraft.util.ezfc;
import net.minecraft.util.sajh;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import znw.mods.stalkerguide.pidb;

@SideOnly(value=Side.CLIENT)
public abstract class zybc
extends gqjz {
    protected static final ResourceLocation field_110408_a = new ResourceLocation("textures/gui/container/inventory.png");
    public static xsbj field_74196_a = new xsbj();
    public int field_74194_b = 176;
    public int field_74195_c = 166;
    public jjgc field_74193_d;
    public int field_74198_m;
    public int field_74197_n;
    private yeso field_82320_o;
    private yeso field_85051_p;
    private boolean field_90018_r;
    private cvzo field_85050_q;
    private int field_85049_r;
    private int field_85048_s;
    private yeso field_85047_t;
    private long field_85046_u;
    private cvzo field_85045_v;
    private yeso field_92033_y;
    private long field_92032_z;
    protected final Set field_94077_p = new HashSet();
    protected boolean field_94076_q;
    private int field_94071_C;
    private int field_94067_D;
    private boolean field_94068_E;
    private int field_94069_F;
    private long field_94070_G;
    private yeso field_94072_H;
    private int field_94073_I;
    private boolean field_94074_J;
    private cvzo field_94075_K;
    public GuiContainerManager manager;

    public zybc(jjgc jjgc2) {
        this.field_74193_d = jjgc2;
        this.field_94068_E = true;
    }

    @Override
    public void func_73872_a(xpzm xpzm2, int n, int n2) {
        super.func_73872_a(xpzm2, n, n2);
        if (xpzm2._B == this) {
            this.manager = new GuiContainerManager(this);
            this.manager.load();
        }
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.field_73882_e._t.field_71070_bA = this.field_74193_d;
        this.field_74198_m = (this.field_73880_f - this.field_74194_b) / 2;
        this.field_74197_n = (this.field_73881_g - this.field_74195_c) / 2;
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        int n3;
        int n4;
        Object object;
        this.manager.preDraw();
        this.func_73873_v_();
        int n5 = this.field_74198_m;
        int n6 = this.field_74197_n;
        this.func_74185_a(f, n, n2);
        GL11.glDisable(32826);
        qnon._a();
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        super.func_73863_a(n, n2, f);
        qnon._c();
        GL11.glPushMatrix();
        GL11.glTranslatef(n5, n6, 0.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(32826);
        this.field_82320_o = null;
        int n7 = 240;
        int n8 = 240;
        iwya._a(iwya._b, (float)n7 / 1.0f, (float)n8 / 1.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        boolean bl = this.manager.objectUnderMouse(n, n2);
        for (int i = 0; i < this.field_74193_d.field_75151_b.size(); ++i) {
            object = (yeso)this.field_74193_d.field_75151_b.get(i);
            this.func_74192_a((yeso)object);
            if (!this.func_74186_a((yeso)object, n, n2) || !((yeso)object).func_111238_b() || bl) continue;
            this.field_82320_o = object;
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            n4 = ((yeso)object).field_75223_e;
            n3 = ((yeso)object).field_75221_f;
            this.func_73733_a(n4, n3, n4 + 16, n3 + 16, -2130706433, -2130706433);
            GL11.glEnable(2896);
            GL11.glEnable(2929);
        }
        GL11.glDisable(2896);
        this.func_74189_g(n, n2);
        GL11.glEnable(2896);
        GL11.glTranslatef(-n5, -n6, 200.0f);
        this.manager.renderObjects(n, n2);
        GL11.glTranslatef(n5, n6, -200.0f);
        eidj eidj2 = this.field_73882_e._t.field_71071_by;
        Object object2 = object = this.field_85050_q == null ? eidj2._g() : this.field_85050_q;
        if (object != null) {
            n4 = 8;
            n3 = this.field_85050_q == null ? 8 : 16;
            String string = null;
            if (this.field_85050_q != null && this.field_90018_r) {
                object = ((cvzo)object)._l();
                ((cvzo)object)._b = sajh._f((float)((cvzo)object)._b / 2.0f);
            } else if (this.field_94076_q && this.field_94077_p.size() > 1) {
                object = ((cvzo)object)._l();
                ((cvzo)object)._b = this.field_94069_F;
                if (((cvzo)object)._b == 0) {
                    string = "" + (Object)((Object)ezfc._o) + "0";
                }
            }
            this.func_85044_b((cvzo)object, n - n5 - n4, n2 - n6 - n3, string);
        }
        if (this.field_85045_v != null) {
            float f2 = (float)(xpzm._M() - this.field_85046_u) / 100.0f;
            if (f2 >= 1.0f) {
                f2 = 1.0f;
                this.field_85045_v = null;
            }
            n3 = this.field_85047_t.field_75223_e - this.field_85049_r;
            int n9 = this.field_85047_t.field_75221_f - this.field_85048_s;
            int n10 = this.field_85049_r + (int)((float)n3 * f2);
            int n11 = this.field_85048_s + (int)((float)n9 * f2);
            this.func_85044_b(this.field_85045_v, n10, n11, null);
        }
        GL11.glPopMatrix();
        this.manager.renderToolTips(n, n2);
        GL11.glEnable(2896);
        GL11.glEnable(2929);
        qnon._b();
        pidb._a(this, n, n2, f);
        StalkerMobsHooks.drawScreen(this, n, n2, f);
    }

    private void func_85044_b(cvzo cvzo2, int n, int n2, String string) {
        GL11.glTranslatef(0.0f, 0.0f, 32.0f);
        this.field_73735_i = 500.0f;
        zybc.field_74196_a.field_77023_b = 500.0f;
        qncw qncw2 = null;
        if (cvzo2 != null) {
            qncw2 = cvzo2._a().getFontRenderer(cvzo2);
        }
        if (qncw2 == null) {
            qncw2 = this.field_73886_k;
        }
        field_74196_a.func_82406_b(qncw2, this.field_73882_e._R(), cvzo2, n, n2);
        field_74196_a.func_94148_a(qncw2, this.field_73882_e._R(), cvzo2, n, n2 - (this.field_85050_q == null ? 0 : 8), string);
        this.field_73735_i = 0.0f;
        zybc.field_74196_a.field_77023_b = 0.0f;
    }

    public List<String> handleTooltip(int n, int n2, List<String> list2) {
        return list2;
    }

    public List<String> handleItemTooltip(cvzo cvzo2, int n, int n2, List<String> list2) {
        return list2;
    }

    @Deprecated
    protected void func_74184_a(cvzo cvzo2, int n, int n2) {
        List list2 = cvzo2._a((EntityPlayer)this.field_73882_e._t, this.field_73882_e._M.field_82882_x);
        for (int i = 0; i < list2.size(); ++i) {
            if (i == 0) {
                list2.set(i, "\u00a7" + Integer.toHexString(cvzo2._w()._e) + (String)list2.get(i));
                continue;
            }
            list2.set(i, (Object)((Object)ezfc._h) + (String)list2.get(i));
        }
        qncw qncw2 = cvzo2._a().getFontRenderer(cvzo2);
        this.drawHoveringText(list2, n, n2, qncw2 == null ? this.field_73886_k : qncw2);
    }

    @Deprecated
    protected void func_74190_a(String string, int n, int n2) {
        this.func_102021_a(Arrays.asList(string), n, n2);
    }

    @Deprecated
    protected void func_102021_a(List list2, int n, int n2) {
        this.drawHoveringText(list2, n, n2, this.field_73886_k);
    }

    @Deprecated
    protected void drawHoveringText(List list2, int n, int n2, qncw qncw2) {
        if (!list2.isEmpty()) {
            int n3;
            GL11.glDisable(32826);
            qnon._a();
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            int n4 = 0;
            for (String string : list2) {
                n3 = qncw2._b(string);
                if (n3 <= n4) continue;
                n4 = n3;
            }
            int n5 = n + 12;
            n3 = n2 - 12;
            int n6 = 8;
            if (list2.size() > 1) {
                n6 += 2 + (list2.size() - 1) * 10;
            }
            if (n5 + n4 > this.field_73880_f) {
                n5 -= 28 + n4;
            }
            if (n3 + n6 + 6 > this.field_73881_g) {
                n3 = this.field_73881_g - n6 - 6;
            }
            this.field_73735_i = 300.0f;
            zybc.field_74196_a.field_77023_b = 300.0f;
            int n7 = -267386864;
            this.func_73733_a(n5 - 3, n3 - 4, n5 + n4 + 3, n3 - 3, n7, n7);
            this.func_73733_a(n5 - 3, n3 + n6 + 3, n5 + n4 + 3, n3 + n6 + 4, n7, n7);
            this.func_73733_a(n5 - 3, n3 - 3, n5 + n4 + 3, n3 + n6 + 3, n7, n7);
            this.func_73733_a(n5 - 4, n3 - 3, n5 - 3, n3 + n6 + 3, n7, n7);
            this.func_73733_a(n5 + n4 + 3, n3 - 3, n5 + n4 + 4, n3 + n6 + 3, n7, n7);
            int n8 = 0x505000FF;
            int n9 = (n8 & 0xFEFEFE) >> 1 | n8 & 0xFF000000;
            this.func_73733_a(n5 - 3, n3 - 3 + 1, n5 - 3 + 1, n3 + n6 + 3 - 1, n8, n9);
            this.func_73733_a(n5 + n4 + 2, n3 - 3 + 1, n5 + n4 + 3, n3 + n6 + 3 - 1, n8, n9);
            this.func_73733_a(n5 - 3, n3 - 3, n5 + n4 + 3, n3 - 3 + 1, n8, n8);
            this.func_73733_a(n5 - 3, n3 + n6 + 2, n5 + n4 + 3, n3 + n6 + 3, n9, n9);
            for (int i = 0; i < list2.size(); ++i) {
                String string = (String)list2.get(i);
                qncw2._a(string, n5, n3, -1);
                if (i == 0) {
                    n3 += 2;
                }
                n3 += 10;
            }
            this.field_73735_i = 0.0f;
            zybc.field_74196_a.field_77023_b = 0.0f;
            GL11.glEnable(2896);
            GL11.glEnable(2929);
            qnon._b();
            GL11.glEnable(32826);
        }
    }

    protected void func_74189_g(int n, int n2) {
    }

    protected abstract void func_74185_a(float var1, int var2, int var3);

    protected void func_74192_a(yeso yeso2) {
        dwan dwan2;
        if (GloomyHooks.shouldNotRenderSlot(this, yeso2)) {
            return;
        }
        int n = yeso2.field_75223_e;
        int n2 = yeso2.field_75221_f;
        cvzo cvzo2 = yeso2.func_75211_c();
        boolean bl = false;
        boolean bl2 = yeso2 == this.field_85051_p && this.field_85050_q != null && !this.field_90018_r;
        cvzo cvzo3 = this.field_73882_e._t.field_71071_by._g();
        String string = null;
        if (yeso2 == this.field_85051_p && this.field_85050_q != null && this.field_90018_r && cvzo2 != null) {
            cvzo2 = cvzo2._l();
            cvzo2._b /= 2;
        } else if (this.field_94076_q && this.field_94077_p.contains(yeso2) && cvzo3 != null) {
            if (this.field_94077_p.size() == 1) {
                return;
            }
            if (jjgc.func_94527_a(yeso2, cvzo3, true) && this.field_74193_d.func_94531_b(yeso2)) {
                cvzo2 = cvzo3._l();
                bl = true;
                jjgc.func_94525_a(this.field_94077_p, this.field_94071_C, cvzo2, yeso2.func_75211_c() == null ? 0 : yeso2.func_75211_c()._b);
                if (cvzo2._b > cvzo2._d()) {
                    string = (Object)((Object)ezfc._o) + "" + cvzo2._d();
                    cvzo2._b = cvzo2._d();
                }
                if (cvzo2._b > yeso2.func_75219_a()) {
                    string = (Object)((Object)ezfc._o) + "" + yeso2.func_75219_a();
                    cvzo2._b = yeso2.func_75219_a();
                }
            } else {
                this.field_94077_p.remove(yeso2);
                this.func_94066_g();
            }
        }
        this.field_73735_i = 100.0f;
        zybc.field_74196_a.field_77023_b = 100.0f;
        if (cvzo2 == null && (dwan2 = yeso2.func_75212_b()) != null) {
            GL11.glDisable(2896);
            this.field_73882_e._R()._a(sctd._e);
            this.func_94065_a(n, n2, dwan2, 16, 16);
            GL11.glEnable(2896);
            bl2 = true;
        }
        if (!bl2) {
            if (bl) {
                zybc.func_73734_a(n, n2, n + 16, n2 + 16, -2130706433);
            }
            this.manager.renderSlotUnderlay(yeso2);
            GL11.glEnable(2929);
            this.drawSlotItem(yeso2, cvzo2, n, n2, string);
            this.manager.renderSlotOverlay(yeso2);
        }
        zybc.field_74196_a.field_77023_b = 0.0f;
        this.field_73735_i = 0.0f;
    }

    public void drawSlotItem(yeso yeso2, cvzo cvzo2, int n, int n2, String string) {
        field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e._R(), cvzo2, n, n2);
        field_74196_a.func_94148_a(this.field_73886_k, this.field_73882_e._R(), cvzo2, n, n2, string);
    }

    private void func_94066_g() {
        cvzo cvzo2 = this.field_73882_e._t.field_71071_by._g();
        if (cvzo2 != null && this.field_94076_q) {
            this.field_94069_F = cvzo2._b;
            for (yeso yeso2 : this.field_94077_p) {
                cvzo cvzo3 = cvzo2._l();
                int n = yeso2.func_75211_c() == null ? 0 : yeso2.func_75211_c()._b;
                jjgc.func_94525_a(this.field_94077_p, this.field_94071_C, cvzo3, n);
                if (cvzo3._b > cvzo3._d()) {
                    cvzo3._b = cvzo3._d();
                }
                if (cvzo3._b > yeso2.func_75219_a()) {
                    cvzo3._b = yeso2.func_75219_a();
                }
                this.field_94069_F -= cvzo3._b - n;
            }
        }
    }

    public yeso func_74187_b(int n, int n2) {
        for (int i = 0; i < this.field_74193_d.field_75151_b.size(); ++i) {
            yeso yeso2 = (yeso)this.field_74193_d.field_75151_b.get(i);
            if (!this.func_74186_a(yeso2, n, n2)) continue;
            return yeso2;
        }
        return null;
    }

    @Override
    protected void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
        this.field_94068_E = true;
        if (this.manager.mouseClicked(n, n2, n3)) {
            return;
        }
        boolean bl = n3 == this.field_73882_e._M.field_74322_I._d + 100;
        yeso yeso2 = this.func_74187_b(n, n2);
        long l = xpzm._M();
        this.field_94074_J = this.field_94072_H == yeso2 && l - this.field_94070_G < 250L && this.field_94073_I == n3;
        this.field_94068_E = false;
        if (n3 == 0 || n3 == 1 || bl) {
            int n4 = this.field_74198_m;
            int n5 = this.field_74197_n;
            boolean bl2 = (n < n4 || n2 < n5 || n >= n4 + this.field_74194_b || n2 >= n5 + this.field_74195_c) && yeso2 == null;
            int n6 = -1;
            if (yeso2 != null) {
                n6 = yeso2.field_75222_d;
            }
            if (bl2) {
                n6 = -999;
            }
            if (this.field_73882_e._M.field_85185_A && bl2 && this.field_73882_e._t.field_71071_by._g() == null) {
                this.field_73882_e._a((gqjz)null);
                return;
            }
            if (n6 != -1) {
                if (this.field_73882_e._M.field_85185_A) {
                    if (yeso2 != null && yeso2.func_75216_d()) {
                        this.field_85051_p = yeso2;
                        this.field_85050_q = null;
                        this.field_90018_r = n3 == 1;
                    } else {
                        this.field_85051_p = null;
                    }
                } else if (!this.field_94076_q) {
                    if (this.field_73882_e._t.field_71071_by._g() == null) {
                        if (n3 == this.field_73882_e._M.field_74322_I._d + 100) {
                            this.manager.handleMouseClick(yeso2, n6, n3, 3);
                        } else {
                            boolean bl3 = n6 != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
                            int n7 = 0;
                            if (bl3) {
                                this.field_94075_K = yeso2 != null && yeso2.func_75216_d() ? yeso2.func_75211_c() : null;
                                n7 = 1;
                            } else if (n6 == -999) {
                                n7 = 4;
                            }
                            this.manager.handleMouseClick(yeso2, n6, n3, n7);
                        }
                        this.field_94068_E = true;
                    } else {
                        this.field_94076_q = true;
                        this.field_94067_D = n3;
                        this.field_94077_p.clear();
                        if (n3 == 0) {
                            this.field_94071_C = 0;
                        } else if (n3 == 1) {
                            this.field_94071_C = 1;
                        }
                    }
                }
            }
        }
        this.field_94072_H = yeso2;
        this.field_94070_G = l;
        this.field_94073_I = n3;
    }

    @Override
    protected void func_85041_a(int n, int n2, int n3, long l) {
        yeso yeso2 = this.func_74187_b(n, n2);
        cvzo cvzo2 = this.field_73882_e._t.field_71071_by._g();
        this.manager.mouseDragged(n, n2, n3, l);
        if (this.field_85051_p != null && this.field_73882_e._M.field_85185_A) {
            if (n3 == 0 || n3 == 1) {
                if (this.field_85050_q == null) {
                    if (yeso2 != this.field_85051_p) {
                        this.field_85050_q = this.field_85051_p.func_75211_c()._l();
                    }
                } else if (this.field_85050_q._b > 1 && yeso2 != null && jjgc.func_94527_a(yeso2, this.field_85050_q, false)) {
                    long l2 = xpzm._M();
                    if (this.field_92033_y == yeso2) {
                        if (l2 - this.field_92032_z > 500L) {
                            this.func_74191_a(this.field_85051_p, this.field_85051_p.field_75222_d, 0, 0);
                            this.func_74191_a(yeso2, yeso2.field_75222_d, 1, 0);
                            this.func_74191_a(this.field_85051_p, this.field_85051_p.field_75222_d, 0, 0);
                            this.field_92032_z = l2 + 750L;
                            --this.field_85050_q._b;
                        }
                    } else {
                        this.field_92033_y = yeso2;
                        this.field_92032_z = l2;
                    }
                }
            }
        } else if (this.field_94076_q && yeso2 != null && cvzo2 != null && cvzo2._b > this.field_94077_p.size() && jjgc.func_94527_a(yeso2, cvzo2, true) && yeso2.func_75214_a(cvzo2) && this.field_74193_d.func_94531_b(yeso2)) {
            this.field_94077_p.add(yeso2);
            this.func_94066_g();
        }
    }

    @Override
    protected void func_73879_b(int n, int n2, int n3) {
        yeso yeso2 = this.func_74187_b(n, n2);
        int n4 = this.field_74198_m;
        int n5 = this.field_74197_n;
        boolean bl = n < n4 || n2 < n5 || n >= n4 + this.field_74194_b || n2 >= n5 + this.field_74195_c;
        int n6 = -1;
        if (yeso2 != null) {
            n6 = yeso2.field_75222_d;
        }
        if (bl) {
            n6 = -999;
        }
        if (this.field_94074_J && yeso2 != null && n3 == 0 && this.field_74193_d.func_94530_a(null, yeso2)) {
            if (zybc.func_73877_p()) {
                if (yeso2 != null && yeso2.field_75224_c != null && this.field_94075_K != null) {
                    for (yeso yeso3 : this.field_74193_d.field_75151_b) {
                        if (yeso3 == null || !yeso3.func_82869_a(this.field_73882_e._t) || !yeso3.func_75216_d() || yeso3.field_75224_c != yeso2.field_75224_c || !jjgc.func_94527_a(yeso3, this.field_94075_K, true)) continue;
                        this.func_74191_a(yeso3, yeso3.field_75222_d, n3, 1);
                    }
                }
            } else {
                this.func_74191_a(yeso2, n6, n3, 6);
            }
            this.field_94074_J = false;
            this.field_94070_G = 0L;
        } else {
            if (this.field_94076_q && this.field_94067_D != n3) {
                this.field_94076_q = false;
                this.field_94077_p.clear();
                this.field_94068_E = true;
                return;
            }
            if (this.field_94068_E) {
                this.manager.mouseUp(n, n2, n3);
                this.field_94068_E = false;
                return;
            }
            if (this.field_85051_p != null && this.field_73882_e._M.field_85185_A) {
                if (n3 == 0 || n3 == 1) {
                    if (this.field_85050_q == null && yeso2 != this.field_85051_p) {
                        this.field_85050_q = this.field_85051_p.func_75211_c();
                    }
                    boolean bl2 = jjgc.func_94527_a(yeso2, this.field_85050_q, false);
                    if (n6 != -1 && this.field_85050_q != null && bl2) {
                        this.func_74191_a(this.field_85051_p, this.field_85051_p.field_75222_d, n3, 0);
                        this.func_74191_a(yeso2, n6, 0, 0);
                        if (this.field_73882_e._t.field_71071_by._g() != null) {
                            this.func_74191_a(this.field_85051_p, this.field_85051_p.field_75222_d, n3, 0);
                            this.field_85049_r = n - n4;
                            this.field_85048_s = n2 - n5;
                            this.field_85047_t = this.field_85051_p;
                            this.field_85045_v = this.field_85050_q;
                            this.field_85046_u = xpzm._M();
                        } else {
                            this.field_85045_v = null;
                        }
                    } else if (this.field_85050_q != null) {
                        this.field_85049_r = n - n4;
                        this.field_85048_s = n2 - n5;
                        this.field_85047_t = this.field_85051_p;
                        this.field_85045_v = this.field_85050_q;
                        this.field_85046_u = xpzm._M();
                    }
                    this.field_85050_q = null;
                    this.field_85051_p = null;
                }
            } else if (this.field_94076_q && !this.field_94077_p.isEmpty()) {
                this.func_74191_a(null, -999, jjgc.func_94534_d(0, this.field_94071_C), 5);
                for (yeso yeso4 : this.field_94077_p) {
                    this.func_74191_a(yeso4, yeso4.field_75222_d, jjgc.func_94534_d(1, this.field_94071_C), 5);
                }
                this.func_74191_a(null, -999, jjgc.func_94534_d(2, this.field_94071_C), 5);
            } else if (this.field_73882_e._t.field_71071_by._g() != null) {
                if (n3 == this.field_73882_e._M.field_74322_I._d + 100) {
                    this.func_74191_a(yeso2, n6, n3, 3);
                } else {
                    boolean bl3;
                    boolean bl4 = bl3 = n6 != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
                    if (bl3) {
                        this.field_94075_K = yeso2 != null && yeso2.func_75216_d() ? yeso2.func_75211_c() : null;
                    }
                    this.func_74191_a(yeso2, n6, n3, bl3 ? 1 : 0);
                }
            } else if (n3 >= 0) {
                this.manager.mouseUp(n, n2, n3);
            }
        }
        if (this.field_73882_e._t.field_71071_by._g() == null) {
            this.field_94070_G = 0L;
        }
        this.field_94076_q = false;
    }

    protected boolean func_74186_a(yeso yeso2, int n, int n2) {
        return this.func_74188_c(yeso2.field_75223_e, yeso2.field_75221_f, 16, 16, n, n2);
    }

    public boolean func_74188_c(int n, int n2, int n3, int n4, int n5, int n6) {
        int n7 = this.field_74198_m;
        int n8 = this.field_74197_n;
        return (n5 -= n7) >= n - 1 && n5 < n + n3 + 1 && (n6 -= n8) >= n2 - 1 && n6 < n2 + n4 + 1;
    }

    protected void func_74191_a(yeso yeso2, int n, int n2, int n3) {
        if (yeso2 != null) {
            n = yeso2.field_75222_d;
        }
        if (n == -1) {
            return;
        }
        if (this.isClientOnly()) {
            this.field_73882_e._t.field_71070_bA.func_75144_a(n, n2, n3, this.field_73882_e._t);
        } else {
            this.field_73882_e._j._a(this.field_74193_d.field_75152_c, n, n2, n3, this.field_73882_e._t);
        }
    }

    public void sendMouseClick(yeso yeso2, int n, int n2, int n3) {
        this.func_74191_a(yeso2, n, n2, n3);
    }

    public boolean isClientOnly() {
        return false;
    }

    @Override
    protected void func_73869_a(char c, int n) {
        if (n == 1) {
            this.field_73882_e._t.func_71053_j();
            return;
        }
        if (this.manager.lastKeyTyped(n, c)) {
            return;
        }
        this.func_82319_a(n);
        if (this.field_82320_o != null && this.field_82320_o.func_75216_d()) {
            if (n == this.field_73882_e._M.field_74322_I._d) {
                this.func_74191_a(this.field_82320_o, this.field_82320_o.field_75222_d, 0, 3);
            } else if (n == this.field_73882_e._M.field_74316_C._d) {
                this.func_74191_a(this.field_82320_o, this.field_82320_o.field_75222_d, zybc.func_73861_o() ? 1 : 0, 4);
            }
        }
        if (n == this.field_73882_e._M.field_74315_B._d) {
            this.field_73882_e._t.func_71053_j();
            return;
        }
    }

    protected boolean func_82319_a(int n) {
        if (this.field_73882_e._t.field_71071_by._g() == null && this.field_82320_o != null) {
            for (int i = 0; i < 9; ++i) {
                if (n != 2 + i) continue;
                this.func_74191_a(this.field_82320_o, this.field_82320_o.field_75222_d, i, 2);
                return true;
            }
        }
        return false;
    }

    @Override
    public void func_73874_b() {
        if (this.field_73882_e._t != null) {
            this.field_74193_d.func_75134_a(this.field_73882_e._t);
        }
    }

    @Override
    public boolean func_73868_f() {
        return false;
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        this.manager.guiTick();
        if (!this.field_73882_e._t.func_70089_S() || this.field_73882_e._t.field_70128_L) {
            this.field_73882_e._t.func_71053_j();
        }
    }

    public void keyPress(int n, char c) {
        if (n == 87) {
            this.field_73882_e._r();
            return;
        }
        if (this.manager.firstKeyTyped(n, c)) {
            return;
        }
        this.func_73869_a(c, n);
    }

    @Override
    public void func_73860_n() {
        this.manager.fixhandleKeyboardInput();
    }

    @Override
    public void func_73867_d() {
        super.func_73867_d();
        int n = Mouse.getEventDWheel();
        if (n != 0) {
            int n2 = n = n > 0 ? 1 : -1;
            if (!this.manager.mouseScrolled(n)) {
                // empty if block
            }
            this.mouseScrolled(n);
        }
    }

    public void mouseScrolled(int n) {
    }

    public void refresh() {
        this.manager.refresh();
    }
}

