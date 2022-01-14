import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Objects;

/**
 * Book POJO which maps to the Books table.
 */
@DynamoDBTable(tableName = "ComicBookDB")
public class ComicBook {
    private String cbid;
    private String title;
    private Integer issue;
    private String writer;
    private String penciler;
    private Integer yearPublished;

    @DynamoDBHashKey(attributeName = "cbid")
    public String getCbid() {
        return cbid;
    }

    public void setCbid(String cbid) {
        this.cbid = cbid;
    }

    @DynamoDBAttribute(attributeName = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @DynamoDBAttribute(attributeName = "issue")
    public Integer getIssue() {
        return issue;
    }

    public void setIssue(Integer issue) {
        this.issue = issue;
    }

    @DynamoDBAttribute(attributeName = "writer")
    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    @DynamoDBAttribute(attributeName = "penciler")
    public String getPenciler() {
        return penciler;
    }

    public void setPenciler(String penciler) {
        this.penciler = penciler;
    }

    @DynamoDBAttribute(attributeName = "year_published")
    public Integer getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(Integer yearPublished) {
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return "ComicBook{" +
                "cbid='" + cbid + '\'' +
                ", title='" + title + '\'' +
                ", issue=" + issue +
                ", writer='" + writer + '\'' +
                ", penciler='" + penciler + '\'' +
                ", yearPublished=" + yearPublished +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComicBook comicBook = (ComicBook) o;
        return getCbid().equals(comicBook.getCbid()) && getTitle().equals(comicBook.getTitle()) && getIssue().equals(comicBook.getIssue()) && getWriter().equals(comicBook.getWriter()) && getPenciler().equals(comicBook.getPenciler()) && getYearPublished().equals(comicBook.getYearPublished());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCbid(), getTitle(), getIssue(), getWriter(), getPenciler(), getYearPublished());
    }
}
