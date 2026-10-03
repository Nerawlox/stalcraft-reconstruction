/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0014J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0014J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0005R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lgloomyfolken/mods/stalker/misc/sickness/SicknessConfig;", "Lgloomyfolken/mods/core/configuration/ConfigReader;", "()V", "configMap", "Ljava/util/HashMap;", "", "Lgloomyfolken/mods/core/configuration/ConfigPart;", "Lkotlin/collections/HashMap;", "getConfig", "name", "getFiles", "", "Lnet/minecraft/util/ResourceLocation;", "readPart", "", "part", "readProps", "Lgloomyfolken/mods/stalker/misc/sickness/Sickness$Props;", "minecraft"})
public final class rpws
extends ccsw {
    private static final HashMap<String, anof> _b;
    public static final rpws _a;

    @NotNull
    public final anof _b(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        anof anof2 = _b.get(string);
        if (anof2 == null) {
            throw (Throwable)new IllegalArgumentException("Sickness config " + string + " not registered");
        }
        return anof2;
    }

    @NotNull
    public final ejqm.kjui _c(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        anof anof2 = this._b(string);
        Intrinsics.checkExpressionValueIsNotNull(anof2, "getConfig(name)");
        return this._b(anof2);
    }

    @NotNull
    public final ejqm.kjui _b(@NotNull anof anof2) {
        Intrinsics.checkParameterIsNotNull(anof2, "part");
        String string = anof2._a;
        Intrinsics.checkExpressionValueIsNotNull(string, "part.header");
        float[] fArray = anof2._m("level_bounds");
        Intrinsics.checkExpressionValueIsNotNull(fArray, "part.getFloatArray(\"level_bounds\")");
        float[] fArray2 = anof2._m("level_damage");
        Intrinsics.checkExpressionValueIsNotNull(fArray2, "part.getFloatArray(\"level_damage\")");
        return new ejqm.kjui(string, fArray, fArray2, anof2._j("decrease_speed"), anof2._j("decrease_factor"), anof2._a("max_power", 100000.0f), anof2._a("damage_cooldown", 20), anof2._g("reset_ticks"));
    }

    @Override
    protected void _a(@NotNull anof anof2) {
        Intrinsics.checkParameterIsNotNull(anof2, "part");
        Map map = _b;
        String string = anof2._a;
        Intrinsics.checkExpressionValueIsNotNull(string, "part.header");
        String string2 = string;
        anof anof3 = anof2;
        map.put(string2, anof3);
    }

    @Override
    @NotNull
    protected List<ResourceLocation> _a() {
        return CollectionsKt.listOf(new ResourceLocation("stalker", "sickness.txt"));
    }

    private rpws() {
        _a = this;
        _b = new HashMap();
        this._c();
    }

    static {
        new rpws();
    }
}

