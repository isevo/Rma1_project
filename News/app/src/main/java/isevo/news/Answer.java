package isevo.news;

import java.util.List;

/**
 * dohvaca elemnte sa api-a
 */
public class Answer {

    /**
     * objekt tipa Pagination
     */
    private Pagination pagination;
    /**
     * lista objekata
     */
    private List<News> data;

    /**
     * za dohvacanje objekta
     * @return pagination
     */
    public Pagination getPagination() {
        return pagination;
    }

    /**
     * za postavljanje vrijednosti objekta
     * @param pagination
     */
    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    /**
     * za dohvacanje liste
     * @return
     */
    public List<News> getData() {
        return data;
    }

    /**
     * za postavljanje liste
     * @param data
     */
    public void setData(List<News> data) {
        this.data = data;
    }
}
