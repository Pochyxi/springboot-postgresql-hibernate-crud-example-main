package net.guides.springboot2.crud.controller;

import net.guides.springboot2.crud.model.Postit;
import net.guides.springboot2.crud.modelRequests.PostitRequest;
import net.guides.springboot2.crud.services.PostitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/postit")
@CrossOrigin(origins = "*")
public class PostitController {
    @Autowired
    PostitService postitService;

    @GetMapping("")
    public ResponseEntity<List<Postit>> getAll() {
        return new ResponseEntity<>( postitService.getAll(), HttpStatus.OK );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postit> get( @PathVariable("id") Long id ) throws Exception {

        return new ResponseEntity<>(
                postitService.getById( id ),
                HttpStatus.OK
        );
    }

    @PostMapping("/new")
    public ResponseEntity<Postit> create( @RequestBody PostitRequest postItRequest ) throws Exception {
        return new ResponseEntity<>( postitService.requestSave( postItRequest ), HttpStatus.OK );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Postit> update( @RequestBody PostitRequest postItRequest, @PathVariable Long id ) throws Exception {

        return new ResponseEntity<>( postitService.requestUpdate( postItRequest, id ), HttpStatus.OK );
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById( @PathVariable Long id ) {

        postitService.delete( id );
    }

}
