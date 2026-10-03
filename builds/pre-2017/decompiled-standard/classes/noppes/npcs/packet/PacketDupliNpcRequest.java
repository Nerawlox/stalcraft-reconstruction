/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.packet;

import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PacketDupliNpcRequest {

    public static class SetDuplicated
    extends zwat {
        private int sharedDataId;

        public SetDuplicated(int n) {
            this.sharedDataId = n;
        }

        public SetDuplicated() {
        }

        @Override
        public void read(DataInput dataInput) throws IOException {
            this.sharedDataId = dataInput.readInt();
        }

        @Override
        public void write(DataOutput dataOutput) throws IOException {
            dataOutput.writeInt(this.sharedDataId);
        }
    }

    public static class EditNpc
    extends zwat {
        private int groupId;

        public EditNpc(int n) {
            this.groupId = n;
        }

        public EditNpc() {
        }

        @Override
        public void read(DataInput dataInput) throws IOException {
            this.groupId = dataInput.readInt();
        }

        @Override
        public void write(DataOutput dataOutput) throws IOException {
            dataOutput.writeInt(this.groupId);
        }
    }

    public static class RemoveGroup
    extends zwat {
        private int groupId;

        public RemoveGroup(int n) {
            this.groupId = n;
        }

        public RemoveGroup() {
        }

        @Override
        public void read(DataInput dataInput) throws IOException {
            this.groupId = dataInput.readInt();
        }

        @Override
        public void write(DataOutput dataOutput) throws IOException {
            dataOutput.writeInt(this.groupId);
        }
    }

    public static class RemoveNPCs
    extends zwat {
        private int groupId;

        public RemoveNPCs(int n) {
            this.groupId = n;
        }

        public RemoveNPCs() {
        }

        @Override
        public void read(DataInput dataInput) throws IOException {
            this.groupId = dataInput.readInt();
        }

        @Override
        public void write(DataOutput dataOutput) throws IOException {
            dataOutput.writeInt(this.groupId);
        }
    }

    public static class RenameGroup
    extends zwat {
        private int groupId;
        private String newName;

        public RenameGroup(int n, String string) {
            this.groupId = n;
            this.newName = string;
        }

        public RenameGroup() {
        }

        @Override
        public void read(DataInput dataInput) throws IOException {
            this.groupId = dataInput.readInt();
            this.newName = dataInput.readUTF();
        }

        @Override
        public void write(DataOutput dataOutput) throws IOException {
            dataOutput.writeInt(this.groupId);
            dataOutput.writeUTF(this.newName);
        }
    }
}

