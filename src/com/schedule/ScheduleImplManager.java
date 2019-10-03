package com.schedule;

import java.util.HashMap;

public class ScheduleImplManager {
    private HashMap<String, BookingImpl> schedules;

    public ScheduleImplManager() {
        HashMap<String, BookingImpl> schedules = new HashMap<String, BookingImpl>();
    }

    public ScheduleImplManager(HashMap<String, BookingImpl> schedulesParam) {
        schedules = schedulesParam;
    }

    public HashMap<String, BookingImpl> getSchedulesMap() {
        return this.schedules;
    }

    public void setSchedulesMap(HashMap<String, BookingImpl> schedules) {
        this.schedules = schedules;
    }
}