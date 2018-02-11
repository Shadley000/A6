package com.shadley000.a6.entities;

import com.shadley000.a6.entities.Installation;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-10T18:59:37")
@StaticMetamodel(Vendor.class)
public class Vendor_ { 

    public static volatile SingularAttribute<Vendor, String> nname;
    public static volatile SingularAttribute<Vendor, String> logo;
    public static volatile SingularAttribute<Vendor, Integer> id;
    public static volatile CollectionAttribute<Vendor, Installation> installationCollection;

}