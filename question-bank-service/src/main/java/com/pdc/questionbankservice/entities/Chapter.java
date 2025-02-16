package com.pdc.questionbankservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "chapters")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Chapter extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String chapterId;

    @Column(name = "course_id", nullable = false)
    private UUID courseId;

    @OneToMany(mappedBy = "chapter", fetch = FetchType.LAZY)
    private List<Question> questions;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "chapter_no", nullable = false)
    private Integer chapterNo;
}
