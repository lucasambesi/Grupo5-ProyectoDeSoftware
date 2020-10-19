package com.unla.elDeporteOnline.services;

import java.util.List;

import com.unla.elDeporteOnline.entities.Moneda;
import com.unla.elDeporteOnline.entities.Sku;
import com.unla.elDeporteOnline.models.MonedaModel;
import com.unla.elDeporteOnline.models.SkuModel;

public interface ISkuService {

	public List<Sku> getAll();

	public List<SkuModel> getAlls();

	public SkuModel findByIdSku (long idSku);

	public SkuModel insert(SkuModel skuModel);

	public SkuModel update(SkuModel skuModel);

	public boolean remove(long idSku);
}
