package com.sboard.controller;

import com.sboard.dto.CommentDTO;
import com.sboard.service.CommentService;
import com.sboard.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Log4j2
@RequiredArgsConstructor
@Controller
public class CommentController {

    private final CommentService commentService;
    private final UserService userService;

    @PostMapping("/comment/write")
    public ResponseEntity<CommentDTO> write(@RequestBody CommentDTO commentDTO, HttpServletRequest request) {

        String regip = request.getRemoteAddr();
        commentDTO.setRegip(regip);

        // data.user 값 셋팅
        commentDTO.setUser(userService.selectUser(commentDTO.getWriter()));
        log.info(commentDTO);

        CommentDTO dto = commentService.insertComment(commentDTO);

        return ResponseEntity
                .ok()
                .body(dto);
    }

}
