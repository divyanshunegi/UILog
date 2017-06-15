package divyanshu.uiloglib;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by divyanshunegi on 6/15/17.
 * Project : UILog
 */
public class UILog {

    private ArrayList<LogMessage> logMessagelist;
    private List<PropertyChangeListener> listener = new ArrayList<PropertyChangeListener>();
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
        notifyListeners(this, "", "", "");
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
        notifyListeners(this, "", "", "");
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
        notifyListeners(this, "", "", "");
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
        notifyListeners(this, "", "", "");
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
        notifyListeners(this, "", "", "");
    }


    private void notifyListeners(Object object, String property, String oldValue, String newValue) {
        for (PropertyChangeListener name : listener) {
            name.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
        }
    }

    public void addChangeListener(PropertyChangeListener newListener) {
        listener.add(newListener);
    }


}
