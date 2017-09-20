/**
 * Created by pku141 on 8/31/2017.
 */
public class POJO{

    private final int a ;
    private final int b;

    public POJO(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        POJO pojo = (POJO) o;

        if (a != pojo.a) return false;
        return b == pojo.b;
    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + b;
        return result;
    }

    @Override
    public String toString() {
        return "POJO{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
