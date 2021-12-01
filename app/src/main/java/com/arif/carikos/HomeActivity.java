package com.arif.carikos;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arif.carikos.Network.Responserver;
import com.arif.carikos.Network.Retroserver;
import com.arif.carikos.Network.service;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity  {
    private static final String URL_LIST_KOST = "http://www.carikos.mwebs.id/list.php";
    private RecyclerView rc_kos;
    EditText efde;

    //private ArrayList<Kost> listKost = new ArrayList<>();
    CarouselView carouse;
    List<Kost> listKost;
    ListKostAdapter adapter;
    service service;
    SearchView searchView;
    Button btn;
    Context contex;
    int[] sampleImages = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        rc_kos = findViewById(R.id.rc_kos);
        rc_kos.setHasFixedSize(true);
       // efde = findViewById(R.id.editText);
        searchView = findViewById(R.id.searchkos);
        //listKost.addAll(KostData.getListData());

        listKost = new ArrayList<>();

        rc_kos.setAdapter(adapter);

        carouse = findViewById(R.id.carou);
        carouse.setPageCount(sampleImages.length);
        carouse.setImageListener(imageListener);
      //  btn = findViewById(R.id.button);

        rc_kos.setLayoutManager(new LinearLayoutManager(this));

        kosData();




//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                startActivity(new Intent(HomeActivity.this,DetailActivity.class));
//            }
//        });


searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
    @Override
    public boolean onQueryTextSubmit(String query) {
//        Toast.makeText(getApplicationContext(),"sdhfjsd",Toast.LENGTH_LONG).show();
        api(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
//        Toast.makeText(getApplicationContext(),"sdhfjsd",Toast.LENGTH_LONG).show();
        api(newText);
        return true;
    }
});
    }


    private void api(String key){
        service api = Retroserver.getclient().create(service.class);
        Call<Responserver> getdata =api.getlistkos(key);
        getdata.enqueue(new Callback<Responserver>() {
            @Override
            public void onResponse(Call<Responserver> call, Response<Responserver> response) {
//                Toast.makeText(getApplicationContext(),response.body().getKode(),Toast.LENGTH_LONG).show();
                Log.d("Retro","Response : "+response.code());
                listKost = response.body().getData();
                adapter = new ListKostAdapter(getApplicationContext(), (ArrayList<Kost>) listKost);
                rc_kos.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Responserver> call, Throwable t) {

            }
        });
    }



    // gambar bergerak
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };


//       searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//        @Override
//        public boolean onQueryTextSubmit(String query) {
//            api(query);
//            return false;
//        }
//
//        @Override
//        public boolean onQueryTextChange(String newText) {
//            api(newText);
//            return false;
//        }
//    });



// pfungsi data dari web server
    private void kosData() {
        service api = Retroserver.getclient().create(service.class);
        Call<Responserver> getdata = api.getlistkos();
        getdata.enqueue(new Callback<Responserver>() {
            @Override
            public void onResponse(Call<Responserver> call, Response<Responserver> response) {
                //Toast.makeText(getApplicationContext(),""+response.body().getKode(),Toast.LENGTH_LONG).show();
                listKost = response.body().getData();
                adapter = new ListKostAdapter(getApplicationContext(),(ArrayList<Kost>) listKost);
                rc_kos.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Responserver> call, Throwable t) {
             //  efde.setText(""+t);



            }
        });
    }































//    public void fetchContact(String type, String key){
//
//        service = Retroserver.getclient().create(service.class);
//
//        Call<Responserver> call = service.getlistkos(type, key);
//        call.enqueue(new Callback<Responserver>() {
//            @Override
//            public void onResponse(Call<Responserver> call, Response<Responserver> response) {
//                progressBar.setVisibility(View.GONE);
//                listKost = response.body().getData();
//                adapter = new ListKostAdapter(getApplicationContext(), listKost);
//                rc_kos.setAdapter(adapter);
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onFailure(Call<Responserver> call, Throwable t) {
//                progressBar.setVisibility(View.GONE);
//                Toast.makeText(HomeActivity.this, "Error\n"+t.toString(), Toast.LENGTH_LONG).show();
//            }
//        });
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//       // inflater.inflate(R.menu.menu, menu);
//
//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView = (SearchView) menu.findItem(R.id.searchView).getActionView();
//        searchView.setSearchableInfo(
//                searchManager.getSearchableInfo(getComponentName()));
//        searchView.setIconifiedByDefault(false);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                fetchContact("users", query);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                fetchContact("users", newText);
//                return false;
//            }
//        });
//        return true;
//    }
}







