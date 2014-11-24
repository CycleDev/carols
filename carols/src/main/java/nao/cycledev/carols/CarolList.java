package nao.cycledev.carols;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import nao.cycledev.carols.adapter.CarolAdapter;
import nao.cycledev.carols.repository.CarolJsonRepository;
import nao.cycledev.carols.repository.CarolRepository;

import java.io.IOException;
import java.io.InputStream;

public class CarolList extends Fragment {

    private ListView carolListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.carol_list_layout, container, false);

        carolListView = (ListView) view.findViewById(R.id.carolListView);
        String carolText = "";
        try {
            InputStream is = view.getContext().getAssets().open("carols.json");

            int size = is.available();

            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            carolText = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        CarolRepository repository = new CarolJsonRepository(carolText);
        repository.loadCarols();
        CarolAdapter adapter = new CarolAdapter(getActivity().getApplicationContext(), repository.getCarols());
        carolListView.setAdapter(adapter);
        return view;
    }
}
