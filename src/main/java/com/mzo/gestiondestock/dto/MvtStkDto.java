package com.mzo.gestiondestock.dto;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mzo.gestiondestock.entities.Article;
import com.mzo.gestiondestock.entities.MvtStk;
import com.mzo.gestiondestock.entities.TypeMvtStk;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MvtStkDto {

	private Integer id;
    private Instant dateMvt;
	
	private BigDecimal quantite;
		
 	private ArticleDto article;
	
	private TypeMvtStk typeMvt;
	
	public static MvtStkDto fromEntity(MvtStk mvtStk ) {
		
		if(mvtStk == null) {
			return null;
		}
		
		return MvtStkDto.builder().id(mvtStk.getId())
				.dateMvt(mvtStk.getDateMvt())
				.quantite(mvtStk.getQuantite())
				.typeMvt(mvtStk.getTypeMvt())
				.article(ArticleDto.fromEntity(mvtStk.getArticle()))
				.build();
	}
	
	public static MvtStk toEntity(MvtStkDto mvtStkDto) {
		
		if(mvtStkDto == null) {
			return null;
		}
		
		MvtStk mvtStk = new MvtStk();
		
		mvtStk.setId(mvtStk.getId());
		mvtStk.setDateMvt(mvtStk.getDateMvt());
		mvtStk.setQuantite(mvtStk.getQuantite());
		mvtStk.setTypeMvt(mvtStk.getTypeMvt());
		mvtStk.setArticle(ArticleDto.toEntity(mvtStkDto.getArticle()));
		
		return mvtStk;
		
	}
}
