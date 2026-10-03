/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.core.misc.sajh;
import gloomyfolken.mods.core.misc.srli;
import net.minecraft.entity.player.EntityPlayer;

public class ContainerNpcResearcher
extends jjgc {
    private final EntityPlayer player;
    private final ofxb researchInventory;
    private final SlotResearch researchSlot;

    public ContainerNpcResearcher(EntityPlayer entityPlayer) {
        int n;
        this.player = entityPlayer;
        for (n = 0; n < 3; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.func_75146_a(new yeso(entityPlayer.field_71071_by, i + n * 9 + 9, 8 + i * 18, 70 + n * 18));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.func_75146_a(new yeso(entityPlayer.field_71071_by, n, 8 + n * 18, 127));
        }
        this.researchInventory = new ofxb(1);
        this.researchSlot = new SlotResearch(this.researchInventory, 0, 80, 29);
        this.func_75146_a(this.researchSlot);
    }

    @Override
    public cvzo func_82846_b(EntityPlayer entityPlayer, int n) {
        cvzo cvzo2 = null;
        yeso yeso2 = (yeso)this.field_75151_b.get(n);
        if (yeso2 != null && yeso2.func_75216_d()) {
            cvzo cvzo3 = yeso2.func_75211_c();
            cvzo2 = cvzo3._l();
            if (n == 36) {
                if (!this.func_75135_a(cvzo3, 0, 36, false)) {
                    return null;
                }
            } else if (cvzo2._a() instanceof srli && !this.researchSlot.func_75216_d()) {
                cvzo cvzo4 = cvzo3._l();
                cvzo4._b = 1;
                --cvzo3._b;
                this.researchSlot.func_75215_d(cvzo4);
            }
            if (cvzo3._b == 0) {
                yeso2.func_75215_d(null);
            }
            if (cvzo3._b == cvzo2._b) {
                return null;
            }
            yeso2.func_82870_a(this.player, cvzo3);
        }
        return cvzo2;
    }

    @Override
    public boolean func_75145_c(EntityPlayer entityPlayer) {
        return true;
    }

    public cvzo getSelectedStack() {
        return this.researchSlot.func_75211_c();
    }

    public void probeItem() {
        cvzo cvzo2 = this.researchSlot.func_75211_c();
        if (cvzo2 != null && cvzo2._a() instanceof srli) {
            srli srli2 = (srli)((Object)cvzo2._a());
            srli2._f(cvzo2);
            sajh._n._a(cvzo2, null, false);
        }
        this.func_75142_b();
    }

    @Override
    public void func_75134_a(EntityPlayer entityPlayer) {
        super.func_75134_a(entityPlayer);
        if (!entityPlayer.field_70170_p.field_72995_K && this.researchSlot.func_75216_d()) {
            InvokeSideOnly.frontend(() -> {});
        }
    }

    static class SlotResearch
    extends yeso {
        public SlotResearch(mssh mssh2, int n, int n2, int n3) {
            super(mssh2, n, n2, n3);
        }

        @Override
        public int func_75219_a() {
            return 1;
        }

        @Override
        public boolean func_75214_a(cvzo cvzo2) {
            return cvzo2 == null || cvzo2._a() instanceof srli;
        }
    }
}

