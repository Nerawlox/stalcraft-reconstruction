/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.client.clans;

public class TagData {
    public int reputation;
    public boolean isAgressive;
    public String clan;

    public TagData(int reputation, String clan, boolean isAgressive) {
        this.reputation = reputation;
        this.clan = clan;
        this.isAgressive = isAgressive;
    }
}

