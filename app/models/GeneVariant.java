package models;

import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class GeneVariant extends Model {
    @Id
    private UUID id;
    @ManyToOne
    private Gene gene;
    private String ntChange;
    private String proteinChange;
    private String alias;
    private String region;
    private String reportedClassification;
    private LocalDate lastEvaluated;
    private LocalDate lastUpdated;
    private String source;
    private String url;

    public UUID getId() {
        return id;
    }

    public Gene getGene() {
        return gene;
    }

    public String getNtChange() {
        return ntChange;
    }

    public String getProteinChange() {
        return proteinChange;
    }

    public String getAlias() {
        return alias;
    }

    public String getRegion() {
        return region;
    }

    public String getReportedClassification() {
        return reportedClassification;
    }

    public LocalDate getLastEvaluated() {
        return lastEvaluated;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public String getSource() {
        return source;
    }

    public String getUrl() {
        return url;
    }

    public static final Finder<Long, GeneVariant> find = new Finder<>(GeneVariant.class);
}
