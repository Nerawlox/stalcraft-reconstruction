/*
 * Decompiled with CFR 0.152.
 */
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Lgloomyfolken/mods/effects/client/postprocess/effect/EffectManagerInitEvent;", "Lnet/minecraftforge/event/Event;", "manager", "Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffectManager;", "(Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffectManager;)V", "getManager", "()Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffectManager;", "minecraft"})
public final class dxaz
extends Event {
    @NotNull
    private final jysc _a;
    private static ListenerList _b;

    @NotNull
    public final jysc _a() {
        return this._a;
    }

    public dxaz(@NotNull jysc jysc2) {
        Intrinsics.checkParameterIsNotNull(jysc2, "manager");
        this._a = jysc2;
    }

    public dxaz() {
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

