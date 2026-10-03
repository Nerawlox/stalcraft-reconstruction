/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bdi
 *  blm
 *  cpw.mods.fml.common.IScheduledTickHandler
 *  cpw.mods.fml.common.TickType
 *  cpw.mods.fml.relauncher.ReflectionHelper
 *  org.lwjgl.input.Mouse
 *  paulscode.sound.SoundSystem
 */
package ru.stalcraft.client;

import cpw.mods.fml.common.IScheduledTickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.relauncher.ReflectionHelper;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import org.lwjgl.input.Mouse;
import paulscode.sound.SoundSystem;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.blocks.BlockAnomaly;
import ru.stalcraft.client.ClientProxy;
import ru.stalcraft.client.gui.GuiSettingsStalker;
import ru.stalcraft.client.network.ClientPacketSender;
import ru.stalcraft.inventory.StalkerInventory;
import ru.stalcraft.items.ItemDetector;
import ru.stalcraft.items.ItemWeapon;
import ru.stalcraft.player.PlayerInfo;
import ru.stalcraft.player.PlayerUtils;

public class ClientTicker
implements IScheduledTickHandler {
    public static Thread mainThread;
    public static long tickId;
    public atv mc;
    private static List playSoundsAtEntity;
    private String[] sounds = new String[3];
    private float[] levels = new float[3];
    public int savedcurrentitem = 0;
    private int soundTickId = 0;
    private static int latestSoundID;
    public boolean firstrun = true;
    private boolean wasIngame = false;
    private boolean startedSounds;
    private boolean hasUpMouse;
    private boolean hasOpenedOtherInventory;
    private boolean wasInCreative;

    public ClientTicker() {
        tickId = 1L;
        playSoundsAtEntity = new ArrayList();
        this.mc = atv.w();
    }

    public void tickStart(EnumSet type, Object ... tickData) {
        Iterator iterator = null;
        this.mc.u.ak = 0.0f;
        ClientProxy clientProxy = (ClientProxy)StalkerMain.getProxy();
        if (this.firstrun) {
            clientProxy.replaceGuiIngame();
            this.firstrun = false;
        }
        try {
            this.soundTick();
        }
        catch (Exception var8) {
            var8.printStackTrace();
        }
        if (this.mc.A) {
            try {
                if (GuiSettingsStalker.autoReload) {
                    bdi var9 = atv.w().h;
                    PlayerInfo player = PlayerUtils.getInfo((uf)var9);
                    if (var9.bn.h() != null && var9.bn.h().b() instanceof ItemWeapon) {
                        ItemWeapon weapon = (ItemWeapon)var9.bn.h().b();
                        if (PlayerUtils.getTag(var9.bn.h()).e("cage") == 0 && PlayerUtils.hasItem((uf)var9, weapon.bulletId) && var9.bn.h() != null && !player.weaponInfo.isReloading(var9.bn.h())) {
                            ClientPacketSender.sendReloadRequest();
                        }
                    }
                }
            }
            catch (Exception var7) {
                var7.printStackTrace();
            }
        }
        if (ClientProxy.isGameRunning()) {
            iterator = this.mc.f.h.iterator();
            while (iterator.hasNext()) {
                PlayerUtils.getInfo((uf)iterator.next()).onUpdate();
            }
            if (clientProxy.getEjectionManager() != null) {
                clientProxy.getEjectionManager().tick();
            }
            if (ClientProxy.shootLights != null) {
                ClientProxy.shootLights.tick();
            }
        }
        if (this.mc.h != null && PlayerUtils.getInfo((uf)this.mc.h).weaponInfo.currentGun != null && Mouse.isButtonDown((int)0)) {
            StalkerMain.machineGun.a(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            StalkerMain.machineGun.a(0.25f, 0.0f, 0.25f, 0.75f, 0.6f, 0.75f);
        }
        if (this.mc.h != null && this.mc.h.bG.d != this.wasInCreative) {
            this.wasInCreative = this.mc.h.bG.d;
            for (int var11 = 0; var11 < BlockAnomaly.anomalies.size(); ++var11) {
                aqz.s[(Integer)BlockAnomaly.anomalies.get(var11)].a(0.0f, 0.0f, 0.0f, this.wasInCreative ? 1.0f : 0.0f, this.wasInCreative ? 1.0f : 0.0f, this.wasInCreative ? 1.0f : 0.0f);
            }
        }
    }

    public void tickEnd(EnumSet type, Object ... tickData) {
    }

    public EnumSet ticks() {
        return EnumSet.of(TickType.CLIENT);
    }

    public String getLabel() {
        return "StalkerClientTicker";
    }

    private void mouseTick() {
        atv mc = atv.w();
        boolean isMouseDown = Mouse.isButtonDown((int)0);
        this.wasIngame = mc.A;
    }

    private void soundTick() {
        block8: {
            SoundSystem sndSystem;
            block6: {
                block9: {
                    block7: {
                        Iterator it2 = playSoundsAtEntity.iterator();
                        sndSystem = this.mc.v.b;
                        if (this.mc.f != null && playSoundsAtEntity.size() > 0) {
                            nn entity = null;
                            String soundId = null;
                            String[] info = null;
                            float volume = 0.0f;
                            while (it2.hasNext()) {
                                soundId = (String)it2.next();
                                info = soundId.split("_");
                                entity = this.mc.f.a(Integer.parseInt(info[1]));
                                volume = Float.parseFloat(info[2]);
                                if (entity == null) continue;
                                if (sndSystem.playing(soundId)) {
                                    sndSystem.setPosition(soundId, (float)entity.u, (float)entity.v, (float)entity.w);
                                    sndSystem.setVelocity(soundId, (float)entity.x, (float)entity.y, (float)entity.z);
                                    sndSystem.setVolume(soundId, volume * this.mc.u.b);
                                    continue;
                                }
                                it2.remove();
                            }
                        }
                        if (this.mc.h == null) break block6;
                        ++this.soundTickId;
                        if (this.soundTickId > 2) {
                            this.soundTickId = 0;
                        }
                        if (this.soundTickId != 0) break block7;
                        this.updateSound("radiation", (ItemDetector)StalkerMain.radiationDetector, 0);
                        break block8;
                    }
                    if (this.soundTickId != 1) break block9;
                    this.updateSound("chemical", (ItemDetector)StalkerMain.chemicalDetector, 1);
                    break block8;
                }
                if (this.soundTickId != 2) break block8;
                this.updateSound("biological", (ItemDetector)StalkerMain.biologicalDetector, 2);
                break block8;
            }
            for (int i2 = 0; i2 < this.sounds.length; ++i2) {
                if (this.sounds[i2] != null) {
                    sndSystem.stop(this.sounds[i2]);
                    this.sounds[i2] = null;
                }
                this.levels[i2] = 0.0f;
            }
        }
    }

    private void updateSound(String name, ItemDetector detector, int id) {
        bln m2 = this.mc.v;
        SoundSystem sndSystem = this.mc.v.b;
        bdi p2 = this.mc.h;
        StalkerInventory inv = PlayerUtils.getInfo((uf)p2).stInv;
        if (!(inv.mainInventory[5] != null && inv.mainInventory[5].b() == detector || inv.mainInventory[6] != null && inv.mainInventory[6].b() == detector || inv.mainInventory[7] != null && inv.mainInventory[7].b() == detector)) {
            if (this.sounds[id] != null) {
                this.levels[id] = 0.0f;
                sndSystem.stop(this.sounds[id]);
                this.sounds[id] = null;
            }
        } else {
            float currentLevel = detector.detectLevel(p2.q, p2.u, p2.v + (double)p2.f(), p2.w);
            if (this.sounds[id] != null && currentLevel == 0.0f) {
                sndSystem.stop(this.sounds[id]);
                this.sounds[id] = null;
            } else if (this.sounds[id] == null && currentLevel > 0.0f) {
                int latestSoundID = (Integer)ReflectionHelper.getPrivateValue(bln.class, (Object)atv.w().v, (String[])new String[]{"latestSoundID", "field_77378_e", "g"});
                this.sounds[id] = "sound_" + (latestSoundID + 1) % 256;
                m2.a("stalker:" + name, currentLevel, 1.0f);
                m2.b.setLooping(this.sounds[id], true);
                m2.b.setVolume(this.sounds[id], currentLevel * this.mc.u.b);
            } else if (this.sounds[id] != null) {
                m2.b.setVolume(this.sounds[id], currentLevel * this.mc.u.b);
            }
            this.levels[id] = currentLevel;
        }
    }

    public int nextTickSpacing() {
        return 1;
    }

    public static void soundPlayAtEntity(nn entity, String soundName, float volume, float pitch, boolean piority) {
        atv mc = atv.w();
        if (mc.v.c && mc.u.b != 0.0f && entity != null && soundName != null && !soundName.isEmpty()) {
            latestSoundID = (latestSoundID + 1) % 256;
            String s1 = "sound" + latestSoundID + "_" + entity.k + "_" + volume;
            blm soundpoolentry = mc.v.d.b(soundName);
            if (soundpoolentry != null && volume > 0.0f) {
                float f2 = 16.0f;
                if (volume > 1.0f) {
                    f2 *= volume;
                }
                mc.v.b.newSource(piority, s1, soundpoolentry.b(), soundpoolentry.a(), false, (float)entity.u, (float)entity.v, (float)entity.w, 2, f2);
                mc.v.b.setPitch(s1, pitch);
                if (volume > 1.0f) {
                    volume = 1.0f;
                }
                mc.v.b.setVolume(s1, volume * mc.u.b);
                mc.v.b.setVelocity(s1, (float)entity.x, (float)entity.y, (float)entity.z);
                mc.v.b.play(s1);
                playSoundsAtEntity.add(s1);
            }
        }
    }
}

