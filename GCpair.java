package gr.hua.dit;

import java.util.Objects;

public class GCpair {
    private double GC;
    private String sequence;

    public GCpair(double GC, String sequence) {
        this.GC = GC;
        this.sequence = sequence;
    }

    public double getGC() {
        return GC;
    }

    public String getSequence() {
        return sequence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GCpair gCpair = (GCpair) o;
        return Double.compare(gCpair.GC, GC) == 0 &&
                sequence.equals(gCpair.sequence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(GC, sequence);
    }

    @Override
    public String toString() {
        return "GCpair{" +
                "GC=" + GC +
                ", sequence='" + sequence + '\'' +
                '}';
    }
}
