/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.client.render;

import gloomyfolken.mods.stalker.mobs.client.tuning.EditorProperty;
import kotlin.Metadata;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b\u00a8\u0006\u001b"}, d2={"Lgloomyfolken/mods/stalker/mobs/client/render/DebugDrawInfo;", "", "()V", "drawAttackAabb", "", "getDrawAttackAabb", "()Z", "setDrawAttackAabb", "(Z)V", "drawAttackCone", "getDrawAttackCone", "setDrawAttackCone", "drawCrit", "getDrawCrit", "setDrawCrit", "drawHearLie", "getDrawHearLie", "setDrawHearLie", "drawHearRun", "getDrawHearRun", "setDrawHearRun", "drawHearWalk", "getDrawHearWalk", "setDrawHearWalk", "drawSightCone", "getDrawSightCone", "setDrawSightCone", "minecraft"})
public final class DebugDrawInfo {
    @EditorProperty(name="\u0420\u0438\u0441\u043e\u0432\u0430\u0442\u044c \u0445\u0438\u0442\u0431\u043e\u043a\u0441 \u0443\u0434\u0430\u0440\u0430")
    private boolean drawAttackAabb;
    @EditorProperty(name="\u0420\u0438\u0441\u043e\u0432\u0430\u0442\u044c \u0440\u0430\u0441\u0441\u0442. \u0430\u0442\u0430\u043a\u0438")
    private boolean drawAttackCone;
    @EditorProperty(name="\u0420\u0438\u0441\u043e\u0432\u0430\u0442\u044c \u0440\u0430\u0441\u0441\u0442.\u0434\u043e \u043a\u0440\u0438\u0442.\u0436\u0435\u0440\u0442\u0432\u044b")
    private boolean drawCrit;
    @EditorProperty(name="\u0420\u0438\u0441\u043e\u0432\u0430\u0442\u044c \u043a\u043e\u043d\u0443\u0441 \u0437\u0440\u0435\u043d\u0438\u044f")
    private boolean drawSightCone;
    @EditorProperty(name="\u0420\u0438\u0441\u043e\u0432\u0430\u0442\u044c \u0440\u0430\u0434\u0438\u0443\u0441 \u0441\u043b\u044b\u0448\u0438\u043c\u043e\u0441\u0442\u0438 \u0448\u0430\u0433\u043e\u0432")
    private boolean drawHearWalk;
    @EditorProperty(name="\u0420\u0438\u0441\u043e\u0432\u0430\u0442\u044c \u0440\u0430\u0434\u0438\u0443\u0441 \u0441\u043b\u044b\u0448\u0438\u043c\u043e\u0441\u0442\u0438 \u0431\u0435\u0433\u0430")
    private boolean drawHearRun;
    @EditorProperty(name="\u0420\u0438\u0441\u043e\u0432\u0430\u0442\u044c \u0440\u0430\u0434\u0438\u0443\u0441 \u0441\u043b\u044b\u0448\u0438\u043c\u043e\u0441\u0442\u0438 \u0434\u0432\u0438\u0436.\u043f\u043e\u043b\u043a\u0437\u043e\u043c")
    private boolean drawHearLie;

    public final boolean getDrawAttackAabb() {
        return this.drawAttackAabb;
    }

    public final void setDrawAttackAabb(boolean bl) {
        this.drawAttackAabb = bl;
    }

    public final boolean getDrawAttackCone() {
        return this.drawAttackCone;
    }

    public final void setDrawAttackCone(boolean bl) {
        this.drawAttackCone = bl;
    }

    public final boolean getDrawCrit() {
        return this.drawCrit;
    }

    public final void setDrawCrit(boolean bl) {
        this.drawCrit = bl;
    }

    public final boolean getDrawSightCone() {
        return this.drawSightCone;
    }

    public final void setDrawSightCone(boolean bl) {
        this.drawSightCone = bl;
    }

    public final boolean getDrawHearWalk() {
        return this.drawHearWalk;
    }

    public final void setDrawHearWalk(boolean bl) {
        this.drawHearWalk = bl;
    }

    public final boolean getDrawHearRun() {
        return this.drawHearRun;
    }

    public final void setDrawHearRun(boolean bl) {
        this.drawHearRun = bl;
    }

    public final boolean getDrawHearLie() {
        return this.drawHearLie;
    }

    public final void setDrawHearLie(boolean bl) {
        this.drawHearLie = bl;
    }
}

