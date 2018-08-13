package com.hand.api.controller;

import com.github.pagehelper.PageInfo;
import com.hand.api.service.FilmService;
import com.hand.domain.entity.Film;
import com.hand.domain.entity.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/film")
@RestController
public class FilmController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private FilmService filmService;


    @GetMapping(value = "/")
    public PageInfo<Film> list( Page page) {
        PageInfo<Film> list = filmService.list(page);
        logger.info("start page");
        for (Film f : list.getList()
                ) {
            logger.info(f.toString());
        }


        return filmService.list(page);
    }
}
