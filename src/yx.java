/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aau
 *  aaw
 *  la
 *  net.minecraftforge.common.IShearable
 */
import java.util.ArrayList;
import java.util.Random;
import net.minecraftforge.common.IShearable;

public class yx
extends yc {
    public yx(int par1) {
        super(par1);
        this.d(1);
        this.e(238);
        this.a(ww.i);
    }

    @Override
    public boolean a(ye par1ItemStack, abw par2World, int par3, int par4, int par5, int par6, of par7EntityLivingBase) {
        if (par3 != aqz.P.cF && par3 != aqz.ab.cF && par3 != aqz.ac.cF && par3 != aqz.bz.cF && par3 != aqz.bZ.cF && !(aqz.s[par3] instanceof IShearable)) {
            return super.a(par1ItemStack, par2World, par3, par4, par5, par6, par7EntityLivingBase);
        }
        return true;
    }

    @Override
    public boolean a(aqz par1Block) {
        return par1Block.cF == aqz.ab.cF || par1Block.cF == aqz.aA.cF || par1Block.cF == aqz.bZ.cF;
    }

    @Override
    public float a(ye par1ItemStack, aqz par2Block) {
        return par2Block.cF != aqz.ab.cF && par2Block.cF != aqz.P.cF ? (par2Block.cF == aqz.ag.cF ? 5.0f : super.a(par1ItemStack, par2Block)) : 15.0f;
    }

    @Override
    public boolean a(ye itemstack, uf player, of entity) {
        if (entity.q.I) {
            return false;
        }
        if (entity instanceof IShearable) {
            IShearable target = (IShearable)entity;
            if (target.isShearable(itemstack, entity.q, (int)entity.u, (int)entity.v, (int)entity.w)) {
                ArrayList drops = target.onSheared(itemstack, entity.q, (int)entity.u, (int)entity.v, (int)entity.w, aaw.a((int)aau.u.z, (ye)itemstack));
                Random rand = new Random();
                for (ye stack : drops) {
                    ss ent = entity.a(stack, 1.0f);
                    ent.y += (double)(rand.nextFloat() * 0.05f);
                    ent.x += (double)((rand.nextFloat() - rand.nextFloat()) * 0.1f);
                    ent.z += (double)((rand.nextFloat() - rand.nextFloat()) * 0.1f);
                }
                itemstack.a(1, entity);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean onBlockStartBreak(ye itemstack, int x2, int y2, int z2, uf player) {
        IShearable target;
        if (player.q.I) {
            return false;
        }
        int id = player.q.a(x2, y2, z2);
        if (aqz.s[id] instanceof IShearable && (target = (IShearable)aqz.s[id]).isShearable(itemstack, player.q, x2, y2, z2)) {
            ArrayList drops = target.onSheared(itemstack, player.q, x2, y2, z2, aaw.a((int)aau.u.z, (ye)itemstack));
            Random rand = new Random();
            for (ye stack : drops) {
                float f2 = 0.7f;
                double d2 = (double)(rand.nextFloat() * f2) + (double)(1.0f - f2) * 0.5;
                double d1 = (double)(rand.nextFloat() * f2) + (double)(1.0f - f2) * 0.5;
                double d22 = (double)(rand.nextFloat() * f2) + (double)(1.0f - f2) * 0.5;
                ss entityitem = new ss(player.q, (double)x2 + d2, (double)y2 + d1, (double)z2 + d22, stack);
                entityitem.b = 10;
                player.q.d(entityitem);
            }
            itemstack.a(1, (of)player);
            player.a(la.C[id], 1);
        }
        return false;
    }
}

