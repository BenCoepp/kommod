package de.bencoepp.kommod.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class DoctorElement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String command;
    private String output;
    private Boolean ok;
    private Instant executed;
    private Instant saved;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    public Instant getExecuted() {
        return executed;
    }

    public void setExecuted(Instant executed) {
        this.executed = executed;
    }

    public Instant getSaved() {
        return saved;
    }

    public void setSaved(Instant saved) {
        this.saved = saved;
    }

    public void print(boolean verbose){

    }
}
