package com.schedule;

import java.util.HashMap;

/**
 * Created by dwanw_000 on 11/16/2015.
 */
public class BookingImpl implements Schedule {
    private int day;
    private int processes;

    public BookingImpl() {
        day = 0;
        processes = 0;

    }

    public BookingImpl(int dayParam, int processesParam, int maxRateParam, HashMap<Integer, Integer> scheduleParam) {
        day = dayParam;
        processes = processesParam;

    }

    public int getDay() {
        return this.day;
    }
    public void setDay(int day) {
        this.day = day;
    }

    public int getProcesses() {
        return this.processes;
    }
    public void setProcesses(int processes) {
        this.processes = processes;
    }



}
