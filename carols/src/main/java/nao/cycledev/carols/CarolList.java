package nao.cycledev.carols;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import nao.cycledev.carols.adapter.CarolAdapter;
import nao.cycledev.carols.repository.CarolMemoryRepository;
import nao.cycledev.carols.repository.CarolRepository;

public class CarolList extends Fragment {

    private ListView carolListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.carol_list_layout, container, false);

        carolListView = (ListView) view.findViewById(R.id.carolListView);
        CarolRepository repository = new CarolMemoryRepository();
        CarolAdapter adapter = new CarolAdapter(getActivity().getApplicationContext(), repository.loadCarols());
        carolListView.setAdapter(adapter);
        return view;
    }
}
