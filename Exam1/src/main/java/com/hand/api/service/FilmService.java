package com.hand.api.service;

import com.github.pagehelper.PageInfo;
import com.hand.domain.entity.Film;
import com.hand.domain.entity.Page;

public interface FilmService {




    PageInfo<Film> list(Page page);
}
