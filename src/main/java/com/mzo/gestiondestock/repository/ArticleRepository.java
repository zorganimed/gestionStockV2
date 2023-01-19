package com.mzo.gestiondestock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mzo.gestiondestock.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
	
	/*@Query(" select a from Article a  where a.codeArticle = :code and a.designation = :designation ")
	List<Article> findByCustomQuery(@Param("code") String c, @Param("designation")String d);
	
	@Query(value = " select * from article where code_article = :code ",nativeQuery = true)
	List<Article> findByCustomNativeQuery(@Param("code") String code);
	
	List<Article> findByCodeArticleAndDesignationIgnoreCase(String codeArticle, String designation);*/

}
