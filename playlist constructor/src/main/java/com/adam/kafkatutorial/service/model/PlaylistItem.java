package com.adam.kafkatutorial.service.model;

import java.time.Instant;
import java.util.Objects;

public class PlaylistItem implements Comparable<PlaylistItem>{
    private Instant timestamp;
    private String song;

    public PlaylistItem(Instant timestamp, String song) {
        this.timestamp = timestamp;
        this.song = song;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaylistItem that = (PlaylistItem) o;
        return Objects.equals(timestamp, that.timestamp) && Objects.equals(song, that.song);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, song);
    }

    @Override
    public String toString() {
        return "PlaylistItem{" +
                "timestamp=" + timestamp +
                ", song='" + song + '\'' +
                '}';
    }

    @Override
    public int compareTo(PlaylistItem o) {
        return timestamp.compareTo(o.getTimestamp());
    }
}
