package divyanshu.uiloglib;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ListAdapter extends ArrayAdapter<LogMessage> {

    public ListAdapter(Context context, int resource, List<LogMessage> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.log_element, null);
        }

        LogMessage p = getItem(position);

        if (p != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.logMessage);

            if (tt1 != null) {

                tt1.setText(getFormatedDateTime(Long.parseLong(p.getLogTimestamp()))
                        +"/"+p.getLogType().toString().toLowerCase().charAt(0)+":"
                        +"    "
                        +p.getLogTag()
                        +"    "
                        +p.getLogMessage()
                );

                switch (p.getLogType()){
                    case VERBOSE:
                        tt1.setTextColor(ContextCompat.getColor(getContext(),R.color.verbose));
                        break;
                    case INFO:
                        tt1.setTextColor(ContextCompat.getColor(getContext(),R.color.info));
                        break;
                    case WARNING:
                        tt1.setTextColor(ContextCompat.getColor(getContext(),R.color.warning));
                        break;
                    case ERROR:
                        tt1.setTextColor(ContextCompat.getColor(getContext(),R.color.error));
                        break;
                    case DEBUG:
                        tt1.setTextColor(ContextCompat.getColor(getContext(),R.color.debug));
                        break;
                }

            }
        }

        return v;
    }


    private String getFormatedDateTime(long timeinEpoch){
        if (timeinEpoch == 0) {
            return "";
        }
        Date date = new Date(timeinEpoch);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
        return formatter.format(date);
    }

}