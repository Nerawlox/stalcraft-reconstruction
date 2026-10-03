/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.EntityLiving;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH&J\b\u0010\u0010\u001a\u00020\u0005H&R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2={"Lgloomyfolken/mods/core/spawn/EntitySpawnEntryInfo;", "", "configurationName", "", "weight", "", "(Ljava/lang/String;F)V", "getConfigurationName", "()Ljava/lang/String;", "getWeight", "()F", "setWeight", "(F)V", "getSpawnConfiguration", "Lgloomyfolken/mods/core/spawn/IEntitySpawnProvider;", "Lnet/minecraft/entity/EntityLiving;", "getSpawnWeight", "minecraft"})
public abstract class qman {
    @SerializedName(value="name")
    @NotNull
    private final String configurationName;
    @SerializedName(value="weight")
    private float weight;

    @Nullable
    public abstract uyqc<EntityLiving> getSpawnConfiguration();

    public abstract float getSpawnWeight();

    @NotNull
    public final String getConfigurationName() {
        return this.configurationName;
    }

    public final float getWeight() {
        return this.weight;
    }

    public final void setWeight(float f) {
        this.weight = f;
    }

    public qman(@NotNull String string, float f) {
        Intrinsics.checkParameterIsNotNull(string, "configurationName");
        this.configurationName = string;
        this.weight = f;
    }
}

