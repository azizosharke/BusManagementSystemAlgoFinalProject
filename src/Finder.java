import java.util.Objects;

public record Finder(double w, Search v) {    // converted into record as it is better for plain data carriers

    public double weightFinder() {
        return w;
    }

    public Search searchV() {
        return v;
    }

    @Override
    public boolean equals(Object obj) {                                     // overriding and checking in the main system
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

    @Override
    public int hashCode() {
        return Objects.hash(w, v);
    }

    @Override
    public String toString() {                // override for used variables
        return "Finder[" +
                "w=" + w + ", " +
                "v=" + v + ']';
    }
}

// finder class is finished

//public final class Finder {
//    private final double w;
//    private final Search v;
//
//    public Finder(double w, Search v) {
//        this.w = w;
//        this.v = v;
//    }    // converted into record as it is better for plain data carriers
//
//    public double weightFinder() {
//        return w;
//    }
//
//    public Search searchV() {
//        return v;
//    }
//
//    @Override
//    public boolean equals(Object obj) {                                     // overriding and checking in the main system
//        boolean result;
//        if (obj == this) {
//            result = true;
//        } else if (obj == null || obj.getClass() != this.getClass()) {
//            result = false;
//        } else {
//            var that = (Finder) obj;
//            result = Double.doubleToLongBits(this.w) == Double.doubleToLongBits(that.w) &&
//                    Objects.equals(this.v, that.v);
//        }
//        return result;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(w, v);
//    }
//
//    @Override
//    public String toString() {                // override for used variables
//        return "Finder[" +
//                "w=" + w + ", " +
//                "v=" + v + ']';
//    }
//
//    public double w() {
//        return w;
//    }
//
//    public Search v() {
//        return v;
//    }
//
//}

