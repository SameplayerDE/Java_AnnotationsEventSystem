package io.github.SameplayerDE.AnnotationsEventSystem.Events;

public abstract class Event {

    private Priority priority;
    private String eventName;

    public String getEventName() {
        return eventName;
    }

    public Priority getPriority() {
        return priority;
    }

    public enum Priority {

        LOW,
        MIDDLE,
        HIGH;

    }

}
