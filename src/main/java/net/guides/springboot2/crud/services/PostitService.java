package net.guides.springboot2.crud.services;

import net.guides.springboot2.crud.model.Postit;
import net.guides.springboot2.crud.modelRequests.PostitRequest;
import net.guides.springboot2.crud.repository.PostitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PostitService {

    @Autowired
    PostitRepository postitRepository;


    public Postit getById( Long id ) throws Exception {
        Optional<Postit> prodotto = postitRepository.findById( id );
        if( prodotto.isEmpty() )
            throw new Exception( "Lista not available" );
        return prodotto.get();
    }

    public List<Postit> getAll() {

        return postitRepository.findAll();
    }

    public void save( Postit postIt ) {

        postitRepository.save( postIt );
    }

    public Postit requestSave( PostitRequest request ) {

        Postit newPostIt = Postit.builder()
                .contenuto( request.getContenuto() )
                .scadenza( LocalDate.parse( request.getScadenza() ) )
                .stato( false )
                .build();

        return postitRepository.save( newPostIt );
    }

    public void update( Postit postIt ) {

        postitRepository.save( postIt );
    }

    public Postit requestUpdate( PostitRequest request, Long id ) {
        Optional<Postit> postItF = postitRepository.findById( id );

        if( postItF.isPresent()) {
            Postit postItNew = Postit.builder()
                    .id( postItF.get().getId() )
                    .contenuto( request.getContenuto() == null ? postItF.get().getContenuto() :
                            request.getContenuto() )
                    .scadenza( request.getScadenza() == null ? postItF.get().getScadenza() :
                            LocalDate.parse( request.getScadenza() ) )
                    .stato( request.getStato() )
                    .build();

            save( postItNew );
            return postItNew;
        }
        return null;
    }

    public void delete( Long id ) {
        Optional<Postit> postIt = postitRepository.findById( id );

        postIt.ifPresent( post -> postitRepository.delete( post ) );
    }

}
