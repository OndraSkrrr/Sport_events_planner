package si.feri.opj.Skrob.athleticsClasses;

import java.util.Arrays;

/**
 *
 * @author Ondrej Skrob
 * @version 1.0
 */

public class Match extends Event implements Competition{

    private Athlete[] athletesList = new Athlete[10];

    public Match(String name, Schedule schedule, boolean cancelled) {
        super(name, schedule, cancelled);
    }
    /**
     *
     * @name Name of the match
     * @schedule Reference to another class schedule, that contain date and time of the Match
     */

    public Match() {
        super();
    }


    public Athlete[] getAthletesList() {
        return athletesList;
    }

    public void setAthletesList(Athlete[] athletesList) {
        this.athletesList = athletesList;
    }

    /**
     * decide if given athlete is allowed to compete in the mach
     * @param athl Take as a parameter Athlete instance about which will be decided if can compete.
     * @return returns boolean value (True - if athlete can compete, false if he/she cant)
     */
    public boolean canCompete(Athlete athl) {
        boolean value=false;
        if(athl.getAge() >= 14 && athl.getAge() <= 18){
            value=true;
        }

        return value;
    }

    /**
     *  count the number of athletes
     * @return Return the number of athletes that are enroled to the match
     */

    public int getNumberOfAthletesInMatch(){
        int num=0;
        for (int i=0;i < this.athletesList.length; i++){
            if(this.athletesList[i] != null){
                num++;
            }
        }
        return num;
    }

    /**
     *  add given athlet to the array of athletes that are enrolled in the mach
     * @param athl Takes instance of the class Athlete that is added in the match
     */
    public void addAthleteToMatch(Athlete athl) throws AddingAthleteException{

        if(!this.canCompete(athl)){
            throw new AddingAthleteException("Athlete has not proper age to compete");
        }

        if(this.getNumberOfAthletesInMatch() < this.athletesList.length){
            int i=0;
            while (this.athletesList[i] != null) {
                i++;
            }

            if(this.athletesList[i] == null) {
                this.athletesList[i] = athl;
            }
            else {
                System.out.println("error occurred - athlet was not added!!");
            }
        }
    }

    /**
     * decide if the athlete with given name is enroled to the mach
     * @param lastName takes name of the athlete that is searched in the array of athletes
     * @return return true if athlete was found, false if he was not found
     */
    public boolean athleteExists(String lastName){
        boolean exist=false;
        for(int i=0; i<this.athletesList.length;i++)
        {
            if(this.athletesList[i] != null && this.athletesList[i].getSurname() == lastName){
                exist=true;
            }
        }
        return exist;
    }

    /**
     * search for the given athlete and delete him from enroled athletes, if he is found
     * @param athl takes as a parameter athlet instance
     */
    public void removeAthleteFromMatch(Athlete athl){
        for(int i=0; i<this.athletesList.length;i++)
        {
            if(this.athletesList[i] == athl){
                this.athletesList[i] = null;
            }
        }
    }

    /**
     * search athlete in the array of enroled athletes and delete him, if he/she is found
     * @param athleteNumber takes number that is identifier of athlete
     * @return returns logic value, true if athlete was found and removed, false if he/she was not
     */
    public boolean removeAthleteFromMatch(int athleteNumber){
        boolean success = false;
        for(int i=0; i<this.athletesList.length;i++)
        {
            if(this.athletesList[i] != null && this.athletesList[i].getAthleteNumber() == athleteNumber){
                this.athletesList[i] = null;
                success=true;
            }
        }
        return success;
    }

    @Override
    public String toString() {
        return super.toString() + "athletesList=" + Arrays.toString(athletesList);
    }

    @Override
    public void checkValidity(Venue venue) {
        boolean can = false;
        for(int i=0; i < venue.getListOfMatches().length; i++){
            if(venue.getListOfMatches()[i] == this){
                can = true;
            }
        }
        if(can){
            System.out.println("The match " + this.getName() + " can take place");
        }
        else{
            System.out.println("The match " + this.getName() + " has not been added to the venue");
        }
    }
}
