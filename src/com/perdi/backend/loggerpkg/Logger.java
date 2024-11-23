package com.perdi.backend.loggerpkg;

import java.util.ArrayList;
import java.util.UUID;

public class Logger {
    private static Logger singleInstance;
    private ArrayList<Log> logs;

    private Logger() {
        logs = new ArrayList<>();
    }

    public static synchronized Logger getInstance() {
        if (singleInstance == null) {
            singleInstance = new Logger();
        }
        return singleInstance;
    }

    public void createErrorLog (UUID logCreatorID, UUID logSubjectID) {
        String logTitle = "ERROR";
        Log newLog = new Log(logCreatorID, logSubjectID, logTitle);
    }

    public void createWarningLog (UUID logCreatorID, UUID logSubjectID) {
        String logTitle = "WARNING";
        Log newLog = new Log(logCreatorID, logSubjectID, logTitle);
    }

    public void createCreationLog (UUID logCreatorID, UUID logSubjectID) {
        String logTitle = "NEW";
        Log newLog = new Log(logCreatorID, logSubjectID, logTitle);
    }

    public void createLog (UUID logCreatorID, UUID logSubjectID, String logTitle) {
        Log newLog = new Log(logCreatorID, logSubjectID, logTitle);
    }

    public void createLog (UUID logCreatorID, UUID logSubjectID, String logTitle, String logMessage) {
        Log newLog = new Log(logCreatorID, logSubjectID, logTitle, logMessage);
    }

    public void addLog (Log log) {
        logs.add(log);
    }

    public void removeLog (UUID logID) {
        for (int i = 0; i < logs.size(); i++) {
            if (logs.get(i).getLogID().equals(logID)) logs.remove(i);
        }
    }

    public void removeLog (Log log) {
        for (int i = 0; i < logs.size(); i++) {
            if (log.equals(logs.get(i))) logs.remove(i);
        }
    }

    public void clearLogs () {
        logs.clear();
    }


    public ArrayList<Log> getLogs () {
        return logs;
    }

    public void setLogs (ArrayList < Log > logs) {
        this.logs = logs;
    }

}