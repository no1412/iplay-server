package com.lilei.iplay.service;

import java.util.List;

import com.lilei.iplay.exception.ParameterException;
import com.lilei.iplay.exception.ServiceException;
import com.lilei.iplay.model.EntertainmentDescribeVo;

public interface EntertainmentService {

    public List<EntertainmentDescribeVo> findEntertainmentDescribes() throws ParameterException, ServiceException;
}
