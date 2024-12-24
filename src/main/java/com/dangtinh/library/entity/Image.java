package com.haianh123.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblimage")
public class Image {

    @Id
    @Column(name = "image_id", nullable = false)
    private int id;

    @Column(name = "image_link", nullable = false, length = 125)
    private String link;

    @Column(name = "image_avatar")
    private boolean avatar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    @JsonIgnore
    private Book book;
}
