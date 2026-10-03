/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers.availability;

import noppes.npcs.controllers.availability.AvailabilityRule;

public abstract class EnumRule<T extends Enum>
extends AvailabilityRule {
    protected T anEnum;
    protected int id;

    public EnumRule(AvailabilityRule.RuleType ruleType) {
        super(ruleType);
    }

    @Override
    public void save(qoac qoac2) {
        qoac2._a("av", (byte)((Enum)this.anEnum).ordinal());
        qoac2._a("id", this.id);
    }

    @Override
    public void load(qoac qoac2) {
        this.anEnum = this.getEnumValues()[qoac2._d("av")];
        this.id = qoac2._f("id");
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

