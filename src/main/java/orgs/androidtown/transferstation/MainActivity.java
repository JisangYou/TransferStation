package orgs.androidtown.transferstation;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import orgs.androidtown.transferstation.model.JsonClass;
import orgs.androidtown.transferstation.model.Row;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        load("http://openapi.seoul.go.kr:8088/47516265416a697337374e7872556a/json/StationDayTrnsitNmpr/1/100/");
    }

    private void load(String url) {
        new AsyncTask<String, Void, String>() {

            @Override
            protected String doInBackground(String...args ) {
                String param1 = args[0];
                String str = Remote.getData(param1);
                Log.d("데이터가 들어오나?","=========================="+str);
                return str;
            }

            @Override
            protected void onPostExecute(String jsonstr) {

                data = parse(jsonstr);

                setList();
            }
        }.execute(url);
    }

    private List<Row> parse(String str) {
        Gson gson = new Gson();
        JsonClass json = gson.fromJson(str, JsonClass.class);
        Row row[] = json.getStationDayTrnsitNmpr().getRow();
        List<Row> rows = Arrays.asList(row);
        return rows;
    }

    List<Row> data;

    private void setList() {
        RecyclerAdapter adapter = new RecyclerAdapter(data, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}
