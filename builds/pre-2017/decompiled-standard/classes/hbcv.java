/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.eidj;
import gloomyfolken.mods.effects.client.mcsa.ezfa;
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import gloomyfolken.mods.effects.client.mcsa.qlgf;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.sajh;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Project;

public abstract class hbcv
extends iefv
implements kkll {
    protected List<kjui> _a = new ArrayList<kjui>(6);
    protected static final xpzm _b = xpzm._E();
    public uhib _c = new uhib();
    private static final float[] _i = new float[]{0.66f, 1.3f, 0.78f, -76.8f, 14.1f, 45.3f};

    public hbcv(String string, String string2, String string3) {
        super(string, string2, string3);
    }

    @Override
    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType itemRenderType, cvzo cvzo2, IItemRenderer.ItemRendererHelper itemRendererHelper) {
        return itemRenderType == IItemRenderer.ItemRenderType.EQUIPPED;
    }

    @Override
    public boolean handleRenderType(cvzo cvzo2, IItemRenderer.ItemRenderType itemRenderType) {
        return itemRenderType != IItemRenderer.ItemRenderType.INVENTORY;
    }

    @Override
    public void renderItem(IItemRenderer.ItemRenderType itemRenderType, cvzo cvzo2, Object ... objectArray) {
        try {
            ezfc._a();
            switch (itemRenderType) {
                case EQUIPPED_FIRST_PERSON: {
                    this._f(cvzo2);
                    break;
                }
                case EQUIPPED: {
                    this._a(cvzo2, (EntityLivingBase)objectArray[1], true);
                    break;
                }
                case ENTITY: {
                    this._b(cvzo2, (EntityItem)objectArray[1]);
                    break;
                }
            }
            ezfc._b();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void _a(cvzo cvzo2, EntityLivingBase entityLivingBase) {
        try {
            ezfc._a();
            this._a(cvzo2, entityLivingBase, false);
            ezfc._b();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void _b(cvzo cvzo2, EntityItem entityItem) {
        ezfc._a();
        ezfc._d();
        ezfc._a(0.0f, this._a(entityItem), 0.0f);
        if (entityItem != null) {
            ezfc._a(entityItem.field_70177_z, 0.0f, 1.0f, 0.0f);
        }
        float f = 2.0f;
        ezfc._b(f *= this._d(cvzo2), f, f);
        this._a(cvzo2, entityItem);
        ezfc._b();
    }

    private void _a(cvzo cvzo2, EntityLivingBase entityLivingBase, boolean bl) {
        if (bl) {
            ezfc._a();
            ezfc._d();
        }
        ezfc._a(_i[0], _i[1], _i[2]);
        ezfc._a(_i[3], 1.0f, 0.0f, 0.0f);
        ezfc._a(_i[4], 0.0f, 1.0f, 0.0f);
        ezfc._a(_i[5], 0.0f, 0.0f, 1.0f);
        float f = 2.6666667f;
        f *= 1.0666667f;
        ezfc._b(f *= this._d(cvzo2), f, f);
        this._b(cvzo2, entityLivingBase);
        if (bl) {
            ezfc._b();
        }
    }

    private void _f(cvzo cvzo2) {
        hbcv._a(hbcv._b._t, this._c(cvzo2), hbcv._b._p._d);
        this._g(cvzo2);
        this._a(cvzo2);
        ezfa._a._a();
    }

    private void _g(cvzo cvzo2) {
        hbcv._a(this._b(cvzo2));
    }

    public static void _a(EntityClientPlayerMP entityClientPlayerMP, float f, float f2) {
        float f3;
        float f4;
        jizq jizq2 = hbcv._b._D.field_78516_c;
        float f5 = jywc._a(jizq2.field_78451_d, jizq2.field_78454_c, f2);
        ezfc._c();
        ezfc._a();
        ezfc._a(entityClientPlayerMP.field_70127_C + (entityClientPlayerMP.field_70125_A - entityClientPlayerMP.field_70127_C) * f2, 1.0f, 0.0f, 0.0f);
        ezfc._a(entityClientPlayerMP.field_70126_B + (entityClientPlayerMP.field_70177_z - entityClientPlayerMP.field_70126_B) * f2 + 180.0f, 0.0f, 1.0f, 0.0f);
        eidj._a._d();
        ezfc._b();
        if (hbcv._b._u instanceof EntityPlayer) {
            f4 = entityClientPlayerMP.field_70140_Q - entityClientPlayerMP.field_70141_P;
            f3 = -(entityClientPlayerMP.field_70140_Q + f4 * hbcv._b._p._d);
            float f6 = entityClientPlayerMP.field_71107_bF + (entityClientPlayerMP.field_71109_bG - entityClientPlayerMP.field_71107_bF) * f2;
            float f7 = entityClientPlayerMP.field_70727_aS + (entityClientPlayerMP.field_70726_aT - entityClientPlayerMP.field_70727_aS) * f2;
            ezfc._a(sajh._a(f3 * (float)Math.PI) * f6 * 0.5f * 0.2f * f, -Math.abs(sajh._b(f3 * (float)Math.PI) * f6) * 0.2f * f, 0.0f);
            ezfc._a(sajh._a(f3 * (float)Math.PI) * f6 * 3.0f * 0.2f * f, 0.0f, 0.0f, 1.0f);
            ezfc._a(Math.abs(sajh._b(f3 * (float)Math.PI - 0.2f) * f6) * 5.0f * 0.2f * f, 1.0f, 0.0f, 0.0f);
            ezfc._a(f7 * 0.2f * f, 1.0f, 0.0f, 0.0f);
        }
        f4 = jywc._a(entityClientPlayerMP.field_71164_i, entityClientPlayerMP.field_71155_g, f2);
        f3 = jywc._a(entityClientPlayerMP.field_71163_h, entityClientPlayerMP.field_71154_f, f2);
        ezfc._a((entityClientPlayerMP.field_70125_A - f4) * 0.1f * f, 1.0f, 0.0f, 0.0f);
        ezfc._a((entityClientPlayerMP.field_70177_z - f3) * 0.1f * f, 0.0f, 1.0f, 0.0f);
        ezfc._a(0.0f, (1.0f - f5) * -0.6f, 0.0f);
    }

    public static void _a(float f) {
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        float f2 = 0.07f;
        tfsl tfsl2 = hbcv._b._D;
        if (hbcv._b._M.field_74337_g) {
            GL11.glTranslatef((float)(-(tfsl.field_78515_b * 2 - 1)) * f2, 0.0f, 0.0f);
        }
        if (tfsl2.field_78503_V != 1.0) {
            GL11.glTranslatef((float)tfsl2.field_78502_W, (float)(-tfsl2.field_78509_X), 0.0f);
            GL11.glScaled(tfsl2.field_78503_V, tfsl2.field_78503_V, 1.0);
        }
        Project.gluPerspective(f, (float)hbcv._b._n / (float)hbcv._b._o, 0.05f, tfsl2.field_78530_s * 2.0f);
        GL11.glMatrixMode(5888);
    }

    public boolean _a(cvzo cvzo2, int n) {
        return n == 0;
    }

    protected abstract void _a(cvzo var1);

    protected abstract void _a(cvzo var1, EntityItem var2);

    protected abstract void _b(cvzo var1, EntityLivingBase var2);

    protected float _a(EntityItem entityItem) {
        return -0.2f;
    }

    protected float _b(cvzo cvzo2) {
        return 70.0f;
    }

    protected float _c(cvzo cvzo2) {
        return 1.0f;
    }

    public float _d(cvzo cvzo2) {
        return 1.0f;
    }

    protected kjui _a(Predicate<String> predicate) {
        return new kjui(predicate);
    }

    protected class kjui {
        private boolean[] _b;
        private Predicate<String> _c;

        private kjui(Predicate<String> predicate) {
            this._c = predicate;
            hbcv.this._a.add(this);
        }

        public void _a() {
            this._b = null;
        }

        public void _a(gloomyfolken.mods.effects.client.mcsa.kjui kjui2) {
            ArrayList arrayList = kjui2._a().getMeshes();
            this._b = new boolean[arrayList.size()];
            for (int i = 0; i < arrayList.size(); ++i) {
                this._b[i] = this._c.test(((qlgf)arrayList.get((int)i))._l);
            }
        }

        public void _a(cucv cucv2, gloomyfolken.mods.effects.client.mcsa.kjui kjui2) {
            if (this._b == null) {
                this._a(kjui2);
            }
            for (int i = 0; i < this._b.length; ++i) {
                if (!this._b[i]) continue;
                kjui2._c.renderPart(i, cucv2);
            }
        }

        public boolean _b(gloomyfolken.mods.effects.client.mcsa.kjui kjui2) {
            if (this._b == null) {
                this._a(kjui2);
            }
            for (int i = 0; i < this._b.length; ++i) {
                if (!this._b[i]) continue;
                return true;
            }
            return false;
        }
    }
}

