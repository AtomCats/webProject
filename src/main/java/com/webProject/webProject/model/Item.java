package com.webProject.webProject.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Item name is required.")
    @Basic(optional = false)
    private String name;

    @NotNull(message = "Item category is required.")
    @Basic(optional = false)
    private String category;

    private String pictureUrl;
    private String url;

    public Item(@NotNull(message = "Item name is required.") String name, @NotNull(message = "Item category is required.") String category, String pictureUrl, String url) {
        this.name = name;
        this.category = category;
        this.pictureUrl = pictureUrl;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
