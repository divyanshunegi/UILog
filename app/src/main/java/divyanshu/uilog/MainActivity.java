package divyanshu.uilog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import divyanshu.uiloglib.UILog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UILog.init().w(MainActivity.class.getName(),"On Create");
    }

    @Override
    protected void onPause() {
        super.onPause();
        UILog.init().d(MainActivity.class.getName(),"On Pause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        UILog.init().e(MainActivity.class.getName(),"On Stop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        UILog.init().i(MainActivity.class.getName(),"On Resume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UILog.init().v(MainActivity.class.getName(),"On Destroy");
    }
}
