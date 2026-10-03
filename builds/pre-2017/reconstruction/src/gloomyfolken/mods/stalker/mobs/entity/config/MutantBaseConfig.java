/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.config;

import com.google.gson.annotations.SerializedName;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.animation.AnimationProperty;
import gloomyfolken.mods.stalker.mobs.entity.config.AttackConfig;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantBaseConfig;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantRelation;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantSoundType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 Z2\u00020\u0001:\u0001ZB\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u0004H\u0002J\b\u0010T\u001a\u00020PH\u0002J\b\u0010U\u001a\u00020PH\u0002J\u0006\u0010V\u001a\u00020PJ\u0006\u0010W\u001a\u00020\u0000J\u000e\u0010X\u001a\u00020P2\u0006\u0010Y\u001a\u00020\u0004R,\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\t8\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R,\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b`\t8\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R,\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\t8\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000e8\u0006@BX\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001e\u0010#\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\u001e\u0010&\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010\u001fR\u001e\u0010)\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR\u001e\u0010,\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010\u001fR\u001e\u0010/\u001a\u0002008\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u00105\u001a\u0002008\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00102\"\u0004\b7\u00104R\u0012\u00108\u001a\u00020\u001b8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u00109\u001a\u0002008\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u00102\"\u0004\b;\u00104R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010=R:\u0010>\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020?0\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020?`\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001e\u0010D\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u001d\"\u0004\bF\u0010\u001fR\u001e\u0010G\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u001d\"\u0004\bI\u0010\u001fR\u001e\u0010J\u001a\u0002008\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u00102\"\u0004\bL\u00104R\u001d\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00158F\u00a2\u0006\u0006\u001a\u0004\bN\u0010\u0017\u00a8\u0006["}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/MutantBaseConfig;", "", "()V", "mobName", "", "(Ljava/lang/String;)V", "_animations", "Ljava/util/HashMap;", "Lgloomyfolken/mods/stalker/mobs/entity/animation/AnimationProperty;", "Lkotlin/collections/HashMap;", "_attacks", "Lgloomyfolken/mods/stalker/mobs/entity/config/AttackConfig;", "_sounds", "<set-?>", "", "animationList", "getAnimationList", "()Ljava/util/List;", "setAnimationList", "(Ljava/util/List;)V", "animations", "", "getAnimations", "()Ljava/util/Map;", "attacks", "getAttacks", "bodyEater", "", "getBodyEater", "()Z", "setBodyEater", "(Z)V", "canRest", "getCanRest", "setCanRest", "canRunAttack", "getCanRunAttack", "setCanRunAttack", "canSuddenTurn", "getCanSuddenTurn", "setCanSuddenTurn", "canWalk", "getCanWalk", "setCanWalk", "hasMovementTurnAnimations", "getHasMovementTurnAnimations", "setHasMovementTurnAnimations", "idleSoundDelayMax", "", "getIdleSoundDelayMax", "()I", "setIdleSoundDelayMax", "(I)V", "idleSoundDelayMin", "getIdleSoundDelayMin", "setIdleSoundDelayMin", "initialized", "maxSoundSources", "getMaxSoundSources", "setMaxSoundSources", "getMobName", "()Ljava/lang/String;", "mutantRelations", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantRelation;", "getMutantRelations", "()Ljava/util/HashMap;", "setMutantRelations", "(Ljava/util/HashMap;)V", "playIdleSound", "getPlayIdleSound", "setPlayIdleSound", "playStepSounds", "getPlayStepSounds", "setPlayStepSounds", "restStages", "getRestStages", "setRestStages", "sounds", "getSounds", "addDefaultSound", "", "type", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantSoundType;", "name", "addDefaultSounds", "checkInitialized", "create", "createWithTestValues", "setRelationsFromString", "string", "Companion", "minecraft"})
public final class MutantBaseConfig {
    @SerializedName(value="_sounds")
    private final HashMap<String, String> _sounds;
    @SerializedName(value="_animations")
    private final HashMap<String, AnimationProperty> _animations;
    @SerializedName(value="_attacks")
    private final HashMap<String, AttackConfig> _attacks;
    private transient boolean initialized;
    @NotNull
    private transient List<? extends AnimationProperty> animationList;
    @SerializedName(value="mutantRelations")
    @NotNull
    private HashMap<String, MutantRelation> mutantRelations;
    @SerializedName(value="canWalk")
    private boolean canWalk;
    @SerializedName(value="canRest")
    private boolean canRest;
    @SerializedName(value="canSuddenTurn")
    private boolean canSuddenTurn;
    @SerializedName(value="canRunAttack")
    private boolean canRunAttack;
    @SerializedName(value="hasMovementTurnAnimations")
    private boolean hasMovementTurnAnimations;
    @SerializedName(value="bodyEater")
    private boolean bodyEater;
    @SerializedName(value="playIdleSound")
    private boolean playIdleSound;
    @SerializedName(value="idleSoundDelayMin")
    private int idleSoundDelayMin;
    @SerializedName(value="idleSoundDelayMax")
    private int idleSoundDelayMax;
    @SerializedName(value="maxSoundSources")
    private int maxSoundSources;
    @SerializedName(value="restStages")
    private int restStages;
    @SerializedName(value="playStepSounds")
    private boolean playStepSounds;
    @SerializedName(value="mobName")
    @NotNull
    private final String mobName;
    @NotNull
    private static final HashMap<Class<? extends EntityMutant>, MutantBaseConfig> mobConfigurations;
    public static final Companion Companion;

    @NotNull
    public final Map<String, AnimationProperty> getAnimations() {
        return this._animations;
    }

    @NotNull
    public final Map<String, AttackConfig> getAttacks() {
        return this._attacks;
    }

    @NotNull
    public final Map<String, String> getSounds() {
        return this._sounds;
    }

    @NotNull
    public final List<AnimationProperty> getAnimationList() {
        List<AnimationProperty> list = this.animationList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationList");
        }
        return list;
    }

    private final void setAnimationList(List<? extends AnimationProperty> list) {
        this.animationList = list;
    }

    @NotNull
    public final MutantBaseConfig createWithTestValues() {
        this._attacks.put("sample", new AttackConfig());
        this.create();
        return this;
    }

    @NotNull
    public final HashMap<String, MutantRelation> getMutantRelations() {
        return this.mutantRelations;
    }

    public final void setMutantRelations(@NotNull HashMap<String, MutantRelation> hashMap) {
        Intrinsics.checkParameterIsNotNull(hashMap, "<set-?>");
        this.mutantRelations = hashMap;
    }

    public final boolean getCanWalk() {
        return this.canWalk;
    }

    public final void setCanWalk(boolean bl) {
        this.canWalk = bl;
    }

    public final boolean getCanRest() {
        return this.canRest;
    }

    public final void setCanRest(boolean bl) {
        this.canRest = bl;
    }

    public final boolean getCanSuddenTurn() {
        return this.canSuddenTurn;
    }

    public final void setCanSuddenTurn(boolean bl) {
        this.canSuddenTurn = bl;
    }

    public final boolean getCanRunAttack() {
        return this.canRunAttack;
    }

    public final void setCanRunAttack(boolean bl) {
        this.canRunAttack = bl;
    }

    public final boolean getHasMovementTurnAnimations() {
        return this.hasMovementTurnAnimations;
    }

    public final void setHasMovementTurnAnimations(boolean bl) {
        this.hasMovementTurnAnimations = bl;
    }

    public final boolean getBodyEater() {
        return this.bodyEater;
    }

    public final void setBodyEater(boolean bl) {
        this.bodyEater = bl;
    }

    public final boolean getPlayIdleSound() {
        return this.playIdleSound;
    }

    public final void setPlayIdleSound(boolean bl) {
        this.playIdleSound = bl;
    }

    public final int getIdleSoundDelayMin() {
        return this.idleSoundDelayMin;
    }

    public final void setIdleSoundDelayMin(int n) {
        this.idleSoundDelayMin = n;
    }

    public final int getIdleSoundDelayMax() {
        return this.idleSoundDelayMax;
    }

    public final void setIdleSoundDelayMax(int n) {
        this.idleSoundDelayMax = n;
    }

    public final int getMaxSoundSources() {
        return this.maxSoundSources;
    }

    public final void setMaxSoundSources(int n) {
        this.maxSoundSources = n;
    }

    public final int getRestStages() {
        return this.restStages;
    }

    public final void setRestStages(int n) {
        this.restStages = n;
    }

    public final boolean getPlayStepSounds() {
        return this.playStepSounds;
    }

    public final void setPlayStepSounds(boolean bl) {
        this.playStepSounds = bl;
    }

    private final void checkInitialized() {
        if (!this.initialized) {
            throw (Throwable)new IllegalStateException("The base config wasn't initialized!");
        }
    }

    private final void addDefaultSounds() {
        MutantSoundType[] mutantSoundTypeArray = MutantSoundType.values();
        for (int i = 0; i < mutantSoundTypeArray.length; ++i) {
            String string;
            MutantSoundType mutantSoundType = mutantSoundTypeArray[i];
            String string2 = mutantSoundType.name();
            StringBuilder stringBuilder = new StringBuilder().append("stalkermobs:").append(this.mobName).append('.');
            MutantSoundType mutantSoundType2 = mutantSoundType;
            MutantBaseConfig mutantBaseConfig = this;
            String string3 = string2;
            if (string3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            Intrinsics.checkExpressionValueIsNotNull(string3.toLowerCase(), "(this as java.lang.String).toLowerCase()");
            mutantBaseConfig.addDefaultSound(mutantSoundType2, stringBuilder.append(string).toString());
        }
    }

    private final void addDefaultSound(MutantSoundType mutantSoundType, String string) {
        String string2 = mutantSoundType.name();
        HashMap<String, String> hashMap = this._sounds;
        String string3 = string2;
        if (string3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string4 = string3.toLowerCase();
        Intrinsics.checkExpressionValueIsNotNull(string4, "(this as java.lang.String).toLowerCase()");
        String string5 = string4;
        hashMap.putIfAbsent(string5, string);
    }

    public final void setRelationsFromString(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "string");
        Regex regex = new Regex("([a-zA-Z0-9_]+):([a-zA-Z_]+)");
        String string2 = string;
        Regex regex2 = regex;
        String string3 = ((Object)StringsKt.trim((CharSequence)string2)).toString();
        Map map = MapsKt.toMap(SequencesKt.map(Regex.findAll$default(regex2, string3, 0, 2, null), setRelationsFromString.relations.1.INSTANCE));
        this.mutantRelations.clear();
        this.mutantRelations.putAll(map);
    }

    public final void create() {
        this._attacks.put("sample", new AttackConfig());
        this.initialized = true;
        this.addDefaultSounds();
        Collection<AnimationProperty> collection = this._animations.values();
        MutantBaseConfig mutantBaseConfig = this;
        Collection<AnimationProperty> collection2 = collection;
        if (collection2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
        }
        Collection<AnimationProperty> collection3 = collection2;
        AnimationProperty[] animationPropertyArray = collection3.toArray(new AnimationProperty[collection3.size()]);
        if (animationPropertyArray == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        AnimationProperty[] animationPropertyArray2 = animationPropertyArray;
        mutantBaseConfig.animationList = CollectionsKt.listOf(Arrays.copyOf(animationPropertyArray2, animationPropertyArray2.length));
    }

    @NotNull
    public final String getMobName() {
        return this.mobName;
    }

    public MutantBaseConfig(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "mobName");
        this.mobName = string;
        MutantBaseConfig mutantBaseConfig = this;
        HashMap hashMap = new HashMap();
        mutantBaseConfig._sounds = hashMap;
        mutantBaseConfig = this;
        hashMap = new HashMap();
        mutantBaseConfig._animations = hashMap;
        mutantBaseConfig = this;
        hashMap = new HashMap();
        mutantBaseConfig._attacks = hashMap;
        mutantBaseConfig = this;
        hashMap = new HashMap();
        mutantBaseConfig.mutantRelations = hashMap;
        this.canWalk = true;
        this.canRest = true;
        this.canSuddenTurn = true;
        this.canRunAttack = true;
        this.hasMovementTurnAnimations = true;
        this.playIdleSound = true;
        this.idleSoundDelayMin = 200;
        this.idleSoundDelayMax = 400;
        this.maxSoundSources = 3;
        this.restStages = 1;
        this.playStepSounds = true;
    }

    public MutantBaseConfig() {
        this("");
    }

    static {
        Companion = new Companion(null);
        mobConfigurations = new HashMap();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R=\u0010\u0003\u001a.\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004j\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/MutantBaseConfig$Companion;", "", "()V", "mobConfigurations", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantBaseConfig;", "Lkotlin/collections/HashMap;", "getMobConfigurations", "()Ljava/util/HashMap;", "minecraft"})
    public static final class Companion {
        @NotNull
        public final HashMap<Class<? extends EntityMutant>, MutantBaseConfig> getMobConfigurations() {
            return mobConfigurations;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

