/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.smplayer;

import gloomyfolken.mods.stalker.player.zwat;
import kotlin.Metadata;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&\u00a8\u0006\f"}, d2={"Lgloomyfolken/mods/stalker/smplayer/ISmartMeshRotation;", "Lgloomyfolken/mods/stalker/player/IMeshRotation;", "getScaleY", "", "ignoreBase", "", "ignoreSuperRotation", "rotationOrder", "", "translationOffsetX", "translationOffsetY", "translationOffsetZ", "minecraft"})
public interface eidj
extends zwat {
    public int rotationOrder();

    public boolean ignoreBase();

    public boolean ignoreSuperRotation();

    public float translationOffsetX();

    public float translationOffsetY();

    public float translationOffsetZ();

    public float getScaleY();
}

