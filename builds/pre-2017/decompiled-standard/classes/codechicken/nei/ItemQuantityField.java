/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.NEIClientConfig;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.TextField;

public class ItemQuantityField
extends TextField {
    public ItemQuantityField(String string) {
        super(string);
        this.centered = true;
    }

    @Override
    public boolean isValid(String string) {
        if (string.equals("")) {
            return true;
        }
        try {
            return Integer.parseInt(string) >= 0;
        }
        catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

    public int intValue() {
        return this.intValue(this.text());
    }

    public int intValue(String string) {
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            return 0;
        }
    }

    @Override
    public void loseFocus() {
        this.setText(Integer.toString(NEIClientConfig.getItemQuantity()));
    }

    @Override
    public void onTextChange(String string) {
        if (this.intValue(string) != this.intValue()) {
            NEIClientUtils.setItemQuantity(this.intValue());
        }
    }
}

