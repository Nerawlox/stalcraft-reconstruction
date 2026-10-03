/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.annotations.SerializedName;
import gloomyfolken.mods.core.misc.uxqz;
import gloomyfolken.mods.stalker.mobs.client.tuning.EditorProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0004#$%&B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u001f\u001a\n  *\u0004\u0018\u00010\u00000\u0000J\u0006\u0010!\u001a\u00020\"R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u001c8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006'"}, d2={"Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEmitterSettings;", "", "()V", "color", "Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEmitterSettings$Color;", "getColor", "()Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEmitterSettings$Color;", "common", "Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEmitterSettings$Common;", "getCommon", "()Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEmitterSettings$Common;", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", "motion", "Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEmitterSettings$Motion;", "getMotion", "()Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEmitterSettings$Motion;", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "spawn", "Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEmitterSettings$Spawn;", "getSpawn", "()Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEmitterSettings$Spawn;", "cloned", "kotlin.jvm.PlatformType", "getRenderPassMask", "", "Color", "Common", "Motion", "Spawn", "minecraft"})
public final class ogjh {
    @SerializedName(value="enabled")
    @EditorProperty(name="\u0412\u043a\u043b\u044e\u0447\u0435\u043d")
    private boolean _a = true;
    @SerializedName(value="name")
    @NotNull
    private String _b = "\u041d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u044b\u0439 \u0441\u043b\u043e\u0439";
    @SerializedName(value="spawn")
    @NotNull
    private final ezey _c = new ezey();
    @SerializedName(value="common")
    @NotNull
    private final pidb _d = new pidb();
    @SerializedName(value="motion")
    @NotNull
    private final eidj _e = new eidj();
    @SerializedName(value="color")
    @NotNull
    private final kjui _f = new kjui();

    public final boolean _a() {
        return this._a;
    }

    public final void _a(boolean bl) {
        this._a = bl;
    }

    @NotNull
    public final String _b() {
        return this._b;
    }

    public final void _a(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "<set-?>");
        this._b = string;
    }

    @NotNull
    public final ezey _c() {
        return this._c;
    }

    @NotNull
    public final pidb _d() {
        return this._d;
    }

    @NotNull
    public final eidj _e() {
        return this._e;
    }

    @NotNull
    public final kjui _f() {
        return this._f;
    }

    public final int _g() {
        int n = 0;
        if (this._d._b()) {
            n |= 1;
        }
        if (this._d._a()) {
            n |= 2;
        }
        return n;
    }

    public final ogjh _h() {
        return uxqz._a(uxqz._a(this), ogjh.class);
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u001d\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001e\u0010!\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014R\u001e\u0010$\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u001e\u0010'\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R\u001e\u0010*\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014R\u001e\u0010-\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0012\"\u0004\b/\u0010\u0014R\u001e\u00100\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0012\"\u0004\b2\u0010\u0014R\u001e\u00103\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\f\"\u0004\b5\u0010\u000e\u00a8\u00066"}, d2={"Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEmitterSettings$Spawn;", "", "()V", "boneName", "", "getBoneName", "()Ljava/lang/String;", "setBoneName", "(Ljava/lang/String;)V", "distCheck", "", "getDistCheck", "()Z", "setDistCheck", "(Z)V", "emissionRate", "", "getEmissionRate", "()F", "setEmissionRate", "(F)V", "maxDist", "getMaxDist", "setMaxDist", "maxParticles", "", "getMaxParticles", "()I", "setMaxParticles", "(I)V", "minDist", "getMinDist", "setMinDist", "offsetX", "getOffsetX", "setOffsetX", "offsetXVar", "getOffsetXVar", "setOffsetXVar", "offsetY", "getOffsetY", "setOffsetY", "offsetYVar", "getOffsetYVar", "setOffsetYVar", "offsetZ", "getOffsetZ", "setOffsetZ", "offsetZVar", "getOffsetZVar", "setOffsetZVar", "spawnOnce", "getSpawnOnce", "setSpawnOnce", "minecraft"})
    public static final class ezey {
        @SerializedName(value="spawnOnce")
        @EditorProperty(name="\u0421\u043f\u0430\u0432\u043d \u0435\u0434\u0438\u043d\u043e\u0436\u0434\u044b")
        private boolean _a;
        @SerializedName(value="boneName")
        @EditorProperty(name="\u0418\u043c\u044f \u043a\u043e\u0441\u0442\u0438")
        @NotNull
        private String _b = "";
        @SerializedName(value="maxParticles")
        @EditorProperty(name="\u041c\u0430\u043a\u0441.\u0447\u0430\u0441\u0442\u0438\u0446", min="0", max="200")
        private int _c = 10;
        @SerializedName(value="emissionRate")
        @EditorProperty(name="\u0427\u0430\u0441\u0442\u043e\u0442\u0430 \u0441\u043f\u0430\u0432\u043d\u0430 \u0447\u0430\u0441\u0442\u0438\u0446", min="0", max="10")
        private float _d = 0.5f;
        @SerializedName(value="spawnX")
        @EditorProperty(name="\u0426\u0435\u043d\u0442\u0440 x", min="-5.0", max="5.0")
        private float _e;
        @SerializedName(value="spawnXVar")
        @EditorProperty(name="+- \u0426\u0435\u043d\u0442\u0440 x", min="-5.0", max="5.0")
        private float _f;
        @SerializedName(value="spawnY")
        @EditorProperty(name="\u0426\u0435\u043d\u0442\u0440 y", min="-5.0", max="5.0")
        private float _g;
        @SerializedName(value="spawnYVar")
        @EditorProperty(name="+- \u0426\u0435\u043d\u0442\u0440 y", min="-5.0", max="5.0")
        private float _h;
        @SerializedName(value="spawnZ")
        @EditorProperty(name="\u0426\u0435\u043d\u0442\u0440 z", min="-5.0", max="5.0")
        private float _i;
        @SerializedName(value="spawnZVar")
        @EditorProperty(name="+- \u0426\u0435\u043d\u0442\u0440 z", min="-5.0", max="5.0")
        private float _j;
        @SerializedName(value="distCheck")
        @EditorProperty(name="\u041f\u0440\u043e\u0432\u0435\u0440\u043a\u0430 \u0440\u0430\u0441\u0441\u0442\u043e\u044f\u043d\u0438\u044f")
        private boolean _k;
        @SerializedName(value="minDist")
        @EditorProperty(name="\u041c\u0438\u043d.\u0440\u0430\u0441\u0441\u0442\u043e\u044f\u043d\u0438\u0435", min="0", max="10.0")
        private float _l;
        @SerializedName(value="maxDist")
        @EditorProperty(name="\u041c\u0430\u043a\u0441.\u0440\u0430\u0441\u0441\u0442\u043e\u044f\u043d\u0438\u0435", min="0", max="10.0")
        private float _m = 5.0f;

        public final boolean _a() {
            return this._a;
        }

        public final void _a(boolean bl) {
            this._a = bl;
        }

        @NotNull
        public final String _b() {
            return this._b;
        }

        public final void _a(@NotNull String string) {
            Intrinsics.checkParameterIsNotNull(string, "<set-?>");
            this._b = string;
        }

        public final int _c() {
            return this._c;
        }

        public final void _a(int n) {
            this._c = n;
        }

        public final float _d() {
            return this._d;
        }

        public final void _a(float f) {
            this._d = f;
        }

        public final float _e() {
            return this._e;
        }

        public final void _b(float f) {
            this._e = f;
        }

        public final float _f() {
            return this._f;
        }

        public final void _c(float f) {
            this._f = f;
        }

        public final float _g() {
            return this._g;
        }

        public final void _d(float f) {
            this._g = f;
        }

        public final float _h() {
            return this._h;
        }

        public final void _e(float f) {
            this._h = f;
        }

        public final float _i() {
            return this._i;
        }

        public final void _f(float f) {
            this._i = f;
        }

        public final float _j() {
            return this._j;
        }

        public final void _g(float f) {
            this._j = f;
        }

        public final boolean _k() {
            return this._k;
        }

        public final void _b(boolean bl) {
            this._k = bl;
        }

        public final float _l() {
            return this._l;
        }

        public final void _h(float f) {
            this._l = f;
        }

        public final float _m() {
            return this._m;
        }

        public final void _i(float f) {
            this._m = f;
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b)\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001e\u0010$\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001e\u0010'\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 R\u001e\u0010*\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 R\u001e\u0010-\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001e\"\u0004\b/\u0010 R\u001e\u00100\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001e\"\u0004\b2\u0010 R\u001e\u00103\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001e\"\u0004\b5\u0010 R\u001e\u00106\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001e\"\u0004\b8\u0010 R\u001e\u00109\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001e\"\u0004\b;\u0010 R\u001e\u0010<\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001e\"\u0004\b>\u0010 R\u001e\u0010?\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001e\"\u0004\bA\u0010 R\u001e\u0010B\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001e\"\u0004\bD\u0010 R\u001e\u0010E\u001a\u00020F8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J\u00a8\u0006K"}, d2={"Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEmitterSettings$Common;", "", "()V", "animationSpeed", "", "getAnimationSpeed", "()D", "setAnimationSpeed", "(D)V", "colorPass", "", "getColorPass", "()Z", "setColorPass", "(Z)V", "distortions", "getDistortions", "setDistortions", "frameEnd", "", "getFrameEnd", "()I", "setFrameEnd", "(I)V", "frameStart", "getFrameStart", "setFrameStart", "initialRotation", "", "getInitialRotation", "()F", "setInitialRotation", "(F)V", "particleLife", "getParticleLife", "setParticleLife", "particleLifeVar", "getParticleLifeVar", "setParticleLifeVar", "particleScale", "getParticleScale", "setParticleScale", "particleScaleEnd", "getParticleScaleEnd", "setParticleScaleEnd", "particleScaleEndVar", "getParticleScaleEndVar", "setParticleScaleEndVar", "particleScaleVar", "getParticleScaleVar", "setParticleScaleVar", "particleSimSpeed", "getParticleSimSpeed", "setParticleSimSpeed", "rotationOffset", "getRotationOffset", "setRotationOffset", "rotationSpeed", "getRotationSpeed", "setRotationSpeed", "rotationSpeedEnd", "getRotationSpeedEnd", "setRotationSpeedEnd", "rotationSpeedEndVar", "getRotationSpeedEndVar", "setRotationSpeedEndVar", "rotationSpeedVar", "getRotationSpeedVar", "setRotationSpeedVar", "texturePath", "", "getTexturePath", "()Ljava/lang/String;", "setTexturePath", "(Ljava/lang/String;)V", "minecraft"})
    public static final class pidb {
        @SerializedName(value="distortions")
        @EditorProperty(name="\u0418\u0441\u043a\u0430\u0436\u0435\u043d\u0438\u044f")
        private boolean _a;
        @SerializedName(value="colorPass")
        @EditorProperty(name="\u041e\u0431\u044b\u0447\u043d\u044b\u0439 \u043f\u0440\u043e\u0445\u043e\u0434")
        private boolean _b = true;
        @SerializedName(value="particleSimSpeed")
        @EditorProperty(name="\u0421\u043a\u043e\u0440\u043e\u0441\u0442\u044c \u0441\u0438\u043c\u0443\u043b\u044f\u0446\u0438\u0438", min="0", max="10")
        private float _c = 1.0f;
        @SerializedName(value="particleLife")
        @EditorProperty(name="\u0412\u0440\u0435\u043c\u044f \u0436\u0438\u0437\u043d\u0438 \u0447\u0430\u0441\u0442\u0438\u0446\u044b", min="0", max="20")
        private float _d = 1.0f;
        @SerializedName(value="particleLifeVar")
        @EditorProperty(name="+- \u0412\u0440\u0435\u043c\u044f \u0436\u0438\u0437\u043d\u0438 \u0447\u0430\u0441\u0442\u0438\u0446\u044b", min="0", max="20")
        private float _e = 0.2f;
        @SerializedName(value="particleScale")
        @EditorProperty(name="\u0420\u0430\u0437\u043c\u0435\u0440 \u0447\u0430\u0441\u0442\u0438\u0446\u044b", min="0", max="10.0")
        private float _f = 0.2f;
        @SerializedName(value="particleScaleVar")
        @EditorProperty(name="+- \u0420\u0430\u0437\u043c\u0435\u0440 \u0447\u0430\u0441\u0442\u0438\u0446\u044b", min="0", max="10.0")
        private float _g = 0.05f;
        @SerializedName(value="particleScaleEnd")
        @EditorProperty(name="\u0420\u0430\u0437\u043c\u0435\u0440 \u0447\u0430\u0441\u0442\u0438\u0446\u044b \u0432 \u043a\u043e\u043d\u0446\u0435", min="0", max="10.0")
        private float _h;
        @SerializedName(value="particleScaleEndVar")
        @EditorProperty(name="+- \u0420\u0430\u0437\u043c\u0435\u0440 \u0447\u0430\u0441\u0442\u0438\u0446\u044b \u0432 \u043a\u043e\u043d\u0446\u0435", min="0", max="10.0")
        private float _i;
        @SerializedName(value="texturePath")
        @NotNull
        private String _j = "assets/stalker/textures/particles/smoke/smoke1.png";
        @SerializedName(value="initialRotation")
        @EditorProperty(name="\u041d\u0430\u0447\u0430\u043b\u044c\u043d\u044b\u0439 \u043f\u043e\u0432\u043e\u0440\u043e\u0442", min="-180.0", max="180.0")
        private float _k;
        @SerializedName(value="rotationOffset")
        @EditorProperty(name="+- \u041d\u0430\u0447\u0430\u043b\u044c\u043d\u044b\u0439 \u043f\u043e\u0432\u043e\u0440\u043e\u0442", min="-180.0", max="180.0")
        private float _l;
        @SerializedName(value="rotationSpeed")
        @EditorProperty(name="\u0421\u043a\u043e\u0440\u043e\u0441\u0442\u044c \u043f\u043e\u0432\u043e\u0440\u043e\u0442\u0430", min="-180.0", max="180.0")
        private float _m;
        @SerializedName(value="rotationSpeedVar")
        @EditorProperty(name="+- \u0421\u043a\u043e\u0440\u043e\u0441\u0442\u044c \u043f\u043e\u0432\u043e\u0440\u043e\u0442\u0430", min="-180.0", max="180.0")
        private float _n;
        @SerializedName(value="rotationSpeedEnd")
        @EditorProperty(name="\u0421\u043a\u043e\u0440\u043e\u0441\u0442\u044c \u043f\u043e\u0432\u043e\u0440\u043e\u0442\u0430 \u0432 \u043a\u043e\u043d\u0446\u0435", min="-180.0", max="180.0")
        private float _o;
        @SerializedName(value="rotationSpeedEndVar")
        @EditorProperty(name="+- \u0421\u043a\u043e\u0440\u043e\u0441\u0442\u044c \u043f\u043e\u0432\u043e\u0440\u043e\u0442\u0430 \u0432 \u043a\u043e\u043d\u0446\u0435", min="-180.0", max="180.0")
        private float _p;
        @SerializedName(value="frameStart")
        @EditorProperty(name="\u041f\u0435\u0440\u0432\u044b\u0439 \u043a\u0430\u0434\u0440", min="0", max="63")
        private int _q;
        @SerializedName(value="frameEnd")
        @EditorProperty(name="\u041f\u043e\u0441\u043b\u0435\u0434\u043d\u0438\u0439 \u043a\u0430\u0434\u0440", min="0", max="63")
        private int _r;
        @SerializedName(value="animationSpeed")
        @EditorProperty(name="\u0421\u043a\u043e\u0440\u043e\u0441\u0442\u044c \u0430\u043d\u0438\u043c\u0430\u0446\u0438\u0438", min="0.0", max="10.0")
        private double _s = 1.0;

        public final boolean _a() {
            return this._a;
        }

        public final void _a(boolean bl) {
            this._a = bl;
        }

        public final boolean _b() {
            return this._b;
        }

        public final void _b(boolean bl) {
            this._b = bl;
        }

        public final float _c() {
            return this._c;
        }

        public final void _a(float f) {
            this._c = f;
        }

        public final float _d() {
            return this._d;
        }

        public final void _b(float f) {
            this._d = f;
        }

        public final float _e() {
            return this._e;
        }

        public final void _c(float f) {
            this._e = f;
        }

        public final float _f() {
            return this._f;
        }

        public final void _d(float f) {
            this._f = f;
        }

        public final float _g() {
            return this._g;
        }

        public final void _e(float f) {
            this._g = f;
        }

        public final float _h() {
            return this._h;
        }

        public final void _f(float f) {
            this._h = f;
        }

        public final float _i() {
            return this._i;
        }

        public final void _g(float f) {
            this._i = f;
        }

        @NotNull
        public final String _j() {
            return this._j;
        }

        public final void _a(@NotNull String string) {
            Intrinsics.checkParameterIsNotNull(string, "<set-?>");
            this._j = string;
        }

        public final float _k() {
            return this._k;
        }

        public final void _h(float f) {
            this._k = f;
        }

        public final float _l() {
            return this._l;
        }

        public final void _i(float f) {
            this._l = f;
        }

        public final float _m() {
            return this._m;
        }

        public final void _j(float f) {
            this._m = f;
        }

        public final float _n() {
            return this._n;
        }

        public final void _k(float f) {
            this._n = f;
        }

        public final float _o() {
            return this._o;
        }

        public final void _l(float f) {
            this._o = f;
        }

        public final float _p() {
            return this._p;
        }

        public final void _m(float f) {
            this._p = f;
        }

        public final int _q() {
            return this._q;
        }

        public final void _a(int n) {
            this._q = n;
        }

        public final int _r() {
            return this._r;
        }

        public final void _b(int n) {
            this._r = n;
        }

        public final double _s() {
            return this._s;
        }

        public final void _a(double d) {
            this._s = d;
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001e\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001e\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001e\u0010\u001e\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001e\u0010!\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001e\u0010$\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u001e\u0010'\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u001e\u0010*\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR\u001e\u0010-\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000eR\u001e\u00100\u001a\u0002018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105\u00a8\u00066"}, d2={"Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEmitterSettings$Motion;", "", "()V", "dampening", "", "getDampening", "()F", "setDampening", "(F)V", "particleGravityX", "", "getParticleGravityX", "()D", "setParticleGravityX", "(D)V", "particleGravityXEnd", "getParticleGravityXEnd", "setParticleGravityXEnd", "particleGravityY", "getParticleGravityY", "setParticleGravityY", "particleGravityYEnd", "getParticleGravityYEnd", "setParticleGravityYEnd", "particleGravityZ", "getParticleGravityZ", "setParticleGravityZ", "particleGravityZEnd", "getParticleGravityZEnd", "setParticleGravityZEnd", "particleSpeedX", "getParticleSpeedX", "setParticleSpeedX", "particleSpeedXVar", "getParticleSpeedXVar", "setParticleSpeedXVar", "particleSpeedY", "getParticleSpeedY", "setParticleSpeedY", "particleSpeedYVar", "getParticleSpeedYVar", "setParticleSpeedYVar", "particleSpeedZ", "getParticleSpeedZ", "setParticleSpeedZ", "particleSpeedZVar", "getParticleSpeedZVar", "setParticleSpeedZVar", "posBoundToBone", "", "getPosBoundToBone", "()Z", "setPosBoundToBone", "(Z)V", "minecraft"})
    public static final class eidj {
        @SerializedName(value="posBoundToBone")
        @EditorProperty(name="\u041f\u0440\u0438\u0432\u044f\u0437\u044f\u0442\u044c \u043a \u043a\u043e\u0441\u0442\u0438")
        private boolean _a;
        @SerializedName(value="dampening")
        @EditorProperty(name="\u0421\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u0435 \u0441\u043a\u043e\u0440\u043e\u0441\u0442\u0438", min="0", max="2")
        private float _b = 1.0f;
        @SerializedName(value="particleSpeedX")
        @EditorProperty(name="\u041d\u0430\u0447.\u0441\u043a\u043e\u0440\u043e\u0441\u0442\u044c \u0425", min="-0.2", max="0.2")
        private double _c;
        @SerializedName(value="particleSpeedXVar")
        @EditorProperty(name="+- \u041d\u0430\u0447.\u0441\u043a\u043e\u0440\u043e\u0441\u0442\u044c \u0425", min="-0.2", max="0.2")
        private double _d;
        @SerializedName(value="particleSpeedY")
        @EditorProperty(name="\u041d\u0430\u0447.\u0441\u043a\u043e\u0440\u043e\u0441\u0442\u044c Y", min="-0.2", max="0.2")
        private double _e = 0.05;
        @SerializedName(value="particleSpeedYVar")
        @EditorProperty(name="+- \u041d\u0430\u0447.\u0441\u043a\u043e\u0440\u043e\u0441\u0442\u044c Y", min="-0.2", max="0.2")
        private double _f;
        @SerializedName(value="particleSpeedZ")
        @EditorProperty(name="\u041d\u0430\u0447.\u0441\u043a\u043e\u0440\u043e\u0441\u0442\u044c Z", min="-0.2", max="0.2")
        private double _g;
        @SerializedName(value="particleSpeedZVar")
        @EditorProperty(name="+- \u041d\u0430\u0447.\u0441\u043a\u043e\u0440\u043e\u0441\u0442\u044c Z", min="-0.2", max="0.2")
        private double _h;
        @SerializedName(value="particleGravityX")
        @EditorProperty(name="\u0423\u0441\u043a\u043e\u0440\u0435\u043d\u0438\u0435 \u0425", min="-0.2", max="0.2")
        private double _i;
        @SerializedName(value="particleGravityY")
        @EditorProperty(name="\u0423\u0441\u043a\u043e\u0440\u0435\u043d\u0438\u0435 Y", min="-0.2", max="0.2")
        private double _j;
        @SerializedName(value="particleGravityZ")
        @EditorProperty(name="\u0423\u0441\u043a\u043e\u0440\u0435\u043d\u0438\u0435 Z", min="-0.2", max="0.2")
        private double _k;
        @SerializedName(value="particleGravityXEnd")
        @EditorProperty(name="\u0423\u0441\u043a\u043e\u0440\u0435\u043d\u0438\u0435 \u0425 \u0432 \u043a\u043e\u043d\u0446\u0435", min="-0.2", max="0.2")
        private double _l;
        @SerializedName(value="particleGravityYEnd")
        @EditorProperty(name="\u0423\u0441\u043a\u043e\u0440\u0435\u043d\u0438\u0435 Y \u0432 \u043a\u043e\u043d\u0446\u0435", min="-0.2", max="0.2")
        private double _m;
        @SerializedName(value="particleGravityZEnd")
        @EditorProperty(name="\u0423\u0441\u043a\u043e\u0440\u0435\u043d\u0438\u0435 Z \u0432 \u043a\u043e\u043d\u0446\u0435", min="-0.2", max="0.2")
        private double _n;

        public final boolean _a() {
            return this._a;
        }

        public final void _a(boolean bl) {
            this._a = bl;
        }

        public final float _b() {
            return this._b;
        }

        public final void _a(float f) {
            this._b = f;
        }

        public final double _c() {
            return this._c;
        }

        public final void _a(double d) {
            this._c = d;
        }

        public final double _d() {
            return this._d;
        }

        public final void _b(double d) {
            this._d = d;
        }

        public final double _e() {
            return this._e;
        }

        public final void _c(double d) {
            this._e = d;
        }

        public final double _f() {
            return this._f;
        }

        public final void _d(double d) {
            this._f = d;
        }

        public final double _g() {
            return this._g;
        }

        public final void _e(double d) {
            this._g = d;
        }

        public final double _h() {
            return this._h;
        }

        public final void _f(double d) {
            this._h = d;
        }

        public final double _i() {
            return this._i;
        }

        public final void _g(double d) {
            this._i = d;
        }

        public final double _j() {
            return this._j;
        }

        public final void _h(double d) {
            this._j = d;
        }

        public final double _k() {
            return this._k;
        }

        public final void _i(double d) {
            this._k = d;
        }

        public final double _l() {
            return this._l;
        }

        public final void _j(double d) {
            this._l = d;
        }

        public final double _m() {
            return this._m;
        }

        public final void _k(double d) {
            this._m = d;
        }

        public final double _n() {
            return this._n;
        }

        public final void _l(double d) {
            this._n = d;
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0006\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001e\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\b\u00a8\u0006$"}, d2={"Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEmitterSettings$Color;", "", "()V", "alpha", "", "getAlpha", "()I", "setAlpha", "(I)V", "alphaEnd", "getAlphaEnd", "setAlphaEnd", "b", "getB", "setB", "bEnd", "getBEnd", "setBEnd", "burn", "", "getBurn", "()D", "setBurn", "(D)V", "g", "getG", "setG", "gEnd", "getGEnd", "setGEnd", "r", "getR", "setR", "rEnd", "getREnd", "setREnd", "minecraft"})
    public static final class kjui {
        @SerializedName(value="burn")
        @EditorProperty(name="\u0421\u0432\u0435\u0442\u0438\u043c\u043e\u0441\u0442\u044c", min="0", max="1.0")
        private double _a;
        @SerializedName(value="alpha")
        @EditorProperty(name="\u041f\u0440\u043e\u0437\u0440\u0430\u0447\u043d\u043e\u0441\u0442\u044c", min="0", max="255.0")
        private int _b = 255;
        @SerializedName(value="r")
        @EditorProperty(name="R", min="0", max="255.0")
        private int _c = 255;
        @SerializedName(value="g")
        @EditorProperty(name="G", min="0", max="255.0")
        private int _d = 255;
        @SerializedName(value="b")
        @EditorProperty(name="B", min="0", max="255.0")
        private int _e = 255;
        @SerializedName(value="alphaEnd")
        @EditorProperty(name="\u041f\u0440\u043e\u0437\u0440\u0430\u0447\u043d\u043e\u0441\u0442\u044c \u0432 \u043a\u043e\u043d\u0446\u0435", min="0", max="255.0")
        private int _f;
        @SerializedName(value="rEnd")
        @EditorProperty(name="R \u0432 \u043a\u043e\u043d\u0446\u0435", min="0", max="255.0")
        private int _g = 255;
        @SerializedName(value="gEnd")
        @EditorProperty(name="G \u0432 \u043a\u043e\u043d\u0446\u0435", min="0", max="255.0")
        private int _h = 255;
        @SerializedName(value="bEnd")
        @EditorProperty(name="B \u0432 \u043a\u043e\u043d\u0446\u0435", min="0", max="255.0")
        private int _i = 255;

        public final double _a() {
            return this._a;
        }

        public final void _a(double d) {
            this._a = d;
        }

        public final int _b() {
            return this._b;
        }

        public final void _a(int n) {
            this._b = n;
        }

        public final int _c() {
            return this._c;
        }

        public final void _b(int n) {
            this._c = n;
        }

        public final int _d() {
            return this._d;
        }

        public final void _c(int n) {
            this._d = n;
        }

        public final int _e() {
            return this._e;
        }

        public final void _d(int n) {
            this._e = n;
        }

        public final int _f() {
            return this._f;
        }

        public final void _e(int n) {
            this._f = n;
        }

        public final int _g() {
            return this._g;
        }

        public final void _f(int n) {
            this._g = n;
        }

        public final int _h() {
            return this._h;
        }

        public final void _g(int n) {
            this._h = n;
        }

        public final int _i() {
            return this._i;
        }

        public final void _h(int n) {
            this._i = n;
        }
    }
}

