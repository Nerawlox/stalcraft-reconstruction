/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.core.misc.pidb;
import gloomyfolken.mods.stalker.misc.tupg;
import java.util.ArrayList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidj;

public class jzak
extends zwyn {
    public ArrayList<ccvh> armorSlots;
    public ArrayList<ydiu> artefaktSlots;
    protected ndjp backpackSlot;

    public jzak(EntityLivingBase entityLivingBase, mssh ... msshArray) {
        super(entityLivingBase, msshArray);
    }

    @Override
    public void init() {
        rpbk rpbk2;
        int n;
        this.armorSlots = new ArrayList();
        this.artefaktSlots = new ArrayList();
        zwyn.kjui kjui2 = new zwyn.kjui();
        this.addCommonSlot(kjui2, 26, 26);
        this.addCommonSlot(kjui2, 26, 44);
        this.addCommonSlot(kjui2, 62, 26);
        this.addCommonSlot(kjui2, 62, 44);
        for (n = 0; n < 4; ++n) {
            for (int i = 0; i < 8; ++i) {
                this.addCommonSlot(kjui2, 125 + n * 18, 16 + i * 18);
            }
        }
        for (n = 0; n < 4; ++n) {
            kjui2._a();
            rpbk2 = new bagk(this, kjui2._b(), kjui2._b, 44, 62 - n * 18, 3 - n);
            this.func_75146_a(rpbk2);
            this.armorSlots.add((ccvh)rpbk2);
        }
        for (n = 0; n < 5; ++n) {
            kjui2._a();
            rpbk2 = new ydiu(this, kjui2._b(), kjui2._b, 8 + n * 18, 108);
            this.artefaktSlots.add((ydiu)rpbk2);
            this.func_75146_a(rpbk2);
        }
        for (n = 0; n < 3; ++n) {
            kjui2._a();
            this.func_75146_a(new vlar(this, kjui2._b(), kjui2._b, 26 + n * 18, 131));
        }
        for (n = 0; n < 4; ++n) {
            kjui2._a();
            this.func_75146_a(new dgnj(this, kjui2._b(), kjui2._b, 17 + n * 18, 85));
        }
        kjui2._a();
        this.backpackSlot = new ndjp(this, kjui2._b(), kjui2._b, 44, 155);
        this.func_75146_a(this.backpackSlot);
        this.ownedSlots = this.field_75151_b;
    }

    @Override
    public boolean hasCraftSlots() {
        return false;
    }

    private rpbk addCommonSlot(zwyn.kjui kjui2, int n, int n2) {
        kjui2._a();
        rpbk rpbk2 = new rpbk(this, kjui2._b(), kjui2._b, n, n2);
        this.func_75146_a(rpbk2);
        return rpbk2;
    }

    @Override
    public cvzo func_82846_b(EntityPlayer entityPlayer, int n) {
        return null;
    }

    @Override
    public cvzo func_75144_a(int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (n >= 0 && !this.isSlotActive(this.func_75139_a(n))) {
            return null;
        }
        return super.func_75144_a(n, n2, n3, entityPlayer);
    }

    @Override
    public boolean func_94530_a(cvzo cvzo2, yeso yeso2) {
        return super.func_94530_a(cvzo2, yeso2);
    }

    public boolean hasBackpack() {
        return this.backpackSlot.func_75216_d();
    }

    @Override
    public yeso func_75139_a(int n) {
        return n < this.field_75151_b.size() && n >= 0 ? (yeso)this.field_75151_b.get(n) : null;
    }

    @Override
    public void func_75141_a(int n, cvzo cvzo2) {
        yeso yeso2 = this.func_75139_a(n);
        if (yeso2 != null) {
            yeso2.func_75215_d(cvzo2);
        }
    }

    @Override
    public void func_75142_b() {
        super.func_75142_b();
    }

    public int getArtefaktSlots() {
        cvzo cvzo2 = this.owner.func_71124_b(3);
        if (cvzo2 != null && cvzo2._a() instanceof dgmz) {
            return ((dgmz)cvzo2._a())._n;
        }
        return 0;
    }

    @Override
    public void onItemsChanged() {
        if (this.isOwnerPlayer) {
            ccxr ccxr2 = ncwh._a((EntityPlayer)this.owner);
            tupg tupg2 = tupg._a(this.player);
            tupg2._c();
            tupg2._e();
            if (!ccxr2._a.field_70170_p.field_72995_K) {
                InvokeSideOnly.frontend(() -> {});
            }
        }
    }

    public ArrayList<ccvh> getArmorSlots() {
        return this.armorSlots;
    }

    public EntityLivingBase getOwner() {
        return this.owner;
    }

    @Override
    public boolean isSlotActive(yeso yeso2) {
        if (this.artefaktSlots.indexOf(yeso2) >= this.getArtefaktSlots()) {
            return false;
        }
        cvzo cvzo2 = this.getArmorSlots().get(2).func_75211_c();
        return !this.isOwnerPlayer || cvzo2 == null || yeso2 != this.backpackSlot || !(cvzo2._a() instanceof dgmz) || ((dgmz)cvzo2._a())._k(this.backpackSlot.func_75211_c());
    }

    @Override
    public void func_75134_a(EntityPlayer entityPlayer) {
        eidj eidj2 = entityPlayer.field_71071_by;
        if (!entityPlayer.field_70170_p.field_72995_K && eidj2._g() != null && (entityPlayer.func_110143_aJ() > 0.0f || pidb._a(eidj2._g(), entityPlayer))) {
            InvokeSideOnly.frontend(() -> {});
        }
        super.func_75134_a(entityPlayer);
    }
}

