package com.benchmark.todo.todo;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

public class TodoDTO {

  @Getter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class CreateRequest {

    LocalDateTime dueDate;
    @NotBlank
    @Length(max = 50)
    String description;

    public Todo toEntity(long userId) {
      return Todo.builder()
          .dueDate(dueDate)
          .description(description)
          .userId(userId)
          .build();
    }
  }

  @Getter
  @AllArgsConstructor
  public static class UpdateRequest {

    LocalDateTime dueDate;
    @NotBlank
    @Length(max = 50)
    String description;
  }

  // looking up full details
  @Getter
  @Builder
  public static class Detail {

    Long id;
    LocalDateTime datetime;
    String description;

    public static Detail of(Todo todo) {
      return Detail.builder()
          .id(todo.getId())
          .datetime(todo.getDueDate())
          .description(todo.getDescription())
          .build();
    }
  }

  // /todos, /todos/{id}
  @Getter
  @Builder
  public static class Slim {

    LocalDateTime datetime;
    String description;

    public static Slim of(Todo todo) {
      return Slim.builder()  
          .datetime(todo.getDueDate())
          .description(todo.getDescription())
          .build();
    }
  }
}
