/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.constants;

import noppes.npcs.CustomNpcs;

public enum EnumModelType {
    HumanMale("HumanMale", 0, "Human Male", CustomNpcs.getEntityId(), "npchumanmale"),
    Villager("Villager", 1, "Villager", CustomNpcs.getEntityId(), "npcvillager"),
    Pony("Pony", 2, "Pony", CustomNpcs.getEntityId(), "npcpony"),
    HumanFemale("HumanFemale", 3, "Human Female", CustomNpcs.getEntityId(), "npchumanfemale"),
    DwarfMale("DwarfMale", 4, "Dwarf Male", CustomNpcs.getEntityId(), "npcdwarfmale"),
    FurryMale("FurryMale", 5, "Furry Male", CustomNpcs.getEntityId(), "npcfurrymale"),
    MonsterMale("MonsterMale", 6, "Monster Male", CustomNpcs.getEntityId(), "npczombiemale"),
    MonsterFemale("MonsterFemale", 7, "Monster Female", CustomNpcs.getEntityId(), "npczombiefemale"),
    Skeleton("Skeleton", 8, "Skeleton", CustomNpcs.getEntityId(), "npcskeleton"),
    DwarfFemale("DwarfFemale", 9, "Dwarf Female", CustomNpcs.getEntityId(), "npcdwarffemale"),
    FurryFemale("FurryFemale", 10, "Furry Female", CustomNpcs.getEntityId(), "npcfurryfemale"),
    OrcMale("OrcMale", 11, "Orc Male", CustomNpcs.getEntityId(), "npcorcfmale"),
    OrcFemale("OrcFemale", 12, "Orc Female", CustomNpcs.getEntityId(), "npcorcfemale"),
    ElfMale("ElfMale", 13, "Elf Male", CustomNpcs.getEntityId(), "npcelfmale"),
    ElfFemale("ElfFemale", 14, "Elf Female", CustomNpcs.getEntityId(), "npcelffemale"),
    Crystal("Crystal", 15, "Crystal", CustomNpcs.getEntityId(), "npccrystal"),
    Golem("Golem", 16, "Golem", CustomNpcs.getEntityId(), "npcGolem"),
    EnderChibi("EnderChibi", 17, "EnderChibi", CustomNpcs.getEntityId(), "npcenderchibi"),
    EnderMan("EnderMan", 18, "EnderMan", CustomNpcs.getEntityId(), "npcEnderman"),
    NagaMale("NagaMale", 19, "Naga Male", CustomNpcs.getEntityId(), "npcnagamale"),
    NagaFemale("NagaFemale", 20, "Naga Female", CustomNpcs.getEntityId(), "npcnagafemale"),
    Slime("Slime", 21, "Slime", CustomNpcs.getEntityId(), "NpcSlime"),
    Dragon("Dragon", 22, "Dragon", CustomNpcs.getEntityId(), "NpcDragon");

    private static final EnumModelType[] $VALUES;
    public String name;
    public String entityName;
    public int id;

    private EnumModelType(String string2, int n2, String string3, int n3, String string4) {
        this.name = string3;
        this.entityName = string4;
        this.id = n3;
    }

    static {
        $VALUES = new EnumModelType[]{HumanMale, Villager, Pony, HumanFemale, DwarfMale, FurryMale, MonsterMale, MonsterFemale, Skeleton, DwarfFemale, FurryFemale, OrcMale, OrcFemale, ElfMale, ElfFemale, Crystal, Golem, EnderChibi, EnderMan, NagaMale, NagaFemale, Slime, Dragon};
    }
}

