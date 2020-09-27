package com.unla.elDeporteOnline.converters;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.elDeporteOnline.entities.Producto;
import com.unla.elDeporteOnline.models.ProductoModel;

@Component("productoConverter")
public class ProductoConverter {

    @Autowired
    @Qualifier("categoriaConverter")
    private CategoriaConverter categoriaConverter;

    @Autowired
    @Qualifier("monedaConverter")
    private MonedaConverter monedaConverter;

    public ProductoModel entityToModel(Producto producto) {
        return new ProductoModel(producto.getIdProducto(), producto.getNombre() ,producto.getDescripcionCorta(), 
                    producto.getDescripcionLarga(), categoriaConverter.entityToModel(producto.getCategoria()), producto.isActivo(), 
                    producto.getPrecio(), monedaConverter.entityToModel(producto.getMoneda()));
        }

        public Producto modelToEntity(ProductoModel productoModel) {
            return new Producto(productoModel.getIdProducto(), productoModel.getNombre(), productoModel.getDescripcionCorta(),
                    productoModel.getDescripcionLarga(), categoriaConverter.modelToEntity(productoModel.getCategoria()), 
                    productoModel.isActivo(), productoModel.getPrecio(), monedaConverter.modelToEntity(productoModel.getMoneda()));
        }

}
