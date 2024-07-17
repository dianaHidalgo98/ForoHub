package com.alura.forohub.domain.topico;

import java.time.LocalDateTime;

public record DataTopicResponse(
        String title, String content, LocalDateTime createdAt, boolean status, String author, String course
) {
}

