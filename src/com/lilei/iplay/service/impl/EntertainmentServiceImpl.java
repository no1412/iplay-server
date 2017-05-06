package com.lilei.iplay.service.impl;

import java.util.List;

import com.lilei.iplay.dao.EntertainmentDao;
import com.lilei.iplay.exception.ParameterException;
import com.lilei.iplay.exception.ServiceException;
import com.lilei.iplay.model.EntertainmentDescribeVo;
import com.lilei.iplay.service.EntertainmentService;

public class EntertainmentServiceImpl implements EntertainmentService {

    private EntertainmentDao entertainmentDao;
    
    @Override
    public List<EntertainmentDescribeVo> findEntertainmentDescribes()
            throws ParameterException, ServiceException {
        return entertainmentDao.findEntertainmentDescribes();
    }

    public void setEntertainmentDao(EntertainmentDao entertainmentDao) {
        this.entertainmentDao = entertainmentDao;
    }
}
