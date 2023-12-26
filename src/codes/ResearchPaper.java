package codes;

public class ResearchPaper {
    private User author;
    private String name;
    private String description;
    private String pages;
    private int citation;
    ResearchPaper(){};

    ResearchPaper(User author,String name, String description, String pages, int citation){
        this.author = author;
        this.name = name;
        this.description = description;
        this.pages = pages;
        this.citation = citation;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public int getCitation() {
        return citation;
    }

    public void setCitizion(int citation) {
        this.citation = citation;
    }

    @Override
    public String toString() {
        return "ResearchPaper{" +
                "author=" + author +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", pages='" + pages + '\'' +
                ", citation=" + citation +
                '}';
    }
}
