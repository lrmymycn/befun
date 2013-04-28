package com.befun.domain.profile;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
@DiscriminatorValue("Client")
@PrimaryKeyJoinColumn(name = "CLIENT_ID")
public class Client extends Profile {

    private static final long serialVersionUID = 8457225248069897238L;

    @Column(name = "ADDRESS", length = 200)
    private String address;
}
