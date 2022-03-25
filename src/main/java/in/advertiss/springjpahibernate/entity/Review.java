package in.advertiss.springjpahibernate.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private long id;
    private String rating;
    private String desc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    public Review() {
    }

    public Review(String rating, String desc) {
        this.rating = rating;
        this.desc = desc;
    }

    public Review(String rating, String desc, Course course) {
        this.rating = rating;
        this.desc = desc;
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", rating='" + rating + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
