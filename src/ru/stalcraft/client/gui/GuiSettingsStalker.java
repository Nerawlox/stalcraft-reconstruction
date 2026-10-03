/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  awk
 */
package ru.stalcraft.client.gui;

import ru.stalcraft.StalkerMain;
import ru.stalcraft.client.ClientProxy;
import ru.stalcraft.client.effects.EffectsEngine;

public class GuiSettingsStalker
extends awe {
    public static boolean useWeaponModels = true;
    public static boolean renderSleeves = true;
    public static boolean autoReload = true;
    public static boolean renderEquippedWeapons = true;
    public static boolean dynamicLights = true;
    public static boolean highRenderDistance = true;
    public static boolean shaderRendering = true;
    public static int particleRenderDistance = 64;
    public static boolean advancedShot = true;
    private awe parentGuiScreen;
    protected String screenTitle = "S.T.A.L.K.E.R. - \u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438";
    private aut weaponModelsButton;
    private aut renderSleevesButton;
    private aut autoReloadButton;
    private aut renderEquippedWeaponsButton;
    private aut useFlahslightButton;
    private aut entityRenderDistance;
    private aut shaderRenderingBtn;
    private aut advancedShotBtn;
    private awk particleRenderDistanceSlider;

    public GuiSettingsStalker(awe par1GuiScreen) {
        this.parentGuiScreen = par1GuiScreen;
    }

    @Override
    public void A_() {
        this.i.clear();
        this.i.add(new aut(0, this.g / 2 - 100, this.h / 6 + 168, 200, 20, "\u0413\u043e\u0442\u043e\u0432\u043e"));
        this.weaponModelsButton = new aut(1, this.g / 2 - 152, this.h / 6, 150, 20, "");
        this.renderSleevesButton = new aut(2, this.g / 2 + 2, this.h / 6, 150, 20, "");
        this.autoReloadButton = new aut(3, this.g / 2 - 152, this.h / 6 + 24, 150, 20, "");
        this.renderEquippedWeaponsButton = new aut(4, this.g / 2 + 2, this.h / 6 + 24, 150, 20, "");
        this.useFlahslightButton = new aut(5, this.g / 2 - 152, this.h / 6 + 48, 150, 20, "");
        this.entityRenderDistance = new aut(6, this.g / 2 + 2, this.h / 6 + 48, 150, 20, "");
        this.shaderRenderingBtn = new aut(7, this.g / 2 - 152, this.h / 6 + 72, 150, 20, "");
        this.advancedShotBtn = new aut(8, this.g / 2 + 2, this.h / 6 + 72, 150, 20, "");
        this.i.add(this.weaponModelsButton);
        this.i.add(this.renderSleevesButton);
        this.i.add(this.autoReloadButton);
        this.i.add(this.renderEquippedWeaponsButton);
        this.i.add(this.useFlahslightButton);
        this.i.add(this.entityRenderDistance);
        this.i.add(this.shaderRenderingBtn);
        this.i.add(this.advancedShotBtn);
        this.updateButtonNames();
    }

    private void updateButtonNames() {
        this.weaponModelsButton.f = "3D \u043c\u043e\u0434\u0435\u043b\u0438: " + (useWeaponModels ? "\u0432\u043a\u043b." : "\u0432\u044b\u043a\u043b.");
        this.renderSleevesButton.f = "\u0413\u0438\u043b\u044c\u0437\u044b: " + (renderSleeves ? "\u0432\u043a\u043b." : "\u0432\u044b\u043a\u043b.");
        this.autoReloadButton.f = "\u0410\u0432\u0442\u043e\u043f\u0435\u0440\u0435\u0437\u0430\u0440\u044f\u0434\u043a\u0430: " + (autoReload ? "\u0432\u043a\u043b." : "\u0432\u044b\u043a\u043b.");
        this.renderEquippedWeaponsButton.f = "\u041e\u0440\u0443\u0436\u0438\u0435 \u043d\u0430 \u0441\u043f\u0438\u043d\u0435: " + (renderEquippedWeapons ? "\u0432\u043a\u043b." : "\u0432\u044b\u043a\u043b.");
        this.useFlahslightButton.f = "\u0414\u0438\u043d\u0430\u043c\u0438\u0447\u0435\u0441\u043a\u043e\u0435 \u043e\u0441\u0432\u0435\u0449\u0435\u043d\u0438\u0435: " + (dynamicLights ? "\u0432\u043a\u043b." : "\u0432\u044b\u043a\u043b.");
        this.entityRenderDistance.f = "\u0414\u0430\u043b\u044c\u043d\u044f\u044f \u043f\u0440\u043e\u0440\u0438\u0441\u043e\u0432\u043a\u0430 \u0441\u0443\u0449\u043d\u043e\u0441\u0442\u0435\u0439: " + (highRenderDistance ? "\u0432\u043a\u043b." : "\u0432\u044b\u043a\u043b.");
        this.shaderRenderingBtn.f = "\u0428\u0435\u0439\u0434\u0435\u0440\u044b \u0447\u0430\u0441\u0442\u0438\u0446: " + (shaderRendering ? "\u0432\u043a\u043b." : "\u0432\u044b\u043a\u043b.");
        this.advancedShotBtn.f = "\u0423\u043b\u0443\u0447\u0448\u0435\u043d\u043d\u0430\u044f \u0432\u0441\u043f\u044b\u0448\u043a\u0430: " + (advancedShot ? "\u0432\u043a\u043b." : "\u0432\u044b\u043a\u043b.");
    }

    @Override
    protected void a(aut btn) {
        if (btn.g == 1) {
            useWeaponModels = !useWeaponModels;
        } else if (btn.g == 2) {
            renderSleeves = !renderSleeves;
        } else if (btn.g == 3) {
            autoReload = !autoReload;
        } else if (btn.g == 4) {
            renderEquippedWeapons = !renderEquippedWeapons;
        } else if (btn.g == 5) {
            dynamicLights = !dynamicLights;
        } else if (btn.g == 6) {
            boolean bl2 = highRenderDistance = !highRenderDistance;
            if (atv.w().f != null) {
                for (nn entity : atv.w().f.e) {
                    if (!(entity instanceof of)) continue;
                    entity.l = highRenderDistance ? 10000.0 : 1.0;
                }
            }
        } else if (btn.g == 7) {
            EffectsEngine.instance.shouldUseShaders = shaderRendering = !shaderRendering;
        } else if (btn.g == 8) {
            advancedShot = !advancedShot;
        }
        this.updateButtonNames();
        ClientProxy par1 = (ClientProxy)StalkerMain.getProxy();
        ClientProxy.mcconfig.get("general", "use_weapons_models", true).set(useWeaponModels);
        ClientProxy.mcconfig.get("general", "render_sleeves", true).set(renderSleeves);
        ClientProxy.mcconfig.get("general", "auto_reload", true).set(autoReload);
        ClientProxy.mcconfig.get("general", "render_equipped_items", true).set(renderEquippedWeapons);
        ClientProxy.mcconfig.get("general", "use_flashlight", true).set(dynamicLights);
        ClientProxy.mcconfig.get("general", "high_render_distance", true).set(highRenderDistance);
        ClientProxy.mcconfig.get("general", "shader_rendering", true).set(shaderRendering);
        ClientProxy.mcconfig.get("general", "advanced_shot", true).set(advancedShot);
        ClientProxy.mcconfig.get("general", "particle_render_distance", 64).set(particleRenderDistance);
        ClientProxy.mcconfig.save();
        if (btn.g == 0) {
            this.f.a(this.parentGuiScreen);
        }
    }

    @Override
    public void a(int par1, int par2, float par3) {
        this.e();
        super.a(par1, par2, par3);
    }
}

