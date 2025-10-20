package com.medlink.portal.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SelectedListItem {

    // Getters and Setters
    private String text;
    private String value;
    private boolean selected;

    public SelectedListItem(String text, String value, boolean selected) {
        this.text = text;
        this.value = value;
        this.selected = selected;
    }

}

