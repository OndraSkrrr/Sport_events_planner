package si.feri.opj.Skrob.athleticsClasses;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Athlete implements Competition{
    private String name;

    private String surname;

    private int athleteNumber;

    private LocalDate dateOfBirth;

    private Discipline discipline;

    Match[] listOfPersonalMatches = new Match[5];

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAthleteNumber() {
        return athleteNumber;
    }
    public void setAthleteNumber(int athleteNumber) {
        this.athleteNumber = athleteNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public Athlete(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    public Athlete() {
    }

    public Athlete(String name, String surname, int athleteNumber, LocalDate dateOfBirth, Discipline discipline) {
        this(name, surname, athleteNumber, dateOfBirth);
        this.discipline = discipline;
    }

    public Athlete(String name, String surname, int athleteNumber, LocalDate dateOfBirth) {
        this(name, surname);
        this.dateOfBirth = dateOfBirth;

        if(athleteNumber < 0){
            throw new java.lang.IllegalArgumentException();
        }
        this.athleteNumber = athleteNumber;
    }

    public int getAge(){
        long years = ChronoUnit.YEARS.between(this.dateOfBirth, LocalDateTime.now());
        return (int)years;
    }


    @Override
    public String toString() {
        return "Athlete{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    /*
    @Override
    public String toString() {
        return "Athlete{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", athleteNumber=" + athleteNumber +
                ", dateOfBirth=" + dateOfBirth +
                ", discipline=" + discipline +
                '}';
    }
*/



    @Override
    public void checkValidity(Venue venue) {
        //i might asign list of matches at venue to variable and not return that each time
        //Match[] listOfMatches = venue.getListOfMatches();
        for (int i=0; i < venue.getListOfMatches().length; i++){
            if(venue.getListOfMatches()[i] != null && venue.getListOfMatches()[i].athleteExists(this.surname)){
                if(!didIaddTheMatch(venue.getListOfMatches()[i])) {
                    this.addPersonalMatch(venue.getListOfMatches()[i]);
                }
            }
        }
    }

    public boolean didIaddTheMatch(Match match){
        boolean added = false;
        for (int i=0; i < this.listOfPersonalMatches.length; i++){
            if(this.listOfPersonalMatches[i] == match){
                added = true;
            }
        }
        return added;
    }

    public void addPersonalMatch(Match match){
        int i=0;
        while (this.listOfPersonalMatches[i] != null) {
            i++;
        }

        if(this.listOfPersonalMatches[i] == null && i < 5) {
            this.listOfPersonalMatches[i] = match;
        }
        else {
            System.out.println("error occurred - match was not added!!");
        }
    }

    public void printMyMatches(){
        System.out.println("These are my events:\n");
        for(int i=0; i < this.listOfPersonalMatches.length; i++){
            if(this.listOfPersonalMatches[i] != null){
                System.out.println(this.listOfPersonalMatches[i].getName());
            }else {
                System.out.println("empty");
            }
        }
        System.out.println("\n --------------------- \n");

    }

}
