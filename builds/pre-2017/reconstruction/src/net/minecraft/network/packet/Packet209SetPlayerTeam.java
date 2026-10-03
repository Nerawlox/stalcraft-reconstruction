/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import java.util.ArrayList;
import java.util.Collection;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.scoreboard.ScorePlayerTeam;

public class Packet209SetPlayerTeam
extends Packet {
    public String _a = "";
    public String _b = "";
    public String _c = "";
    public String _d = "";
    public Collection _e = new ArrayList();
    public int _f;
    public int _g;

    public Packet209SetPlayerTeam() {
    }

    public Packet209SetPlayerTeam(ScorePlayerTeam scorePlayerTeam, int n) {
        this._a = scorePlayerTeam._a();
        this._f = n;
        if (n == 0 || n == 2) {
            this._b = scorePlayerTeam._b();
            this._c = scorePlayerTeam._d();
            this._d = scorePlayerTeam._e();
            this._g = scorePlayerTeam._h();
        }
        if (n == 0) {
            this._e.addAll(scorePlayerTeam._c());
        }
    }

    public Packet209SetPlayerTeam(ScorePlayerTeam scorePlayerTeam, Collection collection, int n) {
        if (n != 3 && n != 4) {
            throw new IllegalArgumentException("Method must be join or leave for player constructor");
        }
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException("Players cannot be null/empty");
        }
        this._f = n;
        this._a = scorePlayerTeam._a();
        this._e.addAll(collection);
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = Packet209SetPlayerTeam.readString(dataInput, 16);
        this._f = dataInput.readByte();
        if (this._f == 0 || this._f == 2) {
            this._b = Packet209SetPlayerTeam.readString(dataInput, 32);
            this._c = Packet209SetPlayerTeam.readString(dataInput, 16);
            this._d = Packet209SetPlayerTeam.readString(dataInput, 16);
            this._g = dataInput.readByte();
        }
        if (this._f == 0 || this._f == 3 || this._f == 4) {
            int n = dataInput.readShort();
            for (int i = 0; i < n; ++i) {
                this._e.add(Packet209SetPlayerTeam.readString(dataInput, 16));
            }
        }
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        Packet209SetPlayerTeam.writeString(this._a, dataOutput);
        dataOutput.writeByte(this._f);
        if (this._f == 0 || this._f == 2) {
            Packet209SetPlayerTeam.writeString(this._b, dataOutput);
            Packet209SetPlayerTeam.writeString(this._c, dataOutput);
            Packet209SetPlayerTeam.writeString(this._d, dataOutput);
            dataOutput.writeByte(this._g);
        }
        if (this._f == 0 || this._f == 3 || this._f == 4) {
            dataOutput.writeShort(this._e.size());
            for (String string : this._e) {
                Packet209SetPlayerTeam.writeString(string, dataOutput);
            }
        }
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleSetPlayerTeam(this);
    }

    @Override
    public int getPacketSize() {
        return 3 + this._a.length();
    }
}

