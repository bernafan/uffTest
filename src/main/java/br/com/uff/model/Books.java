package br.com.uff.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Component
@Entity
@Data
public class Books {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String author;
}
