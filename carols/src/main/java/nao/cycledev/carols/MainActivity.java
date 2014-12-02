package nao.cycledev.carols;

import android.app.Activity;
import android.os.Bundle;
import nao.cycledev.carols.model.Carol;

public class MainActivity extends Activity implements ItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        setTitle(R.string.app_title);
    }
    @Override
    public void onCarolSelected(Carol carol) {
        CarolView fragment = (CarolView)getFragmentManager().findFragmentById(R.id.carol_view);
        if (fragment != null && fragment.isInLayout()) {
            fragment.setCarolText(carol.getText());
        }
    }
}
