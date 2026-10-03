/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.RandomEquipSettings;
import noppes.npcs.containers.ContainerNPCSetup;

public class ContainerRandomEquip
extends ContainerNPCSetup {
    public final RandomEquipSettings settings;

    public ContainerRandomEquip(EntityNPCInterface entityNPCInterface, EntityPlayer entityPlayer) {
        super(entityNPCInterface, entityPlayer);
        int n;
        int n2;
        this.settings = entityNPCInterface.inventory.randomEquipSettings;
        for (n2 = 0; n2 < 4; ++n2) {
            for (n = 0; n < 6; ++n) {
                this.func_75146_a(new yeso(this.settings, n2 * 6 + n, n2 * 60 - 50, n * 18){

                    @Override
                    public boolean func_75214_a(cvzo cvzo2) {
                        return this.field_75224_c.func_94041_b(this.field_75222_d, cvzo2);
                    }
                });
            }
        }
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.func_75146_a(new yeso(entityPlayer.field_71071_by, n + n2 * 9 + 9, n * 18 + 8, 113 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 9; ++n2) {
            this.func_75146_a(new yeso(entityPlayer.field_71071_by, n2, n2 * 18 + 8, 171));
        }
    }
}

