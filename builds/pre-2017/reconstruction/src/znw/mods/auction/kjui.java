/*
 * Decompiled with CFR 0.152.
 */
package znw.mods.auction;

import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class kjui
extends PlayerEvent {
    public final zwat _a;
    public long _b;
    public final List<ItemStack> _c;
    private static ListenerList _d;

    public kjui(EntityPlayer entityPlayer, zwat zwat2, long l, List<ItemStack> list) {
        super(entityPlayer);
        this._a = zwat2;
        this._b = l;
        this._c = list;
    }

    public kjui() {
    }

    @Override
    protected void setup() {
        super.setup();
        if (_d != null) {
            return;
        }
        _d = new ListenerList(super.getListenerList());
    }

    @Override
    public ListenerList getListenerList() {
        return _d;
    }
}

