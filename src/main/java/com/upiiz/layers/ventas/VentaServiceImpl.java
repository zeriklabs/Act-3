package com.upiiz.layers.ventas;

import com.upiiz.layers.ventas.dto.NuevaVentaDto;
import com.upiiz.layers.ventas.dto.VentaDto;
import com.upiiz.layers.ventas.entity.VentaEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// Capa de negocio
@Service
public class VentaServiceImpl implements VentaService {

    private VentaRepository ventaRepository;

    public VentaServiceImpl(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    public VentaDto save(NuevaVentaDto nuevaVentaDto) {
        VentaEntity nuevaEntidad = new VentaEntity(
                nuevaVentaDto.getFecha(),
                nuevaVentaDto.getClienteId(),
                nuevaVentaDto.getTotal()
        );
        VentaEntity guardada = ventaRepository.save(nuevaEntidad);

        return new VentaDto(guardada.getId(), guardada.getFecha(), guardada.getClienteId(), guardada.getTotal());
    }

    @Override
    public List<VentaDto> findAll() {
        return ventaRepository.findAll()
                .stream()
                .map(e -> new VentaDto(e.getId(), e.getFecha(), e.getClienteId(), e.getTotal()))
                .collect(Collectors.toList());
    }

    @Override
    public VentaDto update(Long id, NuevaVentaDto updateVentaDto) {
        VentaEntity entidad = ventaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Venta no encontrada con id: " + id));

        entidad.setFecha(updateVentaDto.getFecha());
        entidad.setClienteId(updateVentaDto.getClienteId());
        entidad.setTotal(updateVentaDto.getTotal());

        VentaEntity actualizada = ventaRepository.save(entidad);
        return new VentaDto(actualizada.getId(), actualizada.getFecha(), actualizada.getClienteId(), actualizada.getTotal());
    }

    @Override
    public void delete(Long id) {
        ventaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Venta no encontrada con id: " + id));
        ventaRepository.deleteById(id);
    }
}
