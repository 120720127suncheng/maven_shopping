package com.iotek.dao;

import com.iotek.po.Department;
import com.iotek.po.Position;

import java.util.List;

/**
 * com.iotek.dao
 *
 * @author <Author Administrator>
 * @date 2018/3/20 19:36
 */
public interface PositionMapper {
    List<Position> findPositionByDepartment(Department department);
    boolean addPosition(Position position);
    List<Position> findPositionByName(Position position);
    boolean updatePosition(Position position);
   Position findPositionByNameAndDId(Position position);
}