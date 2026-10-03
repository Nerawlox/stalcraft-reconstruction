/*
 * Decompiled with CFR 0.152.
 */
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010(\u001a\u00020\fH\u0004J\u0006\u0010)\u001a\u00020\u0018J\u0006\u0010*\u001a\u00020\u0018J\u0010\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u0006H\u0014J\u0010\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u0013H\u0016J\u0018\u0010/\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u00062\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020\u00182\b\u0010.\u001a\u0004\u0018\u00010\u0013J\u0010\u00103\u001a\u00020\u00182\b\u0010,\u001a\u0004\u0018\u00010\u0006J\u0010\u00104\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u0006H\u0014J\b\u00105\u001a\u00020\u0018H\u0016J\u0010\u00106\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u0006H\u0014J\u001a\u00107\u001a\u00020\u00002\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00180\u0017J\u001a\u00109\u001a\u00020\u00002\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00180\u0017J\u001a\u0010:\u001a\u00020\u00002\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u0017R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@DX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR(\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR&\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u0017X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001c\u0010#\u001a\u0004\u0018\u00010\u0013X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'\u00a8\u0006<"}, d2={"Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffect;", "", "effectId", "", "(Ljava/lang/String;)V", "_manager", "Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffectManager;", "get_manager", "()Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffectManager;", "set_manager", "(Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffectManager;)V", "<set-?>", "", "active", "getActive", "()Z", "setActive", "(Z)V", "defaultSettings", "Lgloomyfolken/mods/effects/client/postprocess/effect/CustomEffectSettings;", "getEffectId", "()Ljava/lang/String;", "effectUpdate", "Lkotlin/Function1;", "", "getEffectUpdate", "()Lkotlin/jvm/functions/Function1;", "setEffectUpdate", "(Lkotlin/jvm/functions/Function1;)V", "executeAction", "getExecuteAction", "setExecuteAction", "finishCondition", "getFinishCondition", "setFinishCondition", "lastEffectorSettings", "getLastEffectorSettings", "()Lgloomyfolken/mods/effects/client/postprocess/effect/CustomEffectSettings;", "setLastEffectorSettings", "(Lgloomyfolken/mods/effects/client/postprocess/effect/CustomEffectSettings;)V", "checkIsValid", "doExecute", "doUpdate", "execute", "manager", "loadCustomEffectSettings", "settings", "renderUpdate", "immediateRenderParams", "Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffectManager$ImmediateRenderParams;", "setCurrentEffectSettings", "setManager", "shouldEffectStop", "stop", "update", "withContinousEffect", "effect", "withExecuteAction", "withFinishCondition", "condition", "minecraft"})
public class bqzs {
    @Nullable
    private jysc _manager;
    @Nullable
    private Function1<? super jysc, Unit> effectUpdate;
    @Nullable
    private Function1<? super jysc, Unit> executeAction;
    @NotNull
    private Function1<? super jysc, Boolean> finishCondition;
    @Nullable
    private oxbc lastEffectorSettings;
    private final oxbc defaultSettings;
    private boolean active;
    @Nullable
    private final String effectId;

    @Nullable
    protected final jysc get_manager() {
        return this._manager;
    }

    protected final void set_manager(@Nullable jysc jysc2) {
        this._manager = jysc2;
    }

    @Nullable
    protected final Function1<jysc, Unit> getEffectUpdate() {
        return this.effectUpdate;
    }

    protected final void setEffectUpdate(@Nullable Function1<? super jysc, Unit> function1) {
        this.effectUpdate = function1;
    }

    @Nullable
    protected final Function1<jysc, Unit> getExecuteAction() {
        return this.executeAction;
    }

    protected final void setExecuteAction(@Nullable Function1<? super jysc, Unit> function1) {
        this.executeAction = function1;
    }

    @NotNull
    protected final Function1<jysc, Boolean> getFinishCondition() {
        return this.finishCondition;
    }

    protected final void setFinishCondition(@NotNull Function1<? super jysc, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "<set-?>");
        this.finishCondition = function1;
    }

    @Nullable
    protected final oxbc getLastEffectorSettings() {
        return this.lastEffectorSettings;
    }

    protected final void setLastEffectorSettings(@Nullable oxbc oxbc2) {
        this.lastEffectorSettings = oxbc2;
    }

    public final boolean getActive() {
        return this.active;
    }

    protected final void setActive(boolean bl) {
        this.active = bl;
    }

    protected final boolean checkIsValid() {
        if (this._manager == null) {
            this.stop();
            return false;
        }
        return true;
    }

    @NotNull
    public final bqzs withExecuteAction(@NotNull Function1<? super jysc, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "effect");
        this.executeAction = function1;
        return this;
    }

    @NotNull
    public final bqzs withContinousEffect(@NotNull Function1<? super jysc, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "effect");
        this.effectUpdate = function1;
        return this;
    }

    @NotNull
    public final bqzs withFinishCondition(@NotNull Function1<? super jysc, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "condition");
        this.finishCondition = function1;
        return this;
    }

    public final void setManager(@Nullable jysc jysc2) {
        this._manager = jysc2;
    }

    public final void doExecute() {
        if (this.checkIsValid()) {
            jysc jysc2 = this._manager;
            if (jysc2 == null) {
                Intrinsics.throwNpe();
            }
            this.execute(jysc2);
        }
    }

    public final void doUpdate() {
        if (this.checkIsValid()) {
            jysc jysc2 = this._manager;
            if (jysc2 == null) {
                Intrinsics.throwNpe();
            }
            if (this.shouldEffectStop(jysc2)) {
                this.stop();
            } else {
                jysc jysc3 = this._manager;
                if (jysc3 == null) {
                    Intrinsics.throwNpe();
                }
                this.update(jysc3);
            }
        }
    }

    public void stop() {
        this.active = false;
    }

    public final void setCurrentEffectSettings(@Nullable oxbc oxbc2) {
        oxbc oxbc3;
        oxbc oxbc4 = oxbc2;
        if (oxbc4 == null) {
            oxbc4 = oxbc3 = this.defaultSettings;
        }
        if (Intrinsics.areEqual(this.lastEffectorSettings, oxbc3) ^ true) {
            this.lastEffectorSettings = oxbc3;
            this.loadCustomEffectSettings(oxbc3);
        }
    }

    public void loadCustomEffectSettings(@NotNull oxbc oxbc2) {
        Intrinsics.checkParameterIsNotNull(oxbc2, "settings");
    }

    public void renderUpdate(@NotNull jysc jysc2, @NotNull jysc.eidj eidj2) {
        Intrinsics.checkParameterIsNotNull(jysc2, "manager");
        Intrinsics.checkParameterIsNotNull(eidj2, "immediateRenderParams");
    }

    protected void execute(@NotNull jysc jysc2) {
        block0: {
            Intrinsics.checkParameterIsNotNull(jysc2, "manager");
            Function1<? super jysc, Unit> function1 = this.executeAction;
            if (function1 == null) break block0;
            function1.invoke(jysc2);
        }
    }

    protected void update(@NotNull jysc jysc2) {
        block0: {
            Intrinsics.checkParameterIsNotNull(jysc2, "manager");
            Function1<? super jysc, Unit> function1 = this.effectUpdate;
            if (function1 == null) break block0;
            function1.invoke(jysc2);
        }
    }

    protected boolean shouldEffectStop(@NotNull jysc jysc2) {
        Intrinsics.checkParameterIsNotNull(jysc2, "manager");
        return this.finishCondition.invoke(jysc2);
    }

    @Nullable
    public final String getEffectId() {
        return this.effectId;
    }

    public bqzs(@Nullable String string) {
        this.effectId = string;
        this.finishCondition = kjui._a;
        this.defaultSettings = new oxbc();
        this.active = true;
    }

    public /* synthetic */ bqzs(String string, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            string = null;
        }
        this(string);
    }

    public bqzs() {
        this(null, 1, null);
    }
}

