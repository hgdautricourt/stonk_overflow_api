package net.dautricourt.tp_techno_web.mappers;

import net.dautricourt.tp_techno_web.dto.AuthorDTO;
import net.dautricourt.tp_techno_web.entities.Author;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAuthorFromDto(AuthorDTO dto, @MappingTarget Author entity);
}
