/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.nbt.NBTTagCompound;
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

    public void readToNBT(NBTTagCompound nBTTagCompound) {
        this.readData(nBTTagCompound);
        this.readMovement(nBTTagCompound);
    }

    public void readData(NBTTagCompound nBTTagCompound) {
        this.canSwim = nBTTagCompound._o("CanSwim");
        this.reactsToFire = nBTTagCompound._o("ReactsToFire");
        this.avoidsWater = nBTTagCompound._o("AvoidsWater");
        this.avoidsSun = nBTTagCompound._o("AvoidsSun");
        this.returnToStart = nBTTagCompound._o("ReturnToStart");
        this.onAttack = nBTTagCompound._f("OnAttack");
        this.doorInteract = nBTTagCompound._f("DoorInteract");
        this.findShelter = nBTTagCompound._f("FindShelter");
        this.directLOS = nBTTagCompound._o("DirectLOS");
        this.canSleep = nBTTagCompound._o("CanSleep");
        this.canLeap = nBTTagCompound._o("CanLeap");
        this.canSprint = nBTTagCompound._o("CanSprint");
        this.canFireIndirect = nBTTagCompound._o("CanFireIndirect");
        this.useRangeMelee = nBTTagCompound._f("RangeAndMelee");
        this.tacticalRadius = nBTTagCompound._f("TacticalRadius");
        this.distanceToMelee = nBTTagCompound._f("DistanceToMelee");
        this.tacticalVariant = EnumNavType.values()[nBTTagCompound._f("TacticalVariant") % EnumNavType.values().length];
        this.advancedAgroTarget = nBTTagCompound._o("AdvancedAgro");
        if (nBTTagCompound._c("SoundThresold")) {
            this.soundAmountThresold = nBTTagCompound._h("SoundThresold");
            this.eyeFov = nBTTagCompound._h("EyeFov");
            this.eyeRange = nBTTagCompound._h("EyeRange");
        }
        this.npc.updateTasks();
    }

    public void readMovement(NBTTagCompound nBTTagCompound) {
        this.movingPause = nBTTagCompound._o("MovingPause");
        this.animationType = EnumAnimation.values()[nBTTagCompound._f("MoveState") % EnumAnimation.values().length];
        this.standingType = EnumStandingType.values()[nBTTagCompound._f("StandingState") % EnumStandingType.values().length];
        this.movingType = EnumMovingType.values()[nBTTagCompound._f("MovingState") % EnumMovingType.values().length];
        this.orientation = nBTTagCompound._f("Orientation");
        this.bodyOffsetY = nBTTagCompound._h("PositionOffsetY");
        this.bodyOffsetZ = nBTTagCompound._h("PositionOffsetZ");
        this.bodyOffsetX = nBTTagCompound._h("PositionOffsetX");
        this.walkingRange = nBTTagCompound._f("WalkingRange");
        this.setMovingPath(NBTTags.getIntegerArraySet(nBTTagCompound._n("MovingPath")));
        this.movingPos = nBTTagCompound._f("MovingPos");
        this.movingPattern = nBTTagCompound._f("MovingPatern");
        this.npc.updateTasks();
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nBTTagCompound) {
        this.writeData(nBTTagCompound);
        this.writeMovement(nBTTagCompound);
        return nBTTagCompound;
    }

    public void writeData(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("CanSwim", this.canSwim);
        nBTTagCompound._a("ReactsToFire", this.reactsToFire);
        nBTTagCompound._a("AvoidsWater", this.avoidsWater);
        nBTTagCompound._a("AvoidsSun", this.avoidsSun);
        nBTTagCompound._a("ReturnToStart", this.returnToStart);
        nBTTagCompound._a("OnAttack", this.onAttack);
        nBTTagCompound._a("DoorInteract", this.doorInteract);
        nBTTagCompound._a("FindShelter", this.findShelter);
        nBTTagCompound._a("DirectLOS", this.directLOS);
        nBTTagCompound._a("CanSleep", this.canSleep);
        nBTTagCompound._a("CanLeap", this.canLeap);
        nBTTagCompound._a("CanSprint", this.canSprint);
        nBTTagCompound._a("CanFireIndirect", this.canFireIndirect);
        nBTTagCompound._a("RangeAndMelee", this.useRangeMelee);
        nBTTagCompound._a("TacticalRadius", this.tacticalRadius);
        nBTTagCompound._a("DistanceToMelee", this.distanceToMelee);
        nBTTagCompound._a("TacticalVariant", this.tacticalVariant.ordinal());
        nBTTagCompound._a("AdvancedAgro", this.advancedAgroTarget);
        nBTTagCompound._a("SoundThresold", this.soundAmountThresold);
        nBTTagCompound._a("EyeFov", this.eyeFov);
        nBTTagCompound._a("EyeRange", this.eyeRange);
    }

    public void writeMovement(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("MovingPause", this.movingPause);
        nBTTagCompound._a("MoveState", this.animationType.ordinal());
        nBTTagCompound._a("StandingState", this.standingType.ordinal());
        nBTTagCompound._a("MovingState", this.movingType.ordinal());
        nBTTagCompound._a("Orientation", this.orientation);
        nBTTagCompound._a("PositionOffsetX", this.bodyOffsetX);
        nBTTagCompound._a("PositionOffsetY", this.bodyOffsetY);
        nBTTagCompound._a("PositionOffsetZ", this.bodyOffsetZ);
        nBTTagCompound._a("WalkingRange", this.walkingRange);
        nBTTagCompound._a("MovingPath", NBTTags.nbtIntegerArraySet(this.movingPath));
        nBTTagCompound._a("MovingPos", this.movingPos);
        nBTTagCompound._a("MovingPatern", this.movingPattern);
    }

    public List getMovingPath() {
        if (this.npc.startPos == null) {
            this.npc.startPos = new int[]{sajh._c(this.npc.posX), sajh._c(this.npc.posY), sajh._c(this.npc.posZ)};
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

