/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.GloomyHooks;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.AchievementList;
import org.lwjgl.opengl.GL11;

public class cebg
extends InventoryEffectRenderer {
    public float _f;
    public float _g;

    public cebg(EntityPlayer entityPlayer) {
        super(entityPlayer.inventoryContainer);
        this.allowUserInput = true;
        entityPlayer.addStat(AchievementList._f, 1);
    }

    @Override
    public void updateScreen() {
        if (GloomyHooks.getTrue()) {
            return;
        }
        super.updateScreen();
        if (this.mc._j._i()) {
            this.mc._a(new qngy(this.mc._t));
        }
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        if (this.mc._j._i()) {
            this.mc._a(new qngy(this.mc._t));
        } else {
            super.initGui();
        }
    }

    @Override
    public void drawGuiContainerForegroundLayer(int n, int n2) {
        this.fontRenderer._b(wpcz._a("container.crafting"), 86, 16, 0x404040);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
        this._f = n;
        this._g = n2;
    }

    @Override
    public void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._R()._a(field_110408_a);
        int n3 = this.guiLeft;
        int n4 = this.guiTop;
        this.drawTexturedModalRect(n3, n4, 0, 0, this.xSize, this.ySize);
        cebg._a(n3 + 51, n4 + 75, 30, (float)(n3 + 51) - this._f, (float)(n4 + 75 - 50) - this._g, this.mc._t);
    }

    public static void _a(int n, int n2, int n3, float f, float f2, EntityLivingBase entityLivingBase) {
        GL11.glEnable(2903);
        GL11.glPushMatrix();
        GL11.glTranslatef(n, n2, 50.0f);
        GL11.glScalef(-n3, n3, n3);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        float f3 = entityLivingBase.renderYawOffset;
        float f4 = entityLivingBase.rotationYaw;
        float f5 = entityLivingBase.rotationPitch;
        float f6 = entityLivingBase.prevRotationYawHead;
        float f7 = entityLivingBase.rotationYawHead;
        GL11.glRotatef(135.0f, 0.0f, 1.0f, 0.0f);
        qnon._b();
        GL11.glRotatef(-135.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-((float)Math.atan(f2 / 40.0f)) * 20.0f, 1.0f, 0.0f, 0.0f);
        entityLivingBase.renderYawOffset = (float)Math.atan(f / 40.0f) * 20.0f;
        entityLivingBase.rotationYaw = (float)Math.atan(f / 40.0f) * 40.0f;
        entityLivingBase.rotationPitch = -((float)Math.atan(f2 / 40.0f)) * 20.0f;
        entityLivingBase.rotationYawHead = entityLivingBase.rotationYaw;
        entityLivingBase.prevRotationYawHead = entityLivingBase.rotationYaw;
        GL11.glTranslatef(0.0f, entityLivingBase.yOffset, 0.0f);
        RenderManager._b._l = 180.0f;
        RenderManager._b._a(entityLivingBase, 0.0, 0.0, 0.0, 0.0f, 1.0f);
        entityLivingBase.renderYawOffset = f3;
        entityLivingBase.rotationYaw = f4;
        entityLivingBase.rotationPitch = f5;
        entityLivingBase.prevRotationYawHead = f6;
        entityLivingBase.rotationYawHead = f7;
        GL11.glPopMatrix();
        qnon._a();
        GL11.glDisable(32826);
        iwya._a(iwya._b);
        GL11.glDisable(3553);
        iwya._a(iwya._a);
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 0) {
            this.mc._a(new ohbq(this.mc._X));
        }
        if (guiButton.id == 1) {
            this.mc._a(new uzta(this, this.mc._X));
        }
    }
}

