package com.example.francisco.villegas.os.cipher.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.TextOut;

@Mapper
public interface CipherMapper {

    @Mapping(target = "text", source = "source")
    TextOut generateTextOut(String source);

}
