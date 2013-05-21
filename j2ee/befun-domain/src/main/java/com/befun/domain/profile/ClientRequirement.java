package com.befun.domain.profile;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.befun.domain.Modification;
import com.befun.domain.ModificationModel;

@Entity
@Table(name = "DEPARTMENT")
@TableGenerator(name = "clientRequirementGenerator", table = "ID_GENERATOR", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "clientRequirement", allocationSize = 1)
public class ClientRequirement implements ModificationModel<Long> {

    private static final long serialVersionUID = -102971164729347498L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "clientRequirementGenerator")
    private Long id;

    @Embedded
    private Modification modification = Modification.createDefault();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Modification getModification() {
        return modification;
    }

    @Override
    public void setModification(Modification modification) {
        this.modification = modification;
    }

}
