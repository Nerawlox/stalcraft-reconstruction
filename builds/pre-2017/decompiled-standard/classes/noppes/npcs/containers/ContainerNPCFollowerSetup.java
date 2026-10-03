/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.containers.ContainerNPCSetup;
import noppes.npcs.roles.RoleFollower;

public class ContainerNPCFollowerSetup
extends ContainerNPCSetup {
    private RoleFollower role;

    public ContainerNPCFollowerSetup(EntityNPCInterface entityNPCInterface, EntityPlayer entityPlayer) {
        super(entityNPCInterface, entityPlayer);
        int n;
        this.role = (RoleFollower)entityNPCInterface.roleInterface;
        for (n = 0; n < 3; ++n) {
            this.func_75146_a(new yeso(this.role.inventory, n, 44, 29 + n * 25));
        }
        for (n = 0; n < 3; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.func_75146_a(new yeso(entityPlayer.field_71071_by, i + n * 9 + 9, 8 + i * 18, 103 + n * 18));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.func_75146_a(new yeso(entityPlayer.field_71071_by, n, 8 + n * 18, 161));
        }
    }

    @Override
    public cvzo func_82846_b(EntityPlayer entityPlayer, int n) {
        if (!this.access) {
            return null;
        }
        cvzo cvzo2 = null;
        yeso yeso2 = (yeso)this.field_75151_b.get(n);
        if (yeso2 != null && yeso2.func_75216_d()) {
            cvzo cvzo3 = yeso2.func_75211_c();
            cvzo2 = cvzo3._l();
            if (n >= 0 && n < 3 ? !this.func_75135_a(cvzo3, 3, 38, true) : (n >= 3 && n < 30 ? !this.func_75135_a(cvzo3, 30, 38, false) : (n >= 30 && n < 38 ? !this.func_75135_a(cvzo3, 3, 29, false) : !this.func_75135_a(cvzo3, 3, 38, false)))) {
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
}

