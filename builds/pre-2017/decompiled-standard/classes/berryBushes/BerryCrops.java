/*
 * Decompiled with CFR 0.152.
 */
package berryBushes;

import berryBushes.Base;
import berryBushes.te.BushTE;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;

public class BerryCrops
extends iwgt {
    @SideOnly(value=Side.CLIENT)
    private dwan[] iconArray;

    public BerryCrops(int n) {
        super(n, tflj._d);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return Base.berry.field_77779_bT;
    }

    @Override
    public void func_71898_d(ozlu ozlu2, int n, int n2, int n3, int n4) {
        cvzo cvzo2 = new cvzo(Base.berry);
        cvzo2._b = 1;
        EntityItem entityItem = new EntityItem(ozlu2, n, n2, n3, cvzo2);
        if (!ozlu2.field_72995_K) {
            ozlu2.func_72838_d(entityItem);
        }
        if (ozlu2.func_72796_p(n, n2, n3) instanceof BushTE) {
            BushTE bushTE = (BushTE)ozlu2.func_72796_p(n, n2, n3);
            float f = bushTE.count;
            cvzo cvzo3 = null;
            if (f > 8000.0f && f < 12000.0f) {
                cvzo3 = new cvzo(Base.berry);
            }
            if (f >= 12000.0f && f < 18000.0f) {
                cvzo3 = new cvzo(Base.berryII);
            }
            if (f >= 18000.0f && f < 24000.0f) {
                cvzo3 = new cvzo(Base.berryIII);
            }
            if (f >= 24000.0f) {
                cvzo3 = new cvzo(Base.berryIV);
            }
            if (f > 8000.0f) {
                int n5;
                EntityItem entityItem2 = new EntityItem(ozlu2, n, n2, n3, cvzo3);
                Random random = new Random();
                cvzo3._b = n5 = random.nextInt(2) + 1;
                if (!ozlu2.field_72995_K) {
                    ozlu2.func_72838_d(entityItem2);
                }
                bushTE.count = 5000.0f;
                bushTE.stack = null;
            }
        }
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (entityPlayer.func_71045_bC() != null) {
            if (entityPlayer.func_71045_bC()._a() instanceof hugs && entityPlayer.func_71045_bC()._j() == 15 && ozlu2.func_72796_p(n, n2, n3) instanceof BushTE) {
                BushTE bushTE = (BushTE)ozlu2.func_72796_p(n, n2, n3);
                if (bushTE.count < 24000.0f) {
                    bushTE.count += 400.0f;
                    if (!entityPlayer.field_71075_bZ._d) {
                        --entityPlayer.func_71045_bC()._b;
                    }
                }
            }
        } else if (ozlu2.func_72796_p(n, n2, n3) instanceof BushTE) {
            BushTE bushTE = (BushTE)ozlu2.func_72796_p(n, n2, n3);
            float f4 = bushTE.count;
            cvzo cvzo2 = null;
            if (f4 > 8000.0f && f4 < 12000.0f) {
                cvzo2 = new cvzo(Base.berry);
            }
            if (f4 >= 12000.0f && f4 < 18000.0f) {
                cvzo2 = new cvzo(Base.berryII);
            }
            if (f4 >= 18000.0f && f4 < 24000.0f) {
                cvzo2 = new cvzo(Base.berryIII);
            }
            if (f4 >= 24000.0f) {
                cvzo2 = new cvzo(Base.berryIV);
            }
            if (f4 > 8000.0f) {
                int n5;
                EntityItem entityItem = new EntityItem(ozlu2, n, n2, n3, cvzo2);
                Random random = new Random();
                cvzo2._b = n5 = random.nextInt(2) + 1;
                if (!ozlu2.field_72995_K) {
                    ozlu2.func_72838_d(entityItem);
                }
                bushTE.count = 5000.0f;
                bushTE.stack = null;
            }
        }
        return false;
    }

    @Override
    public int func_71857_b() {
        return RenderingRegistry.getNextAvailableRenderId();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b("leaves_oak");
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new BushTE();
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }
}

