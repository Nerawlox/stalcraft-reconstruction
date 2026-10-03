/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.guilib.vanilla;

import com.mcf.davidee.guilib.core.TextField;
import net.minecraft.util.ezey;

public class TextFieldVanilla
extends TextField {
    private int outerColor;
    private int innerColor;

    public TextFieldVanilla(int n, int n2, TextField.CharacterFilter characterFilter) {
        super(n, n2, characterFilter);
        this.outerColor = -6250336;
        this.innerColor = -16777216;
    }

    public TextFieldVanilla(TextField.CharacterFilter characterFilter) {
        this(200, 20, characterFilter);
    }

    public TextFieldVanilla(int n, int n2, int n3, int n4, TextField.CharacterFilter characterFilter) {
        super(n, n2, characterFilter);
        this.outerColor = n4;
        this.innerColor = n3;
    }

    public void setInnerColor(int n) {
        this.innerColor = n;
    }

    public void setOuterColor(int n) {
        this.outerColor = n;
    }

    @Override
    protected int getDrawX() {
        return this.x + 4;
    }

    @Override
    protected int getDrawY() {
        return this.y + (this.height - 8) / 2;
    }

    @Override
    public int getInternalWidth() {
        return this.width - 8;
    }

    @Override
    protected void drawBackground() {
        TextFieldVanilla.func_73734_a(this.x - 1, this.y - 1, this.x + this.width + 1, this.y + this.height + 1, this.outerColor);
        TextFieldVanilla.func_73734_a(this.x, this.y, this.x + this.width, this.y + this.height, this.innerColor);
    }

    public static class VanillaFilter
    implements TextField.CharacterFilter {
        @Override
        public String filter(String string) {
            return ezey._a(string);
        }

        @Override
        public boolean isAllowedCharacter(char c) {
            return ezey._a(c);
        }
    }

    public static class NumberFilter
    implements TextField.CharacterFilter {
        @Override
        public String filter(String string) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : string.toCharArray()) {
                if (!this.isAllowedCharacter(c)) continue;
                stringBuilder.append(c);
            }
            return stringBuilder.toString();
        }

        @Override
        public boolean isAllowedCharacter(char c) {
            return Character.isDigit(c);
        }
    }
}

