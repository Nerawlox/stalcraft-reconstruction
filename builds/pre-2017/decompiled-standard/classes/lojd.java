/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class lojd
extends PlayerEvent {
    public int _a;
    private static ListenerList _b;

    public lojd(EntityPlayer entityPlayer, int n) {
        super(entityPlayer);
        this._a = n;
    }

    public lojd() {
    }

    @Override
    protected void setup() {
        super.setup();
        if (_b != null) {
            return;
        }
        _b = new ListenerList(super.getListenerList());
    }

    @Override
    public ListenerList getListenerList() {
        return _b;
    }
}

