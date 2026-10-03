/*
 * Decompiled with CFR 0.152.
 */
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.util.amxi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2={"Lgloomyfolken/mods/core/client/render/ItemEffectorSettings;", "", "()V", "Companion", "minecraft"})
public final class iefo {
    @NotNull
    private static final amxi _b;
    public static final kjui _a;

    static {
        _a = new kjui(null);
        _b = new amxi();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2={"Lgloomyfolken/mods/core/client/render/ItemEffectorSettings$Companion;", "", "()V", "itemSettings", "Lnet/minecraft/util/IntHashMap;", "getItemSettings", "()Lnet/minecraft/util/IntHashMap;", "getSettings", "Lgloomyfolken/mods/effects/client/postprocess/effect/CustomEffectSettings;", "id", "", "minecraft"})
    public static final class kjui {
        @NotNull
        public final amxi _a() {
            return _b;
        }

        @Nullable
        public final oxbc _a(int n) {
            Object object = this._a()._b(n);
            if (!(object instanceof oxbc)) {
                object = null;
            }
            return (oxbc)object;
        }

        private kjui() {
        }

        public /* synthetic */ kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

