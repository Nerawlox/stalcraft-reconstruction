/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.containers.InventoryNPC;
import noppes.npcs.containers.NpcBankInventory;
import noppes.npcs.containers.SlotNpcBankCurrency;
import noppes.npcs.controllers.PlayerBankData;
import noppes.npcs.controllers.PlayerDataController;

public class ContainerNPCBankInterface
extends jjgc {
    public InventoryNPC currencyMatrix;
    public SlotNpcBankCurrency currency;
    public int slot = 0;
    public int bankid;
    private EntityPlayer player;
    private PlayerBankData data;

    public ContainerNPCBankInterface(EntityPlayer entityPlayer, int n, int n2) {
        int n3;
        int n4;
        this.bankid = n2;
        this.slot = n;
        this.player = entityPlayer;
        this.currencyMatrix = new InventoryNPC("currency", 1, this);
        if (!this.isAvailable() || this.canBeUpgraded()) {
            this.currency = new SlotNpcBankCurrency(this, this.currencyMatrix, 0, 80, 29);
            this.func_75146_a(this.currency);
        }
        NpcBankInventory npcBankInventory = new NpcBankInventory(54);
        if (!entityPlayer.field_70170_p.field_72995_K) {
            this.data = PlayerDataController.instance.getBankData(entityPlayer, n2);
            npcBankInventory = this.data.getBankOrDefault((int)n2).itemSlots.get(n);
        }
        int n5 = this.xOffset();
        for (n4 = 0; n4 < this.getRowNumber(); ++n4) {
            for (n3 = 0; n3 < 9; ++n3) {
                int n6 = n3 + n4 * 9;
                this.func_75146_a(new yeso(npcBankInventory, n6, 8 + n3 * 18, 17 + n5 + n4 * 18));
            }
        }
        if (this.isUpgraded()) {
            n5 += 54;
        }
        for (n4 = 0; n4 < 3; ++n4) {
            for (n3 = 0; n3 < 9; ++n3) {
                this.func_75146_a(new yeso(entityPlayer.field_71071_by, n3 + n4 * 9 + 9, 8 + n3 * 18, 86 + n5 + n4 * 18));
            }
        }
        for (n4 = 0; n4 < 9; ++n4) {
            this.func_75146_a(new yeso(entityPlayer.field_71071_by, n4, 8 + n4 * 18, 144 + n5));
        }
    }

    public int getRowNumber() {
        return 0;
    }

    public int xOffset() {
        return 0;
    }

    @Override
    public void func_75130_a(mssh mssh2) {
    }

    public boolean isAvailable() {
        return false;
    }

    public boolean isUpgraded() {
        return false;
    }

    public boolean canBeUpgraded() {
        return false;
    }

    @Override
    public cvzo func_82846_b(EntityPlayer entityPlayer, int n) {
        return null;
    }

    @Override
    public boolean func_75145_c(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public void func_75134_a(EntityPlayer entityPlayer) {
        super.func_75134_a(entityPlayer);
        if (!entityPlayer.field_70170_p.field_72995_K) {
            cvzo cvzo2 = this.currencyMatrix.func_70301_a(0);
            this.currencyMatrix.func_70299_a(0, null);
            if (cvzo2 != null) {
                entityPlayer.func_71021_b(cvzo2);
            }
        }
    }
}

