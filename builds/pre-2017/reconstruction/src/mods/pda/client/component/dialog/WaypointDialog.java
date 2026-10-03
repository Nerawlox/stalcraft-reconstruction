/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.component.dialog;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionButtonClick;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McNumberField;
import gloomyfolken.mods.core.client.gui.engine.component.McRadioButton;
import gloomyfolken.mods.core.client.gui.engine.component.McRadioGroup;
import gloomyfolken.mods.core.client.gui.engine.component.McTextField;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentCheckboxStyle;
import gloomyfolken.mods.party.zwat;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiConsumer;
import mods.pda.client.component.dialog.Dialog;
import mods.pda.client.component.option.PdaToggle;
import mods.pda.client.waypoint.UserWaypoint;
import org.lwjgl.util.vector.Vector3f;

public class WaypointDialog
extends Dialog {
    private static final Dimension DEFAULT_SIZE = new Dimension(500, 290);
    private static final int[] COLORS = new int[]{-14277082, -5767055, -655104, -16734463, -5614845, -16711512, -262910, -1};
    private BiConsumer<Boolean, UserWaypoint> onCreation;
    private McTextField titleTextField;
    private McNumberField xNumField;
    private McNumberField yNumField;
    private McNumberField zNumField;
    private int colorId;
    private McRadioGroup colorSelector;
    private boolean partyWaypoint = false;
    public McLabel partyLabel;
    public PdaToggle partyToggle;
    public McButton cancel;
    public McButton confirm;

    public WaypointDialog(IAdvancedGui iAdvancedGui, Point point) {
        super(iAdvancedGui, point, DEFAULT_SIZE);
    }

    @Override
    protected void setupDialog() {
        Point point = new Point(50, 45);
        this.titleTextField = this.add(new McTextField(this.parent, point.add(0, 10), new Dimension(this.getSize().width / 10 * 8, 30)));
        this.titleTextField.tipText = "\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435";
        this.titleTextField.setStyle(iedw._i);
        int n = this.getSize().width / 4;
        this.xNumField = this.add(new McNumberField(this.parent, point.add(0, 64), new Dimension(n, 30)));
        this.xNumField.setStyle(iedw._i);
        this.yNumField = this.add(new McNumberField(this.parent, point.add(n + 13, 64), new Dimension(n, 30)));
        this.yNumField.setStyle(iedw._i);
        this.zNumField = this.add(new McNumberField(this.parent, point.add(n * 2 + 26, 64), new Dimension(n, 30)));
        this.zNumField.setStyle(iedw._i);
        this.colorSelector = new McRadioGroup(this.parent);
        for (int i = 0; i < COLORS.length; ++i) {
            int n2 = 46;
            this.colorSelector.addElement(this.add(new ColorButton(this.colorSelector, point.add((n2 + 4) * i + 2, 109), new Dimension(n2, 25), i)));
        }
        this.partyWaypoint = false;
        this.confirm = this.add(new McButton(this.parent, point.add(0, 184), iedw._l, "\u0421\u043e\u0437\u0434\u0430\u0442\u044c"));
        this.parent.getActionManager().registerActionHandler(this.confirm, GuiActionButtonClick.class, guiActionButtonClick -> {
            this.submit();
            this.setStatus(false);
        });
        this.confirm.setSize(new Dimension(190, 30));
        this.cancel = this.add(new McButton(this.parent, point.add(210, 184), iedw._l, "\u041e\u0442\u043c\u0435\u043d\u0438\u0442\u044c"));
        this.parent.getActionManager().registerActionHandler(this.cancel, GuiActionButtonClick.class, guiActionButtonClick -> this.setStatus(false));
        this.cancel.setSize(new Dimension(190, 30));
        this.partyLabel = this.add(new McLabel(this.parent, "\u041c\u0435\u0442\u043a\u0430 \u043e\u0442\u0440\u044f\u0434\u0430: ", point.add(0, 149), 0x939393));
        this.partyToggle = new PdaToggle(this.parent, point.add(300, 149), new Dimension(100, 23), false);
        this.partyToggle.onToggle(pdaToggle -> {
            this.partyWaypoint = pdaToggle.getActive();
            this.toggleParty(this.partyWaypoint, this.inParty());
        });
        this.add(this.partyToggle);
        this.toggleParty(this.partyWaypoint, this.inParty());
    }

    private void toggleParty(boolean bl, boolean bl2) {
        this.colorSelector.setEnabled(!bl);
        this.colorSelector.setVisible(!bl);
        this.partyToggle.setEnabled(bl2);
        this.partyToggle.setVisible(bl2);
        this.partyLabel.setEnabled(bl2);
        this.partyLabel.setVisible(bl2);
        int n = (!bl && bl2 ? 35 : 0) + 45;
        this.partyLabel.setLocation(new Point(this.partyLabel.getLocation().x, 114 + n));
        this.partyToggle.setLocation(new Point(this.partyToggle.getLocation().x, 114 + n));
        this.cancel.setLocation(new Point(this.cancel.getLocation().x, 149 + n));
        this.confirm.setLocation(new Point(this.confirm.getLocation().x, 149 + n));
        this.setSize(!bl && bl2 ? DEFAULT_SIZE : DEFAULT_SIZE.add(0, -35));
    }

    private boolean inParty() {
        return zwat._a != null && !zwat._a._a.isEmpty();
    }

    @Override
    public void drawComponent(Point point, float f) {
        super.drawComponent(point, f);
        if (this.partyWaypoint && !this.inParty()) {
            this.partyWaypoint = false;
            this.toggleParty(false, false);
        }
    }

    public WaypointDialog setWaypointTitle(String string) {
        this.titleTextField.setText(string);
        return this;
    }

    public WaypointDialog setCoords(Vector3f vector3f) {
        this.xNumField.setText(String.valueOf((int)vector3f.getX()));
        this.yNumField.setText(String.valueOf((int)vector3f.getY()));
        this.zNumField.setText(String.valueOf((int)vector3f.getZ()));
        return this;
    }

    public WaypointDialog resetState() {
        this.colorId = ThreadLocalRandom.current().nextInt(8);
        this.colorSelector.setActiveButton(this.colorId);
        this.partyToggle.setActive(false);
        this.partyToggle.resetAnimation();
        this.partyWaypoint = false;
        return this;
    }

    private void submit() {
        String string = this.titleTextField.getText();
        int n = (int)this.xNumField.getValue();
        int n2 = (int)this.yNumField.getValue();
        int n3 = (int)this.zNumField.getValue();
        this.onCreation.accept(this.partyWaypoint, new UserWaypoint(string, new Vector3f(n, n2, n3), COLORS[this.colorId]));
    }

    public WaypointDialog setOnCreation(BiConsumer<Boolean, UserWaypoint> biConsumer) {
        this.onCreation = biConsumer;
        return this;
    }

    private class ColorButton
    extends McRadioButton {
        int buttonColorId;

        public ColorButton(McRadioGroup mcRadioGroup, Point point, Dimension dimension, int n) {
            super(mcRadioGroup, "", point, new ComponentCheckboxStyle());
            this.setSize(dimension);
            this.buttonColorId = n;
        }

        @Override
        public void drawComponent(Point point, float f) {
            if (this.active) {
                this.renderer.drawRect(this.getLocation(), this.getSize(), COLORS[this.buttonColorId]);
            } else {
                int n = 6;
                this.renderer.drawRect(this.getLocation().add(n, n), this.getSize().add(-n * 2, -n * 2), COLORS[this.buttonColorId]);
            }
        }

        @Override
        public void setSelected(boolean bl) {
            super.setSelected(bl);
            WaypointDialog.this.colorId = this.buttonColorId;
        }
    }
}

