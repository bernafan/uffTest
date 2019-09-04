package br.com.uff.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Component

@Entity

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Books {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.PRIVATE)
    private Long id;
    private String title;
    private String author;
}
