package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetna, krajnja;
    boolean pripadnostPrve, pripadnostDruge;

    public Interval(double pocetna, double krajnja, boolean pripadnostPrve, boolean pripadnostDruge) throws IllegalArgumentException {
        if (pocetna>krajnja)
            throw new IllegalArgumentException("Pocetna tacka intervala veca od krajnje");
        this.pocetna = pocetna;
        this.krajnja = krajnja;
        this.pripadnostPrve = pripadnostPrve;
        this.pripadnostDruge = pripadnostDruge;
    }

    public Interval () {
        pocetna=0; krajnja=0; pripadnostPrve=false; pripadnostDruge=false;
    }

    public Interval intersect(Interval i2) {
        return intersect(this,i2);
    }

    public static Interval intersect(Interval i, Interval i2) {
      if (Double.compare(i.pocetna,i2.krajnja)>0 || Double.compare(i2.pocetna,i.krajnja)>0) return new Interval();
      double pocetna, krajnja;
      boolean pripadnostPrve, pripadnostDruge;

      if (i.pocetna > i2.pocetna) {
          pocetna=i.pocetna;
          pripadnostPrve=i.pripadnostPrve;
      }
      else {
          pocetna=i2.pocetna;
          pripadnostPrve=i2.pripadnostPrve;
      }

        if (i.krajnja < i2.krajnja){
            krajnja=i.krajnja;
            pripadnostDruge=i.pripadnostDruge;
        }
        else {
            krajnja=i2.krajnja;
            pripadnostDruge=i2.pripadnostDruge;
        }

        return new Interval(pocetna, krajnja, pripadnostPrve, pripadnostDruge);
    }

    public boolean isIn(double v) {
        if (v>pocetna && v<krajnja)  return true;
        return (pripadnostPrve && pocetna==v || pripadnostDruge && krajnja==v);
    }

    public boolean isNull() {
        return (pocetna==0 && krajnja==0 && !pripadnostPrve && !pripadnostDruge);
    }

    @Override
    public String toString() {
        String s;
        if (pripadnostPrve) s="[";
        else s="(";
       if (!isNull()) s = s + pocetna + "," + krajnja;
        if (pripadnostDruge) s=s+"]";
        else s=s+")";
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
        return Double.compare(interval.pocetna, pocetna) == 0 &&
                Double.compare(interval.krajnja, krajnja) == 0 &&
                pripadnostPrve == interval.pripadnostPrve &&
                pripadnostDruge == interval.pripadnostDruge;
    }
}
