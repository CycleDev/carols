package nao.cycledev.carols;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class CarolView extends Fragment {

    private EditText txtCarolText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.carol_view_layout, container, false);
        txtCarolText = (EditText) view.findViewById(R.id.txtCarolText);
        return view;
    }

    public void setCarolText(String carolText) {
        txtCarolText.setText(carolText);
    }
}
