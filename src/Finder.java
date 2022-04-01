import java.util.Objects;

public record Finder(double w, Search v) {

    public double weightFinder() {
        return w;
    }

    public Search getTargetVertex() {
        return v;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result;
        if (obj == this) {
            result = true;
        } else if (obj == null || obj.getClass() != this.getClass()) {
            result = false;
        } else {
            var that = (Finder) obj;
            result = Double.doubleToLongBits(this.w) == Double.doubleToLongBits(that.w) &&
                    Objects.equals(this.v, that.v);
        }
        return result;
    }