package si.feri.opj.Skrob.athleticsClasses;

import java.time.LocalTime;

public class Stadium extends Venue{

    public Stadium(String name, String phoneNumber, int numberOfMatches) {
        super(name, phoneNumber, numberOfMatches);
    }

    public Stadium(String name, String phoneNumber, Discipline discipline, int numberOfMatches) {
        super(name, phoneNumber, discipline, numberOfMatches);
    }

    @Override
    int getCapacity(){
        return super.getListOfMatches().length;
    }

    @Override
    public String toString(){
        return super.toString();
    }

    @Override
    public void addMatch(Match match) throws AddingMatchException, SportDisciplineException {
        if(match.getSchedule().getDataTime().getHour() > LocalTime.of(20, 0).getHour()){
            throw new AddingMatchException("The Match can not take a place at stadium after 8 pm");
        }else {
            super.addMatch(match);
        }
    }
}
