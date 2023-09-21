package com.bookStore.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookStore.model.Author;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthorRepository extends JpaRepository<Author, Long>{
	
	@Query(value="select first_name, last_name from author",nativeQuery=true)
	List<String> findFisrtNameLastName();
	
	
	@Query(value="select author_id from author where first_name=:fname and last_name=:lname",nativeQuery = true)
	Long findByFirstNameandLastName(@Param("fname")String fname,@Param("lname")String lname);
}
