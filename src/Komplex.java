import java.util.Objects;

public class Komplex {
//  deklarerar vad som ska vara med i Komplex.
    public double real;
    public double imagi;

//  sejer att båda variablerna måste vara deklarerad (har ett värde).
    public Komplex(double real, double imagi) {
        this.real = real;
        this.imagi = imagi;
    }
//  konverterar "hach" till en läsbar string.
    @Override
    public String toString() {
        return "(" + real + " + " + imagi + "i)";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Komplex komplex = (Komplex) o;
        return Double.compare(komplex.real, real) == 0 && Double.compare(komplex.imagi, imagi) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(real, imagi);
    }

//  funktionen för att addera två komplexa tall.
    public Komplex add(Komplex b) {
        double reel = real + b.real;
        double imaag = imagi + b.imagi;
        Komplex c = new Komplex(reel,imaag);
        return c;
    }
//  funktionen för att multiplicerar komplexa tall.
    public Komplex multiply(Komplex b) {
        double reel, imaag;
        reel = (real*b.real)-(imagi*b.imagi);
        imaag = (imagi*b.real)+(real*b.imagi);
        Komplex c = new Komplex(reel,imaag);
        return c;
    }

//  funktionen för argumentet i komplexa tal
    public double arg() {
        double a = real; double b = imagi; double c = 0;
//       har flera if satser eftersom man använder olika formler för olika värden.
        if (a > 0) {
            c = Math.atan(b/a);
        }else if (a<0) {
            if (b >= 0) {
                c = Math.atan(b/a) + Math.PI;
            }else if (b<0){
                c = Math.atan(b/a) - Math.PI;
            }
        }else if (a==0) {
            if (b>0) {
                c = (Math.PI)/2;
            }else if (b<0) {
                c = (Math.PI/2)*(-1);
            }else if (b==0) {
                c = 0;
            }
        }
        return c;
    }
}
