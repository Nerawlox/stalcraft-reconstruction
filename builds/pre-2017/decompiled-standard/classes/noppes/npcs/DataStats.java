/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import net.minecraft.entity.vjta;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.Resistances;
import noppes.npcs.constants.EnumParticleType;
import noppes.npcs.constants.EnumPotionType;
import noppes.npcs.controllers.TimeRanges;

public class DataStats {
    public double damageLoss = 0.0;
    public double bleedingChance = 5.0;
    public int attackStrength = 5;
    public int attackSpeed = 20;
    public int attackRange = 2;
    public int knockback = 0;
    public int fireDelay = 20;
    public int delayVariance = 40;
    public int rangedRange = 15;
    public int fireRate = 5;
    public int burstCount = 1;
    public double accuracy = 90.0;
    public int moveSpeed = 6;
    public int aggroRange = 16;
    public EnumPotionType potionType;
    public int potionDuration = 5;
    public int potionAmp = 0;
    public int maxHealth = 20;
    public int respawnTime = 20;
    public int spawnCycle = 0;
    public TimeRanges spawnTimeRanges = new TimeRanges();
    public Resistances resistances;
    public boolean canDrown = true;
    public boolean burnInSun = false;
    public boolean noFallDamage = false;
    public boolean healthRegen = true;
    public int pDamage = 4;
    public int pImpact = 0;
    public int pSize = 5;
    public int pSpeed = 10;
    public int pArea = 0;
    public int pDur = 5;
    public boolean pPhysics = true;
    public boolean pXlr8 = false;
    public boolean pGlows = false;
    public boolean pExplode = false;
    public boolean pRender3D = false;
    public boolean pSpin = false;
    public boolean pStick = false;
    public EnumPotionType pEffect;
    public EnumParticleType pTrail;
    public int pEffAmp = 0;
    public String fireSound = "random.bow";
    public vjta creatureType;
    protected boolean immuneToFire = false;
    private EntityNPCInterface npc;
    public boolean collidable = false;
    public boolean playersThrowOff = false;

    public DataStats(EntityNPCInterface entityNPCInterface) {
        this.potionType = EnumPotionType.None;
        this.resistances = new Resistances();
        this.pEffect = EnumPotionType.None;
        this.pTrail = EnumParticleType.None;
        this.creatureType = vjta._a;
        this.npc = entityNPCInterface;
        this.collidable = false;
    }

    public qoac writeToNBT(qoac qoac2) {
        qoac2._a("Resistances", this.resistances.writeToNBT());
        qoac2._a("MaxHealth", this.maxHealth);
        qoac2._a("AggroRange", this.aggroRange);
        qoac2._a("RespawnTime", this.respawnTime);
        qoac2._a("SpawnCycle", this.spawnCycle);
        qoac2._a("CreatureType", this.creatureType.ordinal());
        qoac2._a("MoveSpeed", this.moveSpeed);
        qoac2._a("HealthRegen", this.healthRegen);
        qoac2._a("AttackStrenght", this.attackStrength);
        qoac2._a("AttackRange", this.attackRange);
        qoac2._a("AttackSpeed", this.attackSpeed);
        qoac2._a("KnockBack", this.knockback);
        qoac2._a("PotionEffect", this.potionType.ordinal());
        qoac2._a("PotionDuration", this.potionDuration);
        qoac2._a("PotionAmp", this.potionAmp);
        qoac2._a("MaxFiringRange", this.rangedRange);
        qoac2._a("FireRate", this.fireRate);
        qoac2._a("FiringDelay", this.fireDelay);
        qoac2._a("DelayVariance", this.delayVariance);
        qoac2._a("BurstCount", this.burstCount);
        qoac2._a("Accuracy", this.accuracy);
        qoac2._a("pDamage", this.pDamage);
        qoac2._a("pImpact", this.pImpact);
        qoac2._a("pSize", this.pSize);
        qoac2._a("pSpeed", this.pSpeed);
        qoac2._a("pArea", this.pArea);
        qoac2._a("pDur", this.pDur);
        qoac2._a("pPhysics", this.pPhysics);
        qoac2._a("pXlr8", this.pXlr8);
        qoac2._a("pGlows", this.pGlows);
        qoac2._a("pExplode", this.pExplode);
        qoac2._a("pRender3D", this.pRender3D);
        qoac2._a("pSpin", this.pSpin);
        qoac2._a("pStick", this.pStick);
        qoac2._a("pEffect", this.pEffect.ordinal());
        qoac2._a("pTrail", this.pTrail.ordinal());
        qoac2._a("pEffAmp", this.pEffAmp);
        qoac2._a("FiringSound", this.fireSound);
        qoac2._a("ImmuneToFire", this.immuneToFire);
        qoac2._a("CanDrown", this.canDrown);
        qoac2._a("BurnInSun", this.burnInSun);
        qoac2._a("NoFallDamage", this.noFallDamage);
        qoac2._a("CollidableNpc", this.collidable);
        qoac2._a("PlayersThrowOff", this.playersThrowOff);
        qoac2._a("BleedingChance", this.bleedingChance);
        qoac2._a("DamageLoss", this.damageLoss);
        this.spawnTimeRanges.writeToNBT(qoac2);
        return qoac2;
    }

    public void readToNBT(qoac qoac2) {
        this.resistances.readToNBT(qoac2._m("Resistances"));
        this.maxHealth = qoac2._f("MaxHealth");
        this.aggroRange = qoac2._f("AggroRange");
        this.respawnTime = qoac2._f("RespawnTime");
        this.spawnCycle = qoac2._f("SpawnCycle");
        this.creatureType = vjta.values()[qoac2._f("CreatureType") % EnumPotionType.values().length];
        this.moveSpeed = qoac2._f("MoveSpeed");
        this.healthRegen = qoac2._o("HealthRegen");
        this.attackStrength = qoac2._f("AttackStrenght");
        this.attackSpeed = qoac2._f("AttackSpeed");
        this.attackRange = qoac2._f("AttackRange");
        this.knockback = qoac2._f("KnockBack");
        this.potionType = EnumPotionType.values()[qoac2._f("PotionEffect") % EnumPotionType.values().length];
        this.potionDuration = qoac2._f("PotionDuration");
        this.potionAmp = qoac2._f("PotionAmp");
        this.rangedRange = qoac2._f("MaxFiringRange");
        this.fireRate = qoac2._f("FireRate");
        this.fireDelay = qoac2._f("FiringDelay");
        this.delayVariance = qoac2._f("DelayVariance");
        this.burstCount = qoac2._f("BurstCount");
        this.pDamage = qoac2._f("pDamage");
        this.pImpact = qoac2._f("pImpact");
        this.pSize = qoac2._f("pSize");
        this.pSpeed = qoac2._f("pSpeed");
        this.pArea = qoac2._f("pArea");
        this.pDur = qoac2._f("pDur");
        this.pPhysics = qoac2._o("pPhysics");
        this.pXlr8 = qoac2._o("pXlr8");
        this.pGlows = qoac2._o("pGlows");
        this.pExplode = qoac2._o("pExplode");
        this.pRender3D = qoac2._o("pRender3D");
        this.pSpin = qoac2._o("pSpin");
        this.pStick = qoac2._o("pStick");
        this.pEffect = EnumPotionType.values()[qoac2._f("pEffect") % EnumPotionType.values().length];
        this.pTrail = EnumParticleType.values()[qoac2._f("pTrail") % EnumParticleType.values().length];
        this.pEffAmp = qoac2._f("pEffAmp");
        this.fireSound = qoac2._j("FiringSound");
        this.immuneToFire = qoac2._o("ImmuneToFire");
        this.canDrown = qoac2._o("CanDrown");
        this.burnInSun = qoac2._o("BurnInSun");
        this.noFallDamage = qoac2._o("NoFallDamage");
        this.collidable = qoac2._o("CollidableNpc");
        this.playersThrowOff = qoac2._o("PlayersThrowOff");
        huhy huhy2 = qoac2._b("Accuracy");
        this.accuracy = huhy2 == null ? 90.0 : (huhy2 instanceof hdfw ? (double)((hdfw)huhy2)._c : ((qoae)huhy2)._c);
        this.bleedingChance = qoac2._i("BleedingChance");
        this.damageLoss = qoac2._i("DamageLoss");
        this.spawnTimeRanges.readFromNBT(qoac2);
        this.npc.setImmuneToFire(this.immuneToFire);
        this.npc.updateHitbox();
    }
}

