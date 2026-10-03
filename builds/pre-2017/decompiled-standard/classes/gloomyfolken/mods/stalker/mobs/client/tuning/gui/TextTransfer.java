/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.client.tuning.gui;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public final class TextTransfer
implements ClipboardOwner {
    private static TextTransfer instance = new TextTransfer();

    private TextTransfer() {
    }

    public static TextTransfer getInstance() {
        return instance;
    }

    @Override
    public void lostOwnership(Clipboard clipboard, Transferable transferable) {
    }

    public void setClipboardContents(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, this);
    }

    public String getClipboardContents() {
        boolean bl;
        String string = "";
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable transferable = clipboard.getContents(null);
        boolean bl2 = bl = transferable != null && transferable.isDataFlavorSupported(DataFlavor.stringFlavor);
        if (bl) {
            try {
                string = (String)transferable.getTransferData(DataFlavor.stringFlavor);
            }
            catch (UnsupportedFlavorException | IOException exception) {
                System.out.println(exception);
                exception.printStackTrace();
            }
        }
        return string;
    }
}

