/*
 * Decompiled with CFR 0.152.
 */
import kotlin.Metadata;
import net.minecraft.entity.EntityLiving;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2={"Lgloomyfolken/mods/core/spawn/IEntitySpawnProvider;", "T", "Lnet/minecraft/entity/EntityLiving;", "", "instantiateEntity", "world", "Lnet/minecraft/world/World;", "(Lnet/minecraft/world/World;)Lnet/minecraft/entity/EntityLiving;", "minecraft"})
public interface uyqc<T extends EntityLiving> {
    @Nullable
    public T instantiateEntity(@NotNull ozlu var1);
}

