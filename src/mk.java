/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asc
 *  mi
 *  mj
 *  mo
 *  net.minecraftforge.common.ChestGenHooks
 */
import java.util.Random;
import net.minecraftforge.common.ChestGenHooks;

public class mk
extends mj {
    public ye b;
    public int c;
    public int d;

    public mk(int par1, int par2, int par3, int par4, int par5) {
        super(par5);
        this.b = new ye(par1, 1, par2);
        this.c = par3;
        this.d = par4;
    }

    public mk(ye par1ItemStack, int par2, int par3, int par4) {
        super(par4);
        this.b = par1ItemStack;
        this.c = par2;
        this.d = par3;
    }

    public static void a(Random par0Random, mk[] par1ArrayOfWeightedRandomChestContent, mo par2IInventory, int par3) {
        for (int j2 = 0; j2 < par3; ++j2) {
            ye[] stacks;
            mk weightedrandomchestcontent = (mk)mi.a((Random)par0Random, (mj[])par1ArrayOfWeightedRandomChestContent);
            for (ye item : stacks = weightedrandomchestcontent.generateChestContent(par0Random, par2IInventory)) {
                par2IInventory.a(par0Random.nextInt(par2IInventory.j_()), item);
            }
        }
    }

    public static void a(Random par0Random, mk[] par1ArrayOfWeightedRandomChestContent, asc par2TileEntityDispenser, int par3) {
        for (int j2 = 0; j2 < par3; ++j2) {
            ye[] stacks;
            mk weightedrandomchestcontent = (mk)mi.a((Random)par0Random, (mj[])par1ArrayOfWeightedRandomChestContent);
            for (ye item : stacks = weightedrandomchestcontent.generateChestContent(par0Random, (mo)par2TileEntityDispenser)) {
                par2TileEntityDispenser.a(par0Random.nextInt(par2TileEntityDispenser.j_()), item);
            }
        }
    }

    public static mk[] a(mk[] par0ArrayOfWeightedRandomChestContent, mk ... par1ArrayOfWeightedRandomChestContent) {
        mk[] aweightedrandomchestcontent1 = new mk[par0ArrayOfWeightedRandomChestContent.length + par1ArrayOfWeightedRandomChestContent.length];
        int i2 = 0;
        for (int j2 = 0; j2 < par0ArrayOfWeightedRandomChestContent.length; ++j2) {
            aweightedrandomchestcontent1[i2++] = par0ArrayOfWeightedRandomChestContent[j2];
        }
        mk[] aweightedrandomchestcontent2 = par1ArrayOfWeightedRandomChestContent;
        int k2 = par1ArrayOfWeightedRandomChestContent.length;
        for (int l2 = 0; l2 < k2; ++l2) {
            mk weightedrandomchestcontent1 = aweightedrandomchestcontent2[l2];
            aweightedrandomchestcontent1[i2++] = weightedrandomchestcontent1;
        }
        return aweightedrandomchestcontent1;
    }

    protected ye[] generateChestContent(Random random, mo newInventory) {
        return ChestGenHooks.generateStacks((Random)random, (ye)this.b, (int)this.c, (int)this.d);
    }
}

