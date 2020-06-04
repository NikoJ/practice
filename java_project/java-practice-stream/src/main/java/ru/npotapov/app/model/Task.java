package ru.npotapov.app.model;

import java.util.Objects;

public class Task {

    private final long id;
    private final long wfId;
    private final String name;
    private final String description;
    private final boolean isEnabled;

    private Task(Task.Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.isEnabled = builder.isEnabled;
        this.wfId = builder.wfId;
    }

    public static class Builder {
        private final long id;
        private final String name;
        private final long wfId;

        private String description = "";
        private boolean isEnabled = true;

        public Builder(long id, String name, long wfId) {
            this.id = id;
            this.name = name;
            this.wfId = wfId;
        }

        public Task.Builder description(String val) {
            description = val;
            return this;
        }

        public Task.Builder isEnabled(boolean val) {
            isEnabled = val;
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public long getWfId() {
        return wfId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id &&
                wfId == task.wfId &&
                Objects.equals(name, task.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, wfId, name);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", wfId=" + wfId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isEnabled=" + isEnabled +
                '}';
    }
}
