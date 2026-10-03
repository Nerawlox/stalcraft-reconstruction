/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.screens;

import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.effects.client.main.jxtc;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.util.vector.Vector2f;

public class GuiScreenRadial
extends GuiScreenAdvanced
implements owwh {
    private static jxtc shader = jxtc._a("gloomycore", "radial_gui");
    public int activeSector = -1;
    public final int downSector;
    public int numSectors;
    public boolean canDeselect = true;
    private long activeTimerTick = 0L;
    private int prevActiveSector = -1;

    public GuiScreenRadial(int n, int n2) {
        super(new GuiRendererBuilder().setFontRenderer(ExternalFont.tahoma14).create());
        this.downSector = n;
        this.numSectors = n2;
        this.allowUserInput = true;
    }

    @Override
    public void initGui() {
        super.initGui();
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
        shader._e();
        float f2 = n * 2 - this.mc._n / 2;
        float f3 = n2 * 2 - this.mc._o / 2;
        double d = Math.atan2(f3, f2);
        double d2 = (d + Math.PI + 5.497787143782138) / (Math.PI * 2) % 1.0;
        Vector2f vector2f = new Vector2f(f2, f3);
        int n3 = this.activeSector;
        if (vector2f.length() > 128.0f) {
            n3 = (int)(d2 * (double)this.numSectors);
        } else if (this.canDeselect) {
            n3 = -1;
        }
        if (n3 != this.activeSector) {
            this.prevActiveSector = this.activeSector;
            this.activeSector = n3;
            this.activeTimerTick = ntte._b;
        }
        shader._a("resolution", (float)this.mc._n, (float)this.mc._o);
        shader._a("numSectors", (float)this.numSectors);
        shader._a("activeSector", this.activeSector);
        shader._a("activeTimer", (float)(ntte._b - this.activeTimerTick) + f);
        shader._a("prevActiveSector", this.prevActiveSector);
        GuiScreenRadial.drawRect(this.width / 2 - 256, this.height / 2 - 256, this.width / 2 + 256, this.height / 2 + 256, -1);
        GL20.glUseProgram(0);
        double d3 = 235.0;
        GL11.glEnable(3042);
        for (int i = 0; i < this.numSectors; ++i) {
            double d4 = ((double)i + 0.5) * Math.PI * 2.0 / (double)this.numSectors + Math.PI + 0.7853981633974483;
            int n4 = (int)(Math.cos(d4) * d3);
            int n5 = (int)(Math.sin(d4) * d3);
            this.drawIcon(i, this.screenWidth / 2 + n4, this.screenHeight / 2 + n5);
        }
        if (this.activeSector >= 0) {
            this.drawIcon(this.activeSector, this.screenWidth / 2, this.screenHeight / 2);
            GL11.glDisable(2896);
            this.renderer.getFontRenderer().renderCenteredString(this.getSelectedTitle(this.activeSector), this.width / 2, this.height / 2 + 21, 0xFFFFFF, true);
        }
    }

    @Override
    public void updateScreen() {
        if (this.downSector >= 0 && !Keyboard.isKeyDown(this.downSector)) {
            if (this.activeSector >= 0) {
                this.runAction(this.activeSector);
            }
            this.closeScreen();
        }
    }

    @Override
    public void handleKeyboardInput() {
        this._a();
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) {
        if (this.activeSector >= 0) {
            this.runAction(this.activeSector);
        }
        this.closeScreen();
    }

    protected String getSelectedTitle(int n) {
        return "";
    }

    protected void drawIcon(int n, int n2, int n3) {
    }

    protected void runAction(int n) {
    }
}

