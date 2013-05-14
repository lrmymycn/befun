package com.befun.domain.estate;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.befun.domain.BaseEstateModel;

@Entity
@Table(name = "PROJECT_MEDIA")
@TableGenerator(name = "projectMediaGenerator", table = "ID_GENERATOR", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "projectMedia", allocationSize = 1)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region="project")
public class ProjectMedia implements BaseEstateModel<Long> {

    private static final long serialVersionUID = -5085346163844201100L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "projectMediaGenerator")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", name = "PROJECT_ID")
    private Project project;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", name = "MEDIA_ID")
    private Media media;

    @Embedded
    private ModelModification modelModification;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public ModelModification getModelModification() {
        return modelModification;
    }

    public void setModelModification(ModelModification modelModification) {
        this.modelModification = modelModification;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((media == null) ? 0 : media.hashCode());
        result = prime * result + ((modelModification == null) ? 0 : modelModification.hashCode());
        result = prime * result + ((project == null) ? 0 : project.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ProjectMedia other = (ProjectMedia) obj;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        if (media == null) {
            if (other.media != null) return false;
        } else if (!media.equals(other.media)) return false;
        if (modelModification == null) {
            if (other.modelModification != null) return false;
        } else if (!modelModification.equals(other.modelModification)) return false;
        if (project == null) {
            if (other.project != null) return false;
        } else if (!project.equals(other.project)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "ProjectMedia [id=" + id + ", project=" + project + ", media=" + media + ", modelModification=" + modelModification + "]";
    }

}
