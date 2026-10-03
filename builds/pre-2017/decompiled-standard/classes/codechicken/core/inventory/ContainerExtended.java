/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.inventory;

import codechicken.core.inventory.SlotHandleClicks;
import codechicken.lib.packet.PacketCustom;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.eidj;

public abstract class ContainerExtended
extends jjgc
implements sdcd {
    public LinkedList<EntityPlayerMP> playerCrafters = new LinkedList();

    public ContainerExtended() {
        this.field_75149_d.add(this);
    }

    @Override
    public void func_75132_a(sdcd sdcd2) {
        if (sdcd2 instanceof EntityPlayerMP) {
            this.playerCrafters.add((EntityPlayerMP)sdcd2);
            this.sendContainerAndContentsToPlayer(this, this.func_75138_a(), Arrays.asList((EntityPlayerMP)sdcd2));
            this.func_75142_b();
        } else {
            super.func_75132_a(sdcd2);
        }
    }

    @Override
    public void func_82847_b(sdcd sdcd2) {
        if (sdcd2 instanceof EntityPlayerMP) {
            this.playerCrafters.remove(sdcd2);
        } else {
            super.func_82847_b(sdcd2);
        }
    }

    @Override
    public void func_71110_a(jjgc jjgc2, List list) {
        this.sendContainerAndContentsToPlayer(jjgc2, list, this.playerCrafters);
    }

    public void sendContainerAndContentsToPlayer(jjgc jjgc2, List<cvzo> list, List<EntityPlayerMP> list2) {
        LinkedList<cvzo> linkedList = new LinkedList<cvzo>();
        for (int i = 0; i < list.size(); ++i) {
            cvzo object2 = list.get(i);
            if (object2 != null && object2._b > 127) {
                list.set(i, null);
                linkedList.add(object2);
                continue;
            }
            linkedList.add(null);
        }
        for (EntityPlayerMP entityPlayerMP : list2) {
            entityPlayerMP.func_71110_a(jjgc2, list);
        }
        for (int i = 0; i < linkedList.size(); ++i) {
            cvzo cvzo2 = (cvzo)linkedList.get(i);
            if (cvzo2 == null) continue;
            this.sendLargeStack(cvzo2, i, list2);
        }
    }

    public void sendLargeStack(cvzo cvzo2, int n, List<EntityPlayerMP> list) {
    }

    @Override
    public void func_71112_a(jjgc jjgc2, int n, int n2) {
        for (EntityPlayerMP entityPlayerMP : this.playerCrafters) {
            entityPlayerMP.func_71112_a(jjgc2, n, n2);
        }
    }

    @Override
    public void func_71111_a(jjgc jjgc2, int n, cvzo cvzo2) {
        if (cvzo2 != null && cvzo2._b > 127) {
            this.sendLargeStack(cvzo2, n, this.playerCrafters);
        } else {
            for (EntityPlayerMP entityPlayerMP : this.playerCrafters) {
                entityPlayerMP.func_71111_a(jjgc2, n, cvzo2);
            }
        }
    }

    @Override
    public cvzo func_75144_a(int n, int n2, int n3, EntityPlayer entityPlayer) {
        yeso yeso2;
        if (n >= 0 && n < this.field_75151_b.size() && (yeso2 = this.func_75139_a(n)) instanceof SlotHandleClicks) {
            return ((SlotHandleClicks)yeso2).slotClick(this, entityPlayer, n2, n3);
        }
        return super.func_75144_a(n, n2, n3, entityPlayer);
    }

    @Override
    public cvzo func_82846_b(EntityPlayer entityPlayer, int n) {
        cvzo cvzo2 = null;
        yeso yeso2 = (yeso)this.field_75151_b.get(n);
        if (yeso2 != null && yeso2.func_75216_d()) {
            cvzo cvzo3 = yeso2.func_75211_c();
            cvzo2 = cvzo3._l();
            if (!this.doMergeStackAreas(n, cvzo3)) {
                return null;
            }
            if (cvzo3._b == 0) {
                yeso2.func_75215_d(null);
            } else {
                yeso2.func_75218_e();
            }
        }
        return cvzo2;
    }

    @Override
    public boolean func_75135_a(cvzo cvzo2, int n, int n2, boolean bl) {
        yeso yeso2;
        int n3;
        boolean bl2 = false;
        int n4 = n3 = bl ? n2 - 1 : n;
        if (cvzo2 == null) {
            return false;
        }
        if (cvzo2._e()) {
            while (cvzo2._b > 0 && (bl ? n3 >= n : n3 < n2)) {
                yeso2 = (yeso)this.field_75151_b.get(n3);
                cvzo cvzo3 = yeso2.func_75211_c();
                if (cvzo3 != null && cvzo3._d == cvzo2._d && (!cvzo2._g() || cvzo2._j() == cvzo3._j()) && cvzo._a(cvzo2, cvzo3)) {
                    int n5 = cvzo3._b + cvzo2._b;
                    int n6 = Math.min(cvzo2._d(), yeso2.func_75219_a());
                    if (n5 <= n6) {
                        cvzo2._b = 0;
                        cvzo3._b = n5;
                        yeso2.func_75218_e();
                        bl2 = true;
                    } else if (cvzo3._b < n6) {
                        cvzo2._b -= n6 - cvzo3._b;
                        cvzo3._b = n6;
                        yeso2.func_75218_e();
                        bl2 = true;
                    }
                }
                n3 += bl ? -1 : 1;
            }
        }
        if (cvzo2._b > 0) {
            int n7 = n3 = bl ? n2 - 1 : n;
            while (cvzo2._b > 0 && (bl ? n3 >= n : n3 < n2)) {
                yeso2 = (yeso)this.field_75151_b.get(n3);
                if (!yeso2.func_75216_d() && yeso2.func_75214_a(cvzo2)) {
                    int n8 = Math.min(cvzo2._d(), yeso2.func_75219_a());
                    if (cvzo2._b <= n8) {
                        yeso2.func_75215_d(cvzo2._l());
                        yeso2.func_75218_e();
                        cvzo2._b = 0;
                        bl2 = true;
                    } else {
                        yeso2.func_75215_d(cvzo2._a(n8));
                        yeso2.func_75218_e();
                        bl2 = true;
                    }
                }
                n3 += bl ? -1 : 1;
            }
        }
        return bl2;
    }

    public boolean doMergeStackAreas(int n, cvzo cvzo2) {
        return false;
    }

    protected void bindPlayerInventory(eidj eidj2) {
        this.bindPlayerInventory(eidj2, 8, 84);
    }

    protected void bindPlayerInventory(eidj eidj2, int n, int n2) {
        int n3;
        for (n3 = 0; n3 < 3; ++n3) {
            for (int i = 0; i < 9; ++i) {
                this.func_75146_a(new yeso(eidj2, i + n3 * 9 + 9, n + i * 18, n2 + n3 * 18));
            }
        }
        for (n3 = 0; n3 < 9; ++n3) {
            this.func_75146_a(new yeso(eidj2, n3, n + n3 * 18, n2 + 58));
        }
    }

    @Override
    public boolean func_75145_c(EntityPlayer entityPlayer) {
        return true;
    }

    public void sendContainerPacket(PacketCustom packetCustom) {
        for (EntityPlayerMP entityPlayerMP : this.playerCrafters) {
            packetCustom.sendToPlayer(entityPlayerMP);
        }
    }

    public void handleOutputPacket(PacketCustom packetCustom) {
    }

    public void handleInputPacket(PacketCustom packetCustom) {
    }

    public void handleGuiChange(int n, int n2) {
    }

    public void sendProgressBarUpdate(int n, int n2) {
        for (sdcd sdcd2 : this.field_75149_d) {
            sdcd2.func_71112_a(this, n, n2);
        }
    }
}

