/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import mcoptifine.Config;

public class NaturalProperties {
    public int rotation = 1;
    public boolean flip = false;

    public NaturalProperties(String string) {
        if (string.equals("4")) {
            this.rotation = 4;
        } else if (string.equals("2")) {
            this.rotation = 2;
        } else if (string.equals("F")) {
            this.flip = true;
        } else if (string.equals("4F")) {
            this.rotation = 4;
            this.flip = true;
        } else if (string.equals("2F")) {
            this.rotation = 2;
            this.flip = true;
        } else {
            Config.warn("NaturalTextures: Unknown type: " + string);
        }
    }

    public boolean isValid() {
        return this.rotation != 2 && this.rotation != 4 ? this.flip : true;
    }
}

