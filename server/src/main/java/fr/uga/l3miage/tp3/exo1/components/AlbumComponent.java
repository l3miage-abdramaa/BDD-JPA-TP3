package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.AlbumEntity;
import fr.uga.l3miage.tp3.exo1.repositories.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class AlbumComponent {

    private final AlbumRepository albumRepository;

    // opérations CRUD

    // READ
    private AlbumEntity getAlbum(String title) {
        return albumRepository
                .findById(title)
                .orElseThrow();
    }

    // CREATE

    public AlbumEntity createAlbum(AlbumEntity albumEntity ) {
        return albumRepository.save(albumEntity);
    }

    // UPDATE

    public AlbumEntity updateAlbumDateRelease(String title,Date newReleaseDate) {
        AlbumEntity albumEntity = albumRepository
                .findById(title)
                .orElseThrow();
        albumEntity.setReleaseDate(newReleaseDate);
        return albumRepository.save(albumEntity);
    }

    // DELETE ALBUM

    public void deleteAlbum(String title) {
        albumRepository.deleteById(title);
    }



    //

    public Set<AlbumEntity> getAlbumByTitle(String title) {
        return albumRepository.findAllByTitle(title);
    }

}
