/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  bjo
 *  org.lwjgl.opengl.GL11
 */
package ru.stalcraft.client.gui;

import org.lwjgl.opengl.GL11;
import ru.stalcraft.client.gui.GuiInventoryStalker;
import ru.stalcraft.client.network.ClientPacketSender;
import ru.stalcraft.inventory.ICustomContainer;
import ru.stalcraft.inventory.WeaponContainer;
import ru.stalcraft.items.ItemWeapon;
import ru.stalcraft.player.PlayerUtils;

public class GuiWeaponUpgrade
extends awy {
    public WeaponContainer container;
    public ICustomContainer customContainer;
    private static final int X_INV_SIZE = 227;
    private static final int Y_INV_SIZE = 181;
    public static final bjo commonUpgrade = new bjo("stalker", "textures/upgrade.png");
    public static final bjo backpackUpgrade = new bjo("stalker", "textures/upgrade_b.png");
    public static final bjo flashlightTexture = new bjo("stalker", "textures/flashlight.png");
    public static final bjo silencerTexture = new bjo("stalker", "textures/silencer.png");
    public static final bjo sightTexture = new bjo("stalker", "textures/sight.png");
    private aut backButton;
    private aut ammoExtractButton;

    public GuiWeaponUpgrade(WeaponContainer container) {
        super(container);
        this.container = container;
        this.customContainer = container;
    }

    @Override
    public void A_() {
        this.i.clear();
        this.c = 227;
        this.d = 181;
        this.p = this.g / 2 - this.c / 2;
        this.q = this.h / 2 - this.d / 2;
        this.backButton = new aut(5, this.g / 2 - 40, this.h / 2 + 95, 80, 20, "\u041d\u0430\u0437\u0430\u0434");
        this.ammoExtractButton = new aut(6, this.p + 28, this.q + 119, 73, 20, "\u0418\u0437\u0432\u043b\u0435\u0447\u044c \u043f\u0430\u0442\u0440\u043e\u043d\u044b");
        this.displayUpgradeButtons(this.container.updatedWeapon);
    }

    @Override
    protected void a(float par1, int par2, int par3) {
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glDisable((int)2896);
        if (this.customContainer.hasBackpack()) {
            atv.w().N.a(backpackUpgrade);
        } else {
            atv.w().N.a(commonUpgrade);
        }
        this.b(this.g / 2 - 113, this.h / 2 - 90, 0, 0, 227, 181);
        if (this.container.updatedWeapon != null) {
            ItemWeapon weapon = (ItemWeapon)this.container.updatedWeapon.b();
            if (weapon.flashlight) {
                atv.w().N.a(flashlightTexture);
                this.b(this.g / 2 - 113, this.h / 2 - 90, 0, 0, 227, 181);
            }
            if (weapon.sight) {
                atv.w().N.a(sightTexture);
                this.b(this.g / 2 - 113, this.h / 2 - 90, 0, 0, 227, 181);
            }
            if (weapon.silencer) {
                atv.w().N.a(silencerTexture);
                this.b(this.g / 2 - 113, this.h / 2 - 90, 0, 0, 227, 181);
            }
        }
    }

    @Override
    public void c() {
        super.c();
    }

    @Override
    protected void b(int par1, int par2) {
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glDisable((int)2896);
        this.b(atv.w().l, "\u0412\u0435\u0441: " + (int)this.container.info.getWeight() + "/" + (int)this.container.info.getMaxWeight() + " \u043a\u0433", 126, 159, 0xFFFFFF);
    }

    @Override
    protected void a(aut par1GuiButton) {
        super.a(par1GuiButton);
        if (par1GuiButton == this.ammoExtractButton) {
            ClientPacketSender.sendExtractAmmoRequest();
            this.ammoExtractButton.h = false;
        } else if (par1GuiButton == this.backButton) {
            atv.w().h.i();
            atv.w().a(new GuiInventoryStalker((uf)atv.w().h));
        }
    }

    public void displayUpgradeButtons(ye stack) {
        this.i.add(this.ammoExtractButton);
        this.i.add(this.backButton);
        this.ammoExtractButton.h = PlayerUtils.getTag(stack).e("cage") > 0;
    }
}

