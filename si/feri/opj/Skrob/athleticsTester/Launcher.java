package si.feri.opj.Skrob.athleticsTester;

import java.time.LocalDate;
import java.time.LocalDateTime;
import si.feri.opj.Skrob.athleticsClasses.*;

import static si.feri.opj.Skrob.athleticsClasses.Discipline.VOLLEYBALL;

/**
 *
 * @author Ondrej Skrob
 * @version 1.0
 */

public class Launcher {



    public static void main(String[] args) {
        /*
        Schedule moment1 = new Schedule(LocalDateTime.now().plusWeeks(20));
        Schedule moment2 = new Schedule(LocalDateTime.now().plusWeeks(21));

        Athlete Jan = new Athlete("Jan", "Novak");
        Jan.setDateOfBirth(LocalDate.of(2006,6,13));
        Jan.setAthleteNumber(1);

        Athlete Peter = new Athlete();
        Peter.setName("Petr");
        Peter.setSurname("Jahoda");
        Peter.setAthleteNumber(2);
        Peter.setDateOfBirth(LocalDate.of(1999,1,2));

        Training tr1 = new Training("Maraton");

        Match mach1 = new Match("Sprint", moment1);
        mach1.canCompete(Peter);
        System.out.println("Can Petr compete " + mach1.canCompete(Peter));

        mach1.addAthleteToMatch(Jan);
        System.out.println("Number of athlets in the mach is " + mach1.getNumberOfAthletesInMatch());
        System.out.println("Is there an athlete with the surname Jahoda? " + mach1.athleteExists("Jahoda"));
        mach1.addAthleteToMatch(Peter);
        System.out.println(Peter.toString());
        System.out.println("Number of athlets in the mach is " + mach1.getNumberOfAthletesInMatch());
        System.out.println("Is there an athlete with the surname Jahoda? " + mach1.athleteExists("Jahoda"));
        mach1.removeAthleteFromMatch(2);
        System.out.println("Number of athlets in the mach is " + mach1.getNumberOfAthletesInMatch());
        mach1.removeAthleteFromMatch(Jan);
        System.out.println("Number of athlets in the mach is " + mach1.getNumberOfAthletesInMatch());
        */

        /*
        Stadium place1 = new Stadium("placeOne", "01234", Discipline.VOLLEYBALL, 5);

        System.out.println("HERE " + place1.toString());
        Schedule moment1 = new Schedule(LocalDateTime.now().plusWeeks(20));
        Match mach1 = new Match("Sprint", moment1);
        Match mach2 = new Match("Marathon", moment1);
        place1.addMatch(mach1);
        place1.addMatch(mach2);
        System.out.println("Number of matches " + place1.getNumberOfMatchesAtVenue());
        System.out.println("Occupancy is " + place1.getOccupancy());
        place1.removeMatches();
        System.out.println("Number of matches " + place1.getNumberOfMatchesAtVenue());
        System.out.println("Occupancy is " + place1.getOccupancy());

        Hall place2 = new Hall("placeTwo", "09876", 4, 2);
        System.out.println("HERE " + place2.toString());

        Athlete Jan = new Athlete("Jan", "Novak", 7, LocalDate.of(1999,1,2), Discipline.ATHLETICS);
        System.out.println(Jan.toString());
         */

        Schedule moment1 = new Schedule(LocalDateTime.of(2023,4,29, 13, 22));
        Venue ven1 = new Stadium("Stadion", "0987", VOLLEYBALL, 3);
        Venue ven2 = new Hall("Stadion", "0987", 4, 3);
        Match match1 = new Match("Basket", moment1, false);
        Athlete petr;
        try {
            petr = new Athlete("Petr", "Novak",-22, LocalDate.of(1986, 2, 2), VOLLEYBALL);
        } catch (IllegalArgumentException e){
            petr = new Athlete("Petr", "Novak",22, LocalDate.of(1986, 2, 2), VOLLEYBALL);
            //throw new IllegalArgumentException(e);
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }


        match1.checkValidity(ven1);
        petr.printMyMatches();


        try {
            match1.addAthleteToMatch(petr);
        } catch (AddingAthleteException e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        }

        petr.setDateOfBirth(LocalDate.of(2006, 2, 2));

        try {
            match1.addAthleteToMatch(petr);
        } catch (AddingAthleteException e) {
            //throw new RuntimeException(e);
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }


        try {
            ven1.addMatch(match1);
        } catch (AddingMatchException e) {
            //throw new RuntimeException(e);
            System.out.println(e.getMessage());
        } catch (SportDisciplineException e) {
            //throw new RuntimeException(e);
            System.out.println(e.getMessage());
        }

        try {
            ven2.addMatch(match1);
        } catch (AddingMatchException e) {
            //throw new RuntimeException(e);
            System.out.println(e.getMessage());
        } catch (SportDisciplineException e) {
            ven2.setDiscipline(VOLLEYBALL);
            //throw new RuntimeException(e);
            System.out.println(e.getMessage());
        }

        match1.checkValidity(ven1);

        petr.checkValidity(ven1);

        match1.checkValidity(ven1);
        petr.printMyMatches();


    }
}
