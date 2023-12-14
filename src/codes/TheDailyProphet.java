package codes;

import java.util.Date;
import java.util.Objects;

public class TheDailyProphet {
    private Date date;

    /**
     * @generated
     */
    private String description;

    /**
     * @generated
     */
    private String title;
    TheDailyProphet(){

    }
    TheDailyProphet(String title, String description){
        this.description = description;
        this.title = title;
    }
    public Date getDate() {
        return this.date;
    }

    /**
     * @generated
     */

    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @generated
     */

    public String getDescription() {
        return this.description;
    }

    /**
     * @generated
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @generated
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * @generated
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nDescription: " + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TheDailyProphet news = (TheDailyProphet) o;

        if (!Objects.equals(date, news.date)) return false;
        if (!Objects.equals(description, news.description)) return false;
        return Objects.equals(title, news.title);
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}

