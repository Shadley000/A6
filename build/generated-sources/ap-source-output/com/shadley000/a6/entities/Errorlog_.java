package com.shadley000.a6.entities;

import com.shadley000.a6.entities.Alarmfile;
import com.shadley000.a6.entities.Installation;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-15T06:28:58")
@StaticMetamodel(Errorlog.class)
public class Errorlog_ { 

    public static volatile SingularAttribute<Errorlog, String> originalText;
    public static volatile SingularAttribute<Errorlog, Integer> linenumber;
    public static volatile SingularAttribute<Errorlog, String> errorMessage;
    public static volatile SingularAttribute<Errorlog, Alarmfile> idFile;
    public static volatile SingularAttribute<Errorlog, Integer> id;
    public static volatile SingularAttribute<Errorlog, Installation> idInstallation;

}