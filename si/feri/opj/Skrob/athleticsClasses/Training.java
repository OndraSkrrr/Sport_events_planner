package si.feri.opj.Skrob.athleticsClasses;

public class Training extends Event{

    private String trainerName;

    public String getTrainerName() {
        return trainerName;
    }
    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public Training(String name, Schedule schedule, boolean cancelled, String trainerName) {
        super(name, schedule, cancelled);
        this.trainerName = trainerName;
    }

    @Override
    public String toString() {
        return super.toString() + "Trainer name: " + this.trainerName;
    }
}
