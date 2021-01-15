package isevo.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

/**
 *
 * @author :ivana
 */
public class MainActivity extends AppCompatActivity implements AdapterList.ItemClickInterface {
    /**
     * varijabla u kojoj je spremljena text. vrijednost news kao dio url-a
     */
    private static final String NEWS ="news" ;
    /**
     * kolekcija kartica
     */
    private RecyclerView recyclerView;
    /**
     * objekt klase AdapterList
     */
    private AdapterList adapterList;

    /**
     *
     * @param savedInstanceState
     * glavna metoda u kojoj se pokreću sve ostale
     * pozivanje i izvrsavanje klase RESTTASK
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapterList=new AdapterList(this);
        adapterList.setItemClickInterface(this);

        recyclerView.setAdapter(adapterList);



        String url = getString(R.string.REST_API) +NEWS+ "?"+getString(R.string.REST_API1)+"&"+getString(R.string.REST_API_KEY2)+"&"+getString(R.string.REST_API_KEY);

        RESTTask task = new RESTTask();
        task.execute(url);

    }

    /**
     * omogucuje povezivanje sa url-om
     */

    public class RESTTask extends AsyncTask<String,Void, List<News>> {
        @Override
        protected List<News> doInBackground(String... strings) {

            String adresa =strings[0];

            try {
                URL url=new URL(adresa);
                System.out.println("-----------------------------------------------------------"+adresa);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.connect();

                InputStreamReader inputStreamReader = new InputStreamReader((httpURLConnection.getInputStream()));
                System.out.println("***********************************************"+inputStreamReader);
                BufferedReader bufferedReader = new BufferedReader((inputStreamReader));

                System.out.println("***********************************************"+bufferedReader);

                Answer answer = new Gson().fromJson(bufferedReader,Answer.class);
                System.out.println("ODGOVOR:#############################################################################"+answer.getPagination().getCount());
                System.out.println("ODGOVOR:#############################################################################"+answer.getPagination().getLimit());
                System.out.println("ODGOVOR:#############################################################################"+answer.getPagination().getTotal());

                bufferedReader.close();
                inputStreamReader.close();

                if (answer.getPagination().getLimit()!=20){
                    System.out.println("LALALALALALALA");
                    System.out.println(answer.getPagination().getLimit());
                    System.out.println(answer.getPagination().getCount());
                    return null;
                }
                System.out.println("?????????????????"+answer.getPagination().getOffset());

                for (int i =0;i<answer.getData().size();i++){
                    System.out.println(i+"?????????????????"+answer.getData().get(i).getImage());
                    //System.out.println("DESCRIPTIN: "+answer.getData().get(i).getDescription());

                }

                return answer.getData();

            } catch (MalformedURLException e) {
                System.out.println("ERROR1");
                e.printStackTrace();
            } catch (ProtocolException e) {
                System.out.println("ERROR2");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("ERROR3");
                e.printStackTrace();
            }

            return null;
        }

        /**
         *
         * @param News lista objekata tipa News
         * postavljanje liste tj njenih vrijednosti koristeci set metodu
         */
        @Override
        protected void onPostExecute(List<News> News) {
            adapterList.setList_news(News);
            adapterList.notifyDataSetChanged();
        }
    }

    /**
     *
     * @param News objekt klase News
     * klikom na karticu se otvara slajd
     * na slajd se prenose vrijednosti
     */
    @Override
    public void onItemClick(News News) {
        System.out.println("#####################");
        System.out.println(News.getTitle());
        Intent intent=new Intent(this, details.class);



        intent.putExtra("news", News);
        startActivity(intent);



    }
}