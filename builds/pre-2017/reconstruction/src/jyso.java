/*
 * Decompiled with CFR 0.152.
 */
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2={"Lgloomyfolken/mods/effects/client/postprocess/GameEffectHandler;", "Lgloomyfolken/mods/core/client/IGameHandler;", "()V", "onGameJoined", "", "onTickInGame", "playerRespawn", "event", "Lgloomyfolken/mods/core/event/PlayerHandlersInitEvent;", "minecraft"})
public final class jyso
implements nttf {
    @ForgeSubscribe
    public final void _a(@NotNull mquk mquk2) {
        Intrinsics.checkParameterIsNotNull(mquk2, "event");
        if (mquk2._a._a != null && mquk2._a._a.worldObj.isRemote && fmej._b) {
            fmej._b = false;
            jysc._b._c();
        }
    }

    @Override
    public void onGameJoined() {
        jysc._b._c();
    }

    @Override
    public void onTickInGame() {
    }

    public jyso() {
        MinecraftForge.EVENT_BUS.register(this);
    }
}

