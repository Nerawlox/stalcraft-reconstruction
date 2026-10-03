/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.entity;

import ru.stalcraft.client.player.PlayerClientInfo;
import ru.stalcraft.player.PlayerUtils;

public class PlayerJumpHelper {
    private uf player;
    private boolean isJumping;

    public PlayerJumpHelper(uf player) {
        this.player = player;
    }

    public void setJumping() {
        this.isJumping = true;
        ((PlayerClientInfo)PlayerUtils.getInfo((uf)this.player)).shouldJump = true;
    }

    public void doJump() {
        this.player.f(this.isJumping);
        this.isJumping = false;
    }
}

