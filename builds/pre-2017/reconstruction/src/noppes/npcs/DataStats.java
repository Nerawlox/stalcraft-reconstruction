/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
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
    public EnumCreatureAttribute creatureType;
    protected boolean immuneToFire = false;
    private EntityNPCInterface npc;
    public boolean collidable = false;
    public boolean playersThrowOff = false;

    public DataStats(EntityNPCInterface entityNPCInterface) {
        this.potionType = EnumPotionType.None;
        this.resistances = new Resistances();
        this.pEffect = EnumPotionType.None;
        this.pTrail = EnumParticleType.None;
        this.creatureType = EnumCreatureAttribute._a;
        this.npc = entityNPCInterface;
        this.collidable = false;
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("Resistances", this.resistances.writeToNBT());
        nBTTagCompound._a("MaxHealth", this.maxHealth);
        nBTTagCompound._a("AggroRange", this.aggroRange);
        nBTTagCompound._a("RespawnTime", this.respawnTime);
        nBTTagCompound._a("SpawnCycle", this.spawnCycle);
        nBTTagCompound._a("CreatureType", this.creatureType.ordinal());
        nBTTagCompound._a("MoveSpeed", this.moveSpeed);
        nBTTagCompound._a("HealthRegen", this.healthRegen);
        nBTTagCompound._a("AttackStrenght", this.attackStrength);
        nBTTagCompound._a("AttackRange", this.attackRange);
        nBTTagCompound._a("AttackSpeed", this.attackSpeed);
        nBTTagCompound._a("KnockBack", this.knockback);
        nBTTagCompound._a("PotionEffect", this.potionType.ordinal());
        nBTTagCompound._a("PotionDuration", this.potionDuration);
        nBTTagCompound._a("PotionAmp", this.potionAmp);
        nBTTagCompound._a("MaxFiringRange", this.rangedRange);
        nBTTagCompound._a("FireRate", this.fireRate);
        nBTTagCompound._a("FiringDelay", this.fireDelay);
        nBTTagCompound._a("DelayVariance", this.delayVariance);
        nBTTagCompound._a("BurstCount", this.burstCount);
        nBTTagCompound._a("Accuracy", this.accuracy);
        nBTTagCompound._a("pDamage", this.pDamage);
        nBTTagCompound._a("pImpact", this.pImpact);
        nBTTagCompound._a("pSize", this.pSize);
        nBTTagCompound._a("pSpeed", this.pSpeed);
        nBTTagCompound._a("pArea", this.pArea);
        nBTTagCompound._a("pDur", this.pDur);
        nBTTagCompound._a("pPhysics", this.pPhysics);
        nBTTagCompound._a("pXlr8", this.pXlr8);
        nBTTagCompound._a("pGlows", this.pGlows);
        nBTTagCompound._a("pExplode", this.pExplode);
        nBTTagCompound._a("pRender3D", this.pRender3D);
        nBTTagCompound._a("pSpin", this.pSpin);
        nBTTagCompound._a("pStick", this.pStick);
        nBTTagCompound._a("pEffect", this.pEffect.ordinal());
        nBTTagCompound._a("pTrail", this.pTrail.ordinal());
        nBTTagCompound._a("pEffAmp", this.pEffAmp);
        nBTTagCompound._a("FiringSound", this.fireSound);
        nBTTagCompound._a("ImmuneToFire", this.immuneToFire);
        nBTTagCompound._a("CanDrown", this.canDrown);
        nBTTagCompound._a("BurnInSun", this.burnInSun);
        nBTTagCompound._a("NoFallDamage", this.noFallDamage);
        nBTTagCompound._a("CollidableNpc", this.collidable);
        nBTTagCompound._a("PlayersThrowOff", this.playersThrowOff);
        nBTTagCompound._a("BleedingChance", this.bleedingChance);
        nBTTagCompound._a("DamageLoss", this.damageLoss);
        this.spawnTimeRanges.writeToNBT(nBTTagCompound);
        return nBTTagCompound;
    }

    public void readToNBT(NBTTagCompound nBTTagCompound) {
        this.resistances.readToNBT(nBTTagCompound._m("Resistances"));
        this.maxHealth = nBTTagCompound._f("MaxHealth");
        this.aggroRange = nBTTagCompound._f("AggroRange");
        this.respawnTime = nBTTagCompound._f("RespawnTime");
        this.spawnCycle = nBTTagCompound._f("SpawnCycle");
        this.creatureType = EnumCreatureAttribute.values()[nBTTagCompound._f("CreatureType") % EnumPotionType.values().length];
        this.moveSpeed = nBTTagCompound._f("MoveSpeed");
        this.healthRegen = nBTTagCompound._o("HealthRegen");
        this.attackStrength = nBTTagCompound._f("AttackStrenght");
        this.attackSpeed = nBTTagCompound._f("AttackSpeed");
        this.attackRange = nBTTagCompound._f("AttackRange");
        this.knockback = nBTTagCompound._f("KnockBack");
        this.potionType = EnumPotionType.values()[nBTTagCompound._f("PotionEffect") % EnumPotionType.values().length];
        this.potionDuration = nBTTagCompound._f("PotionDuration");
        this.potionAmp = nBTTagCompound._f("PotionAmp");
        this.rangedRange = nBTTagCompound._f("MaxFiringRange");
        this.fireRate = nBTTagCompound._f("FireRate");
        this.fireDelay = nBTTagCompound._f("FiringDelay");
        this.delayVariance = nBTTagCompound._f("DelayVariance");
        this.burstCount = nBTTagCompound._f("BurstCount");
        this.pDamage = nBTTagCompound._f("pDamage");
        this.pImpact = nBTTagCompound._f("pImpact");
        this.pSize = nBTTagCompound._f("pSize");
        this.pSpeed = nBTTagCompound._f("pSpeed");
        this.pArea = nBTTagCompound._f("pArea");
        this.pDur = nBTTagCompound._f("pDur");
        this.pPhysics = nBTTagCompound._o("pPhysics");
        this.pXlr8 = nBTTagCompound._o("pXlr8");
        this.pGlows = nBTTagCompound._o("pGlows");
        this.pExplode = nBTTagCompound._o("pExplode");
        this.pRender3D = nBTTagCompound._o("pRender3D");
        this.pSpin = nBTTagCompound._o("pSpin");
        this.pStick = nBTTagCompound._o("pStick");
        this.pEffect = EnumPotionType.values()[nBTTagCompound._f("pEffect") % EnumPotionType.values().length];
        this.pTrail = EnumParticleType.values()[nBTTagCompound._f("pTrail") % EnumParticleType.values().length];
        this.pEffAmp = nBTTagCompound._f("pEffAmp");
        this.fireSound = nBTTagCompound._j("FiringSound");
        this.immuneToFire = nBTTagCompound._o("ImmuneToFire");
        this.canDrown = nBTTagCompound._o("CanDrown");
        this.burnInSun = nBTTagCompound._o("BurnInSun");
        this.noFallDamage = nBTTagCompound._o("NoFallDamage");
        this.collidable = nBTTagCompound._o("CollidableNpc");
        this.playersThrowOff = nBTTagCompound._o("PlayersThrowOff");
        NBTBase nBTBase = nBTTagCompound._b("Accuracy");
        this.accuracy = nBTBase == null ? 90.0 : (nBTBase instanceof hdfw ? (double)((hdfw)nBTBase)._c : ((qoae)nBTBase)._c);
        this.bleedingChance = nBTTagCompound._i("BleedingChance");
        this.damageLoss = nBTTagCompound._i("DamageLoss");
        this.spawnTimeRanges.readFromNBT(nBTTagCompound);
        this.npc.setImmuneToFire(this.immuneToFire);
        this.npc.updateHitbox();
    }
}

