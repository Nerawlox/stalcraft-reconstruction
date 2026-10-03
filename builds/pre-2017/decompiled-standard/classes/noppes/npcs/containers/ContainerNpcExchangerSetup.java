/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.containers.ContainerNPCSetup;
import noppes.npcs.roles.RoleExchanger;

public class ContainerNpcExchangerSetup
extends ContainerNPCSetup {
    public RoleExchanger role;

    public ContainerNpcExchangerSetup(EntityNPCInterface entityNPCInterface, EntityPlayer entityPlayer) {
        super(entityNPCInterface, entityPlayer);
        int n;
        int n2;
        this.role = (RoleExchanger)entityNPCInterface.roleInterface;
        for (n2 = 0; n2 < 18; ++n2) {
            n = 194 + n2 % 3 * 59;
            int n3 = 14 + n2 / 3 * 22;
            this.func_75146_a(new yeso(this.role.invCurrency, n2, n, n3));
            this.func_75146_a(new yeso(this.role.invSold, n2, n + 26, n3));
        }
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.func_75146_a(new yeso(entityPlayer.field_71071_by, n + n2 * 9 + 9, 8 + n * 18, 103 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 9; ++n2) {
            this.func_75146_a(new yeso(entityPlayer.field_71071_by, n2, 8 + n2 * 18, 161));
        }
    }
}

