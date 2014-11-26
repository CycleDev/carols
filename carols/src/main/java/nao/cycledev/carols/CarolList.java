package nao.cycledev.carols;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import nao.cycledev.carols.adapter.CarolAdapter;
import nao.cycledev.carols.repository.CarolJsonRepository;
import nao.cycledev.carols.repository.CarolRepository;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

public class CarolList extends Fragment {

    private ListView carolListView;
    private CarolRepository repository;
    private ItemSelectedListener selectedListener;
    private EditText search;
    private CarolAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.carol_list_layout, container, false);
        carolListView = (ListView) view.findViewById(R.id.carolListView);
        carolListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                selectedListener.onCarolSelected(repository.getCarols().get(position));
            }
        });

        repository = new CarolJsonRepository(loadCarolsFile(view));
        repository.loadCarols();

        adapter = new CarolAdapter(getActivity().getApplicationContext(), repository.getCarols());
        carolListView.setAdapter(adapter);

        search = (EditText)view.findViewById(R.id.search);
        search.addTextChangedListener(new TextWatcher() {
              @Override
              public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                  // TODO Auto-generated method stub
              }

              @Override
              public void onTextChanged(CharSequence s, int start, int before, int count) {
                  // TODO Auto-generated method stub
              }

              @Override
              public void afterTextChanged(Editable s) {
                  String text = search.getText().toString().toLowerCase(Locale.getDefault());
                  adapter.filter(text);
              }
        });

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ItemSelectedListener){
            selectedListener = (ItemSelectedListener)activity;
        }else {
            throw new ClassCastException(activity.toString() + " must implement interface ItemSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        selectedListener = null;
    }

    private String loadCarolsFile(View view) {
        InputStream is = null;
        try {
            is = view.getContext().getAssets().open("carols.json");

            int size = is.available();

            byte[] buffer = new byte[size];
            is.read(buffer);

            return new String(buffer);
        } catch (IOException e) {
            return "";
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
