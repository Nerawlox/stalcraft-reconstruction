/*
 * Decompiled with CFR 0.152.
 */
package mods.sound.config;

import gloomyfolken.bundle.common.core.qlgf;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;
import javax.vecmath.Vector3f;

public class SoundSource
extends qlgf {
    private String group;
    private Vector3f pos;
    private float rolloff;
    private float gain;

    public SoundSource() {
    }

    public SoundSource(String string, Vector3f vector3f, float f, float f2) {
        this.group = string;
        this.pos = vector3f;
        this.rolloff = f;
        this.gain = f2;
    }

    public String getGroup() {
        return this.group;
    }

    public SoundSource setGroup(String string) {
        this.group = string;
        return this;
    }

    public Vector3f getPos() {
        return this.pos;
    }

    public SoundSource setPos(Vector3f vector3f) {
        this.pos = vector3f;
        return this;
    }

    public float getRolloff() {
        return this.rolloff;
    }

    public SoundSource setRolloff(float f) {
        this.rolloff = f;
        return this;
    }

    public float getGain() {
        return this.gain;
    }

    public SoundSource setGain(float f) {
        this.gain = f;
        return this;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeFloat(this.getPos().x);
        dataOutput.writeFloat(this.getPos().y);
        dataOutput.writeFloat(this.getPos().z);
        dataOutput.writeUTF(this.getGroup());
        dataOutput.writeFloat(this.getRolloff());
        dataOutput.writeFloat(this.getGain());
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.pos = new Vector3f(dataInput.readFloat(), dataInput.readFloat(), dataInput.readFloat());
        this.group = dataInput.readUTF();
        this.rolloff = dataInput.readFloat();
        this.gain = dataInput.readFloat();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        SoundSource soundSource = (SoundSource)object;
        return Float.compare(soundSource.rolloff, this.rolloff) == 0 && Float.compare(soundSource.gain, this.gain) == 0 && Objects.equals(this.group, soundSource.group) && Objects.equals(this.pos, soundSource.pos);
    }

    public int hashCode() {
        return Objects.hash(this.group, this.pos, Float.valueOf(this.rolloff), Float.valueOf(this.gain));
    }
}

