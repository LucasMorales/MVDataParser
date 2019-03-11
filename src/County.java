public class County {
    private String name;
    private int fips;
    private Election2016 vote2016;
    private Education2016 education2016;
    private Employment2016 employment2016;


    public County(String name, int fips) {
        this.name = name;
        this.fips = fips;
    }

}
