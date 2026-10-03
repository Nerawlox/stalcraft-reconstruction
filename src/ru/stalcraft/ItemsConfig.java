/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.common.EnumHelper
 */
package ru.stalcraft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.regex.Pattern;
import net.minecraftforge.common.EnumHelper;
import ru.stalcraft.Logger;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.client.ClientProxy;
import ru.stalcraft.items.FireMode;
import ru.stalcraft.items.ItemArmorArtefakt;
import ru.stalcraft.items.ItemArtefakt;
import ru.stalcraft.items.ItemBullet;
import ru.stalcraft.items.ItemGrenade;
import ru.stalcraft.items.ItemWeapon;
import ru.stalcraft.proxy.IProxy;

public class ItemsConfig {
    private static HashSet sounds = new HashSet();
    private static HashMap items;
    private static int nextArmorId;
    private static int nextArmorRenderId;
    private static ArrayList zombieWeapons;
    private static Random rand;

    public static HashSet getSounds() {
        return sounds;
    }

    public static ye getRandomZombieWeapon() {
        return zombieWeapons.size() == 0 ? null : new ye((Integer)zombieWeapons.get(rand.nextInt(zombieWeapons.size())), 1, 0);
    }

    public static void readConfig() {
        try {
            BufferedReader e2 = new BufferedReader(new InputStreamReader(StalkerMain.class.getResourceAsStream("/assets/stalker/items.txt"), "UTF-8"));
            StringBuffer buffer = new StringBuffer();
            boolean flag = false;
            String weaponRegex = null;
            while (!flag) {
                weaponRegex = e2.readLine();
                if (weaponRegex == null) {
                    flag = true;
                    continue;
                }
                if ((weaponRegex = weaponRegex.trim()).startsWith("//")) continue;
                buffer.append(weaponRegex.split("//", 2)[0]);
            }
            Pattern var26 = Pattern.compile(".*weapon.*\\{.*");
            Pattern bulletRegex = Pattern.compile(".*bullet.*\\{.*");
            Pattern grenadeRegex = Pattern.compile(".*grenade.*\\{.*");
            Pattern artefaktRegex = Pattern.compile(".*artefakt.*\\{.*");
            Pattern armorRegex = Pattern.compile(".*armor.*\\{.*");
            String itemsSplitter = "\\{";
            String parSplitter = "[\\s]*;[\\s]*";
            String config = buffer.toString().replaceAll("\n|\r", "");
            String[] splitted = config.split("\\}");
            items = new HashMap();
            String[] parameters = null;
            int id = 0;
            int itemExtends = 0;
            String declaration = null;
            ItemType e22 = null;
            for (int e1 = 0; e1 < splitted.length; ++e1) {
                try {
                    if (var26.matcher(splitted[e1]).matches()) {
                        e22 = ItemType.WEAPON;
                    } else if (grenadeRegex.matcher(splitted[e1]).matches()) {
                        e22 = ItemType.GRENADE;
                    } else if (bulletRegex.matcher(splitted[e1]).matches()) {
                        e22 = ItemType.BULLET;
                    } else if (artefaktRegex.matcher(splitted[e1]).matches()) {
                        e22 = ItemType.ARTEFAKT;
                    } else if (armorRegex.matcher(splitted[e1]).matches()) {
                        e22 = ItemType.ARMOR;
                    } else {
                        Logger.console("Strange string: " + splitted[e1]);
                    }
                    declaration = splitted[e1].split(itemsSplitter)[0];
                    if (declaration.contains("extends")) {
                        try {
                            itemExtends = Integer.parseInt(declaration.split("extends")[1].trim());
                        }
                        catch (Exception var23) {
                            var23.printStackTrace();
                        }
                    }
                    parameters = splitted[e1].split(itemsSplitter)[1].split(parSplitter);
                    id = ItemsConfig.getInt(parameters, "item_id");
                    items.put(id, new ItemToAdd(id, itemExtends, e22, parameters));
                    continue;
                }
                catch (Exception var24) {
                    var24.printStackTrace();
                    Logger.console("Error item config \u2116= " + Integer.toString(e1) + " type=" + (Object)((Object)e22) + "!");
                }
            }
            Iterator var27 = items.entrySet().iterator();
            ItemToAdd var28 = null;
            while (var27.hasNext()) {
                var28 = (ItemToAdd)var27.next().getValue();
                try {
                    if (var28.type == ItemType.WEAPON) {
                        ItemsConfig.addWeapon(var28);
                        continue;
                    }
                    if (var28.type == ItemType.GRENADE) {
                        ItemsConfig.addGrenade(var28);
                        continue;
                    }
                    if (var28.type == ItemType.BULLET) {
                        ItemsConfig.addBullet(var28);
                        continue;
                    }
                    if (var28.type == ItemType.ARTEFAKT) {
                        ItemsConfig.addArtefakt(var28);
                        continue;
                    }
                    if (var28.type != ItemType.ARMOR) continue;
                    ItemsConfig.addArmor(var28);
                }
                catch (Exception var22) {
                    Logger.debug("Error occured during adding item " + var28.itemId);
                    var22.printStackTrace();
                }
            }
        }
        catch (Exception var25) {
            var25.printStackTrace();
        }
    }

    private static void addWeapon(ItemToAdd item) {
        int id = item.getInt("item_id");
        int bulletId = item.getInt("bullet_id");
        int cooldown = item.getInt("cooldown");
        int damage = item.getInt("damage");
        int cageSize = item.getInt("cage_size");
        int reloadTime = item.getInt("reload_time");
        int maxDamage = item.getInt("durability");
        float bulletSpeed = item.getFloat("bullet_speed");
        String name = item.getString("name");
        String textureName = item.getString("item_texture");
        String modelName = item.getString("model_name");
        ArrayList description = item.getList("description");
        String aimTexture = item.getString("aiming_texture");
        String shootSound = item.getString("shoot_sound");
        String hitSound = item.getString("hit_sound");
        String reloadSound = item.getString("reload_sound");
        String sleeveModel = item.getString("sleeve_model");
        String sleeveTexture = item.getString("sleeve_texture");
        int grenadeId = item.getInt("grenade_id");
        int grenadeCooldown = item.getInt("grenade_cooldown");
        boolean isPistol = item.getBoolean("is_pistol");
        boolean renderEquipped = item.getBoolean("render_equipped");
        float lightDistance = item.getFloat("light_distance");
        float lightSize = item.getFloat("light_size");
        float zoom = Math.max(1.0f, item.getFloat("zoom"));
        float aimX = item.getFloat("aimRotation");
        float aimY = item.getFloat("aimPosY");
        float aimZ = item.getFloat("aimPosZ");
        float posX = item.getFloat("posX");
        float posY = item.getFloat("posY");
        float posZ = item.getFloat("posZ");
        float recoil = item.getFloat("recoil");
        float spread = item.getFloat("spread");
        int bulletsCount = item.getInt("bullets_count");
        String modelTexture = item.getString("model_texture");
        boolean canBeUsedByZombie = item.getBoolean("can_be_used_by_zombie");
        boolean flashlight = item.getBoolean("flashlight");
        boolean silencer = item.getBoolean("silencer");
        boolean sight = item.getBoolean("sight");
        String silencerShoootSound = item.getString("silencer_shoot_sound");
        String sightAimingTexture = item.getString("sight_aiming_texture");
        float sightZoom = item.getFloat("sight_zoom");
        int halfLife = item.getInt("half-life");
        int[] fireModsArray = item.getIntArray("fire_mods");
        FireMode[] fireMods = new FireMode[]{FireMode.AUTO};
        if (fireModsArray.length > 0) {
            fireMods = new FireMode[fireModsArray.length];
            for (int i2 = 0; i2 < fireModsArray.length; ++i2) {
                fireMods[i2] = FireMode.values()[fireModsArray[i2]];
            }
        }
        if (canBeUsedByZombie) {
            zombieWeapons.add(id);
        }
        sounds.add(shootSound);
        if (silencerShoootSound != null && !silencerShoootSound.isEmpty()) {
            sounds.add(silencerShoootSound);
        }
        sounds.add(hitSound);
        sounds.add(reloadSound);
        ItemWeapon weapon = new ItemWeapon(id, bulletId, fireMods, cooldown, damage, cageSize, reloadTime, maxDamage, bulletSpeed, name, textureName, modelName, modelTexture, description, aimTexture, shootSound, hitSound, reloadSound, sleeveModel, sleeveTexture, grenadeId, grenadeCooldown, isPistol, renderEquipped, bulletsCount, lightDistance, lightSize, zoom, recoil, spread, aimX, aimY, aimZ, posX, posY, posZ, flashlight, silencer, sight, silencerShoootSound, sightAimingTexture, sightZoom, halfLife);
        IProxy proxy = StalkerMain.getProxy();
        if (proxy.isRemote()) {
            ((ClientProxy)proxy).registerWeaponRenderer(weapon);
        }
    }

    private static void addBullet(ItemToAdd item) {
        int id = item.getInt("item_id");
        String name = item.getString("name");
        String textureName = item.getString("item_texture");
        ArrayList description = item.getList("description");
        int stackSize = item.getInt("stack_size");
        new ItemBullet(id, name, textureName, description, stackSize);
    }

    private static void addGrenade(ItemToAdd item) {
        int id = item.getInt("item_id");
        String name = item.getString("name");
        String modelName = item.getString("model_name");
        String modelTexture = item.getString("model_texture");
        String textureName = item.getString("item_texture");
        ArrayList description = item.getList("description");
        float explosionSize = item.getFloat("explosion_size");
        float maxStartSpeed = item.getFloat("max_start_speed");
        boolean handUse = item.getBoolean("hand_use");
        int lifetime = item.getInt("lifetime");
        boolean collideExplosion = item.getBoolean("explosion_on_collide");
        new ItemGrenade(id, name, modelName, modelTexture, textureName, description, explosionSize, maxStartSpeed, handUse, lifetime, collideExplosion);
    }

    private static void addArtefakt(ItemToAdd item) {
        int id = item.getInt("item_id");
        String name = item.getString("name");
        String textureName = item.getString("item_texture");
        ArrayList description = item.getList("description");
        int radiationProtection = item.getInt("radiation_protection");
        int chemicalProtection = item.getInt("chemical_protection");
        int biologicalProtection = item.getInt("biological_protection");
        boolean radiationImmunity = item.getBoolean("radiation_immunity");
        boolean chemicalImmunity = item.getBoolean("chemical_immunity");
        boolean biologicalImmunity = item.getBoolean("biological_immunity");
        boolean psychoImmunity = item.getBoolean("pchycho_immunity");
        float speedFactor = item.getFloat("speed_factor");
        float bulletDamageFactor = item.getFloat("bullet_damage_factor");
        float jumpIncrease = item.getFloat("jump_increase");
        boolean fireResistance = item.getBoolean("fire_resistance");
        boolean waterWalking = item.getBoolean("water_walking");
        int fall_protection = item.getInt("fall_protection");
        new ItemArtefakt(id, name, textureName, description, new int[]{radiationProtection, chemicalProtection, biologicalProtection, 0}, new boolean[]{radiationImmunity, chemicalImmunity, biologicalImmunity, psychoImmunity}, speedFactor, bulletDamageFactor, jumpIncrease, fireResistance, waterWalking, fall_protection);
    }

    private static void addArmor(ItemToAdd item) {
        int id = item.getInt("item_id");
        String name = item.getString("name");
        String setId = item.getString("set_id");
        String textureName = item.getString("item_texture");
        String modelTexture = item.getString("armor_texture");
        String specialModel = item.getString("special_model");
        String extension = item.getString("extension");
        int durability = item.getInt("durability");
        int defence = item.getInt("defence");
        int slot = item.getInt("armor_slot");
        ArrayList description = item.getList("description");
        int radiationProtection = item.getInt("radiation_protection");
        int chemicalProtection = item.getInt("chemical_protection");
        int biologicalProtection = item.getInt("biological_protection");
        boolean radiationImmunity = item.getBoolean("radiation_immunity");
        boolean chemicalImmunity = item.getBoolean("chemical_immunity");
        boolean biologicalImmunity = item.getBoolean("biological_immunity");
        boolean psychoImmunity = item.getBoolean("pchycho_immunity");
        float bulletDamageFactor = item.getFloat("bullet_damage_factor");
        float jumpIncrease = item.getFloat("jump_increase");
        boolean fireResistance = item.getBoolean("fire_resistance");
        boolean waterWalking = item.getBoolean("water_walking");
        int fall_protection = item.getInt("fall_protection");
        wj material = EnumHelper.addArmorMaterial((String)("STALKERSET" + ++nextArmorId), (int)durability, (int[])new int[]{defence, defence, defence, defence}, (int)15);
        new ItemArmorArtefakt(id, slot, material, textureName, modelTexture, specialModel, extension, name, description, setId, new int[]{radiationProtection, chemicalProtection, biologicalProtection, 0}, new boolean[]{radiationImmunity, chemicalImmunity, biologicalImmunity, psychoImmunity}, 1.0f, bulletDamageFactor, jumpIncrease, fireResistance, waterWalking, fall_protection);
    }

    private static void addBlock(ItemToAdd item) {
        int id = item.getInt("item_id");
        String name = item.getString("name");
        String textureName = item.getString("texture_name");
        String block_model = item.getString("special_model");
        float minX = item.getFloat("min_x");
        float minY = item.getFloat("min_y");
        float minZ = item.getFloat("min_z");
        float maxX = item.getFloat("max_x");
        float maxY = item.getFloat("max_y");
        float maxZ = item.getFloat("max_z");
        boolean rotation = item.getBoolean("rotation");
        boolean collision = item.getBoolean("collision");
        float hardness = item.getFloat("hardness");
    }

    private static int getInt(String[] parameters, String name) {
        String str = ItemsConfig.getParStr(parameters, name);
        return str == null ? 0 : Integer.parseInt(str.split(":")[1].trim());
    }

    private static String getParStr(String[] parameters, String name) {
        for (int i$ = 0; i$ < parameters.length; ++i$) {
            if (!parameters[i$].startsWith(name + ":")) continue;
            return parameters[i$];
        }
        return null;
    }

    static {
        nextArmorId = 0;
        nextArmorRenderId = 125;
        zombieWeapons = new ArrayList();
        rand = new Random();
    }

    private static enum ItemType {
        WEAPON("WEAPON", 0),
        BULLET("BULLET", 1),
        GRENADE("GRENADE", 2),
        ARTEFAKT("ARTEFAKT", 3),
        ARMOR("ARMOR", 4),
        BLOCK("BLOCK", 5);

        private static final ItemType[] $VALUES;

        private ItemType(String var1, int var2) {
        }

        static {
            $VALUES = new ItemType[]{WEAPON, BULLET, GRENADE, ARTEFAKT, ARMOR, BLOCK};
        }
    }

    private static class ItemToAdd {
        public String[] parameters;
        public int itemExtends;
        public int itemId;
        public ItemType type;

        public ItemToAdd(int itemId, int itemExtends, ItemType type, String[] parameters) {
            this.itemId = itemId;
            this.itemExtends = itemExtends;
            this.parameters = parameters;
            this.type = type;
        }

        private String getParStr(String name) {
            for (int i2 = 0; i2 < this.parameters.length; ++i2) {
                if (!this.parameters[i2].startsWith(name + ":")) continue;
                return this.parameters[i2];
            }
            if (this.itemExtends != 0 && items.containsKey(this.itemExtends)) {
                return ((ItemToAdd)items.get(this.itemExtends)).getParStr(name);
            }
            return null;
        }

        public ArrayList getList(String name) {
            ArrayList<String> list = new ArrayList<String>();
            String descriptionStr = this.getString(name);
            if (!descriptionStr.isEmpty()) {
                String[] descriptionArray = descriptionStr.split("@");
                for (int i2 = 0; i2 < descriptionArray.length; ++i2) {
                    list.add(descriptionArray[i2]);
                }
            }
            return list;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public int[] getIntArray(String name) {
            ArrayList list = new ArrayList();
            String descriptionStr = this.getString(name);
            int[] array = new int[]{};
            if (descriptionStr.isEmpty()) return array;
            String[] descriptionArray = descriptionStr.split(", ");
            if (descriptionArray.length > 0) {
                array = new int[descriptionArray.length];
                int i2 = 0;
                while (i2 < descriptionArray.length) {
                    array[i2] = Integer.parseInt(descriptionArray[i2]);
                    ++i2;
                }
                return array;
            }
            int value = 0;
            try {
                value = Integer.parseInt(descriptionArray[0]);
            }
            catch (Exception e2) {
                try {
                    e2.printStackTrace();
                }
                catch (Throwable throwable) {
                    array = new int[]{value};
                    throw throwable;
                }
                return new int[]{value};
            }
            return new int[]{value};
        }

        public int getInt(String name) {
            String str = this.getParStr(name);
            return str == null ? 0 : Integer.parseInt(str.split(":")[1].trim());
        }

        public String getString(String name) {
            String str = this.getParStr(name);
            if (str == null) {
                return "";
            }
            String value = str.split(":", 2)[1].trim();
            if (value.equals("\"\"")) {
                return "";
            }
            return value.substring(value.indexOf("\"") + 1, value.lastIndexOf("\"")).trim();
        }

        public boolean getBoolean(String name) {
            String str = this.getParStr(name);
            return str == null ? false : str.split(":", 2)[1].trim().equals("true");
        }

        public float getFloat(String name) {
            String str = this.getParStr(name);
            return str == null ? 0.0f : Float.parseFloat(str.split(":")[1].replace(",", ".").trim());
        }
    }
}

