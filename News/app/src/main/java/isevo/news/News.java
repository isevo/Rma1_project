package isevo.news;

import java.io.Serializable;

/**
 * klasa koja sprema vrijednosti json objekta
 */
public class News implements Serializable {
    /**
     * sprema vrijednost autora
     */
    private String author;
    /**
     * sprema vrijednost naslova
     */
    private String title;
    /**
     * sprema vrijednost opisa
     */
    private String description;
    /**
     * sprema vijednost url-a
     */
    private String url;
    /**
     * sprema vijednost izvora
     */
    private String source;
    /**
     * sprema vijednost url slike
     */
    private String image;
    /**
     * sprema vijednost kategorije vijesti
     */
    private String category;
    /**
     * sprema vijednost jezika
     */
    private String language;
    /**
     * sprema vijednost drzave
     */
    private String country;
    /**
     * sprema vijednost datuma objave
     */
    private String published_at;

    /**
     * konstruktor
     * @param title naslov
     * @param date datum
     * @param source izvor
     */
    public News(String title, String date, String source) {
        this.title=title;
        this.published_at=date;
        this.source=source;
    }

    /**
     * dohvaca datum
     * @return pulished_at
     */

    public String getDate() {
        return published_at;
    }

    /**
     * dohvaca naslov
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * dohvacanje opisa
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * dohvacane url slike
     * @return image
     */
    public String getImage() {
        return image;
    }

    /**
     * dohvacanje izvora
     * @return source
     */
    public String getSource() {
        return source;
    }

    /**
     * postavljanje vrijednosti naslova
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * postavljanje opisa
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * postavljanje vrijednosti url slike
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * postavljenje izvora
     * @param source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * postavljenje datuma
     * @param date
     */
    public void setDate(String date) {
        this.published_at = date;
    }

    /**
     * dohvacanje autora
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * postavljenje url-a
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * dohvacanje kategorije
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     * dohvacanje jezike
     * @return language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * postavljanje drzave
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * postavljenje autora
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * postavljenje url-a
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * postavljenje kategorije
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * postavljenje jezike
     * @param language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * postavljenje drzave
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }


}
