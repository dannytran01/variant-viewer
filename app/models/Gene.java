package models;

import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Gene extends Model {
    @Id
    public UUID id;
    public String name;

    public static final Finder<Long, Gene> find = new Finder<>(Gene.class);
}
