package com.blackball.pssmall.member.dao;

import com.blackball.pssmall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author blackball
 * @email blackball@outlook.com
 * @date 2020-12-31 19:18:04
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
