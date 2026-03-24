package dev.cris97.fms.models;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class FoodDTO {
    private String uuid;
    private String name;
    private String categ;
    private Integer calor;
    private BigDecimal pric;
    private boolean availa;
    private LocalDate expi;
    private LocalDateTime creat;


    public FoodDTO(){

    }


    public String getUuid() {
        return uuid;
    }
    public String getName() {
        return name;
    }
    public String getCateg() {
        return categ;
    }
    public Integer getCalor() {
        return calor;
    }
    public BigDecimal getPric() {
        return pric;
    }
    public boolean isAvaila() {
        return availa;
    }
    public LocalDate getExpi() {
        return expi;
    }
    public LocalDateTime getCreat() {
        return creat;
    }


    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCateg(String categ) {
        this.categ = categ;
    }
    public void setCalor(Integer calor) {
        this.calor = calor;
    }
    public void setPric(BigDecimal pric) {
        this.pric = pric;
    }
    public void setAvaila(boolean availa) {
        this.availa = availa;
    }
    public void setExpi(LocalDate expi) {
        this.expi = expi;
    }
    public void setCreat(LocalDateTime creat) {
        this.creat = creat;
    }
}
