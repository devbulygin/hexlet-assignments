package exercise.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.FetchType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@Entity
@Table(name = "comments")
public class Comment {


    // BEGIN
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Post post;
    // END
}
