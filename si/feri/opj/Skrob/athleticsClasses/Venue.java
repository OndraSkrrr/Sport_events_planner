package si.feri.opj.Skrob.athleticsClasses;

import java.util.Arrays;

abstract public class Venue {
    private String name;
    private String phoneNumber;
    Discipline discipline;

    private Match[] listOfMatches;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    private Venue(String name) {
        this.name = name;
    }

    private Venue() {
    }

    public Venue(String name, String phoneNumber, int numberOfMatches) {
        this(name);
        this.phoneNumber = phoneNumber;

        if(numberOfMatches < 0){
            throw new java.lang.IllegalArgumentException();
        }
        this.listOfMatches = new  Match[numberOfMatches];
    }

    public Venue(String name, String phoneNumber, Discipline discipline, int numberOfMatches) {
        this(name, phoneNumber, numberOfMatches);
        this.discipline = discipline;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", discipline=" + discipline +
                ", listOfMatches=" + Arrays.toString(listOfMatches) +
                '}';
    }

    public int getNumberOfMatchesAtVenue(){
        int n=0;
        for(int i=0;i<this.listOfMatches.length;i++){
            if(listOfMatches[i] != null){
                n++;
            }
        }
        return n;
    }

    public void addMatch(Match match) throws AddingMatchException, SportDisciplineException {

        for (int i=0; i < match.getAthletesList().length; i++){
            if(match.getAthletesList()[i] != null && match.getAthletesList()[i].getDiscipline() != this.discipline){
                throw new SportDisciplineException("Unable to add the match to the venue, as the venue accepts matches of discipline " + this.discipline + ", and athlete " + match.getAthletesList()[i].getSurname() + "assigned to the match competes in discipline " + match.getAthletesList()[i].getDiscipline() + ".");
            }
        }

        if(this.getNumberOfMatchesAtVenue() < this.listOfMatches.length){
            int i=0;
            while (this.listOfMatches[i] != null) {
                i++;
            }

            if(this.listOfMatches[i] == null) {
                this.listOfMatches[i] = match;
            }
            else {
                System.out.println("error occurred - match was not added!!");
            }
        }
    }

    public void removeMatches(){
        for(int i=0; i < listOfMatches.length; i++){
            this.listOfMatches[i] = null;
        }
    }


    public double getOccupancy(){
        double perc = (float)this.getNumberOfMatchesAtVenue() / this.getCapacity();
        return perc*100;
    }

    abstract int getCapacity();

    public Match[] getListOfMatches() {
        return listOfMatches;
    }

    public void setListOfMatches(Match[] listOfMatches) {
        this.listOfMatches = listOfMatches;
    }
}
