/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;
import net.minecraft.util.sajh;
import noppes.npcs.CustomItems;
import noppes.npcs.blocks.TileMailbox;

public class BlockMailbox
extends iwgt {
    public int renderId = -1;

    public BlockMailbox(int n) {
        super(n, tflj._e);
        this.func_71849_a(CustomItems.tab);
    }

    @Override
    public void func_71879_a(int n, tgbl tgbl2, List list2) {
        list2.add(new cvzo(n, 1, 0));
        list2.add(new cvzo(n, 1, 1));
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (!ozlu2.field_72995_K) {
            InvokeSideOnly.frontend(() -> {});
        }
        return true;
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new TileMailbox();
    }

    public ArrayList getBlockDropped(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        ArrayList<cvzo> arrayList = new ArrayList<cvzo>();
        arrayList.add(new cvzo(this, 1, this.func_71873_h(ozlu2, n, n2, n3)));
        return arrayList;
    }

    @Override
    public int func_71899_b(int n) {
        return n >> 2;
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        int n4 = sajh._c((double)(entityLivingBase.field_70177_z * 4.0f / 360.0f) + 0.5) & 3;
        ozlu2.func_72921_c(n, n2, n3, (n4 %= 4) | cvzo2._j() << 2, 2);
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    @Override
    public int func_71857_b() {
        return this.renderId;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan func_71858_a(int n, int n2) {
        return twgu.field_72013_bc.func_71851_a(n);
    }
}

