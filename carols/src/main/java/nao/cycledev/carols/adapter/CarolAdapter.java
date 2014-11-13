package nao.cycledev.carols.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import nao.cycledev.carols.R;
import nao.cycledev.carols.model.Carol;

import java.util.List;

public class CarolAdapter extends BaseAdapter {

    private List<Carol> carols;
    private LayoutInflater layoutInflater;

    public CarolAdapter(Context context, List<Carol> carols) {
        this.carols = carols;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return carols.size();
    }

    @Override
    public Object getItem(int position) {
        return carols.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ((Carol) carols.get(position)).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.carol_item_layout, parent, false);
        }

        Carol carol = getCarol(position);
        TextView carolTitle = (TextView) view.findViewById(R.id.txtCarolTitle);
        carolTitle.setText(carol.getTitle());
        return view;
    }

    private Carol getCarol(int position) {
        return (Carol) getItem(position);
    }
}
