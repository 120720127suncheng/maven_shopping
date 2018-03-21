package com.iotek.service;

import com.iotek.po.Department;
import com.iotek.po.Position;

import java.util.List;

/**
 * com.iotek.service
 *
 * @author <Author Administrator>
 * @date 2018/3/21 15:08
 */
public interface PositionService {
    List<Position> findPositionByDepartment(Department department);
    boolean addPosition(Position position);
    List<Position> findPositionByName(Position position);
    boolean updatePosition(Position position);
    boolean deletePosition(Position position);
    Position findPositionByNameAndDId(Position position);
}