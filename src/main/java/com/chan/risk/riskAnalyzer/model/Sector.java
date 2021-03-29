package com.chan.risk.riskAnalyzer.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="SECTOR")
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="sector_id")
    private Integer sectorId;

    @Column(name="sector_name")
    private String sectorName;

    @Column(name="sub_sector_id")
    private Integer subSectorId;

    @Column(name="sub_sector_name")
    private String subSectorName;

    @Column(name="facilitie_id")
    private Integer facilitieId;

    @Column(name="facilitie_name")
    private String facilitieName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSectorId() {
        return sectorId;
    }

    public void setSectorId(Integer sectorId) {
        this.sectorId = sectorId;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public Integer getSubSectorId() {
        return subSectorId;
    }

    public void setSubSectorId(Integer subSectorId) {
        this.subSectorId = subSectorId;
    }

    public String getSubSectorName() {
        return subSectorName;
    }

    public void setSubSectorName(String subSectorName) {
        this.subSectorName = subSectorName;
    }

    public Integer getFacilitieId() {
        return facilitieId;
    }

    public void setFacilitieId(Integer facilitieId) {
        this.facilitieId = facilitieId;
    }

    public String getFacilitieName() {
        return facilitieName;
    }

    public void setFacilitieName(String facilitieName) {
        this.facilitieName = facilitieName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sector sector = (Sector) o;
        return Objects.equals(id, sector.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
