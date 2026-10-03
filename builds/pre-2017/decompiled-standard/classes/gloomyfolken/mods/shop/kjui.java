/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.shop;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.player.PlayerEvent;

@Cancelable
public class kjui
extends PlayerEvent {
    private static ListenerList _a;

    public kjui(EntityPlayer entityPlayer) {
        super(entityPlayer);
    }

    public kjui() {
    }

    @Override
    protected void setup() {
        super.setup();
        if (_a != null) {
            return;
        }
        _a = new ListenerList(super.getListenerList());
    }

    @Override
    public ListenerList getListenerList() {
        return _a;
    }
}

