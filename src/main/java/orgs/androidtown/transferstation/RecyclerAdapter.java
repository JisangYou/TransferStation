package orgs.androidtown.transferstation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import orgs.androidtown.transferstation.model.Row;

/**
 * Created by Jisang on 2017-10-17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Holder> {

    Context context;
    List<Row> data;

    public RecyclerAdapter(List<Row> data, Context context) {
        this.context = context;
        this.data = data;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Row row = data.get(position);

        holder.sn.setText(row.getSN());
        holder.stn_num.setText(row.getSTATN_NM());
        holder.weekday.setText(row.getWKDAY());
        holder.saturday.setText(row.getSATDAY());
        holder.sunday.setText(row.getSUNDAY());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView stn_num;
        TextView weekday;
        TextView sunday;
        TextView saturday;
        TextView sn;

        public Holder(View itemView) {
            super(itemView);
            stn_num = itemView.findViewById(R.id.textView2);
            weekday = itemView.findViewById(R.id.textView3);
            sunday = itemView.findViewById(R.id.textView5);
            saturday = itemView.findViewById(R.id.textView4);
            sn = itemView.findViewById(R.id.textView1);

        }
    }
}
