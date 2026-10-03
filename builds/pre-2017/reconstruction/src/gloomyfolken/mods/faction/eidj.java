/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.faction;

import gloomyfolken.bundle.common.core.tupg;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class eidj
extends PlayerEvent {
    public final tupg _a;
    public final tupg _b;
    private static ListenerList _c;

    public eidj(EntityPlayer entityPlayer, tupg tupg2, tupg tupg3) {
        super(entityPlayer);
        this._a = tupg2;
        this._b = tupg3;
    }

    public eidj() {
    }

    @Override
    protected void setup() {
        super.setup();
        if (_c != null) {
            return;
        }
        _c = new ListenerList(super.getListenerList());
    }

    @Override
    public ListenerList getListenerList() {
        return _c;
    }
}

