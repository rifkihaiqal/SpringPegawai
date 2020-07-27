package com.example.SpringPegawai.repository;

import com.example.SpringPegawai.model.Pegawai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PegawaiRepository extends JpaRepository<Pegawai, Long> {
    List<Pegawai> findByNamaDepanPegawai (String namaDepanPegawai);

}