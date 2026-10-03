/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.entity;

import java.util.ArrayList;
import java.util.List;
import ru.stalcraft.entity.EntityTurrel;

public class TurrelSenses {
    EntityTurrel entityObj;
    List seenEntities = new ArrayList();
    List unseenEntities = new ArrayList();

    public TurrelSenses(EntityTurrel entity) {
        this.entityObj = entity;
    }

    public void clearSensingCache() {
        this.seenEntities.clear();
        this.unseenEntities.clear();
    }

    public boolean canSee(nn par1Entity) {
        if (this.seenEntities.contains(par1Entity)) {
            return true;
        }
        if (this.unseenEntities.contains(par1Entity)) {
            return false;
        }
        this.entityObj.q.C.a("canSee");
        boolean flag = this.entityObj.canEntityBeSeen(par1Entity);
        this.entityObj.q.C.b();
        if (flag) {
            this.seenEntities.add(par1Entity);
        } else {
            this.unseenEntities.add(par1Entity);
        }
        return flag;
    }
}

