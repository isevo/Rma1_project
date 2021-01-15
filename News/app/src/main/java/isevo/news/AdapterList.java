package isevo.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Adapter
 */
public class AdapterList extends RecyclerView.Adapter<AdapterList.Red>{
    /**
     * lista objekata
     */
    private List<News>list_news;
    /**
     * objekt tipa layoutInflater
     */
    private LayoutInflater layoutInflater;
    /**
     * listener interface-a
     */
    private ItemClickInterface itemClickInterface;

    /**
     * konstruktor
     * @param context
     */
    public AdapterList(Context context) {
        layoutInflater= LayoutInflater.from(context);
    }

    /**
     *
     * @param list_news lista objekata
     */
    public void setList_news(List<News> list_news) {
        this.list_news = list_news;
    }
    @NonNull
    @Override
    public AdapterList.Red onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.list_of_elements,parent,false);
        return new Red(view);
    }

    /**
     * postavljanje vrijednosti u elemente layout-a
     * @param holder
     * @param position pozicija za svaki element liste
     */
    @Override
    public void onBindViewHolder(@NonNull AdapterList.Red holder, int position) {
       // System.out.println("---------------------->"+list_news.get(0).getTitle());
        News News =list_news.get(position);
        holder.title.setText(News.getTitle());
        holder.source.setText("SOURCE: "+News.getSource());
        holder.date.setText("DATE: "+News.getDate());
    }

    /**
     * pregledavanje je li lista prazna
     * @return
     */
    @Override
    public int getItemCount() {
        if (list_news==null){
            return 0;
        }
        else
        {
            return list_news.size();
        }
    }

    /**
     * klasa u kojoj je definiran dogadaj klika na karticu
     *
     */
    public class Red extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView title;
        private TextView source;
        private  TextView date;

        public Red(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.textViewTitle);
            source=itemView.findViewById(R.id.textViewource);
            date=itemView.findViewById(R.id.textViewdate);
            itemView.setOnClickListener(this);
        }

        public void onClick(View view) {
            if (itemClickInterface == null) {
                return;
            }
            list_news.get(getAdapterPosition());
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

            itemClickInterface.onItemClick(list_news.get(getAdapterPosition()));

          //  itemClickInterface.onItemClick(list_news.get(1));
        }
    }

    /**
     * iterface sa metodom
     */
    public interface ItemClickInterface{
        void onItemClick(News news);
    }

    /**
     * listener- okidač za klik na karticu
     * @param itemClickInterface
     */
    public void setItemClickInterface(ItemClickInterface itemClickInterface) {
        this.itemClickInterface = itemClickInterface;
    }
}
