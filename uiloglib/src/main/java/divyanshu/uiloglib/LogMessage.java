package divyanshu.uiloglib;

public class LogMessage {

    private String logTag;
    private String logMessage;
    private String logTimestamp;
    private LogType logType;

    public String getLogTag() {
        return logTag;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public String getLogTimestamp() {
        return logTimestamp;
    }

    public LogType getLogType() {
        return logType;
    }

    private LogMessage(Builder builder) {
        logTag = builder.logTag;
        logMessage = builder.logMessage;
        logTimestamp = builder.logTimestamp;
        logType = builder.logType;
    }


    public static final class Builder {
        private String logTag;
        private String logMessage;
        private String logTimestamp;
        private LogType logType;

        public Builder() {
        }

        public Builder logTag(String val) {
            logTag = val;
            return this;
        }

        public Builder logMessage(String val) {
            logMessage = val;
            return this;
        }

        public Builder logTimestamp(String val) {
            logTimestamp = val;
            return this;
        }

        public Builder logType(LogType val) {
            logType = val;
            return this;
        }

        public LogMessage build() {
            return new LogMessage(this);
        }
    }

}