/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.bundle.common.core.stats;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.time.Instant;

public enum StatsType {
    INTEGER{

        @Override
        public void write(Object object, DataOutput dataOutput) throws IOException {
            dataOutput.writeInt((Integer)object);
        }

        @Override
        public Object read(DataInput dataInput) throws IOException {
            return dataInput.readInt();
        }

        @Override
        public Object getDefault() {
            return 0;
        }
    }
    ,
    DECIMAL{

        @Override
        public void write(Object object, DataOutput dataOutput) throws IOException {
            dataOutput.writeDouble((Double)object);
        }

        @Override
        public Object read(DataInput dataInput) throws IOException {
            return dataInput.readDouble();
        }

        @Override
        public Object getDefault() {
            return 0.0;
        }
    }
    ,
    DATE{

        @Override
        public void write(Object object, DataOutput dataOutput) throws IOException {
            dataOutput.writeLong(((Instant)object).toEpochMilli());
        }

        @Override
        public Object read(DataInput dataInput) throws IOException {
            return Instant.ofEpochMilli(dataInput.readLong());
        }

        @Override
        public Object getDefault() {
            return Instant.ofEpochMilli(0L);
        }
    }
    ,
    DURATION{

        @Override
        public void write(Object object, DataOutput dataOutput) throws IOException {
            dataOutput.writeLong((Long)object);
        }

        @Override
        public Object read(DataInput dataInput) throws IOException {
            return dataInput.readLong();
        }

        @Override
        public Object getDefault() {
            return 0L;
        }
    };


    public abstract void write(Object var1, DataOutput var2) throws IOException;

    public abstract Object read(DataInput var1) throws IOException;

    public abstract Object getDefault();

    public String diff(Object object, Object object2) {
        if (object instanceof Integer && object2 instanceof Integer) {
            return String.format("+%d", Math.max((Integer)object, (Integer)object2) - Math.min((Integer)object, (Integer)object2));
        }
        if (object instanceof Double && object2 instanceof Double) {
            return String.format("+%.2f", Math.max((Double)object, (Double)object2) - Math.min((Double)object, (Double)object2));
        }
        throw new UnsupportedOperationException("Type " + object.getClass() + " is not supported");
    }
}

