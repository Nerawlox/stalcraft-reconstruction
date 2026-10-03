/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3;

import java.io.Serializable;
import java.util.Comparator;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class Range<T>
implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Comparator<T> comparator;
    private final T minimum;
    private final T maximum;
    private transient int hashCode;
    private transient String toString;

    public static <T extends Comparable<T>> Range<T> is(T element) {
        return Range.between(element, element, null);
    }

    public static <T> Range<T> is(T element, Comparator<T> comparator) {
        return Range.between(element, element, comparator);
    }

    public static <T extends Comparable<T>> Range<T> between(T fromInclusive, T toInclusive) {
        return Range.between(fromInclusive, toInclusive, null);
    }

    public static <T> Range<T> between(T fromInclusive, T toInclusive, Comparator<T> comparator) {
        return new Range<T>(fromInclusive, toInclusive, comparator);
    }

    private Range(T element1, T element2, Comparator<T> comparator) {
        if (element1 == null || element2 == null) {
            throw new IllegalArgumentException("Elements in a range must not be null: element1=" + element1 + ", element2=" + element2);
        }
        if (comparator == null) {
            comparator = ComparableComparator.INSTANCE;
        }
        if (comparator.compare(element1, element2) < 1) {
            this.minimum = element1;
            this.maximum = element2;
        } else {
            this.minimum = element2;
            this.maximum = element1;
        }
        this.comparator = comparator;
    }

    public T getMinimum() {
        return this.minimum;
    }

    public T getMaximum() {
        return this.maximum;
    }

    public Comparator<T> getComparator() {
        return this.comparator;
    }

    public boolean isNaturalOrdering() {
        return this.comparator == ComparableComparator.INSTANCE;
    }

    public boolean contains(T element) {
        if (element == null) {
            return false;
        }
        return this.comparator.compare(element, this.minimum) > -1 && this.comparator.compare(element, this.maximum) < 1;
    }

    public boolean isAfter(T element) {
        if (element == null) {
            return false;
        }
        return this.comparator.compare(element, this.minimum) < 0;
    }

    public boolean isStartedBy(T element) {
        if (element == null) {
            return false;
        }
        return this.comparator.compare(element, this.minimum) == 0;
    }

    public boolean isEndedBy(T element) {
        if (element == null) {
            return false;
        }
        return this.comparator.compare(element, this.maximum) == 0;
    }

    public boolean isBefore(T element) {
        if (element == null) {
            return false;
        }
        return this.comparator.compare(element, this.maximum) > 0;
    }

    public int elementCompareTo(T element) {
        if (element == null) {
            throw new NullPointerException("Element is null");
        }
        if (this.isAfter(element)) {
            return -1;
        }
        if (this.isBefore(element)) {
            return 1;
        }
        return 0;
    }

    public boolean containsRange(Range<T> otherRange) {
        if (otherRange == null) {
            return false;
        }
        return this.contains(otherRange.minimum) && this.contains(otherRange.maximum);
    }

    public boolean isAfterRange(Range<T> otherRange) {
        if (otherRange == null) {
            return false;
        }
        return this.isAfter(otherRange.maximum);
    }

    public boolean isOverlappedBy(Range<T> otherRange) {
        if (otherRange == null) {
            return false;
        }
        return otherRange.contains(this.minimum) || otherRange.contains(this.maximum) || this.contains(otherRange.minimum);
    }

    public boolean isBeforeRange(Range<T> otherRange) {
        if (otherRange == null) {
            return false;
        }
        return this.isBefore(otherRange.minimum);
    }

    public Range<T> intersectionWith(Range<T> other) {
        if (!this.isOverlappedBy(other)) {
            throw new IllegalArgumentException(String.format("Cannot calculate intersection with non-overlapping range %s", other));
        }
        if (this.equals(other)) {
            return this;
        }
        T min = this.getComparator().compare(this.minimum, other.minimum) < 0 ? other.minimum : this.minimum;
        T max = this.getComparator().compare(this.maximum, other.maximum) < 0 ? this.maximum : other.maximum;
        return Range.between(min, max, this.getComparator());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Range range = (Range)obj;
        return this.minimum.equals(range.minimum) && this.maximum.equals(range.maximum);
    }

    public int hashCode() {
        int result2 = this.hashCode;
        if (this.hashCode == 0) {
            result2 = 17;
            result2 = 37 * result2 + this.getClass().hashCode();
            result2 = 37 * result2 + this.minimum.hashCode();
            this.hashCode = result2 = 37 * result2 + this.maximum.hashCode();
        }
        return result2;
    }

    public String toString() {
        String result2 = this.toString;
        if (result2 == null) {
            StringBuilder buf = new StringBuilder(32);
            buf.append('[');
            buf.append(this.minimum);
            buf.append("..");
            buf.append(this.maximum);
            buf.append(']');
            this.toString = result2 = buf.toString();
        }
        return result2;
    }

    public String toString(String format) {
        return String.format(format, this.minimum, this.maximum, this.comparator);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static enum ComparableComparator implements Comparator
    {
        INSTANCE;


        public int compare(Object obj1, Object obj2) {
            return ((Comparable)obj1).compareTo(obj2);
        }
    }
}

