/*
 * Decompiled with CFR 0.152.
 */
package berryBushes;

import berryBushes.Base;
import berryBushes.te.BushTE;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.tdpx;

public class Berry
extends tgha {
    private int Meta;

    public Berry(int n, int n2, float f, int n3) {
        super(n, n2, f, false);
        this.Meta = n3;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94581_a(nege nege2) {
        switch (this.Meta) {
            case 0: {
                this.field_77791_bV = nege2._b("berries:berryI");
                break;
            }
            case 1: {
                this.field_77791_bV = nege2._b("berries:berry");
                break;
            }
            case 2: {
                this.field_77791_bV = nege2._b("berries:berryIII");
                break;
            }
            case 3: {
                this.field_77791_bV = nege2._b("berries:berryIV");
                break;
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(cvzo cvzo2, EntityPlayer entityPlayer, List list2, boolean bl) {
        switch (this.Meta) {
            case 0: {
                list2.add(tdpx._a("A small juicy berry"));
                list2.add(tdpx._a("1.5/10"));
                break;
            }
            case 1: {
                list2.add(tdpx._a("A sweet small tasty berry"));
                list2.add(tdpx._a("2/10"));
                break;
            }
            case 2: {
                list2.add(tdpx._a("A juicy, tasty, big berry"));
                list2.add(tdpx._a("3/10"));
                break;
            }
            case 3: {
                list2.add(tdpx._a("A giant sweet and juicy berry"));
                list2.add(tdpx._a("4/10"));
                break;
            }
        }
    }

    @Override
    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (this.Meta == 0 && (ozlu2.func_72798_a(n, n2, n3) == twgu.field_71980_u.field_71990_ca || ozlu2.func_72798_a(n, n2, n3) == twgu.field_71979_v.field_71990_ca)) {
            ozlu2.func_94575_c(n, n2 + 1, n3, Base.berryCrop.field_71990_ca);
            BushTE bushTE = new BushTE();
            bushTE.isCrop = true;
            ozlu2.func_72837_a(n, n2 + 1, n3, bushTE);
            --entityPlayer.func_71045_bC()._b;
        }
        return false;
    }
}

