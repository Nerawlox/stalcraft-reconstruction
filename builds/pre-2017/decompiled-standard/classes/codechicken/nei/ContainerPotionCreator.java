/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.inventory.ContainerExtended;
import codechicken.core.inventory.SlotHandleClicks;
import codechicken.lib.inventory.InventoryNBT;
import codechicken.lib.inventory.InventoryUtils;
import codechicken.lib.packet.PacketCustom;
import codechicken.nei.NEICPH;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.NEIClientUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidj;

public class ContainerPotionCreator
extends ContainerExtended {
    eidj playerInv;
    tgfo potionInv;
    mssh potionStoreInv;

    public ContainerPotionCreator(eidj eidj2, mssh mssh2) {
        this.playerInv = eidj2;
        this.potionInv = new tgfo("Potion", true, 1);
        this.potionStoreInv = mssh2;
        this.func_75146_a(new SlotPotion(this.potionInv, 0, 25, 102));
        for (int i = 0; i < 9; ++i) {
            this.func_75146_a(new SlotPotionStore(mssh2, i, 8 + i * 18, 14));
        }
        this.bindPlayerInventory(eidj2, 8, 125);
    }

    @Override
    public boolean doMergeStackAreas(int n, cvzo cvzo2) {
        if (n < 10) {
            return this.func_75135_a(cvzo2, 10, 46, true);
        }
        return this.func_75135_a(cvzo2, 0, 1, false);
    }

    @Override
    public boolean func_75145_c(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public void func_75134_a(EntityPlayer entityPlayer) {
        super.func_75134_a(entityPlayer);
        if (!entityPlayer.field_70170_p.field_72995_K) {
            InventoryUtils.dropOnClose(entityPlayer, this.potionInv);
        }
    }

    @Override
    public void handleInputPacket(PacketCustom packetCustom) {
        cvzo cvzo2 = this.potionInv.func_70301_a(0);
        if (cvzo2 == null) {
            return;
        }
        bsyv bsyv2 = cvzo2._q()._n("CustomPotionEffects");
        if (packetCustom.readBoolean()) {
            supr supr2 = new supr(packetCustom.readUByte(), packetCustom.readInt(), packetCustom.readUByte());
            for (int i = 0; i < bsyv2._d(); ++i) {
                supr supr3 = supr._b((qoac)bsyv2._b(i));
                if (supr3._a() != supr2._a()) continue;
                bsyv2._c.set(i, supr2._a(new qoac()));
                return;
            }
            bsyv2._a(supr2._a(new qoac()));
        } else {
            int n = packetCustom.readUByte();
            int n2 = 0;
            while (n2 < bsyv2._d()) {
                supr supr4 = supr._b((qoac)bsyv2._b(n2));
                if (supr4._a() == n) {
                    bsyv2._a(n2);
                    continue;
                }
                ++n2;
            }
        }
    }

    public void setPotionEffect(int n, int n2, int n3) {
        PacketCustom packetCustom = NEICPH.createContainerPacket();
        packetCustom.writeBoolean(true);
        packetCustom.writeByte(n);
        packetCustom.writeInt(n2);
        packetCustom.writeByte(n3);
        packetCustom.sendToServer();
    }

    public void removePotionEffect(int n) {
        PacketCustom packetCustom = NEICPH.createContainerPacket();
        packetCustom.writeBoolean(false);
        packetCustom.writeByte(n);
        packetCustom.sendToServer();
    }

    public static class InventoryPotionStore
    extends InventoryNBT {
        public InventoryPotionStore() {
            super(9, NEIClientConfig.global.nbt._m("potionStore"));
        }

        @Override
        public void func_70296_d() {
            super.func_70296_d();
            NEIClientConfig.global.nbt._a("potionStore", this.tag);
            NEIClientConfig.global.saveNBT();
        }
    }

    public class SlotPotionStore
    extends SlotHandleClicks {
        public SlotPotionStore(mssh mssh2, int n, int n2, int n3) {
            super(mssh2, n, n2, n3);
        }

        @Override
        public cvzo slotClick(ContainerExtended containerExtended, EntityPlayer entityPlayer, int n, int n2) {
            cvzo cvzo2 = entityPlayer.field_71071_by._g();
            if (n == 0 && n2 == 1) {
                NEIClientUtils.cheatItem(this.func_75211_c(), n, -1);
            } else if (n == 1) {
                this.func_75215_d(null);
            } else if (cvzo2 != null) {
                if (this.func_75214_a(cvzo2)) {
                    this.func_75215_d(InventoryUtils.copyStack(cvzo2, 1));
                    entityPlayer.field_71071_by._d(null);
                }
            } else if (this.func_75216_d()) {
                entityPlayer.field_71071_by._d(this.func_75211_c());
            }
            return null;
        }

        @Override
        public boolean func_75214_a(cvzo cvzo2) {
            return cvzo2._a() instanceof zyyc;
        }
    }

    public class SlotPotion
    extends yeso {
        public SlotPotion(mssh mssh2, int n, int n2, int n3) {
            super(mssh2, n, n2, n3);
        }

        @Override
        public boolean func_75214_a(cvzo cvzo2) {
            return cvzo2._a() instanceof zyyc;
        }

        @Override
        public void func_75218_e() {
            super.func_75218_e();
            if (this.func_75216_d()) {
                cvzo cvzo2 = this.func_75211_c();
                if (!cvzo2._p()) {
                    cvzo2._d(new qoac("tag"));
                }
                if (!cvzo2._q()._c("CustomPotionEffects")) {
                    cvzo2._q()._a("CustomPotionEffects", new bsyv());
                }
            }
        }
    }
}

