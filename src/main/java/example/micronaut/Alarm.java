package example.micronaut;

import io.micronaut.core.annotation.Introspected;

import java.util.Objects;

@Introspected
public class Alarm {

    private final Integer id;
    private final String name;
    private final String severity;

    public Alarm(Integer id, String name, String severity) {
        this.id = id;
        this.name = name;
        this.severity = severity;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSeverity() {
        return severity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Alarm alarm = (Alarm) o;
        return getId().equals(alarm.getId()) && getName().equals(alarm.getName()) && getSeverity().equals(alarm.getSeverity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSeverity());
    }
}
