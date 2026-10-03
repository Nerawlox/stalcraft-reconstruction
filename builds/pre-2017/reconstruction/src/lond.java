/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.weapon.zwat;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.player.PlayerEvent;

@Cancelable
public class lond
extends PlayerEvent {
    public Entity _a;
    public zwat _b;
    public float _c;
    private static ListenerList _d;

    public lond(EntityPlayer entityPlayer, Entity entity, zwat zwat2, float f) {
        super(entityPlayer);
        this._a = entity;
        this._b = zwat2;
        this._c = f;
    }

    public lond() {
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

