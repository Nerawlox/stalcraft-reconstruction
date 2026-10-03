/*
 * Decompiled with CFR 0.152.
 */
package gr.zdimensions.jsquish.test;

import gr.zdimensions.jsquish.test.ResourceIO;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.IOException;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import javax.swing.RootPaneContainer;

final class UIUtil {
    private static Image icon;

    private UIUtil() {
    }

    public static Image uiGetDefaultIcon() {
        if (icon == null) {
            try {
                icon = ResourceIO.resourceReadImage("images/icon.png");
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
        return icon;
    }

    public static void uiShowInfo(Component parent, String title, String msg) {
        JOptionPane.showMessageDialog(parent, msg, title, 1);
    }

    public static void uiShowInfo(Component parent, String title, String msg, Icon icon) {
        JOptionPane.showMessageDialog(parent, msg, title, 1, icon);
    }

    public static void uiShowWarning(Component parent, String title, String msg) {
        JOptionPane.showMessageDialog(parent, msg, title, 2);
    }

    public static void uiShowError(Component parent, String title, String msg) {
        JOptionPane.showMessageDialog(parent, msg, title, 0);
    }

    public static void uiShowErrorDebug(Component parent, String title, String msg, Exception e) {
        e.printStackTrace();
        UIUtil.uiShowError(parent, title, msg);
    }

    public static int uiShowConfirm(Component parent, String title, String msg) {
        return JOptionPane.showConfirmDialog(parent, msg, title, 0, 2);
    }

    public static boolean uiShowConfirmYes(Component parent, String title, String msg) {
        return JOptionPane.showConfirmDialog(parent, msg, title, 0, 2) == 0;
    }

    public static void uiCenterDialog(Dialog dialog) {
        Window owner = dialog.getOwner();
        Point loc = owner.getLocation();
        Dimension size = owner.isVisible() ? owner.getSize() : Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = loc.x + (size.width >> 1);
        int centerY = loc.y + (size.height >> 1);
        size = dialog.getSize();
        dialog.setLocation(centerX - (size.width >> 1), centerY - (size.height >> 1));
    }

    public static void uiMaximizeDialogBounds(Dialog dialog) {
        Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
        dialog.setBounds(0, 0, res.width, res.height);
    }

    public static void uiRegisterCloseAction(RootPaneContainer window, Action action) {
        UIUtil.uiRegisterGlobalAction(window, "CLOSE_ACTION_KEY", KeyStroke.getKeyStroke(27, 0, false), action);
    }

    public static void uiRegisterGlobalAction(RootPaneContainer window, String key, KeyStroke keyStroke, Action action) {
        JRootPane root = window.getRootPane();
        InputMap inputMap = root.getInputMap(2);
        inputMap.put(keyStroke, key);
        root.getActionMap().put(key, action);
    }

    public static AbstractButton uiSetupButton(AbstractButton comp, char mnemonic, String description) {
        comp.setPreferredSize(new Dimension(80, 24));
        comp.setMnemonic(mnemonic);
        comp.setToolTipText(description);
        return comp;
    }

    public static JLabel uiLabel(String text) {
        return UIUtil.uiLabel(text, null);
    }

    public static JLabel uiLabel(String text, JComponent labelFor) {
        JLabel label = new JLabel(text, 4);
        if (labelFor != null) {
            label.setLabelFor(labelFor);
            label.setToolTipText(labelFor.getToolTipText());
        }
        return label;
    }

    public static Container uiButtonGroupContainer(ButtonGroup group, String title) {
        Box container = Box.createHorizontalBox();
        container.add(UIUtil.uiLabel(title));
        Box buttonPane = Box.createVerticalBox();
        Enumeration<AbstractButton> buttons = group.getElements();
        while (buttons.hasMoreElements()) {
            buttonPane.add(buttons.nextElement());
        }
        container.add(buttonPane);
        return container;
    }
}

