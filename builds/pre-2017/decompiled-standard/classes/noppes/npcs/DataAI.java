/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.util.sajh;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NBTTags;
import noppes.npcs.constants.EnumAnimation;
import noppes.npcs.constants.EnumMovingType;
import noppes.npcs.constants.EnumNavType;
import noppes.npcs.constants.EnumStandingType;

public class DataAI {
    public int onAttack = 0;
    public int doorInteract = 2;
    public int findShelter = 2;
    public int distanceToMelee = 4;
    public boolean canSwim = true;
    public boolean reactsToFire = false;
    public boolean avoidsWater = false;
    public boolean avoidsSun = false;
    public boolean returnToStart = true;
    public boolean directLOS = true;
    public boolean canSleep = false;
    public boolean canLeap = false;
    public boolean canFireIndirect = false;
    public boolean canSprint = false;
    public EnumNavType tacticalVariant = EnumNavType.Default;
    public int useRangeMelee = 0;
    public int tacticalRadius = 8;
    public EnumAnimation animationType = EnumAnimation.NONE;
    public EnumStandingType standingType = EnumStandingType.RotateBody;
    public EnumMovingType movingType = EnumMovingType.Standing;
    public int orientation = 0;
    public float bodyOffsetX = 5.0f;
    public float bodyOffsetY = 5.0f;
    public float bodyOffsetZ = 5.0f;
    public int walkingRange = 5;
    public int movingPattern = 0;
    public boolean movingPause = true;
    protected int movingPos = 0;
    public EntityNPCInterface npc;
    private List movingPath = new ArrayList();
    public boolean advancedAgroTarget = false;
    public float soundAmountThresold = 20.0f;
    public float eyeRange = 30.0f;
    public float eyeFov = 120.0f;

    public DataAI(EntityNPCInterface entityNPCInterface) {
        this.npc = entityNPCInterface;
    }

    public void readToNBT(qoac qoac2) {
        this.readData(qoac2);
        this.readMovement(qoac2);
    }

    public void readData(qoac qoac2) {
        this.canSwim = qoac2._o("CanSwim");
        this.reactsToFire = qoac2._o("ReactsToFire");
        this.avoidsWater = qoac2._o("AvoidsWater");
        this.avoidsSun = qoac2._o("AvoidsSun");
        this.returnToStart = qoac2._o("ReturnToStart");
        this.onAttack = qoac2._f("OnAttack");
        this.doorInteract = qoac2._f("DoorInteract");
        this.findShelter = qoac2._f("FindShelter");
        this.directLOS = qoac2._o("DirectLOS");
        this.canSleep = qoac2._o("CanSleep");
        this.canLeap = qoac2._o("CanLeap");
        this.canSprint = qoac2._o("CanSprint");
        this.canFireIndirect = qoac2._o("CanFireIndirect");
        this.useRangeMelee = qoac2._f("RangeAndMelee");
        this.tacticalRadius = qoac2._f("TacticalRadius");
        this.distanceToMelee = qoac2._f("DistanceToMelee");
        this.tacticalVariant = EnumNavType.values()[qoac2._f("TacticalVariant") % EnumNavType.values().length];
        this.advancedAgroTarget = qoac2._o("AdvancedAgro");
        if (qoac2._c("SoundThresold")) {
            this.soundAmountThresold = qoac2._h("SoundThresold");
            this.eyeFov = qoac2._h("EyeFov");
            this.eyeRange = qoac2._h("EyeRange");
        }
        this.npc.updateTasks();
    }

    public void readMovement(qoac qoac2) {
        this.movingPause = qoac2._o("MovingPause");
        this.animationType = EnumAnimation.values()[qoac2._f("MoveState") % EnumAnimation.values().length];
        this.standingType = EnumStandingType.values()[qoac2._f("StandingState") % EnumStandingType.values().length];
        this.movingType = EnumMovingType.values()[qoac2._f("MovingState") % EnumMovingType.values().length];
        this.orientation = qoac2._f("Orientation");
        this.bodyOffsetY = qoac2._h("PositionOffsetY");
        this.bodyOffsetZ = qoac2._h("PositionOffsetZ");
        this.bodyOffsetX = qoac2._h("PositionOffsetX");
        this.walkingRange = qoac2._f("WalkingRange");
        this.setMovingPath(NBTTags.getIntegerArraySet(qoac2._n("MovingPath")));
        this.movingPos = qoac2._f("MovingPos");
        this.movingPattern = qoac2._f("MovingPatern");
        this.npc.updateTasks();
    }

    public qoac writeToNBT(qoac qoac2) {
        this.writeData(qoac2);
        this.writeMovement(qoac2);
        return qoac2;
    }

    public void writeData(qoac qoac2) {
        qoac2._a("CanSwim", this.canSwim);
        qoac2._a("ReactsToFire", this.reactsToFire);
        qoac2._a("AvoidsWater", this.avoidsWater);
        qoac2._a("AvoidsSun", this.avoidsSun);
        qoac2._a("ReturnToStart", this.returnToStart);
        qoac2._a("OnAttack", this.onAttack);
        qoac2._a("DoorInteract", this.doorInteract);
        qoac2._a("FindShelter", this.findShelter);
        qoac2._a("DirectLOS", this.directLOS);
        qoac2._a("CanSleep", this.canSleep);
        qoac2._a("CanLeap", this.canLeap);
        qoac2._a("CanSprint", this.canSprint);
        qoac2._a("CanFireIndirect", this.canFireIndirect);
        qoac2._a("RangeAndMelee", this.useRangeMelee);
        qoac2._a("TacticalRadius", this.tacticalRadius);
        qoac2._a("DistanceToMelee", this.distanceToMelee);
        qoac2._a("TacticalVariant", this.tacticalVariant.ordinal());
        qoac2._a("AdvancedAgro", this.advancedAgroTarget);
        qoac2._a("SoundThresold", this.soundAmountThresold);
        qoac2._a("EyeFov", this.eyeFov);
        qoac2._a("EyeRange", this.eyeRange);
    }

    public void writeMovement(qoac qoac2) {
        qoac2._a("MovingPause", this.movingPause);
        qoac2._a("MoveState", this.animationType.ordinal());
        qoac2._a("StandingState", this.standingType.ordinal());
        qoac2._a("MovingState", this.movingType.ordinal());
        qoac2._a("Orientation", this.orientation);
        qoac2._a("PositionOffsetX", this.bodyOffsetX);
        qoac2._a("PositionOffsetY", this.bodyOffsetY);
        qoac2._a("PositionOffsetZ", this.bodyOffsetZ);
        qoac2._a("WalkingRange", this.walkingRange);
        qoac2._a("MovingPath", NBTTags.nbtIntegerArraySet(this.movingPath));
        qoac2._a("MovingPos", this.movingPos);
        qoac2._a("MovingPatern", this.movingPattern);
    }

    public List getMovingPath() {
        if (this.npc.startPos == null) {
            this.npc.startPos = new int[]{sajh._c(this.npc.field_70165_t), sajh._c(this.npc.field_70163_u), sajh._c(this.npc.field_70161_v)};
        }
        if (this.movingPath.isEmpty()) {
            this.movingPath.add(this.npc.startPos);
        }
        return this.movingPath;
    }

    public void setMovingPath(List list2) {
        this.movingPath = list2;
        if (!this.movingPath.isEmpty()) {
            this.npc.startPos = (int[])this.movingPath.get(0);
        }
    }

    public int[] getCurrentMovingPath() {
        List list2 = this.getMovingPath();
        if (list2.size() == 1) {
            this.movingPos = 0;
        } else if (this.movingPos >= list2.size()) {
            if (this.movingPattern == 0) {
                this.movingPos = 0;
            } else {
                int n = list2.size() * 2 - 2;
                if (this.movingPos >= n) {
                    this.movingPos = 0;
                } else if (this.movingPos >= list2.size()) {
                    return (int[])list2.get(list2.size() - this.movingPos % list2.size() - 2);
                }
            }
        }
        return (int[])list2.get(this.movingPos);
    }

    public void incrementMovingPath() {
        List list2 = this.getMovingPath();
        if (list2.size() == 1) {
            this.movingPos = 0;
        } else if (this.movingPattern == 0) {
            ++this.movingPos;
            this.movingPos %= list2.size();
        } else if (this.movingPattern == 1) {
            ++this.movingPos;
            int n = list2.size() * 2 - 2;
            this.movingPos %= n;
        }
    }

    public void decreaseMovingPath() {
        List list2 = this.getMovingPath();
        if (list2.size() == 1) {
            this.movingPos = 0;
        } else if (this.movingPattern == 0) {
            --this.movingPos;
            if (this.movingPos < 0) {
                this.movingPos += list2.size();
            }
        } else if (this.movingPattern == 1) {
            --this.movingPos;
            if (this.movingPos < 0) {
                int n = list2.size() * 2 - 2;
                this.movingPos += n;
            }
        }
    }
}

