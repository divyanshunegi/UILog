package divyanshu.uiloglib;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by divyanshunegi on 6/15/17.
 * Project : UILog
 */
public class UILogView extends LinearLayout implements PropertyChangeListener {

    private ListView lv;
    private ListAdapter adapter;

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
        UILog.init().addChangeListener(this);
        LinearLayout.LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        View view = inflate(context, R.layout.log_layout, null);
        view.setLayoutParams(params);
        lv = (ListView) view.findViewById(R.id.logList);
        adapter = new ListAdapter(context,R.layout.log_element,UILog.init().getLogs());
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        addView(view);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Property Changed");
        this.adapter.notifyDataSetChanged();
    }
}
