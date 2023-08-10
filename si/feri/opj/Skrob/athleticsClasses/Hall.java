package si.feri.opj.Skrob.athleticsClasses;

public class Hall extends Venue{

    private int  numberOfAdditionalHalls;

    public Hall(String name, String phoneNumber, int numberOfMatches, int numberOfAdditionalHalls) {
        super(name, phoneNumber, numberOfMatches);
        this.numberOfAdditionalHalls = numberOfAdditionalHalls;
    }

    public Hall(String name, String phoneNumber, Discipline discipline, int numberOfMatches, int numberOfAdditionalHalls) {
        super(name, phoneNumber, discipline, numberOfMatches);
        this.numberOfAdditionalHalls = numberOfAdditionalHalls;
    }

    public int getNumberOfAdditionalHalls() {
        return numberOfAdditionalHalls;
    }

    public void setNumberOfAdditionalHalls(int numberOfAdditionalHalls) {
        this.numberOfAdditionalHalls = numberOfAdditionalHalls;
    }

    @Override
    int getCapacity() {
        return this.numberOfAdditionalHalls + super.getListOfMatches().length;
    }

    @Override
    public String toString() {
        return super.toString() + "Number of aditional halls " + getNumberOfAdditionalHalls();
    }
}
