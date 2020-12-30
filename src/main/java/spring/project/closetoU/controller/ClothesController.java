package spring.project.closetoU.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.project.closetoU.service.ClothesService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clothes")
public class ClothesController {

    private final ClothesService clothesService;
}
