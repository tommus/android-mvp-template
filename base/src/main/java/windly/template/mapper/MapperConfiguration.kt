package windly.template.mapper

import org.mapstruct.MapperConfig
import org.mapstruct.NullValueCheckStrategy
import org.mapstruct.NullValueMappingStrategy

@MapperConfig(
  nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
  nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
)
interface MapperConfiguration
