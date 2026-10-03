/*
 * Decompiled with CFR 0.152.
 */
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B)\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\tJ\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u0004H\u0086\u0002J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2={"Lgloomyfolken/bundle/common/config/LocationConfig;", "", "locations", "", "", "Lgloomyfolken/bundle/common/config/LocationConfigEntry;", "defaultSavepoint", "Lgloomyfolken/bundle/common/utils/position/GlobalPosition;", "fallbackSavepoint", "(Ljava/util/Map;Lgloomyfolken/bundle/common/utils/position/GlobalPosition;Lgloomyfolken/bundle/common/utils/position/GlobalPosition;)V", "getDefaultSavepoint", "()Lgloomyfolken/bundle/common/utils/position/GlobalPosition;", "getFallbackSavepoint", "getLocations", "()Ljava/util/Map;", "get", "name", "getLocalizedName", "minecraft"})
public final class dwbf {
    @NotNull
    private final Map<String, sajh> _a;
    @NotNull
    private final iuyn _b;
    @NotNull
    private final iuyn _c;

    @Nullable
    public final sajh _a(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        return this._a.get(string);
    }

    @NotNull
    public final String _b(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        Object object = this._a.get(string);
        if (object == null || (object = ((sajh)object)._d()) == null) {
            object = "\u041d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u043e";
        }
        return object;
    }

    @NotNull
    public final Map<String, sajh> _a() {
        return this._a;
    }

    @NotNull
    public final iuyn _b() {
        return this._b;
    }

    @NotNull
    public final iuyn _c() {
        return this._c;
    }

    public dwbf(@NotNull Map<String, sajh> map, @NotNull iuyn iuyn2, @NotNull iuyn iuyn3) {
        Intrinsics.checkParameterIsNotNull(map, "locations");
        Intrinsics.checkParameterIsNotNull(iuyn2, "defaultSavepoint");
        Intrinsics.checkParameterIsNotNull(iuyn3, "fallbackSavepoint");
        this._a = map;
        this._b = iuyn2;
        this._c = iuyn3;
    }
}

