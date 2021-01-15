package isevo.news;

/**
 * dohvacanje objekta sa json-a
 */
public class Pagination {

    /**
     * vrijednost limit
     */
    private int limit;
    /**
     * vrijednost offset
     */
    private int offset;
    /**
     * vrijednost count
     */
    private int count;
    /**
     * vrijednost total
     */
    private int total;

    /**
     * dohvacanje vrijednosti limit
     * @return limit
     */
    public int getLimit() {
        return limit;
    }

    /**
     * dohvacanje vrijednosti offset
     * @return offset
     */
    public int getOffset() {
        return offset;
    }

    /**
     * dohvacanje vrijednosti count
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * dohvacanje vrijednosti total
     * @return total
     */
    public int getTotal() {
        return total;
    }


    /**
     * postavljanje vrijednosti limit
     * @param limit
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * postavljenje vrijednosti izvora
     * @param offset
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * postavljenje vrijednosti count
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * postavljenje vrijednosti total
     * @param total
     */
    public void setTotal(int total) {
        this.total = total;
    }


}
