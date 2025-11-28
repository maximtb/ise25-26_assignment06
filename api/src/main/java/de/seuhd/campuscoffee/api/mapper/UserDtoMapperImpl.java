package de.seuhd.campuscoffee.api.mapper;
import de.seuhd.campuscoffee.api.dtos.UserDto;
import  de.seuhd.campuscoffee.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapperImpl implements UserDtoMapper{

    @Override
    public UserDto fromDomain(User user){
        if(user == null){
            return  null;
        }
        return new UserDto(
                user.id(),
                user.createdAt(),
                user.updatedAt(),
                user.loginName(),
                user.emailAddress(),
                user.firstName(),
                user.lastName()
        );

    }
    @Override
    public User toDomain(UserDto dto){
        if(dto==null){
            return null;
        }
        return User.builder()
                .id(dto.id())
                .createdAt(dto.createdAt())
                .updatedAt(dto.updatedAt())
                .loginName(dto.loginName())
                .emailAddress(dto.emailAddress())
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .build();
    }
}
