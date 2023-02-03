package net.guides.springboot2.crud.repository;

import net.guides.springboot2.crud.model.Postit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostitRepository extends JpaRepository<Postit, Long> {

}
