/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bu
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  zn
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

public class zo
extends yc {
    public zo(int par1) {
        super(par1);
        this.d(1);
    }

    public static boolean a(by par0NBTTagCompound) {
        if (!zn.a((by)par0NBTTagCompound)) {
            return false;
        }
        if (!par0NBTTagCompound.b("title")) {
            return false;
        }
        String s2 = par0NBTTagCompound.i("title");
        return s2 != null && s2.length() <= 16 ? par0NBTTagCompound.b("author") : false;
    }

    @Override
    public String l(ye par1ItemStack) {
        by nbttagcompound;
        ck nbttagstring;
        if (par1ItemStack.p() && (nbttagstring = (ck)(nbttagcompound = par1ItemStack.q()).a("title")) != null) {
            return nbttagstring.toString();
        }
        return super.l(par1ItemStack);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(ye par1ItemStack, uf par2EntityPlayer, List par3List, boolean par4) {
        by nbttagcompound;
        ck nbttagstring;
        if (par1ItemStack.p() && (nbttagstring = (ck)(nbttagcompound = par1ItemStack.q()).a("author")) != null) {
            par3List.add((Object)((Object)a.h) + String.format(bu.a((String)"book.byAuthor", (Object[])new Object[]{nbttagstring.a}), new Object[0]));
        }
    }

    @Override
    public ye a(ye par1ItemStack, abw par2World, uf par3EntityPlayer) {
        par3EntityPlayer.c(par1ItemStack);
        return par1ItemStack;
    }

    @Override
    public boolean s() {
        return true;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean e(ye par1ItemStack) {
        return true;
    }
}

