package si.feri.opj.Skrob.athleticsClasses;

public class Event {
    private String name;

    private Schedule schedule;

    private boolean cancelled;

    public Event(String name, Schedule schedule, boolean cancelled) {
        this.name = name;
        this.schedule = schedule;
        this.cancelled = cancelled;
    }

    public Event() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' + "}";
    }
}

    /*
    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", schedule=" + schedule +
                ", cancelled=" + cancelled +
                '}';
    }
}
*/