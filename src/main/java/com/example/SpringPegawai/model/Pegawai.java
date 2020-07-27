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
    @GeneratedValue (strategy = GenerationType.AUTO)
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
}
