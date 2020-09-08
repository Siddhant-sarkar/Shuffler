package com.SarkarSiddhant;

public class Song {
    private String SongName;
    private double Time;

    public String getSongName() {
        return SongName;
    }

    public void setSongName(String songName) {
        SongName = songName;
    }

    public double getTime() {
        return Time;
    }

    public void setTime(double time) {
        Time = time;
    }

    public Song(String songName, double time) {
        SongName = songName;
        Time = time;
    }
}
