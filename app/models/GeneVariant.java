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
    private String mappingAlias;
    private String transcriptRegion;
    private String reportedClassification;
    private LocalDate lastEvaluated;
    private LocalDate lastUpdated;

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

    public String getMappingAlias() {
        return mappingAlias;
    }

    public String getTranscriptRegion() {
        return transcriptRegion;
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

    public static final Finder<Long, GeneVariant> find = new Finder<>(GeneVariant.class);
}
