package com.befun.web.view;

import java.util.Date;

import com.befun.domain.estate.Stage;

public class StageView extends BaseEasteView<Stage> {

    private static final long serialVersionUID = 8472013261079987847L;

    private Long projectId;

    //
    private String name;

    private String description;

    private Date finishDate;

    private Integer sold;

    private boolean soldOut;

    public StageView() {
        super();
    }
    
    public StageView(Stage model) {
        super(model);
    }

    @Override
    public Stage getModel() {
        return this.model;
    }

    //

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public boolean isSoldOut() {
        return soldOut;
    }

    public void setSoldOut(boolean soldOut) {
        this.soldOut = soldOut;
    }

}
