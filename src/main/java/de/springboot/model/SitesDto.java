package de.springboot.model;

import lombok.Data;

import java.util.List;

@Data
public class SitesDto {
    private List<SiteDto> items;
}
