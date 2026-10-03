/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.network;

import cpw.mods.fml.common.network.Player;

public interface IConnectionHandler {
    public void playerLoggedIn(Player var1, elai var2, jjpj var3);

    public String connectionReceived(yezc var1, jjpj var2);

    public void connectionOpened(elai var1, String var2, int var3, jjpj var4);

    public void connectionOpened(elai var1, dzfd var2, jjpj var3);

    public void connectionClosed(jjpj var1);

    public void clientLoggedIn(elai var1, jjpj var2, txpf var3);
}

