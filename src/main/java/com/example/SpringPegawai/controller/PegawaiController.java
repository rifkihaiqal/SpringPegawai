package com.example.SpringPegawai.controller;

import com.example.SpringPegawai.model.Pegawai;
import com.example.SpringPegawai.repository.PegawaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping ("/pegawai")
public class PegawaiController {

    @Autowired
    PegawaiRepository pegawaiRepository;

    @GetMapping("/")
    public List<Pegawai> getAll(){
        return pegawaiRepository.findAll();
    }

    @PostMapping ("/")
    public Pegawai tambahPegawai (@Valid @RequestBody Pegawai pegawai){
        return pegawaiRepository.save(pegawai);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pegawai> updatePegawai(@PathVariable(value = "id")Long id,
                                                 @Valid @RequestBody Pegawai detailpegawai){
        Pegawai pegawai = pegawaiRepository.getOne(id);

        if (pegawai == null)
            return ResponseEntity.notFound().build();
        pegawai.setNamaDepanPegawai(detailpegawai.getNamaDepanPegawai());
        pegawai.setNamaBelakangPegawai(detailpegawai.getNamaBelakangPegawai());
        pegawai.setJabatanPegawai(detailpegawai.getJabatanPegawai());
        pegawai.setMasukPada(detailpegawai.getMasukPada());
        Pegawai updatedPegawai = pegawaiRepository.save(pegawai);
        return ResponseEntity.ok(updatedPegawai);
    }

    @DeleteMapping("/{id}")
    public String deleteBuku(@PathVariable (value = "id") Long id) {
        Pegawai pegawai = pegawaiRepository.getOne(id);
        String result = "";
        if (pegawai == null) {
            result = "id " + id + " gak ketemu";
            return result;
        }
        result = "id " + id + " dihapus";
        pegawaiRepository.deleteById(id);
        return result;
    }
        @GetMapping("/{id}")
        public ResponseEntity<Pegawai> getPegawaiById (@PathVariable(value="id") Long id){
            Pegawai pegawai = pegawaiRepository.getOne(id);
            if(pegawai == null)
                return ResponseEntity.notFound().build();
            return ResponseEntity.ok().body(pegawai);
        }

        @GetMapping("/sortpegawai")
        public List<Pegawai> sortpegawai(@RequestParam(value="title")String namaDepanPegawai){
            return pegawaiRepository.findByNamaDepanPegawai(namaDepanPegawai);
        }
}
