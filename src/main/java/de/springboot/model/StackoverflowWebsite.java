package de.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class StackoverflowWebsite {
    @Id
    private String id;
    //@Field spring will do it automatic
    private String website;
    private String iconImageUrl;
    private String title;
    private String description;
}
