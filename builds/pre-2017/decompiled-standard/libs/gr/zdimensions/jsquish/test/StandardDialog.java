/*
 * Decompiled with CFR 0.152.
 */
package gr.zdimensions.jsquish.test;

import gr.zdimensions.jsquish.test.UIUtil;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JDialog;

abstract class StandardDialog
extends JDialog {
    private JComponent focusRoot;
    private CloseOperation closeOperation;

    protected StandardDialog(String title) {
        super((Frame)null, title, true);
        super.setResizable(false);
        super.setDefaultCloseOperation(0);
        super.addWindowListener(new WindowAdapter(){

            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                StandardDialog.this.doClose();
            }
        });
        super.addComponentListener(new ComponentAdapter(){

            public void componentShown(ComponentEvent e) {
                if (StandardDialog.this.focusRoot != null) {
                    StandardDialog.this.focusRoot.requestFocus();
                }
            }
        });
        UIUtil.uiRegisterCloseAction(this, new AbstractAction(){

            public void actionPerformed(ActionEvent e) {
                StandardDialog.this.doClose();
            }
        });
        this.closeOperation = CloseOperation.HIDE_ON_CLOSE;
    }

    protected StandardDialog(Frame owner, String title) {
        super(owner, title, true);
        super.setResizable(false);
        super.setDefaultCloseOperation(0);
        super.addWindowListener(new /* invalid duplicate definition of identical inner class */);
        super.addComponentListener(new /* invalid duplicate definition of identical inner class */);
        UIUtil.uiRegisterCloseAction(this, new /* invalid duplicate definition of identical inner class */);
        this.closeOperation = CloseOperation.HIDE_ON_CLOSE;
    }

    protected StandardDialog(Dialog owner, String title) {
        super(owner, title, true);
        super.setResizable(false);
        super.setDefaultCloseOperation(0);
        super.addWindowListener(new /* invalid duplicate definition of identical inner class */);
        super.addComponentListener(new /* invalid duplicate definition of identical inner class */);
        UIUtil.uiRegisterCloseAction(this, new /* invalid duplicate definition of identical inner class */);
        this.closeOperation = CloseOperation.HIDE_ON_CLOSE;
    }

    public final void showCentered() {
        UIUtil.uiCenterDialog(this);
        this.setVisible(true);
    }

    protected final void setFocusRoot(JComponent component) {
        this.focusRoot = component;
    }

    protected void setCloseOperation(CloseOperation operation) {
        this.closeOperation = operation;
    }

    protected abstract Container createContent();

    protected final void setupContent() {
        super.setContentPane(this.createContent());
        super.pack();
    }

    protected boolean closeAction() {
        return true;
    }

    private void doClose() {
        if (!this.closeAction()) {
            return;
        }
        if (this.closeOperation == CloseOperation.HIDE_ON_CLOSE) {
            super.setVisible(false);
        } else {
            super.dispose();
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static enum CloseOperation {
        HIDE_ON_CLOSE,
        DISPOSE_ON_CLOSE;

    }
}

