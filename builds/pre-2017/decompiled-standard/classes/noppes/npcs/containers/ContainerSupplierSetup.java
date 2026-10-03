/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.containers.ContainerNPCSetup;
import noppes.npcs.roles.RoleSupplier;

public class ContainerSupplierSetup
extends ContainerNPCSetup {
    private RoleSupplier supplier;

    public ContainerSupplierSetup(EntityNPCInterface entityNPCInterface, EntityPlayer entityPlayer) {
        super(entityNPCInterface, entityPlayer);
        int n;
        this.supplier = (RoleSupplier)entityNPCInterface.roleInterface;
        for (n = 0; n < 8; ++n) {
            this.func_75146_a(new yeso(this.supplier.tradepacksInv, n, 200, 22 * n){

                @Override
                public boolean func_75214_a(cvzo cvzo2) {
                    return cvzo2 == null || cvzo2._a() instanceof pjnz;
                }
            });
        }
        for (n = 0; n < 3; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.func_75146_a(new yeso(entityPlayer.field_71071_by, i + n * 9 + 9, 8 + i * 18, 96 + n * 18));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.func_75146_a(new yeso(entityPlayer.field_71071_by, n, 8 + n * 18, 154));
        }
    }
}

