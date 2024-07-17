package com.alura.forohub.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    @Column(unique = true)
    private String content;
    private LocalDateTime createdAt;
    private boolean status;
    private String author;
    private String course;

    public Topico(DataTopicRegister dataTopicRegister) {
        this.createdAt = LocalDateTime.now();
        this.status = true;
        this.title = dataTopicRegister.title();
        this.content = dataTopicRegister.content();
        this.author = dataTopicRegister.author();
        this.course = dataTopicRegister.course();
    }

    public void actualizarDatos(DataTopicUpdate dataTopicUpdate) {

        if (dataTopicUpdate.title() != null) {
            this.title = dataTopicUpdate.title();
        }
        if (dataTopicUpdate.content() != null) {
            this.content = dataTopicUpdate.content();
        }

    }

}
