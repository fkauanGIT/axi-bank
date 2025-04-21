package com.project.axibank.controller;

import com.project.axibank.model.Notice;
import com.project.axibank.repository.NoticeRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequiredArgsConstructor
@Tag(name = "Avisos", description = "Avisos e comunicados do banco")
public class NoticesController {

    private final NoticeRepository noticeRepository;

    @Operation(
            summary = "Listar avisos ativos",
            description = "Retorna todos os avisos e comunicados ativos para os clientes."
    )
    @GetMapping("/notices")
    public ResponseEntity<List<Notice>> getNotices() {
        List<Notice> notices = noticeRepository.findAllActiveNotices();
        if (notices != null) {
            return ResponseEntity.ok()
                    .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                    .body(notices);
        } else {
            return null;
        }
    }

}

