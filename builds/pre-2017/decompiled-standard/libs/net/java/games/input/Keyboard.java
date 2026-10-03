/*
 * Decompiled with CFR 0.152.
 */
package net.java.games.input;

import net.java.games.input.AbstractController;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.Rumbler;

public abstract class Keyboard
extends AbstractController {
    protected Keyboard(String name2, Component[] keys2, Controller[] children, Rumbler[] rumblers) {
        super(name2, keys2, children, rumblers);
    }

    public Controller.Type getType() {
        return Controller.Type.KEYBOARD;
    }

    public final boolean isKeyDown(Component.Identifier.Key key_id) {
        Component key = this.getComponent(key_id);
        if (key == null) {
            return false;
        }
        return key.getPollData() != 0.0f;
    }
}

