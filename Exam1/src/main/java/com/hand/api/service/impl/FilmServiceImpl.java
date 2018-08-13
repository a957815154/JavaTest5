package com.hand.api.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hand.api.service.FilmService;
import com.hand.domain.entity.Film;
import com.hand.domain.entity.Page;
import com.hand.infra.mapper.FilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmMapper filmMapper;

    @Override
    public PageInfo<Film> list(Page page) {
        PageHelper.startPage(page.getPage(), page.getPageSize(),"film_id "+page.getSort());
        List<Film> films = filmMapper.selectAll();
        PageInfo<Film> pageInfo = new PageInfo<>(films);
        return pageInfo;
    }
}