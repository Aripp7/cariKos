package com.arif.carikos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailActivity extends AppCompatActivity {

    Button contact;

    TextView nama;
    TextView harga;
    TextView ukuran;

    TextView alamat;
    TextView wifi;
    TextView ac;
    ImageView image;
    FloatingActionButton btnflo;
    String latid;
    String id;
    String longit;

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
       // String Nama,Harga,Images,Ukuran,Kamarmandi,Alamat,Wifi,Ac;

        image = findViewById(R.id.image_view);
        nama = findViewById(R.id.nama_kos);
        alamat = findViewById(R.id.tv_alamat);
        harga = findViewById(R.id.tvharga);
        ukuran = findViewById(R.id.tv_ukuran);
        wifi = findViewById(R.id.tv_wifi);
        ac = findViewById(R.id.tv_ac);
        btnflo = findViewById(R.id.btnflo);

        btnflo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this,MapsActivity.class);
                intent.putExtra("latitude",latid);
                intent.putExtra("longitude",longit);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
        String imgUrl =  "http://carikos.mwebs.id/gambar/";

       // sessionManager = new SessionManager(getApplicationContext());
        final Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Glide.with(getApplicationContext())
                    .load(""+imgUrl+"/"+bundle.getString("foto"))
                    .apply(new RequestOptions())
                    .into(image);

            nama.setText(bundle.getString("nama_kos"));
            harga.setText(bundle.getString("harga"));
            ukuran.setText(bundle.getString("ukuran"));
            alamat.setText(bundle.getString("alamat"));
            wifi.setText(bundle.getString("wifi"));
            ac.setText(bundle.getString("ac"));
            latid = bundle.getString("latitude");
            longit = bundle.getString("longitude");
            id =bundle.getString("nama_kos");



        }



//        contact.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openWA();
//            }
//        });


    }

    public void openWA(View view) {


        String number = "+6285263156326";
        String Pesan = ("hai, Apakah Kost ini masih tersedia?"+nama);
        String url = "https://api.whatsapp.com/send?phone="+number;
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.putExtra(Intent.EXTRA_TEXT, Pesan);
        i.setType("text/plain");
        i.setData(Uri.parse(url));

        startActivity(i);
    }





}
//        String Pesan = ("hai, Apakah Kost ini masih tersedia?");
//        Intent senWA = new Intent();
//        senWA.setAction(Intent.ACTION_SEND);
//        senWA.putExtra(Intent.EXTRA_TEXT, Pesan);
//        senWA.putExtra("jid", "+6285263156326" + "@s.whatsapp.net");
//        senWA.setType("text/plain");
//        senWA.setPackage("com.whatsapp");
//        startActivity(senWA);







// Nama=getIntent().getStringExtra("nama");
//         Harga=getIntent().getStringExtra("harga");
//         Images=getIntent().getStringExtra("image");
//         Ukuran=getIntent().getStringExtra("ukuran");
//         Kamarmandi=getIntent().getStringExtra("kamarmandi");
//         Alamat=getIntent().getStringExtra("alamat");
//         Wifi=getIntent().getStringExtra("wifi");
//         Ac=getIntent().getStringExtra("ac");
//         nama=(TextView)findViewById(R.id.nama_kos);
//         harga=(TextView)findViewById(R.id.tvharga);
//         image= (ImageView) findViewById(R.id.image_view);
//         ukuran=(TextView)findViewById(R.id.tv_ukuran);
//
//         alamat=(TextView)findViewById(R.id.tv_alamat);
//         wifi=(TextView)findViewById(R.id.tv_wifi);
//         ac=(TextView)findViewById(R.id.tv_ac);
//
//
//         contact = (Button)findViewById(R.id.contact);
//
//
//
//
//         Glide.with(getApplicationContext())
//         .load(Images)
//         .apply(new RequestOptions())
//         .into(image);
//         nama.setText(Nama);
//         harga.setText(Harga);
//         ukuran.setText(Ukuran);
//         kamarmandi.setText(Kamarmandi);
//         alamat.setText(Alamat);
//         wifi.setText(Wifi);
//         ac.setText(Ac);