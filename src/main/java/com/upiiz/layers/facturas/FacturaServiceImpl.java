package com.upiiz.layers.facturas;

import com.upiiz.layers.facturas.dto.FacturaDto;
import com.upiiz.layers.facturas.dto.NuevaFacturaDto;
import com.upiiz.layers.facturas.entity.FacturaEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// Capa de negocio
@Service
public class FacturaServiceImpl implements FacturaService {

    private FacturaRepository facturaRepository;

    public FacturaServiceImpl(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    @Override
    public FacturaDto save(NuevaFacturaDto nuevaFacturaDto) {
        FacturaEntity nuevaEntidad = new FacturaEntity(
                nuevaFacturaDto.getFecha(),
                nuevaFacturaDto.getVentaId(),
                nuevaFacturaDto.getTotal(),
                nuevaFacturaDto.getEstado()
        );
        FacturaEntity guardada = facturaRepository.save(nuevaEntidad);

        return new FacturaDto(
                guardada.getId(),
                guardada.getFecha(),
                guardada.getVentaId(),
                guardada.getTotal(),
                guardada.getEstado()
        );
    }

    @Override
    public List<FacturaDto> findAll() {
        return facturaRepository.findAll()
                .stream()
                .map(e -> new FacturaDto(e.getId(), e.getFecha(), e.getVentaId(), e.getTotal(), e.getEstado()))
                .collect(Collectors.toList());
    }

    @Override
    public FacturaDto update(Long id, NuevaFacturaDto updateFacturaDto) {
        FacturaEntity entidad = facturaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Factura no encontrada con id: " + id));

        entidad.setFecha(updateFacturaDto.getFecha());
        entidad.setVentaId(updateFacturaDto.getVentaId());
        entidad.setTotal(updateFacturaDto.getTotal());
        entidad.setEstado(updateFacturaDto.getEstado());

        FacturaEntity actualizada = facturaRepository.save(entidad);
        return new FacturaDto(
                actualizada.getId(),
                actualizada.getFecha(),
                actualizada.getVentaId(),
                actualizada.getTotal(),
                actualizada.getEstado()
        );
    }

    @Override
    public void delete(Long id) {
        facturaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Factura no encontrada con id: " + id));
        facturaRepository.deleteById(id);
    }
}
