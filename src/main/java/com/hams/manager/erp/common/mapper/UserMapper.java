package com.hams.manager.erp.common.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hams.manager.erp.common.entity.Role;
import com.hams.manager.erp.common.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;
import java.util.Set;

/**
 * 功能说明: 用户Mapper<br>
 * 系统版本: v1.0<br>
 * 开发人员: @author lh<br>
 * 开发时间: 2020/4/12<br>
 */
public interface UserMapper extends BaseMapper<User> {
    User selectUserByMap(Map<String, Object> map);

    void saveUserRoles(@Param("userId")Long id, @Param("roleIds") Set<Role> roles);

    void dropUserRolesByUserId(@Param("userId")Long userId);

    Map selectUserMenuCount();
}
