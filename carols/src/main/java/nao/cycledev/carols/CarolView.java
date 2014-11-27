package nao.cycledev.carols;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CarolView extends Fragment {

    private TextView txtCarolText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.carol_view_layout, container, false);
        txtCarolText = (TextView) view.findViewById(R.id.txtCarolText);
        return view;
    }

    public void setCarolText(String carolText) {
        Spanned str = Html.fromHtml(carolText);
        txtCarolText.setText(str);
    }

}
