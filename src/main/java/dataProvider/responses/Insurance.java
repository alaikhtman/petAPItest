package dataProvider.responses;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnore;

public class Insurance {

    private String tabName;

    @JsonIgnore
    private TabContent tabContent;

    public String getTabName() {
        return tabName;
    }


    public TabContent getTabContent() {
        return tabContent;
    }
}
