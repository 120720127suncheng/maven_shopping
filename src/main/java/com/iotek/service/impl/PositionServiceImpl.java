package com.iotek.service.impl;

import com.iotek.dao.PositionMapper;
import com.iotek.po.Department;
import com.iotek.po.Position;
import com.iotek.service.PositionService;
import com.iotek.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * com.iotek.service.impl
 *
 * @author <Author Administrator>
 * @date 2018/3/21 15:10
 */
@Transactional
@Component(value = "positionService")
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionMapper positionMapper;
    @Override
    public List<Position> findPositionByDepartment(Department department) {
        return positionMapper.findPositionByDepartment(department);
    }
    @Override
    public boolean addPosition(Position position) {
        return positionMapper.addPosition(position);
    }

    @Override
    public List<Position> findPositionByName(Position position) {
        return positionMapper.findPositionByName(position);
    }

    @Override
    public boolean updatePosition(Position position) {
        return positionMapper.updatePosition(position);
    }

    @Override
    public boolean deletePosition(Position position) {
        if(position==null){
            return false;
        }else {
            position.setPositionIsDeleted(1);
            position.setPositionModifiedTime(TimeUtil.getTimestamp());
            if(positionMapper.updatePosition(position)){
                return true;
            }
            return false;
        }
    }

    @Override
    public Position findPositionByNameAndDId(Position position) {
        return positionMapper.findPositionByNameAndDId(position);
    }
}