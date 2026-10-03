/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.Point;
import mods.pda.client.minimap.MapCanvas;
import noppes.npcs.DataAI;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.ITextfieldListener;
import noppes.npcs.client.gui.util.SubGuiInterface;
import noppes.npcs.constants.EnumAnimation;
import noppes.npcs.constants.EnumMovingType;
import noppes.npcs.constants.EnumStandingType;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

public class SubGuiNpcMovement
extends SubGuiInterface
implements MapCanvas.MapRenderer,
ITextfieldListener {
    private DataAI ai;
    private MapCanvas map;
    private boolean mapDragging = false;

    public SubGuiNpcMovement(DataAI dataAI) {
        this.ai = dataAI;
        this.setBackground("menubg.png");
        this.xSize = 256;
        this.ySize = 216;
        this.closeOnEsc = true;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.addLabel(new GuiNpcLabel(0, "Moving type", this.guiLeft + 4, this.guiTop + 9, 0x404040));
        this.addButton(new GuiNpcButton(0, this.guiLeft + 80, this.guiTop + 4, 100, 20, EnumMovingType.names(), this.ai.movingType.ordinal()));
        if (this.ai.movingType == EnumMovingType.Wandering) {
            this.addLabel(new GuiNpcLabel(4, "Walking range", this.guiLeft + 4, this.guiTop + 31, 0x404040));
            this.addTextField(new GuiNpcTextField(4, this, this.field_73886_k, this.guiLeft + 100, this.guiTop + 26, 40, 20, this.ai.walkingRange + ""));
            this.getTextField((int)4).numbersOnly = true;
            this.getTextField(4).setMinMaxDefault(0, 1000, 5);
        } else if (this.ai.movingType == EnumMovingType.Standing) {
            this.addLabel(new GuiNpcLabel(7, "Position Offset X:", this.guiLeft + 4, this.guiTop + 31, 0x404040));
            this.addTextField(new GuiNpcTextField(7, this, this.field_73886_k, this.guiLeft + 99, this.guiTop + 26, 24, 20, (int)this.ai.bodyOffsetX + ""));
            this.getTextField((int)7).numbersOnly = true;
            this.getTextField(7).setMinMaxDefault(0, 10, 5);
            this.addLabel(new GuiNpcLabel(8, "Y:", this.guiLeft + 125, this.guiTop + 31, 0x404040));
            this.addTextField(new GuiNpcTextField(8, this, this.field_73886_k, this.guiLeft + 135, this.guiTop + 26, 24, 20, (int)this.ai.bodyOffsetY + ""));
            this.getTextField((int)8).numbersOnly = true;
            this.getTextField(8).setMinMaxDefault(0, 10, 5);
            this.addLabel(new GuiNpcLabel(9, "Z:", this.guiLeft + 161, this.guiTop + 31, 0x404040));
            this.addTextField(new GuiNpcTextField(9, this, this.field_73886_k, this.guiLeft + 171, this.guiTop + 26, 24, 20, (int)this.ai.bodyOffsetZ + ""));
            this.getTextField((int)9).numbersOnly = true;
            this.getTextField(9).setMinMaxDefault(0, 10, 5);
            this.addLabel(new GuiNpcLabel(3, "Animation", this.guiLeft + 4, this.guiTop + 53, 0x404040));
            this.addButton(new GuiNpcButton(3, this.guiLeft + 80, this.guiTop + 48, 100, 20, new String[]{"Normal", "Sitting", "Lying", "Sneaking", "Dancing", "Aiming"}, this.ai.animationType.ordinal()));
            if (this.ai.standingType == EnumStandingType.NoRotation || this.ai.standingType == EnumStandingType.HeadRotation) {
                this.setupRotationControls();
            } else {
                this.map = null;
            }
            if (this.ai.animationType != EnumAnimation.LYING) {
                this.addLabel(new GuiNpcLabel(1, "Rotation", this.guiLeft + 4, this.guiTop + 75, 0x404040));
                this.addButton(new GuiNpcButton(4, this.guiLeft + 80, this.guiTop + 70, 80, 20, new String[]{"Body", "Manual", "Stalking", "Head"}, this.ai.standingType.ordinal()));
            } else {
                this.addLabel(new GuiNpcLabel(6, "Lying Rotation", this.guiLeft + 4, this.guiTop + 75, 0x404040));
                this.addTextField(new GuiNpcTextField(5, this, this.field_73886_k, this.guiLeft + 99, this.guiTop + 70, 40, 20, this.ai.orientation + ""));
                this.getTextField((int)5).numbersOnly = true;
                this.getTextField(5).setMinMaxDefault(0, 359, 0);
                this.addLabel(new GuiNpcLabel(5, "(0-359)", this.guiLeft + 142, this.guiTop + 75, 0x404040));
            }
        }
        if (this.ai.movingType != EnumMovingType.Standing) {
            this.addLabel(new GuiNpcLabel(12, "Animation", this.guiLeft + 4, this.guiTop + 53, 0x404040));
            this.addButton(new GuiNpcButton(12, this.guiLeft + 80, this.guiTop + 48, 100, 20, new String[]{"Normal", "Sneaking", "Aiming", "Dancing"}, this.ai.animationType.getWalkingAnimation()));
        }
        if (this.ai.movingType == EnumMovingType.MovingPath) {
            this.addLabel(new GuiNpcLabel(8, "Movement", this.guiLeft + 4, this.guiTop + 31, 0x404040));
            this.addButton(new GuiNpcButton(8, this.guiLeft + 80, this.guiTop + 26, 80, 20, new String[]{"ai.looping", "ai.backtracking"}, this.ai.movingPattern));
            this.addLabel(new GuiNpcLabel(9, "Pauses", this.guiLeft + 4, this.guiTop + 75, 0x404040));
            this.addButton(new GuiNpcButton(9, this.guiLeft + 80, this.guiTop + 70, 80, 20, new String[]{"gui.no", "gui.yes"}, this.ai.movingPause ? 1 : 0));
        }
        this.addButton(new GuiNpcButton(66, this.guiLeft + 190, this.guiTop + 190, 60, 20, "gui.done"));
    }

    private void setupRotationControls() {
        this.addTextField(new GuiNpcTextField(5, this, this.field_73886_k, this.guiLeft + 165, this.guiTop + 70, 40, 20, this.ai.orientation + ""));
        this.getTextField((int)5).numbersOnly = true;
        this.getTextField(5).setMinMaxDefault(0, 359, 0);
        this.addLabel(new GuiNpcLabel(5, "(0-359)", this.guiLeft + 207, this.guiTop + 75, 0x404040));
        this.map = new MapCanvas("npc_movement", new GuiRendererBuilder().setScale(1.0f).create(), new Point(this.field_73880_f / 2 - 50, this.field_73881_g / 2 - 50 + 40), new Dimension(100, 100));
        this.map.setInitialMapCoords(new Vector2f((float)this.ai.npc.field_70165_t, (float)this.ai.npc.field_70161_v));
        this.map.addObjectRenderer(this);
    }

    private void updateRotationValue(int n) {
        this.ai.orientation = n;
        this.getTextField(5).func_73782_a(String.valueOf(n));
    }

    @Override
    public void drawMapObjects(MapCanvas mapCanvas, float f) {
        int n = this.ai.orientation;
        double d = 100.0;
        double d2 = Math.toRadians(n) + 1.5707963267948966;
        double d3 = Math.cos(d2) * d;
        double d4 = Math.sin(d2) * d;
        GL11.glDisable(3553);
        GL11.glEnable(2848);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glHint(3154, 4354);
        GL11.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
        GL11.glBegin(1);
        GL11.glVertex2d(0.0, 0.0);
        GL11.glVertex2d(d3, d4);
        GL11.glEnd();
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
        if (this.map != null) {
            GL11.glColor4d(1.0, 1.0, 1.0, 1.0);
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            GL11.glEnable(3042);
            Dimension dimension = this.map.getSize();
            this.map.drawMap(this.map.getLocation().add(dimension.width / 2, dimension.height / 2), 2, f);
            if (this.mapDragging) {
                this.updateRotationBasedOnMouse(n, n2);
            }
        }
    }

    @Override
    public void func_73879_b(int n, int n2, int n3) {
        super.func_73879_b(n, n2, n3);
        if (n3 != -1) {
            this.mapDragging = false;
        }
    }

    @Override
    public void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
        if (this.map != null) {
            Point point = this.map.getLocation();
            Dimension dimension = this.map.getSize();
            if (n > point.x && n < point.x + dimension.width && n2 > point.y && n2 < point.y + dimension.height) {
                this.updateRotationBasedOnMouse(n, n2);
                this.mapDragging = true;
            }
        }
    }

    private void updateRotationBasedOnMouse(int n, int n2) {
        Point point = this.map.getLocation();
        Dimension dimension = this.map.getSize();
        double d = Math.atan2(n2 - (point.y + dimension.height / 2), n - (point.x + dimension.width / 2));
        if ((d -= 1.5707963267948966) < 0.0) {
            d += Math.PI * 2;
        }
        this.updateRotationValue((int)Math.round(Math.toDegrees(d)));
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        GuiNpcButton guiNpcButton = (GuiNpcButton)jiok2;
        if (guiNpcButton.field_73741_f == 0) {
            this.ai.movingType = EnumMovingType.values()[guiNpcButton.getValue()];
            if (this.ai.movingType != EnumMovingType.Standing) {
                this.ai.animationType = EnumAnimation.NONE;
                this.ai.standingType = EnumStandingType.RotateBody;
                this.ai.bodyOffsetZ = 5.0f;
                this.ai.bodyOffsetY = 5.0f;
                this.ai.bodyOffsetX = 5.0f;
            }
            this.func_73866_w_();
        } else if (guiNpcButton.field_73741_f == 3) {
            this.ai.animationType = EnumAnimation.values()[guiNpcButton.getValue()];
            this.func_73866_w_();
        } else if (guiNpcButton.field_73741_f == 4) {
            this.ai.standingType = EnumStandingType.values()[guiNpcButton.getValue()];
            this.func_73866_w_();
        } else if (guiNpcButton.field_73741_f == 8) {
            this.ai.movingPattern = guiNpcButton.getValue();
        } else if (guiNpcButton.field_73741_f == 9) {
            this.ai.movingPause = guiNpcButton.getValue() == 1;
        } else if (guiNpcButton.field_73741_f == 12) {
            if (guiNpcButton.getValue() == 0) {
                this.ai.animationType = EnumAnimation.NONE;
            }
            if (guiNpcButton.getValue() == 1) {
                this.ai.animationType = EnumAnimation.SNEAKING;
            }
            if (guiNpcButton.getValue() == 2) {
                this.ai.animationType = EnumAnimation.Aiming;
            }
            if (guiNpcButton.getValue() == 3) {
                this.ai.animationType = EnumAnimation.DANCING;
            }
        } else if (jiok2.field_73741_f == 66) {
            this.close();
        }
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        if (guiNpcTextField.id == 7) {
            this.ai.bodyOffsetX = guiNpcTextField.getInteger();
        } else if (guiNpcTextField.id == 8) {
            this.ai.bodyOffsetY = guiNpcTextField.getInteger();
        } else if (guiNpcTextField.id == 9) {
            this.ai.bodyOffsetZ = guiNpcTextField.getInteger();
        } else if (guiNpcTextField.id == 5) {
            this.updateRotationValue(guiNpcTextField.getInteger());
        } else if (guiNpcTextField.id == 4) {
            this.ai.walkingRange = guiNpcTextField.getInteger();
        } else if (guiNpcTextField.id == 6) {
            this.ai.distanceToMelee = guiNpcTextField.getInteger();
        }
    }
}

