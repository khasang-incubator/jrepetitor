package io.khasang.jrepetitor.service.impl;

import io.khasang.jrepetitor.dao.CatDao;
import io.khasang.jrepetitor.entity.Cat;
import io.khasang.jrepetitor.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("catService")
public class CatServiceImpl implements CatService {
    @Autowired
    private CatDao catDao;

    @Override
    public Cat addCat(Cat cat) {
        if (catDao.getCatsByName(cat.getName()).get(0) == null) {
            return catDao.create(cat);
        } else {
            throw new IllegalArgumentException("Name should be uniq - duplicate name: " + cat.getName());
        }
    }

    @Override
    public List<Cat> getAllCats() {
        return catDao.getList();
    }

    @Override
    public Cat getCatById(long id) {
        return catDao.getById(id);
    }

    @Override
    public Cat deleteCat(long id) {
        return catDao.delete(getCatById(id));
    }

    @Override
    public Cat updateCat(Cat cat) {
        return catDao.update(cat);
    }

    @Override
    public List<Cat> getCatByName(String name) {
        return catDao.getCatsByName(name);
    }
}
