package com.perdi.backend.systempkg.loggerpkg;

import java.time.LocalDateTime;
import java.util.UUID;

public class Log {
    private UUID logID;
    private UUID logCreatorID;
    private UUID logSubjectID;
    private LocalDateTime logCreationDate;

    private String logTitle;
    private String logMessage;

    public Log (UUID logCreatorID, UUID logSubjectID, String logTitle) {
        setLogID();
        setLogCreatorID(logCreatorID);
        setLogSubjectID(logSubjectID);
        setLogCreationDate();
        setLogTitle(logTitle);
    }

    public Log (UUID logCreatorID, UUID logSubjectID, String logTitle, String logMessage) {
        setLogID();
        setLogCreatorID(logCreatorID);
        setLogSubjectID(logSubjectID);
        setLogCreationDate();
        setLogTitle(logTitle);
        setLogMessage(logMessage);
    }

    public UUID getLogID() {
        return logID;
    }

    private void setLogID() {
        this.logID = UUID.randomUUID();
    }

    public UUID getLogCreatorID() {
        return logCreatorID;
    }

    private void setLogCreatorID(UUID logCreatorID) {
        this.logCreatorID = logCreatorID;
    }

    public UUID getLogSubjectID() {
        return logSubjectID;
    }

    private void setLogSubjectID(UUID logSubjectID) {
        this.logSubjectID = logSubjectID;
    }

    public LocalDateTime getLogCreationDate() {
        return logCreationDate;
    }

    private void setLogCreationDate() {
        this.logCreationDate = LocalDateTime.now();
    }

    public String getLogTitle() {
        return logTitle;
    }

    public void setLogTitle(String logTitle) {
        this.logTitle = logTitle;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }
}
