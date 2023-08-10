package si.feri.opj.Skrob.athleticsClasses;

import java.time.LocalDateTime;

public class Schedule {
    private LocalDateTime dataTime;

    public LocalDateTime getDataTime() {
        return dataTime;
    }

    public void setDataTime(LocalDateTime dataTime) {
        this.dataTime = dataTime;
    }

    public Schedule() {
    }

    public Schedule(LocalDateTime dataTime) {
        this.dataTime = dataTime;
    }

    @Override
    public String toString() {
        return "si.feri.opj.Skrob.athleticsClasses.Schedule{" +
                "dataTime=" + dataTime +
                '}';
    }
}
