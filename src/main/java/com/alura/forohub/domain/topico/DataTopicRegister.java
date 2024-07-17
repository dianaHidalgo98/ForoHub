package com.alura.forohub.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record DataTopicRegister(

        @NotBlank
        String title,
        @NotBlank
        String content,
        @NotBlank
        String author,
        @NotBlank
        String course

) {
}
