package com.hemlata.app.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hemlata.app.Model.Phrase;


@Repository
public interface PhraseRepo extends CrudRepository<Phrase, Long>{

		
}