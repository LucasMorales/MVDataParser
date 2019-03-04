public class ElectionResult {

    private double votesDem, votesGOP, totalVotes, perDem, perGOP;
    private int diff;
    private double perPointDiff;
    private String stateAbbr, countyName;
    private int combinedFips;

    public double getVotesDem() {
        return votesDem;
    }

    public void setVotesDem(double votesDem) {
        this.votesDem = votesDem;
    }

    public double getVotesGOP() {
        return votesGOP;
    }

    public void setVotesGOP(double votesGOP) {
        this.votesGOP = votesGOP;
    }

    public double getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(double totalVotes) {
        this.totalVotes = totalVotes;
    }

    public double getPerDem() {
        return perDem;
    }

    public void setPerDem(double perDem) {
        this.perDem = perDem;
    }

    public double getPerGOP() {
        return perGOP;
    }

    public void setPerGOP(double perGOP) {
        this.perGOP = perGOP;
    }

    public int getDiff() {
        return diff;
    }

    public void setDiff(int diff) {
        this.diff = diff;
    }

    public double getPerPointDiff() {
        return perPointDiff;
    }

    public void setPerPointDiff(double perPointDiff) {
        this.perPointDiff = perPointDiff;
    }

    public String getStateAbbr() {
        return stateAbbr;
    }

    public void setStateAbbr(String stateAbbr) {
        this.stateAbbr = stateAbbr;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public int getCombinedFips() {
        return combinedFips;
    }

    public void setCombinedFips(int combinedFips) {
        this.combinedFips = combinedFips;
    }

    @Override
    public String toString() {
        return "ElectionResult{" +
                "votesDem=" + votesDem +
                ", votesGOP=" + votesGOP +
                ", totalVotes=" + totalVotes +
                ", perDem=" + perDem +
                ", perGOP=" + perGOP +
                ", diff=" + diff +
                ", perPointDiff=" + perPointDiff +
                ", stateAbbr='" + stateAbbr + '\'' +
                ", countyName='" + countyName + '\'' +
                ", combinedFips=" + combinedFips +
                '}';
    }

}
