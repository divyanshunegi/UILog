package divyanshu.uiloglib;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

/**
 * Created by divyanshunegi on 6/15/17.
 * Project : UILog
 */
public class UILogView extends LinearLayout {

    public UILogView(Context context) {
        super(context);
        init(context,null);
    }

    public UILogView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public UILogView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context,AttributeSet attr){
        LinearLayout.LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        View view = inflate(context, R.layout.log_layout, null);
        view.setLayoutParams(params);
        ListView lv = (ListView) view.findViewById(R.id.logList);
        ListAdapter adapter = new ListAdapter(context,R.layout.log_element,UILog.init().getLogs());
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        addView(view);

//        View v; // Creating an instance for View Object
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        v = inflater.inflate(R.layout.log_layout, null);

//            LayoutInflater mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            mInflater.inflate(R.layout.log_layout, this, true);
//        ListView lv = (ListView) findViewById(R.id.logList);
//        ListAdapter adapter = new ListAdapter(context,R.layout.log_element,UILog.init().getLogs());
//        lv.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
    }

}
