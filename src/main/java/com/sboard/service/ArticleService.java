package com.sboard.service;

import com.sboard.dto.TermsDTO;
import com.sboard.dto.ArticleDTO;
import com.sboard.entity.Article;
import com.sboard.entity.Terms;
import com.sboard.repository.ArticleRepository;
import com.sboard.repository.TermsRepository;
import com.sboard.repository.ArticleRepository;
import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Log4j2
@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;

    public int insertArticle(ArticleDTO articleDTO){

        // ModelMapper를 이용해서 DTO를 Entity로 변환
        Article article = modelMapper.map(articleDTO, Article.class);

        log.info(article);

        // 저장 (entity로 저장됨)
        Article savedArticle = articleRepository.save(article);

        // 저장된 글번호 리턴
        return savedArticle.getNo();
    }

    public ArticleDTO selectArticle(int no){
        return null;
    }

    public List<ArticleDTO> selectArticleAll(){
        return null;
    }

    public void updateArticle(ArticleDTO ArticleDTO){

    }

    public void deleteArticle(int no){

    }


}
