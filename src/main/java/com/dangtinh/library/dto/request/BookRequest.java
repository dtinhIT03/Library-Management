package com.haianh123.library.dto.request;

import com.haianh123.library.entity.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    private String name;
    private int publishingYear;
    private String description;
    private BigDecimal price;
    private int inventoryNumber;
    private int pageNumber;
    private String status;
    private String language;
    private float weight;
    private String size;
    private int author;
    private int category;
    private int publisher;
    private List<Image> images;

}
