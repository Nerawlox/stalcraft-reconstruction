/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bdi
 *  bjo
 *  cpw.mods.fml.common.registry.LanguageRegistry
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  mt
 */
package ru.stalcraft.items;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.Util;
import ru.stalcraft.client.ClientTicker;
import ru.stalcraft.client.ClientWeaponInfo;
import ru.stalcraft.client.gui.GuiSettingsStalker;
import ru.stalcraft.client.player.PlayerClientInfo;
import ru.stalcraft.entity.EntityBullet;
import ru.stalcraft.entity.EntityGrenade;
import ru.stalcraft.entity.EntityShot;
import ru.stalcraft.entity.EntitySleeve;
import ru.stalcraft.items.FireMode;
import ru.stalcraft.items.IFlashlight;
import ru.stalcraft.items.ISpecialWeight;
import ru.stalcraft.items.ItemGrenade;
import ru.stalcraft.player.PlayerUtils;
import ru.stalcraft.server.WeightMap;
import ru.stalcraft.server.network.ServerPacketSender;

public class ItemWeapon
extends yc
implements ISpecialWeight,
IFlashlight {
    private static int nextId = 0;
    private static int ticksToChangeMotion = 0;
    private static int motionPause = 0;
    private static float motionYaw = 0.0f;
    private static float motionPitch = 0.0f;
    public final FireMode[] fireMods;
    private List description;
    public final String textureName;
    public final String modelName;
    public final String shootSound;
    public final String hitSound;
    public final String reloadSound;
    public final String aimingTexture;
    public final String modelTexture;
    public final String sleeveModel;
    public final String silencerShootSound;
    public final String aimingTextureSight;
    public final bjo sleeveTexture;
    public final int bulletId;
    public final int cooldown;
    public final int damage;
    public final int cageSize;
    public final int reloadTime;
    public final int bulletsCount;
    public final int grenadeId;
    public final int grenadeLaunchCooldown;
    public final float lightSize;
    public final float lightDistance;
    public final float bulletSpeed;
    public final float zoom;
    public final float recoil;
    public final float spread;
    public final float zoomSight;
    public final float aimPosY;
    public final float aimPosZ;
    public final float aimRotX;
    public final float posX;
    public final float posY;
    public final float posZ;
    public final boolean hasGrenadeLauncher;
    public final boolean isPistol;
    public final boolean renderEquipped;
    public final boolean flashlight;
    public final boolean silencer;
    public final boolean sight;
    public final double damageFactor;

    public ItemWeapon(int id, int bulletID, FireMode[] fireMods, int cooldown, int damage, int cageSize, int reloadTime, int maxDamage, float bulletSpeed, String name, String textureName, String modelName, String modelTexture, List description, String aimingTexture, String shootSound, String hitSound, String reloadSound, String sleeveModel, String sleeveTexture, int grenadeId, int grenadeLaunchCooldown, boolean isPistol, boolean renderEquipped, int bulletsCount, float lightDistance, float lightSize, float zoom, float recoil, float spread, float aimX, float aimY, float aimZ, float x2, float y2, float z2, boolean flashlight, boolean silencer, boolean sight, String silencerShootSound, String aimingTextureSight, float zoomSight, int halfLife) {
        super(id - 256);
        this.b("weapon" + ++nextId);
        this.textureName = textureName;
        this.a(StalkerMain.tabWeapon);
        LanguageRegistry.addName((Object)this, (String)name);
        this.fireMods = fireMods;
        this.cw = 1;
        this.bulletId = bulletID;
        this.cooldown = cooldown;
        this.e(maxDamage);
        this.description = description;
        this.damage = damage;
        this.cageSize = cageSize;
        this.lightSize = lightSize;
        this.reloadTime = reloadTime;
        boolean bl2 = this.hasGrenadeLauncher = grenadeId != 0;
        if (sleeveModel != null) {
            if (sleeveModel.isEmpty()) {
                sleeveModel = null;
                this.sleeveTexture = null;
            } else {
                this.sleeveTexture = new bjo("stalker", "models/sleeves/" + sleeveTexture + ".png");
            }
        } else {
            this.sleeveTexture = null;
        }
        this.sleeveModel = sleeveModel;
        this.grenadeId = grenadeId;
        this.grenadeLaunchCooldown = grenadeLaunchCooldown;
        this.lightDistance = lightDistance;
        this.aimingTexture = aimingTexture != null && !aimingTexture.isEmpty() ? aimingTexture : null;
        this.modelName = modelName;
        this.bulletSpeed = bulletSpeed;
        this.isPistol = isPistol;
        this.zoom = zoom;
        this.shootSound = "stalker:" + shootSound;
        this.hitSound = "stalker:" + hitSound;
        this.reloadSound = "stalker:" + reloadSound;
        this.recoil = recoil;
        this.renderEquipped = renderEquipped;
        this.bulletsCount = bulletsCount;
        this.spread = spread;
        this.modelTexture = modelTexture;
        this.flashlight = flashlight;
        this.silencer = silencer;
        this.sight = sight;
        this.silencerShootSound = "stalker:" + silencerShootSound;
        this.aimingTextureSight = aimingTextureSight;
        this.zoomSight = zoomSight;
        this.damageFactor = Math.pow(0.5, 1.0 / (double)(halfLife - 1));
        this.aimPosY = aimY;
        this.aimPosZ = aimZ;
        this.aimRotX = aimX;
        this.posX = x2;
        this.posY = y2;
        this.posZ = z2;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(mt par1IconRegister) {
        this.cz = par1IconRegister.a("stalker:" + this.textureName);
    }

    @Override
    public ye a(ye is2, abw world, uf player) {
        return is2;
    }

    @Override
    public void onUsingItemTick(ye stack, uf player, int count) {
        if (player.bq() == 20) {
            Util.setPrivateValue(uf.class, player, 21, "itemInUseCount", "field_71072_f", "g");
        }
        if (player.q.I) {
            this.onItemUsingTickClient(stack, player, count);
        }
    }

    private void onItemUsingTickClient(ye stack, uf player, int count) {
        if (atv.w().h == player && ((ClientWeaponInfo)((PlayerClientInfo)PlayerUtils.getInfo((uf)player)).weaponInfo).isAiming()) {
            bdi p2 = atv.w().h;
            if (--ticksToChangeMotion <= 0) {
                ticksToChangeMotion = 5 + (int)(Math.random() * 15.0);
                motionPitch = ((float)Math.random() - 0.5f) * 0.5f;
                motionYaw = ((float)Math.random() - 0.5f) * 0.5f;
                motionPause = (int)(Math.random() * 5.0);
            }
            if (--motionPause <= 0) {
                atv.w().h.c(motionYaw, motionPitch);
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void clientShoot(of shooter, ye stack, boolean hasFlash) {
        boolean isShooterPlayer = shooter instanceof uf;
        if (GuiSettingsStalker.renderSleeves) {
            shooter.q.d(new EntitySleeve(shooter.q, shooter, isShooterPlayer, this));
        }
        if (hasFlash) {
            shooter.q.d(new EntityShot(shooter, this, isShooterPlayer));
        }
        if (shooter == atv.w().h) {
            shooter.c(0.0f, this.recoil);
        }
        shooter.q.a((double)((float)shooter.u), (double)((float)shooter.v) + 0.5, (double)((float)shooter.w), PlayerUtils.getTag(stack).n("silencer") ? this.silencerShootSound : this.shootSound, 1.5f, shooter.q.s.nextFloat() * 0.1f + 0.9f, false);
    }

    @SideOnly(value=Side.CLIENT)
    public void clientReload(of shooter, ye stack) {
        ClientTicker.soundPlayAtEntity(shooter, ((ItemWeapon)yc.g[stack.d]).reloadSound, 1.0f, 0.9f + shooter.q.s.nextFloat() * 0.1f, false);
    }

    public void shootRequest(uf player, int slot, boolean leftClick) {
        ye stack = player.bn.h();
        if (stack != null && stack.d == this.cv) {
            PlayerUtils.getInfo((uf)player).weaponInfo.onShoot(stack);
            this.shoot(player, stack, leftClick, !PlayerUtils.getTag(stack).n("silencer"));
            stack.a(1, (of)player);
            if (stack.b == 0 && player instanceof jv) {
                player.bz();
                ((jv)player).a(player.bo);
            }
        }
    }

    public void shoot(of shooter, ye stack, boolean leftClick, boolean hasFlash) {
        abw w2 = shooter.q;
        if (!w2.I) {
            ServerPacketSender.sendShoot(shooter, hasFlash);
            float yaw = shooter instanceof of ? shooter.aP : shooter.A;
            float pitch = shooter.B;
            if (leftClick) {
                yaw += (float)(Math.random() - 0.5) * 10.0f;
                pitch += (float)(Math.random() - 0.5) * 10.0f;
            }
            for (int bulletNumber = 0; bulletNumber < this.bulletsCount; ++bulletNumber) {
                EntityBullet bullet = new EntityBullet(shooter, this.damage, leftClick, this.spread, this.bulletSpeed, this.hitSound, this.damageFactor, yaw, pitch);
                w2.d(bullet);
                ServerPacketSender.sendRotation(bullet, bullet.A, bullet.B);
            }
        } else {
            this.clientShoot(shooter, stack, hasFlash);
        }
    }

    public void grenadeShootRequest(uf player, int slot) {
        if (this.grenadeId != 0 && player.bn.a(slot) != null && player.bn.a((int)slot).b().cv == this.cv && PlayerUtils.getInfo((uf)player).weaponInfo.canLaunchGrenade(this)) {
            PlayerUtils.getInfo((uf)player).weaponInfo.onGrenadeLaunch(this);
            if (yc.g[this.grenadeId] != null && yc.g[this.grenadeId] instanceof ItemGrenade) {
                ItemGrenade item = (ItemGrenade)yc.g[this.grenadeId];
                EntityGrenade grenade = new EntityGrenade(player.q, player, item.maxStartSpeed, item.explosionSize, item.modelName, item.textureName, item.lifetime, item.explosionOnCollide);
                player.q.d(grenade);
            }
        }
    }

    @Override
    public boolean a(ye par1ItemStack, uf par2EntityPlayer, abw par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
        return false;
    }

    @Override
    public boolean onLeftClickEntity(ye par1, uf par2, nn par3) {
        return true;
    }

    @Override
    public boolean onEntitySwing(of par1, ye par2) {
        return true;
    }

    @Override
    public float a(ye par1, aqz par2) {
        return 0.0f;
    }

    @Override
    public boolean a(ye par1, of par2, of par3) {
        return false;
    }

    @Override
    public boolean onItemUseFirst(ye par1, uf par2, abw par3, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
        return true;
    }

    @Override
    public boolean onBlockStartBreak(ye par1, int par2, int par3, int par4, uf par5) {
        return true;
    }

    @Override
    public void a(ye stack, uf par2EntityPlayer, List par3List, boolean par4) {
        by tag = PlayerUtils.getTag(stack);
        par3List.add("\u041f\u0430\u0442\u0440\u043e\u043d\u043e\u0432: " + tag.e("cage") + "/" + this.cageSize);
        if (tag.n("flashlight")) {
            par3List.add("\u0422\u0430\u043a\u0442\u0438\u0447\u0435\u0441\u043a\u0438\u0439 \u0444\u043e\u043d\u0430\u0440\u0438\u043a");
        }
        if (tag.n("silencer")) {
            par3List.add("\u0413\u043b\u0443\u0448\u0438\u0442\u0435\u043b\u044c");
        }
        if (tag.n("sight")) {
            par3List.add("\u041e\u043f\u0442\u0438\u0447\u0435\u0441\u043a\u0438\u0439 \u043f\u0440\u0438\u0446\u0435\u043b");
        }
        String[] fireModsName = new String[]{"\u0410\u0432\u0442\u043e\u043c\u0430\u0442", "\u041f\u043e\u043b\u0443-\u0430\u0432\u0442\u043e\u043c\u0430\u0442", "\u0411\u043e\u043b\u0442"};
        par3List.add("\u0420\u0435\u0436\u0438\u043c \u0441\u0442\u0440\u0435\u043b\u044c\u0431\u044b: " + fireModsName[tag.e("fireMode")]);
        par3List.addAll(this.description);
    }

    @Override
    public zj c_(ye par1ItemStack) {
        return zj.e;
    }

    @Override
    public boolean n_() {
        return true;
    }

    @Override
    public float getWeight(ye stack) {
        float weight = 0.0f;
        weight = WeightMap.itemsWeight.containsKey(this.cv) ? ((Float)WeightMap.itemsWeight.get(this.cv)).floatValue() : 5.0f;
        by tag = PlayerUtils.getTag(stack);
        if (tag.n("flashlight")) {
            weight += WeightMap.getWeight(StalkerMain.flashlight.cv);
        }
        if (tag.n("silencer")) {
            weight += WeightMap.getWeight(StalkerMain.silencer.cv);
        }
        if (tag.n("sight")) {
            weight += WeightMap.getWeight(StalkerMain.sight.cv);
        }
        return weight += (float)tag.e("cage") * WeightMap.getWeight(this.bulletId);
    }

    @Override
    public boolean canShine(ye stack) {
        return PlayerUtils.getTag(stack).n("flashlight");
    }

    @Override
    public boolean shouldRotateWhenSprinting() {
        return !this.isPistol;
    }

    public FireMode getFireMod(ye par1) {
        return this.fireMods[PlayerUtils.getTag(par1).e("fireMode")];
    }
}

