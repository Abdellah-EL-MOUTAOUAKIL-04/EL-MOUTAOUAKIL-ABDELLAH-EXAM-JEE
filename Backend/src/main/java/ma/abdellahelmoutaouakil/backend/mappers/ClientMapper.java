package ma.abdellahelmoutaouakil.backend.mappers;

import ma.abdellahelmoutaouakil.backend.entities.Client;
import ma.abdellahelmoutaouakil.backend.dtos.ClientDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDTO toDTO(Client client);
    Client toEntity(ClientDTO dto);
} 