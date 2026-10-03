/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.animation;

import com.google.gson.annotations.SerializedName;
import gloomyfolken.mods.stalker.mobs.client.tuning.EditorProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000bJ\u0006\u0010\u0015\u001a\u00020\u0003R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0016"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/animation/AnimationProperty;", "", "fullname", "", "duration", "", "inversed", "", "animationSpeed", "", "animName", "(Ljava/lang/String;IZFLjava/lang/String;)V", "getAnimName", "()Ljava/lang/String;", "getAnimationSpeed", "()F", "getDuration", "()I", "getFullname", "getInversed", "()Z", "getBaseAnimationName", "minecraft"})
public class AnimationProperty {
    @SerializedName(value="name")
    @NotNull
    private final String fullname;
    @SerializedName(value="duration")
    private final int duration;
    @SerializedName(value="inversed")
    @EditorProperty(name="\u041f\u0440\u043e\u0438\u0433\u0440\u044b\u0432\u0430\u0442\u044c \u043d\u0430\u043e\u0431\u043e\u0440\u043e\u0442")
    private final boolean inversed;
    @SerializedName(value="animationSpeed")
    @EditorProperty(name="\u0421\u043a\u043e\u0440\u043e\u0441\u0442\u044c \u0430\u043d\u0438\u043c\u0430\u0446\u0438\u0438", min="0.01", max="10")
    private final float animationSpeed;
    @SerializedName(value="animationName")
    @EditorProperty(name="ID \u0430\u043d\u0438\u043c\u0430\u0446\u0438\u0438")
    @NotNull
    private final String animName;

    @NotNull
    public final String getBaseAnimationName() {
        return StringsKt.substringBeforeLast$default(this.animName, "#", null, 2, null);
    }

    @NotNull
    public final String getFullname() {
        return this.fullname;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final boolean getInversed() {
        return this.inversed;
    }

    public final float getAnimationSpeed() {
        return this.animationSpeed;
    }

    @NotNull
    public final String getAnimName() {
        return this.animName;
    }

    public AnimationProperty(@NotNull String string, int n, boolean bl, float f, @NotNull String string2) {
        Intrinsics.checkParameterIsNotNull(string, "fullname");
        Intrinsics.checkParameterIsNotNull(string2, "animName");
        this.fullname = string;
        this.duration = n;
        this.inversed = bl;
        this.animationSpeed = f;
        this.animName = string2;
    }

    public /* synthetic */ AnimationProperty(String string, int n, boolean bl, float f, String string2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 8) != 0) {
            f = 1.0f;
        }
        this(string, n, bl, f, string2);
    }
}

