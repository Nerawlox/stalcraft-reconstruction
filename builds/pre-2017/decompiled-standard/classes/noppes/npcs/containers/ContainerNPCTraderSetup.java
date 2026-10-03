/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.containers.ContainerNPCSetup;
import noppes.npcs.roles.RoleTrader;

public class ContainerNPCTraderSetup
extends ContainerNPCSetup {
    private RoleTrader role;

    public ContainerNPCTraderSetup(EntityNPCInterface entityNPCInterface, EntityPlayer entityPlayer) {
        super(entityNPCInterface, entityPlayer);
        int n;
        this.role = (RoleTrader)entityNPCInterface.roleInterface;
        for (n = 0; n < 63; ++n) {
            this.func_75146_a(new yeso(this.role.inventorySold, n, -100, -100));
        }
        for (n = 0; n < 210; ++n) {
            this.func_75146_a(new yeso(this.role.inventoryBought, n, -100, -100));
        }
        this.setupSlotsForPage(0);
        for (n = 0; n < 3; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.func_75146_a(new yeso(entityPlayer.field_71071_by, i + n * 9 + 9, 8 + i * 18, 96 + n * 18));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.func_75146_a(new yeso(entityPlayer.field_71071_by, n, 8 + n * 18, 154));
        }
    }

    public void setupSlotsForPage(int n) {
        int n2;
        for (n2 = 0; n2 < 273; ++n2) {
            yeso yeso2 = this.func_75139_a(n2);
            yeso2.field_75223_e = -100;
            yeso2.field_75221_f = 100;
        }
        for (n2 = 0; n2 < 21; ++n2) {
            int n3 = 220;
            int n4 = 7;
            yeso yeso3 = this.func_75139_a(n2 + n * 21);
            yeso3.field_75223_e = n3 += n2 / 7 * 59;
            yeso3.field_75221_f = n4 += n2 % 7 * 22;
        }
    }
}

