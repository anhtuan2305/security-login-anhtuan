package vn.tuan.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vn.tuan.dto.UserDTO;
import vn.tuan.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "roleName", source = "role.name")
    UserDTO toDTO(User user);
}