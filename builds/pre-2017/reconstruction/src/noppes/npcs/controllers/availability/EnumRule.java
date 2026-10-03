/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers.availability;

import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.controllers.availability.AvailabilityRule;

public abstract class EnumRule<T extends Enum>
extends AvailabilityRule {
    protected T anEnum;
    protected int id;

    public EnumRule(AvailabilityRule.RuleType ruleType) {
        super(ruleType);
    }

    @Override
    public void save(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("av", (byte)((Enum)this.anEnum).ordinal());
        nBTTagCompound._a("id", this.id);
    }

    @Override
    public void load(NBTTagCompound nBTTagCompound) {
        this.anEnum = this.getEnumValues()[nBTTagCompound._d("av")];
        this.id = nBTTagCompound._f("id");
    }

    public T getEnum() {
        return this.anEnum;
    }

    public void setEnum(T t) {
        this.anEnum = t;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int n) {
        this.id = n;
    }

    abstract T[] getEnumValues();
}

