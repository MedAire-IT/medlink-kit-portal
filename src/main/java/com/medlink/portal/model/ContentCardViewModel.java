package com.medlink.portal.model;


import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ContentCardViewModel extends BaseViewModel {

    // Getters and Setters
    private int kitId = 0;
    private int selectedIndustry;
    @Getter
    private List<SelectedListItem> industryTypes = new ArrayList<>();

    public ContentCardViewModel() {
//        industryTypes.add(new SelectedListItem("Aviation (SmartSheet)", "1", false));
        industryTypes.add(new SelectedListItem("Yachting", "2", false));
        selectedIndustry = 0;
    }

    public void setKitId(int kitId) {
        this.kitId = kitId;
    }

    public void setSelectedIndustry(int selectedIndustry) {
        this.selectedIndustry = selectedIndustry;
    }

    public void setIndustryTypes(List<SelectedListItem> industryTypes) {
        this.industryTypes = industryTypes;
    }
}

