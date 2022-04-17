package net.dautricourt.tp_techno_web.mappers;

import net.dautricourt.tp_techno_web.dto.PostDTO;
import net.dautricourt.tp_techno_web.entities.Post;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePostFromDto(PostDTO dto, @MappingTarget Post entity);
}
