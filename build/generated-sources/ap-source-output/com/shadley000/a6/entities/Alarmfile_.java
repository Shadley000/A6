package com.shadley000.a6.entities;

import com.shadley000.a6.entities.Errorlog;
import com.shadley000.a6.entities.Installation;
import com.shadley000.a6.entities.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-11T16:44:08")
@StaticMetamodel(Alarmfile.class)
public class Alarmfile_ { 

    public static volatile SingularAttribute<Alarmfile, String> fileName;
    public static volatile SingularAttribute<Alarmfile, Integer> dataLines;
    public static volatile SingularAttribute<Alarmfile, Integer> dataSkipped;
    public static volatile SingularAttribute<Alarmfile, Integer> dataInserted;
    public static volatile SingularAttribute<Alarmfile, Integer> dataError;
    public static volatile SingularAttribute<Alarmfile, Date> firstDate;
    public static volatile SingularAttribute<Alarmfile, Installation> idInstallation;
    public static volatile SingularAttribute<Alarmfile, Integer> id;
    public static volatile SingularAttribute<Alarmfile, Users> idUsers;
    public static volatile CollectionAttribute<Alarmfile, Errorlog> errorlogCollection;
    public static volatile SingularAttribute<Alarmfile, Date> loadDate;
    public static volatile SingularAttribute<Alarmfile, Date> lastDate;

}