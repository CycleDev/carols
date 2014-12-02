package nao.cycledev.carols;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class CarolDetail extends Activity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carol_view_layout);

        if (getResources().getBoolean(R.bool.has_two_panes)) {
            finish();
            return;
        }

        String carolText = getIntent().getExtras().getString("carolText");
        String carolTitle = getIntent().getExtras().getString("carolTitle");


        setTitle(carolTitle);

        textView = (TextView)findViewById(R.id.txtCarolText);
        textView.setText(carolText);

    }

}
