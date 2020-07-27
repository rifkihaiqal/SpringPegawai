package com.example.SpringPegawai.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity @Table (name = "pegawai")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"masukPada"}, allowGetters = true)
public class Pegawai {
    @Id
    @GeneratedValue (strategy = javax.persistence.GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String namaDepanPegawai;

    @NotBlank
    private String namaBelakangPegawai;

    @NotBlank
    private String jabatanPegawai;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date masukPada;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaDepanPegawai() {
        return namaDepanPegawai;
    }

    public void setNamaDepanPegawai(String namaDepanPegawai) {
        this.namaDepanPegawai = namaDepanPegawai;
    }

    public String getNamaBelakangPegawai() {
        return namaBelakangPegawai;
    }

    public void setNamaBelakangPegawai(String namaBelakangPegawai) {
        this.namaBelakangPegawai = namaBelakangPegawai;
    }

    public String getJabatanPegawai() {
        return jabatanPegawai;
    }

    public void setJabatanPegawai(String jabatanPegawai) {
        this.jabatanPegawai = jabatanPegawai;
    }

    public Date getMasukPada() {
        return masukPada;
    }

    public void setMasukPada(Date masukPada) {
        this.masukPada = masukPada;
    }
}

