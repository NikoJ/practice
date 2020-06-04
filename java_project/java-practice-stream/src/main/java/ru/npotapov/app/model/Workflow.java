package ru.npotapov.app.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Workflow {

    private final long id;
    private final String name;
    private String description;
    private boolean isEnabled;
    private List<Task> tasks;

    private Workflow(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.isEnabled = builder.isEnabled;
        this.tasks = builder.tasks;
    }

    public static class Builder {
        private final long id;
        private final String name;

        private String description = "";
        private boolean isEnabled = true;
        private List<Task> tasks = null;

        public Builder(long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder setDescription(String val) {
            description = val;
            return this;
        }

        public Builder setTasks(List<Task> val) {
            tasks = val;
            return this;
        }

        public Builder setIsEnabled(boolean val) {
            isEnabled = val;
            return this;
        }

        public Workflow build() {
            return new Workflow(this);
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

    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workflow workflow = (Workflow) o;
        return id == workflow.id &&
                Objects.equals(name, workflow.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        String strTasks = tasks.stream().map(Task::toString).collect(Collectors.joining(","));
        return "Workflow{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isEnabled=" + isEnabled +
                ", tasks={" + strTasks + "}" +
                '}';
    }
}
