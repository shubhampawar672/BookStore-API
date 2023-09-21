package com.bookStore.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookStore.model.Author;
import com.bookStore.model.Book;
import com.bookStore.model.Book_Author;

import jakarta.transaction.Transactional;

public interface BookAuthorRepository extends JpaRepository<Book_Author, Long> {
	Optional<Book_Author> findByBookAndAuthor(Book b,Author a);
	
	
	//Add below annotation ->did't worked before
	@Transactional
    @Modifying
    @Query(value="DELETE FROM Book_Author ba WHERE ba.book_id = :id",nativeQuery=true)
	void deleteByBookId(@Param("id")Long id);
	@Transactional
    @Modifying
	@Query(value="delete from book_author ba where author_id= :id",nativeQuery=true)
	void deleteByAuthorId(@Param("id")Long id);
	
	

    @Query(value="select ba.book_id from book_author ba where ba.author_id= :aid ",nativeQuery=true)
	List<Long>findBookByAuthorId(@Param("aid")Long aid);
}


