package ddongman.algorithms.etc.past.domain;

public class Machine implements Comparable<Machine> {

    private final int number;
    private final int operatingTimes;

    public Machine(int number, int operatingTimes) {
        this.number = number;
        this.operatingTimes = operatingTimes;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(Machine other) {

        if (this.operatingTimes != other.operatingTimes) {
            return Integer.compare(other.operatingTimes, this.operatingTimes);
        }
        return Integer.compare(this.number, other.number);
    }
}
