/*
 * Decompiled with CFR 0.152.
 */
package gr.zdimensions.jsquish.test;

import gr.zdimensions.jsquish.test.SquishTest;
import gr.zdimensions.jsquish.test.StandardDialog;
import gr.zdimensions.jsquish.test.UIUtil;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Comparator;
import javax.swing.AbstractAction;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

final class StartupDialog
extends StandardDialog {
    private final JComboBox modes;
    private final DisplayMode[] avlModes;
    private final JCheckBox fullscreen;

    StartupDialog() {
        super("Launch JSquish Test");
        super.setCloseOperation(StandardDialog.CloseOperation.DISPOSE_ON_CLOSE);
        try {
            DisplayMode[] supportedModes = Display.getAvailableDisplayModes();
            Arrays.sort(supportedModes, new Comparator<DisplayMode>(){

                @Override
                public int compare(DisplayMode d1, DisplayMode d2) {
                    int diff = d1.getBitsPerPixel() - d2.getBitsPerPixel();
                    if (diff != 0) {
                        return diff;
                    }
                    diff = d1.getWidth() - d2.getWidth();
                    if (diff != 0) {
                        return diff;
                    }
                    diff = d1.getHeight() - d2.getHeight();
                    if (diff != 0) {
                        return diff;
                    }
                    return d1.getFrequency() - d2.getFrequency();
                }
            });
            int i = 0;
            while (i < supportedModes.length) {
                if (supportedModes[i].getWidth() >= 800) break;
                ++i;
            }
            this.avlModes = new DisplayMode[supportedModes.length - i];
            System.arraycopy(supportedModes, i, this.avlModes, 0, this.avlModes.length);
        }
        catch (LWJGLException e) {
            throw new RuntimeException("Failed to get available display modes.");
        }
        this.modes = new JComboBox(new DisplayComboBoxModel());
        int i = this.avlModes.length;
        while (--i >= 0) {
            DisplayMode mode = this.avlModes[i];
            if (mode.getWidth() <= 1024 && mode.getFrequency() <= 85) break;
        }
        this.modes.setSelectedIndex(i);
        this.fullscreen = new JCheckBox("Fullscreen");
        this.fullscreen.setToolTipText("If checked, FPS display will not be available");
        super.setupContent();
    }

    protected Container createContent() {
        JPanel cont = new JPanel(new BorderLayout(4, 4));
        cont.setBorder(new EmptyBorder(4, 4, 4, 4));
        cont.add(this.createFormPanel(), "Center");
        cont.add(this.createButtonPanel(), "South");
        return cont;
    }

    private Component createFormPanel() {
        JPanel form = new JPanel(new FlowLayout(0, 1, 0));
        form.add(UIUtil.uiLabel("Display mode", this.modes));
        form.add(this.modes);
        form.add(this.fullscreen);
        return form;
    }

    private Component createButtonPanel() {
        JPanel pane = new JPanel(new FlowLayout(2, 8, 0));
        JButton btn = new JButton(new AbstractAction("Launch"){

            public void actionPerformed(ActionEvent e) {
                StartupDialog.this.setVisible(false);
                SquishTest.start(StartupDialog.this.avlModes[StartupDialog.this.modes.getSelectedIndex()], StartupDialog.this.fullscreen.isSelected());
                StartupDialog.this.dispose();
            }
        });
        pane.add(UIUtil.uiSetupButton(btn, 'L', "Launch application"));
        btn = new JButton(new AbstractAction("Help"){

            public void actionPerformed(ActionEvent e) {
                UIUtil.uiShowInfo(StartupDialog.this, "SquishTest Quick Help", "Press 'O' to open a new image file.\nPress 'C' to cycle the different compression methods.\nPress 'V' to toggle V-Sync [default ON].\nUse cursor keys to navigate the image.\nUse +,- or mousewheel to zoom in/out.\nHold SHIFT to navigate faster.\nPress HOME to reset the viewport.\nPress ESC to quit the application.");
            }
        });
        pane.add(UIUtil.uiSetupButton(btn, 'H', "Show quick help dialog"));
        btn = new JButton(new AbstractAction("Cancel"){

            public void actionPerformed(ActionEvent e) {
                StartupDialog.this.dispose();
            }
        });
        pane.add(UIUtil.uiSetupButton(btn, 'C', "Cancel and exit the application"));
        return pane;
    }

    private class DisplayComboBoxModel
    extends AbstractListModel
    implements ComboBoxModel {
        private Object selected;

        private DisplayComboBoxModel() {
        }

        public int getSize() {
            return StartupDialog.this.avlModes.length;
        }

        public Object getElementAt(int index) {
            if (index >= 0 && index < StartupDialog.this.avlModes.length) {
                return StartupDialog.this.avlModes[index];
            }
            return null;
        }

        public void setSelectedItem(Object o) {
            if (this.selected != null && !this.selected.equals(o) || this.selected == null && o != null) {
                this.selected = o;
                this.fireContentsChanged(this, -1, -1);
            }
        }

        public Object getSelectedItem() {
            return this.selected;
        }
    }
}

