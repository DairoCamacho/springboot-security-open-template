package com.spacecodee.springbootsecurityopentemplate.mappers.details;

import com.spacecodee.springbootsecurityopentemplate.data.dto.user.details.UserDetailsDTO;
import com.spacecodee.springbootsecurityopentemplate.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {
        IRoleDetailsMapper.class})
public interface IUserDetailsMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "name", source = "fullname")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "userDetailsRoleDTO", source = "roleEntity")
    UserDetailsDTO toUserDetailsDTO(UserEntity userEntity);
}