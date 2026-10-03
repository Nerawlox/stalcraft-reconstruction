/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;

public class zwyn
extends jjgc {
    public bsse craftMatrix;
    public mssh craftResult;
    public final boolean isLocalWorld;
    public final EntityLivingBase owner;
    public final boolean isOwnerPlayer;
    public EntityPlayer player;
    public mssh[] inventories;
    public qoac containerData = new qoac();
    protected List<yeso> ownedSlots = new ArrayList<yeso>();

    public zwyn(EntityLivingBase entityLivingBase, mssh ... msshArray) {
        this.isLocalWorld = entityLivingBase.field_70170_p.field_72995_K;
        this.owner = entityLivingBase;
        this.isOwnerPlayer = entityLivingBase instanceof EntityPlayer;
        this.inventories = msshArray;
        if (this.isOwnerPlayer) {
            this.player = (EntityPlayer)entityLivingBase;
        }
        this.init();
    }

    public void init() {
        yeso yeso2;
        int n;
        int n2;
        if (this.hasCraftSlots() && this.isOwnerPlayer) {
            this.craftMatrix = new bsse(this, 2, 2);
            this.craftResult = new wpoq();
            this.func_75146_a(new pkzb(this.player, this.craftMatrix, this.craftResult, 0, 144, 36));
            for (n2 = 0; n2 < 2; ++n2) {
                for (n = 0; n < 2; ++n) {
                    this.func_75146_a(new yeso(this.craftMatrix, n + n2 * 2, 88 + n * 18, 26 + n2 * 18));
                }
            }
        }
        mssh mssh2 = this.inventories[0];
        for (n2 = 0; n2 < 9; ++n2) {
            yeso2 = new yeso(mssh2, n2, 8 + n2 * 18, 142);
            this.ownedSlots.add(yeso2);
            this.func_75146_a(yeso2);
        }
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 9; ++n) {
                yeso2 = new yeso(mssh2, n + (n2 + 1) * 9, 8 + n * 18, 84 + n2 * 18);
                this.ownedSlots.add(yeso2);
                this.func_75146_a(yeso2);
            }
        }
        for (n2 = 0; n2 < 4; ++n2) {
            yeso2 = new ccvh(this, mssh2, mssh2.func_70302_i_() - 1 - n2, 8, 8 + n2 * 18, n2);
            this.func_75146_a(yeso2);
            this.ownedSlots.add(yeso2);
        }
        if (this.hasCraftSlots() && this.isOwnerPlayer) {
            this.func_75130_a(this.craftMatrix);
        }
    }

    public List<yeso> getOwnedSlots() {
        return this.ownedSlots;
    }

    public void onArmorChanged() {
    }

    @Override
    public cvzo func_82846_b(EntityPlayer entityPlayer, int n) {
        cvzo cvzo2 = null;
        yeso yeso2 = (yeso)this.field_75151_b.get(n);
        if (yeso2 != null && yeso2.func_75216_d()) {
            int n2;
            cvzo cvzo3 = yeso2.func_75211_c();
            cvzo2 = cvzo3._l();
            if (n == 0) {
                if (!this.func_75135_a(cvzo3, 5, 41, true)) {
                    return null;
                }
                yeso2.func_75220_a(cvzo3, cvzo2);
            } else if (n >= 1 && n < 5 ? !this.func_75135_a(cvzo3, 5, 41, false) : (n >= 41 && n < 45 ? !this.func_75135_a(cvzo3, 5, 41, false) : (cvzo2._a() instanceof lpno && !((yeso)this.field_75151_b.get(41 + ((lpno)cvzo2._a()).field_77881_a)).func_75216_d() ? !this.func_75135_a(cvzo3, n2 = 41 + ((lpno)cvzo2._a()).field_77881_a, n2 + 1, false) : (n >= 5 && n < 32 ? !this.func_75135_a(cvzo3, 32, 41, false) : (n >= 32 && n < 41 ? !this.func_75135_a(cvzo3, 5, 32, false) : !this.func_75135_a(cvzo3, 5, 41, false)))))) {
                return null;
            }
            if (cvzo3._b == 0) {
                yeso2.func_75215_d(null);
            } else {
                yeso2.func_75218_e();
            }
            if (cvzo3._b == cvzo2._b) {
                return null;
            }
            yeso2.func_82870_a(entityPlayer, cvzo3);
        }
        return cvzo2;
    }

    @Override
    public void func_75130_a(mssh mssh2) {
        if (this.player != null) {
            cvzo cvzo2 = igjl._a()._a(this.craftMatrix, this.player.field_70170_p);
            this.craftResult.func_70299_a(0, cvzo2);
        }
    }

    @Override
    public boolean func_75145_c(EntityPlayer entityPlayer) {
        jhla.kjui kjui2 = new jhla.kjui(this.owner, this, entityPlayer);
        MinecraftForge.EVENT_BUS.post(kjui2);
        switch (kjui2.getResult()) {
            case ALLOW: {
                return true;
            }
            case DENY: {
                return false;
            }
        }
        return entityPlayer == this.owner;
    }

    @Override
    public cvzo func_75144_a(int n, int n2, int n3, EntityPlayer entityPlayer) {
        jhla.ezey ezey2 = new jhla.ezey(this.owner, this, entityPlayer, n, n2, n3);
        MinecraftForge.EVENT_BUS.post(ezey2);
        if (ezey2.isCanceled()) {
            return null;
        }
        return super.func_75144_a(n, n2, n3, entityPlayer);
    }

    @Override
    public void func_75134_a(EntityPlayer entityPlayer) {
        if (this.hasCraftSlots() && this.isOwnerPlayer) {
            for (int i = 0; i < 4; ++i) {
                cvzo cvzo2 = this.craftMatrix.func_70304_b(i);
                if (cvzo2 == null) continue;
                entityPlayer.func_71021_b(cvzo2);
            }
            this.craftResult.func_70299_a(0, null);
        }
        super.func_75134_a(entityPlayer);
        MinecraftForge.EVENT_BUS.post(new jhla.pidb(this.owner, this, entityPlayer));
    }

    @Override
    public void func_75142_b() {
        boolean bl = false;
        HashMap<Integer, cvzo> hashMap = new HashMap<Integer, cvzo>();
        HashMap<Integer, cvzo> hashMap2 = new HashMap<Integer, cvzo>();
        for (int i = 0; i < this.field_75151_b.size(); ++i) {
            cvzo cvzo2 = ((yeso)this.field_75151_b.get(i)).func_75211_c();
            cvzo cvzo3 = (cvzo)this.field_75153_a.get(i);
            if (cvzo._b(cvzo3, cvzo2)) continue;
            bl = true;
            hashMap.put(i, cvzo2 == null ? null : cvzo2._l());
            hashMap2.put(i, cvzo3);
            cvzo3 = cvzo2 == null ? null : cvzo2._l();
            this.field_75153_a.set(i, cvzo3);
            for (int j = 0; j < this.field_75149_d.size(); ++j) {
                ((sdcd)this.field_75149_d.get(j)).func_71111_a(this, i, cvzo3);
            }
        }
        if (bl) {
            this.onItemsChanged();
            MinecraftForge.EVENT_BUS.post(new jhla.eidj(this.owner, this, hashMap, hashMap2));
        }
    }

    public void onItemsChanged() {
    }

    public boolean isSlotActive(yeso yeso2) {
        return true;
    }

    public boolean hasCraftSlots() {
        return true;
    }

    public class kjui {
        public int _a;
        public int _b = -1;

        public kjui _a() {
            if (this._a >= zwyn.this.inventories.length) {
                throw new RuntimeException("Not enough slots!");
            }
            mssh mssh2 = zwyn.this.inventories[this._a];
            if (++this._b >= mssh2.func_70302_i_()) {
                this._b = 0;
                ++this._a;
            }
            return this;
        }

        public mssh _b() {
            return zwyn.this.inventories[this._a];
        }
    }
}

