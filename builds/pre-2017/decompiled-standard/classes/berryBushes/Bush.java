/*
 * Decompiled with CFR 0.152.
 */
package berryBushes;

import berryBushes.Base;
import berryBushes.te.BushTE;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;

public class Bush
extends iwgt {
    public int Meta;

    public Bush(int n, int n2) {
        super(n, tflj._j);
        this.Meta = n2;
        this.func_71894_b(0.2f);
        this.func_71848_c(0.5f);
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new BushTE();
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        switch (this.Meta) {
            case 0: {
                this.func_71905_a(0.2f, 0.0f, 0.2f, 0.8f, 0.6f, 0.8f);
                break;
            }
            case 1: {
                this.func_71905_a(0.15f, 0.0f, 0.15f, 0.85f, 0.8f, 0.85f);
                break;
            }
            case 2: {
                this.func_71905_a(0.1f, 0.0f, 0.1f, 0.9f, 0.9f, 0.9f);
                break;
            }
            case 3: {
                this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                break;
            }
        }
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return 0;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return 0;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71920_b(sdrg sdrg2, int n, int n2, int n3) {
        switch (this.Meta) {
            case 0: {
                return 1008406;
            }
            case 1: {
                return 1018134;
            }
            case 2: {
                return 2517270;
            }
            case 3: {
                return 4164425;
            }
        }
        return 0;
    }

    @Override
    public ArrayList<cvzo> getBlockDropped(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        ArrayList<cvzo> arrayList = super.getBlockDropped(ozlu2, n, n2, n3, n4, n5);
        tgdv tgdv2 = this.Meta == 0 ? Base.berry : (this.Meta == 1 ? Base.berryII : (this.Meta == 2 ? Base.berryIII : Base.berryIV));
        int n6 = new Random().nextInt(2) + 1;
        for (int i = 0; i < n6; ++i) {
            arrayList.add(new cvzo(tgdv2, 1));
        }
        return arrayList;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b("leaves_oak_opaque");
    }

    @Override
    public int func_71857_b() {
        return RenderingRegistry.getNextAvailableRenderId();
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

