package divyanshu.uiloglib;

import java.util.ArrayList;

/**
 * Created by divyanshunegi on 6/15/17.
 * Project : UILog
 */
public class UILog {

    private ArrayList<LogMessage> logMessagelist;
    private static UILog INSTANCE;

    public static UILog init(){
        if(INSTANCE==null){
            INSTANCE = new UILog();
        }
        return INSTANCE;
    }

    private UILog() {
        logMessagelist = new ArrayList<>();
    }

    public ArrayList<LogMessage> getLogs(){
        return this.logMessagelist;
    }
    /**
     * Verbose message display
     * @param tagName
     * @param logMessage
     */
    public void v(String tagName,String logMessage){
        logMessagelist.add(new LogMessage.Builder()
                .logTag(tagName)
                .logMessage(logMessage)
                .logTimestamp(System.currentTimeMillis()+"")
                .logType(LogType.VERBOSE)
                .build());
    }

    /**
     * Error Log message display
     * @param tagName
     * @param logMessage
     */
    public void e(String tagName,String logMessage){
        logMessagelist.add(new LogMessage.Builder()
                .logTag(tagName)
                .logMessage(logMessage)
                .logTimestamp(System.currentTimeMillis()+"")
                .logType(LogType.ERROR)
                .build());
    }

    /**
     * Warning Log message display
     * @param tagName
     * @param logMessage
     */
    public void w(String tagName,String logMessage){
        logMessagelist.add(new LogMessage.Builder()
                .logTag(tagName)
                .logMessage(logMessage)
                .logTimestamp(System.currentTimeMillis()+"")
                .logType(LogType.WARNING)
                .build());
    }

    /**
     * Debug Log message display
     * @param tagName
     * @param logMessage
     */
    public void d(String tagName,String logMessage){
        logMessagelist.add(new LogMessage.Builder()
                .logTag(tagName)
                .logMessage(logMessage)
                .logTimestamp(System.currentTimeMillis()+"")
                .logType(LogType.DEBUG)
                .build());
    }

    /**
     * Info Log message display
     * @param tagName
     * @param logMessage
     */
    public void i(String tagName,String logMessage){
        logMessagelist.add(new LogMessage.Builder()
                .logTag(tagName)
                .logMessage(logMessage)
                .logTimestamp(System.currentTimeMillis()+"")
                .logType(LogType.INFO)
                .build());
    }


}
