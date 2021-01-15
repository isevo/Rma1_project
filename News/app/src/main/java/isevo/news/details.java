package isevo.news;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;

public class details extends AppCompatActivity {
    /**
     * metoda u kojoj se postvaljaju vrijednosti u elemente sa activity_details layout i definira se dogadaj klika na button
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        News News = (News) intent.getSerializableExtra("news");

        TextView TextViewDescription = findViewById(R.id.description);
        TextViewDescription.setText("DESCRIPTION: "+String.valueOf(News.getDescription()));

        TextView Title=findViewById(R.id.Title);
        Title.setText("TITLE: "+String.valueOf(News.getTitle()));


        Button nazad = findViewById(R.id.button);
        nazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        new DownloadImageTask(findViewById(R.id.image)).execute(News.getImage());


    }

    /**
     * klasa za ocitavanje slike putem url-a
     */
    private class DownloadImageTask  extends AsyncTask<String,Void,Bitmap> {


        private final ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;

            if (urldisplay!=null) {
                try {
                    InputStream in = new java.net.URL(urldisplay).openStream();
                    mIcon11 = BitmapFactory.decodeStream(in);
                } catch (Exception e) {
                    Log.e("Error", e.getMessage());
                    e.printStackTrace();
                }
                return mIcon11;
            }
            return null;
        }


        /**
         * postavljanje slike sa odredenim dimenzijama
         * @param result vrijednost proslijedeno iz metode doInBackground
         */
        protected void onPostExecute(Bitmap result) {
            System.out.println("RESULT: ");
            System.out.println(result);
            if(result==null){
                System.out.println("Null");
            }
            else{
                bmImage.setImageBitmap(result);
                bmImage.getLayoutParams().height=400;
                bmImage.getLayoutParams().width=400;
            }



        }
    }



}
