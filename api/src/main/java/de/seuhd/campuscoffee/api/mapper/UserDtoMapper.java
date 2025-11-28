package de.seuhd.campuscoffee.api.mapper;
import de.seuhd.campuscoffee.domain.model.User;
import  de.seuhd.campuscoffee.api.dtos.UserDto;


public interface UserDtoMapper {
    //TODO: Implement user DTO mapper
    UserDto fromDomain(User user);
    User toDomain(UserDto dto);
}