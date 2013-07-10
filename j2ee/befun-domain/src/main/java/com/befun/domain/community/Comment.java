package com.befun.domain.community;

import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.befun.domain.BaseModel;
import com.befun.domain.profile.Profile;

@Entity
@Table(name = "COMMENT_REC")
@TableGenerator(name = "commentGenerator", table = "ID_GENERATOR", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "comment", allocationSize = 1)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "comment")
public class Comment implements BaseModel<Long> {

    private static final long serialVersionUID = -8513720307562351486L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "commentGenerator")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", name = "PROFILE_ID")
    private Profile profile;

    @Column(name = "GUEST_NAME")
    private String guestName;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Column(name = "ENABLED")
    private boolean enabled;

    @Column(name = "ENABLED_DATE")
    private Date enabledDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", name = "ENABLED_BY")
    private Profile enabledBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", name = "PARENT_ID")
    private Comment parentComment;

    @OneToMany(mappedBy = "parentComment", fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE })
    @OrderBy("creationDate ASC")
    private List<Comment> subComments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getEnabledDate() {
        return enabledDate;
    }

    public void setEnabledDate(Date enabledDate) {
        this.enabledDate = enabledDate;
    }

    public Profile getEnabledBy() {
        return enabledBy;
    }

    public void setEnabledBy(Profile enabledBy) {
        this.enabledBy = enabledBy;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public List<Comment> getSubComments() {
        return subComments;
    }

    public void setSubComments(List<Comment> subComments) {
        this.subComments = subComments;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((content == null) ? 0 : content.hashCode());
        result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
        result = prime * result + (enabled ? 1231 : 1237);
        result = prime * result + ((enabledDate == null) ? 0 : enabledDate.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Comment other = (Comment) obj;
        if (content == null) {
            if (other.content != null) return false;
        } else if (!content.equals(other.content)) return false;
        if (creationDate == null) {
            if (other.creationDate != null) return false;
        } else if (!creationDate.equals(other.creationDate)) return false;
        if (enabled != other.enabled) return false;
        if (enabledDate == null) {
            if (other.enabledDate != null) return false;
        } else if (!enabledDate.equals(other.enabledDate)) return false;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        if (title == null) {
            if (other.title != null) return false;
        } else if (!title.equals(other.title)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Comment [id=" + id + ", guestName=" + guestName + ", title=" + title + ", content=" + content + ", creationDate=" + creationDate + ", enabled="
               + enabled + ", enabledDate=" + enabledDate + "]";
    }

}
