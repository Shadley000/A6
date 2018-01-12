package com.shadley000.a6.entities;

import com.shadley000.a6.entities.Installation;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-11T16:44:08")
@StaticMetamodel(Contractor.class)
public class Contractor_ { 

    public static volatile SingularAttribute<Contractor, String> nname;
    public static volatile SingularAttribute<Contractor, String> logo;
    public static volatile SingularAttribute<Contractor, Integer> id;
    public static volatile CollectionAttribute<Contractor, Installation> installationCollection;

}